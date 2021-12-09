# Editing domain identity policies<a name="editing_domains"></a>

Domain identity policies specify permissions for email actions \(such as redirecting email messages\)\. You can redirect email to any email address of your choosing\. However, if your domain was added prior to October 13, 2016, you need to update the sending authorization policy manually to support that\.

The update is the addition of a new action: `ses:*`\. Domains added after October 13, 2016 have this action added by default\.

**Note**  
Exercise caution when editing other sections of the `ses` policy, as incorrect settings can have an adverse effect on Amazon WorkMail functionality\.

**To update the domain identity policy**

1. Sign in to the AWS Management Console and open the Amazon SES console at [https://console\.aws\.amazon\.com/ses/home](https://console.aws.amazon.com/ses/home)\.

1. In the **Navigation** pane of the Amazon SES console, under **Identity Management**, choose **Domains**\.

1. In the list of domains, select the domain to edit\.

1. In the **Details** pane, expand **Identity Policies**, find the policy to edit, and then choose **Edit Policy**\.

1. In the **Edit Policy** pane, under `"Action"`, add `ses:*,`\.

1. Choose **Apply Policy**\.

The updated actions of the policy should look like the following\. 

```
            "Action": [
                "ses:*",
                "ses:SendBounce",
                "ses:SendRawEmail"
            ],
```