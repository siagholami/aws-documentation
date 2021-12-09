# Step 5: Deploy Robot Application<a name="gs-deploy"></a>

In this section, you compile the Hello World robot application for the ARMHF platform, which is used by TurtleBot3\. You also create a robot in AWS RoboMaker and then configure your TurtleBot3 robot with AWS IoT Greengrass software\. Then you register the robot into a new fleet and deploy the application\.

**Topics**
+ [Prepare your TurtleBot3 Robot](#gs-deploy-config)
+ [Bundle and Deploy Hello World Robot Application](#gs-deploy-bundle)

## Prepare your TurtleBot3 Robot<a name="gs-deploy-config"></a>

Before you can deploy a robot application to a physical robot, create the robot in AWS RoboMaker\. Next, configure your physical robot with AWS IoT Greengrass\. After that, create a fleet and register your robot into the fleet\.

**To prepare your TurtleBot3 robot**

1. First, create a robot in AWS RoboMaker and configure your TurtleBot3 robot\. Follow the steps in [Creating a Robot](create-robot.md)\.

1. Next, create a fleet\. Follow the steps in [Creating a Fleet](create-fleet.md)\.

1. Register your robot as part of the new fleet\. Follow the steps to **Register** your robot to your fleet in [Registering and Deregistering Robots](register-deregister-fleet.md)\.

## Bundle and Deploy Hello World Robot Application<a name="gs-deploy-bundle"></a>

In this section, bundle the Hello World application for the ARMHF architecture using a Docker image\. Then you copy the robot application bundle to an Amazon S3 bucket and deploy\.

Bundling the robot application and simulation application might each take 20 minutes or more depending on your instance type\.

**Note**  
The AWS RoboMaker cross\-compilation container uses `colcon bundle` to package the compiled sources\. This resolves the Debian packages for Ubuntu \(Bionic and Xenial\)\. The packages are provided in the ROS distributions\. Packages that are not available in the ROS distributions, such as Debian packages for Raspbian, are not supported by the cross\-compilation container\.

**To bundle and deploy the Hello World robot application**

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\. 

1. On the left, expand **Development**, choose **Development environments**, select **HelloWorld**, and then select **Open IDE**\. It might take a few minutes to prepare the development environment\. 

1. In the **HelloWorld** AWS Cloud9 development environment, choose the **bash** tab at the bottom of the page\. Next, run the following commands to bundle the **HelloWorld** robot application for ARMHF:
**Note**  
The following commands are for ROS Kinetic and ROS Melodic applications\.

   ```
   $ cd /opt/robomaker/cross-compilation-dockerfile/
   $ sudo bin/build_image.bash      
   $ cd ~/environment/HelloWorld/robot_ws
   $ sudo docker run -v $(pwd):/ws -it ros-cross-compile:armhf
   $ cd ws
   $ apt update
   $ rosdep install --from-paths src --ignore-src -r -y
   $ colcon build --build-base armhf_build --install-base armhf_install
   $ colcon bundle --build-base armhf_build --install-base armhf_install --bundle-base armhf_bundle --apt-sources-list /opt/cross/apt-sources.yaml
   $ exit
   ```

1. Before you can deploy the robot application, copy it to an Amazon S3 bucket that AWS RoboMaker can access\. A bucket was created on your behalf for the **HelloWorld** robot application\. Find the name of the bucket using the following command:

   ```
   $ aws s3 ls | grep "robomakerhelloworld"
   ```

   Now, copy the robot application to the bucket you found above\.

   ```
   $ aws s3 cp armhf_bundle/output.tar s3://robomakersampleapplicationhelloworld-bundlesbucket-##########/hello-world-robot.armhf.tar
   ```

   The ARMHF version of the robot application is `hello-world-robot.armhf.tar`\.

1. Update the Hello World robot application created on your behalf with the ARMHF version of the robot application\. In the **AWS RoboMaker console**, select **Development**, then select **Robot applications**, and then choose the robot application with a name beginning with **roboMakerSampleApplicationHelloWorld\_**\. 

1. In the **Robot application details** page, in **Versions**, select **$LATEST**, and then choose **Update**\. 

1. In the **Update robot application** page, in **Sources**, specify the location of the **ARMHF** bundle from step 4 in the **ARMHF source file** field, then select **Create**\.

1. In the **Robot application details** page, in **Versions**, select **Create new version**, and then choose **Create**\. 

1. You are now ready to deploy the robot application to your TurtleBot3 robot\. In the **AWS RoboMaker console**, select **Fleet management**, then select **Deployments**, and then select **Create deployment**\. 

1. In the **Create deployment** page, select the **Fleet** you created with your robot registered, then select the **Robot application** and **Robot application version** you created\.

1. In **Deployment launch config**, type in **hello\_world\_robot** for **Package name**\. Then type in **deploy\_rotate\.launch** for **Launch file**\. 

1. In **Deployment config**, accept the default values for **Concurrent deployment percentages** and **Failure threshold percentage**\. 

1. Select **Create**\. You can track the deployment status and deployment progress detail on the **deployment details** page\. 

**Next Step**  
[Step 6: Clean up](gs-cleanup.md)