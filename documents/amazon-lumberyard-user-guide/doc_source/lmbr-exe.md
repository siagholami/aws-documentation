# Managing Game Projects with Lmbr\.exe<a name="lmbr-exe"></a>

****  
This feature is in [preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#preview) release and is subject to change\. 

`Lmbr.exe` is a command\-line tool for managing capabilities, game projects, and Gems\.

**To find the `Lmbr.exe` file**

1. Navigate to one of the following directories:
   + For Visual Studio 2017: `lumberyard_version\dev\Bin64vc141`
   + For Visual Studio 2019: `lumberyard_version\dev\Bin64vc142`

1. In a command line prompt, enter the following command to see the commands that you can run\. 

   ```
   lmbr -help
   ```

   The list of possible commands appears\.  
![\[Lmbr.exe help commands.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/configurator-lmbr.png)

You can also use `-help` on other commands\. For example, to see more information about Lumberyard capabilities, you can enter the following commands: 

```
lmbr capabilities -help
```

```
lmbr capabilities list -help
```

**Topics**
+ [Projects Commands](lmbr-exe-project.md)
+ [Gems Commands](lmbr-exe-gem.md)
+ [Capabilities Commands](lmbr-exe-capabilities.md)
+ [ThirdPartySDKs Commands](lmbr-exe-thirdpartysdks.md)
+ [Packages Commands](lmbr-exe-packages.md)