# Configuring source authentication<a name="configure-source-authentication"></a>

If your OPC\-UA servers require authentication credentials to connect, you can define a user name and password in a secret for each source in AWS Secrets Manager\. Then, you add the secret to your Greengrass group and IoT SiteWise connector to make the secret available to your gateway\. For more information, see [Deploy secrets to the AWS IoT Greengrass core](https://docs.aws.amazon.com/greengrass/latest/developerguide/secrets.html) in the *AWS IoT Greengrass Developer Guide*\.

After a secret is available to your gateway, you can choose it when you configure a source\. Then, the gateway uses the authentication credentials from the secret when it connects to the source\. For more information, see [Configuring data sources](configure-sources.md)\.

**Topics**
+ [Creating source authentication secrets](#create-source-secrets)
+ [Adding secrets to a Greengrass group](#add-secret-to-group)
+ [Adding secrets to an IoT SiteWise connector](#add-secret-to-connector)

## Creating source authentication secrets<a name="create-source-secrets"></a>

In this procedure, you create an authentication secret for your source in Secrets Manager\. In the secret, define **username** and **password** key\-value pairs that contain authentication details for your source\.

**To create a source authentication secret**

1. Navigate to the [Secrets Manager console](https://console.aws.amazon.com/secretsmanager/)\.

1. Choose **Store a new secret**\.

1. Under **Select secret type**, choose **Other type of secrets**\.

1. Enter **username** and **password** key\-value pairs for your OPC\-UA server's authentication values, and then choose **Next**\.  
![\[AWS IoT Greengrass "Secret type" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-specify-secret-console.png)

1. Enter a **Secret name** that begins with `greengrass-`, such as **greengrass\-factory1\-auth**\.
**Important**  
You must use the `greengrass-` prefix for the default AWS IoT Greengrass service role to access your secrets\. If you want to name your secrets without this prefix, you must grant AWS IoT Greengrass custom permissions to access your secrets\. For more information, see [Allow AWS IoT Greengrass to get secret values](https://docs.aws.amazon.com/greengrass/latest/developerguide/secrets.html#secrets-config-service-role) in the *AWS IoT Greengrass Developer Guide*\.  
![\[AWS IoT Greengrass "Select secret name and description" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-name-secret-console.png)

1. Enter a **Description** and choose **Next**\.

1. \(Optional\) On the **Configure automatic rotation** page, configure automatic rotation for your secrets\. If you configure automatic rotation, you must redeploy your Greengrass group each time a secret rotates\.

1. On the **Configure automatic rotation** page, choose **Next**\.

1. Review your new secret and choose **Store**\.

## Adding secrets to a Greengrass group<a name="add-secret-to-group"></a>

In this procedure, you add your source authentication secrets to your AWS IoT Greengrass group to make them available to your IoT SiteWise connector\.

**To add a secret to your Greengrass group**

1. Navigate to the [AWS IoT Greengrass console](https://console.aws.amazon.com/greengrass/)\.

1. In the left navigation pane, under **Greengrass**, choose **Groups**, and then choose your group\.  
![\[AWS IoT Greengrass "Greengrass Groups" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-group-console.png)

1. In the left navigation page, choose **Resources**\. On the **Resources** page, choose the **Secret** tab, and then choose **Add a secret resource**\.  
![\[AWS IoT Greengrass "Resources" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-add-secret-console.png)

1. Choose **Select** and choose your secret from the list\.

1. Choose **Next**\.

1. In **Secret resource name**, enter a name for your secret resource and choose **Save**\.  
![\[AWS IoT Greengrass "Name your secret resource" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-name-secret-resource-console.png)

## Adding secrets to an IoT SiteWise connector<a name="add-secret-to-connector"></a>

In this procedure, you add your source authentication secrets to your IoT SiteWise connector to make them available to AWS IoT SiteWise and your gateway\.

**To add a secret to your IoT SiteWise connector**

1. Navigate to the [AWS IoT Greengrass console](https://console.aws.amazon.com/greengrass/)\.

1. In the left navigation pane, under **Greengrass**, choose **Groups**, and then choose your group\.  
![\[AWS IoT Greengrass "Greengrass Groups" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-group-console.png)

1. In the left navigation page, choose **Connectors**\.

1. Choose the ellipsis icon for the **IoT SiteWise** connector to open the options menu, and then choose **Edit**\.  
![\[AWS IoT Greengrass "Connectors" page screenshot with "Edit" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-edit-connector-console.png)

1. Under **List of ARNs for OPC\-UA username/password secrets**, choose **Select**, and then select each secret to add to this gateway\. If you need to create secrets, see [Creating source authentication secrets](#create-source-secrets)\.  
![\[AWS IoT Greengrass "Configure a connector" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-configure-connector-console.png)

   If your secret doesn't appear, choose **Refresh**\. If your secret still doesn't appear, check that you [added the secret to your Greengrass group](#add-secret-to-group)\.

1. Choose **Save**\.

1. In the upper\-right corner, in the **Actions** menu, choose **Deploy**\.

1. Choose **Automatic detection** to start the deployment\.

   If the deployment fails, choose **Deploy** again\. If the deployment continues to fail, see [AWS IoT Greengrass deployment troubleshooting](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html#gg-troubleshooting-deploymentissues)\.

   After your group deploys, you can configure a source that uses the new secret\. For more information, see [Configuring data sources](configure-sources.md)\.