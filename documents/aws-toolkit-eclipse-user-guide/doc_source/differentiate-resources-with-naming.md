# Differentiating AWS Resources with Naming<a name="differentiate-resources-with-naming"></a>

During development of new products or features, it is useful to keep AWS resources that are used for development separate from resources that are used for production\. One approach to maintaining this separation was discussed in the [Set up AWS Credentials](setup-credentials.md), that is, to use different accounts for development and production resources\. That approach works especially well when using AWS Explorer, because AWS Explorer displays resources based on account credentials\. This section will discuss an alternative approach in which a naming convention is used to differentiate between development and production resources—and in which support for the naming convention is implemented in code\.

The basic idea is to distinguish your AWS resources, such as Amazon Simple Storage Service \(Amazon S3\) buckets or Amazon SimpleDB domains, by adding a designated string value to the resource name\. For example, instead of naming your Amazon SimpleDB domain “customers”, you would name it “customers\-dev” for development use or “customer\-prod” for production use\. However, an issue arises if you need to move development code into production\. At that point, you would need to change all these strings, perhaps with a number of global search and replace operations; that could be tedious or error prone\. A more efficient method would be to add support for the naming convention in the code\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-stage-utils.png)

The `StageUtils` class exposes the following method\.

```
public static String getResourceSuffixForCurrentStage()
```

The `getResourceSuffixForCurrentStage` method returns a string that corresponds to the “stage” in the software life cycle for which the resource is used, such as “dev” or “beta” or “prod”\. This string can then be appended to resource identifiers used in code\. You can use `getResourceSuffixForCurrentStage` to construct resource names\. For example, the following method, `getTopicName`, returns a unique name for an Amazon SNS topic\. Notice how it embeds the return value from `getResourceSuffixForCurrentStage` in this name\.

```
private String getTopicName (Entry entry) {
    return "entry" + StageUtils.getResourceSuffixForCurrentStage() + "-" + entry.getId();
}
```

The value returned by `getResourceSuffixForCurrentStage` is retrieved from the Java system property, “application\.stage”\. You can specify this value by setting the system property in the container configuration for AWS Elastic Beanstalk\.

**Note**  
In the AWS Toolkit for Eclipse, your AWS Elastic Beanstalk application needs to be up and running in order for you to access the container configuration\. Changing and saving the configuration causes the application to automatically restart with the new configuration\.

 **To access the Container/JVM Options panel for your AWS Elastic Beanstalk application** 

1. In **AWS Explorer**, expand the **AWS Elastic Beanstalk** node and your application node\.

1. Beneath the application node, double\-click your AWS Elastic Beanstalk environment\.

1. At the bottom of the **Overview** pane, click the **Configuration** tab\.

1. In the **Container** area, configure the container options\.

1. In the **Additional Tomcat JVM command line options** box, specify the value for the application\.stage system property by adding a `-D` command line option\. For example, you could use the following syntax to specify that the string value should be “\-beta”\.

    `-Dapplication.stage=beta` 

   Note that `getResourceSuffixForCurrentStage` automatically prepends a hyphen character to whatever string value you specify\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-container-config.png)

1. After you have added the system property value, click the **File** menu, and then click **Save**\. Eclipse will save the new configuration\. The application should restart automatically\. You can check the **Events** tab—at the bottom of the Eclipse editor—for the event that indicates that the new configuration was successfully deployed to the environment\.

1. After the application restarts, expand the **Amazon SimpleDB** node in **AWS Explorer**\. You should now see a new set of domains that use the string value that you specified\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-domains-beta.png)

**Note**  
For more information about configuring the container, see [Creating and Deploying Java Applications on AWS Elastic Beanstalk](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/create_deploy_Java.html) in the AWS Elastic Beanstalk Developer Guide\.