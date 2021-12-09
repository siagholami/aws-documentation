# Installing the Gateway<a name="install-gateway"></a>

The gateway is available on the Alexa for Business console\. 

To install the Alexa for Business gateway, you need the following:
+ One of the following virtual or physical machines to run the Alexa for Business gateway:
  + Windows Server 2008 or later
  + Windows 7 desktop or later
  + Linux server
+ A minimum of 1 GB available disk space\.
+ A minimum of 2 GB of RAM\.
+ Your locally deployed Alexa for Business gateway is allowed to make outbound HTTPS connections\. It also has local network access to control your Cisco TelePresence or Polycom Group Series endpoints\. \(Incoming external communication or inbound ports aren't required\.\)

**To prepare for installation**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conferencing**, **Conferencing equipment skills**, **Alexa for Cisco TelePresence**, and **Download gateway**\.

1. Select the package for your operating system and choose **Download**\.

**To install and configure the gateway on Windows**

1. Run the installer on your Windows server as an administrator: right\-click on the downloaded file and choose **Run as administrator**\.

1. When prompted, enter the user credentials to sign into your Cisco TelePresence or Polycom Group Series endpoints\.

1. Register your gateway\. If it's enabled, the Alexa for Business registration tool starts automatically\. You can also manually run the registration tool as an administrator at **C:\\Program Files\\Amazon\\AlexaForBusinessGateway\\register\.exe**\.

1. Open the Alexa for Business console again, refresh **Alexa for Business Gateways**, and confirm that your gateway is listed\.

1. In the **Services** window, verify that the service \(Alexa for Business gateway\) is installed and running\.

**To install and configure the gateway on Amazon Linux**

1. Install the gateway:
   + On Amazon Linux, Red Hat, or CentOS, run the following command:

     sudo yum install \-y a4b\_gateway\_<architecture>\.rpm
   + For Ubuntu Server, run the following command:

     sudo dpkg \-i a4b\_gateway\_<architecture>\.deb 
   + On other Distros, run the following commands:

     sudo tar zxvf a4b\_gateway\_<architecture>\.tar\.gz

     sudo cp bin/\* /usr/bin/

     sudo mkdir /etc/alexaforbusinessgateway

     sudo cp config/\* /etc/alexaforbusinessgateway

     \(sysvinit\): sudo cp service/sysvinit/alexaforbusinessgateway /etc/init\.d/alexaforbusinessgateway

     \(Upstart\): sudo cp service/upstart/alexaforbusinessgateway\.conf /etc/init/alexaforbusinessgateway\.conf

     \(Systemd\): sudo cp service/systemd/alexaforbusinessgateway\.service /usr/lib/systemd/system/alexaforbusinessgateway\.service

1. Set the credentials of your Cisco TelePresence or Polycom Group Series endpoints:

    sudo nano /etc/alexaforbusinessgateway/secrets\.cfg

1. Verify that the system manager is set to the correct value \(valid values are `sysvinit`, `upstart`, or `systemd`\):

   sudo cat /etc/alexaforbusinessgateway/gateway\.cfg\.template \| grep serviceManager

1. Register the gateway to your Alexa for Business setup:

   1. Run the following command:

      sudo /usr/bin/alexaforbusinessgateway\-register 

   1. When prompted, enter the IAM access keys and secret keys of the IAM users that you created previously\.

   1. For more advanced scenarios, run the following command to see additional help documentation:

      sudo /usr/bin/alexaforbusinessgateway\-register \-\-help

1. Start the Alexa for Business gateway service:
   + sysvinit: sudo service alexaforbusinessgateway start
   + Upstart: sudo initctl start alexaforbusinessgateway
   + Systemd: sudo systemctl start alexaforbusinessgateway

1. \(Optional\) Check the logs for errors logged when starting the service:

   sudo tail /var/log/alexaforbusinessgateway/gateway\.log