# Fleet Management and Deployment<a name="how-it-works-deployment"></a>

After testing is complete, you can deploy the robot application to your robots by using an AWS IoT Greengrass over\-the\-air update\. Before you deploy your application, set up each robot to accept updates from AWS RoboMaker and communicate its status\. Next, register your robots into a fleet\. A fleet is a logical group of robots\. When your fleet is set up, deploy your robot application\. You can control the pace of deployment\. You can also control what happens before and after your application launches on the robot\.

Information about the deployment is provided by AWS RoboMaker\. Additional information specific to your robot and scenarios can be captured using AWS RoboMaker cloud extensions and custom code\.