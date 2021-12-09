# Preparing to Use a Recommender Model with Amazon Pinpoint<a name="ml-models-rm-prerequisites"></a>

To work with Amazon Pinpoint, a recommender model has to be deployed as an Amazon Personalize campaign\. In addition, certain AWS Identity and Access Management \(IAM\) roles and policies need to be in place\. If you want to enhance recommendations that Amazon Pinpoint receives from the model, an AWS Lambda function also needs to be in place to process the recommendations\.

Before you set up a recommender model in Amazon Pinpoint, work with your data science and development teams to design and create these resources\. Also, work with those teams to ensure that the model meets certain technical requirements to work with Amazon Pinpoint\. After you create these resources, work with your administrator to ensure that you and Amazon Pinpoint can access them\. As you take these steps, gather the information that you'll need to set up the model in Amazon Pinpoint\. 

**Topics**
+ [Amazon Personalize Campaigns](#ml-models-rm-prerequisites-personalize)
+ [AWS Identity and Access Management Roles and Policies](#ml-models-rm-prerequisites-iam)
+ [AWS Lambda Functions](#ml-models-rm-prerequisites-lambda)

## Amazon Personalize Campaigns<a name="ml-models-rm-prerequisites-personalize"></a>

Amazon Personalize is an AWS service that's designed to help you create machine learning models that provide real\-time, personalized recommendations for customers who use your applications\. Amazon Personalize guides you through the process of creating and training a machine learning model, primarily by using a combination of data and a recipe\. A *recipe* is an algorithm that's configured to support a specific use case, such as predicting items that a person will like and interact with\.

This combination of data and a recipe is referred to as a *solution*\. After a solution is trained, it becomes a *solution version*\. The solution version is then tested, refined, and prepared for use\. When a solution version is ready for use, it's deployed as an Amazon Personalize campaign\. The campaign is then used to provide real\-time, personalized recommendations\. To learn more about Amazon Personalize, see the [Amazon Personalize Developer Guide](https://docs.aws.amazon.com/personalize/latest/dg/what-is-personalize.html)\.

For Amazon Pinpoint to retrieve recommendations from an Amazon Personalize campaign, the campaign and its components have to meet the following requirements:
+ The recipe has to be a *USER\_PERSONALIZATION* recipe\. It can use any supported algorithm settings \(hyperparameters\) for this type of recipe\. For information about this type of recipe, see [Using Predefined Recipes](https://docs.aws.amazon.com/personalize/latest/dg/working-with-predefined-recipes.html) in the *Amazon Personalize Developer Guide*\.
+ The solution has to be trained using user IDs that can be correlated with endpoint IDs or user IDs in Amazon Pinpoint projects\. Amazon Pinpoint uses the `userId` field in Amazon Personalize to correlate data between users in Amazon Personalize and endpoints or users in Amazon Pinpoint projects\.
+ The solution has to support use of the [GetRecommendations](https://docs.aws.amazon.com/personalize/latest/dg/API_RS_GetRecommendations.html) operation of the Amazon Personalize Runtime API\.
+ The campaign has to use the solution version that you want to retrieve recommendations from\. 
+ The campaign has to be deployed and have a status of *active*\.
+ The campaign has to be running in the same AWS Region as the Amazon Pinpoint projects that will use recommendations from it\. Otherwise, Amazon Pinpoint won't be able to retrieve recommendations from the campaign, which could cause an Amazon Pinpoint campaign or journey activity to fail\.

In addition to these requirements, we recommend configuring the campaign to support at least 20 provisioned transactions per second\.

As you work with your team to implement an Amazon Personalize campaign that meets the preceding requirements, also be sure to answer the following questions:

**Which campaign?**  
To set up the model in Amazon Pinpoint, you'll need to know the name of the Amazon Personalize campaign to retrieve recommendations from\. Later, if you work with your administrator to manually configure access to the campaign, you'll also need to know the Amazon Resource Name \(ARN\) of the campaign\.

**Which type of ID?**  
When you set up the model in Amazon Pinpoint, you choose whether to associate users in the Amazon Personalize campaign with endpoints or users in your Amazon Pinpoint projects\. This enables the model to provide recommendations that are truly specific to a particular message recipient\.  
In an Amazon Personalize campaign, each user has a user ID \(`userId` or `USER_ID`, depending on the context\)\. This is a sequence of characters that uniquely identifies a particular user in the campaign\. In an Amazon Pinpoint project, a message recipient can have two types of IDs:  
+ **Endpoint ID** – This is a sequence of characters that uniquely identifies a destination that you can send messages to—such as an email address, mobile phone number, or mobile device\.
+ **User ID** – This is a sequence of characters that uniquely identifies a particular user\. Each user can be associated with one or more endpoints\. For example, if you communicate with a user by email, SMS, and a mobile app, the user could be associated with three endpoints—one for the user's email address, another for the user's mobile phone number, and another for the user's mobile device\. 
When you choose the type of Amazon Pinpoint ID to associate with Amazon Personalize user IDs, choose the type that you use most consistently in your Amazon Pinpoint projects\. If you or your application hasn't assigned an ID to an endpoint or user, Amazon Pinpoint can't retrieve recommendations for the endpoint or user\. This might prevent Amazon Pinpoint from sending messages to the endpoint or user\. Or, it might cause Amazon Pinpoint to send messages that display in unexpected or unwanted ways\.

**How many recommendations?**  
Each time Amazon Pinpoint retrieves recommendations, Amazon Personalize returns an ordered list of recommendations for each recipient of a message\. You can configure Amazon Pinpoint to retrieve between 1 and 5 of these recommendations for each recipient\. If you choose one recommendation, Amazon Pinpoint retrieves only the first item from the list for each recipient—for example, the most highly recommended movie for a recipient\. If you choose two recommendations, it retrieves the first and second items from the list for each recipient—for example, the top two recommended movies for a recipient\. And so on\.  
Your choice for this setting depends primarily on your goals for messages that include recommendations from the model\. However, it might also depend on how your team designed the solution and your team's evaluation of the solution's performance\. For this reason, work with your team to ensure that you choose an appropriate number for this setting\.

**What does a recommendation contain?**  
When Amazon Pinpoint retrieves recommendations, Amazon Personalize returns an ordered list of 1\-5 recommended items, depending on how many recommendations you choose to retrieve for each message recipient\. Each item consists only of text, such as a product ID or a movie title\. However, the nature and contents of these items can vary from one Amazon Personalize campaign to another, based on the design of the underlying solution and the campaign\.  
Therefore, it's a good idea to ask your team exactly what content the campaign provides for recommended items\. Their answer will probably affect how you design messages that use recommendations from the campaign\. If you want to enhance the content that the campaign provides, you might also choose to implement an AWS Lambda function that can perform this task\.

## AWS Identity and Access Management Roles and Policies<a name="ml-models-rm-prerequisites-iam"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that helps administrators control access to AWS resources\. To learn more about IAM and how it works with Amazon Pinpoint, see [Identity and Access Management for Amazon Pinpoint](https://docs.aws.amazon.com/pinpoint/latest/developerguide/security-iam.html) in the *Amazon Pinpoint Developer Guide*\.

When you set up a recommender model in Amazon Pinpoint, you specify which Amazon Personalize campaign you want to retrieve recommendations from\. To choose the campaign, your administrator needs to first allow you to view the campaigns for your organization's AWS account\. Otherwise, the campaign won't appear in the list of campaigns that you can choose from\. If you don't see the campaign in the list, ask your administrator to provide you with this access\. 

In addition, you or your administrator needs to create an IAM role and policy that allows Amazon Pinpoint to retrieve recommendations from Amazon Personalize campaigns\. When you set up a recommender model, you can choose to have Amazon Pinpoint create this role and policy for you automatically\. Another option is for you or your administrator to create this role and policy manually, before you set up the recommender model in Amazon Pinpoint\. To learn how to do this, see [IAM Role for Retrieving Recommendations](https://docs.aws.amazon.com/pinpoint/latest/developerguide/permissions-get-recommendations.html) in the *Amazon Pinpoint Developer Guide*\.

## AWS Lambda Functions<a name="ml-models-rm-prerequisites-lambda"></a>

For some models, you might want to enhance the recommendations that Amazon Pinpoint receives from Amazon Personalize\. For example, instead of including only a single recommended value \(such as a product name\) in messages, you might want to include additional content \(such as a product's name, description, and image\) in messages\. You can do this by working with your team to design and create an AWS Lambda function that transforms recommendation data into the content that you want\.

AWS Lambda is an AWS service that's designed to help people run code without provisioning or managing servers\. You or your team develops and packages code, and uploads it to AWS Lambda as a Lambda function\. AWS Lambda then runs the function each time the function is invoked by an application or service, such as Amazon Pinpoint\. To learn more about AWS Lambda, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/welcome.html)\.

When you set up a recommender model in Amazon Pinpoint, you specify how you want Amazon Pinpoint to process the recommendations that it receives\. One option is to use a Lambda function\. If you want to use a Lambda function, work with your team to: 
+ Define what the function does\.
+ Define the custom recommended attributes that you want the function to use when it processes recommendations\. This includes the number of attributes, and the name and purpose of each one\. A Lambda function can use as many as 10 custom attributes for each message recipient\. You'll need to enter information about these attributes when you set up the recommender model in Amazon Pinpoint\.
+ Ensure that the function is hosted in the same AWS Region as the Amazon Pinpoint projects that will use it\. Otherwise, Amazon Pinpoint won't be able to send recommendation data to the function, which could cause an Amazon Pinpoint campaign or journey activity to fail\.

Finally, work with your administrator to create a policy that allows Amazon Pinpoint to invoke the Lambda function each time it sends messages that include recommendations from the model\. 

For detailed information about using a Lambda function to process recommendations, see [Customizing Recommendations with AWS Lambda](https://docs.aws.amazon.com/pinpoint/latest/developerguide/ml-models-rm-lambda.html) in the *Amazon Pinpoint Developer Guide*\.