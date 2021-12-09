# \(Optional\) Step 4: Check Amazon FSx File System Status<a name="file-system-lifecycle-states"></a>

You can view the status of an Amazon FSx file system by using the Amazon FSx console, the AWS CLI command [describe\-file\-systems](https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html), or the API operation [DescribeFileSystems](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html)\. 


| File System Status  | Description | 
| --- | --- | 
| AVAILABLE | The file system is in a healthy state, and is reachable and available for use\. | 
| CREATING | Amazon FSx is creating a new file system\. | 
| DELETING | Amazon FSx is deleting an existing file system\. | 
| UPDATING | The file system is undergoing a customer\-initiated update\. | 
| MISCONFIGURED | The file system is in a failed but recoverable state\. | 
| FAILED |  This status can mean either of the following: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/file-system-lifecycle-states.html)  | 