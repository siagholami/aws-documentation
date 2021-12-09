# Fixes<a name="lumberyard-v1.8-fixes"></a>

Lumberyard Beta 1.8 and 1.8.0.1 include the following fixes:

## Lumberyard Beta 1.8.0.1<a name="lumberyard-v1.8.0.1-fixes"></a>

Lumberyard Beta 1.8.0.1 includes the following fixes:

**Asset Processor**
+ The macOS package provides a pre-built version of the asset processor that you can use to build your assets. By default the asset processor starts in proxy mode, which means that assets are not built on the local computer. Instead, the game connects to an asset processor that runs on the computer that you specify in the **Proxy IP Address** field. 

  In order to build assets on macOS, you must use the following command to build the asset processor locally and for each computer on which you want to run the asset processor: `lmbr_waf.sh -p all build_darwin_x64_profile --targets=AssetProcessor`

  When you start the asset processor, you must clear the **Proxy Mode** check box. The asset processor will then run on your local computer and build the assets for the operating systems that are enabled in the `AssetProcessorPlatformConfig.ini` file.

**Geppetto**
+ Assigning a skeleton `.chr` to a newly created `.cdf` file in Geppetto no longer results in an error message or requires that you load a different `.cdf` file first.

**Lumberyard Max Export Tool**
+ The `RC.exe` file is now located in the correct folder, and the Lumberyard Max Export tool works as expected.

## Lumberyard Beta 1.8<a name="lumberyard-v1.8.0-fixes"></a>

Lumberyard Beta 1.8 includes the following fixes:

**Audio**
+ Audio area ambience and audio area random no longer play the StopTrigger sound when disabled.
+ Slices that contain audio components no longer fail in the asset processor.

**Character and Animation**
+ Geppetto now provides better error messaging when dealing with read-only files that are not in revision control.
+ Override-mode aimpose blending now uses a smaller angle when blending.

**Cloud Canvas**
+ Listing the resources in a resource group before a project is initialized now works properly.
+ Metrics now work as expected for Cloud Canvas commands.
+ When attempting to update a stack, you will now see a warning that updating a stack will change security metadata, roles, and policies.
+ FunctionAccess metadata now appears in templates as expected.
+ The `lmbr_aws project create` command for Samples Project no longer fails if the `project-template.json` file isn't writable.
+ The resource group for each cloud gem is now added automatically.
+ Various fixes for `lmbr_aws` include an unhandled error for uninitialized projects or when using an invalid endpoint. This applies to `add-login-provider`, `update-login-provider`, and `remove-login-provider`.
+ Runtests now properly runs the `add_resource` tests.
+ The **Create Deployment** and **Create Resource Group** windows no longer have black text on a dark background.

**Console Support**
+ Console keyboards now function properly.

**FBX Settings**
+ The FBX Settings now correctly computes the frame count of imported animations.
+ Animations are no longer always considered to be looping.

**Lumberyard Editor**
+ Pressing and holding **Shift** and right-click while navigating in the 3D view now speeds up navigation in the editor as expected.

**Lumberyard Setup Assistant**
+ Various fixes to the Lumberyard Setup Assistant include grammatical fixes to error messages and descriptions, improved error messages, and updated setup instructions.
+ The Lumberyard Setup Assistant now correctly displays an error message for third-party paths that exceed the maximum length allowed. Previously, long paths were missing.
+ If the `3rdParty` folder is not set, the working directory is no longer polluted with SDK folders.

**macOS**
+ The TouchRayCast map in FeatureTests now prints text when you hover the mouse over each object.
+ The HumanFeatureEye map now loads properly on macOS. You can load the map directly from the `autoexec.cfg` file or from the default ShadowSkybox map.
+ Compiling no longer results in an "Argument list too long" error.

**Mobile**
+ When issued from the remote console, the `map` command now works correctly.
+ Android:
  + Live reloading over VFS is now fixed for Android.
  + The assets folder is now generated correctly when packing assets into the APK.
  + The HumanFeatureHair level in FeatureTests now works correctly.
  + You can now modify icons and splash screens.
