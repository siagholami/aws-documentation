# Create a GitHub repository association in Amazon CodeGuru Reviewer<a name="create-github-association"></a>

 You can create a GitHub repository association using the Amazon CodeGuru Reviewer console\. You cannot create a GitHub repository using the AWS CLI or the CodeGuru Reviewer SDK\. Before you create a GitHub repository association, you must have a GitHub repository\. 

**To create a GitHub repository association**

1. Open the Amazon CodeGuru Reviewer console at [https://console\.aws\.amazon\.com/codeguru/reviewer/home](https://console.aws.amazon.com/codeguru/reviewer/home)\.

1.  In the navigation pane, choose **Associated repositories**\. 

1.  Choose **Associate repository**\. 

1.  Choose **GitHub**\. 

1.  If you are not connected to GitHub, choose **Connect to GitHub** and follow the prompts to connect\. 

1.  From **Repository location**, choose your repository, then choose **Associate**\. On the **Associated repositories** page, the **Status** is **Associating**\. When the association is complete, the status changes to **Associated** and you can create a pull request or a repository analysis to get recommendations\. Refresh the page to check for the status change\. 