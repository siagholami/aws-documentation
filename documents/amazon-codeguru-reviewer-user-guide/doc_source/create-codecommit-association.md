# Create an AWS CodeCommit repository association in Amazon CodeGuru Reviewer<a name="create-codecommit-association"></a>

 You can create an AWS CodeCommit repository association using the Amazon CodeGuru Reviewer console, the AWS CLI, or the CodeGuru Reviewer SDK\. Before you create a CodeCommit repository association, you must have a CodeCommit repository in the same AWS account and Region in which you want your CodeGuru Reviewer code reviews\. For more information, see [Create an AWS CodeCommit repository](https://docs.aws.amazon.com/codecommit/latest/userguide/how-to-create-repository.html) in the *AWS CodeCommit User Guide*\. 

**Topics**
+ [Create a CodeCommit repository association \(console\)](#create-codecommit-association-console)
+ [Create a CodeCommit repository association \(AWS CLI\)](#create-codecommit-association-cli)
+ [Create a CodeCommit repository association \(AWS SDKs\)](#create-codecommit-association-sdk)

## Create a CodeCommit repository association \(console\)<a name="create-codecommit-association-console"></a>

**To create a CodeCommit repository association**

1. Open the Amazon CodeGuru Reviewer console at [https://console\.aws\.amazon\.com/codeguru/reviewer/home](https://console.aws.amazon.com/codeguru/reviewer/home)\.

1. In the navigation pane, choose **Associated repositories**\. 

1. Choose **Associate repository**\. 

1. Choose **AWS CodeCommit**\. 

1. From **Repository location**, choose your CodeCommit repository, then choose **Associate**\. On the **Associated repositories** page, the **Status** is **Associating**\. When the association is complete, the status changes to **Associated** and you can create a pull request or a repository analysis to get recommendations\. Refresh the page to check for the status change\. 

## Create a CodeCommit repository association \(AWS CLI\)<a name="create-codecommit-association-cli"></a>

 For information about using the AWS CLI with CodeGuru Reviewer, see the [CodeGuru Reviewer section of the AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/codeguru-reviewer/index.html)\. 

**To create a CodeCommit repository association**

1. Make sure that you have configured the AWS CLI with the AWS Region in which want to create your code reviews and in which your CodeCommit repository exists\. To verify the Region, run the following command at the command line or terminal and review the information for the default name\. 

   ```
   aws configure
   ```

   The default region name must match the AWS Region for the repository in CodeCommit\. 

1. Run the associate\-repository command specifying the name of the CodeCommit repository you want to associate\. 

   ```
   aws codeguru-reviewer associate-repository --repository CodeCommit={Name=my-codecommit-repo}
   ```

1. If successful, this command outputs a [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_RepositoryAssociation.html) object\. 

   ```
   {
       "RepositoryAssociation": {
           "AssociationId": "repository-association-uuid",
           "Name": "my-codecommit-repo",
           "LastUpdatedTimeStamp": 1595634764.029,
           "ProviderType": "CodeCommit",
           "CreatedTimeStamp": 1595634764.029,
           "Owner": "123456789012",
           "State": "Associating",
           "StateReason": "Pending Repository Association",
           "AssociationArn": "arn:aws:codeguru-reviewer:us-west-2:123456789012:association:repository-association-uuid",
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
           "AssociationId": "repository-association-uuid",
           "Name": "my-codecommit-repo",
           "LastUpdatedTimeStamp": 1595634764.029,
           "ProviderType": "CodeCommit",
           "CreatedTimeStamp": 1595634764.029,
           "Owner": "123456789012",
           "State": "Associated",
           "StateReason": ""Pull Request Notification configuration successful",
           "AssociationArn": "arn:aws:codeguru-reviewer:us-west-2:123456789012:association:repository-association-uuid"
       }
   }
   ```

## Create a CodeCommit repository association \(AWS SDKs\)<a name="create-codecommit-association-sdk"></a>

 To create a CodeCommit repository association with the AWS SDKs, use the `AssociateRepository` API\. For more information, see [AssociateRepository](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_AssociateRepository.html) in the *Amazon CodeGuru Reviewer API Reference*\. 