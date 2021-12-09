# Connecting to a NICE DCV Session Using the Web Browser<a name="using-connecting-browser-connect"></a>

The steps for connecting to a NICE DCV session are the same across all supported web browsers\. The client connects to the NICE DCV server using your web browser's proxy settings\. To connect using different proxy settings, see your web browser's documentation\.

**To connect to your NICE DCV session using the web browser client**

1. Open your preferred web browser and enter the NICE DCV server URL in the following format:

   ```
   https://server_hostname_or_IP:port/#session_id
   ```

   For example, the following URL connects to a session named `my-session`, which is hosted on a NICE DCV server with the hostname `my-dcv-server.com`, over port `8443`:

   ```
   https://my-dcv-server.com:8443/#my-session
   ```

1. Enter your user name and password and choose **Login**\.
**Note**  
By default, the connection is terminated after three unsuccessful login attempts\. To try again, restart the connection\.

1. Your web browser might warn you that the server's certificate is not trusted\. If you're unsure about the authenticity of the certificate, confirm it with your NICE DCV administrator\. Proceed if it is safe to do so\.
**Note**  
This step varies depending on the web browser that you are using\.