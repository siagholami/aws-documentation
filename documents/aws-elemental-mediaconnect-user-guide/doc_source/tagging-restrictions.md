# Tag naming and usage conventions<a name="tagging-restrictions"></a>

The following basic naming and usage conventions apply to using tags with AWS Elemental MediaConnect resources:
+ Each resource can have a maximum of 50 tags\.
+ For each resource, each tag key must be unique, and each tag key can have only one value\.
+ The maximum tag key length is 128 Unicode characters in UTF\-8\.
+ The maximum tag value length is 256 Unicode characters in UTF\-8\.
+ Allowed characters are letters, numbers, spaces representable in UTF\-8, and the following characters:*** \. : \+ = @ \_ / \-*** \(hyphen\)\. Amazon EC2 resources allow any characters\.
+ Tag keys and values are case sensitive\. As a best practice, decide on a strategy for capitalizing tags, and consistently implement that strategy across all resource types\. For example, decide whether to use `Costcenter`, `costcenter`, or `CostCenter`, and use the same convention for all tags\. Avoid using similar tags with inconsistent case treatment\. 
+ The `aws:` prefix is prohibited for tags; it's reserved for AWS use\. You can't edit or delete tag keys or values with this prefix\. Tags with this prefix do not count against your tags per resource quota\.