# Improvements and Changes<a name="lumberyard-v1.2-changes"></a>

This release of Lumberyard includes numerous systems and functionality updates:

**Asset Processor**
+ The Asset Processor now stores log files in a logs subfolder (located in the same location as the Asset Processor executable file). These logs include detailed information that you can use to diagnose issues in the Asset Processor.
+ The Asset Processor now recognizes when copies of the tool are stored in different locations for different projects on the same machine. If you attempt to run Lumberyard Editor while the Asset Processor from a different branch or version of Lumberyard is running, you will receive notification and the option to run the correct Asset Processor or exit the old version. This helps to prevent connection to and communication with the incorrect Asset Processor.
+ To allow you to get started while assets compile in the background, the Asset Processor now supports priorities assigned to asset types to compile in the configuration file. By default meshes and animations are preferred over textures.
+ A new algorithm is now used to order the Asset Processor's build queue and dynamically reorder the queue based on the connected operating systems and the assets requested by these operating systems. Unconnected operating systems have a lower priority than connected ones.

**Audio**
+ The default audio error logging verbosity is now set to **Errors and Warnings** to increase visibility.
+ A new flow graph node controls audio components.
+ A new method stops all sounds to the audio proxy.

**Cloud Canvas Resource Management**
+ To help reduce confusion about their purpose, the Development deployment and Hello World feature were removed from the default project.
+ Deployment stacks are no longer created under the project stack. With this change you can create, update, and delete deployments without risking changes to other deployments.

**component entity system**
+ You can now push unrelated entities with instanced entities to a slice asset.
+ The **Entity Outliner** can now show multiple components of the same type.

**FBX Settings**
+ The **FBX Settings** now automatically converts FBX units to meters. This gives you the ability to use scenes from different content creation packages because the content is automatically scaled logically upon import.
+ The **FBX Settings** now reads Up-Axis orientation data. This gives you the ability to use scenes from different content creation packages because the content is automatically oriented logically upon import.

**GameLift**
+ The command that is used to start the Amazon GameLift server was changed from `start_lobby` to `gamelift_start_server`.
+ Idle timeout in all modes was added. Idle timeout is disabled by default. To enable idle timeout for Amazon GameLift, you can add `+sv_idle_seconds 600` to your server's command line in the Amazon GameLift dashboard.
+ The GridMateGameLift static library was removed and all Amazon GameLift code in the Multiplayer Project has been moved to the Amazon GameLift Gem.
+ The include paths for Amazon GameLift session header files were changed from `GridMateGameLift/Session/..` to `GameLift/Session/...`

**Lumberyard Installer**
+ The installer now automatically installs the Visual C\+\+ Redistributable Packages for Visual Studio 2013, if it is not already on your machine.
+ To help provide clarity, the installer now clearly states the build version that will be installed.
+ To help improve functionality, the installer now reports metrics when certain steps are completed.

**Mobile**
+ The error messages for configuring an Android project offer better diagnostic help.
+ Lumberyard includes support for the Android devices Samsung Galaxy Note 5 and Motorola Nexus 6.
+ A separate download package for iOS developers is available to help with line ending problems in JSON files.
+ Various updates for iOS include exposing global blending weight and fixing vis area bugs.
+ Use rsync to copy assets for improved the Xcode project generation for iOS.
+ You can now enable `r_VisAreaClipLightsPerPixel` in GMEM for iOS.

**Networking**
+ Lumberyard now inclues a gem for GridMate GameLift integration. This Gem contributes to Lumberyard's modular approach, so you can more easily customize the engine for your needs. You can optionally include this gem in your Lumberyard game project.
+ The **Connect** and **Host** flow graph nodes are no longer available for the sMultiplayer Gem.
+ You can now search for Amazon GameLift sessions by game instance ID. This means you can create a custom matchmaking service with your game hosted by Amazon GameLift.
+ You can now use the GridMate API tor reuse EC2 instances in Amazon GameLift, which removes the need to spin up a new instance for every game session.
+ Replica initialization can now take a debug name.
+ AzFramework now requires GridMate. On Windows, GridMate links in using a pragma in code.
+ Windows XP is no longer suported. The \_WIN32\_WINNT version is now set to 0x6000 (Windows Vista), and the unnecessary `inet_ntop()` implementation .
+ Modified UpdateFromChunk now makes calls per chunk and not per replica.

**Project Configurator**
+ Various updates include adding metrics reporting, ensuring the `ProjectConfigurator.log` file is saved to the engine root (`\lumberyard\dev`), and updating the project template to match the latest changes to the Empty Template.

**Twitch ChatPlay**
+ The `Twitch:JoinIn:CreateLink` flow graph node now includes an **Error** port, which is signaled if the link was not created successfully. The **GameName** port was removed; the game name is now copied from the `sys_game_name` console variable.
+ You can now use the `joinin_uriScheme` console variable to set the URI scheme for the JoinIn link. The default value is game.
+ You can now use the `chatPlay_GroupServerList` console variable to set the list of group chat servers and ports.

**UI Editor**
+ In the Samples Project, the UIDemo level was renamed to UIEditor\_Sample.
+ The UiDemo Gem was removed and the functionality added to the Samples Project.
+ A new UiInitializationBus helps simplify the process of writing custom UI components that require data initialization after loading a canvas in-game.
+ In the **File** menu, **New** has been renamed to **New Canvas**.
+ In the component properties, the **Selected** state has been renamed to **Hover**.
+ In the **Properties** pane, the **Components** button has been renamed to **Add Component** and is now located at the top of the pane.
+ You can now remove components by right-clicking the component.
+ New flow graph nodes include **Ui:Element:SetIsEnabled** and **UI:Interactable:SetIsHandlingEvents**.
+ New image types **Stretched to Fit** and **Stretched to Fill** are now part of the **Image** component. These image types maintain the aspect ratio of the texture when the element is a different aspect ratio.
+ You can now show the anchor preset in use by using the icon to the right of the anchor values in the **Anchor** properties.

**Miscellaneous**
+ Renamed the following parts of EBus for clarity: 
  + **EBusEventGroupContainerTypes** renamed to **EBusHandlerPolicy**
  + **EBBCT\_SINGLE** renamed to **EBusHandlerPolicy::Single**
  + **EBBCT\_MULTI** renamed to **EBusHandlerPolicy::Multiple**
  + **EBBCT\_MULTI\_ORD** renamed to **EBusHandlerPolicy::MultipleAndOrdered**
  + **EBusContainerTypes** renamed to **EBusAddressPolicy**
  + **EBCT\_SINGLE** renamed to **EBusAddressPolicy::Single**
  + **EBCT\_ID\_UNORDERED** renamed to **EBusAddressPolicy::ById**
  + **EBCT\_ID\_ORDERED** renamed to **EBusAddressPolicy::ByIdAndOrdered**
+ Updated EBus to declare traits as follows: 

  ```
  static const AZ::EBusAddressPolicy AddressPolicy = AZ::EBusAddressPolicy::ById;
  static const AZ::EBusHandlerPolicy HandlerPolicy = AZ::EBusHandlerPolicy::Single;
  ```
+ Various EBus updates include adding script bindings, removing "Listener," and improved documentation.
+ The Lumberyard Waf build system (lmbr\_waf) QT tool now resembles the Waf QT5 version.
+ In Lumberyard Editor, you can now opt out of sending metrics by clicking **File**, **Global Preferences**, **Editor Settings**, and selecting the opt-out check box.