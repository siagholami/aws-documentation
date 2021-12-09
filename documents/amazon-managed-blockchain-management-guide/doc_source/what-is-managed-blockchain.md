# What Is Amazon Managed Blockchain?<a name="what-is-managed-blockchain"></a>

Amazon Managed Blockchain is a fully managed service for creating and managing blockchain networks using open source frameworks\. Currently, the Hyperledger Fabric open source framework is supported\. Blockchain allows you to build applications where multiple parties can securely and transparently run transactions and share data without the need for a trusted, central authority\.

You can use Managed Blockchain to create a scalable blockchain network quickly and efficiently using the AWS Management Console, the AWS CLI, or the Managed Blockchain SDK\. Managed Blockchain scales to meet the demands of thousands of applications running millions of transactions\. After the blockchain network is up and running, Managed Blockchain also simplifies network management tasks\. Managed Blockchain manages your certificates, lets you easily create proposals for a vote among network members, and tracks operational metrics such as compute, memory, and storage resources\.

This guide covers the fundamentals of creating and working with resources in a Managed Blockchain network\.

## How to Get Started with Managed Blockchain<a name="how-to-start"></a>

We recommend the following resources to get started developing blockchain applications using Managed Blockchain:
+ [Key Concepts: Managed Blockchain Networks, Members, and Peer Nodes](network-components.md)

  This overview helps you understand the fundamental building blocks of a Managed Blockchain network\. It also tells you how to identify and communicate with resources, regardless of the blockchain framework that you're using\.
+ [Get Started Creating a Hyperledger Fabric Blockchain Network Using Amazon Managed Blockchain](managed-blockchain-get-started-tutorial.md)

  This tutorial lets you try Managed Blockchain and get a Hyperledger Fabric blockchain application running in a short time\. You create your first network, set up a Hyperledger Fabric client, and use the open source Hyperledger Fabric peer CLI to query and update the ledger\. You then invite another member to the network\. The member can be from a different AWS account, or you can invite a new member in your own account to simulate a multi\-account network\. The new member then queries and updates the ledger\.
+ [Hyperledger Fabric Documentation \(v1\.2\)](https://hyperledger-fabric.readthedocs.io/en/release-1.2/)

  The open source documentation for Hyperledger Fabric is a starting point for key concepts and the architecture of the Hyperledger Fabric blockchain network that you build using Managed Blockchain\. As you develop your blockchain application, you can reference this document for key tasks and code samples\. Use the documentation version that corresponds to the version of Hyperledger Fabric that you use\.