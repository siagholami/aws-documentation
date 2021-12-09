# Amazon Managed Blockchain Management Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [What Is Amazon Managed Blockchain?](what-is-managed-blockchain.md)
+ [Key Concepts: Managed Blockchain Networks, Members, and Peer Nodes](network-components.md)
+ [Get Started Creating a Hyperledger Fabric Blockchain Network Using Amazon Managed Blockchain](managed-blockchain-get-started-tutorial.md)
   + [Prerequisites and Considerations](get-started-prerequisites.md)
   + [Step 1: Create the Network and First Member](get-started-create-network.md)
   + [Step 2: Create and Configure the Interface VPC Endpoint](get-started-create-endpoint.md)
   + [Step 3: Create an Amazon EC2 Instance and Set Up the Hyperledger Fabric Client](get-started-create-client.md)
   + [Step 4: Enroll an Administrative User](get-started-enroll-admin.md)
   + [Step 5: Create a Peer Node in Your Membership](get-started-create-peer-node.md)
   + [Step 6: Create a Hyperledger Fabric Channel](get-started-create-channel.md)
   + [Step 7: Install and Run Chaincode](get-started-chaincode.md)
   + [Step 8: Invite Another AWS Account to be a Member and Create a Joint Channel](get-started-joint-channel.md)
+ [Create an Amazon Managed Blockchain Network](create-network.md)
+ [Delete an Amazon Managed Blockchain Network](delete-network.md)
+ [Invite or Remove Members](managed-blockchain-members.md)
+ [Accept an Invitation to Create a Member and Join a Managed Blockchain Network](managed-blockchain-hyperledger-member.md)
   + [Work with Invitations](accept-invitation.md)
   + [Create a Member and Join a Network](managed-blockchain-hyperledger-create-member.md)
+ [Create an Interface VPC Endpoint to Connect to Managed Blockchain Network Resources](managed-blockchain-endpoints.md)
+ [Work with Peer Nodes in a Managed Blockchain Network](managed-blockchain-hyperledger-peer-nodes.md)
   + [Create a Peer Node](managed-blockchain-create-peer-node.md)
   + [View Peer Node Properties](managed-blockchain-view-peer-node.md)
   + [Use Peer Node Metrics](managed-blockchain-peer-node-metrics.md)
+ [Work with Proposals](managed-blockchain-proposals.md)
   + [Automating Managed Blockchain Proposal Notifications with CloudWatch Events](automating-proposals-with-cloudwatch-events.md)
+ [Work with Hyperledger Fabric](framework-client.md)
   + [Register and Enroll a User as an Administrator](managed-blockchain-hyperledger-create-admin.md)
   + [Develop Chaincode](managed-blockchain-hyperledger-write-and-run-chaincode.md)
+ [Amazon Managed Blockchain Security](managed-blockchain-security.md)
   + [Data Protection for Amazon Managed Blockchain](managed-blockchain-data-protection.md)
   + [Authentication and Access Control](managed-blockchain-auth-and-access-control.md)
   + [Identity and Access Management for Amazon Managed Blockchain](security-iam.md)
      + [How Amazon Managed Blockchain Works with IAM](security_iam_service-with-iam.md)
      + [Amazon Managed Blockchain Identity-Based Policy Examples](security_iam_id-based-policy-examples.md)
      + [Using Service-Linked Roles for Managed Blockchain](using-service-linked-roles.md)
      + [Troubleshooting Amazon Managed Blockchain Identity and Access](security_iam_troubleshoot.md)
   + [Configuring Security Groups](managed-blockchain-security-sgs.md)
+ [Monitoring Blockchain Activity Using CloudWatch Logs](monitoring-cloudwatch-logs.md)
+ [Document History for Amazon Managed Blockchain Management Guide](managed-blockchain-management-guide-doc-history.md)
+ [AWS Glossary](glossary.md)