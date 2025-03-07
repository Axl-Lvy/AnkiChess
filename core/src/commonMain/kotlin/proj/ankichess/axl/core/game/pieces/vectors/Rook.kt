package proj.ankichess.axl.core.game.pieces.vectors

import proj.ankichess.axl.core.game.Game
import proj.ankichess.axl.core.game.pieces.IPiece

/** Rook. */
class Rook(player: Game.Player) : AInfiniteMovers(player) {
  override fun getVectors(): Set<Pair<Int, Int>> {
    return STRAIGHT_VECTORS
  }

  override fun baseChar(): String {
    return IPiece.ROOK
  }
}
