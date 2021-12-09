# Import the Installer VM Certificate<a name="getting-started-with-rds-on-vmware.onboard.import-vm-certificate"></a>

You can extract the self\-signed certificate generated at bootstrap time on the installer VM from vCenter\. You then convert the certificate to binary format that you can import as a Trusted CA on the browser\. Doing so makes the connection in between the browser and the RDS Installer secure\.

**Note**  
The process described in this section should work for most operating systems and browsers\. However, each operating system and browser has its own way of storing and managing certificates\. We described the sequence of steps for Windows 10, Chrome Version 77\.0\.3865\.90, and Microsoft Edge 44\.18362\.387\.0\. We also tested this process for Mac OS and Chrome\.

Performing this process avoids the **Connection Not Secure** alert in the browser when accessing the Installer because the application uses self\-signed certificates\. 

The process requires the Managed Object Browser \(MOB\) to find the certificate of the Installer\. Make sure that you have the MOB accessible\. The MOB provides a way to explore the vSphere object model\. However, it's not enabled in production systems on vSphere 6\.5 and higher\. To enable it, see the [ VMware documentation](https://docs.vmware.com/en/VMware-vSphere/6.5/com.vmware.vsphere.security.doc/GUID-0EF83EA7-277C-400B-B697-04BDC9173EA3.html)\.

**To import the Installer VM certificate**

1. Power on the Installer VM for Amazon RDS on VMware\.

1. Get the VM Object Reference certificate by navigating the MOB\.

   1. Go to `https://vCenter FQDN/mob`\.

   1. Choose **Content**\.

   1. Choose **SearchIndex**\.

   1. Choose **FindAllByIp**\.

      The **Method Invocation Result** page looks similar to the following\.  
![\[Method Invocation Result page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/vm-cert-method-invocation-result.png)

      Note the return value, which is the VM object reference\. On the preceding page, the VM Object reference value is `vm-41`\.

1. Get the VM Installer certificate using the VM object reference\.

   1. Go to this location: `http://vCenter-FQDN/mob/?moid=VM_object_reference&doPath=config.extraConfig["guestinfo.RDSInstaller.certificate"]`

      Replace *VM\_object\_reference* with the value that you retrieved in the previous step\. In the sample page, it was `vm-41`\.

      A page similar to the following opens\.  
![\[Data Object Type page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/vm-cert-data-object-type.png)

   1. Copy and paste this certificate to create a text file called `RDSinstCert.cer`\.

1. Use a tool to convert the captured certificate to the CRT binary format\. For example, you can use openssl, which is available on Windows, Mac, and Linux\.

   The following example shows the conversion with openssl\.

   ```
   openssl x509 -outform der -in RDSinstCert.cer -out RDSinstCert.crt                  
   ```

1. Import the certificate with your browser\.

   The following steps import the certificate with Chrome on Windows\. On Windows, this method also works with Edge and Firefox, but Firefox must be configured to use the Windows certificate store instead of the Mozilla store\. On Mac, you must use the Mac system keychain\.

   1. Go to **Manage Certificates** Chrome settings, and import the certificate on the **Trusted Root Certification Authorities** folder, as shown following\.  
![\[Certificates page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/vm-cert-certificates.png)

   1. On the **Security Warning** page, accept the installation of the certificate\.

      After the certificate is installed, it is listed in the **Trusted Root Certification Authorities** folder, as shown following\.  
![\[Certificates page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/vm-cert-certificate-listed.png)

1. Restart the browser and launch the Installer by following the instructions in step 8 in [Onboard Your vSphere Cluster](getting-started-with-rds-on-vmware.onboard.md)\.

   The security alert shouldn't appear\.