# Add an IAM Role to a Project<a name="add-iam-role"></a>

As of December 6, 2018 PDT you can define your own roles and polices in the application stack \(template\.yml\)\. To mitigate risks of privilege escalation and destructive actions, you are required to set the project\-specific permissions boundary for every IAM entity you create\. If you have a Lambda project with multiple functions, it is a best practice to create an IAM role for each function\.

**To add an IAM role to your project**

1. Edit the `template.yml` file for your project\.

1. In the `Resources:` section, add your IAM resource, using the format in the following example:

   ```
     SampleRole:
     Description: Sample Lambda role
     Type: AWS::IAM::Role
     Properties:
       AssumeRolePolicyDocument:
         Statement:
         - Effect: Allow
           Principal:
             Service: [lambda.amazonaws.com]
           Action: sts:AssumeRole
       ManagedPolicyArns:
         -  arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole
       PermissionsBoundary: !Sub 'arn:${AWS::Partition}:iam::${AWS::AccountId}:policy/CodeStar_${ProjectId}_PermissionsBoundary'
   ```

1. Release your changes through the pipeline and verify success\.