# Replicate VMs using the AWS SMS console<a name="console_workflow"></a>

You can use the AWS SMS console to import your server catalog and migrate your on\-premises servers to Amazon EC2\. For directions using the AWS Command Line Interface \(AWS CLI\), see [Replicate VMs using AWS CLI commands for AWS SMS](cli_workflow.md)\.

**Considerations**
+ You can replicate your on\-premises servers to AWS for up to 90 days per server\. Usage time is calculated from the time a server replication begins until you terminate the replication job\. After 90 days, your replication job is automatically terminated\. You can request an extension from AWS Support\.
+ If you have enabled integration between AWS SMS and AWS Migration Hub, your SMS server catalog is also visible on Migration Hub\. For more information, see [Import applications from Migration Hub](application-migration.md#migration-hub)\.
+ During the replication process, AWS SMS creates an Amazon S3 bucket in the Region on your behalf, with server\-side encryption enabled and a bucket policy to delete any items in the bucket after seven days\. AWS SMS replicates server volumes from your environment to this bucket and then creates EBS snapshots from the volumes\. If you do not delete this bucket, AWS SMS uses it for all replication jobs in this Region\.
+ During the AMI creation process, AWS SMS sets the `DeleteOnTermination` attribute for the root volume to false, overriding the default\. You can delete the root volume manually after you terminate the instance, or you can set the attribute to true so that Amazon EC2 deletes the root volume on instance termination\. For more information, see [Preserving Amazon EBS volumes on instance termination](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/terminating-instances.html#preserving-volumes-on-termination) in the *Amazon EC2 User Guide*\.

**Topics**
+ [Replicate a server](#configure_replication)
+ [Resume a replication job](#resume_replication)
+ [Monitor a server replication job](#monitor_replication)
+ [Delete a replication job](#delete_replication)

## Replicate a server<a name="configure_replication"></a>

AWS SMS automatically replicates live server volumes to AWS and creates an Amazon Machine Image \(AMI\) as needed\.

**To replicate a server**

1. Install the Server Migration Connector as described in [Install the Server Migration Connector](SMS_setup.md)\.

1. Open the AWS SMS console at [https://console\.aws\.amazon\.com/servermigration/](https://console.aws.amazon.com/servermigration/)\.

1. In the navigation menu, choose **Connectors**\. Verify that the connector that you deployed in your virtualization environment is shown with a status of healthy\.

1. If you have not yet imported a catalog, choose **Servers**, **Import server catalog**\. To reflect new servers added in your VMware environment after your previous import operation, choose **Re\-import server catalog**\. This process can take up to a minute\.

1. Select a server to replicate and choose **Create replication job**\.

1. On the **Configure server\-specific settings** page, in the **License type** column, select the license type for AMIs to be created from the replication job\. Linux servers can only use Bring Your Own License \(BYOL\)\. Windows servers can use either an AWS\-provided license or BYOL\. You can also choose **Auto** to allow AWS SMS to select the appropriate license\. Choose **Next**\.

1. On the **Configure replication job settings** page, provide the following information and then choose **Next**:
   + **Replication job type** — Specify the replication interval \(every 1\-24 hours\) or choose **One\-time migration**\.
   + **Start replication run** — Choose **Immediately** to start a replication run immediately or **At a later date and time** to start replication at the specified date and time, up to 30 days in the future\. The date and time are specified using the local time of your browser\.
   + **IAM service role** — Choose **Allow automation role creation** to have AWS SMS create a service\-linked role on your behalf or **Use my own role** to specify an existing IAM role\. For more information, see [Service\-linked roles for AWS SMS](using-service-linked-roles.md)\. This option is not present if AWS SMS has already created the service\-linked role on your behalf\.
   + **Description** — A description of the replication run\.
   + **Enable automatic AMI deletion** — To enable automatic AMI deletion, choose **Yes** and specify the maximum number of AMIs to keep \(from 1\-270\)\. To disable automatic AMI deletion, choose **No**\.
   + **Enable AMI encryption** — To enable AMI encryption, choose **Yes** and specify an encryption key \(using its key ID, Amazon Resource Name, or alias\) or leave blank to use the default key for EBS encryption\. To disable AMI encryption, choose **No**\.
   + **Enable notifications** — Choose **Yes** to configure Amazon Simple Notification Service \(Amazon SNS\) to notify a list of recipients when the replication job is completed, failed, or deleted\. For more information, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\.
   + **Pause replication job on consecutive failures** — Choose **Yes** to move the job to the `PausedOnFailure` state, not immediately to the `Failed` state, if the job encounters consecutive failures\. This option is not available for one\-time replication jobs\.

1. On the **Review** page, review your settings and update them as needed\. When you are finished, choose **Create**\. After the replication job is set up, replication starts automatically at the specified time and is repeated at the specified interval\.

In addition to your scheduled replication runs, you may also start up to two on\-demand replication runs per 24\-hour period\. On the **Replication jobs** page, select a job and choose **Actions**, **Start replication run**\. This starts a replication run that does not affect your scheduled replication runs, except in the case that the on\-demand run is still ongoing at the time of your scheduled run\. In this case, the scheduled run is skipped and rescheduled at the next interval\. The same thing happens if a scheduled run is due while a previous scheduled run is still in progress\.

## Resume a replication job<a name="resume_replication"></a>

AWS SMS can pause a replication job after the maximum number of consecutive scheduled replication jobs have failed\. Before attempting to resume a job that is in the `PausedOnFailure` state, try to identify and fix the root cause of the replication run failure\. For more information, see [Replication run fails during the preparing stage](troubleshoot-sms.md#preparing-failure)\.

**To resume a replication job that is paused**

1. In the AWS SMS console, choose **Replication jobs**\.

1. In the search bar, filter the jobs by `PausedOnFailure` to identify all paused jobs\.

1. To resume a paused job, select the job and choose **Actions**, **Resume replication job**\.

## Monitor a server replication job<a name="monitor_replication"></a>

You can manage and track the progress of each migration\.

**To monitor and modify server replication jobs**

1. In the AWS SMS console, choose **Replication jobs**\. You can view all replication jobs by scrolling through the table\. In the search bar, you can filter the table contents on specific values\. 

1. Select a single replication job to view details about it in the lower pane\. The **Job details** tab displays information about the current replication run, including the ID of the latest AMI created by the replication job\. The **Run history** tab shows details about all of the replication runs for the selected replication job\. 

1. To change any job parameters, select a job on the **Replication jobs** page and choose **Actions**, **Edit replication job**\. After entering new information in the **Edit configuration job** form, choose **Save** to commit your changes\. 
**Note**  
You may need to refresh the page for the changes to become visible\.

## Delete a replication job<a name="delete_replication"></a>

After you have finished replicating a server, you can delete the replication job\. This stops the replication job and cleans up any artifacts created by the service \(for example, the job's S3 bucket\)\. This does not delete any AMIs created by runs of the stopped job\. When you are done using a connector and no longer need it for any replication jobs, you can disassociate it from AWS SMS\.

**To shut down replication**

1. Choose **Replication jobs**, select the desired job, choose **Actions**, and then choose **Delete replication jobs**\. In the confirmation window, choose **Delete**\.
**Note**  
You may need to refresh the page for the changes to become visible\.

1. To clear your server catalog after you no longer need it, choose **Servers**, **Clear server catalog**\.

1. To disassociate a connector after you no longer need it, choose **Connectors** and select the connector\. Choose **Disassociate** at the top\-right corner of its information section and choose **Disassociate** again in the confirmation window\.