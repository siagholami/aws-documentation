# Updating Instances<a name="updating-instances"></a>

You can update service instances in two ways, depending on which values you want to update:
+ **Update any values**: If you want to update any of the values that you specified for a service instance when you registered it, including custom attributes, you reregister the service instance and respecify all values\. See [To update a service instance](#updating-instances-procedure)\.
+ **Update only custom attributes**: If you want to update only the custom attributes for a service instance, you don't need to reregister the instance\. You can update only those values\. See [To update only custom attributes for a service instance](#updating-instance-attributes-procedure)\.<a name="updating-instances-procedure"></a>

**To update a service instance**

1. Sign in to the AWS Management Console and open the AWS Cloud Map console at [https://console\.aws\.amazon\.com/cloudmap/](https://console.aws.amazon.com/cloudmap/)\.

1. In the navigation pane, choose **Namespaces**\.

1. On the **Namespaces** page, choose the namespace that contains the service that you originally used to register the service instance\.

1. On the **Namespace: *namespace\-name*** page, choose the service that you used to register the service instance\.

1. On the **Service: *service\-name*** page, copy the ID of the service instance that you want to update\.

1. Choose **Register service instance**\.

1. On the **Register service instance** page, paste the ID that you copied in step 5 into **Service instance ID**\. 

1. Enter all the other values that you want to apply to the service instance\. The previous values for the service instance are not retained\. For more information, see [Values That You Specify When You Register or Update Instances](instances-values.md)\.

1. Choose **Register service instance**\.<a name="updating-instance-attributes-procedure"></a>

**To update only custom attributes for a service instance**

1. Sign in to the AWS Management Console and open the AWS Cloud Map console at [https://console\.aws\.amazon\.com/cloudmap/](https://console.aws.amazon.com/cloudmap/)\.

1. In the navigation pane, choose **Namespaces**\.

1. On the **Namespaces** page, choose the namespace that contains the service that you originally used to register the service instance\.

1. On the **Namespace: *namespace\-name*** page, choose the service that you used to register the service instance\.

1. On the **Service: *service\-name*** page, choose the name of the service instance that you want to update\.

1. In the **Custom attributes** section, choose **Edit**\.

1. On the **Edit service instance: *instance\-name*** page, add, remove, or update custom attributes\. You can update both keys and values for existing attributes\. 

1. Choose **Update service instance**\.