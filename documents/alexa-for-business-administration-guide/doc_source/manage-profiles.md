# Managing Room Profiles<a name="manage-profiles"></a>

To simplify the process of creating and managing rooms, first define room profiles\. A room profile contains the settings for your Alexa devices, so that they can provide you with weather, time, and other location\-based information\. For example, you can create a room profile that contains the Alexa settings that apply to all rooms in the same building\.

If you want to offer room booking to your users, Alexa searches all rooms in a room profile when receiving requests like “Alexa, find a room\.” To optimize room searching, you can create a room profile that contains all rooms in the same building, or on the same floor \(depending on your office size\)\.

When you create a room, you must select a room profile\. If you have not created one, a default room profile is provided\. You can modify the settings, including the default room profile, at any time\.

**To create a room profile**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Room profiles**, **Create room profile**\.

1. Fill in the following fields:
   + **Profile name** – Enter a unique name for the room profile\. \(Required\)
   + **Location** – Enter the physical address of the building\. \(Required\)
   + **Time zone** – Select the time zone for the room profile\. \(Required\)
   + **Wake word** – Select the voice command that turns on the device\.
   + **Temperature units** – Choose **Fahrenheit** or **Celsius**\.
   + **Distance units** – Choose **Feet** or **Meters**\.
   + **Max volume** – Choose a value between **6**–**10** to limit the volume output of the device to this value\.
   + **Device setup mode** – Choose **On** to allow users to hold the action button for 7 seconds to put the device into setup mode\. Otherwise, choose **Off**\.
   + **Outbound calling** – Choose **Enable** or **Disable** to specify the ability to make outbound PSTN phone calls from the Echo devices\.
   + **Address book** – Select the address book you want to assign to the room profile\.

1. Choose **Create**\.

You can edit the name, description, and room profile of your room in **Room profile**\. 

**To edit a room profile**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Room profiles** and choose the name of the room profile to edit\.

1. Edit any of the fields and choose **Save**\.

If a room profile is assigned to a room, you can't delete it\.

**To delete a room profile**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Room profiles**, **Delete room profile**\.

1. Select the check box next the room profile to delete\.

1. Choose **Delete room profile**, **Delete**\.