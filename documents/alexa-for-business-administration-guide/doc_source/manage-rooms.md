# Managing Rooms<a name="manage-rooms"></a>

A room is a physical location where you can put your Alexa devices\. Examples of rooms include conference rooms, lobbies, or hotel rooms\.

We recommend naming your rooms with unique and meaningful identifiers that can be logically parsed by a third party\. Instead of “Room 12” or “Suite 104,” pick a name like “ORD\_01\_0201” or “SEA\_38\_0021\.” The ResolveRoom API action exposes the room name to third\-party skill developers, including any skills that you develop privately for your organization\. 

**To create a room**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Rooms**, **Create room**\.

1. For **Name**, enter a unique name\.

1. For **Profile name**, select a room profile or choose **Create room profile** and choose **Next**\.

1. \(Optional\) To add a skill group, select the check box next to the skill group to add and choose **Next**\.
**Note**  
You can assign a skill group to multiple rooms at once from the **Skill group** detail page\.

1. \(Optional\) To add devices, select the check box next to the devices\.
**Note**  
You can also assign devices to a room from the **Shared devices** list view\.

1. Choose** Create room**\.

You can edit the name, description, and room profile of your room in the **Rooms** tab\. You can also assign or unassign devices and skill groups in the same tab\.

**To edit a room**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Rooms** and select the name of the room to edit\.

1. Edit the **Name**, **Description**, or **Room profile** and choose **Save**\.

1. Under **Devices or Skill groups**, choose **Assign** or **Unassign**\.

If you no longer need a room, you can delete it\. This stops the Alexa device in the room from responding to voice requests\.

**To delete a room**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Rooms** and select the check box next to the room to delete\.

1. Choose **Delete room**, **Delete**\.

After your room is deleted, your Alexa devices are automatically unassigned and can be assigned to a different room\. For more information, see [Managing Devices](manage-devices.md)\.

Echo, Echo Dot, and Echo Plus devices use on\-device keyword spotting to detect a wake word\. When they detect a wake word, the light ring around the top of the device turns blue to indicate that Alexa is streaming audio to the cloud\. These voice recordings are anonymously stored in the cloud\. You can't view or listen to the interactions that users have with the Alexa devices in a room\. You can choose to delete voice recordings from all of the devices in a specific room\. If you delete these recordings, it might degrade your experience using voice features\. 

**To delete voice recordings**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Rooms** and select a room\.

1.  Choose **Delete voice recordings**, **Delete**\.