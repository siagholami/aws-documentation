# Amazon Elastic Container Service Developer Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [What is Amazon Elastic Container Service?](Welcome.md)
+ [Setting up with Amazon ECS](get-set-up-for-amazon-ecs.md)
+ [Getting started with Amazon ECS](getting-started.md)
   + [Docker basics for Amazon ECS](docker-basics.md)
   + [Getting started with Amazon ECS using Amazon EC2](getting-started-ecs-ec2.md)
   + [Getting started with Amazon ECS using Fargate](getting-started-fargate.md)
+ [Amazon ECS on AWS Fargate](AWS_Fargate.md)
   + [AWS Fargate platform versions](platform_versions.md)
      + [AWS Fargate platform versions scheduled for deprecation](platform-versions-retired.md)
+ [Amazon ECS clusters](clusters.md)
   + [Creating a cluster](create_cluster.md)
   + [Amazon ECS capacity providers](cluster-capacity-providers.md)
      + [Auto Scaling group capacity providers](asg-capacity-providers.md)
      + [AWS Fargate capacity providers](fargate-capacity-providers.md)
   + [Amazon ECS cluster auto scaling](cluster-auto-scaling.md)
   + [Amazon ECS clusters in Local Zones, Wavelength Zones, and AWS Outposts](cluster-regions-zones.md)
   + [Updating cluster settings](update-cluster-settings.md)
   + [Deleting a cluster](delete_cluster.md)
+ [Amazon ECS Task definitions](task_definitions.md)
   + [Application architecture](application_architecture.md)
   + [Creating a task definition](create-task-definition.md)
   + [Task definition parameters](task_definition_parameters.md)
   + [Amazon ECS launch types](launch_types.md)
   + [Working with GPUs on Amazon ECS](ecs-gpu.md)
   + [Working with inference workloads on Amazon ECS](ecs-inference.md)
   + [Using data volumes in tasks](using_data_volumes.md)
      + [Fargate Task Storage](fargate-task-storage.md)
      + [Docker volumes](docker-volumes.md)
      + [Bind mounts](bind-mounts.md)
      + [Amazon EFS volumes](efs-volumes.md)
   + [Managing container swap space](container-swap.md)
   + [Task Networking with the awsvpc Network Mode](task-networking.md)
   + [Using the awslogs Log Driver](using_awslogs.md)
   + [Custom log routing](using_firelens.md)
   + [Private registry authentication for tasks](private-auth.md)
   + [Specifying sensitive data](specifying-sensitive-data.md)
      + [Specifying sensitive data using Secrets Manager](specifying-sensitive-data-secrets.md)
      + [Specifying sensitive data using Systems Manager Parameter Store](specifying-sensitive-data-parameters.md)
   + [Specifying environment variables](taskdef-envfiles.md)
   + [Example task definitions](example_task_definitions.md)
   + [Updating a task definition](update-task-definition.md)
   + [Deregistering task definition revisions](deregister-task-definition.md)
+ [Account settings](ecs-account-settings.md)
   + [Viewing account settings](ecs-viewing-longer-id-settings.md)
   + [Modifying account settings](ecs-modifying-longer-id-settings.md)
+ [Amazon ECS container instances](ECS_instances.md)
   + [Amazon ECS-optimized AMIs](ecs-optimized_AMI.md)
      + [Retrieving Amazon ECS-Optimized AMI metadata](retrieve-ecs-optimized_AMI.md)
      + [Subscribing to Amazon ECS-optimized AMI update notifications](ECS-AMI-SubscribeTopic.md)
      + [Amazon ECS-optimized AMI versions](ecs-ami-versions.md)
      + [AMI storage configuration](ecs-ami-storage-config.md)
   + [Using Bottlerocket with Amazon ECS](ecs-bottlerocket.md)
   + [Launching an Amazon ECS Container Instance](launch_container_instance.md)
      + [Using Spot Instances](container-instance-spot.md)
   + [Bootstrapping Container Instances with Amazon EC2 User Data](bootstrap_container_instance.md)
      + [Example Container Instance User Data Configuration Scripts](example_user_data_scripts.md)
   + [Elastic network interface trunking](container-instance-eni.md)
   + [Container Instance Memory Management](memory-management.md)
   + [Connect to your container instance](instance-connect.md)
   + [Using CloudWatch Logs with container instances](using_cloudwatch_logs.md)
   + [Container instance draining](container-instance-draining.md)
   + [Manage container instances remotely using AWS Systems Manager](ec2-run-command.md)
   + [Starting a task at container instance launch time](start_task_at_launch.md)
   + [Deregister a container instance](deregister_container_instance.md)
