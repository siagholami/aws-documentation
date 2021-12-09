# Replicate VMs using AWS CLI commands for AWS SMS<a name="cli_workflow"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to inventory and migrate your on\-premises servers to Amazon EC2\. For directions using the AWS SMS console, see [Replicate VMs using the AWS SMS console](console_workflow.md)\.

**Prerequisites**
+ Install the Server Migration Connector as described in [Install the Server Migration Connector](SMS_setup.md)\.
+ If you have not used the AWS SMS console to start a replication job, you must use the following [create\-service\-linked\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/create-service-linked-role.html) command to create the required service\-linked role\.

  ```
  aws iam create-service-linked-role --aws-service-name sms.amazonaws.com
  ```

  For more information, see [Service\-linked roles for AWS SMS](using-service-linked-roles.md)\.

**Considerations**
+ You can replicate your on\-premises servers to AWS for up to 90 days per server\. Usage time is calculated from the time a server replication begins until you terminate the replication job\. After 90 days, your replication job is automatically terminated\. You can request an extension from AWS Support\.
+ If you have enabled integration between AWS SMS and AWS Migration Hub, your SMS server catalog is also visible on Migration Hub\. For more information, see [Import applications from Migration Hub](application-migration.md#migration-hub)\.
+ During the replication process, AWS SMS creates an Amazon S3 bucket in the Region on your behalf, with server\-side encryption enabled and a bucket policy to delete any items in the bucket after seven days\. AWS SMS replicates server volumes from your environment to this bucket and then creates EBS snapshots from the volumes\. If you do not delete this bucket, AWS SMS uses it for all replication jobs in this Region\.
+ During the AMI creation process, AWS SMS sets the `DeleteOnTermination` attribute for the root volume to false, overriding the default\. You can delete the root volume manually after you terminate the instance, or you can set the attribute to true so that Amazon EC2 deletes the root volume on instance termination\. For more information, see [Preserving Amazon EBS volumes on instance termination](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/terminating-instances.html#preserving-volumes-on-termination) in the *Amazon EC2 User Guide*\.

**To replicate a server using the CLI**

1. Use the [get\-connectors](https://docs.aws.amazon.com/cli/latest/reference/sms/get-connectors.html) command to obtain a list of connectors that are registered to you\.

   ```
   aws sms get-connectors
   ```

1. After a connector has been installed and registered through the console, use the [import\-server\-catalog](https://docs.aws.amazon.com/cli/latest/reference/sms/import-server-catalog.html) command to create an inventory of your servers\. This process can take up to a minute\.

   ```
   aws sms import-server-catalog
   ```

1. Use the [get\-servers](https://docs.aws.amazon.com/cli/latest/reference/sms/get-servers.html) command to display a list of servers available for import to Amazon EC2\.

   ```
   aws sms get-servers
   ```

   The output should be similar to the following:

   ```
   {
       "serverList": [
           {
               "serverId": "s-12345678", 
               "serverType": "VIRTUAL_MACHINE", 
               "vmServer": {
                   "vmManagerName": "vcenter.yourcompany.com", 
                   "vmServerAddress": {
                       "vmManagerId": "your-vcenter-instance-uuid", 
                       "vmId": "vm-123"
                   }, 
                   "vmName": "your-linux-vm", 
                   "vmPath": "/Datacenters/DC1/vm/VM Folder Path/your-linux-vm", 
                   "vmManagerType": "vSphere"
               }
           }, 
           {
               "replicationJobTerminated": false, 
               "serverId": "s-23456789", 
               "serverType": "VIRTUAL_MACHINE", 
               "replicationJobId": "sms-job-12345678", 
               "vmServer": {
                   "vmManagerName": "vcenter.yourcompany.com", 
                   "vmServerAddress": {
                       "vmManagerId": "your-vcenter-instance-uuid", 
                       "vmId": "vm-234"
                   }, 
                   "vmName": "Your Windows VM", 
                   "vmPath": "/Datacenters/DC1/vm/VM Folder Path/Your Windows VM", 
                   "vmManagerType": "vSphere"
               }
           }
       ]
   }
   ```

   If you have not yet imported a server catalog, you see output similar to the following:

   ```
   {
       "lastModifiedOn": 1477006131.856, 
       "serverCatalogStatus": "NOT IMPORTED", 
       "serverList": []
   }
   ```

   A catalog status of DELETED or EXPIRED also shows that no servers exist in the catalog\.

1. Select a server to replicate, note the server ID, and specify the ID in the [create\-replication\-job](https://docs.aws.amazon.com/cli/latest/reference/sms/create-replication-job.html) command\.

   ```
   aws sms create-replication-job --server-id s-12345678 \
       --frequency 12 \
       --seed-replication-time 2016-10-24T15:30:00-07:00 \
       --role-name AWSServiceRoleForSMS
   ```

   After the replication job is set up, it starts replicating automatically at the time specified with the `--seed-replication-time` parameter, expressed in seconds of the Unix epoch or according to ISO 8601\. For more information, see [Specifying Parameter Values for the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html)\. Thereafter, the replication repeats with an interval specified by the `--frequency` parameter, expressed in hours\.

1. You can view details of all running replication jobs using the [get\-replication\-jobs](https://docs.aws.amazon.com/cli/latest/reference/sms/get-replication-jobs.html) command\. If you do not specify any parameters, the command lists all your replication jobs\.

   This command returns output similar to the following:

   ```
   {
       "replicationJobList": [
           {
               "vmServer": {
                   "vmManagerName": "vcenter.yourcompany.com", 
                   "vmServerAddress": {
                       "vmManagerId": "your-vcenter-instance-uuid", 
                       "vmId": "vm-1234"
                   }, 
                   "vmName": "VM name in vCenter", 
                   "vmPath": "/Datacenters/DC1/vm/VM Folder Path/VM name in vCenter"
               }, 
               "replicationRunList": [
                   {
                       "scheduledStartTime": 1487007010.0, 
                       "state": "Deleted", 
                       "type": "Automatic", 
                       "statusMessage": "Uploading", 
                       "replicationRunId": "sms-run-12345678"
                   }
               ], 
               "replicationJobId": "sms-job-98765432", 
               "state": "Deleted", 
               "frequency": 12, 
               "seedReplicationTime": 1477007049.0, 
               "roleName": "sms"
           }, 
           {
               "vmServer": {
                   "vmManagerName": "vcenter.yourcompany.com", 
                   "vmServerAddress": {
                       "vmManagerId": "your-vcenter-instance-uuid", 
                       "vmId": "vm-2345"
                   }, 
                   "vmName": "win2k12", 
                   "vmPath": "/Datacenters/DC1/vm/VM Folder Path/win2k12"
               }, 
               "replicationRunList": [
                   {
                       "scheduledStartTime": 1477008789.0, 
                       "state": "Active", 
                       "type": "Automatic", 
                       "statusMessage": "Converting", 
                       "replicationRunId": "sms-run-12345679"
                   }
               ], 
               "replicationJobId": "sms-job-23456789", 
               "state": "Active", 
               "frequency": 24, 
               "seedReplicationTime": 1477008789.0, 
               "roleName": "sms"
           }
       ]
   }
   ```

1. You can also use the [get\-replication\-runs](https://docs.aws.amazon.com/cli/latest/reference/sms/get-replication-runs.html) command to retrieve information about all replication runs for a specific replication job\. To do this, specify a replication job ID as follows:

   ```
   aws sms get-replication-runs --replication-job-id sms-job-12345678
   ```

   This command returns a list of all replication runs for the specified replication job, as well as details for that replication job, similar to the following:

   ```
   {
       "replicationRunList": [
           {
               "scheduledStartTime": 1477310423.0,
               "state": "Active",
               "type": "Automatic",
               "statusMessage": "Converting",
               "replicationRunId": "sms-run-23456789"
           },
           {
               "amiId": "ami-abcdefab",
               "state": "Completed",
               "completedTime": 1477227683.652,
               "scheduledStartTime": 1477224023.0,
               "replicationRunId": "sms-run-34567890",
               "type": "Automatic",
               "statusMessage": "Completed"
           },
           {
               "amiId": "ami-efababcd",
               "state": "Completed",
               "completedTime": 1477144823.486,
               "scheduledStartTime": 1477137623.0,
               "replicationRunId": "sms-run-45678903",
               "type": "Automatic",
               "statusMessage": "Completed"
           }
       ]
   }
   ```

1. To change any of the parameters of a replication job after you have created it, use the [update\-replication\-job](https://docs.aws.amazon.com/cli/latest/reference/sms/update-replication-job.html) command, by providing the replication job ID and any parameters to change\.

   ```
   aws sms update-replication-job --replication-job-id sms-job-12345678 --frequency 24 --next-replication-run-start-time 2016-10-24T15:30:00-07:00
   ```

1. In addition to your scheduled replication runs, you may also start up to two on\-demand replication runs per 24\-hour period\. To do this, use the [start\-on\-demand\-replication\-run](https://docs.aws.amazon.com/cli/latest/reference/sms/start-on-demand-replication-run.html) command, which starts a replication run immediately\. If another replication run is currently active, an on\-demand replication run cannot be started\.

   ```
   aws sms start-on-demand-replication-run --replication-job-id sms-job-12345678
   ```

   If a scheduled replication run is expected to start while an on\-demand replication run is ongoing, then the scheduled run is skipped and rescheduled for the next interval\.

1. After you are finished replicating a server, you may stop the replication job using the [delete\-replication\-job](https://docs.aws.amazon.com/cli/latest/reference/sms/delete-replication-job.html) command\. This stops the replication job and cleans up any artifacts created by the service \(for example, the job's S3 bucket\)\. This does not delete any AMIs created by runs of the stopped job\.

   ```
   aws sms delete-replication-job --replication-job-id sms-job-12345678
   ```

1. When you no longer need to maintain your catalog of servers, use the [delete\-server\-catalog](https://docs.aws.amazon.com/cli/latest/reference/sms/delete-server-catalog.html) command to clear the catalog of servers maintained by the service\.

   ```
   aws sms delete-server-catalog
   ```

1. When you are done using a connector, use the [disassociate\-connector](https://docs.aws.amazon.com/cli/latest/reference/sms/disassociate-connector.html) command to deregister the connector from AWS SMS\. Call this command only after all replications using that connector are complete\.

   ```
   aws sms disassociate-connector --connector-id c-12345678901234567
   ```