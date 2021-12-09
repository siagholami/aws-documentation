# Enabling multi\-factor authentication<a name="connect_mfa"></a>

You can enable multi\-factor authentication for your AD Connector directory by performing the following procedure\. 

**Note**  
Multi\-factor authentication is not available for Simple AD directories\.

**To enable multi\-factor authentication**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

1. In the **Manage Your WorkDocs Sites** page, select the desired site and choose **Actions** and **Manage MFA**\.

1. Enter the following values and choose **Update MFA**\.   
**Enable Multi\-Factor Authentication**  
Check to enable multi\-factor authentication\.  
**RADIUS server IP address\(es\)**  
The IP addresses of your RADIUS server endpoints, or the IP address of your RADIUS server load balancer\. You can enter multiple IP addresses by separating them with a comma \(for example, **192\.0\.0\.0,192\.0\.0\.12**\)\.  
**Port**  
The port that your RADIUS server is using for communications\. Your on\-premises network must allow inbound traffic over the default RADIUS server port \(1812\) from the AD Connector servers\.  
**Shared secret code**  
The shared secret code that was specified when your RADIUS endpoints were created\.  
**Confirm shared secret code**  
Confirm the shared secret code for your RADIUS endpoints\.  
**Protocol**  
Select the protocol that was specified when your RADIUS endpoints were created\.  
**Server timeout**  
The amount of time, in seconds, to wait for the RADIUS server to respond\. This must be a value between 1 and 60\.  
**Max retries**  
The number of times that communication with the RADIUS server is attempted\. This must be a value between 0 and 10\.

   Multi\-factor authentication is available when the **RADIUS Status** changes to **Enabled**\. While multi\-factor authentication is being set up, your users are not able to log in to their Amazon WorkDocs site\.