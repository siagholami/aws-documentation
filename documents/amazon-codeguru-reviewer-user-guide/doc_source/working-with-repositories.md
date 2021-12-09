# Working with repository associations in Amazon CodeGuru Reviewer<a name="working-with-repositories"></a>

Amazon CodeGuru Reviewer requires a repository that contains the source code you want it to review\. To add a repository with your source code to CodeGuru Reviewer, you create a *repository association*\. When you associate a repository, you enable CodeGuru Reviewer to read the code in its pull requests at the time of the request\. You also enable CodeGuru Reviewer to listen to pull request notifications so that a code review is created for every pull request\. A pull request triggers a code review\. Following the code review, CodeGuru Reviewer provides any recommendations it found to help you improve the code\. You can create one association for a repository\. 

 Immediately after you create the repository association, its status is **Associating**\. A repository association with this status is doing the following\. 
+ Setting up pull request notifications\. This is required for pull requests to trigger a CodeGuru Reviewer review\. For GitHub, GitHub Enterprise Server, and Bitbucket repositories, the notifications are webhooks created in your repository to trigger CodeGuru Reviewer reviews\. If you delete these webhooks, reviews of code in your repository cannot be triggered\. 
+ Setting up source code access\. This is required for CodeGuru Reviewer to securely clone the code in your repository\. 

When the pull request notifications and source code access are complete, the status changes to **Associated**\. After its status changes to **Associated**, the association is complete and you can create a pull request or a repository analysis to get recommendations\. 

 CodeGuru Reviewer supports associations with the following repositories: 
+  AWS CodeCommit 
+  Bitbucket 
+  GitHub 
+  GitHub Enterprise Server 

**Note**  
 The source code reviewed by CodeGuru Reviewer is not stored\. For more information, see [Captured data in CodeGuru Reviewer](data-protection.md#data-captured)\. 

**Topics**
+ [Create an AWS CodeCommit repository association in Amazon CodeGuru Reviewer](create-codecommit-association.md)
+ [Create a Bitbucket repository association in Amazon CodeGuru Reviewer](create-bitbucket-association.md)
+ [Create a GitHub repository association in Amazon CodeGuru Reviewer](create-github-association.md)
+ [Create a GitHub Enterprise Server repository association in Amazon CodeGuru Reviewer](create-github-enterprise-association.md)