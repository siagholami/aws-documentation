# Viewing an Amazon Aurora DB Cluster<a name="Aurora.Viewing"></a>

You have several options for viewing information about your Amazon Aurora DB clusters and the DB instances in your DB clusters\.
+ You can view DB clusters and DB instances in the Amazon RDS console by choosing **Databases** from the navigation pane\. 
+ You can get DB cluster and DB instance information using the AWS Command Line Interface \(AWS CLI\)\.
+ You can get DB cluster and DB instance information using the Amazon RDS API\.

## Console<a name="Aurora.Viewing.Console"></a>

In the Amazon RDS, you can see details about a DB cluster by choosing **Databases** from the console's navigation pane\. You can also see details about DB instances that are members of an Amazon Aurora DB cluster on the **Databases** page\.

The **Databases** list shows all of the DB clusters for your AWS account\. When you choose a DB cluster, you see both information about the DB cluster and also a list of the DB instances that are members of that DB cluster\. You can choose the identifier for a DB instance in the list to go directly to the details page for that DB instance in the RDS console\.

To view the details page for a DB cluster, choose **Databases** in the navigation pane, and then choose the name of the DB cluster\.

You can modify your DB cluster by choosing **Databases** from the console's navigation pane to go to the **Databases** list\. To modify a DB cluster, select the DB cluster from the **Databases** list and choose **Modify**\.

To modify a DB instance that is a member of a DB cluster, choose **Databases** from the console's navigation pane to go to the **Databases** list\.

For example, the following image shows the details page for the DB cluster named `aurora-test`\. The DB cluster has four DB instances shown in the **DB identifier** list\. The writer DB instance, `dbinstance4`, is the primary DB instance for the DB cluster\.

