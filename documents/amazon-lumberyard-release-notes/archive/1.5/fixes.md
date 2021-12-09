# Fixes<a name="lumberyard-v1.5-fixes"></a>

Lumberyard Beta 1.5 includes the following fixes:

**Lumberyard Setup Assistant**
+ Fixed an issue that caused long installation paths to display incorrectly.
+ Fixed an issue with scroll view that prevented the user interface from rendering correctly.
+ Fixed the Boost version and installation instructions that are displayed in the Lumberyard Setup Assistant.
+ Fixed the Mikktspace version that is displayed in the Lumberyard Setup Assistant.

**Character and Animation**
+ Geppetto:
  + Fixed several issues with source control integration that resulted in error messages during save.
  + Fixed an issue with bspace live reloading of assets.
  + Fixed an issue that caused a delay when marking UI fields as read only; you can now edit fields temporarily.
+ Mannequin:
  + Fixed an issue that caused the **Mannequin Editor **to crash if a prop model was attached to a skin attachment point using AttachmentPnT and AttachmentProp proc layer clips.
  + Fixed an issue that prevented a particle FX from attaching correctly when triggered through the particle proc layer.
+ FBX Settings:
  + Fixed an issue where meshes with no material data caused pure function call errors.
  + Fixed an issue that caused the import progress bar to hang if a mesh group without selected meshes was added.
+ Maya: Fixed an issue that caused an error caused by some meshes in a group having specified vertex colors while some did not.

**Cinematics**
+ Fixed an issue that prevented animated property values from displaying in the **Rollup Bar**.

**Cloud Canvas**
+ The **Cloud Canvas Resource Manager** includes numerous improvements, bug fixes, and error validations.

**Component Entity System**
+ Fixed an issue that caused undo operations to lose parent–child relationships.

**Gems**
+ Fixed an issue that prevented a gem's scroll position from being preserved when saving.
+ Fixed an issue that prevented a gem-specific assets directory from generating when creating a new gem.

**Mobile**
+ Fixed an issue with the log being spammed with a "File not found" error in the `\FeatureTests\KeyboardBasic` directory.
+ Android:
  + Fixed an issue that caused alignment of the APK to occur after it was signed. Alignment of the APK is now completed in the proper order for distribution as required by the Google Play Store.
  + Fixed a broken lighting issue in the Movers\_Sample and Trigger\_Sample maps.
  + Fixed an issue that prevented the Decal\_Sample map from rendering properly.

**Networking**
+ Fixed a crash issue with the console variables in the Multiplayer Gem for consoles.
+ Fixed an issue with logging bad characters that caused a crash. The output buffer is now written to properly.
+ Fixed a threading-related crash in Lua VM caused by incoming script RMIs being processed during level load.

**OS X**
+ The **Decal** component now serializes its data in and out properly. Decals now appear correctly on the Decal\_Sample map.
+ Fixed an issue that prevented volumetric clouds from rendering correctly.

**Particle Editor**
+ Fixed an issue with rotation angle behaving differently on CPU and GPU emitters.
+ Fixed an issue with the emissive lighting attribute behaving differently on CPU and GPU emitters.
+ Fixed an issue that caused an emitter to persist in the **Preview** window even after all emitters were deleted.
+ Fixed an issue with renaming emitters that caused the name to be repositioned.
+ The Init Angle and Random Angle are now located next to each other.

**UI Editor**
+ Fixed an issue that caused bad track colors in the Animation Editor.

**Virtual Reality**
+ Fixed an issue that prevented `r_ResolutionScale` from working properly in the standalone launcher.
+ Fixed an issue that caused GPU particles to consume update time even when there were no particles in the scene.
+ Fixed the symmetric field of view (FOV) calculation for OpenVR.
+ Fixed a tracking issue for OpenVR where waiting for vsync could happen twice in one frame.
+ Fixed an issue that prevented the coverage buffer from working properly in VR. You can now use CPU-side object culling.

**Miscellaneous**
+ Updated the Asset Processor so that it no longer treats newly imported `i_caf` files as failures until an animsettings file is created.
+ Fixed an issue that prevented shader parameters from overloading on cloned materials when the render thread is enabled (`r_multithreaded=1`).
+ Fixed an issue that prevented the **Decal** texture from being animated and used to control the intensity of emittance in the Illum shader.
+ Fixed an issue that prevented occlusion meshes from being sorted properly.
+ Fixed an issue that prevented the terrain painting tool from saving and loading color values per layer correctly.
+ Fixed an issue that affected the default brightness of the terrain layer.
+ Fixed an issue that caused water volume fog to render even when it was not inside the volume.
+ Fixed the `lmbr_test.cmd` tool so that it now points to the correct Python location.
+ Fixed the `lmbr_test.cmd` tool so that it now works properly in directories that contain spaces in the path.
+ Updated the AzTestScanner so that you can now interrupt and exit test runs immediately.