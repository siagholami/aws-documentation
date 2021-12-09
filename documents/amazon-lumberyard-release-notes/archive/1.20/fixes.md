# Fixes<a name="lumberyard-v1.20-fixes"></a>

Lumberyard Beta 1.20 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Audio](#audio-fixes-v1.20)
+ [PhysX](#physx-fixes-v1.20)

## Audio<a name="audio-fixes-v1.20"></a>

Audio has the following fixes:
+ `AudioPreloadComponent::isLoaded` now accurately reflects what is loaded in memory.

## PhysX<a name="physx-fixes-v1.20"></a>

The PhysX system has the following fixes:
+ The wscript files for the following gems now have a legal header:
  + AWSLambdaLanguageDemo/v1
  + ScriptCanvasTesting
  + PhysXDebug
  + TouchBending
+ When an entity with a **PhysX Terrain** component has the character "%" in its name, Lumberyard Editor no longer crashes with the error Invalid parameter detected in CRT function. 