# Conference room configuration<a name="configure-rooms"></a>

Amazon Chime can integrate with your in\-room video hardware from Cisco, Tandberg, Polycom, Lifesize, Vidyo, or others when you use the SIP or H\.323 protocol\.

To connect to Amazon Chime using a conference room VTC device that supports SIP, enter one of the following options:
+ **@meet\.chime\.in**
+ **u@meet\.chime\.in**
+ A 10\-digit meeting ID followed by **@meet\.chime\.in**

**meet\.chime\.in** connects your SIP room device to the nearest Amazon Chime Region\. To connect to a specific Region, use Region\-specific DNS entries for SIP room systems\. For more information, see [Session Initiation Protocol \(SIP\) room systems](network-config.md#sip)\.

**Note**  
If your SIP room device does not support TLS and requires TCP connectivity, contact AWS Support\.

If you are using a device that supports only H\.323, you must dial one of the following:
+ **13\.248\.147\.139**
+ **76\.223\.18\.152**

If a firewall is filtering traffic between the VTC device and Amazon Chime, open the ranges for the protocols used\. For more information, see [Network configuration and bandwidth requirements](network-config.md)\.

On the Amazon Chime welcome screen, enter the 10\-digit or 13\-digit meeting ID to join\. You can find the 13\-digit meeting ID in the Amazon Chime client or web app, or choose the **Dial\-in** option\.

## Joining a moderated meeting<a name="room-join-mod"></a>

If the meeting is moderated and you are the host or delegate, enter your 13\-digit meeting ID to join the meeting as a moderator\. If you are a moderator, enter the moderator passcode in the dialpad followed by the pound sign \(\#\) to join and start the meeting\. If you are not a host, delegate, or moderator, you are connected to the meeting after a moderator joins and starts the meeting\.

Moderators have host controls, which means that they can perform additional meeting actions\. These actions include starting and stopping recording, locking and unlocking the meeting, muting all other attendees, and ending the meeting\. For more information, see [Moderator Actions using phone or in\-room video systems](https://docs.aws.amazon.com/chime/latest/ug/moderate-meeting.html#actions-phone-vid) in the *Amazon Chime User Guide*\.

**Note**  
If you are using Alexa for Business to join your Amazon Chime meetings, you can join as a moderator only if your device is connected to an in\-room video system and you dial in by using the device's dialpad\.

## Compatible VTC devices<a name="devices"></a>

The following table is a subset of the compatible VTC devices list\.


| Device | SIP | H\.323 | Comment | 
| --- | --- | --- | --- | 
| Cisco SX20 | Yes | Yes | Audio/Video/Screen: To and From OK | 
| Cisco DX80 | Yes | Yes | Audio/Video/Screen: To and From OK | 
| Lifesize Icon | Yes | No | Audio/Video/Screen: To and From OK | 
| Polycom Debut | Yes | Yes | Audio/Video/Screen: To and From OK | 
| Polycom RealPresence Desktop | No | Yes | Audio/Video: OK, Screen: From device is OK | 
| Polycom Trio | Yes | Yes | Audio/Video/Screen: To and From OK | 
| Tandberg C40 | Yes | Yes | Audio/Video/Screen: To and From OK | 