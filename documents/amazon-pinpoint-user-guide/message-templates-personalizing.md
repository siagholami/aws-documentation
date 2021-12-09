# Adding Personalized Content to Message Templates<a name="message-templates-personalizing"></a>

To deliver dynamic, personalized content in messages that use a template, add *message variables* to the message template\. A *message variable* is a placeholder that refers to a specific attribute that you or Amazon Pinpoint created to store information about your users\. Each attribute typically corresponds to a characteristic of a user, such as a user's first name or the city where they live\. By adding message variables to templates, you can use these attributes to deliver custom content to each recipient of a message that uses a template\.

If a template contains message variables, Amazon Pinpoint replaces each variable with the current, corresponding value of the attribute for each recipient\. It does this each time it sends a message that uses the template\. This means that you can send personalized content to each recipient without creating multiple, customized versions of a message or message template\. You can also feel confident that the message contains the latest information that you have for a recipient\.

For example, if your project is a fitness application for runners and it includes attributes for each user's first name, preferred activity, and personal record, you could use the following text and message variables in a template:

`Hi {{User.UserAttributes.FirstName}}, congratulations on your new {{User.UserAttributes.Activity}} record of {{User.UserAttributes.PersonalRecord}}!`

When you send a message that uses the template, Amazon Pinpoint replaces the variables with the current value of each attribute for each recipient\. The following examples show this\.

**Example 1**  
`Hi Sofia, congratulations on your new half marathon record of 1:42:17!`

**Example 2**  
`Hi Alejandro, congratulations on your new 5K record of 20:52!`

If an attribute value doesn't exist for a recipient, Amazon Pinpoint can replace a variable with a default value that you specify for the variable\. For example, if a user of your fitness application hasn't chosen their preferred activity, you could use `running` as a default value for the `{{User.UserAttributes.Activity}}` variable\. In this case, Amazon Pinpoint replaces the variable as shown in the following examples:

**Example 1**  
`Hi Jane, congratulations on your new running record of 1:42:17!`

**Example 2**  
`Hi John, congratulations on your new running record of 20:52!`

If you don't specify a default value and a value doesn't exist for a recipient, Amazon Pinpoint omits all text for the variable when it sends a message to that recipient\. For example:

`Hi Mary, congratulations on your new record of 20:52!`

As a best practice, we recommend that you specify a default value for each variable that you include in a template\.

## Adding Message Variables<a name="message-templates-add-variables"></a>

You can add message variables to a new template when you create the template, or to an existing template\. If you add variables to an existing template, Amazon Pinpoint doesn't necessarily apply the changes to messages that use the template and haven't been sent yet, such as campaign messages that are scheduled to be sent at a later time\. This depends on the version of the template that you add variables to and how you configured the messages that use the template\. For more information, see [Managing Versions of Message Templates](message-templates-versioning.md)\.

**To add a message variable to a message template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. On the **Message templates** page, do one of the following: 
   + To create a new template and add a message variable to it, choose **Create template**\. Then, on the template page, enter a name for the template and, optionally, a description of the template\.
   + To add a message variable to an existing template, choose the template that you want to add a variable to\. Then, on the template page, choose **Edit**\. Under **Template details**, use the version selector to choose the version of the template that you want to use as a starting point\. If you choose the most recent version, you can save your changes directly to that version of the template\. Otherwise, you can save your changes as a new version of the template\.

1. In the message details section, determine where you want to add a message variable\. You can add a variable to the body of any type of template\. For email and push notification templates, you can also add a variable to the message subject or title\. 

