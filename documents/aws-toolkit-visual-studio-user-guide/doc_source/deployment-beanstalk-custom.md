# Custom Elastic Beanstalk Application Deployments<a name="deployment-beanstalk-custom"></a>

This topic describes how the deployment manifest for Elastic Beanstalk's Microsoft Windows container supports custom application deployments\.

Custom application deployments are a powerful feature for advanced users who want to leverage the power of Elastic Beanstalk to create and manage their AWS resources, but want complete control on how their application is deployed\. For a custom application deployment, you create Windows PowerShell scripts for the three different actions Elastic Beanstalk performs\. The install action is used when a deployment is initiated, restart is used when the `RestartAppServer` API is called from either the toolkit or the web console, and uninstall which is invoked on any previous deployment whenever a new deployment occurs\.

For example, you might have an ASP\.NET application that you want to deploy while your documentation team has written a static website that they want included with the deployment\. You can do that by writing your deployment manifest like this:

```
{
  "manifestVersion": 1,
  "deployments": {

    "msDeploy": [
      {
        "name": "app",
        "parameters": {
          "appBundle": "CoolApp.zip",
          "iisPath": "/"
        }
      }
    ],
    "custom": [
      {
        "name": "PowerShellDocs",
        "scripts": {
          "install": {
            "file": "install.ps1"
          },
          "restart": {
            "file": "restart.ps1"
          },
          "uninstall": {
            "file": "uninstall.ps1"
          }
        }
      }
    ]
  }
}
```

The scripts listed for each action must be in the application bundle relative to the deployment manifest file\. For this example, the application bundle will also contain a documentation\.zip file which contains a static website created by your documentation team\.

The `install.ps1` script extracts the zip file and sets up the IIS Path\.

```
Add-Type -assembly "system.io.compression.filesystem"
[io.compression.zipfile]::ExtractToDirectory('./documentation.zip', 'c:\inetpub\wwwroot\documentation')

powershell.exe -Command {New-WebApplication -Name documentation -PhysicalPath  c:\inetpub\wwwroot\documentation -Force}
```

Since your application is running in IIS, the restart action will invoke an IIS reset\.

```
iisreset /timeout:1
```

For uninstall scripts, it is important to clean up all settings and files used during the install stage\. That way during the install phase for the new version, you can avoid any collision with previous deployments\. For this example, you need to remove the IIS application for the static website and remove the website files\.

```
powershell.exe -Command {Remove-WebApplication -Name documentation}
Remove-Item -Recurse -Force 'c:\inetpub\wwwroot\documentation'
```

With these script files and the documentation\.zip file included in your application bundle, the deployment creates the ASP\.NET application and then deploys the documentation site\.

For this example, we choose a simple example that deploys a simple static website, but with custom application deployment you can deploy any type of application and let Elastic Beanstalk manage the AWS resources for it\.