+ [Amazon ECS Container Agent](ECS_agent.md)
   + [Installing the Amazon ECS Container Agent](ecs-agent-install.md)
   + [Amazon ECS Container Agent Versions](ecs-agent-versions.md)
   + [Updating the Amazon ECS Container Agent](ecs-agent-update.md)
      + [Updating the Amazon ECS Container Agent on an Amazon ECS-optimized AMI](agent-update-ecs-ami.md)
      + [Manually Updating the Amazon ECS Container Agent (for Non-Amazon ECS-Optimized AMIs)](manually_update_agent.md)
   + [Amazon ECS Container Agent Configuration](ecs-agent-config.md)
   + [Private Registry Authentication for Container Instances](private-auth-container-instances.md)
   + [Automated Task and Image Cleanup](automated_image_cleanup.md)
   + [Amazon ECS Container Metadata File](container-metadata.md)
   + [Amazon ECS Task metadata endpoint](task-metadata-endpoint.md)
      + [Task metadata endpoint version 4](task-metadata-endpoint-v4.md)
      + [Task Metadata Endpoint version 3](task-metadata-endpoint-v3.md)
      + [Task Metadata Endpoint version 2](task-metadata-endpoint-v2.md)
   + [Amazon ECS Container Agent Introspection](ecs-agent-introspection.md)
   + [HTTP Proxy Configuration](http_proxy_config.md)
+ [Scheduling Amazon ECS tasks](scheduling_tasks.md)
   + [Running tasks](ecs_run_task.md)
      + [Running a task using the Fargate launch type](ecs_run_task_fargate.md)
      + [Running a task using the EC2 launch type](ecs_run_task_ec2.md)
   + [Amazon ECS task placement](task-placement.md)
      + [Amazon ECS task placement strategies](task-placement-strategies.md)
      + [Amazon ECS task placement constraints](task-placement-constraints.md)
      + [Cluster query language](cluster-query-language.md)
   + [Scheduled tasks (cron)](scheduled_tasks.md)
   + [Task lifecycle](task-lifecycle.md)
   + [Task retirement](task-retirement.md)
   + [Fargate task recycling](task-recycle.md)
   + [Creating a scheduled task using the AWS CLI](scheduled_tasks_cli_tutorial.md)
