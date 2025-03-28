package proj.ankichess.axl.core.graph.nodes

import proj.ankichess.axl.core.engine.Game
import proj.ankichess.axl.core.engine.parser.FenParser

/**
 * Node that has next.
 *
 * @constructor Create empty A parent node
 */
abstract class AParentNode(private val position: String) : INode {
  private val children = mutableMapOf<String, INode>()

  override fun getChildren(): MutableMap<String, INode> {
    return children
  }

  override fun save() {
    TODO("Not yet implemented")
  }

  override fun getGame(): Game {
    return FenParser.read(position)
  }
}
