# Invite and Remove Users<a name="add-users"></a>

After you configure user enrollment for your organization, you can invite users\.

**To invite a user**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Users** and select **Invite new user**\.

1. Enter the **First name**, **Last name**, and **Email address** of the user to enroll\. 
**Note**  
Typically, this is a corporate email address that can be mapped to a corporate identity in your system\. When connecting to a Microsoft Exchange account, this must be the same email address as the one on the corporate Exchange server\.   
Make sure that the email addresses you enter when inviting users are correct\. Whoever receives the email with the unique URL can log in with their Amazon account and be a part of your organization\. 

1. \(Optional\) Choose **Add another user** and add the information from step 3\. Repeat this step until you have entered all the information for the users to invite\. 

1. Choose **Send invite** to send an invitation to each user for whom you provided information\. 

**To remove a user**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Users** and select the check box next to the user to delete\.

1. Choose **Remove user**, **Remove**\.

After you remove a user, they can no longer access any of the benefits of being enrolled in your organization\. If you remove a user who has not completed enrollment, the token is not valid\.

A user might fail to enroll while the URL token is valid\. In this case, you can resend the invitation\. 

**To resend an expired invitation**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Users** and select the check box next to the user\.

1. Choose **Resend invitation**\.