1. In the **Attribute finder**, expand the section for the type of attribute that you want to add a message variable for\. You can choose from the following types of attributes:  
**Standard attributes**  
These are attributes that Amazon Pinpoint creates automatically for any project\. This means that you can use them in messages that you send for any project\. For detailed information about each of these attributes, see [Supported Attributes](#message-templates-variables)\.  
To add a variable for a standard attribute, choose the attribute from the list\.  
**Custom attributes**  
These are attributes that you optionally create for individual projects\. Because these attributes might not be available for some of your projects, Amazon Pinpoint might not be able to replace the variable with a value for each and every recipient of a message that uses the template\. To help you avoid this issue, Amazon Pinpoint provides options to help you choose an attribute that exists for specific projects or all of your projects\.  
To add a variable for a custom attribute:  

   1. Choose **Load custom attributes**\. In the window that appears, Amazon Pinpoint lists all the projects that you created custom attributes for\. To see which attributes are used by one or more projects, select each project\. The right pane of the window lists all the custom attributes that you created for the selected projects\.

   1. Do one of the following:
      + To use an attribute that exists in one or more specific projects, select each project\.
      + To use an attribute that exists in all of your projects, select **All shared custom attributes**\.

   1. Choose **Load custom attributes**\.

   1. In the **Attribute finder**, choose the attribute that you want to add a variable for\.  
**Recommended attributes**  
These are attributes that you optionally create for your account when you configure Amazon Pinpoint to retrieve personalized recommendations from a recommender model\. For information about using recommender models, see [Machine Learning Models](ml-models.md)\. You can add variables for this type of attribute to email templates, push notification templates, and SMS templates\. You can't add them to voice templates\.  
To add a variable for a recommended attribute, choose the attribute from the list\. If the **Attribute finder** doesn't list any recommended attributes, you have to first connect the template to a recommender model\. To do this, choose **Connect model**\. Next, select the model that you want to retrieve recommendations from when you send messages that use the template\. Then choose **Connect model**\.

1. When you choose an attribute from the **Attribute finder**, Amazon Pinpoint creates a message variable for the attribute and copies it to your clipboard\. Paste the variable in the location that you want\.

   After you paste the variable, Amazon Pinpoint displays it as the name of the associated attribute, enclosed in two sets of curly braces—for example, `{{User.UserAttributes.FirstName}}`\.

1. Repeat steps 4 through 6 for each message variable that you want to add\.

1. To specify a default value for a message variable, expand the **Default attribute values** section\. Then, in the list of variables, enter the default value that you want to use for the variable\.
**Note**  
We recommend that you do this for each variable in the template\. Otherwise, Amazon Pinpoint might not be able to send a message that uses the template or the message might display in unexpected or unwanted ways\.

1. When you finish, do one of the following:
   + If you added message variables to a new template, choose **Create**\.
   + If you added message variables to an existing template and you want to save your changes as a new version of the template, choose **Save as new version**\.
   + If you added message variables to an existing template and you want to save your changes as an update to the most recent version of the template, choose **Update version**\. This option is available only if you opened the most recent version of the template in step 3\.

## Supported Attributes<a name="message-templates-variables"></a>

Each project can have standard attributes and custom attributes\. Standard attributes are attributes that Amazon Pinpoint creates automatically for any project\. Custom attributes are attributes that you optionally create for a project\. There are three types of custom attributes:
+ **User attributes** – These attributes describe a user—for example, a user's first name, last name, and birth date\. A *user* is an individual who has a unique user ID for a project\.
+ **Endpoint attributes** – These attributes describe a specific endpoint for a user\. An *endpoint* is a destination that you can send messages to—such as an email address, phone number, or mobile device\. Each user can be associated with one or more endpoints\. For example, if you communicate with a user by email, SMS, and phone, the user could be associated with three endpoints—one for the user's email address, another for the user's mobile phone number, and another for the user's home \(landline\) phone number\.
+ **Metric attributes** – These attributes are numeric metrics that your application reports to Amazon Pinpoint for individual endpoints, such as the number of sessions for a mobile app or the number of items left in a cart\.

In addition to custom and standard attributes that you or Amazon Pinpoint creates for your projects, Amazon Pinpoint supports *recommended attributes*\. A *recommended attribute* is an attribute that temporarily stores personalized recommendations for users or endpoints\. Amazon Pinpoint retrieves these recommendations from recommender models that you configure it to use\. Recommended attributes aren't associated with specific projects\. Instead, they're associated with your Amazon Pinpoint account\. For information about using recommender models, see [Machine Learning Models](ml-models.md)\.

You can use any standard, custom, or recommended attribute in a message variable\. The following table indicates the text that appears in the message variable for each supported attribute, and it describes each attribute\. In the table, *custom\_attribute* indicates text that appears in a variable for a custom attribute\. In those cases, replace *custom\_attribute* with the name of the custom attribute\. For example, if your project stores users' first names in a custom user attribute named `FirstName` and you add a variable for that attribute, the text for the variable is `{{User.UserAttributes.FirstName}}`\.


| Attribute | Description | 
| --- | --- | 
| Address | The destination address for messages or push notifications that you send to the endpoint—for example, an email address, phone number, or device token\. | 
| Attributes\.custom\_attribute | A custom endpoint attribute that describes the endpoint\. | 
| ChannelType | The channel to use when sending messages or push notifications to the endpoint\. For example:[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/message-templates-personalizing.html) | 
| CreationDate | The date and time when the endpoint was added to the project, in [ISO 8601 format](https://en.wikipedia.org/wiki/ISO_8601)\. For example, 2019\-06\-30T11:45:25\.220Z for 11:45 AM UTC June 30, 2019\. | 
| Demographic\.AppVersion | The version number of the application that's associated with the endpoint\. | 
| Demographic\.Locale | The locale of the endpoint, in the following format: the [ISO 639\-1 alpha\-2](https://en.wikipedia.org/wiki/ISO_639-1) code, followed by an underscore \(\_\), followed by an [ISO 3166\-1 alpha\-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) value\. For example, en\_US is the English language locale for the United States\. | 
| Demographic\.Make | The manufacturer of the endpoint device, such as apple or samsung\. | 
| Demographic\.Model | The model name or number of the endpoint device, such as iPhone or SM\-G900F\. | 
| Demographic\.ModelVersion | The model version of the endpoint device\. | 
| Demographic\.Platform | The operating system on the endpoint device, such as ios or android\. | 
| Demographic\.PlatformVersion | The version of the operating system on the endpoint device\. | 
| Demographic\.Timezone | The endpoint's time zone, as a [tz database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) value\. For example, America/Los\_Angeles for Pacific Time \(North America\)\. | 
| EffectiveDate | The date and time when the endpoint was last updated, in [ISO 8601 format](https://en.wikipedia.org/wiki/ISO_8601)\. For example, 2019\-08\-23T10:54:35\.220Z for 10:54 AM UTC August 23, 2019\. | 
| EndpointStatus | Whether to send messages or push notifications to the endpoint: ACTIVE, send messages to the endpoint; or, INACTIVE, don't send messages to the endpoint\. | 
| Id | The unique identifier for the endpoint\. | 
| Location\.City | The city where the endpoint is located\. | 
| Location\.Country | The two\-character code, in [ISO 3166\-1 alpha\-2 format](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2), for the country or region where the endpoint is located\. For example, US for the United States\. | 
| Location\.Latitude | The latitude coordinate of the endpoint's location, rounded to one decimal place\. | 
| Location\.Longitude | The longitude coordinate of the endpoint's location, rounded to one decimal place\. | 
| Location\.PostalCode | The postal or ZIP code for the area where the endpoint is located\. | 
| Location\.Region | The name of the region, such as a state or province, where the endpoint is located\. | 
| Metrics\.custom\_attribute | A custom, numeric metric that your application reports to Amazon Pinpoint for the endpoint\. | 
| OptOut | Whether the user opted out of receiving messages and push notifications from you: ALL, the user opted out and doesn't want to receive any messages or push notifications; or, NONE, the user hasn't opted out and wants to receive all messages and push notifications\. | 
| RecommendationItems | A standard recommended attribute that stores one recommendation for the endpoint or user\. This attribute contains text that's provided directly by a recommender model\. | 
| RecommendationItems\.\[\#\] | A standard recommended attribute that stores an ordered list of 2–5 recommendations for the endpoint or user\. This attribute contains text that's provided directly by a recommender model\.The numeric placeholder \(\.\[\#\]\) indicates that the attribute contains multiple values\. A message variable for this attribute can refer to a specific value in the list\. | 
| Recommendations\.custom\_attribute | A custom recommended attribute that stores one recommendation for the endpoint or user\. This attribute contains content that's provided by a recommender model and enhanced by an AWS Lambda function\. | 
| Recommendations\.custom\_attribute\.\[\#\] | A custom recommended attribute that stores multiple recommendations for the endpoint or user\. This attribute contains content that's provided by a recommender model and enhanced by an AWS Lambda function\.The numeric placeholder \(\.\[\#\]\) indicates that the attribute contains multiple values\. A message variable for this attribute can refer to one of those values specifically\. | 
| RequestId | The unique identifier for the most recent request to update the endpoint\. | 
| User\.UserAttributes\.custom\_attribute | A custom user attribute that describes the user\. | 
| User\.UserId | A unique identifier for the user\. | 