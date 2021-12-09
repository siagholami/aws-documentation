# Step 1: Integrate a chatbot with Amazon Chime<a name="integrate-bots"></a>

After you complete the [prerequisites](use-bots.md#bots-prereqs), integrate your chatbot with Amazon Chime using the AWS CLI or Amazon Chime API\.

**Note**  
These procedures create a name and email address for your chatbot\. Chatbot names and email addresses cannot be changed after creation\.

## AWS CLI<a name="integ-cli"></a>

**To integrate a chatbot using the AWS CLI**

1. To integrate your chatbot with Amazon Chime, use the create\-bot command in the AWS CLI\.

   ```
   aws chime create-bot --account-id 12a3456b-7c89-012d-3456-78901e23fg45 --display-name exampleBot --domain example.com
   ```

   1. Enter a chatbot display name of up to 55 alphanumeric or special characters \(such as \+, \-, %\)\.

   1. Enter the registered domain name for your Amazon Chime Enterprise account\.

1. Amazon Chime returns a response that includes the bot ID\.

   ```
   "Bot": {
           "CreatedTimestamp": "timeStamp",
           "DisplayName": "exampleBot",
           "Disabled": exampleBotFlag,
           "UserId": "1ab2345c-67de-8901-f23g-45h678901j2k",
           "BotId": "botId",
           "UpdatedTimestamp": "timeStamp",
           "BotType": "ChatBot",
           "SecurityToken": "securityToken",
           "BotEmail": "displayName-chimebot@example.com"
            }
   ```

1. Copy and save the bot ID and bot email address to use in the following procedures\.

## Amazon Chime API<a name="integ-api"></a>

**To integrate a chatbot using the Amazon Chime API**

1. To integrate your chatbot with Amazon Chime, use the [CreateBot](https://docs.aws.amazon.com/chime/latest/APIReference/API_CreateBot.html) API operation in the *Amazon Chime API Reference*\.

   1. Enter a chatbot display name of up to 55 alphanumeric or special characters \(such as \+, \-, %\)\.

   1. Enter the registered domain name for your Amazon Chime Enterprise account\.

1. Amazon Chime returns a response that includes the bot ID\. Copy and save the bot ID and email address\. The bot email address looks like this: `exampleBot-chimebot@example.com`\. 

## AWS SDK for Java<a name="integ-sdk"></a>

The following sample code demonstrates how to integrate a chatbot using the AWS SDK for Java\.

```
CreateBotRequest createBotRequest = new CreateBotRequest()
    .withAccountId("chimeAccountId")
    .withDisplayName("exampleBot")
    .withDomain("example.com");

chime.createBot(createBotRequest);
```

Amazon Chime returns a response that includes the bot ID\. Copy and save the bot ID and email address\. The bot email address looks like this: `exampleBot-chimebot@example.com`\.