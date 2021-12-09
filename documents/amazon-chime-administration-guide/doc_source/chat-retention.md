# Managing chat retention policies<a name="chat-retention"></a>

Administrators of Amazon Chime Enterprise accounts can choose to set chat retention policies for the following:
+ The chat conversations that include only members of their Enterprise account
+ The chat rooms that are created by members of their Enterprise account

Messages are automatically deleted based on the time period set by the administrator\. You can set time periods lasting from one day to 15 years\.

**Note**  
A retention period of 90 days applies to the chat conversations that include any users who are members of an Amazon Chime Enterprise account and any users who do not belong to the same Enterprise account\. The preceding messages are automatically deleted after 90 days\.  
Retention policies do not apply to the following:  
The chat conversations that do not include any members of Amazon Chime Enterprise accounts
The chat rooms created by users who are not members of an Amazon Chime Enterprise account

## How retention policies affect Amazon Chime users<a name="retention-policy-users"></a>

The retention policies that Enterprise account administrators set affect Amazon Chime users differently, depending on whether the users are part of the same Enterprise account, a different Enterprise account, a Team account, or whether the users are not members of any account\.

**Enterprise member chat conversations**  
The following table shows how retention policies affect chat conversations for Enterprise account members\.


| If the chat conversation includes\.\.\. | The retention policy is\.\.\. | 
| --- | --- | 
|  Only other members of the user’s Enterprise account   |  Set by the user’s administrator  | 
|  Anyone outside of the user’s Enterprise account  |  Automatically set to 90 days  | 

**Enterprise member chat rooms**  
The following table shows how retention policies affect chat rooms for Enterprise account members\.


| If the chat room is created by\.\.\. | The retention policy is\.\.\. | 
| --- | --- | 
|  A member of the user’s Enterprise account   |  Set by the user’s administrator  | 
|  Another Enterprise account member  |  Set by the other account’s administrator  | 
|  A non\-Enterprise account member  |  Not applicable  | 

**Team member chat conversations**  
The following table shows how retention policies affect chat conversations for Team account members\.


| If the chat conversation includes\.\.\. | The retention policy is\.\.\. | 
| --- | --- | 
|  Only users who are not members of an Enterprise account   |  Not applicable  | 
|  At least one member of an Enterprise account  |  Automatically set to 90 days  | 

**Team member chat rooms**  
The following table shows how retention policies affect chat rooms for Team account members\.


| If the chat room is created by \.\.\. | The retention policy is\.\.\. | 
| --- | --- | 
|  A Team account user  |  Not applicable  | 
|  Anyone who is not an Enterprise account member  |  Not applicable  | 
|  A member of an Enterprise account  |  Set by the Enterprise account’s administrator  | 

Amazon Chime users who are not members of an Enterprise or Team account are only subject to chat room retention policies in chat rooms that are created by a member of an Enterprise account\.

**Chat conversations with recipients who do not belong to an Enterprise or Team account**  
The following table shows how retention policies affect chat conversations for users who are not members of an Amazon Chime Enterprise or Team account\.


| If the chat conversation includes\.\.\. | The retention policy is\.\.\. | 
| --- | --- | 
|  Only users who are not members of an Enterprise account   |  Not applicable  | 
|  At least one member of an Enterprise account  |  Automatically set to 90 days  | 

**Chat rooms created by users who do not belong to an Enterprise or Team account**  
The following table shows how retention policies affect chat rooms for users who are not members of an Amazon Chime Enterprise or Team account\.


| If the chat room is created by \.\.\. | The retention policy is\.\.\. | 
| --- | --- | 
|  A user who is not a member of an Enterprise or Team account  |  Not applicable  | 
|  A Team account user  |  Not applicable  | 
|  A member of an Enterprise account  |  Set by the Enterprise account’s administrator  | 

## Turning on chat retention<a name="turn-on-chat-retention"></a>

Amazon Chime Enterprise account administrators can use the Amazon Chime console to turn chat retention on for chat conversations and chat rooms in their account\. You can also use the console to update chat retention periods or turn off chat retention at any time\.

**To turn on chat retention**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. On the **Accounts** page, select the name of the account\. 

1. For **Settings**, choose **Retention**\.

1. Turn on **Chat conversation retention**\.

1. For **Retention period**, select the length of the retention period for chat conversations\.

1. Turn on **Chat room retention**\.

1. For **Retention period**, select the length of the retention period for chat room messages\.

Within one day of setting a chat retention period, users in your account lose access to applicable chat messages that are outside of the chat retention period\.

## Restoring and deleting chat messages<a name="restore-delete-chat-data"></a>

As an Enterprise account administrator, you can restore chat messages to your users within 30 days of setting or updating a chat retention period\. However, after the 30\-day grace period, all chat messages that fall under the retention period are permanently deleted, and new chat messages are permanently deleted as soon as they pass the retention period\.

**Note**  
During the 30\-day grace period, if you update a chat retention policy with a longer retention period or turn it off, chat messages that haven't passed the new retention period become visible again to users in your account\.

Chat messages are also permanently deleted from Amazon Chime when an Enterprise account administrator or a member of your account performs one or more of the following actions:
+ Deletes an Amazon Chime chat room
+ Ends an Amazon Chime meeting in which chat messages are present