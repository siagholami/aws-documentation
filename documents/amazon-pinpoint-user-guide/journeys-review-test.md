# Review and Test a Journey<a name="journeys-review-test"></a>

Before you can publish your journey, you have to review it in order to make sure that all of the activities that it contains are configured properly\. It's also a good idea to enroll test users in a copy of the journey before you publish it, to confirm that it behaves the way you expect it to behave\. This section contains information and procedures related to reviewing and testing your journey\.

## Reviewing a Journey<a name="journeys-review"></a>

The review feature provides information about configuration errors in your journey, and also provides some recommendations\.

**To review a journey**

1. In the upper\-right corner of the journey workspace, choose **Review**\. The **Review your journey** pane appears in the journey workspace\. The following image shows the journey workspace with the **Review your journey** pane opened\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-review-pane.png)

1. Review the error messages that are shown on the first page of the **Review your journey** pane\. You can't publish your journey until you resolve all the issues that are shown on this page\. If there aren't any issues with your journey, you see a message stating that your journey doesn't contain any errors\. When you're ready to proceed, choose **Next**\.
**Tip**  
Choose an error to go directly to the activity that it applies to\.

1. The second page of the **Review your journey** pane contains recommendations and best practices that are relevant to your journey\. You can proceed without resolving the issues that are shown on this page\. When you're ready to proceed, choose **Mark as reviewed**\.

1. On the third page of the **Review your journey** pane, you can publish your journey\. If you're ready for customers to enter the journey, choose **Publish**\. However, if you want to test your journey first, close the **Review your journey** pane, and then complete the steps in [Testing a Journey](#journeys-test)\.

## Testing a Journey<a name="journeys-test"></a>

One of the most important steps in creating a journey is testing it to make sure that it behaves as intended\. Journeys includes a testing feature that makes it easy to send a group of test participants through the journey\. It includes features that let you reduce or eliminate the amount of time that participants spend on wait or multivariate split activities, so that you can test each journey thoroughly and quickly\.

**To test a journey**

1. Create a new segment that contains only the test participants who you want to participate in the test journey\. Or, if you already have a segment of test participants, proceed to the next step\.

   For more information about creating segments, see [Building Segments](segments-building.md)\.
**Tip**  
One of the easiest ways to create a test segment is by importing a spreadsheet\. For more information, see [Importing Segments](segments-importing.md)\.

1. On the **Actions** menu, choose **Test**\.

1. For **Test segment**, choose the segment that contains the test participants\.

1. Choose how to handle delays in the journey\. You can choose one of the following options:
   + **Skip all waits and delays** – Choose this option to have test participants proceed from one activity to another without any intervening delays\.
   + **Custom wait time** – Choose this option to have test participants wait for a pre\-defined amount of time at each activity that includes a delay\. This option is helpful if your journey contains wait activities, or yes/no split or multivariate split activities that are based on customer interactions\.

1. Choose **Send test**\. Amazon Pinpoint creates a new journey with `Test-` added to the beginning of the journey name\. The test participants are added to the journey\.

1. When you finish testing, choose **Stop journey** to permanently end the test journey\.
**Tip**  
During the testing process, if you discover that you need to make changes to the original journey \(that is, the journey that the test journey was based on\), return to the **Journeys** page\. In the list of journeys, choose the original journey, and then make your changes\. Changes that you make to the test journey aren't automatically applied to the journey that the test is based on\.

### Best Practices for Testing Your Journeys<a name="journeys-test-best-practices"></a>
+ Include several test participants in the segment that you use to test your journey\.
+ Include test participants whose email addresses are on domains other than your own\.
+ Use a variety of email clients and operating systems to test the messages that are sent from your journey\.
+ If your journey includes yes/no split or multivariate split activities that are based on interactions with your emails, test those interactions\. For example, if you have a split activity that checks to see if an email was opened, then some of your test participants should open the email\. Then, check the **Journey metrics** pane to make sure that the correct number of users went down each path\.
+ If your email templates include message variables that refer to endpoint attributes, make sure that your test participants have those same attributes\. For example, if your email template refers to a `User.UserAttributes.FirstName` attribute, the endpoints in your test segment should also have that attribute\.

**Next**: [Publish a Journey](journeys-publish.md)