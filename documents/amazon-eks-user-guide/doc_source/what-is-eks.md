# What is Amazon EKS?<a name="what-is-eks"></a>

Amazon EKS is a managed service that makes it easy for you to run Kubernetes on AWS without needing to install, operate, and maintain your own Kubernetes control plane or nodes\. Kubernetes is an open\-source system for automating the deployment, scaling, and management of containerized applications\. 

Amazon EKS runs Kubernetes control plane instances across multiple Availability Zones to ensure high availability\. Amazon EKS automatically detects and replaces unhealthy control plane instances, and it provides automated version upgrades and patching for them\.

Amazon EKS is integrated with many AWS services to provide scalability and security for your applications, including the following: 
+ Amazon ECR for container images
+ Elastic Load Balancing for load distribution
+ IAM for authentication
+ Amazon VPC for isolation

Amazon EKS runs up\-to\-date versions of the open\-source Kubernetes software, so you can use all of the existing plugins and tooling from the Kubernetes community\. Applications running on Amazon EKS are fully compatible with applications running on any standard Kubernetes environment, whether running in on\-premises data centers or public clouds\. This means that you can easily migrate any standard Kubernetes application to Amazon EKS without any code modification required\.

## Amazon EKS control plane architecture<a name="eks-architecture"></a>

Amazon EKS runs a single tenant Kubernetes control plane for each cluster, and control plane infrastructure is not shared across clusters or AWS accounts\.

This control plane consists of at least two API server nodes and three `etcd` nodes that run across three Availability Zones within a Region\. Amazon EKS automatically detects and replaces unhealthy control plane instances, restarting them across the Availability Zones within the Region as needed\. Amazon EKS leverages the architecture of AWS Regions in order to maintain high availability\. Because of this, Amazon EKS is able to offer an [SLA for API server endpoint availability](http://aws.amazon.com/eks/sla)\.

Amazon EKS uses Amazon VPC network policies to restrict traffic between control plane components to within a single cluster\. Control plane components for a cluster cannot view or receive communication from other clusters or other AWS accounts, except as authorized with Kubernetes RBAC policies\.

This secure and highly\-available configuration makes Amazon EKS reliable and recommended for production workloads\.

## How does Amazon EKS work?<a name="how-eks-works"></a>

![\[How Amazon EKS works\]](http://docs.aws.amazon.com/eks/latest/userguide/images/what-is-eks.png)

Getting started with Amazon EKS is easy:

1. Create an Amazon EKS cluster in the AWS Management Console or with the AWS CLI or one of the AWS SDKs\.

1. Launch managed or self\-managed nodes that register with the Amazon EKS cluster\. We provide you with an AWS CloudFormation template that automatically configures your nodes\. You can also deploy applications to AWS Fargate if you don't need to manage nodes\.

1. When your cluster is ready, you can configure your favorite Kubernetes tools \(such as  `kubectl`  \) to communicate with your cluster\.

1. Deploy and manage applications on your Amazon EKS cluster the same way that you would with any other Kubernetes environment\.

To create your first cluster and its associated resources, see [Getting started with Amazon EKS](getting-started.md)\.

## Pricing<a name="eks-pricing"></a>

An Amazon EKS cluster consists of a control plane and the Amazon EC2 or AWS Fargate compute that you run pods on\. For more information about pricing for the control plane, see [Amazon EKS pricing](http://aws.amazon.com/eks/pricing)\. Both Amazon EC2 and Fargate provide:
+ **On\-Demand Instances** ??? Pay for the instances that you use by the second, with no long\-term commitments or upfront payments\. For more information, see [Amazon EC2 On\-Demand Pricing](http://aws.amazon.com/ec2/pricing/on-demand/) and [AWS Fargate Pricing](http://aws.amazon.com/fargate/pricing/)\.
+ **Savings Plans** ??? You can reduce your costs by making a commitment to a consistent amount of usage, in USD per hour, for a term of 1 or 3 years\. For more information, see [Pricing with Savings Plans](http://aws.amazon.com/savingsplans/pricing/)\.