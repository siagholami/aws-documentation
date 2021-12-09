# Troubleshooting Amazon WorkSpaces Client Issues<a name="client_troubleshooting"></a>

The following are common issues that you might have with your WorkSpaces client\.

**Topics**
+ [The Amazon WorkSpaces Application Manager client application isn't appearing on my Windows WorkSpace desktop](#no-wam-client)
+ [I don't see any applications listed in the Amazon WorkSpaces Application Manager client application](#no-wam-apps)
+ [After logging in, the Windows client application displays only a white page and I cannot connect to my WorkSpace](#windows_white-page)
+ [My WorkSpaces client gives me a network error, but I am able to use other network\-enabled apps on my device](#net_error)
+ [It sometimes takes several minutes to log in to my Windows WorkSpace](#login_delay)
+ [When I try to log in, the Amazon WorkSpaces Windows client gets stuck on the "Preparing your login page" screen](#login_stuck_preparing_page)
+ [The Amazon WorkSpaces Windows client application login page is very tiny](#login_tiny_page)
+ [Sometimes I am logged off of my Windows WorkSpace, even though I closed the session, but did not log off](#logged_out)
+ [I forgot my password and tried to reset it, but I didn’t receive an email with a reset link](#reset_password)
+ [I can't connect to the internet from my WorkSpace](#internet_access)
+ [I installed a third\-party security software package and now I can't connect to my WorkSpace](#security_software)
+ [I am getting a "network connection is slow" warning when connected to my WorkSpace](#latency_warning)
+ [I got an "invalid certificate" error on the client application\. What does that mean?](#client_cert_error)
+ [I'm having trouble when I try to connect to my Windows WorkSpace using Web Access](#webaccess_connection_issues)
+ [I see the following error message: "Device can't connect to the registration service\. Check your network settings\."](#registration_failure)
+ [I skipped an update to my client application and am having trouble updating my client to the latest version](#client_update_skipped)
+ [My headset doesn't work in my WorkSpace](#headset_problems)
+ [I am unable to install the Android client application on my Chromebook](#chromebook_android_app)
+ [I'm getting the wrong characters when I type; for example, I get \\ and \| when I try to type quotation marks \(' and "\)](#lang_keyboard_mismatch)
+ [I'm having trouble using the Windows logo key in Windows WorkSpaces when working on a Mac](#windows_key_osx)
+ [My WorkSpace looks blurry on my Mac](#screen_blurry_osx)

## The Amazon WorkSpaces Application Manager client application isn't appearing on my Windows WorkSpace desktop<a name="no-wam-client"></a>

The **Amazon WAM** shortcut should be installed on the Windows WorkSpaces client desktop\. If the shortcut isn't on the client desktop, see [Troubleshooting Amazon WAM Issues](https://docs.aws.amazon.com/wam/latest/userguide/troubleshooting.html) in the *Amazon WAM User Guide*\.

## I don't see any applications listed in the Amazon WorkSpaces Application Manager client application<a name="no-wam-apps"></a>

Choose **MY APPS** to see the applications that your admin has specified to install by default on your WorkSpace\. Choose **DISCOVER** to see the applications that your admin has made available for you to install\.

## After logging in, the Windows client application displays only a white page and I cannot connect to my WorkSpace<a name="windows_white-page"></a>

This problem can be caused by expired Verisign/Symantec certificates on your client computer \(not your WorkSpace\)\. Remove the expired certificate and launch the client application again\.

**To find and remove expired Verisign/Symantec certificates**

1. In the Windows **Control Panel** on your client computer \(not your WorkSpace\), choose **Network and Internet**\.

1. Choose **Internet Options**\.

1. In the **Internet Properties** dialog box, choose **Content**, **Certificates**\.

1. In the **Certificates** dialog box, choose the **Intermediate Certificate Authorities** tab\. In the list of certificates, select all certificates that were issued by Verisign or Symantec that are also expired, and choose **Remove**\. Do not remove any certificates that are not expired\.

1. On the **Trusted Root Certificate Authorities** tab, select all certificates that were issued by Verisign or Symantec that are also expired, and choose **Remove**\. Do not remove any certificates that are not expired\.

1. Close the **Certificates** dialog box and the **Internet Properties** dialog box\.

## My WorkSpaces client gives me a network error, but I am able to use other network\-enabled apps on my device<a name="net_error"></a>

The WorkSpaces client applications rely on access to resources in the AWS Cloud, and require a connection that provides at least 1 Mbps download bandwidth\. If your device has an intermittent connection to the network, the WorkSpaces client application might report an issue with the network\.

Amazon WorkSpaces enforces the use of digital certificates issued by Amazon Trust Services, as of May 2018\. Amazon Trust Services is already a trusted Root certificate authority \(CA\) on the operating systems that are supported by Amazon WorkSpaces\. If the Root CA list for your operating system is not up to date, your device cannot connect to WorkSpaces and the client gives a network error\.

**To recognize connection issues due to certificate failures**
+ PCoIP zero clients — The following error message is displayed:

  ```
  Failed to connect. The server provided a certificate that is invalid. See below for details:
  - The supplied certificate is invalid due to timestamp
  - The supplied certificate is not rooted in the devices local certificate store
  ```
+ Other clients — The health checks fail with a red warning triangle for **Internet**\.

**To resolve certificate failures**

Use one of the following solutions for certificate failures\.
+ For the Windows client, download and install the latest Windows client application from [Amazon WorkSpaces Client Downloads](https://clients.amazonworkspaces.com/)\. During installation, the client application ensures that your operating system trusts certificates issued by Amazon Trust Services\. If updating your client does not resolve the issue, contact your Amazon WorkSpaces administrator\.
+ For all other clients, contact your Amazon WorkSpaces administrator\.

## It sometimes takes several minutes to log in to my Windows WorkSpace<a name="login_delay"></a>

Group Policy settings that are set by your system administrator can cause a delay on login after your Windows WorkSpace has been launched or rebooted\. This delay occurs while the Group Policy settings are being applied to the WorkSpace, and is normal\.

## When I try to log in, the Amazon WorkSpaces Windows client gets stuck on the "Preparing your login page" screen<a name="login_stuck_preparing_page"></a>

When starting versions 3\.0\.4 and 3\.0\.5 of the WorkSpaces Windows client application on a Windows 10 machine, the client might get stuck on the "Preparing your login page" screen\. To avoid this issue, either upgrade to version 3\.0\.6 of the Windows client application or do not run the Windows client application with administrator \(elevated\) privileges\.

## The Amazon WorkSpaces Windows client application login page is very tiny<a name="login_tiny_page"></a>

Running the WorkSpaces Windows client with administrator \(elevated\) privileges might result in viewing issues in high DPI environments\. To avoid these issues, run the client in user mode instead\.

## Sometimes I am logged off of my Windows WorkSpace, even though I closed the session, but did not log off<a name="logged_out"></a>

Your system administrator applied a new or updated Group Policy setting to your Windows WorkSpace that requires a logoff of a disconnected session\.

## I forgot my password and tried to reset it, but I didn’t receive an email with a reset link<a name="reset_password"></a>

Contact your Amazon WorkSpaces administrator for assistance\.

## I can't connect to the internet from my WorkSpace<a name="internet_access"></a>

WorkSpaces cannot communicate with the internet by default\. Your Amazon WorkSpaces administrator must explicitly provide internet access\.

## I installed a third\-party security software package and now I can't connect to my WorkSpace<a name="security_software"></a>

You can install any type of security or firewall software on your WorkSpace, but Amazon WorkSpaces requires that certain inbound and outbound ports are open on the WorkSpace\. If the security or firewall software that you install blocks these ports, the WorkSpace might not function correctly or might become unreachable\. For more information, see [Port Requirements for Amazon WorkSpaces](https://docs.aws.amazon.com/workspaces/latest/adminguide/workspaces-port-requirements.html) in the *Amazon WorkSpaces Administration Guide*\.

To restore your WorkSpace, [rebuild your WorkSpace](manage_workspace_client.md#client-rebuild-workspace) if you still have access to it, or ask your Amazon WorkSpaces administrator to rebuild your WorkSpace\. You then have to reinstall the software and properly configure port access for your WorkSpace\.

## I am getting a "network connection is slow" warning when connected to my WorkSpace<a name="latency_warning"></a>

If the round\-trip time from your client to your WorkSpace is longer than 100ms, you can still use your WorkSpace, but this might result in a poor experience\. A slow round\-trip time can be caused by many factors, but the following are the most common causes:
+ You are too far from the AWS Region that your WorkSpace resides in\. For the best WorkSpace experience, you should be within 2,000 miles of the AWS Region that your WorkSpace is in\.
+ Your network connection is inconsistent or slow\. For the best experience, your network connection should provide at least 300 kbps, with capability to provide over 1 Mbps when viewing video or using graphics\-intensive applications on your WorkSpace\.

## I got an "invalid certificate" error on the client application\. What does that mean?<a name="client_cert_error"></a>

The WorkSpaces client application validates the identity of the WorkSpaces service through an SSL/TLS certificate\. If the root certificate authority of the Amazon WorkSpaces service cannot be verified, the client application displays an error and prevents any connection to the service\. The most common cause is a proxy server that is removing the root certificate authority and returning an incomplete certificate to the client application\. Contact your network administrator for assistance\.

## I'm having trouble when I try to connect to my Windows WorkSpace using Web Access<a name="webaccess_connection_issues"></a>

Windows WorkSpaces rely on a specific login screen configuration to enable you to log in from your Web Access client\. Your Amazon WorkSpaces administrator might need to configure Group Policy and Security Policy settings to enable you to log in to your WorkSpace from your Web Access client\. If these settings are not correctly configured, you might experience long login times or black screens when you try to log in to your WorkSpace\. Contact your Amazon WorkSpaces administrator for assistance\.

**Important**  
Beginning October 1, 2020, customers will no longer be able to use the Amazon WorkSpaces Web Access client to connect to Windows 7 custom WorkSpaces or to Windows 7 Bring Your Own License \(BYOL\) WorkSpaces\.

## I see the following error message: "Device can't connect to the registration service\. Check your network settings\."<a name="registration_failure"></a>

When a registration service failure occurs, you might see the following error message on the **Connection Health Check** page: "Your device is not able to connect to the WorkSpaces Registration service\. You will not be able to register your device with WorkSpaces\. Please check your network settings\."

This error occurs when the WorkSpaces client application can't reach the registration service\. Contact your Amazon WorkSpaces administrator for assistance\.

## I skipped an update to my client application and am having trouble updating my client to the latest version<a name="client_update_skipped"></a>

If you've skipped an update to your Amazon WorkSpaces Windows client application and now want to update to the latest version of the client, see [ Update the WorkSpaces Windows client application to a newer version](amazon-workspaces-windows-client.md#windows_update_client)\.

If you've skipped an update to your Amazon WorkSpaces macOS client application and now want to update to the latest version of the client, see [ Update the WorkSpaces macOS client application to a newer version](amazon-workspaces-osx-client.md#osx_update_client)\.

## My headset doesn't work in my WorkSpace<a name="headset_problems"></a>

If you're using the Windows, macOS, or Linux client application for Amazon WorkSpaces and you're having trouble using your USB headset in your WorkSpace, try the following steps: 

1. Disconnect from your WorkSpace \(choose **Amazon WorkSpaces**, **Disconnect WorkSpace**\)\.

1. Unplug your headset, and then plug it back in\. Verify that it works on your local machine\.

1. Reconnect to your WorkSpace\.

Your headset should now work in your WorkSpace\. If you're still having trouble with your headset, contact your WorkSpaces administrator\. 

## I am unable to install the Android client application on my Chromebook<a name="chromebook_android_app"></a>

Version 2\.4\.13 is the final release of the Amazon WorkSpaces Chromebook client application\. Because [ Google is phasing out support for Chrome Apps](https://blog.chromium.org/2020/01/moving-forward-from-chrome-apps.html), there will be no further updates to the WorkSpaces Chromebook client application, and its use is unsupported\.

For [ Chromebooks that support installing Android applications](https://sites.google.com/a/chromium.org/dev/chromium-os/chrome-os-systems-supporting-android-apps), we recommend using the [Amazon WorkSpaces Android Client Application](amazon-workspaces-android-client.md) instead\.

If you are using a Chromebook launched before 2019, see the [ installation steps for Chromebooks launched before 2019](amazon-workspaces-android-client.md#chromebook_install_before_2019) before attempting to install the Amazon WorkSpaces Android client application\.

In some cases, your WorkSpaces administrator might need to enable your Chromebook to install Android applications\. If you are unable to install the Android client application on your Chromebook, contact your WorkSpaces administrator for assistance\.

## I'm getting the wrong characters when I type; for example, I get \\ and \| when I try to type quotation marks \(' and "\)<a name="lang_keyboard_mismatch"></a>

This behavior might occur if your device is not set to the same language as your WorkSpace, or if you are using a language\-specific keyboard, such as a French keyboard\.

There are several ways to solve this issue:
+ Install the appropriate language or keyboard settings on your WorkSpace\. For a Windows WorkSpace, use the following steps:

  1. Log in to the WorkSpace\.

  1. On the Windows **Start** menu, choose **Settings**\.

  1. Choose **Time & Language**, and then choose **Language**\.

  1. Under **Preferred languages**, choose **Add a language**\.

  1. In the **Choose a language to install** dialog box, select the language to add, and then choose **Next**\.

  1. In the **Install language features** dialog box, select the language features you want, and then choose **Install**\. For example, if you only want to add support for a language\-specific keyboard, select **Basic typing** to install keyboard support for that language\.
+ If you are in an AWS Region that supports more than one language, have your WorkSpaces administrator create a WorkSpace for you in your preferred language\. Windows WorkSpaces are currently available in all Regions in English \(US\)\. In certain Regions, other languages are available\. In the Canada \(Central\) Region, Windows WorkSpaces are also available in French \(Canadian\); in the Asia Pacific \(Seoul\) Region, Korean is also available; in the Asia Pacific \(Tokyo\) Region, Japanese is also available; and in the China \(Ningxia\) Region, Chinese \(Simplified\) is also available\. To see which Region your WorkSpace is in, log in to the WorkSpaces client application, and then choose **Support**, **About My WorkSpace**\.
+ Change the keyboard and language settings on your device so that they match the language of your WorkSpace\.

## I'm having trouble using the Windows logo key in Windows WorkSpaces when working on a Mac<a name="windows_key_osx"></a>

By default, the Windows logo key on a Windows keyboard and the Command key on an Apple keyboard are both mapped to the Ctrl key when you're using the Amazon WorkSpaces macOS client application\. If you want to change this behavior so that these two keys are mapped to the Windows logo key, see [Remapping the Windows Logo Key or the Command Key](amazon-workspaces-osx-client.md#osx_remap_command_key) for instructions on how to remap these keys\.

## My WorkSpace looks blurry on my Mac<a name="screen_blurry_osx"></a>

If your screen resolution in WorkSpaces is low and objects look blurry, you need to turn on high DPI mode and adjust the display scaling settings on your Mac\. For more information, see [WorkSpaces High DPI Display Support](high_dpi_support.md)\.