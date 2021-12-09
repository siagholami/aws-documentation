# Amazon CodeGuru Profiler User Guide

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
+ [What is Amazon CodeGuru Profiler?](what-is-codeguru-profiler.md)
+ [Setting up CodeGuru Profiler](setting-up.md)
+ [Getting started with CodeGuru Profiler](getting-started.md)
+ [Integrating with Amazon CodeGuru Profiler](integrating-with-codeguru-profiler.md)
   + [Choosing the right integration option](choosing-the-right-integration-option.md)
   + [Profiling your applications that run on AWS Lambda](setting-up-lambda.md)
   + [Enabling the agent from the command line](enabling-the-agent-with-command-line.md)
   + [Enabling the agent with code](enabling-the-agent-with-code.md)
      + [Java](java-language-support.md)
      + [Scala](scala-language-support.md)
      + [Kotlin](kotlin-language-support.md)
      + [Groovy](groovy-language-support.md)
      + [Jython](jython-language-support.md)
      + [JRuby](jruby-language-support.md)
      + [Clojure](clojure-language-support.md)
+ [Working with unsupported AWS Regions](working-with-unsupported-regions.md)
+ [Working with profiling groups](working-with-profiling-groups.md)
   + [Creating a profiling group](working-with-profiling-groups-create.md)
   + [Deleting a profiling group](working-with-profiling-groups-delete.md)
+ [Working with visualizations](working-with-visualizations.md)
   + [Types of visualizations](working-with-visualizations-visualization-types.md)
   + [Exploring visualization data](working-with-visualizations-exploring.md)
      + [Choosing my code in visualizations](working-with-visualizations-choosing-my-code.md)
      + [Pausing over a frame](working-with-visualizations-pause.md)
      + [Zooming in on a frame](working-with-visualizations-zoom.md)
      + [Resetting zoom in a visualization](working-with-visualizations-reset.md)
      + [Inspecting a frame](working-with-visualizations-inspect.md)
      + [Understanding the dollar estimate of the CPU cost for frames](working-with-visualizations-additional-info.md)
   + [Filtering visualization data](working-with-visualizations-filtering.md)
      + [Selecting and coloring thread states](working-with-visualizations-thread-states.md)
      + [Hiding a frame](working-with-visualizations-hiding-frame.md)
   + [Selecting a custom time range](working-with-visualizations-time-range.md)
+ [Working with anomalies and recommendation reports](working-with-recommendation-reports.md)
+ [Security in CodeGuru Profiler](security.md)
   + [Data protection for CodeGuru Profiler](data-protection.md)
   + [Identity and access management in CodeGuru Profiler](auth-and-access-control.md)
      + [Audience in CodeGuru Profiler](security_iam_audience.md)
      + [Authenticating with identities in CodeGuru Profiler](security_iam_authentication.md)
      + [Managing access using policies](security_iam_access-manage.md)
      + [Overview of managing access permissions to your CodeGuru Profiler resources](security_iam_service-with-iam.md)
      + [Using identity-based policies for CodeGuru Profiler](auth-and-access-control-iam-identity-based-access-control.md)
      + [Resource-based policies in CodeGuru Profiler](resource-based-policies.md)
      + [Amazon CodeGuru Profiler permissions reference](auth-and-access-control-permissions-reference.md)
      + [Troubleshooting CodeGuru Profiler identity and access](security_iam_troubleshoot.md)
      + [Using service-linked roles for CodeGuru Profiler](using-service-linked-roles.md)
   + [Logging and monitoring in Amazon CodeGuru Profiler](security-incident-response.md)
      + [Logging Amazon CodeGuru Profiler API calls with AWS CloudTrail](cloudtrail.md)
      + [Monitoring Amazon CodeGuru Profiler with Amazon CloudWatch](monitoring.md)
         + [Monitoring profiling groups with CloudWatch metrics](cloudwatch-metric.md)
         + [Monitoring profiling groups with CloudWatch alarms](cloudwatch-alarm.md)
   + [Compliance validation for Amazon CodeGuru Profiler](codeguru-profilerE-compliance.md)
   + [Infrastructure security in Amazon CodeGuru Profiler](infrastructure-security.md)
+ [Troubleshooting](troubleshooting.md)
+ [Quotas for CodeGuru Profiler](quotas.md)
+ [CodeGuru Profiler user guide document history](doc-history.md)
+ [AWS glossary](glossary.md)