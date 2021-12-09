# Managing Skills<a name="manage-skills"></a>

Skills are voice\-driven capabilities that enhance the functionality of your Alexa device\. Alexa for Business gives you access to all Alexa skills\. To enable skills for your devices, you must first enable it for your organization and then add it to one or more skill groups that are assigned to your rooms\. For more information, see [Managing Skill Groups](manage-skill-groups.md)\.

**To enable a skill**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Skills**, **Alexa Skills store**\. 

1. Find the skill to add by browsing the list of available skills, filtering by category, or searching by keyword\. You can get more details about the skill and how to add it in the skill details\.

1. Choose **Enable skill**\.

1. If the skill requires it, link your master account by following the account linking steps\. When you are done, you receive a success message in the console\.

1. If the skill supports it, optionally enable permissions by choosing **Allow** next to each permission and choose **Save**\. 

1. Choose **Enabled skills**, select the check box next to the skill that you just added, and choose **Add to skill group**\.

1. Select the check box next to the skill group to which to add the skill, and choose **Add**\.

The skill is enabled on all Alexa devices associated with the skill group\.

**Note**  
If there are a large number of rooms associated with the same skill group, this step might take up to five minutes\.

**To change permissions for a skill**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Skills** and select the skill name\.

1. In the upper\-right corner, choose **Change permissions**\.

1. Choose **Allow** next to each permission to enable it, and then choose **Save**\.
**Note**  
The permission given is at the skill level\. It applies to all shared devices with that skill enabled in your organization\. The permission setting doesn't impact the permissions of your enrolled users\. Users must select the permission for themselves in the Alexa companion app\. For more information, see [Enable Alexa Skills](https://www.amazon.com/gp/help/customer/display.html?nodeId=201848700)\.

**To remove a skill**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Skills**\.

1. Choose **Disable** next to the skill that you want to remove, then choose **Disable**\.

**To link a master account to a skill**  
Some skills require the ability to connect with a user in another system\. This is called account linking, which links an Alexa for Business account to a user account in another system\.

When you add a skill that requires account linking, you are prompted to open the sign\-in page of the skill provider and sign in with your user account\. After you successfully sign in, Alexa obtains an access token that uniquely identifies the user within the system\. Alexa for Business applies this token to all devices that receive your skill by default, making this your master account\. Alexa stores this token and includes it in requests sent to the skill provider when the skill is invoked\.

If you want to link a unique account for the devices in a specific room, you can override the linked account\. For example, to use some smart home skill to control the lights in your conference room, you must link to the user account for that room in the smart home system\.

**To link a skill to a room**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Rooms** and select a room\.

1. In the **Skills** table, choose **Link account to this room**, **Link**\.

1. Follow the skill account linking steps\.

On the **Room details** page, there are optional and required actions available in the **Skill configuration** column, depending on skill type and account linking status:


|  Account linking status/skill type  |  Master account linked  |  Account linked to room  |  No account linking  | 
| --- | --- | --- | --- | 
|  Custom skill  | Link account to this room | Revert to master account |  No action  | 
|  Smart home skill  | Require scope or link account to this room | Revert to master account and require scope |  N/A  | 
|  Private skill  |  Optional skill parameters Link account to this room   | Optional skill parametersRevert to master account |  Optional skill parameters  | 

**To configure the scope of a smart home skill**
**Note**  
Not all smart home skills use scope\. Check with the skill developer to see if they do, and if so, what the value should be\. 

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Rooms** and select a room\.

1. In the **Skills** table, choose the edit icon next to the text field and enter the scope for a smart home with a master account skill linked\.

1. Choose **Save**\.

**To configure a skill parameter of a private skill**
**Note**  
Not all private skills call into Alexa for Business to use the scope\. Check with the skill developer to determine if this value is needed, and if so, what it should be\. 

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Rooms** and select a room\.

1. In the **Skills** table, choose the edit icon next to the text field and enter the skill parameter value\.

1. Choose **Save**\.