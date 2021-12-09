# Distributing content to AWS Elemental MediaLive<a name="distribution-to-medialive"></a>

If you plan to distribute the contents of your AWS Elemental MediaConnect flow to AWS Elemental MediaLive, remember the following:
+ For each video stream, create two flows in the same AWS Region, but in different Availability Zones \(such as `us-east-1a` and `us-east-1b`\)\. These redundant flows will serve as the primary and backup inputs for the MediaLive channel\.
+ Create the MediaLive channel in the same AWS Region as the AWS Elemental MediaConnect flows\.
+ Set up permissions that allow MediaLive to communicate with AWS Elemental MediaConnect\. This process consists of the following procedures: 

  1. Create a policy that allows MediaLive to submit a request to AWS Elemental MediaConnect \(see [Create a MediaLive Policy](https://docs.aws.amazon.com/medialive/latest/ug/permissions-medialive-step1.html)\)\.

  1. Assign that policy to a role for MediaLive \(see [Create a Role for MediaLive](https://docs.aws.amazon.com/medialive/latest/ug/permissions-medialive-step2.html)\)\. You will need the Amazon Resource Name \(ARN\) for this role when you specify AWS Elemental MediaConnect flows as inputs to a MediaLive channel\. 
+ Create your AWS Elemental MediaConnect and MediaLive resources in this order:

  1. Set up permissions\.

  1. Create the AWS Elemental MediaConnect flows\. 

  1. Make a note of the flow ARNs\.

  1. Create the inputs on the MediaLive channel\. \(You can create the MediaLive channel whenever you want\. Just be sure to create the inputs for that channel after you create the flows\.\)