# Amazon CloudWatch User Guide

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
+ [What Is Amazon CloudWatch?](WhatIsCloudWatch.md)
   + [How Amazon CloudWatch Works](cloudwatch_architecture.md)
   + [Amazon CloudWatch Concepts](cloudwatch_concepts.md)
   + [Amazon CloudWatch Resources](RelatedResources.md)
+ [Getting Set Up](GettingSetup.md)
+ [Getting Started with Amazon CloudWatch](GettingStarted.md)
   + [See Key Metrics From All AWS Services](CloudWatch_Automatic_Dashboards_Cross_Service.md)
   + [Focus on Metrics and Alarms in a Single AWS Service](CloudWatch_Automatic_Dashboards_Focus_Service.md)
   + [Focus on Metrics and Alarms in a Resource Group](CloudWatch_Automatic_Dashboards_Resource_Group.md)
+ [Using Amazon CloudWatch Dashboards](CloudWatch_Dashboards.md)
   + [Creating a CloudWatch Dashboard](create_dashboard.md)
   + [Cross-Account Cross-Region Dashboards](cloudwatch_xaxr_dashboard.md)
   + [Creating and working with widgets on CloudWatch dashboards](create-and-work-with-widgets.md)
      + [Add or Remove a Graph from a CloudWatch Dashboard](add_remove_graph_dashboard.md)
      + [Move or Resize a Graph on a CloudWatch Dashboard](move_resize_graph_dashboard.md)
      + [Edit a Graph on a CloudWatch Dashboard](edit_graph_dashboard.md)
      + [Graph Metrics Manually on a CloudWatch Dashboard](add_old_metrics_to_graph.md)
      + [Rename a Graph on a CloudWatch Dashboard](rename_graph_dashboard.md)
      + [Add or Remove a Text Widget from a CloudWatch Dashboard](add_remove_text_dashboard.md)
      + [Add an Alarm Widget to a CloudWatch Dashboard](add_remove_alarm_dashboard.md)
      + [Link and Unlink Graphs on a CloudWatch Dashboard](link_unlink_graph_dashboard.md)
   + [Sharing CloudWatch Dashboards](cloudwatch-dashboard-sharing.md)
   + [Use Live Data](cloudwatch-live-data.md)
   + [Add a Dashboard to Your Favorites List](add-dashboard-to-favorites.md)
   + [Change the Period Override Setting or Refresh Interval for the CloudWatch Dashboard](change_dashboard_refresh_interval.md)
   + [Change the Time Range or Time Zone Format of a CloudWatch Dashboard](change_dashboard_time_format.md)
+ [Using Amazon CloudWatch Metrics](working_with_metrics.md)
   + [Viewing Available Metrics](viewing_metrics_with_cloudwatch.md)
   + [Searching for Available Metrics](finding_metrics_with_cloudwatch.md)
   + [Getting Statistics for a Metric](getting-metric-statistics.md)
      + [Getting Statistics for a Specific Resource](US_SingleMetricPerInstance.md)
      + [Aggregating Statistics Across Resources](GetSingleMetricAllDimensions.md)
      + [Aggregating Statistics by Auto Scaling Group](GetMetricAutoScalingGroup.md)
      + [Aggregating Statistics by Amazon Machine Image (AMI)](US_SingleMetricPerAMI.md)
   + [Graphing Metrics](graph_metrics.md)
      + [Graphing a Metric](graph_a_metric.md)
      + [Using Dynamic Labels](graph-dynamic-labels.md)
      + [Modifying the Time Range or Time Zone Format for a Graph](modify_graph_date_time.md)
      + [Modifying the Y-Axis for a Graph](switch_graph_axes.md)
      + [Creating an Alarm from a Metric on a Graph](create_alarm_metric_graph.md)
   + [Publishing Custom Metrics](publishingMetrics.md)
   + [Using Metric Math](using-metric-math.md)
   + [Using Search Expressions in Graphs](using-search-expressions.md)
      + [CloudWatch Search Expression Syntax](search-expression-syntax.md)
      + [CloudWatch Search Expression Examples](search-expression-examples.md)
      + [Creating a CloudWatch Graph with a Search Expression](create-search-expression.md)