+ [Amazon ECS services](ecs_services.md)
   + [Service definition parameters](service_definition_parameters.md)
   + [Creating a service](create-service.md)
      + [Step 1: Configuring Basic Service Parameters](basic-service-params.md)
      + [Step 2: Configure a Network](service-configure-network.md)
      + [Step 3: Configuring Your Service to Use a Load Balancer](service-create-loadbalancer.md)
         + [Configuring a Load Balancer for the Rolling Update Deployment Type](service-create-loadbalancer-rolling.md)
         + [Configuring a Load Balancer for the Blue/Green Deployment Type](service-create-loadbalancer-bluegreen.md)
      + [Step 4: Configuring Your Service to Use Service Discovery](service-configure-servicediscovery.md)
      + [Step 5: Configuring your service to use Service Auto Scaling](service-configure-auto-scaling.md)
      + [Step 6: Review and create your service](create-service-review.md)
   + [Updating a service](update-service.md)
   + [Deleting a service](delete-service.md)
   + [Amazon ECS Deployment types](deployment-types.md)
      + [Rolling update](deployment-type-ecs.md)
      + [Blue/Green deployment with CodeDeploy](deployment-type-bluegreen.md)
      + [External Deployment](deployment-type-external.md)
   + [Service load balancing](service-load-balancing.md)
      + [Load balancer types](load-balancer-types.md)
      + [Creating a load balancer](create-load-balancer.md)
         + [Creating the service role for your account](check-service-role.md)
         + [Creating an Application Load Balancer](create-application-load-balancer.md)
         + [Creating a Network Load Balancer](create-network-load-balancer.md)
         + [Creating a Classic Load Balancer](create-standard-load-balancer.md)
      + [Registering multiple target groups with a service](register-multiple-targetgroups.md)
   + [Service Auto Scaling](service-auto-scaling.md)
      + [Target Tracking Scaling Policies](service-autoscaling-targettracking.md)
      + [Step Scaling Policies](service-autoscaling-stepscaling.md)
   + [Service Discovery](service-discovery.md)
   + [Service throttle logic](service-throttle-logic.md)
+ [Resources and tags](ecs-resource-tagging.md)
   + [Tagging your Amazon ECS resources](ecs-using-tags.md)
   + [Amazon ECS service quotas](service-quotas.md)
   + [Amazon ECS usage reports](usage-reports.md)
+ [Monitoring Amazon ECS](ecs_monitoring.md)
   + [Monitoring tools](monitoring-automated-manual.md)
   + [Amazon ECS CloudWatch metrics](cloudwatch-metrics.md)
      + [Viewing Amazon ECS metrics](viewing_cloudwatch_metrics.md)
      + [Tutorial: Scaling container instances with CloudWatch alarms](cloudwatch_alarm_autoscaling.md)
   + [Amazon ECS events and EventBridge](cloudwatch_event_stream.md)
      + [Amazon ECS events](ecs_cwe_events.md)
      + [Handling events](ecs_cwet_handling.md)
   + [Amazon ECS CloudWatch Container Insights](cloudwatch-container-insights.md)
   + [Logging Amazon ECS API calls with AWS CloudTrail](logging-using-cloudtrail.md)
+ [Security in Amazon Elastic Container Service](security.md)
   + [Identity and access management for Amazon Elastic Container Service](security-iam.md)
      + [How Amazon Elastic Container Service Works with IAM](security_iam_service-with-iam.md)
      + [Amazon Elastic Container Service Identity-Based Policy Examples](security_iam_id-based-policy-examples.md)
      + [Supported Resource-Level Permissions for Amazon ECS API Actions](ecs-supported-iam-actions-resources.md)
      + [Managed Policies and Trust Relationships](managed_policies.md)
         + [Amazon ECS Managed Policies and Trust Relationships](ecs_managed_policies.md)
         + [Amazon ECR Managed Policies](ecr_managed_policies.md)
      + [Service-Linked Role for Amazon ECS](using-service-linked-roles.md)
         + [Legacy IAM Roles for Amazon ECS](ecs-legacy-iam-roles.md)
      + [Amazon ECS task execution IAM role](task_execution_IAM_role.md)
      + [Amazon ECS Container Instance IAM Role](instance_IAM_role.md)
      + [IAM Roles for Tasks](task-iam-roles.md)
      + [Amazon ECS CodeDeploy IAM Role](codedeploy_IAM_role.md)
      + [Amazon ECS CloudWatch Events IAM Role](CWE_IAM_role.md)
      + [Troubleshooting Amazon Elastic Container Service Identity and Access](security_iam_troubleshoot.md)
   + [Logging and Monitoring in Amazon Elastic Container Service](ecs-logging-monitoring.md)
   + [Compliance Validation for Amazon Elastic Container Service](ecs-compliance.md)
   + [Infrastructure Security in Amazon Elastic Container Service](infrastructure-security.md)
      + [Amazon ECS interface VPC endpoints (AWS PrivateLink)](vpc-endpoints.md)
