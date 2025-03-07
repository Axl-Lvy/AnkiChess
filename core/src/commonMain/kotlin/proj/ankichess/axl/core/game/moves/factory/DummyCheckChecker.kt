package proj.ankichess.axl.core.game.moves.factory

import proj.ankichess.axl.core.game.Game
import proj.ankichess.axl.core.game.board.Board
import proj.ankichess.axl.core.game.board.ITile
import proj.ankichess.axl.core.game.board.Tile
import proj.ankichess.axl.core.game.moves.IMove
import proj.ankichess.axl.core.game.moves.description.ClassicMoveDescription
import proj.ankichess.axl.core.game.pieces.IPiece

class DummyCheckChecker(board: Board) : AMoveFactory(board) {

  var changes = mapOf<Pair<Int, Int>, Pair<Int, Int>?>()

  fun isPossible(move: IMove): Boolean {
    changes = move.generateChanges()
    val player = board.getTile(move.origin()).getSafePiece()?.player ?: return false
    val kingPosition =
      board.piecePositionsCache[
          if (player == Game.Player.WHITE) IPiece.KING.uppercase() else IPiece.KING]!!
        .first()
    IPiece.PIECES.map { if (player == Game.Player.WHITE) it else it.uppercase() }
      .forEach {
        board.piecePositionsCache[it]!!.forEach { pos ->
          run {
            val moveDescription = ClassicMoveDescription(pos, kingPosition)
            if (getTileAtCoords(pos).getSafePiece()?.isMovePossible(moveDescription) == true) {
              return false
            }
          }
        }
      }
    return true
  }

  override fun getTileAtCoords(coords: Pair<Int, Int>): ITile {
    if (!changes.containsKey(coords)) {
      return board.getTile(coords)
    }
    val tile = Tile(coords.first, coords.second)
    val refCoords = changes[coords]
    if (refCoords != null) {
      tile.piece = board.getTile(refCoords).getSafePiece()
    }
    return tile
  }
}
