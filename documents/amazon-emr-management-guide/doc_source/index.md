# Amazon EMR Management Guide

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
+ [What Is Amazon EMR?](emr-what-is-emr.md)
   + [Overview of Amazon EMR](emr-overview.md)
   + [Benefits of Using Amazon EMR](emr-overview-benefits.md)
   + [Overview of Amazon EMR Architecture](emr-overview-arch.md)
+ [Getting Started: Analyzing Big Data with Amazon EMR](emr-gs.md)
   + [Step 1: Set Up Prerequisites for Your Sample Cluster](emr-gs-prerequisites.md)
   + [Step 2: Launch Your Sample Amazon EMR Cluster](emr-gs-launch-sample-cluster.md)
   + [Step 3: Allow SSH Connections to the Cluster From Your Client](emr-gs-ssh.md)
   + [Step 4: Process Data By Running The Hive Script as a Step](emr-gs-process-sample-data.md)
   + [Step 5: Terminate the Cluster and Delete the Bucket](emr-gs-reset-environment.md)
+ [Using Amazon EMR Notebooks](emr-managed-notebooks.md)
   + [Considerations When Using EMR Notebooks](emr-managed-notebooks-considerations.md)
   + [Creating a Notebook](emr-managed-notebooks-create.md)
   + [Creating Amazon EMR Clusters for Notebooks](emr-managed-notebooks-cluster.md)
   + [Working with Notebooks](emr-managed-notebooks-working-with.md)
   + [Monitoring Spark User and Job Activity](emr-managed-notebooks-spark-monitor.md)
   + [EMR Notebooks Security and Access Control](emr-managed-notebooks-security.md)
   + [Using Notebook-Scoped Libraries](emr-managed-notebooks-scoped-libraries.md)
   + [Associate Git Repositories with Amazon EMR Notebooks](emr-git-repo.md)
      + [Add a Git Repository to Amazon EMR](emr-git-repo-add.md)
      + [Update or Delete a Git Repository](emr-git-repo-delete.md)
      + [Link or Unlink a Git Repository](emr-git-repo-link.md)
      + [Create a New Notebook with an Associated Git Repository](emr-git-repo-create-notebook.md)
      + [Use Git Repositories in a Notebook](emr-git-repo-open.md)
