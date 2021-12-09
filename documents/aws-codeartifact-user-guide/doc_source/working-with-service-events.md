# Working with CodeArtifact events<a name="working-with-service-events"></a>

 CodeArtifact is integrated with Amazon EventBridge, a service that automates and responds to events, including changes in an CodeArtifact repository\. You can create rules for events and configure what happens when an event matches a rule\. EventBridge was formerly called CloudWatch Events\.

The following actions can be triggered by an event: 
+  Invoking an AWS Lambda function\. 
+  Activating an AWS Step Functions state machine\. 
+  Notifying an Amazon SNS topic or an Amazon SQS queue\. 
+  Starting a pipeline in AWS CodePipeline\. 

 CodeArtifact creates an event when a package version is created, modified, or deleted\. The following are examples of CodeArtifact events: 
+  Publishing a new package version \(for example, by running `npm publish`\)\. 
+  Adding a new asset to an existing package version \(for example, by pushing a new JAR file to an existing Maven package\)\. 
+  Copying a package version from one repository to another using `copy-package-versions`\. For more information, see [Copy packages between repositories](copy-package.md)\. 
+  Deleting a package version using `delete-package-version`\. For more information, see [Delete a package version](delete-package.md)\. 
+  Retaining a package version in a downstream repository when it has been fetched from an upstream repository\. For more information, see [Working with upstream repositories in CodeArtifact](repos-upstream.md)\. 
+  Ingesting a package version from an external repository into an CodeArtifact repository\. For more information, see [Add an external connection](external-connection.md)\. 

Events are delivered to both the account that owns the domain and the account that administers the repository\. For example, suppose that account `111111111111` owns the domain `mydomain`\. Account `222222222222` creates a repository in `mydomain` called `repo2`\. When a new package version is published to `repo2`, both accounts receive the EventBridge events\. The domain\-owning account \(`111111111111`\) receives events for all repositories in the domain\. If a single account owns both the domain and the repository within it, only a single event is delivered\.

The following topics describe the CodeArtifact event format\. They show you how to configure CodeArtifact events, and how to use events with other AWS services\. For more information, see [Getting Started with Amazon EventBridge](https://docs.aws.amazon.com/eventbridge/latest/userguide/eventbridge-getting-set-up.html) in the *Amazon EventBridge User Guide*\.

**Topics**
+ [CodeArtifact event format and example](service-event-format-example.md)
+ [Use an event to start a CodePipeline execution](configure-service-events-codepipeline.md)
+ [Use an event to run a Lambda function](configure-service-events-lambda-function.md)