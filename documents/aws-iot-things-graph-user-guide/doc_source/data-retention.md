--------

--------

# Data Retention<a name="data-retention"></a>

The following characteristics of AWS IoT Things Graph relate to data retention:
+ When you use an API to delete an AWS IoT Things Graph resource, the service deletes that resource immediately\.
+ AWS IoT Things Graph retains some flow execution log data until you delete your AWS account\. When you delete your account, AWS IoT Things Graph deletes all remaining log data\.
+ When you create a new version of a namespace, AWS IoT Things Graph takes a snapshot of the earlier version\. These earlier versions of the namespace are deleted when you delete the namespace\.
+ When you deploy a flow to AWS IoT Greengrass, AWS IoT Things Graph creates a deployment artifact that contains the dependency closure of the flow configuration, and saves it to an Amazon S3 bucket that you specify\. After the deployment is complete, you can delete this artifact\.