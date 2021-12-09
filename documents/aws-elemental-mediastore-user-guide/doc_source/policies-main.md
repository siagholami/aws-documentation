# Policies in AWS Elemental MediaStore<a name="policies-main"></a>

You can apply one or more of these policies to your AWS Elemental MediaStore container:
+ [Container policy](policies.md) \- Sets access rights to all folders and objects within the container\. MediaStore sets a default policy that allows users to perform all MediaStore operations on the container\. This policy specifies that all operations must be performed over HTTPS\. After you create a container, you can edit the container policy\.
+ [Cross\-origin resource sharing \(CORS\) policy](cors-policy.md) \- Allows client web applications from one domain to interact with resources in a different domain\. MediaStore does not set a default CORS policy\.
+ [Metrics policy](policies-metric.md) \- Allows MediaStore to send metrics to Amazon CloudWatch\. MediaStore does not set a default metric policy\.
+ [Object lifecycle policy](policies-object-lifecycle.md) \- Controls how long objects remain in a MediaStore container\. MediaStore does not set a default object lifecycle policy\.