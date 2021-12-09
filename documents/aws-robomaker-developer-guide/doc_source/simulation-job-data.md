# Accessing Simulation Job Data<a name="simulation-job-data"></a>

AWS RoboMaker can capture the following information from a running simulation job:
+ **Information written to standard output and standard error streams**\. This information is collected in Amazon CloudWatch Logs\. 
+ **CloudWatch metric `RealTimeFactor`**\. It is the ratio of the amount of time that was simulated versus wall clock time\. If it takes an hour to simulate 30 minutes, the factor is \.5\. More complex simulations have a lower real time factor\. 
+ **Gazebo log data including the state of models, links and joints**\. Gazebo log data is written to the `gazebo-logs` folder if an Amazon Simple Storage Service bucket was specified when the simulation job was created\. 
+ **ROS bag files containing timestamped ROS messages**\. ROS bag files are written to the `ros-bag` folder if an Amazon Simple Storage Service bucket was specified when the simulation job was created\. 

Standard output and standard error information is written to Amazon CloudWatch while the simulation job is running\. Gazebo logs and ROS bag files are available soon after the simulation job completes\.

**To access logs, metrics and optional output Amazon S3 bucket**

1. In the AWS RoboMaker console, choose **Simulation jobs** on the left and then select the simulation job\. 

1. In the **Simulation details** page, select the **Configuration** tab\.

1. To see ROS bags, ROS logs and Gazebo logs, select the Amazon S3 location under **Simulation job output destination** to view the Amazon S3 bucket, then select the folder beginning with `sim`, and then select the folder\. If there are more than one, select by date and time\. 

   The folder includes `gazebo-logs`, `ros-bags`, and `ros-logs`\.

1. To see standard error, standard output, and other information in CloudWatch Logs, select **Logs**, and then choose a simulation applicatoion or robot application log to view\. 

1. To see CloudWatch metrics, select **Metrics**, and then select a metric\. For example, select **RealTimeFactor**\.

Access CloudWatch Logs, metrics, and simulation output Amazon S3 bucket from the **Simulation job details** page in the AWS RoboMaker console\.