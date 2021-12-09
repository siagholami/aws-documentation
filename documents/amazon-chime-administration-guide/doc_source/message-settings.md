# Managing messages<a name="message-settings"></a>

If you have the ability to program, you can use the Amazon Chime API to remove messages from chat rooms and conversations in your account\.

## Removing messages<a name="remove-messages"></a>

Use the Amazon Chime API to remove reported messages from conversations and chat rooms in your organization\. You must have the message ID and the conversation ID or chat room ID\.

Users can report messages by sending you the message ID information\. This includes the conversation ID or chat room ID\. Users can choose **Copy message ID** next to a message to copy all of the message ID information to their clipboard\. For more information, see [Using chat features](https://docs.aws.amazon.com/chime/latest/ug/chat-features.html) in the *Amazon Chime User Guide*\.

**To remove a message**
+ Do one of the following:
  + **For conversation messages** – Use the [RedactConversationMessage](https://docs.aws.amazon.com/chime/latest/APIReference/API_RedactConversationMessage.html) API operation in the *Amazon Chime API Reference*\.
  + **For chat room messages** – Use the [RedactRoomMessage](https://docs.aws.amazon.com/chime/latest/APIReference/API_RedactRoomMessage.html) API operation in the *Amazon Chime API Reference*\.

The message is removed from its conversation or chat room and can no longer be viewed\.