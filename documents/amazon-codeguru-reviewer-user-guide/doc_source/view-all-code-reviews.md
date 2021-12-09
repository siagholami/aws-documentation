# View all code reviews<a name="view-all-code-reviews"></a>

You can view all code reviews from the past 90 days and their statuses on the **Code reviews** page in the CodeGuru console\. There is a **Pull request** tab to view code reviews done on pull requests and a **Repository analysis** tab to view code reviews requested for repository analyses\.

## Code reviews page<a name="about-viewing-code-reviews"></a>

To view this page, in the navigation pane, choose **Reviewer**, **Code reviews**\.

![\[The Code review page in the CodeGuru Reviewer console\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

**Note**  
After 90 days have passed since a code review was done, you can't view that code review in the Amazon CodeGuru Reviewer console\. But you might be able to view the recommendations from pull request code reviews in the repository source provider\.

To view code reviews with the AWS CLI or the AWS SDK, call `ListCodeReviews`\. You can filter using `ProviderType`, `RepositoryName`, or `State`\. For more information, see the [Amazon CodeGuru Reviewer API Reference](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/Welcome.html)\.

## Navigate to repositories and pull requests<a name="go-to-repository-and-request"></a>

From the **Code reviews** page, you can choose the repository name to navigate to the repository with the source code for the code review\. On pull request code reviews, you can also choose the pull request ID to navigate directly to the pull request that initiated the code review\.