# What is Amazon CodeGuru Reviewer?<a name="welcome"></a>

Amazon CodeGuru Reviewer is a service that uses program analysis and machine learning to detect potential defects that are difficult for developers to find and offers suggestions for improving your Java code\. This service has been released for general availability in several [regions](https://docs.aws.amazon.com/general/latest/gr/codeguru-reviewer.html)\.

By proactively detecting code defects, CodeGuru Reviewer can provide guidelines for addressing them and implementing best practices to improve the overall quality and maintainability of your code base during the code review stage\. For more information, see [How CodeGuru Reviewer works](how-codeguru-reviewer-works.md)\.

## What kind of recommendations does CodeGuru Reviewer provide?<a name="welcome-recommendations"></a>

CodeGuru Reviewer doesn't flag syntactical mistakes, as these are relatively easy to find\. Instead, CodeGuru Reviewer will identify more complex problems and suggest improvements related to the following: 
+ AWS best practices
+ Concurrency
+ Resource leak prevention
+ Sensitive information leak prevention
+ Common coding best practices
+ Refactoring
+ Input validation

For more information, see [Recommendations in Amazon CodeGuru Reviewer](recommendations.md)\.

## What languages and repositories can I use with CodeGuru Reviewer?<a name="welcome-repositories"></a>

CodeGuru Reviewer is designed to work with Java code repositories in the following source providers:
+ [AWS CodeCommit](https://docs.aws.amazon.com/codecommit/latest/userguide/welcome.html)
+ Bitbucket
+ GitHub
+ GitHub Enterprise Cloud
+ GitHub Enterprise Server

 If you use any of these source providers, you can integrate with CodeGuru Reviewer with just a few steps\. After you associate a repository with CodeGuru Reviewer, you can [interact with recommendations in the CodeGuru Reviewer console](https://docs.aws.amazon.com/codeguru/latest/reviewer-ug/give-feedback-from-code-review-details.html)\. For pull request code reviews, you can also [see recommendations directly from inside pull requests](https://docs.aws.amazon.com/codeguru/latest/reviewer-ug/provide-feedback.html#provide-feedback-in-pull-requests) in your repository context\.

## <a name="welcome-next-steps"></a>