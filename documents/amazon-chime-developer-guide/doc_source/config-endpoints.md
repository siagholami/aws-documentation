# Step 2: Configure the outbound endpoint for an Amazon Chime chatbot<a name="config-endpoints"></a>

After you create a chatbot ID for your Amazon Chime Enterprise account, configure your outbound endpoint for Amazon Chime to use to send messages to your bot\. The outbound endpoint can be an AWS Lambda function ARN or an HTTPS endpoint that you created as part of the [prerequisites](use-bots.md#bots-prereqs)\. For more information about Lambda, see the *[AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/)*\.

**Note**  
If the outbound HTTPS endpoint for your bot is not configured or is empty, chat room administrators cannot add the bot to a chat room\. Also, chat room users cannot interact with the bot\.

## AWS CLI<a name="endpoint-cli"></a>

To configure an outbound endpoint for your chatbot, use the put\-events\-configuration command in the AWS CLI\. Configure a Lambda function ARN or an outbound HTTPS endpoint\.

------
#### [ Lambda ARN ]

```
aws chime put-events-configuration --account-id 12a3456b-7c89-012d-3456-78901e23fg45 --bot-id botId --lambda-function-arn arn:aws:lambda:us-east-1:111122223333:function:function-name
```

------
#### [ HTTPS endpoint ]

```
aws chime put-events-configuration --account-id 12a3456b-7c89-012d-3456-78901e23fg45 --bot-id botId --outbound-events-https-endpoint https://example.com:8000
```

------

Amazon Chime responds with the bot ID and HTTPS endpoint\.

```
{
    "EventsConfiguration": {
        "BotId": "BotId", 
        "OutboundEventsHTTPSEndpoint": "https://example.com:8000"
    }
}
```

## Amazon Chime API<a name="endpoint-api"></a>

To configure the outbound endpoint for your chatbot, use the Amazon Chime [PutEventsConfiguration](https://docs.aws.amazon.com/chime/latest/APIReference/API_PutEventsConfiguration.html) API operation in the *Amazon Chime API Reference*\. Configure either a Lambda function ARN or an outbound HTTPS endpoint\.
+ **If you configure a Lambda function ARN** – Amazon Chime calls Lambda to add permission to allow the Amazon Chime administrator's AWS account to invoke the provided Lambda function ARN\. This is followed by a dry run invocation to verify that Amazon Chime has permission to invoke the function\. If adding permissions fails, or if the dry run invocation fails, then the `PutEventsConfiguration` request returns an HTTP 4xx error\.
+ **If you configure an outbound HTTPS endpoint** – Amazon Chime verifies your endpoint by sending an HTTP Post request with a Challenge JSON payload to the outbound HTTPS endpoint that you provided in the previous step\. Your outbound HTTPS endpoint must respond by echoing back the Challenge parameter in JSON format\. The following examples show the request and a valid response\.

------
#### [ Request ]

  ```
                 HTTPS POST 
  
                 JSON Payload:
                 {
                    "Challenge":"00000000000000000000",
                    "EventType" : "HTTPSEndpointVerification"
                 }
  ```

------
#### [ Response ]

  ```
                 HTTP/1.1 200 OK
                 Content-type: application/json
  
                 {
                     "Challenge":"00000000000000000000"
                 }
  ```

------

  If the challenge handshake fails, then the `PutEventsConfiguration` request returns an HTTP 4xx error\.

## AWS SDK for Java<a name="endpoint-sdk"></a>

The following sample code demonstrates how to configure an endpoint using the AWS SDK for Java\.

```
PutEventsConfigurationRequest putEventsConfigurationRequest = new PutEventsConfigurationRequest()
     .withAccountId("chimeAccountId")
     .withBotId("botId")
     .withOutboundEventsHTTPSEndpoint("https://www.example.com")
     .withLambdaFunctionArn("arn:aws:lambda:region:account-id:function:function-name");

 chime.putEventsConfiguration(putEventsConfigurationRequest):
```