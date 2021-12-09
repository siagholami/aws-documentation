# Managing Mobile Push Channels with Amazon Pinpoint<a name="channels-mobile-manage"></a>

Using the console, you can update the credentials that allow Amazon Pinpoint to send push notifications to iOS and Android devices\. You can provide credentials for the following push notification services, each of which is supported by an Amazon Pinpoint channel: 
+ Apple Push Notification service \(APNs\)
+ Firebase Cloud Messaging \(FCM\)
+ Baidu Cloud Push
+ Amazon Device Messaging \(ADM\)

**To update push notification settings**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to manage push notification settings for\.

1. In the navigation pane, under **Settings**, choose **Push notifications**\.

1. Next to **Push notifications**, choose **Edit**\. 

1. On the **Edit push notifications** page, you can update your credentials for the following services:
   + **APNs** – Requires an authentication token signing key or a TLS certificate, which you get from your Apple developer account\. For more information, see the next section, *Managing APNs Settings*\.
   + **FCM** – Requires a Web API Key \(also referred to as an *API\_KEY* or *server key*\), which you get from the Firebase console\. For more information about obtaining FCM credentials, see [Credentials](https://firebase.google.com/docs/cloud-messaging/concept-options#credentials) in the Firebase documentation\.
   + **Baidu Cloud Push** – Requires an API key and a secret key, which you get from your Baidu Cloud Push project\.
   + **Amazon Device Messaging** – Requires the OAuth credentials \(Client ID and Client Secret\) from your Amazon Developer account\. For more information, see [Obtain Credentials](https://developer.amazon.com/public/apis/engage/device-messaging/tech-docs/adm-obtaining-credentials) in the Amazon Device Messaging developer documentation\.

1. When you finish, choose **Save**\.

## Managing APNs Settings<a name="channels-mobile-manage-apns"></a>

On the **Push notifications** settings page for APNs, you can authorize Amazon Pinpoint to send push notifications to your iOS app by providing information about your APNs *key* or *certificate*:

**Key**  
A private signing key used by Amazon Pinpoint to cryptographically sign APNs authentication tokens\. You obtain the signing key from your Apple developer account\.   
If you provide a signing key, Amazon Pinpoint uses a token to authenticate with APNs for every push notification that you send\. With your signing key, you can send push notifications to APNs production and sandbox environments\.  
Unlike certificates, your signing key doesn't expire\. You only provide your key once, and you don't need to renew it later\. You can use the same signing key for multiple apps\. For more information, see [Communicate with APNs using authentication tokens](https://help.apple.com/developer-account/#/deva05921840) in *Xcode Help*\.

**Certificate**  
A TLS certificate that Amazon Pinpoint uses to authenticate with APNs when you send push notifications\. An APNs certificate can support both production and sandbox environments, or it can support only the sandbox environment\. You obtain the certificate from your Apple developer account\.   
A certificate expires after one year\. When this happens, you must create a new certificate, which you then provide to Amazon Pinpoint to renew push notification deliveries\. For more information, see [Communicate with APNs using a TLS certificate](https://help.apple.com/developer-account/#/dev82a71386a) in *Xcode Help*\.

**To manage APNs settings**

1. For **Authentication type**, choose **Key credentials** or **Certificate credentials** to manage the settings for that type\.
   + If you choose **Key credentials**, provide the following information from your Apple developer account\. Amazon Pinpoint requires this information to construct authentication tokens\.
     + **Key ID** – The ID that's assigned to your signing key\. To find this value, choose **Certificates, IDs & Profiles**, and choose your key in the **Keys** section\.
     + **Bundle identifier** – The ID that's assigned to your iOS app\. To find this value, choose **Certificates, IDs & Profiles**, choose **App IDs** in the **Identifiers** section, and choose your app\.
     + **Team identifier** – The ID that's assigned to your Apple developer account team\. This value is provided on the **Membership** page\.
     + **Authentication key** – The \.p8 file that you download from your Apple developer account when you create an authentication key\. Apple allows you to download your authentication key only once\.
   + If you choose **Certificate credentials**, provide the following information:
     + **SSL certificate** – The \.p12 file for your TLS certificate\. You can export this file from Keychain Access after you download and install your certificate from your Apple developer account\.
     + **Certificate password** – If you assigned a password to your certificate, specify it here\.

1. For **Production support**, choose **Yes** if your certificate supports sending push notifications to the APNs production environment\. 
**Important**  
Don't enable this option if your certificate only supports the sandbox environment\.

1. For **Default authentication type**, choose whether Amazon Pinpoint authenticates with APNs using your signing **key** or your TLS **certificate** by default\. Amazon Pinpoint uses this default for every APNs push notification that you send using the console\. You can override the default when you send a message programmatically by using the Amazon Pinpoint API, the AWS Command Line Interface \(AWS CLI\), or an AWS SDK\. If your default authentication type fails, Amazon Pinpoint doesn't attempt to use the other authentication type\.

1. When you finish, choose **Save**\.