+ [Using Amazon CloudWatch Alarms](AlarmThatSendsEmail.md)
   + [Setting Up Amazon SNS Notifications](US_SetupSNS.md)
   + [Create a CloudWatch Alarm Based on a Static Threshold](ConsoleAlarms.md)
   + [Creating a CloudWatch Alarm Based on Anomaly Detection](Create_Anomaly_Detection_Alarm.md)
   + [Creating a CloudWatch Alarm Based on a Metric Math Expression](Create-alarm-on-metric-math-expression.md)
   + [Creating a Composite Alarm](Create_Composite_Alarm.md)
   + [Editing or Deleting a CloudWatch Alarm](Edit-CloudWatch-Alarm.md)
   + [Creating a CPU Usage Alarm That Sends Email](US_AlarmAtThresholdEC2.md)
   + [Creating a Load Balancer Latency Alarm That Sends Email](US_AlarmAtThresholdELB.md)
   + [Creating a Storage Throughput Alarm that Sends Email](US_AlarmAtThresholdEBS.md)
   + [Create Alarms to Stop, Terminate, Reboot, or Recover an Instance](UsingAlarmActions.md)
   + [Creating a Billing Alarm to Monitor Your Estimated AWS Charges](monitor_estimated_charges_with_cloudwatch.md)
   + [Hiding Amazon EC2 Auto Scaling Alarms](hide-autoscaling-alarms.md)
+ [Using Synthetic Monitoring](CloudWatch_Synthetics_Canaries.md)
   + [Required Roles and Permissions for CloudWatch Canaries](CloudWatch_Synthetics_Canaries_Roles.md)
   + [Creating a Canary](CloudWatch_Synthetics_Canaries_Create.md)
      + [Using Canary Blueprints](CloudWatch_Synthetics_Canaries_Blueprints.md)
      + [Canary Runtime Versions](CloudWatch_Synthetics_Canaries_Library.md)
      + [Writing a Canary Script](CloudWatch_Synthetics_Canaries_WritingCanary.md)
      + [Library Functions Available for Canary Scripts](CloudWatch_Synthetics_Canaries_Function_Library.md)
      + [Running a Canary on a VPC](CloudWatch_Synthetics_Canaries_VPC.md)
   + [Viewing Canary Statistics and Details](CloudWatch_Synthetics_Canaries_Details.md)
   + [Editing or Deleting a Canary](synthetics_canaries_deletion.md)
+ [Using ServiceLens to Monitor the Health of Your Applications](ServiceLens.md)
   + [Deploying ServiceLens](deploy_servicelens.md)
      + [Deploying AWS X-Ray](deploy_servicelens_xray.md)
         + [Integrating With CloudWatch Logs](deploy_servicelens_CloudWatch_agent_logintegration.md)
         + [Enabling Segment Metrics From X-Ray](deploy_servicelens_CloudWatch_agent_segments.md)
      + [Deploying the CloudWatch Agent and the X-Ray Daemon](deploy_servicelens_CloudWatch_agent.md)
         + [Deploying the CloudWatch Agent and the X-Ray Daemon on Amazon ECS](deploy_servicelens_CloudWatch_agent_deploy_ECS.md)
         + [Deploying the CloudWatch Agent and the X-Ray Daemon on Amazon EKS or Kubernetes](deploy_servicelens_CloudWatch_agent_deploy_EKS.md)
         + [Deploying the CloudWatch Agent and the X-Ray Daemon on Amazon EC2](deploy_servicelens_CloudWatch_agent_deploy_EC2.md)
   + [Using the Service Map in ServiceLens](servicelens_service_map.md)
   + [Using the Traces View in ServiceLens](servicelens_service_map_traces.md)
   + [ServiceLens Troubleshooting](servicelens_troubleshooting.md)
+ [Cross-Account Cross-Region CloudWatch Console](Cross-Account-Cross-Region.md)
+ [Using CloudWatch Anomaly Detection](CloudWatch_Anomaly_Detection.md)
+ [Using Contributor Insights to Analyze High-Cardinality Data](ContributorInsights.md)
   + [Creating a Contributor Insights Rule](ContributorInsights-CreateRule.md)
   + [Contributor Insights Rule Syntax](ContributorInsights-RuleSyntax.md)
   + [Contributor Insights Rule Examples](ContributorInsights-Rule-Examples.md)
   + [Viewing Contributor Insights Reports](ContributorInsights-ViewReports.md)
   + [Graphing Metrics Generated by Rules](ContributorInsights-GraphReportData.md)
   + [Using Contributor Insights Built-In Rules](ContributorInsights-BuiltInRules.md)