+ iOS:
  + The lighting issues in the decal\_sample maps have been fixed.
  + Apple TV profile builds now build and run correctly.
  + Compiling now works as expected if the argument list is too long.

**Networking**
+ When generating a certificate for the Multiplayer Sample, a certificates folder is now also generated, if needed.
+ The Multiplayer Sample now has updated particle warning messages.
+ MultiplayerLobby no longer crashes when you refresh the server list in the editor.
+ Hot reloading a script with NetBinding no longer results in a crash.
+ Re-running a script that didn't unregister from EBuses and triggered a network call no longer results in a crash.
+ Generating an EntityId is now cross DLL-safe on non-Windows operating systems.
+ DrillerStream no longer experiences an infinite loop issue.
+ The **Multiplayer Gem** no longer experiences a memory leak related to the secure socket driver.
+ Connections are now properly released in the secure socket driver.
+ Marshalling the last replica state no longer results in a crash.
+ Establishing P2P connections no longer randomly fail.
+ Servers now clean up Amazon GameLift sessions on disconnect.
+ Data sets now provide the modification timestamp from the sender rather than the time the callback was triggered on the receiver side.

**Particle Editor**
+ The **Particle** component's spawn direction is now fixed.
+ The **Particle** component now supports particle LODs.
+ You can now browse the **Particle** component audio RTPC asset.
+ The editor no longer crashes when you select **Level** from the **Library** source drop-down list for the **Particle** component.
+ You can now assign new emitters to the particle library as expected.
+ The **Particle** component no longer experiences UI issues when switching between particle effects libraries.
+ The **Particle** component now displays the emitter name only. Previously the library name was also displayed, which used valuable input space.
+ The emitter strength setting is now a slider that ranges from -1 to 1. The default value is -1, which applies strength over the emitter lifetime curve. 0 value removes the curve effect. 1 value applies the effect uniformly over the emitter lifetime curve.
+ When removing a material override from a static mesh entity, the material now hot reloads.
+ The Lumberyard package now includes all assets, such as lens flare textures, that are referenced by the libraries included in the package.
+ GPU and CPU particle emitters now move at the same speed as expected.

**Project Configurator**
+ Various fixes to the Project Configurator include grammatical fixes and cosmetic updates to the interface.
+ The **View in directory** button now opens when the gem asset directory includes spaces in its path.

**Twitch ChatPlay**
+ The editor is no longer affected if you enter an invalid connection configuration for Twitch ChatPlay.

**UI Editor**
+ You can now undo re-parenting actions on multiple items.
+ In the UI Editor, the **Font** component now changes the font for the text after the action state is activated.
+ In the UI Editor, the **Cancel** button in the **Save as** dialog box now displays correctly.
+ UI animations now play at the proper speed when in preview mode.
+ XML parse warnings no longer appear when you type reserved XML characters in a **Text** component.
+ When the **Content** element is scaled, the **Snap to Children** feature now snaps to the correct location.
+ The mouse cursor is no longer visible in the uieditor\_sample map on Android.
+ Loading a UI canvas and clicking **AI/Physics** no longer loads a UI that cannot be closed.
+ The UI Editor no longer crashes due to text rendering issues.
+ The UI Editor no longer crashes when you select an animation with elements removed.
+ The UI Editor no longer crashes when a canvas with a scroll box enters preview or game mode and the **Content** element is set to **None**.

**Virtual Reality**
+ Tessellated objects now cull properly in VR.
+ The Samples Project no longer crashes if the OSVR HMD is connected and `output_to_cmd` is enabled.
+ Black lines and shapes no longer erroneously appear at the edges of vision on the horizon.
+ MP4 files no longer experience playback issues.

**Miscellaneous**
+ The scan no longer fails when trying to delete the `NO_TIMESTAMP` folder if the folder is open in Windows Explorer.
+ The editor no longer crashes when passing an invalid URL through the HTTPClient component.