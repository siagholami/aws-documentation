# Update chatbots<a name="update-bots"></a>

As the Amazon Chime account administrator, you can use the Amazon Chime API with the AWS SDK or AWS CLI to view your chatbot details\. You can also enable or stop your chatbots from being used in your account\. You can also regenerate security tokens for your chatbot\. 

For more information, see the following topics in the *Amazon Chime API Reference*:
+ [GetBot](https://docs.aws.amazon.com/chime/latest/APIReference/API_GetBot.html) – Gets your chatbot details, such as bot email address and bot type\.
+ [UpdateBot](https://docs.aws.amazon.com/chime/latest/APIReference/API_UpdateBot.html) – Enables or stops a chatbot from being used in your account\.
+ [RegenerateSecurityToken](https://docs.aws.amazon.com/chime/latest/APIReference/API_RegenerateSecurityToken.html) – Regenerates the security token for your chatbot\.

You can also change the `PutEventsConfiguration` for your chatbot\. For example, if your chatbot was initially configured to use an outbound HTTPS endpoint, you can delete the previous events configuration and put a new events configuration for a Lambda function ARN\.

For more information, see the following topics in the *Amazon Chime API Reference*:
+ [DeleteEventsConfiguration](https://docs.aws.amazon.com/chime/latest/APIReference/API_DeleteEventsConfiguration.html)
+ [PutEventsConfiguration](https://docs.aws.amazon.com/chime/latest/APIReference/API_PutEventsConfiguration.html)