# Private Skills<a name="private-skills"></a>

In addition to public Alexa skills, developers can use the Alexa Skills Kit to create and publish skills privately to Alexa for Business organizations\. This way, developers do not need to certify or have the skill available with all other Alexa skills\.

Public and private skills share many of the same features\. They are both developed in the same way using the Alexa Skills Kit, and they can both use account linking to map users to a back\-end system\. There are, however, areas where private skills are different from public skills\. When considering whether to make a skill public or private, refer to the list below\.

A private skill has the following characteristics:
+ The skill isn't discoverable in the public Alexa Skills Store\.
+ The skill developer can whitelist which organizations can review the skill, including its description and functionality, as well as enable it\.
+ The skill developer can control which organizations can enable the private skill and therefore limit attempts to authenticate against back\-end systems for account linking\.
+ The skill does not need to go through Amazon's certification process for public skill publishing and for every skill change\. For more information on public skill certification, see [Certification Requirements for Custom Skills](https://developer.amazon.com/docs/custom-skills/certification-requirements-for-custom-skills.html)\.
+ The IT admin has additional control to review and enable the skill for the organization through the AWS console\.
+ The IT admin can use Alexa for Business to control whether enrolled users can view and enable a private skill\. 

If the skill is intended for a limited audience, such as your organization or partner organizations, it’s a good candidate for a private skill\.

**To create private skills with the Alexa Skills Kit**
+ For information about how to create private skills with the Alexa Skills Kit, see [Build Skills with the Alexa Skills Kit](https://developer.amazon.com/docs/ask-overviews/build-skills-with-the-alexa-skills-kit.html)\.
**Note**  
If you are building a private skill and want to use any information from a shared device that requires permission, follow the instructions in the Alexa Skills Kit\. For more information, see [Permissions](https://developer.amazon.com/fr/docs/devconsole/build-your-skill.html#permissions)\.

**To publish private skills created with the Alexa Skills Kit**
+  There are two ways you can publish private skills created with the Alexa Skills Kit:
  + If you are publishing a single skill, we recommend that you use the [developer console beta](https://developer.amazon.com/alexa/console/ask)\. For more information, see [Create and Publish Private Skills \(Developer Console Beta\)](https://developer.amazon.com/docs/alexa-for-business/create-and-publish-private-skills-devconsole.html)\.
  + If you want to automate the creation of private skills, you can use the ASK CLI\. For more information, see [Create and Publish Private Skills \(ASK CLI\)](https://developer.amazon.com/docs/alexa-for-business/create-and-publish-private-skills.html)\.

**To manage private skills created with the Alexa Skills Kit**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Skills**, **Private skills**\.

1. In the list, select the skill that was published to your account and choose **Review**\.
**Note**  
It takes about 20 minutes after publishing for a skill to appear in this list\.

1. To enable the skill for your Alexa for Business organization, choose **Enable**\.

1. To enable the skill for your Alexa devices, choose **Enabled skills**, select the check box next to the skill that you added, and choose **Add to skill group**\.

1. To make the skill available for end users to discover and enable, choose **Private skills** and select the **Available to users** check box\.