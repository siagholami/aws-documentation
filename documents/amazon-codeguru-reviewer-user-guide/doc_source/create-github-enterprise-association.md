# Create a GitHub Enterprise Server repository association in Amazon CodeGuru Reviewer<a name="create-github-enterprise-association"></a>

 You can create a GitHub Enterprise Server repository association using the Amazon CodeGuru Reviewer console, the AWS CLI, or the CodeGuru Reviewer SDK\. Before you create a GitHub Enterprise Server repository association, you must have a GitHub Enterprise Server respository\. 

**Topics**
+ [GitHub Enterprise Server repository association prerequisites](#create-github-enterprise-association-requirements)
+ [Create a GitHub Enterprise Server repository association \(console\)](#create-github-enterprise-association-console)
+ [Create a GitHub Enterprise Server repository association \(AWS CLI\)](#create-github-enterprise-association-cli)
+ [Create a GitHub Enterprise Server repository association \(AWS SDKs\)](#create-github-enterprise-server-association-sdk)

## GitHub Enterprise Server repository association prerequisites<a name="create-github-enterprise-association-requirements"></a>

 To create a GitHub Enterprise Server repository association, you must have a GitHub Enterprise Server connection in AWS CodeStar connections\. The connection must be in the same AWS account and Region in which you want your code reviews\. For more information, see [Create a connection](https://docs.aws.amazon.com/dtconsole/latest/userguide/connections-create.html) and [Create a connection to GitHub Enterprise Server](https://docs.aws.amazon.com/dtconsole/latest/userguide/connections-create-gheserver.html) in the *Developer Tools User Guide*\. 

 Your GitHub Enterprise Server connection requires a *host*\. The host represents your GitHub Enterprise Server instance and is what your GitHub Enterprise Server connection connects to\. A host can be an on\-premises server or a Virtual Private Cloud \(VPC\)\. For more information, see [Amazon VPC configuration for your host](https://docs.aws.amazon.com/dtconsole/latest/userguide/connections-create-gheserver-console.html#connections-create-gheserver-prereq) and [Create a host](https://docs.aws.amazon.com/dtconsole/latest/userguide/connections-host-create.html) in the *AWS Developer Tools User Guide*\. 

## Create a GitHub Enterprise Server repository association \(console\)<a name="create-github-enterprise-association-console"></a>

**To create a GitHub Enterprise Server repository association**

1. Open the Amazon CodeGuru Reviewer console at [https://console\.aws\.amazon\.com/codeguru/reviewer/home](https://console.aws.amazon.com/codeguru/reviewer/home)\.

1. In the navigation pane, choose **Associated repositories**\. 

1. Choose **Associate repository**\. 

1. Choose **GitHub Enterprise Server**\. 

1. From **Connect to GitHub Enterprise Server \(with AWS CodeStar Connections\)**, choose the connection you want to use\. If you don't have a connection, choose **Create a GitHub Enterprise Server connection** to create one in the Developer Tools console\. For more information, see [Create a connection](https://docs.aws.amazon.com/dtconsole/latest/userguide/connections-create.html) in the *AWS Developer Tools User Guide*\. 

1. From **Repository location**, choose the GitHub Enterprise Server repository, then choose **Associate**\. On the **Associated repositories** page, the **Status** is **Associating**\. When the association is complete, the status changes to **Associated** and you can create a pull request or a repository analysis to get recommendations\. Refresh the page to check for the status change\. 

## Create a GitHub Enterprise Server repository association \(AWS CLI\)<a name="create-github-enterprise-association-cli"></a>

 For information about using the AWS CLI with CodeGuru Reviewer, see the [CodeGuru Reviewer section of the AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/codeguru-reviewer/index.html) 

**To create a GitHub Enterprise Server repository association**

1. Make sure that you have configured the AWS CLI with the AWS Region in which you want to create your code reviews\. To verify the Region, run the following command at the command line or terminal and review the information for the default name\. 

   ```
   aws configure
   ```

1. Run the associate\-repository command specifying the owner \(or user name\) of your GitHub Enterprise Server account, the name of your repository, and the Amazon Resource Name \(ARN\) of your connection\. 

   ```
   aws codeguru-reviewer associate-repository --repository GitHubEnterpriseServer="{Owner=github-enterprise-server-user-name, Name=repository-name, \
    ConnectionArn=arn:aws:codestar-connections:us-west-2:123456789012:connection/connection-uuid }"
   ```

1. If successful, this command outputs a [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html) object\. 

   ```
   {
       "RepositoryAssociation": {
           "ProviderType": "GitHubEnterpriseServer",
           "Name": "repository-name",
           "LastUpdatedTimeStamp": 1595966211.79,
           "AssociationId": "repository-association-uuid",
           "CreatedTimeStamp": 1595966211.79,
           "ConnectionArn": "arn:aws:codestar-connections:us-west-2:123456789012:connection/connection-uuid",
           "State": "Associating",
           "StateReason": "Pending Repository Association",
           "AssociationArn": "arn:aws:codeguru-reviewer:us-east-2:123456789012:association:repository-association-uuid",
           "Owner": "github-enterprise-server-user-name"
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
           "ProviderType": "GitHubEnterpriseServer",
           "Name": "repository-name",
           "LastUpdatedTimeStamp": 1595634764.029,
           "AssociationId": "repository-association-uuid",
           "CreatedTimeStamp": 1595634764.029,
           "ConnectionArn": "arn:aws:codestar-connections:us-west-2:123456789012:connection/connection_uuid"
           "State": "Associated",
           "StateReason": "Pull Request Notification configuration successful",
           "AssociationArn": "arn:aws:codeguru-reviewer:us-west-2:123456789012:association:repository-association-uuid",
           "Owner": "github-enterprise-server-user-name"
       }
   }
   ```

## Create a GitHub Enterprise Server repository association \(AWS SDKs\)<a name="create-github-enterprise-server-association-sdk"></a>

 To create an GitHub Enterprise Server repository association with the AWS SDKs, use the `AssociateRepository` API\. For more information, see [AssociateRepository](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_AssociateRepository.html) in the *Amazon CodeGuru Reviewer API Reference*\. 