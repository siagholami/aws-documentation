# Automating Managed Blockchain Proposal Notifications with CloudWatch Events<a name="automating-proposals-with-cloudwatch-events"></a>

Amazon CloudWatch Events enables you to automate your AWS services and respond automatically to system events\. Events from AWS services are delivered to CloudWatch Events in near real time\. You can write simple rules to indicate which events are of interest to you, and what automated actions to take when an event matches a rule\. With Managed Blockchain, you can monitor CloudWatch Events events to respond to proposals, including invitations sent to your AWS account to join a network, and notification that proposals are `APPROVED` or `REJECTED`\. Some examples include notifying an Amazon SNS topic or an AWS SMS queue when an invitation is sent or when a proposal made by a member in your account changes status\.

For more information, see the [Amazon CloudWatch Events User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/)\.

## Example Managed Blockchain Events<a name="automating-proposals-sample-events"></a>

### AWS Account Received an Invitation Event<a name="sample-event-invitation"></a>

The `detail-type` of these messages is `Managed Blockchain Invitation State Change`\.

```
{
    "version": "0",
    "id": "abcd1234-eeee-4321-a1a2-123456789012",
    "detail-type": "Managed Blockchain Invitation State Change",
    "source": "aws.managedblockchain",
    "account": "123456789012",
    "time": "2019-04-08T23:40:20.628Z",
    "region": "us-east-1",
    "resources": [],
    "detail": {
        "invitationId": "i-XL9MDD6LVWWDNA9FF94Y4TFTE",
        "networkId": "n-MWY63ZJZU5HGNCMBQER7IN6OIU",
        "networkName": "ExampleCorpNetwork",
        "status": "PENDING",
        "expirationDate": "2019-04-09T23:40:20.628Z",
        "message": "You have received invitation i-XL9MDD6LVWWDNA9FF94Y4TFTE for Amazon Managed Blockchain Network n-MWY63ZJZU5HGNCMBQER7IN6OIU and it will expire at 2016-12-16 20:42 UTC."
    }
}
```

### Proposal State Change Event<a name="sample-event-proposal-state-change"></a>

The `detail-type` of these messages is `Managed Blockchain Proposal State Change`\. The following example shows an event for a proposal that changed state to `APPROVED`\.

```
{
    "version": "0",
    "id": "abcd1234-eeee-4321-a1a2-123456789012",
    "detail-type": "Managed Blockchain Proposal State Change",
    "source": "aws.managedblockchain",
    "account": "123456789012",
    "time": "2019-04-08T23:40:20.628Z",
    "region": "us-east-1",
    "resources": [],
    "detail": {
        "proposalId": "p-ZR7KUD2YYNESLNG6RQ33X3FUFE",
        "networkId": "n-MWY63ZJZU5HGNCMBQER7IN6OIU",
        "status": "APPROVED",
        "proposedByMemberId": "m-K46ICRRXJRCGRNNS4ES4XUUS5A",
        "proposedByMemberName": "NetworkMember1",
        "expirationDate": "2019-04-09T23:40:20.628Z",
        "description": "Proposal to remove AnyCompany from supply chain blockchain network.",
        "message": "Voting on proposal p-ZR7KUD2YYNESLNG6RQ33X3FUFE in Amazon Managed Blockchain Network n-MWY63ZJZU5HGNCMBQER7IN6OIU completed at 2016-19-16T20:10:50Z UTC and the proposal was approved."
    }
}
```