+ [Plan and Configure Clusters](emr-plan.md)
   + [Configure Cluster Location and Data Storage](emr-cluster-location-data-storage.md)
      + [Choose an AWS Region](emr-plan-region.md)
      + [Work with Storage and File Systems](emr-plan-file-systems.md)
      + [Prepare Input Data](emr-plan-input.md)
         + [Types of Input Amazon EMR Can Accept](emr-plan-input-accept.md)
         + [How to Get Data Into Amazon EMR](emr-plan-get-data-in.md)
            + [Upload Data to Amazon S3](emr-plan-upload-s3.md)
            + [Import files with Distributed Cache](emr-plan-input-distributed-cache.md)
            + [How to Process Compressed Files](HowtoProcessGzippedFiles.md)
            + [Import DynamoDB Data into Hive](emr-plan-input-dynamodb.md)
            + [Connect to Data with AWS DirectConnect](emr-plan-input-directconnect.md)
            + [Upload Large Amounts of Data with AWS Import/Export](emr-plan-input-import-export.md)
      + [Configure an Output Location](emr-plan-output.md)
         + [What formats can Amazon EMR return?](emr-plan-output-formats.md)
         + [How to write data to an Amazon S3 bucket you don't own](emr-s3-acls.md)
         + [Compress the Output of your Cluster](emr-plan-output-compression.md)
   + [Plan and Configure Master Nodes](emr-plan-ha.md)
      + [Supported Applications and Features](emr-plan-ha-applications.md)
      + [Launching an EMR Cluster with Multiple Master Nodes](emr-plan-ha-launch.md)
      + [Considerations and Best Practices](emr-plan-ha-considerations.md)
   + [EMR Clusters on AWS Outposts](emr-plan-outposts.md)
   + [Use EMR File System (EMRFS)](emr-fs.md)
      + [Consistent View](emr-plan-consistent-view.md)
         + [Enable Consistent View](enable-consistent-view.md)
         + [Understanding How EMRFS Consistent View Tracks Objects in Amazon S3](emrfs-files-tracked.md)
         + [Retry Logic](emrfs-retry-logic.md)
         + [EMRFS Consistent View Metadata](emrfs-metadata.md)
         + [Configure Consistency Notifications for CloudWatch and Amazon SQS](emrfs-configure-sqs-cw.md)
         + [Configure Consistent View](emrfs-configure-consistent-view.md)
         + [EMRFS CLI Reference](emrfs-cli-reference.md)
      + [Authorizing Access to EMRFS Data in Amazon S3](emr-plan-credentialsprovider.md)
      + [Specifying Amazon S3 Encryption Using EMRFS Properties](emr-emrfs-encryption.md)
         + [Amazon S3 Client-Side Encryption](emr-emrfs-encryption-cse.md)
   + [Control Cluster Termination](emr-plan-termination.md)
      + [Configuring a Cluster to Auto-Terminate or Continue](emr-plan-longrunning-transient.md)
      + [Using Termination Protection](UsingEMR_TerminationProtection.md)
   + [Working with Amazon Linux AMIs in Amazon EMR](emr-ami.md)
      + [Using the Default Amazon Linux AMI for Amazon EMR](emr-default-ami.md)
      + [Using a Custom AMI](emr-custom-ami.md)
      + [Specifying the Amazon EBS Root Device Volume Size](emr-custom-ami-boot-volume-size.md)
   + [Configure Cluster Software](emr-plan-software.md)
      + [Create Bootstrap Actions to Install Additional Software](emr-plan-bootstrap.md)
   + [Configure Cluster Hardware and Networking](emr-plan-instances.md)
      + [Understanding Master, Core, and Task Nodes](emr-master-core-task-nodes.md)
      + [Configure EC2 Instances](emr-plan-ec2-instances.md)
         + [Supported Instance Types](emr-supported-instance-types.md)
         + [Instance Purchasing Options](emr-instance-purchasing-options.md)
         + [Instance Storage](emr-plan-storage.md)
      + [Configure Networking](emr-plan-vpc-subnet.md)
         + [Amazon VPC Options](emr-clusters-in-a-vpc.md)
         + [Set up a VPC to Host Clusters](emr-vpc-host-job-flows.md)
         + [Launch Clusters into a VPC](emr-vpc-launching-job-flows.md)
         + [Restrict Permissions to a VPC Using IAM](emr-iam-on-vpc.md)
         + [Minimum Amazon S3 Policy for Private Subnet](private-subnet-iampolicy.md)
      + [Create a Cluster with Instance Fleets or Uniform Instance Groups](emr-instance-group-configuration.md)
         + [Configure Instance Fleets](emr-instance-fleet.md)
         + [Configure Uniform Instance Groups](emr-uniform-instance-group.md)
      + [Cluster Configuration Guidelines and Best Practices](emr-plan-instances-guidelines.md)
   + [Configure Cluster Logging and Debugging](emr-plan-debugging.md)
   + [Tag Clusters](emr-plan-tags.md)
      + [Tag Restrictions](emr-plan-tags-restrictions.md)
      + [Tag Resources for Billing](emr-plan-tags-billing.md)
      + [Add Tags to a New Cluster](emr-plan-tags-add-new.md)
      + [Adding Tags to an Existing Cluster](emr-plan-tags-add.md)
      + [View Tags on a Cluster](emr-plan-tags-view.md)
      + [Remove Tags from a Cluster](emr-plan-tags-delete.md)
   + [Drivers and Third-Party Application Integration](emr-plan-third-party.md)
      + [Use Business Intelligence Tools with Amazon EMR](emr-bi-tools.md)
+ [Security in Amazon EMR](emr-security.md)
   + [Use Security Configurations to Set Up Cluster Security](emr-security-configurations.md)
      + [Create a Security Configuration](emr-create-security-configuration.md)
      + [Specify a Security Configuration for a Cluster](emr-specify-security-configuration.md)
   + [Data Protection in Amazon EMR](data-protection.md)
      + [Encrypt Data at Rest and in Transit](emr-data-encryption.md)
         + [Encryption Options](emr-data-encryption-options.md)
         + [Create Keys and Certificates for Data Encryption](emr-encryption-enable.md)
   + [AWS Identity and Access Management for Amazon EMR](emr-plan-access-iam.md)
      + [How Amazon EMR Works with IAM](security_iam_emr-with-iam.md)
      + [Configure IAM Service Roles for Amazon EMR Permissions to AWS Services and Resources](emr-iam-roles.md)
         + [IAM Service Roles Used By Amazon EMR](emr-iam-service-roles.md)
            + [Service Role for Amazon EMR (EMR Role)](emr-iam-role.md)
            + [Service Role for Cluster EC2 Instances (EC2 Instance Profile)](emr-iam-role-for-ec2.md)
            + [Service Role for Automatic Scaling in EMR (Auto Scaling Role)](emr-iam-role-automatic-scaling.md)
            + [Service Role for EMR Notebooks](emr-managed-notebooks-service-role.md)
            + [Using the Service-Linked Role for Amazon EMR](using-service-linked-roles.md)
         + [Customize IAM Roles](emr-iam-roles-custom.md)
         + [Configure IAM Roles for EMRFS Requests to Amazon S3](emr-emrfs-iam-roles.md)
         + [Use Resource-Based Policies for Amazon EMR Access to AWS Glue Data Catalog](emr-iam-roles-glue.md)
         + [Use IAM Roles with Applications That Call AWS Services Directly](emr-iam-roles-calling.md)
         + [Allow Users and Groups to Create and Modify Roles](emr-iam-roles-create-permissions.md)
      + [Amazon EMR Identity-Based Policy Examples](security_iam_id-based-policy-examples.md)
         + [Policy Best Practices for Amazon EMR](security_iam_emr-with-iam-policy-best-practices.md)
         + [Allow Users to View Their Own Permissions](security_iam_id-based-policy-examples-view-own-permissions.md)
         + [Amazon EMR Managed Policies](emr-managed-iam-policies.md)
         + [IAM Policies for Tag-Based Access to Clusters and EMR Notebooks](emr-fine-grained-cluster-access.md)
   + [Authenticate to Amazon EMR Cluster Nodes](emr-authenticate-cluster-connections.md)
      + [Use an Amazon EC2 Key Pair for SSH Credentials](emr-plan-access-ssh.md)
      + [Use Kerberos Authentication](emr-kerberos.md)
         + [Supported Applications](emr-kerberos-principals.md)
         + [Kerberos Architecture Options](emr-kerberos-options.md)
         + [Configuring Kerberos on Amazon EMR](emr-kerberos-configure.md)
            + [Security Configuration and Cluster Settings for Kerberos on Amazon EMR](emr-kerberos-configure-settings.md)
               + [Configuration Examples](emr-kerberos-config-examples.md)
            + [Configuring a Cluster for Kerberos-Authenticated HDFS Users and SSH Connections](emr-kerberos-configuration-users.md)
         + [Using SSH to Connect to Kerberized Clusters](emr-kerberos-connect-ssh.md)
         + [Tutorial: Configure a Cluster-Dedicated KDC](emr-kerberos-cluster-kdc.md)
         + [Tutorial: Configure a Cross-Realm Trust with an Active Directory Domain](emr-kerberos-cross-realm.md)
   + [Integrating Amazon EMR with AWS Lake Formation (Beta)](emr-lake-formation.md)
      + [Conceptual Overview of Amazon EMR Integration with Lake Formation](emr-lf-conceptual.md)
         + [Terms and Concepts](emr-lf-terms.md)
         + [How Access to Data Works in Lake Formation](emr-lf-data.md)
         + [Amazon EMR Components](emr-lf-components.md)
         + [Architecture of SAML-Enabled Single Sign-On and Fine-Grained Access Control](emr-lf-architecture.md)
      + [Supported Applications and Features](emr-lf-scope.md)
      + [Before You Begin](emr-lf-prerequisites.md)
         + [Overview of the IAM Roles for Lake Formation](emr-lf-iam-role.md)
         + [Configure Trust Relationship Between your IdP and Lake Formation](emr-lf-federation.md)
         + [Supported Third-Party Providers for SAML](emr-lf-idp.md)
         + [Configure EMR Security Features](emr-lf-security.md)
      + [Launch an Amazon EMR Cluster with Lake Formation](emr-lf-launch.md)
         + [Launch an Amazon EMR cluster with Lake Formation using the console](emr-lf-console.md)
         + [Launch an Amazon EMR cluster integrated with Lake Formation using the CLI](emr-lf-cli.md)
         + [Update the callback or single sign-on URL in IdP](emr-lf-url.md)
         + [Using Notebooks with Lake Formation](emr-lf-notebook.md)
         + [Customize Proxy Agent Certificate](emr-lf-TLS.md)
   + [Control Network Traffic with Security Groups](emr-security-groups.md)
      + [Working With Amazon EMR-Managed Security Groups](emr-man-sec-groups.md)
      + [Working With Additional Security Groups](emr-additional-sec-groups.md)
      + [Specifying Amazon EMR-Managed and Additional Security Groups](emr-sg-specify.md)
      + [Specifying EC2 Security Groups for EMR Notebooks](emr-managed-notebooks-security-groups.md)
      + [Using Amazon EMR Block Public Access](emr-block-public-access.md)
   + [Compliance Validation for Amazon EMR](emr-compliance.md)
   + [Resilience in Amazon EMR](disaster-recovery-resiliency.md)
   + [Infrastructure Security in Amazon EMR](infrastructure-security.md)
      + [Connect to Amazon EMR Using an Interface VPC Endpoint](interface-vpc-endpoint.md)
+ [Manage Clusters](emr-manage.md)
   + [View and Monitor a Cluster](emr-manage-view.md)
      + [View Cluster Status and Details](emr-manage-view-clusters.md)
      + [Enhanced Step Debugging](emr-enhanced-step-debugging.md)
      + [View Application History](emr-cluster-application-history.md)
         + [One-click Access to Persistent Spark History Server](app-history-spark-UI.md)
         + [View a Summary of Application History](app-history-summary.md)
      + [View Log Files](emr-manage-view-web-log-files.md)
      + [View Cluster Instances in Amazon EC2](UsingEMR_Tagging.md)
      + [CloudWatch Events and Metrics](emr-manage-cluster-cloudwatch.md)
         + [Monitor CloudWatch Events](emr-manage-cloudwatch-events.md)
         + [Monitor Metrics with CloudWatch](UsingEMR_ViewingMetrics.md)
      + [View Cluster Application Metrics with Ganglia](ViewingGangliaMetrics.md)
      + [Logging Amazon EMR API Calls in AWS CloudTrail](logging_emr_api_calls.md)
   + [Connect to the Cluster](emr-connect-master-node.md)
      + [Connect to the Master Node Using SSH](emr-connect-master-node-ssh.md)
      + [View Web Interfaces Hosted on Amazon EMR Clusters](emr-web-interfaces.md)
         + [Option 1: Set Up an SSH Tunnel to the Master Node Using Local Port Forwarding](emr-ssh-tunnel-local.md)
         + [Option 2, Part 1: Set Up an SSH Tunnel to the Master Node Using Dynamic Port Forwarding](emr-ssh-tunnel.md)
         + [Option 2, Part 2: Configure Proxy Settings to View Websites Hosted on the Master Node](emr-connect-master-node-proxy.md)
         + [Access the Web Interfaces on the Master Node Using the Console](emr-connect-ui-console.md)
   + [Terminate a Cluster](UsingEMR_TerminateJobFlow.md)
   + [Scaling Cluster Resources](emr-scale-on-demand.md)
      + [Using Automatic Scaling in Amazon EMR](emr-automatic-scaling.md)
      + [Manually Resizing a Running Cluster](emr-manage-resize.md)
      + [Cluster Scale-Down](emr-scaledown-behavior.md)
   + [Cloning a Cluster Using the Console](clone-console.md)
   + [Submit Work to a Cluster](AddingStepstoaJobFlow.md)
      + [Work with Steps Using the AWS CLI and Console](emr-work-with-steps.md)
         + [Adding Steps to a Cluster Using the Console](emr-add-steps-console.md)
         + [Adding Steps to a Cluster Using the AWS CLI](add-step-cli.md)
         + [Considerations for Running Multiple Steps in Parallel](emr-concurrent-steps.md)
         + [Viewing Steps](emr-view-steps.md)
         + [Canceling Steps](emr-cancel-steps.md)
      + [Submit Hadoop Jobs Interactively](interactive-jobs.md)
      + [Add More than 256 Steps to a Cluster](AddMoreThan256Steps.md)
   + [Automate Recurring Clusters with AWS Data Pipeline](emr-manage-recurring.md)
+ [Troubleshoot a Cluster](emr-troubleshoot.md)
   + [What Tools are Available for Troubleshooting?](emr-troubleshoot-tools.md)
   + [Viewing and Restarting Amazon EMR and Application Processes (Daemons)](emr-process-restart-stop-view.md)
   + [Troubleshoot a Failed Cluster](emr-troubleshoot-failed.md)
      + [Step 1: Gather Data About the Issue](emr-troubleshoot-failed-1.md)
      + [Step 2: Check the Environment](emr-troubleshoot-failed-2.md)
      + [Step 3: Look at the Last State Change](emr-troubleshoot-failed-3.md)
      + [Step 4: Examine the Log Files](emr-troubleshoot-failed-4.md)
      + [Step 5: Test the Cluster Step by Step](emr-troubleshoot-failed-5-test-steps.md)
   + [Troubleshoot a Slow Cluster](emr-troubleshoot-slow.md)
      + [Step 1: Gather Data About the Issue](emr-troubleshoot-slow-1.md)
      + [Step 2: Check the Environment](emr-troubleshoot-slow-2.md)
      + [Step 3: Examine the Log Files](emr-troubleshoot-slow-3.md)
      + [Step 4: Check Cluster and Instance Health](emr-troubleshoot-slow-4.md)
      + [Step 5: Check for Arrested Groups](emr-troubleshoot-slow-5.md)
      + [Step 6: Review Configuration Settings](emr-troubleshoot-slow-6.md)
      + [Step 7: Examine Input Data](emr-troubleshoot-slow-7.md)
   + [Common Errors in Amazon EMR](emr-troubleshoot-errors.md)
      + [Input and Output Errors](emr-troubleshoot-errors-io.md)
      + [Permissions Errors](emr-troubleshoot-error-permissions.md)
      + [Resource Errors](emr-troubleshoot-error-resource.md)
         + [Cluster Terminates With NO_SLAVE_LEFT and Core Nodes FAILED_BY_MASTER](emr-cluster-NO_SLAVE_LEFT-FAILED_BY_MASTER.md)
         + [Cannot replicate block, only managed to replicate to zero nodes.](enough-hdfs-space.md)
         + [EC2 QUOTA EXCEEDED](emr-EC2.md)
         + [Too many fetch-failures](emr-troubleshoot-error-resource-1.md)
         + [File could only be replicated to 0 nodes instead of 1](emr-troubleshoot-error-resource-2.md)
         + [Blacklisted Nodes](emr-troubleshoot-error-resource-3.md)
         + [Throttling Errors](emr-throttling-error.md)
         + [Instance Type Not Supported](emr-INSTANCE_TYPE_NOT_SUPPORTED-error.md)
         + [EC2 is Out of Capacity](emr-EC2_INSUFFICIENT_CAPACITY-error.md)
      + [Streaming Cluster Errors](emr-troubleshoot-error-streaming.md)
      + [Custom JAR Cluster Errors](emr-troubleshoot-error-custom-jar.md)
      + [Hive Cluster Errors](emr-troubleshoot-error-hive.md)
      + [VPC Errors](emr-troubleshoot-error-vpc.md)
      + [AWS GovCloud (US-West) Errors](emr-troubleshoot-error-govcloud.md)
   + [Troubleshoot a Lake Formation Cluster (Beta)](emr-troubleshoot-lf.md)
+ [Write Applications that Launch and Manage Clusters](making_api_requests.md)
   + [End-to-End Amazon EMR Java Source Code Sample](emr-common-programming-sample.md)
   + [Common Concepts for API Calls](emr-common-programming-concepts.md)
   + [Use SDKs to Call Amazon EMR APIs](call-emr-using-sdks.md)
      + [Using the AWS SDK for Java to Create an Amazon EMR Cluster](calling-emr-with-java-sdk.md)
+ [AWS Glossary](glossary.md)