# Tagging Your AWS RoboMaker Resources<a name="tagging-robomaker"></a>

To help you manage and organize your fleets, robots, robot applications, simulation applications, simulation jobs and and deployments you can optionally assign your own metadata to each of these resources in the form of tags\. This section describes tags and shows you how to create them\.

## Tag Basics<a name="tagging-robomaker-basics"></a>

Tags enable you to categorize your AWS RoboMaker resources in different ways, for example, by purpose, owner, or environment\. This is useful when you have many resources of the same type — you can quickly identify a specific resource based on the tags you've assigned to it\. Each tag consists of a key and optional value, both of which you define\. For example, you could define a set of tags for your robots that helps you track devices by function\. We recommend that you create a set of tag keys that meets your needs for each kind of resource\. Using a consistent set of tag keys makes it easier for you to manage your resources\.

You can search for and filter resources based on the tags you add or apply\. You can also use tags to control access to your resources as described in [Using Tags with IAM Policies](tagging-robomaker-iam.md#tagging-robomaker-iam.title)\. 

For ease of use, the Tag Editor in the AWS Management Console provides a central, unified way to create and manage your tags\. For more information, see [Working with Tag Editor](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/tag-editor.html) in [ Working with the AWS Management Console](http://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.

You can also work with tags using the AWS CLI and the AWS RoboMaker API\. You can associate tags with thing groups, thing types, topic rules, jobs, security profiles, and billing groups when you create them by using the "Tags" field in the following commands: 
+ [CreateDeploymentJob](https://docs.aws.amazon.com/robomaker/latest/dg/API_CreateDeploymentJob.html)
+ [CreateFleet](https://docs.aws.amazon.com/robomaker/latest/dg/API_CreateFleet.html)
+ [CreateRobot](https://docs.aws.amazon.com/robomaker/latest/dg/API_CreateRobot.html)
+ [CreateRobotApplication](https://docs.aws.amazon.com/robomaker/latest/dg/API_CreateRobotApplication.html)
+ [CreateSimulationApplication](https://docs.aws.amazon.com/robomaker/latest/dg/API_CreateSimulationApplication.html)
+ [CreateSimulationJob](https://docs.aws.amazon.com/robomaker/latest/dg/API_CreateSimulationJob.html)
+ [StartSimulationJobBatch](https://docs.aws.amazon.com/robomaker/latest/dg/API_CreateSimulationJobStart.html)

You can add, modify, or delete tags for existing resources that support tagging by using the following commands:
+ [TagResource](https://docs.aws.amazon.com/robomaker/latest/dg/API_TagResource.html)
+ [ListTagsForResource](https://docs.aws.amazon.com/robomaker/latest/dg/API_ListTagsForResource.html)
+ [UntagResource](https://docs.aws.amazon.com/robomaker/latest/dg/API_UntagResource.html)

You can edit tag keys and values, and you can remove tags from a resource at any time\. You can set the value of a tag to an empty string, but you can't set the value of a tag to null\. If you add a tag that has the same key as an existing tag on that resource, the new value overwrites the old value\. If you delete a resource, any tags associated with the resource are also deleted\.

Additional information is available in [AWS Tagging Strategies](https://aws.amazon.com/answers/account-management/aws-tagging-strategies/)\.

### Tag Restrictions and Limitations<a name="tagging-robomaker-restrict"></a>

The following basic restrictions apply to tags:
+ Maximum number of tags per resource — 50
+ Maximum key length — 127 Unicode characters in UTF\-8
+ Maximum value length — 255 Unicode characters in UTF\-8
+ Tag keys and values are case\-sensitive\.
+ Do not use the "aws:" prefix in your tag names or values because it's reserved for AWS use\. You can't edit or delete tag names or values with this prefix\. Tags with this prefix don't count against your tags per resource limit\.
+ If your tagging schema is used across multiple services and resources, remember that other services may have restrictions on allowed characters\. Generally, allowed characters are: letters, spaces, and numbers representable in UTF\-8, and the following special characters: \+ \- = \. \_ : / @\. 