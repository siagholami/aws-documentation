# Android and iOS<a name="android"></a>

The following procedure shows how to establish a VPN connection using the OpenVPN client application on an Android or iOS mobile device\. The steps for Android and iOS are the same\.

**Note**  
For more information about the OpenVPN client application for Android, see the [FAQ regarding OpenVPN Connect Android](https://openvpn.net/vpn-server-resources/faq-regarding-openvpn-connect-android/) on the OpenVPN website\.

Before you begin, ensure that your Client VPN administrator has [created a Client VPN endpoint](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-create) and provided you with the [Client VPN endpoint configuration file](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-export)\.

**To establish a VPN connection**

1. Start the OpenVPN client application and choose **OVPN Profile**\.  
![\[iOS and Android step 1\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/android_01.png)

1. Select the configuration file you received from your Client VPN administrator and choose **Import**\. If you received the configuration file as a \.ovpn attachment in a mail, you can open the file using OpenVPN\.   
![\[iOS and Android step 2\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/android_02.png)

1. Choose **Add**\.  
![\[iOS and Android step 3\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/android_03.png)

1. Choose the toggle next to the OpenVPN profile\.  
![\[macOS and Android step 4\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/android_04.png)

1. To view the connection log file, choose Log File \(top\-right corner\)\. 