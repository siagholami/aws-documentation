# Windows<a name="client-vpn-connect-windows"></a>

The following procedure shows how to establish a VPN connection using the AWS\-provided client for Windows\. You can download and install the client at [AWS Client VPN download](https://aws.amazon.com/vpn/client-vpn-download/)\.

## Requirements<a name="client-vpn-connect-windows-req"></a>

To use the AWS\-provided client for Windows, the following are required:
+ Windows 10
+ \.NET Framework 4\.7\.2 or higher

The client reserves TCP port 8096 on your computer\. For Client VPN endpoints that use SAML\-based federated authentication \(single sign\-on\), the client reserves TCP port 35001\.

Before you begin, ensure that your Client VPN administrator has [created a Client VPN endpoint](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-create) and provided you with the [Client VPN endpoint configuration file](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-export)\.

## Connecting<a name="client-vpn-connect-windows-connecting"></a>

Before you begin, ensure that you've read the [requirements](#client-vpn-connect-windows-req)\. The AWS\-provided client is also referred to as *AWS VPN Client* in the following steps\.

**To connect using the AWS\-provided client for Windows**

1. Open the **AWS VPN Client** app\.

1. Choose **File**, **Manage Profiles**\.  
![\[Windows manage profiles\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/client-vpn-win-profiles.png)

1. Choose **Add Profile**\.  
![\[Windows add profile\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/client-vpn-win-add-profile.PNG)

1. For **Display Name**, enter a name for the profile\.

1. For **VPN Configuration File**, browse to and then select the configuration file that you received from your Client VPN administrator, and choose **Add Profile**\.

1. In the **AWS VPN Client** window, ensure that your profile is selected, and then choose **Connect**\. If the Client VPN endpoint has been configured to use credential\-based authentication, you'll be prompted to enter a user name and password\.

1. To view statistics for your connection, choose **Connection**, **Show Details**\.  
![\[Windows add profile\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/client-vpn-win-details.png)

1. To disconnect, in the **AWS VPN Client** window, choose **Disconnect**\. Alternatively, choose the client icon on the Windows taskbar, and then choose **Disconnect**\.  
![\[Windows add profile\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/client-vpn-win-disconnect.png)

## Troubleshooting<a name="client-vpn-connect-windows-troubleshooting"></a>

The AWS\-provided client stores log files and configuration files in the following location on your device:

```
C:\Users\User\AppData\Roaming\AWSVPNClient
```

For troubleshooting information, see [Troubleshooting your Client VPN connection](troubleshooting.md)\.