+ [Using the AWS Copilot command line interface](AWS_Copilot.md)
   + [Getting started with AWS Copilot by deploying an Amazon ECS application](getting-started-aws-copilot-cli.md)
+ [Using the Amazon ECS Command Line Interface](ECS_CLI.md)
   + [Installing the Amazon ECS CLI](ECS_CLI_installation.md)
   + [Configuring the Amazon ECS CLI](ECS_CLI_Configuration.md)
   + [Migrating Configuration Files](ECS_CLI_migrating_config_files.md)
   + [Tutorial: Creating a Cluster with a Fargate Task Using the Amazon ECS CLI](ecs-cli-tutorial-fargate.md)
   + [Tutorial: Creating a Cluster with an EC2 Task Using the Amazon ECS CLI](ecs-cli-tutorial-ec2.md)
   + [Tutorial: Creating an Amazon ECS Service That Uses Service Discovery Using the Amazon ECS CLI](ecs-cli-tutorial-servicediscovery.md)
   + [Amazon ECS Command Line Reference](ECS_CLI_reference.md)
      + [ecs-cli](cmd-ecs-cli.md)
      + [ecs-cli configure](cmd-ecs-cli-configure.md)
         + [ecs-cli configure default](cmd-ecs-cli-configure-default.md)
         + [ecs-cli configure profile](cmd-ecs-cli-configure-profile.md)
         + [ecs-cli configure profile default](cmd-ecs-cli-configure-profile-default.md)
         + [ecs-cli configure migrate](cmd-ecs-cli-configure-migrate.md)
      + [ecs-cli up](cmd-ecs-cli-up.md)
      + [ecs-cli down](cmd-ecs-cli-down.md)
      + [ecs-cli scale](cmd-ecs-cli-scale.md)
      + [ecs-cli ps](cmd-ecs-cli-ps.md)
      + [ecs-cli push](cmd-ecs-cli-push.md)
      + [ecs-cli pull](cmd-ecs-cli-pull.md)
      + [ecs-cli images](cmd-ecs-cli-images.md)
      + [ecs-cli license](cmd-ecs-cli-license.md)
      + [ecs-cli compose](cmd-ecs-cli-compose.md)
         + [ecs-cli compose create](cmd-ecs-cli-compose-create.md)
         + [ecs-cli compose start](cmd-ecs-cli-compose-start.md)
         + [ecs-cli compose up](cmd-ecs-cli-compose-up.md)
      + [ecs-cli compose service](cmd-ecs-cli-compose-service.md)
         + [ecs-cli compose service create](cmd-ecs-cli-compose-service-create.md)
         + [ecs-cli compose service start](cmd-ecs-cli-compose-service-start.md)
         + [ecs-cli compose service up](cmd-ecs-cli-compose-service-up.md)
         + [ecs-cli compose service ps, list](cmd-ecs-cli-compose-service-ps.md)
         + [ecs-cli compose service scale](cmd-ecs-cli-compose-service-scale.md)
         + [ecs-cli compose service stop](cmd-ecs-cli-compose-service-stop.md)
         + [ecs-cli compose service rm, delete, down](cmd-ecs-cli-compose-service-rm.md)
      + [ecs-cli logs](cmd-ecs-cli-logs.md)
      + [ecs-cli check-attributes](cmd-ecs-cli-check-attributes.md)
      + [ecs-cli registry-creds](cmd-ecs-cli-registry-creds.md)
         + [ecs-cli registry-creds up](cmd-ecs-cli-registry-creds-up.md)
      + [ecs-cli local](cmd-ecs-cli-local.md)
         + [ecs-cli local create](cmd-ecs-cli-local-create.md)
         + [ecs-cli local up](cmd-ecs-cli-local-up.md)
         + [ecs-cli local down](cmd-ecs-cli-local-down.md)
         + [ecs-cli local ps](cmd-ecs-cli-local-ps.md)
      + [Using Docker Compose File Syntax](cmd-ecs-cli-compose-parameters.md)
      + [Using Amazon ECS Parameters](cmd-ecs-cli-compose-ecsparams.md)
