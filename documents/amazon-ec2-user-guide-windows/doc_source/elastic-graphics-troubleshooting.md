# Troubleshooting<a name="elastic-graphics-troubleshooting"></a>

The following are common errors and troubleshooting steps\.

**Contents**
+ [Investigating application performance issues](#elastic-graphics-troubleshooting_performance)
  + [OpenGL rendering performance issues](#elastic-graphics-opengl-performance)
  + [Remote access performance issues](#elastic-graphics-remote-performance)
+ [Resolving unhealthy status issues](#elastic-graphics-troubleshooting_unhealthy_status)
  + [Stop and start the instance](#elastic-graphics-start-and-stop)
  + [Verify the installed components](#elastic-graphics-verify)
  + [Check the Elastic Graphics logs](#elastic-graphics-check-logs)

## Investigating application performance issues<a name="elastic-graphics-troubleshooting_performance"></a>

Elastic Graphics uses the instance network to send OpenGL commands to a remotely attached graphics card\. In addition, a desktop running an OpenGL application with an Elastic Graphics accelerator is usually accessed using a remote access technology\. It is important to distinguish between a performance problem related to the OpenGL rendering or the desktop remote access technology\.

### OpenGL rendering performance issues<a name="elastic-graphics-opengl-performance"></a>

The OpenGL rendering performance is determined by the number of OpenGL commands and frames generated on the remote instance\.

Rendering performance may vary depending on the following factors:
+ Elastic Graphics accelerator performance
+ Network performance
+ CPU performance
+ Rendering model, scenario complexity
+ OpenGL application behavior

An easy way to evaluate performance is to display the number of rendered frames on the remote instance\. Elastic Graphics accelerators display a maximum of 25 FPS on the remote instance to achieve the best perceived quality while reducing network usage\.

**To show the number of frames produced**

1. Open the following file in a text editor\. If the file does not exist, create it\.

   ```
   C:\Program Files\Amazon\EC2ElasticGPUs\conf\eg.conf
   ```

1. Identify the `[Application]` section, or add it if it is not present, and add the following configuration parameter:

   ```
   [Application]
   show_fps=1
   ```

1. Restart the application and check the FPS again\.

If the FPS reaches 15\-25 FPS when updating the rendered scene, then the Elastic Graphics accelerator is performing at peak\. Any other performance problems you experience are likely related to the remote access to the instance desktop\. If that is the case, see the Remote Access Performance Issues section\.

If the FPS number is lower than 15, you can try the following:
+ Improve Elastic Graphics accelerator performance by selecting a more powerful graphics accelerator type\.
+ Improve overall network performance by using these tips:
  + Check the amount of incoming and outgoing bandwidth to and from the Elastic Graphics accelerator endpoint\. The Elastic Graphics accelerator endpoint can be retrieved with the following PowerShell command:

    ```
    PS C:\> (Invoke-WebRequest http://169.254.169.254/latest/meta-data/elastic-gpus/associations/[ELASTICGPU_ID]).content
    ```
  + The network traffic from the instance to the Elastic Graphics accelerator endpoint relates to the volume of commands the OpenGL application is producing\.
  + The network traffic from the Elastic Graphics accelerator endpoint to the instance relates to the number of frames generated by the graphics accelerator\.
  + If you see the network usage reaching the instances maximum network throughput, try using an instance with a higher network throughput allowance\.
+ Improve CPU performance:
  + Applications may require a lot of CPU resources in addition to what the Elastic Graphics accelerator requires\. If Windows Task Manager is reporting a high usage of CPU resources, try using an instance with more CPU power\.

### Remote access performance issues<a name="elastic-graphics-remote-performance"></a>

An instance with an attached Elastic Graphics accelerator can be accessed using different remote access technologies\. Performance and quality may vary depending on:
+ The remote access technology
+ Instance performance
+ Client performance
+ Network latency and bandwidth between the client and the instance

Possible choices for the remote access protocol include:
+ Microsoft Remote Desktop Connection
+ NICE DCV
+ VNC

For more information about optimization, see the specific protocol\.

## Resolving unhealthy status issues<a name="elastic-graphics-troubleshooting_unhealthy_status"></a>

If the Elastic Graphics accelerator is in an unhealthy state, use the following troubleshooting steps to resolve the issue\.

### Stop and start the instance<a name="elastic-graphics-start-and-stop"></a>

If your Elastic Graphics accelerator is in an unhealthy state, stopping the instance and starting it again is the simplest option\. For more information, see [Stopping and starting your instances](Stop_Start.md#starting-stopping-instances)\.

**Warning**  
When you stop an instance, the data on any instance store volumes is erased\. To keep data from instance store volumes, be sure to back it up to persistent storage\.

### Verify the installed components<a name="elastic-graphics-verify"></a>

Open the Windows Control Panel and confirm that the following components are installed:
+ Amazon Elastic Graphics Manager
+ Amazon Elastic Graphics OpenGL Library
+ Amazon EC2 Elastic GPUs OpenGL Redirector

If any of these items are missing, you must install them manually\. For more information, see [Installing the required software for Elastic Graphics](working-with-elastic-graphics.md#elastic-graphics-install-libraries)\.

### Check the Elastic Graphics logs<a name="elastic-graphics-check-logs"></a>

Open the Windows Event Viewer, expand the **Application and Services Logs** section, and search for errors in the following event logs:
+ EC2ElasticGPUs
+ EC2ElasticGPUs GUI