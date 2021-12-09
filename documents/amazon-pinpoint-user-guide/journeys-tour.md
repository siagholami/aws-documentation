# Take a Tour of Journeys<a name="journeys-tour"></a>

Journeys includes some new concepts and terminology that you might not be familiar with\. This topic explores these concepts in detail\.

## Journeys Terminology<a name="journeys-tour-terminology"></a>

**Journey workspace**  
The area of the journey page where you create your journey by adding activities\.

**Activity**  
A step in a journey\. Different things can happen when participants arrive on different types of activities\. In Amazon Pinpoint, you can create the following types of activities:    
**Send email**  
When a participant arrives on a **Send email** activity, Amazon Pinpoint sends them an email\. When you create a **Send email** activity, you specify an [email template](message-templates-creating-email.md) to use for the email\. Email templates can include message variables, helping you to create a more personalized experience\.  
**Wait**  
When a participant arrives on a **Wait** activity, they remain on that activity until a certain date or for a specific amount of time\.  
**Yes/No split**  
Sends participants down one of two paths based on criteria that you define\. For example, you can send all participants who read an email down one path, and send everyone else down the other path\.  
**Multivariate split**  
Sends participants down one of up to four paths, based on criteria that you define\. Participants who don't meet any of the criteria proceed down an "Else" path\.  
**Holdout**  
Ends the journey for a specified percentage of participants\.  
**Random split**  
Randomly sends participants down one of up to five paths\.

**Path**  
A connector that joins one activity to another\. A split activity might have several paths\.

**Participant**  
A person who is traveling through the activities in a journey\.

## Parts of the Journeys Interface<a name="journey-tour-interface"></a>

This section contains information about the components of the journeys interface\. When you create or edit a journey, you see the journey workspace\. The following image shows an example of the journey workspace\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-workspace.png)

The following table includes descriptions of several of the buttons that appear in the journey workspace\.


****  

| Appearance | Button name | Description | 
| --- | --- | --- | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-info-button.png) | **Info** | Opens the help panel, which shows additional information about individual journey activities\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-delete-action-button.png) | **Delete activity** | Deletes the highlighted activity\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-undo-button.png) | **Undo** | Reverts the most recent action\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-redo-button.png) | **Redo** | Restores an action that was previously undone by using the **Undo** button\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-center-button.png) | **Center** | Moves to the top of the journey and centers the **Journey entry** activity on the journey workspace\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-zoom-out-button.png) | **Zoom out** | Reduces the size of objects in the journey workspace\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-zoom-in-button.png) | **Zoom in** | Increases the size of objects in the journey workspace\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-add-activity.png) | **Add activity** | This button appears at every point where you can insert another step in the journey\. When you choose this button, you see a menu that lets you choose an activity type\. | 
| ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-feedback-button.png) | **Feedback** | A quick and easy way to provide feedback about your experience using journeys\. We review all of the feedback that we receive through this button\. We might contact you for additional information if we have any questions\. | 