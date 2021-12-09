# Using the Amazon Detective Python scripts<a name="detective-github-scripts"></a>

Amazon Detective provides a set of open\-source Python scripts in the GitHub repository [amazon\-detective\-multiaccount\-scripts](https://github.com/aws-samples/amazon-detective-multiaccount-scripts)\. The scripts require Python 3\.

You can use these to perform the following tasks:
+ Enable Detective for a master account across Regions\.
+ Add member accounts to a master account's behavior graphs across Regions\.
+ Remove member accounts from a master account's behavior graphs across Regions\.
+ Disable Detective for a master account across Regions\. When a master account disables Detective, the master account's behavior graph in each Region is disabled\.

## Overview of the `enableDetective.py` script<a name="enabledetective-script-overview"></a>

The `enableDetective.py` script does the following:

1. Enables Detective in for a master account in each specified Region, if the master account does not already have Detective enabled in that Region\.

1. Sends invitations from the master account to the specified member accounts for each behavior graph\.

   The invitation email messages use the default message content and cannot be customized\.

1. Automatically accepts the invitations for the member accounts\.

   Because the script automatically accepts the invitations, member accounts can ignore these messages\.

   We recommend reaching out directly to the member accounts to notify them that the invitations are accepted automatically\.

## Overview of the `disableDetective.py` script<a name="disabledetective-script-overview"></a>

The `disableDetective.py` script deletes the specified member accounts from the master account's behavior graphs across the specified Regions\.

It also provides an option to disable Detective for the master account across the specified Regions\.

## Required permissions for the scripts<a name="github-scripts-permissions"></a>

The scripts require a preexisting AWS role in the master account and in all of the member accounts that you add or remove\.

The role name must be the same in all of the accounts\.

The role trust relationship must allow your instance or local credentials to assume the role\.

The `AmazonDetectiveFullAccess` managed policy shown below contains the permissions that are required for the script to succeed\.

**Role policy**

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": [
                "detective:CreateMembers",
                "detective:DeleteMembers",
                "detective:AcceptInvitation",
                "guardduty:ArchiveFindings",
                "guardduty:ListDetectors"
            ],
            "Resource": "*"
        }
    ]
}
```

**Role trust relationship**

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "AWS": "arn:aws:iam::<ACCOUNTID>:user/<USERNAME>"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
```

If you do not have a common role that includes at least the above permissions, you must create a role with at least those permissions in each member account and in the master account\.

When you create the role, make sure that you do the following:
+ Use the same role name in every account\.
+ Select the `AmazonDetectiveFullAccess` managed policy\.

To automate this process, you can use the `EnableDetective.yaml` AWS CloudFormation template\. Because the template creates only global resources, it can be run in any Region\.

## Setting up the execution environment for the Python scripts<a name="github-script-setup"></a>

You can run the scripts from either an EC2 instance or from a local machine\.

### Launching and configuring an EC2 instance<a name="github-setup-ec2-instance"></a>

One option for running the scripts is to run them from an EC2 instance\.

**To launch and configure an EC2 instance**

1. Launch an EC2 instance in your master account\. For details on how to launch an EC2 instance, see [Getting Started with Amazon EC2 Linux Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html) in the *Amazon EC2 User Guide for Linux Instances*\.

