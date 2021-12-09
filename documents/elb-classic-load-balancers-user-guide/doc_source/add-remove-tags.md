# Tag your Classic Load Balancer<a name="add-remove-tags"></a>

Tags help you to categorize your load balancers in different ways, for example, by purpose, owner, or environment\.

You can add multiple tags to each Classic Load Balancer\. Tag keys must be unique for each load balancer\. If you add a tag with a key that is already associated with the load balancer, it updates the value of that tag\.

When you are finished with a tag, you can remove it from your load balancer\.

**Topics**
+ [Tag restrictions](#tag-restrictions)
+ [Add a tag](#add-tags)
+ [Remove a tag](#remove-tags)

## Tag restrictions<a name="tag-restrictions"></a>

The following basic restrictions apply to tags:
+ Maximum number of tags per resource—50
+ Maximum key length—127 Unicode characters
+ Maximum value length—255 Unicode characters
+ Tag keys and values are case sensitive\. Allowed characters are letters, spaces, and numbers representable in UTF\-8, plus the following special characters: \+ \- = \. \_ : / @\. Do not use leading or trailing spaces\.
+ Do not use the `aws:` prefix in your tag names or values because it is reserved for AWS use\. You can't edit or delete tag names or values with this prefix\. Tags with this prefix do not count against your tags per resource limit\. 

## Add a tag<a name="add-tags"></a>

You can add tags to your load balancer at any time\.

**To add a tag using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Tags** tab, choose **Add/Edit Tags**\.

1. On the **Add/Edit Tags** page, for each tag, choose **Create Tag** and then specify a key and a value\.  
![\[Add-Edit Tags\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/images/AddEdit-Tags.png)

1. After you have finished adding tags, choose **Save**\.

**To add a tag using the AWS CLI**  
Use the following [add\-tags](https://docs.aws.amazon.com/cli/latest/reference/elb/add-tags.html) command to add the specified tag:

```
aws elb add-tags --load-balancer-name my-loadbalancer --tag "Key=project,Value=lima"
```

## Remove a tag<a name="remove-tags"></a>

You can remove tags from your load balancer whenever you are finished with them\.

**To remove a tag using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Tags** tab, choose **Add/Edit Tags**\.

1. On the **Add/Edit Tags** page, choose the remove icon of the tag\.  
![\[Add-Edit Tags\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/images/RemoveTags.png)

1. After you are have finished removing tags, choose **Save**\. 

**To remove a tag using the AWS CLI**  
Use the following [remove\-tags](https://docs.aws.amazon.com/cli/latest/reference/elb/remove-tags.html) command to remove the tag with the specified key:

```
aws elb remove-tags --load-balancer-name my-loadbalancer --tag project
```