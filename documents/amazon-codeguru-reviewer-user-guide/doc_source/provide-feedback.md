# Step 4: Provide feedback<a name="provide-feedback"></a>

CodeGuru Reviewer is based on program analysis and machine learning models, so it's constantly improving\. To assist in the machine learning process and enhance the experience with CodeGuru Reviewer, you can provide feedback on the recommendations in the **Code reviews** page on the CodeGuru Reviewer console\. You can also provide feedback directly in the pull requests to indicate whether they were helpful to you\. 

Your feedback and comments are shared with CodeGuru Reviewer\. This can help CodeGuru Reviewer to improve its models and become more helpful to you and others in the future\.

**Note**  
The source code reviewed by CodeGuru Reviewer is not stored\. For more information, see [Captured data in CodeGuru Reviewer](data-protection.md#data-captured)\.

**Topics**
+ [Provide feedback using the CodeGuru Reviewer console](#provide-feedback-in-console)
+ [Provide feedback using pull request comments](#provide-feedback-in-pull-requests)
+ [Provide feedback using the CLI](#provide-feedback-cli)

## Provide feedback using the CodeGuru Reviewer console<a name="provide-feedback-in-console"></a>

You can provide feedback for recommendations on pull request or repository analysis code reviews [using the **Code reviews** page](https://docs.aws.amazon.com/codeguru/latest/reviewer-ug/give-feedback-from-code-review-details.html) of the CodeGuru Reviewer console\. Choose the name of a code review to view details and recommendations from that code review\. Then choose the thumbs\-up or thumbs\-down icon under each recommendation to indicate whether the recommendation was helpful\.

## Provide feedback using pull request comments<a name="provide-feedback-in-pull-requests"></a>

You can also provide feedback for pull request scans by replying to comments in pull requests, without leaving your repository context\. In AWS CodeCommit you can view the recommendations on the **Activity** or **Changes** tab\. A thumbs\-up or thumbs\-down icon is provided next to comments made by CodeGuru Reviewer\. Choose a thumbs\-up icon if the recommendation was helpful and a thumbs\-down icon if it wasn't\. In other repository source providers, you can reply to a comment made by CodeGuru Reviewer, and include either a thumbs\-up or thumbs\-down emoji in your comment to indicate whether it was helpful or not\.

![\[Give Feedback in CodeCommit\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/images/guru-feedback-codecommit.png)

## Provide feedback using the CLI<a name="provide-feedback-cli"></a>

You can also use the AWS CLI or the AWS SDK to provide feedback on recommendations\. If you have the code review ARN, you can call [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListRecommendations.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListRecommendations.html)\. This returns the list of all recommendations for a completed code review\. You can then use [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_PutRecommendationFeedback.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_PutRecommendationFeedback.html) to store reactions and send feedback as UTF\-8 text code for emojis\. 

To view the feedback that you have submitted, call [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DescribeRecommendationFeedback.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DescribeRecommendationFeedback.html) using the `RecommendationId`\. To view feedback from all users, call [https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListRecommendationFeedback.html](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListRecommendationFeedback.html) by using a filter on `RecommendationIds` and `UserIds`\. For more information, see the [Amazon CodeGuru Reviewer API Reference](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/Welcome.html)\.