1. Attach to the instance an IAM role that has permissions to allow the instance to call `AssumeRole` within the master account\.

   If you used the `EnableDetective.yaml` AWS CloudFormation template, then an instance role with a profile named `EnableDetective` was created\.

   Otherwise, for information on creating an instance role, see the blog post [Easily Replace or Attach an IAM Role to an Existing EC2 Instance by Using the EC2 Console](http://aws.amazon.com/blogs/security/easily-replace-or-attach-an-iam-role-to-an-existing-ec2-instance-by-using-the-ec2-console/)\.

1. Install the required software:
   + **APT:** `sudo apt-get -y install python3-pip python3 git`
   + **RPM:** `sudo yum -y install python3-pip python3 git`
   + **Boto \(minimum version 1\.15\):** `sudo pip install boto3`

1. Clone the repository to the EC2 instance\.

   ```
   git clone https://github.com/aws-samples/amazon-detective-multiaccount-scripts.git
   ```

### Configuring a local machine to run the scripts<a name="github-setup-local-machine"></a>

You can also run the scripts from your local machine\.

**To configure a local machine to run the scripts**

1. Make sure that you have set up on your local machine credentials for your master account that have permission to call `AssumeRole`\.

1. Install the required software:
   + Python 3
   + Boto \(minimum version 1\.15\)
   + GitHub scripts    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/detective/latest/adminguide/detective-github-scripts.html)

## Creating a `.csv` list of member accounts to add or remove<a name="github-scripts-csv-file"></a>

To identify the member accounts to add to or remove from the behavior graphs, you provide a `.csv` file that contains the list of accounts\.

List each account on a separate line\. Each member account entry contains the AWS account ID and the account's root user email address\.

See the following example:

```
111122223333,srodriguez@example.com
444455556666,rroe@example.com
```

## Running `enableDetective.py`<a name="github-scripts-execute-enabledetective"></a>

You can run the `enableDetective.py` script from an EC2 instance or your local machine\.

**To run `enableDetective.py`**

1. Copy the `.csv` file to the `amazon-detective-multiaccount-scripts` directory on your EC2 instance or local machine\.

1. Change to the `amazon-detective-multiaccount-scripts` directory\.

1. Run the `enableDetective.py` script\.

   ```
   enableDetective.py --master_account masterAccountID --assume_role roleName inputFileName --enabled_regions regionList
   ```

When you run the script, replace the following values:

`masterAccountID`  
The AWS account ID for the master account\.

`roleName`  
The name of the AWS role to assume in the master account and each member account\.

`inputFileName`  
The name of the `.csv` file containing the list of member accounts to add to the master account's behavior graphs\.

`regionList`  
\(Optional\) A comma\-separated list of Regions in which to add the member accounts to the master account's behavior graph\. For example:  

```
--enabled_regions us-east-1,us-east-2,us-west-2
```
The master account might not already have Detective enabled in a Region\. In that case, the script enables Detective and creates a new behavior graph for the master account\.  
If you do not provide a list of Regions, then the script acts across all Regions that Detective supports\.

## Running `disableDetective.py`<a name="github-scripts-execute-disabledetective"></a>

You can run the `disableDetective.py` script from an EC2 instance or your local machine\.

**To run `disableDetective.py`**

1. Copy the `.csv` file to the `amazon-detective-multiaccount-scripts` directory\.

1. To use the `.csv` file to delete the listed member accounts from the master account's behavior graphs across a specified list of Regions, run the `disableDetective.py` script as follows:

   ```
   disabledetective.py --master_account masterAccountID --assume_role roleName inputFileName --disabled_regions regionList
   ```

1. To disable Detective for the master account across all Regions, run the `disableDetective.py` script with the `--delete-master` flag\.

   ```
   disabledetective.py --master_account masterAccountID --assume_role roleName inputFileName --disabled_regions regionList --delete_master
   ```

When you run the script, replace the following values:

`masterAccountID`  
The AWS account ID for the master account\.

`roleName`  
The name of the AWS role to assume in the master account and each member account\.

`inputFileName`  
The name of the `.csv` file containing the list of member accounts to remove from the master account's behavior graphs\.  
You must provide a `.csv` file even if you are disabling Detective\.

`regionList`  
\(Optional\) A comma\-separated list of Regions in which to do one of the following:  
+ Remove the member accounts from the master account's behavior graphs\.
+ If the `--delete-master` flag is included, disable Detective\.
For example:  

```
--disabled_regions us-east-1,us-east-2,us-west-2
```
If you do not provide a list of Regions, then the script acts across all Regions that Detective supports\.