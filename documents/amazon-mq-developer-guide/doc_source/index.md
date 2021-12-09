# Amazon MQ Developer Guide

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
+ [What Is Amazon MQ?](welcome.md)
+ [Setting Up Amazon MQ](amazon-mq-setting-up.md)
+ [Getting Started with Amazon MQ](amazon-mq-getting-started.md)
+ [Amazon MQ Tutorials](amazon-mq-tutorials.md)
   + [Tutorial: Creating and Configuring an Amazon MQ Broker](amazon-mq-creating-configuring-broker.md)
      + [Accessing the ActiveMQ Web Console of a Broker without Public Accessibility](accessing-web-console-of-broker-without-private-accessibility.md)
   + [Tutorial: Creating and Configuring an Amazon MQ Network of Brokers](amazon-mq-creating-configuring-network-of-brokers.md)
   + [Tutorial: Editing Broker Engine Version, Instance Type, CloudWatch Logs, and Maintenance Preferences](amazon-mq-editing-broker-preferences.md)
   + [Tutorial: Creating and Applying Amazon MQ Broker Configurations](amazon-mq-creating-applying-configurations.md)
   + [Tutorial: Editing Amazon MQ Broker Configurations and Managing Configuration Revisions](amazon-mq-editing-managing-configurations.md)
   + [Tutorial: Connecting a Java Application to Your Amazon MQ Broker](amazon-mq-connecting-application.md)
   + [Tutorial: Listing Amazon MQ Brokers and Viewing Broker Details](amazon-mq-listing-brokers.md)
   + [Tutorial: Creating and Managing Amazon MQ Broker Users](amazon-mq-listing-managing-users.md)
   + [Tutorial: Rebooting an Amazon MQ Broker](amazon-mq-rebooting-broker.md)
   + [Tutorial: Deleting an Amazon MQ Broker](amazon-mq-deleting-broker.md)
   + [Tutorial: Accessing CloudWatch Metrics for Amazon MQ](amazon-mq-accessing-metrics.md)
+ [How Amazon MQ Works](amazon-mq-how-it-works.md)
   + [Amazon MQ Basic Elements](amazon-mq-basic-elements.md)
      + [Broker](broker.md)
      + [Configuration](configuration.md)
      + [Engine](broker-engine.md)
      + [Storage](broker-storage.md)
      + [User](user.md)
   + [Amazon MQ Broker Architecture](amazon-mq-broker-architecture.md)
      + [Amazon MQ Single-Instance Broker](single-broker-deployment.md)
      + [Amazon MQ Active/Standby Broker for High Availability](active-standby-broker-deployment.md)
      + [Amazon MQ Network of Brokers](network-of-brokers.md)
      + [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)
   + [Amazon MQ Broker Configuration Parameters](amazon-mq-broker-configuration-parameters.md)
      + [Elements Permitted in Amazon MQ Configurations](permitted-elements.md)
      + [Elements and Their Attributes Permitted in Amazon MQ Configurations](permitted-attributes.md)
      + [Elements, Child Collection Elements, and Their Child Elements Permitted in Amazon MQ Configurations](permitted-collections.md)
         + [Amazon MQ Child Element Attributes](child-element-details.md)
   + [Working Examples of Using Java Message Service (JMS) with ActiveMQ](amazon-mq-working-java-example.md)
   + [Tagging resources](amazon-mq-tagging.md)
+ [Migrating to Amazon MQ](amazon-mq-migrating.md)
   + [Migrating to Amazon MQ without Service Interruption](amazon-mq-migrating-no-service-interruption.md)
   + [Migrating to Amazon MQ with Service Interruption](amazon-mq-migrating-service-interruption.md)
+ [Best Practices for Amazon MQ](amazon-mq-best-practices.md)
   + [Connecting to Amazon MQ](connecting-to-amazon-mq.md)
   + [Ensuring Effective Amazon MQ Performance](ensuring-effective-amazon-mq-performance.md)
   + [Avoid Slow Restarts by Recovering Prepared XA Transactions](recover-xa-transactions.md)
+ [Quotas in Amazon MQ](amazon-mq-limits.md)
+ [Security in Amazon MQ](security.md)
   + [Data Protection in Amazon MQ](data-protection.md)
   + [Identity and Access Management for Amazon MQ](security-iam.md)
      + [How Amazon MQ Works with IAM](security_iam_service-with-iam.md)
      + [Amazon MQ Identity-Based Policy Examples](security_iam_id-based-policy-examples.md)
      + [API Authentication and Authorization for Amazon MQ](security-api-authentication-authorization.md)
      + [Troubleshooting Amazon MQ Identity and Access](security_iam_troubleshoot.md)
   + [Logging and Monitoring Amazon MQ Brokers](security-logging-monitoring.md)
      + [Monitoring Amazon MQ Brokers Using Amazon CloudWatch](security-logging-monitoring-cloudwatch.md)
      + [Logging Amazon MQ API Calls Using AWS CloudTrail](security-logging-monitoring-cloudtrail.md)
      + [Configuring Amazon MQ to Publish General and Audit Logs to Amazon CloudWatch Logs](security-logging-monitoring-configure-cloudwatch.md)
   + [Messaging Authentication and Authorization for ActiveMQ](security-authentication-authorization.md)
   + [Compliance Validation for Amazon MQ](AMQ-compliance.md)
   + [Resilience in Amazon MQ](disaster-recovery-resiliency.md)
   + [Infrastructure Security in Amazon MQ](infrastructure-security.md)
   + [Security Best Practices for Amazon MQ](using-amazon-mq-securely.md)
+ [Related Resources](amazon-mq-related-resources.md)
+ [Amazon MQ Release Notes](amazon-mq-release-notes.md)
   + [Amazon MQ Document History](amazon-mq-documentation-history.md)
+ [AWS glossary](glossary.md)