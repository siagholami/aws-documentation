# View code review details<a name="view-code-review-details"></a>

You can view a summary of code review details or a code review details page in Amazon CodeGuru Reviewer\. This allows you to get information about a code review's status and generated recommendations\.

**Topics**
+ [Information in code review details](#information-in-code-review-details)
+ [View a summary of code review details](#view-details-summary)
+ [View the Code review details page](#view-details-page)
+ [View code review details by using the AWS CLI](#view-details-cli)

## Information in code review details<a name="information-in-code-review-details"></a>

You might want to use code review details to get more information about a code review, to provide feedback on recommendations in a code review, or to troubleshoot a **Failed** code review status\. 

There are three possible code review statuses: 
+ **Pending** – CodeGuru Reviewer has received the pull request notification or the repository analysis request and a code review is scheduled\. Make sure you maintain access permissions to your source branch while CodeGuru Reviewer processes the request\. If the code review is for a pull request, keep the pull request open\.
+ **Completed** – CodeGuru Reviewer successfully finished reviewing the source code\.
+ **Failed** – The code review has failed to finish reviewing the source code\. This could be because of a problem with source code access permissions or a transient exception that occurred:
  + If the problem is due to source code access permissions, the easiest way to fix it is to disassociate the repository and then associate the repository again\. If the error persists, contact AWS Support\.
  + If the problem is due to a transient exception, the code review request will be retried\.

   When you retry the operation, be sure to keep relevant pull requests open and the source branch available while CodeGuru Reviewer processes the request\. 

You can view code review details by choosing the name of the code review\. Or select a code review, and then choose **Action**, **View code review details**\. 

![\[Navigating to the Code review details window in the CodeGuru Reviewer console\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

## View a summary of code review details<a name="view-details-summary"></a>

If you select the code review and then choose **Action**, **View code review details**, the Code review details window opens, showing the name of the repository, the repository source provider, the status, and details about the status\.

![\[The Code review details window in the CodeGuru Reviewer console\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

## View the Code review details page<a name="view-details-page"></a>

If you choose the name of the code review from the **Code reviews** page, a detailed code review page opens\. 

This page contains a **Details** section, where you can view the status, details about the status, the Amazon Resource Name \(ARN\), number of recommendations, number of lines of code, and more\. 

Below that section is a **Recommendations** section that lists each recommendation with the file and line number it addresses\. This is also a place where you can provide feedback by choosing a thumbs\-up or thumbs\-down icon\.

![\[The Code review details page in the CodeGuru Reviewer console\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

## View code review details by using the AWS CLI<a name="view-details-cli"></a>

You can also use the AWS CLI or the AWS SDK to view the details of a code review\. 

If you have the code review ARN, you can call [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DescribeCodeReview.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DescribeCodeReview.html)\. Alternatively, you can call [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListCodeReviews.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListCodeReviews.html) and filter using `ProviderType` and `RepositoryName`\. 