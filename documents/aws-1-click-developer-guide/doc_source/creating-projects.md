# Creating a Project<a name="creating-projects"></a>

The following procedure shows you how to create an AWS IoT 1\-Click project for your AWS IoT 1\-Click supported device\(s\)\.

1. Sign in to your AWS account and open the AWS IoT 1\-Click console\.

1. Choose **Onboard**, and then choose **Create a project**\.

1. Type a name and optional description for the project, and then choose **Next**\.

1. To define one or more templates for your placement, under **Program a device template**, choose **Start**\.

1. To define a template for any button device, choose **All button types**\.

1. For **Device template name**, type a descriptive name for your template\. Under **Action**, choose **Send SMS** or **Send email**\. You can use the **Custom action using a Lambda function** option and chooseone of your own Lambda functions\. Enter the phone number, email address, or Lambda function name, depending on your choice\. For more information about creating Lambda functions, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/)\.

1. Under **Add another device template \(if you need multiple devices per placement\)** choose **Add**\.

1. Enter an attribute key\-value pair\. You can enter additional key\-value pairs, if necessary\.

1. Choose **Create project**\.

The following section, [Example: Meeting Room Satisfaction Project](#project-example), provides a real\-world example of how to use the AWS IoT 1\-Click console to create a project\.

## Example: Meeting Room Satisfaction Project<a name="project-example"></a>

The following example might help you understand AWS IoT 1\-Click concepts\.
+ A project to track the satisfaction of 50 meeting rooms \(and associated AV equipment\) is created and named `MeetingRoomSat`\.
+ Each meeting room will receive two devices \(buttons\), one physically marked "Satisfied" and the other marked "Unsatisfied"\. Since there are two buttons per room, two templates are created, one named `Satisfied` and the other named `Unsatisfied`\.
+ The `Satisfied` template is configured to invoke a Lambda function called `SatLambda`\.
+ The `Unsatisfied` template is configured to invoke a Lambda function called `UnsatLambda`\.
+ For both of these templates, an attribute \(key/value pair\) named `MeetingRoomNum` \(key\) is created whose value is `TBD` \(the `TBD` value will be changed to the room number when both buttons are physically placed in a room\)\.
+ 50 placements are created, one for each room\. Each placement has the two templates associated with it \(i\.e\., `Satisfied` and `Unsatisfied`\)\.
+ Two buttons are physical labeled and placed in a room\. Then, using the AWS IoT 1\-Click mobile app or the AWS IoT 1\-Click console and the button’s serial numbers, the “Satisfied” and “Unsatisfied” marked buttons are associated with one of the 50 placements\. This process continues until all remaining placements are deployed\.
+ When a room button is clicked in a meeting room, AWS IoT 1\-Click invokes either the `SatLambda` or `UnsatLambda` function with the `MeetingRoomNum` value – and feedback can be processed and stored in the cloud\.
+ Later, another template can be added to the project so that the 50 existing placements now contain a slot for a new button to indicate that more towels or other toiletries are needed in each bathroom\.

The following provides an example of using the AWS IoT 1\-Click console to create a project for monitoring meeting room satisfication in an office building \(as part of a group of office buildings\)\.

To monitor the satisfaction of meeting rooms, including their audio/video equipment, two AWS IoT Enterprise buttons, one labeled "Satisfied" and the other labeled "Unsatisifed", are placed in each meeting room\. This is a pilot project, the results of which can be used to improve meeting room customer satisfaction in other buildings on campus\.

At the end of a meeting, participants are encouraged to press either the "Satisfied" or "Unsatisfied" button to record their overall satisfaction with the meeting room and its equipment\. This data is then used to identify meeting rooms with non\-functional A/V equipment or other problems\.

The AWS IoT 1\-Click console can be used to set up this project:

1. From the AWS IoT 1\-Click console, choose **Create a project**\.

1. For the project name, type **MeetingRoomSatisfaction**\. For the project description, type **Project used to track customer meeting room satisfaction, including A/V equipment\.** Choose **Next**\.

1. Under **Program a device template** choose **Start**, and then choose **All button types**\.

1. For **Device template name**, type **Satisfied**\. This is the template used for all buttons labeled "Satisfied\." For **Action**, choose **Send email**\. 
**Note**  
If the meeting room satisfication pilot is successful, under **Action**, you might choose **Custom action using a Lambda function**\. This custom Lambda function could send an email or store the "Satisfied" button data in an Amazon DynamoDB table for later analysis\. For information about creating Lambda functions, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/)\.

1. Under **Add another device template \(if you need multiple devices per placement\)** choose **Add**, and then choose **All button types**\. For **Device template name**, type **Unsatisfied**\. This is the template used for all buttons labeled "Unsatisfied\." For **Action**, choose **Send email**\.

1. For **Required email default value**, type an email address\. For **Required subject default value**, type **Meeting Room Feedback**\. For **Required body default value**, type **Either positive or negative meeting room feedback has been provided\.**

1. For **Attribute key**, type **Building**\. For **Default value**, type **Headquarters**\. The meeting room satisfaction pilot is taking place in the company's headquarters building\. If the pilot is successful, it will be deployed to the company's other buildings\. Therefore, it's important to know from which building the meeting room devices are providing information for\.

1. In the second key\-value pair row, for **Attribute key**, type **Room**\. For **Default value**, type **TBD**\. The **TBD** value will be changed to a meeting room number when the buttons are placed there \(using either the AWS IoT 1\-Click mobile app or AWS IoT 1\-Click console\)\.

1. Choose **Create project**\.

Using the AWS IoT 1\-Click mobile app, when a "Satisfied" button is placed in a meeting room, the **Satisfied** template becomes associated with it and the **TBD** value is replaced with the meeting room number\. The same is true for when the "Unsatisfied" button is placed in a meeting room\.