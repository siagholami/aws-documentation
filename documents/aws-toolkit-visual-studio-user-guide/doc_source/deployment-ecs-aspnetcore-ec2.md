# Deploying an ASP\.NET Core 2\.0 App to Amazon ECS \(EC2\)<a name="deployment-ecs-aspnetcore-ec2"></a>

This section describes how to use the **Publish Container to AWS** wizard, provided as part of the Toolkit for Visual Studio, to deploy a containerized ASP\.NET Core 2\.0 application targeting Linux through Amazon ECS using the EC2 launch type\. Because a web application is meant run continuously, it will deployed as a service\.

## Before you publish your container<a name="tkv-deploy-ecs-netcore-prerequisites"></a>

Before using the **Publish Container to AWS** to deploy your ASP\.NET Core 2\.0 application:
+  [Specify your AWS credentials](deployment-ecs-specify-credentials.md) and [get setup with Amazon ECS](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/get-set-up-for-amazon-ecs.html)\.
+  [Install Docker](https://docs.docker.com/engine/installation)\. You have a few different installation options including [Docker for Windows](https://docs.docker.com/docker-for-windows/install/)\.
+  [Create an Amazon ECS cluster](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/create-cluster.html) based on the needs of your web application\. It only takes a few steps\.
+ In Visual Studio, create \(or open\) a project for an ASP\.NET Core 2\.0 containerized app targeting Linux\.

## Accessing the Publish Container to AWS wizard<a name="tkv-deployment-ecs-netcore-accessing"></a>

To deploy an ASP\.NET Core 2\.0 containerized application targeting Linux, right\-click the project in the Solution Explorer and select **Publish Container to AWS**\.

You can also select **Publish Container to AWS** on the Visual Studio Build menu\.

## Publish Container to AWS Wizard<a name="tkv-deploy-ecs-pubtoaws"></a>

 **Account profile to use** \- Select an account profile to use\.

 **Region** \- Choose a deployment region\. Profile and region are used to set up your deployment environment resources and select the default Docker registry\.

 **Configuration** \- Select the Docker image build configuration\.

 **Docker Repository** \- Choose an existing Docker repository or type in the name of a new repository and it will be created\. This is the repository the built container image is pushed to\.

 **Tag** \- Select an existing tag or type in the name of a new tag\. Tags can track important details like version, options or other unique configuration elements of the Docker container\.

 **Deployment** \- Select **Service on an ECS Cluster**\. Use this deployment option when your application is meant to be long\-running \(like an ASP\.NET Core 2\.0 web application\)\.

 **Save settings to `aws-docker-tools-defaults.json` and configure project for command line deployment** \- Check this option if you want the flexibility of deploying from the command line\. Use `dotnet ecs deploy` from your project directory to deploy and `dotnet ecs publish` the container\.

## Launch Configuration page<a name="tkv-deploy-ecs-launch-config"></a>

 **ECS Cluster** \- Pick the cluster that will run your Docker image\. You can [create an ECS cluster](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/create_cluster.html) using the AWS Management Console\.

 **Launch Type** \- Choose EC2\. To use the Fargate launch type, see [Deploying an ASP\.NET Core 2\.0 Application to Amazon ECS \(Fargate\)](deployment-ecs-aspnetcore-fargate.md)\.

## Service Configuration page<a name="tkv-deploy-ecs-service"></a>

 **Service** \- Select one of the services in the drop\-down to deploy your container into an existing service\. Or choose **Create New** to create a new service\. Service names must be unique within a cluster, but you can have similarly named services in multiple clusters within a region or across multiple regions\.

 **Number of Tasks** \- The number of tasks to deploy and keep running on your cluster\. Each task is one instance of your container\.

 **Minimum Healthy Percent** \- The percentage of tasks that must remain in `RUNNING` state during a deployment rounded up to the nearest integer\.

 **Maximum Percent** \- The percentage of tasks that are allowed in the `RUNNING` or `PENDING` state during a deployment rounded down to the nearest integer\.

 **Placement Templates** \- Select a task placement template\.

When you launch a task into a cluster, Amazon ECS must determine where to place the task based on the requirements specified in the task definition, such as CPU and memory\. Similarly, when you scale down the task count, Amazon ECS must determine which tasks to terminate\.

The placement template controls how tasks are launched into a cluster:
+ AZ Balanced Spread \- distribute tasks across Availability Zones and across container instances in the Availability Zone\.
+ AZ Balanced BinPack \- distribute tasks across Availability Zones and across container instances with the least available memory\.
+ BinPack \- distribute tasks based on the least available amount of CPU or memory\.
+ One Task Per Host \- place, at most, one task from the service on each container instance\.

For more information, see [Amazon ECS Task Placement](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/task-placement.html)\.

## Application Load Balancer page<a name="tkv-deploy-ecs-app-load-balancer"></a>

 **Configure Application Load Balancer** \- Check to configure an application load balancer\.

 **Select IAM role for service** \- Select an existing role or choose **Create New** and a new role will be created\.

 **Load Balancer** \- Select an existing load balancer or choose **Create New** and type in the name for the new load balancer\.

 **Listener Port** \- Select an existing listener port or choose **Create New** and type in a port number\. The default, port `80`, is appropriate for most web applications\.

 **Target Group** \- By default, the load balancer sends requests to registered targets using the port and protocol that you specified for the target group\. You can override this port when you register each target with the target group\.

 **Path Pattern** \- The load balancer will use path\-based routing\. Accept the default `/` or provide a different pattern\. The path pattern is case\-sensitive, can be up to 128 characters in length, and contains a [select set of characters](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/load-balancer-listeners.html#path-conditions)\.

 **Health Check Path** \- The ping path that is the destination on the targets for health checks\. By default, it is `/` and is appropriate for web applications\. Enter a different path if needed\. If the path you enter is invalid, the health check will fail and it will be considered unhealthy\.

If you deploy multiple services, and each service will be deployed to a different path or location, you might need custom check paths\.

## ECS Task Definition page<a name="tkv-deploy-ecs-task-definition"></a>

 **Task Definition** \- Select an existing task definition or choose **Create New** and type in the new task definition name\.

 **Container** \- Select an existing container or choose **Create New** and type in the new container name\.

 **Memory \(MiB\)** \- Provide values for **Soft Limit** or **Hard Limit** or both\.

The *soft limit* \(in MiB\) of memory to reserve for the container\. Docker attempts to keep the container memory under the soft limit\. The container can consume more memory, up to either the hard limit specified with the memory parameter \(if applicable\), or all of the available memory on the container instance, whichever comes first\.

The *hard limit* \(in MiB\) of memory to present to the container\. If your container attempts to exceed the memory specified here, the container is killed\.

 **Task Role** \- Select a task role for an IAM role that allows the container permission to call the AWS APIs that are specified in its associated policies on your behalf\. This is how credentials are passed in to your application\. See [how to specify AWS security credentials for your application](deployment-ecs-specify-credentials.md)\.

 **Port Mapping** \- Add, modify or delete port mappings for the container\. If a load balancer is on, the host port will be default to 0 and port assignment will be dynamic\.

 **Environment Variables** \- Add, modify, or delete environment variables for the container\.

When you are satisfied with the configuration, click **Publish** to begin the deployment process\.

## Publishing Container to AWS<a name="tkv-deploy-ecs-publishing"></a>

Events are displayed during deployment\. The wizard is automatically closed on successful completion\. You can override this by unchecking the box at the bottom of the page\.

You can find the URL of your new instances in the AWS Explorer\. Expand Amazon ECS and Clusters, then click on your cluster\.