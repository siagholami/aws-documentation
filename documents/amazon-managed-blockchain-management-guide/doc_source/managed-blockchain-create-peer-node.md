# Create a Peer Node<a name="managed-blockchain-create-peer-node"></a>

You can create a peer node in a member that is in your AWS account using the AWS Management Console, the AWS CLI, or the Managed Blockchain SDK [CreateNode](https://docs.aws.amazon.com/managed-blockchain/latest/APIReference/>API_CreateNode.html) action\.

## To create a peer node using the AWS Management Console<a name="w22aac21c15b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Choose **Networks**, select the network from the list, and then choose **View details**\.

1. Select a **Member** from the list, and then choose **Create peer node**\.

1. Choose configuration parameters for your peer node according to the previous guidelines, and then choose **Create peer node**\.

## To create a peer node using the AWS CLI<a name="w22aac21c15b5b3"></a>
+ Use the `create-node` command, as shown in the following example\. Replace the value of `--network-id`, `--member-id`, and `AvailabilityZone` as appropriate\.

  ```
  [ec2-user@ip-192-0-2-17 ~]$ aws managedblockchain create-node \
  --node-configuration '{"InstanceType":"bc.t3.small","AvailabilityZone":"us-east-1a"}' \
  --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU \
  --member-id m-K46ICRRXJRCGRNNS4ES4XUUS5A
  ```

  The command returns output that includes the peer node's `NodeID`, as shown in the following example:

  ```
  {
       "NodeId": "nd-6EAJ5VA43JGGNPXOUZP7Y47E4Y"
  }
  ```