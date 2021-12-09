# Managing Versions of Message Templates<a name="message-templates-versioning"></a>

To help you manage the development and use of individual message templates, Amazon Pinpoint supports versioning for all types of message templates\. Versioning provides a way for you to create a history of changes to a template—each version is a snapshot of a template at a certain point in time\. Versioning also provides a way for you to control the contents and settings of messages that use a template\.

Each time you change a template, you can specify whether you want to save your changes as a new version of the template or as an update to the most recent, existing version of the template\. As you design, develop, and refine a template, each of these versions serves as a snapshot that can help you track the progress and status of the template\. That is to say, you can use versioning to store, track, and manage a template as it changes over time\. You can:
+ **Track the history of a template** – For each template, Amazon Pinpoint provides a list of versions of the template\. This list displays the name of each version, and it indicates when each version was last changed\. The list is sorted in descending chronological order with the most recent version listed first\.
+ **View and compare versions of a template** – By using the version list, you can browse previous versions of a template\. If you choose a version from the list, Amazon Pinpoint displays the contents and settings that are stored in that version\.
+ **Restore a previous version of a template** – If you find issues in the most recent version of a template, you can open and edit a previous version that doesn't contain the issues\. You can then save that previous version as a new version of the template\. The new version then becomes the most recent version of the template\.

You can also use versioning to control which version of a template can be used in messages\. You do this by designating a specific version as the *active version* of a template\. The *active version* is typically the version that's been most recently reviewed and approved for use in messages, depending on your organization’s workflow for developing and managing templates\. 

When you designate a version as the active version, you enable that version for use in messages\. As a template changes over time, you can designate a different version as the active version, and you can change that designation multiple times\. 