+ [Common Use Cases in Amazon ECS](common_use_cases.md)
+ [AWS services integrated with Amazon ECS](ecs-integrations.md)
   + [Using Amazon ECR with Amazon ECS](ecr-repositories.md)
   + [Creating Amazon ECS resources with AWS CloudFormation](creating-resources-with-cloudformation.md)
   + [Amazon Elastic Container Service on AWS Outposts](ecs-on-outposts.md)
   + [Getting started with AWS App Mesh and Amazon ECS](appmesh-getting-started.md)
   + [AWS Deep Learning Containers on Amazon ECS](deep-learning-containers.md)
+ [Tutorials for Amazon ECS](ecs-tutorials.md)
   + [Tutorial: Creating a VPC with Public and Private Subnets for Your Clusters](create-public-private-vpc.md)
   + [Tutorial: Creating a Cluster with a Fargate Task Using the AWS CLI](ECS_AWSCLI_Fargate.md)
   + [Tutorial: Creating a cluster with an EC2 task using the AWS CLI](ECS_AWSCLI_EC2.md)
   + [Tutorial: Using cluster auto scaling with the AWS Management Console](tutorial-cluster-auto-scaling-console.md)
   + [Tutorial: Using cluster auto scaling with the AWS CLI](tutorial-cluster-auto-scaling-cli.md)
   + [Tutorial: Specifying sensitive data using Secrets Manager secrets](specifying-sensitive-data-tutorial.md)
   + [Tutorial: Creating a service using Service Discovery](create-service-discovery.md)
   + [Tutorial: Creating a service using a blue/green deployment](create-blue-green.md)
   + [Tutorial: Listening for Amazon ECS CloudWatch Events](ecs_cwet.md)
   + [Tutorial: Sending Amazon Simple Notification Service alerts for task stopped events](ecs_cwet2.md)
   + [Tutorial: Using Amazon EFS file systems with Amazon ECS](tutorial-efs-volumes.md)
+ [Amazon ECS troubleshooting](troubleshooting.md)
   + [Checking stopped tasks for errors](stopped-task-errors.md)
   + [CannotPullContainer task errors](task_cannot_pull_image.md)
   + [Service event messages](service-event-messages.md)
   + [Invalid CPU or memory value specified](task-cpu-memory-error.md)
   + [CannotCreateContainerError: API error (500): devmapper](CannotCreateContainerError.md)
   + [Troubleshooting service load balancers](troubleshoot-service-load-balancers.md)
   + [Troubleshooting service auto scaling](troubleshoot-service-auto-scaling.md)
   + [Enabling Docker debug output](docker-debug-mode.md)
   + [Amazon ECS Log File Locations](logs.md)
   + [Amazon ECS logs collector](ecs-logs-collector.md)
   + [Agent introspection diagnostics](introspection-diag.md)
   + [Docker diagnostics](docker-diags.md)
   + [AWS Fargate throttling limits](throttling.md)
   + [API failure reasons](api_failures_messages.md)
   + [Troubleshooting IAM Roles for Tasks](troubleshoot-task-iam-roles.md)
+ [Windows containers](ECS_Windows.md)
   + [Getting started with Windows containers](ECS_Windows_getting_started.md)
   + [Windows task definitions](windows_task_definitions.md)
   + [Windows IAM roles for tasks](windows_task_IAM_roles.md)
   + [Pushing Windows images to Amazon ECR](windows_ecr.md)
   + [Using gMSAs for Windows Containers](windows-gmsa.md)
+ [Document history](document_history.md)
+ [AWS glossary](glossary.md)