# Create a Bitbucket repository association in Amazon CodeGuru Reviewer<a name="create-bitbucket-association"></a>

You can create an Bitbucket repository association using the Amazon CodeGuru Reviewer console, the AWS CLI, or the CodeGuru Reviewer SDK\. Before you create a Bitbucket repository association, you must have a Bitbucket repository and you must create a connection to it using the Developer Tools console\. For more information, see [Create a connection](https://docs.aws.amazon.com/dtconsole/latest/userguide/connections-create.html) in the *Developer Tools User Guide*\. For information about creating a Bitbucket repository, see [Create a Git repository](https://support.atlassian.com/bitbucket-cloud/docs/create-a-git-repository/) on the Bitbucket website\. 

**Topics**
+ [Create a Bitbucket repository association \(console\)](#create-bitbucket-association-console)
+ [Create a Bitbucket repository association \(AWS CLI\)](#create-bitbucket-association-cli)
+ [Create a Bitbucket repository association \(AWS SDKs\)](#create-bitbucket-association-sdk)

## Create a Bitbucket repository association \(console\)<a name="create-bitbucket-association-console"></a>

**To create a Bitbucket repository association**

1. Open the Amazon CodeGuru Reviewer console at [https://console\.aws\.amazon\.com/codeguru/reviewer/home](https://console.aws.amazon.com/codeguru/reviewer/home)\.

1. In the navigation pane, choose **Associated repositories**\. 

1. Choose **Associate repository**\. 

1. Choose **Bitbucket**\. 

1. From **Connect to Bitbucket \(with AWS CodeStar Connections\)**, choose the connection you want to use\. If you don't have a connection, choose **Create a Bitbucket connection** to create one in the Developer Tools console\. For more information, see [Create a connection](https://docs.aws.amazon.com/dtconsole/latest/userguide/connections-create.html) in the *Developer Tools User Guide*\. 

1. From **Repository location**, choose the name of your Bitbucket repository that contains the source code you want CodeGuru Reviewer to review\. 

1. From **Repository location**, choose your Bitbucket repository, then choose **Associate**\. On the **Associated repositories** page, the **Status** is **Associating**\. When the association is complete, the status changes to **Associated** and you can create a pull request or a repository analysis to get recommendations\. Refresh the page to check for the status change\. 

## Create a Bitbucket repository association \(AWS CLI\)<a name="create-bitbucket-association-cli"></a>

 For information about using the AWS CLI with CodeGuru Reviewer, see the [CodeGuru Reviewer section of the AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/codeguru-reviewer/index.html) 

**To create a Bitbucket repository association**

1. Make sure that you have configured the AWS CLI with the AWS Region in which you want to create your code reviews\. To verify the Region, run the following command at the command line or terminal and review the information for the default name\. 

   ```
   aws configure
   ```

    The default Region name must match the AWS Region for the repository in CodeCommit\. 

1. Run the associate\-repository command specifying the owner \(or user name\) of your Bitbucket account, the name of your repository, and the Amazon Resource Name \(ARN\) of your connection\. 

   ```
   aws codeguru-reviewer associate-repository --repository Bitbucket="{Owner=bitbucket-user-name, Name=repository-name, \
    ConnectionArn=arn:aws:codestar-connections:us-west-2:123456789012:connection/repository-uuid }"
   ```

1. If successful, this command outputs a [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html) object\. 

   ```
   {
       "RepositoryAssociation": {
           "ProviderType": "Bitbucket",
           "Name": "repository-name",
           "LastUpdatedTimeStamp": 1595886585.96,
           "AssociationId": "repository_association_uuid",
           "CreatedTimeStamp": 1595886585.96,
           "ConnectionArn": "arn:aws:codestar-connections:us-west-2:544120495673:connection/connection_uuid",
           "State": "Associating",
           "StateReason": "Pending Repository Association",
           "AssociationArn": "arn:aws:codeguru-reviewer:us-west-2:123456789012:association:repository-association-uuid",
           "Owner": "bitbucket-user-name"
       }
   }
   ```

1. When the associate\-repository command succeeds, the status in the returned output is **Associating**\. When the association is complete, the status changes to **Associated** and you can create a pull request or a repository analysis to get recommendations\. You can check your repository association's status using the `describe-repository` command with its Amazon Resource Name \(ARN\)\. 

   ```
   aws codeguru-reviewer describe-repository-association --association-arn arn:aws:codeguru-reviewer:us-west-2:123456789012:association:repository-association-uuid
   ```

1.  If successful, this command outputs a [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html) object which shows its status\. 

   ```
   {
       "RepositoryAssociation": {
           "ProviderType": "Bitbucket",
           "Name": "repository-name",
           "LastUpdatedTimeStamp": 1595886585.96,
           "AssociationId": "repository_association_uuid",
           "CreatedTimeStamp": 1595886585.96,
           "ConnectionArn": "arn:aws:codestar-connections:us-west-2:544120495673:connection/connection_uuid",
           "State": "Associated",
           "StateReason": ""Pull Request Notification configuration successful",
           "AssociationArn": "arn:aws:codeguru-reviewer:us-west-2:123456789012:association:repository-association-uuid",
           "Owner": "bitbucket-user-name"
       }
   }
   ```

## Create a Bitbucket repository association \(AWS SDKs\)<a name="create-bitbucket-association-sdk"></a>

 To create a Bitbucket repository association with the AWS SDKs, use the `AssociateRepository` API\. For more information, see [AssociateRepository](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_AssociateRepository.html) in the *Amazon CodeGuru Reviewer API Reference*\. 