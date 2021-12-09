# AWS Global Accelerator Developer Guide

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
+ [What is AWS Global Accelerator?](what-is-global-accelerator.md)
   + [AWS Global Accelerator components](introduction-components.md)
   + [How AWS Global Accelerator works](introduction-how-it-works.md)
   + [Location and IP address ranges of Global Accelerator edge servers](introduction-ip-ranges.md)
   + [AWS Global Accelerator use cases](introduction-benefits-of-migrating.md)
   + [AWS Global Accelerator Speed Comparison Tool](introduction-speed-comparison-tool.md)
   + [How to get started with AWS Global Accelerator](introduction-get-started.md)
   + [Tagging in AWS Global Accelerator](tagging-in-global-accelerator.md)
   + [Pricing for AWS Global Accelerator](introduction-pricing.md)
+ [Getting started with AWS Global Accelerator](getting-started.md)
+ [Common actions that you can use with AWS Global Accelerator](global-accelerator-actions.md)
+ [Accelerators in AWS Global Accelerator](about-accelerators.md)
   + [Creating or updating an accelerator](about-accelerators.creating-editing.md)
   + [Deleting an accelerator](about-accelerators.deleting.md)
   + [Viewing your accelerators](about-accelerators.viewing.md)
   + [Add an accelerator when you create a load balancer](about-accelerators.alb-accelerator.md)
   + [Bring your own IP addresses (BYOIP) in AWS Global Accelerator](using-byoip.md)
   + [Support for DNS addressing in Global Accelerator](about-accelerators.dns-addressing.md)
   + [Route custom domain traffic to your accelerator](about-accelerators.mapping-your-custom-domain.md)
+ [Listeners in AWS Global Accelerator](about-listeners.md)
   + [Adding, editing, or removing a listener](about-listeners.creating-listeners.md)
   + [Client affinity](about-listeners-client-affinity.md)
+ [Endpoint groups in AWS Global Accelerator](about-endpoint-groups.md)
   + [Adding, editing, or removing an endpoint group](about-endpoint-groups.create-endpoint-group.md)
   + [Adjusting traffic flow with traffic dials](about-endpoint-groups-traffic-dial.md)
   + [Health check options](about-endpoint-groups-health-check-options.md)
+ [Endpoints in AWS Global Accelerator](about-endpoints.md)
   + [Adding, editing, or removing an endpoint](about-endpoints-adding-endpoints.md)
   + [Endpoint weights](about-endpoints-endpoint-weights.md)
   + [Transitioning endpoints to use client IP address preservation](about-endpoints.transition-to-IP-preservation.md)
+ [Preserve client IP addresses in AWS Global Accelerator](preserve-client-ip-address.md)
   + [How to enable client IP address preservation](preserve-client-ip-address.how-to-enable-preservation.md)
   + [Benefits of client IP address preservation](preserve-client-ip-address.benefits-of-preservation.md)
   + [How the client IP address is preserved in AWS Global Accelerator](preserve-client-ip-address.headers.md)
   + [Best practices for client IP address preservation](best-practices-aga.md)
   + [Supported AWS Regions for client IP address preservation](preserve-client-ip-address.regions.md)
+ [Logging and monitoring in AWS Global Accelerator](monitoring-global-accelerator.md)
   + [Flow logs in AWS Global Accelerator](monitoring-global-accelerator.flow-logs.md)
   + [Using Amazon CloudWatch with AWS Global Accelerator](cloudwatch-monitoring.md)
   + [Using AWS CloudTrail to log AWS Global Accelerator API calls](logging-using-cloudtrail.md)
+ [AWS Global Accelerator security](security.md)
   + [Identity and access management for AWS Global Accelerator](auth-and-access-control.md)
      + [Service-linked role for Global Accelerator](using-service-linked-roles.md)
      + [Overview of access and authentication](auth_access_overview.md)
   + [Secure VPC connections in AWS Global Accelerator](secure-vpc-connections.md)
   + [Logging and monitoring in AWS Global Accelerator](logging-and-monitoring.md)
   + [Compliance validation for AWS Global Accelerator](compliance-validation.md)
   + [Resilience in AWS Global Accelerator](disaster-recovery-resiliency.md)
   + [Infrastructure security in AWS Global Accelerator](infrastructure-security.md)
+ [Quotas for AWS Global Accelerator](limits-global-accelerator.md)
+ [AWS Global Accelerator Related information](Resources.md)
+ [Document history](WhatsNew.md)
+ [AWS glossary](glossary.md)