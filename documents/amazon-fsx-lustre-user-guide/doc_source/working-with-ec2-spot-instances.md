# Working with Amazon EC2 Spot Instances<a name="working-with-ec2-spot-instances"></a>

Amazon FSx for Lustre can be used with EC2 Spot Instances to significantly lower your Amazon EC2 costs\. A Spot Instance is an unused EC2 instance that is available for less than the On\-Demand price\. Amazon EC2 can interrupt your Spot Instance when the Spot price exceeds your maximum price, when the demand for Spot Instances rises, or when the supply of Spot Instances decreases\.

When Amazon EC2 interrupts a Spot Instance, it provides a Spot Instance interruption notice, which gives the instance a two\-minute warning before Amazon EC2 interrupts it\. For more information, see [Spot Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-spot-instances.html) in the *Amazon EC2 User Guide for Linux Instances*\. 

To ensure that Amazon FSx file systems are unaffected by EC2 Spot Instances Interruptions, we recommend unmounting Amazon FSx file systems prior to terminating or hibernating EC2 Spot Instances\. For more information, see [Unmounting File Systems](unmounting-fs.md)\. 