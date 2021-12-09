# Step 3: Get recommendations<a name="get-results"></a>

Amazon CodeGuru Reviewer uses code reviews to provide [different kinds of recommendations](recommendations.md) to help improve your code\. These recommendations are focused on best practices and resolving potential defects in code that are difficult for developers to find\. After a code review is successfully completed on a repository analysis or pull request, you can view recommendations\. You can then choose whether to incorporate the recommendations, and you can provide feedback about whether the recommendations were helpful\.

**Note**  
We recommend that you use both CodeGuru Reviewer and traditional peer review processes during the code review stage\. Using a combination of code review processes helps to identify more issues before they reach production\.

The recommendations show up when a code review is completed\. You can view the status of a code review on the **Code reviews** page on the CodeGuru Reviewer console\. 
+ **Pending**: While a code review status is **Pending**, it is important to maintain source provider access permissions and keep the pull request open\. Keep the relevant branch accessible\.
+ **Completed**: The code review status usually shows as **Completed** after about 15 minutes when you refresh the page\.
+ **Failed**: If a code review status is **Failed**, you can view more details on the **Code reviews** page\. Choose the code review that failed, choose **Action**, and then choose **View code review details**\.

For more information, see [View code review details](view-code-review-details.md)\.

**Topics**
+ [About repository analysis and pull request scans](#repository-analysis-vs-pull-request)
+ [Get recommendations using repository analysis](#get-repository-scan)
+ [Get recommendations using pull requests](#get-pull-request-scan)

## About repository analysis and pull request scans<a name="repository-analysis-vs-pull-request"></a>

You can get recommendations in code reviews by using a repository analysis or a pull request\. After you associate a repository, you can choose when to have an entire branch get a code review, and every pull request in that repository receives a code review\.


| Type of code review | Is the review automatic after I associate the repository? | Where can I see recommendations? | What code is reviewed? | 
| --- | --- | --- | --- | 
|  Repository analysis  |  No\. You must request a repository analysis in the CodeGuru Reviewer console or by using the AWS CLI or AWS SDK\.  |  In the CodeGuru Reviewer console, or by using the AWS CLI or AWS SDK\.   |  All the code in the branch is reviewed\.  | 
|  Pull request  |  Yes\. After associating the repository, every time you do a pull request there is a code review\.  |  In the CodeGuru Reviewer console, in the AWS CLI or AWS SDK, or in pull request comments in the repository source provider\.  |  The code that is changed in the pull request is reviewed\.  | 

## Get recommendations using repository analysis<a name="get-repository-scan"></a>

To get recommendations on all the code in a branch, associate the repository with CodeGuru Reviewer and do the following:

1. Navigate to the **Code reviews** page in the console\.

1. On the **Repository analysis** tab, choose **Create repository analysis**\.

   A window opens for you to specify the location of the source code you wish to scan\.

1. On the **Create repository analysis** page, choose the associated repository from the list, then choose the branch you want reviewed\.

1. \(Optional\) If you want to, you can provide a name for your code review\. If you don't, CodeGuru Reviewer provides a name for you\.

1. When you have specified the branch you want reviewed, choose **Create repository analysis**\.

To view the recommendations, navigate to the **Code reviews** page in the console and choose the name of the code review to view the detailed code review page\. If you do not see the code review right away, try refreshing the page\. For more information, see [View code review details](view-code-review-details.md)\.

## Get recommendations using pull requests<a name="get-pull-request-scan"></a>

To get recommendations from CodeGuru Reviewer after you associate a repository, use the repository source provider to make a pull request\. CodeGuru Reviewer then provides recommendations as pull request comments in the source provider to improve your code\. 

To view the recommendations in the CodeGuru Reviewer console, navigate to the **Code reviews** page in the console and choose the name of the code review to view the detailed code review page\.