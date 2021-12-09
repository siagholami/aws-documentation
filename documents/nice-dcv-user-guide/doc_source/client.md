# NICE DCV Clients<a name="client"></a>

NICE DCV offers a Windows client, Linux client, web browser client, and macOS client\. The clients offer similar feature sets, but there are some differences\. Choose the NICE DCV client that best suits your needs\.

**Topics**
+ [Requirements](#requirements)
+ [Supported Features](#client-features)
+ [Windows Client](client-windows.md)
+ [Web Browser Client](client-web.md)
+ [Linux Client](client-linux.md)
+ [macOS Client](client-mac.md)

## Requirements<a name="requirements"></a>

For a good user experience with NICE DCV, ensure that the client computers meet the following minimum requirements\. Keep in mind that your experience is largely dependent on the number of pixels streamed from the NICE DCV server to the NICE DCV client\.


|  | Native Windows client | Web browser client | Linux client | macOS client | 
| --- | --- | --- | --- | --- | 
| **Software** |  The Native Windows client is supported on 32\-bit and 64\-bit versions of the following operating systems: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dcv/latest/userguide/client.html) The client also requires the following additional software: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dcv/latest/userguide/client.html)  |  The web browser client is supported on the following browsers across all desktop operating systems: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dcv/latest/userguide/client.html) The web browser client also requires WebGL and asm\.js\. The web browser client is not supported on mobile operating systems, such as Android and iOS\.  |  The Linux client is supported on the following modern Linux operating systems: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dcv/latest/userguide/client.html)  |  The macOS client requires macOS High Sierra or later\.  | 
| **Network** | The client must be able to connect to the NICE DCV server, and it must be able to communicate over the required port \(8443 by default\)\. | 

## Supported Features<a name="client-features"></a>

The following table compares the features that are supported by the NICE DCV clients\.


| Feature | [Windows client](client-windows.md) | [Web browser client](client-web.md) | [Linux client](client-linux.md) | [macOS client](client-mac.md) | 
| --- | --- | --- | --- | --- | 
|  [Connect to Windows NICE DCV servers](using-connecting.md)  | ✓ | ✓ | ✓ | ✓ | 
|  [Connect to Linux NICE DCV servers](using-connecting.md)  | ✓ | ✓ | ✓ | ✓ | 
|  [Manage streaming modes](using-streaming.md)  | ✓ | ✓ | ✓ | ✓ | 
|  [Transfer files](using-transfer.md)  | ✓ | ✓ | ✓ | ✓ | 
|  [Print from sessions](using-print.md)  | ✓ | ✓ | ✓ | ✓ | 
|  [Copy and paste](using-copy-paste.md)  | ✓ | ✓ | ✓ | ✓ | 
|  [Smart card support](using-smartcard.md)  | ✓ \(on Linux servers\) | ✗ | ✓ \(on Linux servers\) | ✓ \(on Linux servers\) | 
|  [USB remotization support](using-usb.md)  | ✓ \(installable client\) | ✗ | ✗ | ✗ | 
|  [Connection file support](using-connection-file.md)  | ✓ | ✗ | ✓ | ✓ | 
|  Stereo 2\.0 audio playback  | ✓ | ✓ | ✓ | ✓ | 
|  Surround sound audio playback  | ✓ \(Up to 7\.1\) | ✗ | ✓ \(Up to 5\.1\) | ✗ | 
|  Stereo 2\.0 audio recording \(on Windows servers\)  | ✓ | ✓ | ✓ | ✓ | 
|  Touchscreen  | ✓ \(Windows 8 and later\) | ✓ \* | ✓ | ✗ | 
|  Stylus \(on Linux and Windows 10 and Server 2019 servers\)  | ✓ \(Windows 10 and later\) | ✓ \*\* | ✓ | ✓ | 
|  Multiple monitor support  | ✓ | ✓ | ✓ | ✗ | 

\* Supported with Opera, Firefox version 52 and later, and Edge version 18 and later, and Chrome version 22 and later\.

\*\* Supported on Windows 10 only, with Edge version 79 and later and Chrome\.