+ [Using Container Insights](ContainerInsights.md)
   + [Setting Up Container Insights](deploy-container-insights.md)
      + [Setting Up Container Insights on Amazon ECS](deploy-container-insights-ECS.md)
         + [Setting Up Container Insights on Amazon ECS for Cluster- and Service-Level Metrics](deploy-container-insights-ECS-cluster.md)
         + [Deploying the CloudWatch Agent to Collect EC2 Instance-Level Metrics on Amazon ECS](deploy-container-insights-ECS-instancelevel.md)
      + [Setting Up Container Insights on Amazon EKS and Kubernetes](deploy-container-insights-EKS.md)
         + [Verify Prerequisites](Container-Insights-prerequisites.md)
         + [Quick Start Setup for Container Insights on Amazon EKS](Container-Insights-setup-EKS-quickstart.md)
         + [Set Up the CloudWatch Agent to Collect Cluster Metrics](Container-Insights-setup-metrics.md)
         + [Set Up FluentD as a DaemonSet to Send Logs to CloudWatch Logs](Container-Insights-setup-logs.md)
         + [(Optional) Set Up Amazon EKS Control Plane Logging](Container-Insights-setup-control-plane-logging.md)
         + [(Optional) Enable App Mesh Envoy Access Logs](ContainerInsights-Prometheus-Sample-Workloads-appmesh-envoy.md)
         + [Updating or Deleting Container Insights on Amazon EKS and Kubernetes](ContainerInsights-update-delete.md)
            + [Updating the CloudWatch Agent Container Image](ContainerInsights-update-image.md)
            + [Deleting the CloudWatch Agent and FluentD for Container Insights](ContainerInsights-delete-agent.md)
   + [Viewing Container Insights Metrics](Container-Insights-view-metrics.md)
   + [Metrics Collected by Container Insights](Container-Insights-metrics.md)
      + [Amazon ECS Container Insights Metrics](Container-Insights-metrics-ECS.md)
      + [Amazon EKS and Kubernetes Container Insights Metrics](Container-Insights-metrics-EKS.md)
   + [Container Insights Performance Log Reference](Container-Insights-reference.md)
      + [Container Insights Performance Log Events for Amazon ECS](Container-Insights-reference-performance-logs-ECS.md)
      + [Container Insights Performance Log Events for Amazon EKS and Kubernetes](Container-Insights-reference-performance-logs-EKS.md)
      + [Relevant Fields in Performance Log Events for Amazon EKS and Kubernetes](Container-Insights-reference-performance-entries-EKS.md)
   + [Container Insights Prometheus Metrics Monitoring](ContainerInsights-Prometheus.md)
      + [Set up the CloudWatch Agent for Prometheus Metrics Collection](ContainerInsights-Prometheus-Setup-overall.md)
         + [Install the CloudWatch Agent with Prometheus Metrics Collection on Amazon ECS clusters](ContainerInsights-Prometheus-Setup-ECS.md)
         + [Install the CloudWatch agent with Prometheus metrics collection on Amazon EKS and Kubernetes clusters](ContainerInsights-Prometheus-Setup.md)
         + [Configuring the CloudWatch Agent for Prometheus Monitoring](ContainerInsights-Prometheus-Setup-configure.md)
         + [(Optional) Set Up Sample Containerized Workloads for Prometheus Metric Testing](ContainerInsights-Prometheus-Sample-Workloads.md)
            + [(Optional) Set Up AWS App Mesh sample workload for Amazon EKS and Kubernetes](ContainerInsights-Prometheus-Sample-Workloads-appmesh.md)
            + [(Optional) Set Up NGINX with Sample Traffic on Amazon EKS and Kubernetes](ContainerInsights-Prometheus-Sample-Workloads-nginx.md)
            + [(Optional) Set Up memcached with a Metric Exporter on Amazon EKS and Kubernetes](ContainerInsights-Prometheus-Sample-Workloads-memcached.md)
            + [(Optional) Set Up Java/JMX sample workload on Amazon EKS and Kubernetes](ContainerInsights-Prometheus-Sample-Workloads-javajmx.md)
            + [(Optional) Set Up HAProxy with a Metric Exporter on Amazon EKS and Kubernetes](ContainerInsights-Prometheus-Sample-Workloads-haproxy.md)
            + [(Optional) Sample App Mesh Workload for Amazon ECS clusters](ContainerInsights-Prometheus-Sample-Workloads-ECS-appmesh.md)
            + [(Optional) Sample Java/JMX Workload for Amazon ECS clusters](ContainerInsights-Prometheus-Sample-Workloads-ECS-javajmx.md)
      + [Prometheus Metrics Collected by the CloudWatch Agent](ContainerInsights-Prometheus-metrics.md)
      + [Viewing Your Prometheus Metrics](ContainerInsights-Prometheus-viewmetrics.md)
      + [Prometheus Metrics Troubleshooting](ContainerInsights-Prometheus-troubleshooting.md)
   + [Troubleshooting Container Insights](ContainerInsights-troubleshooting.md)
   + [Building Your Own CloudWatch Agent Docker Image](ContainerInsights-build-docker-image.md)
   + [Deploying Other CloudWatch Agent Features in Your Containers](ContainerInsights-other-agent-features.md)
