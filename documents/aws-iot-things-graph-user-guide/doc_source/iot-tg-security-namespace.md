--------

--------

# Security in AWS IoT Things Graph Namespaces<a name="iot-tg-security-namespace"></a>

Every entity that you use in a workflow must belong to your namespace\. For more information, see [Namespaces](iot-tg-whatis-namespace.html)\.

Entities stored in an account's namespace are available to all users in an account\. All users in the account have read and write access to all entity definitions in the namespace\.

Because you deploy AWS IoT Things Graph to AWS IoT Greengrass, you need to set up AWS IoT Greengrass security by following the steps in [Configuring Greengrass Security](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-sec.html#gg-config-sec) in the *AWS IoT Greengrass Developer Guide*\. 

When you deploy a workflow, you provide AWS IoT Things Graph with an IAM service role\. This role should contain all of the policies required for AWS IoT Things Graph to publish and subscribe to all of the MQTT topics that are used in the workflow\. 

For more information about IAM roles, see [Using IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use.html) in the *IAM User Guide*\.