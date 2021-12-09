# Step 3: Create a DAX Cluster Using the AWS CLI<a name="DAX.create-cluster.cli.create-cluster"></a>

Follow this procedure to use the AWS Command Line Interface \(AWS CLI\) to create an Amazon DynamoDB Accelerator \(DAX\) cluster in your default Amazon VPC\.

**To create a DAX cluster**

1. Get the Amazon Resource Name \(ARN\) for your service role\.

   ```
   aws iam get-role \
       --role-name DAXServiceRoleForDynamoDBAccess \
       --query "Role.Arn" --output text
   ```

   In the output, note the service role ARN, as in the following example\.

   `arn:aws:iam::123456789012:role/DAXServiceRoleForDynamoDBAccess`

1. Create the DAX cluster\. Replace `roleARN` with the ARN from the previous step\.

   ```
   aws dax create-cluster \
       --cluster-name mydaxcluster \
       --node-type dax.r4.large \
       --replication-factor 3 \
       --iam-role-arn roleARN \
       --subnet-group my-subnet-group \
       --sse-specification Enabled=true \
       --region us-west-2
   ```

   All of the nodes in the cluster are of type `dax.r4.large` \(`--node-type`\)\. There are three nodes \(`--replication-factor`\)—one primary node and two replicas\.

To view the cluster status, enter the following command\.

```
aws dax describe-clusters
```

The status is shown in the output—for example, `"Status": "creating"`\.

**Note**  
Creating the cluster takes several minutes\. When the cluster is ready, its status changes to `available`\. In the meantime, proceed to [Step 4: Configure Security Group Inbound Rules Using the AWS CLI](DAX.create-cluster.cli.configure-inbound-rules.md) and follow the instructions there\.