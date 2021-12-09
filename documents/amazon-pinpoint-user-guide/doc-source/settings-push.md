# Push Notification Settings<a name="settings-push"></a>

Use the **Push notifications** settings page to specify the credentials that Amazon Pinpoint should use to send push notifications for the current project to iOS, Android, or Amazon devices\. You can provide credentials for the following push notification services, each of which is supported by an Amazon Pinpoint channel:
+ Amazon Device Messaging \(ADM\)
+ Apple Push Notification service \(APNs\)
+ Baidu Cloud Push
+ Firebase Cloud Messaging \(FCM\)

**Topics**
+ [Updating Push Notification Settings](#settings-push-manage)
+ [Managing APNs Settings](#settings-push-manage-apns)

## Updating Push Notification Settings<a name="settings-push-manage"></a>

By using the console, you can update the credentials that Amazon Pinpoint uses to send push notifications for the current project to iOS, Android, and Amazon devices\.

**To update push notification settings**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to update push notification settings for\.

1. In the navigation pane, under **Settings**, choose **Push notifications**\.

1. Next to **Push notifications**, choose **Edit**\. 

1. To update settings for the Baidu Cloud Push or ADM service, choose **Show more push notification services**\.

1. Enter the correct credentials for the push notification services that you want to use:
   + **APNs** – Requires an authentication token signing key or a TLS certificate, which you get from your Apple developer account\. For more information, see the next section, *Managing APNs Settings*\.
   + **FCM** – Requires a Web API Key, also referred to as an *API\_KEY* or *server key*, which you get from the Firebase console\. For information about obtaining FCM credentials, see [Credentials](https://firebase.google.com/docs/cloud-messaging/concept-options#credentials) in the Firebase documentation\.
   + **Baidu** – Requires an API key and a secret key, which you get from your Baidu Cloud Push project\.
   + **ADM** – Requires the OAuth credentials \(client identifier and client secret\) from your Amazon Developer account\. For more information, see [Obtaining Amazon Device Messaging Credentials](https://developer.amazon.com/public/apis/engage/device-messaging/tech-docs/adm-obtaining-credentials) in the Amazon Developer documentation\.

1. When you finish, choose **Save**\.

## Managing APNs Settings<a name="settings-push-manage-apns"></a>

For the Apple Push Notification service \(APNs\), you can authorize Amazon Pinpoint to send push notifications to your iOS app by providing information about your APNs *key* or *certificate*:

**Key**  
A private signing key that Amazon Pinpoint uses to cryptographically sign APNs authentication tokens\. You obtain the signing key from your Apple developer account\.   
If you provide a signing key, Amazon Pinpoint uses a token to authenticate with APNs for every push notification that you send\. With your signing key, you can send push notifications to APNs production and sandbox environments\.  
Unlike certificates, your signing key doesn't expire\. You provide your key only once, and you don't need to renew it later\. In addition, you can use the same signing key for multiple apps\. For more information, see [Communicate with APNs using authentication tokens](https://help.apple.com/developer-account/#/deva05921840) in *Apple Developer Account Help*\.

**Certificate**  
A TLS certificate that Amazon Pinpoint uses to authenticate with APNs when you send push notifications\. An APNs certificate can support both the production and sandbox environments, or it can support only the sandbox environment\. You obtain the certificate from your Apple developer account\.   
A certificate expires after one year\. When this happens, you must create a new certificate, which you then provide to Amazon Pinpoint to renew push notification deliveries\. For more information, see [Communicate with APNs using a TLS certificate](https://help.apple.com/developer-account/#/dev82a71386a) in *Apple Developer Account Help*\.

**To manage APNs settings**

1. On the **Edit push notifications** page, select **Apple Push Notification service \(APNs\)**\.

1. Under **Authentication type**, choose **Key credentials** or **Certificate credentials**, depending on the type of authentication that you want to use\.
   + If you choose **Key credentials**, provide the following information from your Apple developer account at [https://developer.apple.com/account/](https://developer.apple.com/account/)\. Amazon Pinpoint requires this information to construct authentication tokens\.
     + **Key ID** – The ID assigned to your signing key\. To find this value, choose **Certificates, IDs & Profiles**, and choose your key in the **Keys** section\.
     + **Bundle identifier** – The ID assigned to your iOS app\. To find this value, choose **Certificates, IDs & Profiles**, choose **App IDs** in the **Identifiers** section, and choose your app\.
     + **Team identifier** – The ID assigned to your Apple developer account team\. This value is provided on the **Membership** page\.
     + **Authentication key** – The \.p8 file that you download from your Apple developer account when you create an authentication key\. Apple allows you to download your authentication key only once\.
   + If you choose **Certificate credentials**, provide the following information:
     + **SSL certificate** – The \.p12 file for your TLS certificate\. You can export this file from Keychain Access after you download and install your certificate from your Apple developer account\.
     + **Certificate password** – If you assigned a password to your certificate, enter it here\.

1. For **Production support**, choose **Enabled** if your certificate supports sending push notifications to the APNs production environment\. If your certificate supports the sandbox environment only, choose **Disabled**\.

1. For **Default authentication type**, choose how you want Amazon Pinpoint to authenticate with APNs by default: **Key**, to use your signing key, or **Certificate**, to use your TLS certificate\. Amazon Pinpoint uses this default setting for every APNs push notification that you send by using the console\. You can override the default setting when you send a message programmatically by using the Amazon Pinpoint API, the AWS CLI, or an AWS SDK\. If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type\.

1. When you finish, choose **Save**\.