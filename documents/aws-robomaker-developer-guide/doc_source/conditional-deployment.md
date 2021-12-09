# Conditional Deployment<a name="conditional-deployment"></a>

A robot application is downloaded and installed onto robots in a fleet using a deployment job\. Any tasks the robot is performing will halt as the new version of the robot application is installed\. You can verify your robot is ready to download and install the new robot application using a download condition file\. 

The *download condition file* is a script run on the robot prior to downloading the new deployment\. If the script exits with `0`, verification succeeded and the deployment can proceed on the robot\. If the script exits with `1`, the deployment will not be downloaded and installation will fail\.

**Note**  
To use a download condition file, you must have AWS IoT Greengrass Core version 1\.9\.4 or newer installed on your robots\.

Use the following script as a template for your download condition file:

```
#!/bin/bash
# sample command as condition result
# for example, you could check to see if the robot is in a
# charging station or other suitable spot for a deployment
conditionalScriptPass=`<Condition_Verification_Commands>`
if [[ ! -z "$conditionalScriptPass" ]]; then
    #condition pass
    echo succeeded
    exit 0
else
    #condition failed
    echo failed
    exit 1
fi
```

The download condition file is downloaded to `/home/gcc_user/roboMakerDeploymentPackage/MyS3KeyName`\. If the `/home/gcc_user/` directory does not exist, it is downloaded to `/tmp/roboMakerDeploymentPackage`\. If there is an existing download condition file on the robot, it will be overwritten during the next deployment\. It will also be ignored during robot reboot or restart\. 