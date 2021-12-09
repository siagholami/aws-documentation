# Conference Providers<a name="conference-providers"></a>

To use Alexa for Business to join meetings from the conference devices in your meeting rooms, set up your conference provider\. Alexa for Business offers a list of built\-in conference providers, including Amazon Chime, Cisco WebEx, and Zoom\. If you conference provider isn't listed, choose **Custom conference provider** and specify the details\.

The conference provider contains the following settings:
+ Provider name and meeting 
+ PSTN dial\-in
+ SIP/H323 dial\-in 

When you ask Alexa to join a meeting, Alexa searches for a scheduled meeting on the calendar that you can join\. If there's no meeting on the calendar or the user declines to join it, Alexa asks the user for dial\-in information to join a one\-time meeting\. The provider name and meeting settings are used during this exchange\. The following table provides examples of what you can say to Alexa to start meetings\.


**Example Dialogues**  

| Description | Dialogue | 
| --- | --- | 
| Amazon Chime is set up as the conference provider and no meeting PIN is required\. |  User: “Alexa, start my meeting” Alexa: “There is no meeting on the calendar\. What is your <Amazon Chime> meeting ID?”  | 
| A meeting PIN is optional\. |  User: “Alexa, start my meeting\.” Alexa: “There is no meeting on the calendar\. What is your <provider name> meeting ID?” User: “123456789\.” Alexa: “Do you have a meeting PIN?” User: “Yes\.” Alexa: “What is your meeting PIN?” User: “5678\.” Alexa: “OK, joining your meeting\.”  | 
| A meeting PIN is required\. |  User: “Alexa, start my meeting\.” Alexa: “There is no meeting on the calendar\. What is your <provider name> meeting ID?” User: “123456789\.” Alexa: “What is your meeting PIN?” User: “5678\.” Alexa: “OK, joining your meeting\.”  | 