# MacOS<a name="macos"></a>

The following procedures show how to establish a VPN connection using macOS\-based VPN clients\.

Before you begin, ensure that your Client VPN administrator has [created a Client VPN endpoint](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-create) and provided you with the [Client VPN endpoint configuration file](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-export)\.

For troubleshooting information, see [MacOS troubleshooting](macos-troubleshooting.md)\.

## Tunnelblick<a name="macos-tunnelblick"></a>

The following procedure shows how to establish a VPN connection using the Tunnelblick client application on a macOS computer\.

**Note**  
For more information about the Tunnelblick client application for macOS, see the [Tunnelblick documentation](https://tunnelblick.net/documents.html) on the Tunnelblick website\.

**To establish a VPN connection**

1. Start the Tunnelblick client application and choose **I have configuration files**\.  
![\[macOS step 1\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/macos_01.png)

1. Drag and drop the configuration file that you received from your VPN administrator in the **Configurations** panel\.  
![\[macOS step 2\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/macos_02.png)

1. Select the configuration file in the **Configurations** panel and choose **Connect**\.  
![\[macOS step 3\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/macos_03.png)

## OpenVPN Connect Client<a name="macos-openvpn"></a>

The following procedure shows how to establish a VPN connection using the OpenVPN Connect Client application on a macOS computer\.

**Note**  
For more information, see [Connecting to Access Server with macOS](https://openvpn.net/vpn-server-resources/connecting-to-access-server-with-macos/) on the OpenVPN website\.

**To establish a VPN connection**

1. Start the OpenVPN application and choose **Import**, **From local file\.\.\.**\.

1. Navigate to the configuration file that you received from your VPN administrator and choose **Open**\.