+ [Collecting Metrics and Logs from Amazon EC2 Instances and On-Premises Servers with the CloudWatch Agent](Install-CloudWatch-Agent.md)
   + [Installing the CloudWatch Agent](install-CloudWatch-Agent-on-EC2-Instance.md)
      + [Installing the CloudWatch Agent Using the Command Line](installing-cloudwatch-agent-commandline.md)
         + [Download and Configure the CloudWatch Agent Using the Command Line](download-cloudwatch-agent-commandline.md)
         + [Create IAM Roles and Users for Use With CloudWatch Agent](create-iam-roles-for-cloudwatch-agent-commandline.md)
         + [Installing and Running the CloudWatch Agent on Your Servers](install-CloudWatch-Agent-commandline-fleet.md)
      + [Installing the CloudWatch Agent Using AWS Systems Manager](installing-cloudwatch-agent-ssm.md)
         + [Create IAM Roles and Users for Use with the CloudWatch Agent](create-iam-roles-for-cloudwatch-agent.md)
         + [Download and Configure the CloudWatch Agent](download-CloudWatch-Agent-on-EC2-Instance-SSM-first.md)
         + [Installing the CloudWatch Agent on EC2 Instances Using Your Agent Configuration](install-CloudWatch-Agent-on-EC2-Instance-fleet.md)
         + [Installing the CloudWatch Agent on On-Premises Servers](install-CloudWatch-Agent-on-premise.md)
      + [Installing the CloudWatch Agent Using AWS CloudFormation](Install-CloudWatch-Agent-New-Instances-CloudFormation.md)
      + [Verifying the Signature of the CloudWatch Agent Package](verify-CloudWatch-Agent-Package-Signature.md)
   + [Create the CloudWatch Agent Configuration File](create-cloudwatch-agent-configuration-file.md)
      + [Create the CloudWatch Agent Configuration File with the Wizard](create-cloudwatch-agent-configuration-file-wizard.md)
      + [Manually Create or Edit the CloudWatch Agent Configuration File](CloudWatch-Agent-Configuration-File-Details.md)
         + [Collect Process Metrics with the procstat Plugin](CloudWatch-Agent-procstat-process-metrics.md)
         + [Retrieve Custom Metrics with StatsD](CloudWatch-Agent-custom-metrics-statsd.md)
         + [Retrieve Custom Metrics with collectd](CloudWatch-Agent-custom-metrics-collectd.md)
   + [Metrics Collected by the CloudWatch Agent](metrics-collected-by-CloudWatch-agent.md)
   + [Common Scenarios with the CloudWatch Agent](CloudWatch-Agent-common-scenarios.md)
   + [Troubleshooting the CloudWatch Agent](troubleshooting-CloudWatch-Agent.md)
+ [Amazon CloudWatch Application Insights](cloudwatch-application-insights.md)
   + [What Is Amazon CloudWatch Application Insights?](appinsights-what-is.md)
   + [How Amazon CloudWatch Application Insights works](appinsights-how-works.md)
   + [Get started with Amazon CloudWatch Application Insights](appinsights-getting-started.md)
      + [Access CloudWatch Application Insights](appinsights-accessing.md)
      + [Prerequisites](appinsights-prereqs.md)
      + [IAM policy](appinsights-iam.md)
      + [Set up, configure, and manage your application for monitoring](appinsights-setting-up.md)
   + [Work with component configurations](component-config.md)
      + [Component configuration template fragment](component-config-json.md)
      + [Component configuration sections](component-config-sections.md)
      + [Component configuration examples](component-configuration-examples.md)
   + [Create and configure CloudWatch Application Insights monitoring using CloudFormation templates](appinsights-cloudformation.md)
   + [Tutorial: Set up monitors for .NET applications using SQL Server](appinsights-tutorial-dotnet-sql.md)
   + [View and troubleshoot problems detected by Amazon CloudWatch Application Insights](appinsights-troubleshooting.md)
   + [Logs and metrics supported by Amazon CloudWatch Application Insights](appinsights-logs-and-metrics.md)
