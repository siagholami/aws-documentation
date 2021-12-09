# I Can't Connect Although My Data Source Connection Options Look Right \(SSL\)<a name="troubleshoot-connect-SSL"></a>

Problems connecting can occur when Secure Sockets Layer \(SSL\) is incorrectly configured\. The symptoms can include the following:
+ You can connect to your database in other ways or from other locations but not in this case\.
+ You can connect to a similar database but not this one\.

 Rule out the following circumstances: 
+ Permissions issues
+ Availability issues
+ An expired or invalid certificate
+ A self\-signed certificate
+ Certificate chain in the wrong order
+ Ports not enabled
+ Firewall blocking an IP address
+ A VPC or security group not configured correctly\.

To help find issues with SSL, you can use an online SSL checker, or a tool like OpenSSL\. 

 The following steps walk through troubleshooting a connection where SSL is suspect\. The administrator in this example has already installed OpenSSL\.

**Example**  

1. The user finds an issue connecting to the database\. The user verifies that he can connect a different database in another AWS Region\. He checks other versions of the same database and he can connect easily\. 

1. The administrator reviews the issue and decides to verify that the certificates are working correctly\. She searches online for an article on using OpenSSL to troubleshoot or debug SSL connections\.

1. Using OpenSSL, the administrator verifies the SSL configuration in the terminal\.

   ```
   echo quit
   openssl s_client –connect <host>:port
   ```

   The result shows that the certificate is not working:

   ```
   ...
   ...
   ...
   CONNECTED(00000003)
   012345678901234:error:140770FC:SSL routines:SSL23_GET_SERVER_HELLO:unknown protocol:s23_clnt.c:782:
   ---
   no peer certificate available
   ---
   No client certificate CA names sent
   ---
   SSL handshake has read 7 bytes and written 278 bytes
   ---
   New, (NONE), Cipher is (NONE)
   Secure Renegotiation IS NOT supported
   SSL-Session:
       Protocol  : TLSv1.2
       Cipher    : 0000
       Session-ID:
       Session-ID-ctx:
       Master-Key:
       Key-Arg   : None
       PSK identity: None
       PSK identity hint: None
       Start Time: 1497569068
       Timeout   : 300 (sec)
       Verify return code: 0 (ok)
   ---
   ```

1. The administrator corrects the problem by installing the SSL certificate on the user's database server\. 

For more detail on the solution in this example, see [Using SSL to Encrypt a Connection to a DB Instance](https://docs.aws.amazon.com//AmazonRDS/latest/UserGuide/UsingWithRDS.SSL.html) in the* Amazon RDS User Guide\.*