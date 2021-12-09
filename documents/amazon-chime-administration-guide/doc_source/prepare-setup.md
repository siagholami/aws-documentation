# Preparing for setup<a name="prepare-setup"></a>

There are two ways to set up Amazon Chime on Dolby hardware\. If your company has an Enterprise Active Directory account, you can set it up in a shared conference room that many attendees can use\. As a shared conference room device, organizers invite the conference room to a meeting\. Attendees in the room can join with a single tap\. When Alexa for Business is enabled for Dolby Voice Room, attendees can also join with a voice command using Alexa\.

Alternately, you can associate Dolby hardware with a single, dedicated user\. As a dedicated device, the Dolby Voice Room or Dolby Voice Huddle device is paired with an Amazon Chime profile\. This lets the user conveniently select a meeting to join, just like they would using a desktop or mobile client\. Dedicated devices can only be paired with registered profiles with either Basic or Pro permission\. Make sure that the user is registered before proceeding\.

**To prepare setup for a shared conference room**

1. Create an administrator group to manage the conference room devices called a delegate group:

   1. Create or identify an Active Directory group that consists of administrators who can use their Amazon Chime credentials to set up devices\.

   1. Open the Amazon Chime console and choose the Amazon Chime Enterprise Directory account\.

   1. Choose **Identity**, **Delegates**, and **Add a new group**\.

   1. Enter the Active Directory group name that contains the users who have permissions to use their Amazon Chime to set up Dolby devices in conference rooms \(for example, IT\-AudioVisual\-owners\)\.
**Note**  
These users must have Basic or Pro permissions to use Amazon Chime and be a part of an Active Directory group\. For more information, see [Managing user permissions and access](manage-access.md)\.

1. Create a profile for the conference room:

   1. Make sure that your conference room is set up as a resource in your calendaring system\.

   1. Get the email address used when inviting the resource to a meeting\.

   1. Open the Amazon Chime console and choose the Amazon Chime Enterprise Directory account\.

   1. To create a shared device profile, choose **Users**, **Shared devices**, **Create shared device profile**, enter the email address of the conference room, and choose **Create**\.

1. Set up a phone number for the device to use for inbound and outbound calling\. To do this, use Amazon Chime Business Calling to provision a phone number and assign a number from the phone number Inventory to the shared device profile\. For more information, see [Managing phone numbers in Amazon Chime](phone-numbers.md)\.
**Note**  
You can also complete this step after pairing the device below\. 

1. If you want to enable Alexa on a Dolby Voice Room device, first set up Alexa for Business\. For information, see the [Alexa for Business Administration Guide](https://docs.aws.amazon.com/a4b/latest/ag/what-is.html)\. Then, follow these steps to enable it:
**Note**  
You can also complete this step after pairing the device below\. 

   1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

   1. Choose **Users**, **Shared devices**, select a device, then choose **Actions** and **Enable Alexa for Business**\.

**To prepare setup for a single user**

1. Set up a phone number for the device to use for inbound and outbound calling\. To this, use Amazon Chime Business Calling to provision a phone number and assign a number from the phone number Inventory to the shared device profile\. For more information, see [Managing phone numbers in Amazon Chime](phone-numbers.md)\.
**Note**  
You can also complete this step after pairing the device below\. 

1. Set up an Amazon Chime user profile to allow it to be associated with a Dolby device\. When an Amazon Chime user profile is set up for a Dolby Voice Room device, it can then use Alexa for Business\.

   1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

   1. Select the Amazon Chime account\.

   1. Using the email address, locate the user’s profile to be used for the Dolby device\.
**Note**  
This user must have a registered Amazon Chime account\.

   1.  To edit the user’s profile, select the account, choose **Users**, select the user to open the user detail page, choose **User actions**, **Edit profile type**, and **Shared device profile**\.

1. If you want to enable Alexa on a Dolby Voice Room device, first set up Alexa for Business\. For information, see the [Alexa for Business Administration Guide](https://docs.aws.amazon.com/a4b/latest/ag/what-is.html)\. Then, follow these steps to enable it:
**Note**  
You can complete this step after device pairing\.

   1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

   1. Choose **Users**, **Shared devices**, select a device, then choose **Actions** and **Enable Alexa for Business**\.