![\[Amazon Aurora DB Cluster View\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/images/AuroraView01.png)

If you click the link for the `dbinstance4` DB instance identifier, the Amazon RDS console shows the details page for the `dbinstance4` DB instance, as shown in the following image\.

![\[Amazon Aurora DB Instance View\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/images/AuroraView02.png)

## AWS CLI<a name="Aurora.Viewing.CLI"></a>

To view DB cluster information by using the AWS CLI, use the [describe\-db\-clusters](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-clusters.html) command\. For example, the following AWS CLI command lists the DB cluster information for all of the DB clusters in the `us-east-1` region for the configured AWS account\.

```
aws rds describe-db-clusters --region us-east-1
```

The command returns the following output if your AWS CLI is configured for JSON output\.

```
{
    "DBClusters": [
        {
            "Status": "available",
            "Engine": "aurora",
            "Endpoint": "sample-cluster1.cluster-123456789012.us-east-1.rds.amazonaws.com"
            "AllocatedStorage": 1,
            "DBClusterIdentifier": "sample-cluster1",
            "MasterUsername": "mymasteruser",
            "EarliestRestorableTime": "2016-03-30T03:35:42.563Z",
            "DBClusterMembers": [
                {
                    "IsClusterWriter": false,
                    "DBClusterParameterGroupStatus": "in-sync",
                    "DBInstanceIdentifier": "sample-replica"
                },
                {
                    "IsClusterWriter": true,
                    "DBClusterParameterGroupStatus": "in-sync",
                    "DBInstanceIdentifier": "sample-primary"
                }
            ],
            "Port": 3306,
            "PreferredBackupWindow": "03:34-04:04",
            "VpcSecurityGroups": [
                {
                    "Status": "active",
                    "VpcSecurityGroupId": "sg-ddb65fec"
                }
            ],
            "DBSubnetGroup": "default",
            "StorageEncrypted": false,
            "DatabaseName": "sample",
            "EngineVersion": "5.6.10a",
            "DBClusterParameterGroup": "default.aurora5.6",
            "BackupRetentionPeriod": 1,
            "AvailabilityZones": [
                "us-east-1b",
                "us-east-1c",
                "us-east-1d"
            ],
            "LatestRestorableTime": "2016-03-31T20:06:08.903Z",
            "PreferredMaintenanceWindow": "wed:08:15-wed:08:45"
        },
        {
            "Status": "available",
            "Engine": "aurora",
            "Endpoint": "aurora-sample.cluster-123456789012.us-east-1.rds.amazonaws.com",
            "AllocatedStorage": 1,
            "DBClusterIdentifier": "aurora-sample-cluster",
            "MasterUsername": "mymasteruser",
            "EarliestRestorableTime": "2016-03-30T10:21:34.826Z",
            "DBClusterMembers": [
                {
                    "IsClusterWriter": false,
                    "DBClusterParameterGroupStatus": "in-sync",
                    "DBInstanceIdentifier": "aurora-replica-sample"
                },
                {
                    "IsClusterWriter": true,
                    "DBClusterParameterGroupStatus": "in-sync",
                    "DBInstanceIdentifier": "aurora-sample"
                }
            ],
            "Port": 3306,
            "PreferredBackupWindow": "10:20-10:50",
            "VpcSecurityGroups": [
                {
                    "Status": "active",
                    "VpcSecurityGroupId": "sg-55da224b"
                }
            ],
            "DBSubnetGroup": "default",
            "StorageEncrypted": false,
            "DatabaseName": "sample",
            "EngineVersion": "5.6.10a",
            "DBClusterParameterGroup": "default.aurora5.6",
            "BackupRetentionPeriod": 1,
            "AvailabilityZones": [
                "us-east-1b",
                "us-east-1c",
                "us-east-1d"
            ],
            "LatestRestorableTime": "2016-03-31T20:00:11.491Z",
            "PreferredMaintenanceWindow": "sun:03:53-sun:04:23"
        }
    ]
}
```

## RDS API<a name="Aurora.Viewing.API"></a>

To view DB cluster information using the Amazon RDS API, use the [DescribeDBClusters](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_DescribeDBClusters.html) operation\. For example, the following Amazon RDS API command lists the DB cluster information for all of the DB clusters in the `us-east-1` region\.

```
https://rds.us-east-1.amazonaws.com/
    ?Action=DescribeDBClusters
    &MaxRecords=100
    &SignatureMethod=HmacSHA256
    &SignatureVersion=4
    &Version=2014-10-31
    &X-Amz-Algorithm=AWS4-HMAC-SHA256
    &X-Amz-Credential=AKIADQKE4SARGYLE/20140722/us-east-1/rds/aws4_request
    &X-Amz-Date=20140722T200807Z
    &X-Amz-SignedHeaders=content-type;host;user-agent;x-amz-content-sha256;x-amz-date
    &X-Amz-Signature=2d4f2b9e8abc31122b5546f94c0499bba47de813cb875f9b9c78e8e19c9afe1b
```

The action returns the following output:

```
<DescribeDBClustersResponse xmlns="http://rds.amazonaws.com/doc/2014-10-31/">
  <DescribeDBClustersResult>
    <DBClusters>
      <DBCluster>
        <Engine>aurora5.6</Engine>
        <Status>available</Status>
        <BackupRetentionPeriod>0</BackupRetentionPeriod>
        <DBSubnetGroup>my-subgroup</DBSubnetGroup>
        <EngineVersion>5.6.10a</EngineVersion>
        <Endpoint>sample-cluster2.cluster-cbfvmgb0y5fy.us-east-1.rds.amazonaws.com</Endpoint>
        <DBClusterIdentifier>sample-cluster2</DBClusterIdentifier>
        <PreferredBackupWindow>04:45-05:15</PreferredBackupWindow>
        <PreferredMaintenanceWindow>sat:05:56-sat:06:26</PreferredMaintenanceWindow>
        <DBClusterMembers/>
        <AllocatedStorage>15</AllocatedStorage>
        <MasterUsername>awsuser</MasterUsername>
      </DBCluster>
      <DBCluster>
        <Engine>aurora5.6</Engine>
        <Status>available</Status>
        <BackupRetentionPeriod>0</BackupRetentionPeriod>
        <DBSubnetGroup>my-subgroup</DBSubnetGroup>
        <EngineVersion>5.6.10a</EngineVersion>
        <Endpoint>sample-cluster3.cluster-cefgqfx9y5fy.us-east-1.rds.amazonaws.com</Endpoint>
        <DBClusterIdentifier>sample-cluster3</DBClusterIdentifier>
        <PreferredBackupWindow>07:06-07:36</PreferredBackupWindow>
        <PreferredMaintenanceWindow>tue:10:18-tue:10:48</PreferredMaintenanceWindow>
        <DBClusterMembers>
          <DBClusterMember>
            <IsClusterWriter>true</IsClusterWriter>
            <DBInstanceIdentifier>sample-cluster3-master</DBInstanceIdentifier>
          </DBClusterMember>
          <DBClusterMember>
            <IsClusterWriter>false</IsClusterWriter>
            <DBInstanceIdentifier>sample-cluster3-read1</DBInstanceIdentifier>
          </DBClusterMember>
        </DBClusterMembers>
        <AllocatedStorage>15</AllocatedStorage>
        <MasterUsername>awsuser</MasterUsername>
      </DBCluster>
    </DBClusters>
  </DescribeDBClustersResult>
  <ResponseMetadata>
    <RequestId>d682b02c-1383-11b4-a6bb-172dfac7f170</RequestId>
  </ResponseMetadata>
</DescribeDBClustersResponse>
```