**Topics**
+ [How Versioning Works](#message-templates-versioning-overview)
+ [Viewing Versions of a Message Template](#message-templates-versioning-view-versions)
+ [Viewing the Active Version of a Message Template](#message-templates-versioning-view-active)
+ [Designating the Active Version of a Message Template](#message-templates-versioning-set-active)
+ [Editing the Active Version of a Message Template](#message-templates-versioning-edit-active)

## How Versioning Works<a name="message-templates-versioning-overview"></a>

In a typical development workflow, a message template has many versions\. These versions extend from the start of design and development through testing, review, and, ultimately, approval for use in messages\. In some cases, you might create and approve additional versions after the initial approval, as you refine and update a template\. For example, you might add links or change the layout of a template in response to analytics data for a campaign that uses the template\.

### Version Numbering<a name="message-templates-versioning-overview-numbering"></a>

When you create a template, there is only one version of the template—*Version 1*\. Each time you subsequently change a template, you specify whether you want to save your changes as a new version of the template, or as an update to the most recent version of the template\. 

If you save your changes as a new version, Amazon Pinpoint automatically increments the version number by 1 and assigns that version number to the version—*Version 1* for the first version, *Version 2* for the second version, *Version 3* for the third version, and so on\. Version numbers are never reused\. You can save as many as 5,000 versions of a template\.

If you save your changes as an update to the most recent version, Amazon Pinpoint overwrites the most recent version to include your changes\. To ensure that you have an accurate view of a template’s history, you can overwrite only the most recent version of a template by using the Amazon Pinpoint console\. You can't overwrite any earlier versions of a template by using the console\.

### Current and Active Versions<a name="message-templates-versioning-overview-version-types"></a>

To support long\-term, continuous development of templates, two versions of a template can be current at the same time\. They are: the *latest* version, which is the version that was most recently changed; and, the *active* version, which is the version that can be used in messages\.

Depending on your organization's workflow, the active version is typically the version that's been most recently reviewed and approved for use in messages\. It isn't necessarily the latest version of a template\. In addition, any version other than the active version is considered a draft or archival version of a template\. This means that you can use only the active version of a template in messages that you create by using the Amazon Pinpoint console\.

For example, you might create several versions of a template as you design and develop the template\. When the latest version of the template is complete and approved for use in messages, you can designate that version as the active version of the template\. You can then use that active version of the template in messages\. If you later decide to change the template, you can create additional versions for those changes, without affecting the active version of the template or any existing messages that use the template\. 

Of all the versions of a template, one version has to be designated as the active version of the template\. As a template changes over time, you can designate a different version as the active version, and you can change that designation multiple times\. 

### Version Settings for Messages<a name="message-templates-versioning-overview-versions-messages"></a>

To use a specific version of a template in a message, the version must be the active version of the template when you create the message or when Amazon Pinpoint sends the message\. This depends on how you configure a message to use a template\. When you create a message and choose a template for it, you have two options:
+ **Use the version that’s currently active** – If you choose this option, Amazon Pinpoint always sends the same message content and settings, as specified in the version of the template that's active when you create the message\. This means that the message remains the same, regardless of any changes that you make to the template later\.
+ **Use the version that’s active when the message is sent** – If you choose this option, Amazon Pinpoint automatically updates the message content and settings to match whichever version of the template is active when it sends the message\. This means that the message changes if you designate a different version as the active version after you create the message\.

For example, if you do the following:

1. Create *Version 1* of a template\. 

1. Designate *Version 1* as the active version of the template\.

1. Create a message that uses the template and schedule that message to be sent at a later time\.

1. Change the template several times\.

1. Designate a new version \(*Version 5*\) as the active version of the template\.

Amazon Pinpoint does the following for each option when it sends the message:
+ **Use the version that’s currently active** – If you chose this option for the message, Amazon Pinpoint uses the content and settings specified by *Version 1* of the template\. It does this because *Version 1* was the active version of the template when the message was created\.
+ **Use the version that’s active when the message is sent** – If you chose this option for the message, Amazon Pinpoint automatically updates the message to use the content and settings specified by *Version 5* of the template\. It does this because *Version 5* is the active version of the template when the message is sent\.

If you want to ensure that changes to a template don't affect any existing messages that you haven't sent yet, we recommend that you configure your messages to use the version of the template that's active when messages are created, not sent\. Alternatively, if you want to continue to develop a template after you start using it in messages, you can [create a copy of the template](message-templates-managing.md#message-templates-managing-copy), and then edit and use the template copy in new messages\.

## Viewing Versions of a Message Template<a name="message-templates-versioning-view-versions"></a>

By using the **Message templates** page, you can quickly find and open a specific message template\. You can then view a list of the versions that exist for the template\. From that list, you can choose a specific version to view the contents and settings for that version of the template\.

**To view versions of a message template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. On the **Message templates** page, choose the template whose versions you want to view\. The template page opens and displays information about the template\. It also displays the contents and settings for the active version of the template\.

1. Under **Template details**, open the version selector to display a list of versions for the template\.

1. To view the contents and settings for a specific version, use the version selector to choose the version\. After you choose a version, Amazon Pinpoint displays the contents and settings for that version of the template\.

## Viewing the Active Version of a Message Template<a name="message-templates-versioning-view-active"></a>

You can view the active version of a message template in two ways: while you're creating a message that uses the template, and by using the **Message templates** page\. To view the active version of a template while you're creating a message, choose the template for the message\. Amazon Pinpoint automatically displays a preview of the active version of the template\. 

To view the active version of a template by using the **Message templates** page, follow the steps in this topic\.

**To view the active version of a message template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. On the **Message templates** page, choose the template whose active version you want to view\. The template page opens and displays information about the template\. It also displays the contents and settings for the active version of the template\. Under **Template details**, note that **ACTIVE VERSION** appears \(in green\) next to the version name in the version selector\.

1. To view a different version of the template, use the version selector under **Template details** to choose the version that you want\. To view the active version again, use the version selector to choose the version that displays **ACTIVE VERSION** \(in green\) next to the version name\.

## Designating the Active Version of a Message Template<a name="message-templates-versioning-set-active"></a>

When you create a message template, Amazon Pinpoint automatically designates the first version of the template as the active version of the template\. As you create and develop subsequent versions of a template, you can designate a different version as the active version of the template, and you can change that designation multiple times\.

Before you designate a version as the active version of a template, it's a good idea to ensure that all the content and settings in the proposed active version are complete and ready for use\.

It's also a good idea to verify that the differences between the current and proposed active versions won't affect existing messages in unexpected or unwanted ways\. If you designate a different version as the active version, Amazon Pinpoint might apply your change to existing messages that use the template and haven't been sent yet\. This depends on how you configured the messages that use the template\. For more information, see [Version Settings for Messages](#message-templates-versioning-overview-versions-messages)\.

If the template is being used in messages that haven't been sent yet, compare the version that's currently active to the version that you want to make active\. Also, review any journey activities and campaigns that use the template\. Then, edit the template as necessary to address any issues that you find before you designate a different version as the active version\.

If you're concerned about the effects of designating a different version as the active version, you can [create a copy of the template](message-templates-managing.md#message-templates-managing-copy) instead\. You can then edit and use the template copy in new messages\.

**To designate the active version of a message template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. On the **Message templates** page, choose the template that you want to designate the active version for\. The template page opens and displays information about the template\. It also displays the contents and settings for the version that's currently the active version of the template\. 

1. Under **Template details**, use the version selector to choose the version that you want to designate as the active version\. After you choose a version, Amazon Pinpoint displays the contents and settings for that version of the template\.

1. Choose **Make active version**\.

The new active version of the template is now available for use in new messages\. In addition, it's used in any existing messages that haven't been sent yet and are configured to use the version of the template that’s active when the message is sent\.

## Editing the Active Version of a Message Template<a name="message-templates-versioning-edit-active"></a>

Before you edit the active version of a template, it's important to remember that only the active version of a template can be used in messages that you create by using the Amazon Pinpoint console\. For this reason, it's a good idea to first verify that your changes are complete and ready for use\.

It's also a good idea to verify that your changes won't affect existing messages in unexpected or unwanted ways\. Amazon Pinpoint might apply your changes to existing messages that use the template and haven't been sent yet\. This depends on how you configured the messages that use the template\. For more information, see [Version Settings for Messages](#message-templates-versioning-overview-versions-messages)\.

To determine how your changes might affect existing messages, review the contents and settings for the version of the template that's currently active\. Also, review any journey activities and campaigns that use the template\. Then, consider the changes that you plan to make and ensure that your changes align with your goals for existing messages that use the template\. 

Finally, if you're concerned about the effects of editing the active version of the template, you can [create a copy of the template](message-templates-managing.md#message-templates-managing-copy) instead\. You can then edit and use the template copy in messages that you create later\.

**To edit the active version of a message template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. On the **Message templates** page, choose the template whose active version you want to edit\. The template page opens and displays information about the template\. It also displays the contents and settings for the version that's currently designated as the active version of the template\. 

1. Choose **Edit**\.

1. Under **Template details**, use the version selector to ensure that you're editing the active version of the template\. **ACTIVE VERSION** appears \(in green\) next to the name of the active version\. 

1. Make the changes that you want, and then choose **Save as new version**\.

1. Under **Template details**, use the version selector to choose the version of the template that you created in the preceding step\.

1. Choose **Make active version**\.

The new active version of the template is now available for use in new messages\. In addition, it's used in any existing messages that haven't been sent yet and are configured to use the version of the template that’s active when the message is sent\.