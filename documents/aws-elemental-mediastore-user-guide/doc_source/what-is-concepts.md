# AWS Elemental MediaStore concepts and terminology<a name="what-is-concepts"></a>

ARN  
An [Amazon Resource Name](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

Body  
The data to be uploaded into an object\.

\(Byte\) range  
A subset of object data to be addressed\. For more information, see [range](https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35) from the HTTP specification\.

Container  
A namespace that holds objects\. A container has an endpoint that you can use for writing and retrieving objects and attaching access policies\.

Endpoint  
An entry point to the MediaStore service, given as an HTTPS root URL\.

ETag  
An [entity tag](https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.19), which is a hash of the object data\.

Folder  
A division of a container\. A folder can hold objects and other folders\.

Item  
A term used to refer to objects and folders\.

Object  
An asset, similar to an [Amazon S3 object](https://docs.aws.amazon.com/s3/)\. Objects are the fundamental entities that are stored in MediaStore\. The service accepts all file types\.

Origination service  
MediaStore is considered an *origination service* because it is the point of distribution for media content delivery\.

Path  
A unique identifier for an object or folder, which indicates its location in the container\.

Part  
A subset of data \(chunk\) of an object\.

Policy  
An [IAM policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html)\.

Resource  
An entity in AWS that you can work with\. Each AWS resource is assigned an Amazon Resource Name \(ARN\) that acts as a unique identifier\. In MediaStore, this is the resource and its ARN format:   
+ Container: `aws:mediastore:region:account-id:container/:containerName`