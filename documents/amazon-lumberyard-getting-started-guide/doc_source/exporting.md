# 12: Exporting Your Game<a name="exporting"></a>

Exporting an executable file for your game is a critical steps in game creation\. 

You'll export your game and then play it as an executable file\. Exporting your game packages up the data files so that you can run the level file as a standalone level\.

**To export and run your game**

1. From the Lumberyard Editor main menu, choose **Game**, **Export to Engine**\.

   This creates a launcher file for your level\. When the process is finished, a success message is displayed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-success.png)

1. Open a file manager such as Windows Explorer to find your game launcher, `StarterGameLauncher.exe`\. The launcher is saved in the same directory as the Lumberyard editor executable\.

   For example:
   + For Visual Studio 2017, this might be `C:\Amazon\Lumberyard\1.x.x.x\dev\Bin64vc141`\.
   + For Visual Studio 2015, this might be `C:\Amazon\Lumberyard\1.x.x.x\dev\Bin64vc140`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-filesystem.png)

1. Run `StarterGameLauncher.exe`\.

   The game opens in a game window to the default level for the project\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-gamestart.png)

1. Press the tilde \( **\~** \) key on your keyboard to open the console for your game\.

   Enter **map <your level name>**\. For example, **map MyFirstLevel**\. Press **Enter**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-map.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-myfirstlevel.png)

1. Play and enjoy the game that you just created\.

   To quit, press \( **`** \) again to open the console\.

   Enter **quit**\.

Any changes that you make to your game in Lumberyard Editor require you to export your level again in order to see those changes when you use the game launcher\.

For more information about releasing game builds, see [Creating Game Builds](https://docs.aws.amazon.com/lumberyard/latest/userguide/game-build-intro.html) in the [Amazon Lumberyard User Guide](https://docs.aws.amazon.com/lumberyard/latest/userguide/)\.

