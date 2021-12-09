# Debugging code in an Amazon Elastic Container Service cluster by using the AWS Toolkit for JetBrains<a name="ecs-debug"></a>

You can use the AWS Toolkit for JetBrains to debug code in an Amazon Elastic Container Service \(Amazon ECS\) cluster in an AWS account\.

**Note**  
Debugging code in Amazon ECS clusters is currently in beta\.  
This feature is intended for use a development environment\. Do not use this in a production environment\. Debugging code in an Amazon ECS cluster changes the state of resources in your AWS account including, but not limited to, stopping associated Amazon ECS services and changing their configurations\. Also, manually changing the state of resources while code debugging is enabled could lead to unpredictable results\.

## Prerequisites<a name="ecs-prereqs"></a>

Before you begin debugging your code, you must have the following:

1. The Docker image that you want to use to debug your code\. This image can be hosted in either of the following:
   + Your AWS account's Amazon Elastic Container Registry \(Amazon ECR\)\.
     + To find an existing image in Amazon ECR, see [Pulling an Image](https://docs.aws.amazon.com/AmazonECR/latest/userguide/docker-pull-ecr-image.html) in the Amazon Elastic Container Registry User Guide\. See also [Using Amazon ECR Images with Amazon ECS](https://docs.aws.amazon.com/AmazonECR/latest/userguide/ECR_on_ECS.html) in the Amazon Elastic Container Registry User Guide\.
     + To create a new image in Amazon ECR, see [Pushing an Image](https://docs.aws.amazon.com/AmazonECR/latest/userguide/docker-push-ecr-image.html) in the Amazon Elastic Container Registry User Guide\. See also [Using Amazon ECR Images with Amazon ECS](https://docs.aws.amazon.com/AmazonECR/latest/userguide/ECR_on_ECS.html) in the Amazon Elastic Container Registry User Guide\.
   + Docker Hub\. \(Images that are not hosted in Docker Hub—such as [microsoft\-dotnet\-core\-runtime](https://hub.docker.com/_/microsoft-dotnet-core-runtime/)—are not supported\.\)
     + To find an existing image in Docker Hub, see the [Explore \- Docker Hub](https://hub.docker.com/search/?type=image) on the Docker Hub website\.
     + To create a new image in Docker Hub, see the [Docker Hub Quickstart](https://docs.docker.com/docker-hub/) on the Docker Documentation website\.
**Note**  
If you don't already have an image available, we recommend one of the following:  
For Java, use `amazoncorretto` for the latest version of [Amazon Corretto](http://aws.amazon.com/corretto) \(a no\-cost, multiplatform, production\-ready distribution of the Open Java Development Kit \(OpenJDK\)\), or one of the other [`amazoncorretto` images listed on the Docker Hub website](https://hub.docker.com/_/amazoncorretto) that is compatible with the code you want to debug\.
For Python, use `python` for the latest version of Python, or one of the other [`python` images listed on the Docker Hub website](https://hub.docker.com/_/python) that is compatible with the code you want to debug\.
For Node\.js, use `node` for the latest version of Node\.js, or one of the other [`node` images listed on the Docker Hub website](https://hub.docker.com/_/node) that is compatible with the code you want to debug\.

1. In your AWS account, an AWS Identity and Access Management \(IAM\) role with AWS permissions that are needed by the code you want to debug\. This role will be used as the task role by Amazon Elastic Container Service \(Amazon ECS\)\. This task role must also have a trust relationship with the `ecs-tasks.amazonaws.com` service principal and must contain a reference to the `AmazonSSMManagedInstanceCore` AWS managed policy\. For more information, see how to [set up the Amazon ECS task role](#ecs-task-role)\.

1. In your AWS account, an Amazon ECS cluster that contains the service you want to debug\. For more information, see how to [set up the Amazon ECS cluster](#ecs-cluster)\.

1. In your AWS account, a specific IAM customer managed policy that you add to the appropriate IAM entity \(such as an IAM user, group, or role\) that is associated with AWS credentials you specify when connecting to the AWS Toolkit for JetBrains\. For more information, see how to [add the IAM customer managed policy to the IAM entity](#ecs-iam-policy)\.

1. On your local development machine, a copy of the code you want to debug\.

## Debugging code<a name="ecs-debug-debug"></a>

After you complete the preceding [prerequisites](#ecs-prereqs), you can debug your code as follows:

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\. If the [Amazon ECS cluster](#ecs-cluster) is in an AWS Region that's different from the current one, [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region) that contains it\.

1. Expand **ECS**, and then expand **Clusters**\.

1. Expand your Amazon ECS cluster, right\-click your service, and then choose **Enable Cloud Debugging**\. For example, in the following screenshot, the cluster is named **java**, and the service is named **java\-service**\.  
![\[Enabling cloud debugging in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. When prompted, choose your [Amazon ECS task role](#ecs-task-role), and then choose **OK**\.

   The status bar displays the message **Configuring Cloud Debugging resource**\. Wait until the **Build Output** tab of the **Build** tool window displays a successful configuration message\. \(A related pop\-up also is displayed in the lower\-right corner\.\) This will take several minutes\.
**Note**  
As you enable code debugging in your AWS account for the first time, the AWS Toolkit for JetBrains creates an Amazon S3 bucket in your AWS account\. The bucket's name follows the format of `do-not-delete-cloud-debug-Region-ID-account-ID`\. The JetBrains Toolkit stores information in this bucket to enable code debugging\. **Do not delete this bucket or modify its contents\.** If you do, code debugging might stop working or produce unexpected results\. If you accidentally delete or modify this bucket, the JetBrains Toolkit will try to recreate the bucket\. You can also force the JetBrains Toolkit to recreate the bucket by choosing **Enable Cloud Debugging** again as described earlier, or by choosing **Disable Cloud Debugging** as described later in this procedure\.

1. With the code you want to debug displayed, in the **AWS Explorer**, expand **ECS**, expand **Clusters**, and then expand your cluster\. A service is displayed with a debug icon next to it\. This indicates the service is now enabled for cloud debugging\. Right\-click the service with the debug icon, and then choose **Debug**\.  
![\[Debugging an Amazon ECS service in the AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Complete the [**Edit configuration**](edit-configuration-dialog.md#edit-configuration-dialog-ecs) dialog box, and then choose **Debug**\.
**Note**  
To make changes to this configuration later, on the menu bar, choose **Run**, **Edit Configurations**\. Then expand **Amazon ECS Service Cloud Debug**, and choose the service's name\. 

1. Use the IDE's built\-in debugging tools to debug your code as usual\.

1. If you make changes to your code, you can start debugging again\. In the **AWS Explorer**, expand **ECS**, expand **Clusters**, and then expand your cluster\. Right\-click your service with the debug icon next to it, and then choose **Debug**\.

1. If you make changes to the associated `Dockerfile`, you must rebuild and republish the Docker image, and then repeat this procedure from the beginning\.

1. To disable debugging, in the **AWS Explorer**, expand **ECS**, expand **Clusters**, and then expand your cluster\. Right\-click your service with the debug icon next to it, and then choose **Disable Cloud Debugging**\. A pop\-up is displayed, confirming that debugging is disabled\.

## Setting up the Amazon ECS task role<a name="ecs-task-role"></a>

Note that the following information applies to permissions that Amazon ECS needs, which is different from [permissions that the AWS Toolkit for JetBrains needs](#ecs-iam-policy)\. 

To debug code in Amazon Elastic Container Service \(Amazon ECS\) clusters, you must first have in your AWS account an AWS Identity and Access Management \(IAM\) role with AWS permissions that are needed by the code you want to debug\. This role will be used as the task role by Amazon Elastic Container Service \(Amazon ECS\)\. This task role must also have a trust relationship with the `ecs-tasks.amazonaws.com` service principal and must contain a reference to the `AmazonSSMManagedInstanceCore` AWS managed policy\.

To create a role that meets these requirements, see [Creating a Role for an AWS Service \(Console\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html#roles-creatingrole-service-console) in the IAM User Guide, specifying the following settings:

1. For **Choose the service that will use this role**, choose **Elastic Container Service**\.

1. For **Select your use case**, choose **Elastic Container Service Task**\.

1. For **Attach permissions policies**, choose **AmazonSSMManagedInstanceCore**\.

To add additional AWS permissions to an existing Amazon ECS task role, see "To change the permissions allowed by a role \(console\)" in [Modifying a Role \(Console\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_manage_modify.html#roles-managingrole-editing-console) in the IAM User Guide\.

## Setting up the Amazon ECS cluster<a name="ecs-cluster"></a>

To debug code in Amazon Elastic Container Service \(Amazon ECS\) clusters, you must first have in your AWS account an Amazon ECS cluster that contains the service you want to debug\.

### Setting Up a Fargate Cluster<a name="fargate-cluster"></a>

To quickly create a Fargate cluster, service, and task definition that meets the minimum requirements, see [Getting Started with Amazon ECS using Fargate](https://docs.aws.amazon.com/AmazonECS/latest/userguide/ECS_GetStarted_Fargate.html) in the Amazon Elastic Container Service User Guide for AWS Fargate\. The only required settings are in **Step 1: Container and Task**\. Specifically, after you specify a name for the container, for **Container definition**, choose **Configure**\. Then specify an **Image** that is compatible with the code you want to debug\.

### Setting Up an Amazon EC2 Cluster<a name="ec2-cluster"></a>

For information on how to create an Amazon EC2 managed cluster, see [Getting Started with Amazon ECS Using Amazon EC2](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/getting-started-ecs-ec2.html) in the *Amazon Elastic Container Service Developer Guide*

**Note**  
If you don't already have an image available, we recommend one of the following:  
For Java, use `amazoncorretto` for the latest version of Amazon Corretto, or one of the other [`amazoncorretto` images listed on the Docker Hub website](https://hub.docker.com/_/amazoncorretto) that is compatible with the code you want to debug\.
For Python, use `python` for the latest version of Python, or one of the other [`python` images listed on the Docker Hub website](https://hub.docker.com/_/python) that is compatible with the code you want to debug\.
For Node\.js, use `node` for the latest version of Node\.js, or one of the other [`node` images listed on the Docker Hub website](https://hub.docker.com/_/node) that is compatible with the code you want to debug\.

For advanced scenarios, you can create a cluster, task definition, and service independently\. To do so, see the following in the Amazon Elastic Container Service Developer Guide:
+ [Creating a Cluster](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/create_cluster.html) – For **Select cluster template**, you can choose either **Networking only \(for Fargate\)** or **EC2 Linux \+ Networking \(for EC2\)**\.
+ [Creating a Task Definition](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/create-task-definition.html) – For **Select launch type compatibility**, choose the corresponding launch type\.
+ [Creating a Service](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/create-service.html) – For **Configure service**, choose the corresponding **Launch Type**\.

## Adding the IAM customer managed policy<a name="ecs-iam-policy"></a>

Note that the following information applies to permissions that the AWS Toolkit for JetBrains needs, which is different from [permissions that Amazon ECS needs](#ecs-task-role)\. 

When setting up to debug code in Amazon ECS clusters, we strongly recommend that you follow the AWS security best practice of [granting least privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege)\. Granting least privilege means granting only the permissions required to perform a task\. To grant least privilege for debugging code in Amazon ECS clusters, you must attach a specific IAM customer managed policy as follows to an IAM entity \(such as an IAM user, group, or role\)\. This IAM entity must be associated with the credentials that you specify when you [connect to the AWS Toolkit for JetBrains](setup-credentials.md)\.

In the following policy statement, permission is granted to two Amazon ECS services named `MyService` and `MyOtherService` as well as to two Amazon ECS task roles named `MyTaskRole` and `MyOtherTaskRole` and two Amazon ECS execution task roles named `MyExecutionTaskRole` and `MyOtherExecutionTaskRole`\. Change the names of these example services and task roles to match your own, and then attach this policy to the appropriate IAM entity\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AllowedECSServices",
            "Effect": "Allow",
            "Action": [
                "ecs:UpdateService"
            ],
            "Resource": [
                "arn:aws:ecs:*:*:service/*/cloud-debug-*",
                "arn:aws:ecs:*:*:service/*/MyService",
                "arn:aws:ecs:*:*:service/*/MyOtherService"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "iam:GetRole",
                "iam:ListRoles",
                "iam:SimulatePrincipalPolicy"
            ],
            "Resource": "*"
        },
        {
            "Sid": "AllowedIAMRoles",
            "Effect": "Allow",
            "Action": [
                "iam:PassRole"
            ],
            "Resource": [
                "arn:aws:iam::*:role/MyTaskExecutionRole",
                "arn:aws:iam::*:role/MyOtherTaskExecutionRole",
                "arn:aws:iam::*:role/MyTaskRole",
                "arn:aws:iam::*:role/MyOtherRole"
            ],
            "Condition": {
                "StringEquals": {
                    "iam:PassedToService": "ecs-tasks.amazonaws.com"
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": [
                "iam:PassRole"
            ],
            "Resource": [
                "arn:aws:iam::*:role/aws-service-role/ecs.amazonaws.com/AWSServiceRoleForECS"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "s3:CreateBucket",
                "s3:GetObject",
                "s3:PutObject",
                "s3:DeleteObject",
                "s3:ListBucket"
            ],
            "Resource": "arn:aws:s3:::do-not-delete-cloud-debug-*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "ecs:ListClusters",
                "ecs:ListServices",
                "ecs:DescribeServices",
                "ecs:ListTasks",
                "ecs:DescribeTasks",
                "ecs:DescribeTaskDefinition",
                "elasticloadbalancing:DescribeListeners",
                "elasticloadbalancing:DescribeRules",
                "elasticloadbalancing:DescribeTargetGroups",
                "ecr:GetAuthorizationToken",
                "ecr:BatchCheckLayerAvailability",
                "ecr:GetDownloadUrlForLayer",
                "ecr:BatchGetImage"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "logs:CreateLogGroup",
                "logs:CreateLogStream"
            ],
            "Resource": [
                "arn:aws:logs:*:*:cloud-debug*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "ecs:CreateService",
                "ecs:DeleteService"
            ],
            "Resource": "arn:aws:ecs:*:*:service/*/cloud-debug*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "ecs:RegisterTaskDefinition"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "elasticloadbalancing:ModifyListener",
                "elasticloadbalancing:ModifyRule",
                "elasticloadbalancing:ModifyTargetGroupAttributes"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "elasticloadbalancing:CreateTargetGroup",
                "elasticloadbalancing:DeleteTargetGroup"
            ],
            "Resource": "arn:aws:elasticloadbalancing:*:*:targetgroup/cloud-debug*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "ssm:StartSession",
                "ssm:TerminateSession",
                "ssm:ResumeSession",
                "ssm:DescribeSessions",
                "ssm:GetConnectionStatus"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "application-autoscaling:RegisterScalableTarget",
                "application-autoscaling:DeregisterScalableTarget",
                "application-autoscaling:DescribeScalableTargets"
            ],
            "Resource": "*"
        }
    ]
}
```

You can use tools such as the IAM console within the AWS Management Console to [create an IAM customer managed policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-start) and then [add the policy to the appropriate IAM entity](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_manage-attach-detach.html#add-policies-console) \(such as an IAM user, group, or role\)\.