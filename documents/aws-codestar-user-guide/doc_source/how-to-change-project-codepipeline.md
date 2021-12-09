# Add a Stage to AWS CodePipeline<a name="how-to-change-project-codepipeline"></a>

You can add a new stage to a pipeline that AWS CodeStar creates in a project\. For more information, see [Edit a Pipeline in AWS CodePipeline](https://docs.aws.amazon.com/codepipeline/latest/userguide/pipelines-edit.html) in the *AWS CodePipeline User Guide*\.

**Note**  
If the new stage depends on any AWS resources that AWS CodeStar did not create, the pipeline might break\. This is because the IAM role that AWS CodeStar created for AWS CodePipeline might not have access to those resources by default\.   
To attempt to give AWS CodePipeline access to AWS resources that AWS CodeStar did not create, you might want to change the IAM role that AWS CodeStar created\. This is not supported because AWS CodeStar might remove your IAM role changes when it performs regular update checks on the project\.