# Amazon Chime Administration Guide

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
+ [What is Amazon Chime?](what-is-chime.md)
+ [Prerequisites](prereqs.md)
+ [Security in Amazon Chime](security.md)
   + [Identity and access management for Amazon Chime](security-iam.md)
      + [How Amazon Chime works with IAM](security_iam_service-with-iam.md)
      + [Amazon Chime identity-based policy examples](security_iam_id-based-policy-examples.md)
      + [Troubleshooting Amazon Chime identity and access](security_iam_troubleshoot.md)
   + [Using service-linked roles for Amazon Chime](using-service-linked-roles.md)
      + [Using roles to stream Amazon Chime Voice Connector media to Kinesis](using-service-linked-roles-stream.md)
      + [Using roles with shared Alexa for Business devices](using-service-linked-roles-a4b.md)
   + [Logging and monitoring in Amazon Chime](monitoring-overview.md)
      + [Monitoring Amazon Chime with Amazon CloudWatch](monitoring-cloudwatch.md)
      + [Automating Amazon Chime with EventBridge](automating-chime-with-cloudwatch-events.md)
      + [Logging Amazon Chime API calls with AWS CloudTrail](cloudtrail.md)
   + [Compliance validation for Amazon Chime](compliance.md)
   + [Resilience in Amazon Chime](disaster-recovery-resiliency.md)
   + [Infrastructure security in Amazon Chime](infrastructure-security.md)
+ [Getting started](getting-started.md)
+ [Managing your Amazon Chime accounts](manage-chime-account.md)
   + [Choosing between an Amazon Chime Team account or Enterprise account](choose-team-enterprise-account.md)
   + [Converting a Team account to an Enterprise account](convert-team-to-enterprise.md)
   + [Renaming your account](rename-account.md)
   + [Deleting your account](enterprise-account.md)
   + [Managing meeting settings](mtg-settings.md)
   + [Retention](archive-retention.md)
      + [Managing chat retention policies](chat-retention.md)
   + [Managing messages](message-settings.md)
   + [Claiming a domain](claim-domain.md)
   + [Connecting to your Active Directory](active_directory.md)
   + [Connecting to Okta SSO](okta_sso.md)
   + [Deploying the Amazon Chime Add-In for Outlook](deploy-addin.md)
   + [Setting up the Amazon Chime Meetings App for Slack](config-slack.md)
+ [Managing users](manage-users.md)
   + [Viewing user details](user-details.md)
   + [Managing user permissions and access](manage-access.md)
   + [Managing user phone numbers](user-phone.md)
   + [Changing personal meeting PINs](change-PINs.md)
   + [Managing Pro trials](manage-protrials.md)
   + [Requesting user attachments](request-attachments.md)
+ [Managing phone numbers in Amazon Chime](phone-numbers.md)
   + [Provisioning phone numbers](provision-phone.md)
   + [Porting existing phone numbers](porting.md)
   + [Managing phone number inventory](phone-inventory.md)
   + [Updating outbound calling names](calling-name.md)
   + [Deleting phone numbers](delete-phone.md)
   + [Restoring deleted phone numbers](restore-phone.md)
+ [Managing Amazon Chime Voice Connectors](voice-connectors.md)
   + [Creating an Amazon Chime Voice Connector](create-voicecon.md)
   + [Editing Amazon Chime Voice Connector settings](edit-voicecon.md)
      + [Setting up emergency call routing numbers for your Amazon Chime Voice Connector](chime-voice-connector-emergency-calling.md)
   + [Assigning and unassigning Amazon Chime Voice Connector phone numbers](assign-voicecon.md)
   + [Deleting an Amazon Chime Voice Connector](delete-voicecon.md)
   + [Managing Amazon Chime Voice Connector groups](voice-connector-groups.md)
   + [Streaming Amazon Chime Voice Connector media to Kinesis](start-kinesis-vc.md)
+ [Managing global settings in Amazon Chime](manage-global.md)
+ [Setting up Amazon Chime on Dolby hardware](setup-dolby.md)
   + [Preparing for setup](prepare-setup.md)
   + [Setting up the Dolby hardware](setup-hardware.md)
   + [Pairing a Dolby device](pair-device.md)
   + [Setting up a Dolby Voice Room whiteboard](setup-whiteboard.md)
   + [Verifying Dolby device settings](device-settings.md)
   + [Verifying setup of Amazon Chime on Dolby hardware](verify-setup.md)
+ [Conference room configuration](configure-rooms.md)
+ [Network configuration and bandwidth requirements](network-config.md)
+ [Viewing reports](view-reports.md)
+ [Administrative support for Amazon Chime](chime-getting-admin-support.md)
+ [Document history for Amazon Chime](doc-history.md)
+ [AWS glossary](glossary.md)