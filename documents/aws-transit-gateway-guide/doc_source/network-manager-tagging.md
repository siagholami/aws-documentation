# Tagging your Network Manager resources<a name="network-manager-tagging"></a>

A *tag* is a metadata label that either you or AWS assigns to an AWS resource\. Each tag consists of a *key* and a *value*\. For tags that you assign, you define the key and the value\. For example, you might define the key as `purpose` and the value as `test` for one resource\.

Tags help you do the following:
+ Identify and organize your AWS resources\. Many AWS services support tagging, so you can assign the same tag to resources from different services to indicate that the resources are related\.
+ Control access to your AWS resources\. For more information, see [Controlling Access Using Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) in the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\.

## Supported resources<a name="network-manager-tagging-resources"></a>

The following Network Manager resources support tagging:
+ Global networks
+ Devices
+ Sites
+ Links

## Tagging restrictions<a name="network-manager-tagging-restrictions"></a>

The following basic restrictions apply to tags on Network Manager resources:
+ Maximum number of tags that you can assign to a resource: 200
+ Maximum key length: 128 Unicode characters
+ Maximum value length: 256 Unicode characters
+ Valid characters for key and value: a\-z, A\-Z, 0\-9, space, and the following characters: \_ \. : / = \+ \- and @
+ Keys and values are case sensitive
+ You cannot use `aws:` as a prefix for keys; it's reserved for AWS use