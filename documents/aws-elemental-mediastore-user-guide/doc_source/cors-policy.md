# Cross\-origin resource sharing \(CORS\) policies in AWS Elemental MediaStore<a name="cors-policy"></a>

Cross\-origin resource sharing \(CORS\) defines a way for client web applications that are loaded in one domain to interact with resources in a different domain\. With CORS support in AWS Elemental MediaStore, you can build rich client\-side web applications with MediaStore and selectively allow cross\-origin access to your MediaStore resources\.

**Note**  
If you are using Amazon CloudFront to distribute content from a container that has a CORS policy, be sure to [configure the distribution for AWS Elemental MediaStore](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/live-streaming.html#video-streaming-mediastore) \(including the step to edit the cache behavior to set up CORS\)\.

This section provides an overview of CORS\. The subtopics describe how you can enable CORS using the AWS Elemental MediaStore console, or programmatically using the MediaStore REST API and the AWS SDKs\.

**Topics**
+ [CORS use\-case scenarios](cors-policy-use-case-scenarios.md)
+ [Adding a CORS policy to a container](cors-policy-adding.md)
+ [Viewing a CORS policy](cors-policy-viewing.md)
+ [Editing a CORS policy](cors-policy-editing.md)
+ [Deleting a CORS policy](cors-policy-deleting.md)
+ [Troubleshooting CORS issues](cors-policy-troubleshooting.md)
+ [Example CORS policies](cors-policies-examples.md)