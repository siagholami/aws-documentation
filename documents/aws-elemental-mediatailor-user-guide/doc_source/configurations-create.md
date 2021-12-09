# Creating a Configuration<a name="configurations-create"></a>

Create a configuration to start receiving content streams and to provide an access point for downstream playback devices to request content\.

You can use the AWS Elemental MediaTailor console, the AWS CLI, or the MediaTailor API to create a configuration\. For information about creating a configuration through the AWS CLI or MediaTailor API, see the https://docs\.aws\.amazon\.com/mediatailor/latest/apireference/\.

When you're creating a configuration, do not put sensitive identifying information like customer account numbers into free\-form fields such as the **Configuration name** field\. This includes when you work with MediaTailor using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaTailor might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

**To add a configuration \(console\)**

1. Open the MediaTailor console at [https://console\.aws\.amazon\.com/mediatailor/](https://console.aws.amazon.com/mediatailor/)\.

1. On the **Configurations** page, choose **Create configuration**\.

1. Complete the configuration and additional configuration fields as described in the following topics:
   + [Main Configuration Fields](configurations-create-main.md)
   + [Additional Configuration Fields](configurations-create-addl.md)

1. Choose **Create configuration**\.

   AWS Elemental MediaTailor displays the new configuration in the table on the **Configurations** page\.

1. \(Optional, but recommended\) You can use the configuration playback URLs to set up a CDN with AWS Elemental MediaTailor for manifests and reporting\.

   For information about setting up a CDN for manifest and reporting requests, see [Integrating AWS Elemental MediaTailor and a CDN](integrating-cdn-standard.md)\.