# Windows<a name="windows"></a>

The following procedures show how to establish a VPN connection using Windows\-based VPN clients\.

Before you begin, ensure that your Client VPN administrator has [created a Client VPN endpoint](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-create) and provided you with the [Client VPN endpoint configuration file](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html#cvpn-working-endpoint-export)\.

For troubleshooting information, see [Windows troubleshooting](windows-troubleshooting.md)\.

## OpenVPN GUI<a name="windows-openvpn-gui"></a>

The following procedure shows how to establish a VPN connection using the OpenVPN GUI client application on a Windows computer\.

**Note**  
For information about the OpenVPN client application, see [Community Downloads](https://openvpn.net/community-downloads/) on the OpenVPN website\.

**To establish a VPN connection**

1. Start the OpenVPN client application\.

1. On the Windows taskbar, choose **Show/Hide icons**, right\-click **OpenVPN GUI**, and choose **Import file**\.  
![\[Windows step 2\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/windows_01.png)

1. In the Open dialog box, select the configuration file that you received from your Client VPN administrator and choose **Open**\.

1. On the Windows taskbar, choose **Show/Hide icons**, right\-click **OpenVPN GUI**, and choose **Connect**\.  
![\[Windows step 4\]](http://docs.aws.amazon.com/vpn/latest/clientvpn-user/images/windows_02.png)

## OpenVPN Connect Client<a name="windows-openvpn-connect"></a>

The following procedure shows how to establish a VPN connection using the OpenVPN Connect Client application on a Windows computer\.

**Note**  
For more information, see [Connecting to Access Server with Windows](https://openvpn.net/vpn-server-resources/connecting-to-access-server-with-windows/) on the OpenVPN website\.

**To establish a VPN connection**

1. Start the OpenVPN Connect Client application\.

1. On the Windows taskbar, choose **Show/Hide icons**, right\-click **OpenVPN**, and choose **Import profile**\.

1. Choose **Import from File** and select the configuration file that you received from your Client VPN administrator\.

1. Choose the connection profile to begin the connection\.