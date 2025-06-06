package proj.memorchess.axl.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import kotlinx.coroutines.launch
import proj.memorchess.axl.core.data.DatabaseHolder.getDatabase
import proj.memorchess.axl.core.graph.nodes.NodeManager
import proj.memorchess.axl.ui.pages.navigation.Destination

@Composable
fun Settings() {
  val coroutineScope = rememberCoroutineScope()
  Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.testTag(Destination.SETTINGS.name),
  ) {
    Text(text = "Settings")
    Button(
      onClick = {
        coroutineScope.launch {
          getDatabase().deleteAllPositions()
          NodeManager.resetCacheFromDataBase()
        }
      }
    ) {
      Text("Erase All Data")
    }
  }
}
