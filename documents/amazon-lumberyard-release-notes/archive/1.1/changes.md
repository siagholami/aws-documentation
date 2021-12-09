# Improvements and Changes<a name="lumberyard-v1.1-changes"></a>

Lumberyard release 1.1 includes a variety of updates to systems and functionality:

**Audio**
+ Changed the audio entities to use **Ignore** as the default value for the `OcclusionObstructionCalculationType`.
+ Upgraded the Wwise LTX installer and SDK to v2015.2\_LTX build 5495.

**Cinematics**
+ Removed the following deprecated and non-functioning UI, nodes, and tracks from the **Track View** editor: 
  + Sequence properties / cut scene 16:9 toggle
  + Screen drops setup node
  + GameCameraInfluence track
  + HDR setup node
  + Facial sequence track
  + Expression track
+ Renamed the following options in the **Track View** editor node menu: 
  + **Add Console Variable** renamed to **Add Console Variable Node**
  + **Add Script Variable** renamed to **Add Script Variable Node**
  + **Add Material** renamed to **Add Material Node**
  + **Add Event** renamed to **Add Event Node**

**Cloud Canvas Resource Management**
+ Verifies Cloud Canvas files as writeable and not read only before attempting changes to the AWS stack, Cloud Canvas files that will be written to are now verified as writeable and not read-only.
+ Added the ability to list deployments and features from the lmbr\_aws command line tool to improve discoverability.
+ Added validation of AWS CloudFormation stack names to help prevent instantiation issues within AWS. Names must be less than 128 characters, begin with a character, and use only alphanumerical characters and hyphens.

****Flow Graph****
+ Updated Lumberyard to route Cloud Canvas nodes through this system and moved the UINames data to `Libs\FlowNodes\FlowInitData\CloudCanvasFlowInitInfo.json`. As a result, you are no longer required to instantiate nodes on startup in order to obtain their user-facing names.

**GameLift**
+ Added a batch script (located in the `Gems\GameLift\Code\Scripts\BuildGameLiftServer.bat` directory) to help automate the steps for packaging your server build.
+ Added an example to the Multiplayer Project showing how to use the added batch script (located in the `Code\MultiplayerProject\Scripts\BuildGameLiftServer.bat` directory).

**Maya Lumberyard Tools**
+ Updated the icon for the Lumberyard Tools in Maya.
+ Improved workflows in the **Proxy Editor**.

**Networking**
+ Added GridMateBus, which is used by GridMate to notify services of system events.
+ Created a base GridMate service interface to be used by all GridMate services.
+ Added a `GetChunkByIndex` function to the `Replica` interface.
+ Moved `GridMateAllocatorMP` out of the GridMate implementation to generalize the interface. You can initialize or destroy it.
+ Exposed the carrier disconnect threshold values through `CarrierDesc` to allow custom values for packet loss and RTT thresholds.
+ Exposed the ability to turn disconnection detection on or off during a session.
+ Optimized replica header overhead by approximately 50%.
+ Migrated Lumberyard to support Amazon GameLift 2.1.0.
+ Reenabled debug tracing for profile builds.
+ Added GridMate version checking when establishing a connection to another computer.

**Twitch ChatPlay**
+ Twitch ChatPlay can now be enabled or disabled using the console variable `chatPlay_Enabled`. If disabled (set to 0), the singleton instances associated with CryAction will not be created and runtime operations will not be possible. You can safely disable Twitch ChatPlay, even if the ChatPlay flow nodes are in active use. In this case, the flow nodes will generate error signals instead of doing Twitch ChatPlay work. Before CryAction is initialized, you must set or unset the **Enable** flag. Dynamic changes to the enabled state are not supported.
+ Twitch ChatPlay keywords are now treated as regular expressions. This change applies to inputs in C\+\+ and the Flow Graph editor. 
  + Matches are not case sensitive or locale dependent.
  + Input strings are not trimmed prior to matching, so whitespaces affect matches.
  + The following keyword pattern can now be used to obtain an exclusive match on its own line: "`^foobar$`" (results in an exclusive match of "foobar").
  + We recommend using simple expressions and only features supported by the `std::regex::basic` option (see C\+\+ STL documentation).
+ The Twitch IRC server list for regular chat servers is no longer hardcoded. To ensure the correct IRC server is selected for Twitch channels, the selection logic is now based on the results of a Twitch API query. The endpoint for the Twitch API call is configured using the console variable `chatPlay_ServerListEndpoint`, with a default value of api.twitch.tv that can be changed for testing purposes if needed.
+ Modified `IChatChannel::KeywordCallback` (in the `ChatPlay.h` file) to include a string parameter for the username that typed the keyword. This change is not backwards compatible with the previous interface, so you must update your code if you access the interface from C\+\+. No change is required if you access the interface from the Flow Graph editor.

****UI Editor****
+ Improved the font rendering system to better handle different font sizes.
+ Added an **Anchor** widget for quickly setting anchors to the common values.
+ Improved the **Properties** pane for a better editing experience.
+ Enabled tooltips in the **Properties** pane.
+ Updated distance lines so that they are now drawn to the parent element's rectangle when you highlight or move anchors.
+ Updated the behavior of anchor values in the **Properties** pane so that changing one anchor allows you to push the opposite anchor.
+ Updated the UI canvas to show your changes in the game when running the game in-editor without requiring you to save the UI canvas first.
+ Renamed **Position and Size** to **Offsets** in the **Properties** pane for the **Transform2D** component.
+ Updated the **UI Editor** to display new prefabs in the **Prefab** menu without requiring a restart of the editor.
+ Added the flow node `UI:Canvas:SetKeepLoaded` so that you can keep a UI canvas loaded. By default UI canvases do not remain loaded between levels.
+ Updated UI component classes so that they now derive from `AZ::Entity`. Previously they derived from `IUiComponent`.

**Waf Build System**
+ Updated Waf to identify game projects by reading project information in the `project.json` file (located in `\engine root\game project\`).

**Miscellaneous**
+ Improved the save backup process upon crash.
+ Added Visual Studio 2015 solution support for PC and Android.