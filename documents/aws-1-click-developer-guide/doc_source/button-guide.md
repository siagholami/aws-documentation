# AWS IoT Enterprise Button User Guide<a name="button-guide"></a>

The AWS IoT Enterprise Button is a simple and easy to configure Wi\-Fi\-based button\. It is designed for enterprises and developers to easily integrate with existing business workflows and systems using the AWS IoT 1\-Click service\.

The AWS IoT Enterprise Button supports three types of clicks:
+ Single
+ Double
+ Long press

To function correctly, you must configure the button's Wi\-Fi connection using the AWS IoT 1\-Click mobile app \(iOS or Android\)\. After the connection is configured and claimed through the mobile app or console, the button should be flashing solid green when a single, double, or long press click occurs\.

If you suspect there is an issue with the button after completing the button configuration, use the information in this table to help you troubleshoot:


|  Color  |  Status  |  Recommendation  | 
| --- | --- | --- | 
|  Blinking white  |  Connecting to Wi\-Fi, obtaining IP address, or connecting to AWS IoT\.  |  N/A  | 
|  Solid green  |  Successfully connected to Wi\-Fi and published a message to AWS IoT\.  |  N/A  | 
|  Blinking blue  |  Button is in configuration mode\.  |  Wait for process to complete\.  | 
|  Solid orange  |  Wi\-Fi not configured\.  |  Configure Wi\-Fi using the AWS IoT 1\-Click mobile app\.  | 
|  Red: short, short, short  |  There was an error connecting to the configured wireless network\.  |  Check if any network settings have changed or if the button is too far away from the Wi\-Fi router\.  | 
|  Red: short, short, long  |  There was an error obtaining an IP address from the wireless network\.  |  Check for wireless network issues\.  | 
|  Red: short, long, short  |  There was an error performing a host name lookup\.  |  Check for wireless network issues\.  | 
|  Red: short, long, long  |  Cannot connect to AWS IoT\.  |  Check for wireless network issues\. If no network issues exist and the problem persists, contact [AWS Support Center](https://console.aws.amazon.com/support/home#/) and provide the device serial number \(DSN\)\. You'll find it on the back of the button\.  | 
|  Red: long, short, short  |  Cannot establish a secure connection with the server\.  |  Check if you have the latest firmware using the AWS IoT 1\-Click iOS or Android mobile apps\.  | 
|  Red: long, short, long  |  Received an HTTP 403 forbidden error\.  |  Contact the [AWS Support Center](https://console.aws.amazon.com/support/home#/) and provide the DSN\. You'll find it on the back of the button\.  | 