# Getting Started with NICE DCV<a name="getting-started"></a>

NICE DCV is a high\-performance remote display protocol\. It lets you securely deliver remote desktops and application streaming from any cloud or data center to any device, over varying network conditions\. By using NICE DCV with Amazon EC2, you can run graphics\-intensive applications remotely on Amazon EC2 instances\. You can then stream the results to more modest client machines, which eliminates the need for expensive dedicated workstations\.

To use NICE DCV, install the NICE DCV server software on a server\. The NICE DCV server software is used to create a secure [session](https://docs.aws.amazon.com/dcv/latest/adminguide/managing-sessions.html)\. You install and run your applications on the server\. The server uses its hardware to perform the high\-performance processing that the installed applications require\. Your users access the application by remotely connecting to the session using a NICE DCV client application\. When the connection is established, the NICE DCV server software compresses the visual output of the application and streams it back to the client application in an encrypted pixel stream\. The client application receives the compressed pixel stream, decrypts it, and then outputs it to the local display\.

**Contents**
+ [Step 1: Get the Session Information](#getting-started-session)
+ [Step 2: Choose a Client](#getting-started-choose)

## Step 1: Get the NICE DCV Session Information<a name="getting-started-session"></a>

After the NICE DCV session is running on the NICE DCV server, you must have specific information to be able to connect to it\. Contact your NICE DCV administrator if you do not have the following information:
+ The NICE DCV server's IP address or host name
+ The port over which the NICE DCV server is configured to communicate\. Port 8443 is the default port used by the NICE DCV server\.
+ The session ID
+ A user name and password to connect to the NICE DCV host server

## Step 2: Choose a NICE DCV Client<a name="getting-started-choose"></a>

Next, choose the NICE DCV client that best meets your needs\. NICE DCV offers the following clients: 
+ A native Windows client
+ A web browser client
+ A Linux client
+ A macOS client

For more information about the available clients, see [NICE DCV Clients](client.md)\.

After you have chosen your preferred NICE DCV client, you can use it to connect to, and interact with the NICE DCV session\. For more information about using the NICE DCV clients to interact with sessions, see [Using NICE DCV](using.md)\.