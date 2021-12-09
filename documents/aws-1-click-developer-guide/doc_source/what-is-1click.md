# What Is AWS IoT 1\-Click?<a name="what-is-1click"></a>

AWS IoT 1\-Click makes it easy for enterprise customers to incorporate simple IoT devices into their workflows without having to manufacture devices, write firmware, or configure them for secure connectivity\. Our manufacturing partners create devices that can securely connect to AWS IoT right out of the box\. These devices can trigger [AWS Lambda](https://aws.amazon.com/lambda/) functions that are written in languages like Java, Python, and C\#\. The Lambda functions can implement business logic on their own or trigger actions in the AWS Cloud or on\-premises\.

AWS IoT 1\-Click aims to simplify the Internet of Things for customers by abstracting as much detail related to the device hardware and firmware as possible\. This makes it possible to view AWS IoT 1\-Click devices as software components hosted in the AWS Cloud\. As with any other software component, these devices conform to well\-defined interfaces\. AWS IoT 1\-Click has interfaces defined per device type\. You can use these interfaces to build and base your applications on\.

With AWS IoT 1\-Click, you can group devices by function, location, or other criteria\. This logical grouping of devices is called a “*project*” in AWS IoT 1\-Click\. You can use projects to associate groups of devices with Lambda functions for desired actions\.

Projects contain templates that specify what type of devices are used, what Lambda functions they invoke, and what optional attributes, such as contextual data for location or function, are defined for these devices\. 

Once the project is created and templates defined, you can add placements within the project \- each of which follows the template and specifies actual devices by their serial numbers and attribute values \(key/value pairs\) that make sense to the specific location or function for that particular placement\.

## AWS IoT 1\-Click Components<a name="1click-glossary"></a>

**Claim**  
Refers to the process of associating an AWS IoT 1\-Click device with an AWS account using the AWS IoT 1\-Click console ,AWS IoT 1\-Click mobile app , or the AWS IoT 1\-Click API\.

**Claim code**  
A value used to claim a number of AT&T LTE\-M buttons at once \(that is, in bulk\)\. You can also use device IDs to claim devices\. See the **Device ID** entry\.

**Device**  
A physical device, such as the AWS IoT Enterprise Button or the AT&T LTE\-M Button\.

**Device attributes**  
Either default or custom data associated with a particular device in the form of key\-value pairs\. Default attributes are derived from the placement\. See the **placement** entry\.

**Device ID**  
All devices have a device ID, such as a device serial number \(DSN\)\. A device ID can be used to to register an AWS IoT 1\-Click device with AWS IoT 1\-Click\. A claim code is not the same as a device ID\. See the **Claim code** entry\.

**Placement**  
A group of one or more templates representing devices \(for example, a room containing two templatized buttons\)\. To populate a placement, you use the AWS IoT 1\-Click console or the AWS IoT 1\-Click mobile app to choose templatized devices\.

**Placement name**  
The name of the placement, which often includes a geographic location or object ID \(for example, `Room 217`, `North Dumpster`, or `Container 314`\)\.

**Project**  
A named group of zero or more placements \(containing templatized devices\)\.

**Project name**  
A descriptive name for a group of placements \(for example, "Meeting Room Satisfaction" or "Charter Container Pickup"\)\.

**Template**  
Used to provide default behavior and default attributes for a group of devices\. A physical device uses a particular template to inherit the properties of that template: its Lambda function and default device attributes\. A template defines the behavior and default attributes for a class of device\(s\) in a placement\. A project can have more than one template\.

**Unclaim**  
The process of disassociating an AWS IoT 1\-Click device from an AWS account\. For example, a person who wants to lend an AWS IoT 1\-Click device should first disassociate the device from the AWS account so that the new user can associate the device with their own AWS account\.