+ [AWS Services That Publish CloudWatch Metrics](aws-services-cloudwatch-metrics.md)
+ [Alarm Events and EventBridge](cloudwatch-and-eventbridge.md)
+ [Ingesting High-Cardinality Logs and Generating Metrics with CloudWatch Embedded Metric Format](CloudWatch_Embedded_Metric_Format.md)
   + [Generating Logs Using the Embedded Metric Format](CloudWatch_Embedded_Metric_Format_Generation.md)
      + [Using the Client Libraries to Generate Embedded Metric Format Logs](CloudWatch_Embedded_Metric_Format_Libraries.md)
      + [Manually Generating Embedded Metric Format Logs](CloudWatch_Embedded_Metric_Format_Manual.md)
         + [Specification: Embedded Metric Format](CloudWatch_Embedded_Metric_Format_Specification.md)
         + [Using the PutLogEvents API to Send Manually-Created Embedded Metric Format Logs](CloudWatch_Embedded_Metric_Format_Generation_PutLogEvents.md)
         + [Using the CloudWatch Agent to Send Embedded Metric Format Logs](CloudWatch_Embedded_Metric_Format_Generation_CloudWatch_Agent.md)
   + [Viewing Your Metrics and Logs in the Console](CloudWatch_Embedded_Metric_Format_View.md)
+ [Monitor Applications Using AWS SDK Metrics](CloudWatch-Agent-SDK-Metrics.md)
   + [Metrics and Data Collected by AWS SDK Metrics for Enterprise Support](metrics-collected-by-SDK-Metrics.md)
   + [Set Up SDK Metrics](Set-Up-SDK-Metrics.md)
      + [Configure the CloudWatch Agent for SDK Metrics](Configure-CloudWatch-Agent-SDK-Metrics.md)
      + [Set IAM Permissions for SDK Metrics](Set-IAM-Permissions-For-SDK-Metrics.md)
+ [Service Quotas Integration and Usage Metrics](CloudWatch-Service-Quota-Integration.md)
   + [Visualizing Your Service Quotas and Setting Alarms](CloudWatch-Quotas-Visualize-Alarms.md)
   + [CloudWatch Usage Metrics](CloudWatch-Usage-Metrics.md)
+ [CloudWatch Tutorials](CloudWatch-tutorials.md)
   + [Scenario: Monitor Your Estimated Charges Using CloudWatch](gs_monitor_estimated_charges_with_cloudwatch.md)
   + [Scenario: Publish Metrics to CloudWatch](PublishMetrics.md)
+ [Tagging Your Amazon CloudWatch Resources](CloudWatch-Tagging.md)
+ [Security in Amazon CloudWatch](security.md)
   + [Data Protection in Amazon CloudWatch](data-protection.md)
   + [Identity and Access Management for Amazon CloudWatch](auth-and-access-control-cw.md)
      + [CloudWatch Dashboard Permissions Update](dashboard-permissions-update.md)
      + [Overview of Managing Access Permissions to Your CloudWatch Resources](iam-access-control-overview-cw.md)
      + [Using Identity-Based Policies (IAM Policies) for CloudWatch](iam-identity-based-access-control-cw.md)
      + [Using Condition Keys to Limit Access to CloudWatch Namespaces](iam-cw-condition-keys-namespace.md)
      + [Using Service-Linked Roles for CloudWatch](using-service-linked-roles.md)
      + [Using Service-Linked Roles for CloudWatch Application Insights for .NET and SQL Server](CHAP_using-service-linked-roles-appinsights.md)
      + [Amazon CloudWatch Permissions Reference](permissions-reference-cw.md)
   + [Compliance Validation for Amazon CloudWatch](compliance-validation.md)
   + [Resilience in Amazon CloudWatch](disaster-recovery-resiliency.md)
   + [Infrastructure Security in Amazon CloudWatch](infrastructure-security.md)
   + [Using CloudWatch and CloudWatch Synthetics with Interface VPC Endpoints](cloudwatch-and-interface-VPC.md)
   + [Security Considerations for Synthetics Canaries](servicelens_canaries_security.md)
+ [Logging Amazon CloudWatch API Calls with AWS CloudTrail](logging_cw_api_calls.md)
+ [Grafana Integration](CloudWatch-Grafana-support.md)
+ [CloudWatch Service Quotas](cloudwatch_limits.md)
+ [Document History](DocumentHistory.md)