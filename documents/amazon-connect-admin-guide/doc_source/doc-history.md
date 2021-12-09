# Document history<a name="doc-history"></a>

The following table describes important changes in each release of the CloudWatch Events User Guide, beginning in June 2018\. For notification about updates to this documentation, you can subscribe to an RSS feed\. 

| Change | Description | Date | 
| --- |--- |--- |
| [Show agent queues in a Queues table\.](#doc-history) | By default, agent queues don't appear in a Queues table in a historical metrics report\. You can choose to show them\. For more information, see [Show agent queues in a Queues table](https://docs.aws.amazon.com/connect/latest/adminguide/show-agent-queues.html)\. | September 18, 2020 | 
| [Migrate contact flows to a different instance](#doc-history) | You can migrate hundreds of contact flows using a set of contact flow APIs\. For more information, see [Migrate contact flows to a different instance](https://docs.aws.amazon.com/connect/latest/adminguide/migrate-contact-flows.html)\. | September 18, 2020 | 
| [Languages supported by Amazon Connect](#doc-history) | Learn about which languages are supported in the Amazon Connect console, Contact Control Panel, Contact Lens, Amazon Lex, and Amazon Polly\. For more information, see [Languages supported by Amazon Connect](https://docs.aws.amazon.com/connect/latest/adminguide/supported-languages.html)\. | September 18, 2020 | 
| [Amazon Connect Flow language](#doc-history) | You can use the Amazon Connect Flow language to efficiently update contact flows that you're migrating from one instance to another, and Write contact flows rather than drag blocks onto the contact flow designer\. For more information, see [Amazon Connect Flow language](https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html)\. | September 18, 2020 | 
| [Option 2 \(not recommended\): Allow IP address ranges ](#doc-history) | Removed tip from *Option 2: Allow IP address ranges*, that said if you don't see an entry for your region, use GLOBAL\. For more information, see [Option 2 \(not recommended\): Allow IP address ranges](https://docs.aws.amazon.com/connect/latest/adminguide/option2.html)\. | September 11, 2020 | 
| [Option 1 \(recommended\): Replace Amazon EC2 and CloudFront IP range requirements with a domain allow list ](#doc-history) | Updated Option 1, second row of table, with a line break between \{myInstanceName\}\.awsapps\.com/connect/api and \*\.cloudfront\.net\. For more information, see [Option 1 \(recommended\): Replace Amazon EC2 and CloudFront IP range requirements with a domain allow list](https://docs.aws.amazon.com/connect/latest/adminguide/option1.html)\. | September 11, 2020 | 
| [Amazon Connect resource\-level policy examples ](#doc-history) | Changed title of "Amazon Connect resource\-based policy examples" topic to "Amazon Connect resource\-level policy examples\." For more information, see >[Amazon Connect resource\-level policy examples](https://docs.aws.amazon.com/connect/latest/adminguide/security_iam_resource-level-policy-examples.html)\. | September 8, 2020 | 
| [Consult and Contacts consulted ](#doc-history) | Updated the **Consult** and **Contact consulted** metrics to indicate they were deprecated May 2019\. For more information, see [Consult](https://docs.aws.amazon.com/connect/latest/adminguide/consult-real-time.html) and [Contacts consulted](https://docs.aws.amazon.com/connect/latest/adminguide/contacts-consulted-historical.html)\. | August 27, 2020 | 

## Earlier updates<a name="earlier-updates"></a>


| Change | Description | Date | 
| --- | --- | --- | 
| Added topic on setting up agent\-to\-agent transfers\. |  For more information, see [Set up agent\-to\-agent transfers](setup-agent-to-agent-transfers.md)\.   | August 19, 2020 | 
| Added section on requirements for custom termination points\. |  For more information, see [Request international numbers, special numbers, or termination points](special-request.md)\.   | August 18, 2020 | 
| Removed the "Known differences" section from [I use the Amazon Connect Streams API](upgrade-ccp-streams-api.md)\. |  For more information, see [I use the Amazon Connect Streams API](upgrade-ccp-streams-api.md)\.   | August 3, 2020 | 
| Changed the name of the **Metrics** chapter to **Monitor metrics & run reports**\. |  For more information, see [Monitor metrics and run reports](amazon-connect-metrics.md)\.   | July 16, 2020 | 
| Clarified that the following metrics are no longer supported in queue grouping: Agent on contact time, Agent idle time, Occupancy\. Previously we stated that these metrics had been deprecated\. |  For more information, see [June 2020: Changes for omnichannel spport](upcoming-changes.md#metrics-changes-june-2020)\.   | July 8, 2020 | 
| Updated the [Set disconnect flow](set-disconnect-flow.md) block, which now supports voice conversations\. |  For more information, see [Set disconnect flow](set-disconnect-flow.md)\.   | June 29 2020 | 
| Added upcoming metric changes: new real\-time and historical metrics for inbound and outbound contact time |  For more information, see [What's new in metrics](upcoming-changes.md)\.   | June 26, 2020 | 
| Added how to upgrade CCP |  For more information, see [Upgrade to the latest CCP](upgrade-to-latest-ccp.md)\.   | June 16, 2020 | 
| Added video on using CCP |  For more information, see [Training video: How to use the CCPTraining video](ccp-video-training.md)\.   | June 16, 2020 | 
| Deprecated metrics: Agent on contact time, Agent idle time, Occupancy\. |  For more information, see [June 2020: Changes for omnichannel spport](upcoming-changes.md#metrics-changes-june-2020)\.   | June 12, 2020 | 
| Added topic on quick connects work |  For more information, see [How quick connects work](how-quick-connects-work.md)\.   | May 21, 2020 | 
| Added how to get administrative support, and added a topic on inherited permissions |  For more information, see [Get administrative support for Amazon Connect](get-admin-support.md) and [About inherited permissions](inherited-permissions.md)\.   | April 16, 2020 | 
| Added how to customize your CCP to log out agents automatically when they close the CCP window |  For more information, see [Log out agents automatically when they close their CCP](automatic-logout.md)\.   | April 16, 2020 | 
| Updated the **Get customer input **block to support timeout values for voice input |  For more information, see [Get customer input](get-customer-input.md)\.   | April 8, 2020 | 
| Added terminating keypress |  For more information, see [Store customer input](store-customer-input.md)\.   | March 31, 2020 | 
| Added NLB endpoints and required domain for softphones |  For more information, see [Set up your network](ccp-networking.md)\.   | March 23, 2020 | 
| Announced upcoming changes for metrics |  For more information, see [June 2020: Changes for omnichannel spport](upcoming-changes.md#metrics-changes-june-2020)\.   | March 23, 2020 | 
| Added topic on region requirements for phone numbers |  For more information, see [Region requirements for phone numbers](phone-number-requirements.md)\.   | March 11, 2020 | 
| Added tutorials |  For more information, see [Tutorials: An introduction to Amazon Connect](tutorials.md)\.   | March 6, 2020 | 
| Added topic on tracking who deleted recordings |  For more information, see [Track who deleted or listened to recordings](track-who-deleted-recordings.md)\.   | March 5, 2020 | 
| Added topic on emergency admin access |  For more information, see [Emergency admin login](emergency-admin-login.md)\.   | March 3, 2020 | 
| Added topics on saving, sharing, and publishing reports |  For more information, see [Save custom reports](save-reports.md), [Share custom reports](share-reports.md), [View a shared report](view-a-shared-report.md), and [Publish reports](publish-reports.md)\.   | January 22, 2020 | 
| Updated contact block definitions |  For more information, see \.   | January 17, 2020 | 
| Added a section about queued callbacks in metrics reporting\. |  For more information, see [About queued callbacks in metrics](about-queued-callbacks.md)\.   | January 17, 2020 | 
| Updated networking guidance for the updated CCP \(ccp\-v2\) |  For more information, see [Set up your network](ccp-networking.md)\.   | January 15, 2020 | 
| Add a topic on logging Amazon Connect API calls with AWS CloudTrail |  For more information, see [Logging Amazon Connect API calls with AWS CloudTrail](logging-using-cloudtrail.md)\.   | December 13, 2019 | 
| Added a section on analyzing conversations |  For more information, see [Analyze conversations using Contact Lens for Amazon Connect](analyze-conversations.md)\.   | December 02, 2019 | 
| Added information about live media streaming |  For more information, see [Capture customer audio: live media streaming](customer-voice-streams.md)\.   | November 21, 2019 | 
| Added information about chat |  For more information, see [Chat](chat.md)\.  Also added these topics: [Best practices for Amazon Connect](best-practices.md), [About agent status](metrics-agent-status.md), [About contact states](about-contact-states.md), and [Additional resources for Amazon ConnectAdditional resources](additional-resources.md)\.  | November 21, 2019 | 
| Added topic on using IAM |  For more information, see [Identity and access management for Amazon Connect](security-iam.md)\.  | November 14, 2019 | 
| Added dimensions |  Added dimensions to the Amazon Connect metrics sent to CloudWatch\. See [Monitoring your instance using CloudWatch](monitoring-cloudwatch.md)\.  | October 22, 2019 | 
| Added a networking topic | Consolidated networking content into [Set up your network](ccp-networking.md)\. Updated the guidance\. | September 30, 2019 | 
| Updated metrics topics | Improved the descriptions of the real\-time metrics definitions\. Added categories to the historical metrics definitions\. | August 30, 2019 | 
| Updated historical metrics report section | Added categories to the historical metrics definitions\.  | August 27, 2019 | 
| Re\-organized the content | Re\-organized the content so it's task\-based\. | July 19, 2019 | 
| Added information about the updated **Transfer to phone number** block | You can use the updated **Transfer to phone number** block to transfer callers to a phone number external to your Amazon Connect instance, and then optionally resume the contact flow after the call with the external party ends\. For more information, see [Resume a contact flow after transfer](contact-flow-resume.md)\. | February 18, 2019 | 
| Adding information about live media streaming for customer audio streams | You can capture customer audio during interactions with your contact center and send it to a Kinesis video stream\. For more information, see [Capture customer audio: live media streaming](customer-voice-streams.md)\. | December 21, 2018 | 
| Added content about agent queues | You can use agent queues to route calls directly to a specific agent\. For more information, see [Transfer contacts to a specific agent](transfer-to-agent.md)\. | December 21, 2018 | 
| Added information about using Amazon Connect in the Asia Pacific \(Tokyo\) Region\. | For more information, [Claim phone numbers for Amazon Connect in the Asia Pacific \(Tokyo\) Region](connect-tokyo-region.md)\. | December 10, 2018 | 
| Added information about how to determine agent ACW time from agent event streams | For more information, see [Determine how long an agent spends doing ACW](determine-acw-time.md)\. | October 30, 2018 | 
| Added troubleshooting and best practices | [Troubleshooting Issues with the Contact Control Panel \(CCP\)](troubleshooting.md) covers best practices for agent connectivity using the CCP and troubleshooting connectivity and call quality issues in Amazon Connect\. | October 18, 2018 | 
| Added information about service\-linked roles in Amazon Connect | For more information, see [Use Service\-Linked Roles for Amazon Connect](connect-slr.md)\. | October 17, 2018 | 
| Added information about queue to queue transfers | You can use the new options of the Transfer to queue block to enable transferring calls that are already in a queue to another queue\. For more information, see [Manage contacts in a queue](queue-to-queue-transfer.md)\. | July 31, 2018 | 
| Added information about the Call phone number block | Updated the content about contact flows to include the new Call phone number block, including how to use the block in a contact flow\. For more information, see [Use the Call phone number block to set caller ID](queues-callerid.md#using-call-number-block)\. | July 2, 1018 | 
| Added information about contact attributes and the Get queue metrics block | For more information, see [Use Amazon Connect contact attributes](connect-contact-attributes.md)\. | June 18, 2018 | 
| Added information about new metrics sent to Amazon CloudWatch Logs\. | [Monitoring your instance using CloudWatch](monitoring-cloudwatch.md) includes additional metrics\. | April 19, 2018 | 
| Added information about using SAML for identity management | You can configure your instance to use SAML for identity management\. You can also use SAML to enable single sign\-on\. For more information, see [Configure SAML with IAM for Amazon Connect](configure-saml.md)\. | March 30, 2018 | 
| Added information about agent call transfers | You can enable call transfers from an agent to another agent, to a queue, or to an external number\.  | December 10, 2017 | 
| Added information about manager listen\-in | You can configure and enable a manager to listen in on agent calls\. For more information, see [Monitor live conversations](monitor-conversations.md)\. | December 10, 2017 | 
| Added information about contact flow logs | For more information, see [Enable contact flow logs](contact-flow-logs.md)\. | November 16, 2017 | 
| Added information about contact flow import/export | For more information, see [Import/export contact flows](contact-flow-import-export.md)\. | November 16, 2017 | 
| Added information about agent event streams | For more information, see [Amazon Connect agent event streams](agent-event-streams.md)\. | November 16, 2017 | 
| Added information about porting your current phone number to Amazon Connect | For more information, see [Port your current phone number](port-phone-number.md)\. | November 10, 2017 | 
| Added information about Login/Logout reports | For more information, see [Login/Logout Reports](login-logout-reports.md)\. | November 1, 2017 | 
| Initial release | Initial release of the Amazon Connect Administrator Guide\. | March 28, 2017 | 