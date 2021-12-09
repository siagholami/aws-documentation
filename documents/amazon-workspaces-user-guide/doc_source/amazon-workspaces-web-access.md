# Amazon WorkSpaces Web Access<a name="amazon-workspaces-web-access"></a>

Users can access their Windows WorkSpaces from any location using a web browser\. This is ideal for users who must use a locked\-down device or restrictive network\. Instead of using a traditional remote access solution and installing the appropriate client application, users can visit the website to access their work resources\.

**Note**  
A web browser cannot be used to connect to Amazon Linux WorkSpaces\.

**Important**  
Beginning October 1, 2020, customers will no longer be able to use the Amazon WorkSpaces Web Access client to connect to Windows 7 custom WorkSpaces or to Windows 7 Bring Your Own License \(BYOL\) WorkSpaces\.

## Website<a name="web-access-url"></a>

Open [Amazon WorkSpaces Web Access](https://clients.amazonworkspaces.com/webclient) to log on to your Windows WorkSpace through your web browser\.

## Requirements<a name="web-access-requirements"></a>

You can access a WorkSpace running the Windows 10 desktop experience and one of the following bundles:
+ Value
+ Standard
+ Performance
+ Power
+ PowerPro

You must run one of the following web browsers on your Windows, macOS, or Linux computer:
+ Chrome 53 and later
+ Firefox 49 and later

You must have web connectivity\.

Your administrator must enable Amazon WorkSpaces Web Access\. For more information, see [Enable and Configure Amazon WorkSpaces Web Access](https://docs.aws.amazon.com/workspaces/latest/adminguide/web-access.html) in the *Amazon WorkSpaces Administration Guide*\.

## Client Views<a name="web-access-views"></a>

Amazon WorkSpaces Web Access supports multiple screen resolutions\. The minimum supported resolution is 960x720 pixels, and the maximum supported resolution is 2560x1600 pixels\.

Web Access does not support multiple monitors\.

## Proxy Servers<a name="web-access-proxy"></a>

If you are required to use a proxy server to access the internet, you can configure your browser to use the proxy server\. Amazon WorkSpaces Web Access respects the settings for all related traffic\.

**Limits**
+ Proxy with authentication is not currently supported\.
+ Proxy server support for Web Access can vary by browser\. Chrome \(versions 55 and later\) supports Web Access traffic routed through a web proxy, while the current Firefox does not\.