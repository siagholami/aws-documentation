# Ubuntu troubleshooting<a name="ubuntu-troubleshooting"></a>

 The following are problems you might have when using Ubuntu\-based clients to connect to a Client VPN endpoint, including the following:
+ OpenVPN through Network Manager \(GUI\)
+ OpenVPN \(command line\)

Ensure that you are running the latest version of these clients\. 

The connection logs are stored in the following location on your computer:

```
/var/log/syslog
```

You can enable advanced debugging using the OpenVPN command line client\. Open the Client VPN configuration file \(the \.ovpn file\) and replace verb 3 with verb 5 or higher, and specify the log location, as shown in the following example\. 

```
log /var/log/vpn-log.log
```

Run the OpenVPN client using the `--log` option, as shown in the following example\.

```
sudo openvpn --log vpn-log.log --config test1.ovpn 
```

## DNS server configuration<a name="ubuntu-troubleshooting-dns-server"></a>

**Problem**  
The connection does not function correctly because DNS resolution is not working\.

**Cause**  
The DNS server is not configured on the Client VPN endpoint, or it is not being honored by the client software\.

**Solution**  
Use the following steps to check that the DNS server is configured and working correctly\.

1. Ensure that a DNS server entry is present in the logs\. In the following example, the DNS server `192.168.0.2` \(configured in the Client VPN endpoint\) is returned in the last line\.

   ```
   Mon Apr 15 21:26:55 2019 us=274574 SENT CONTROL [server]: 'PUSH_REQUEST' (status=1)
   WRRMon Apr 15 21:26:55 2019 us=276082 PUSH: Received control message: 'PUSH_REPLY,redirect-gateway def1 bypass-dhcp,dhcp-option DNS 192.168.0.2,route-gateway 10.0.0.97,topology subnet,ping 1,ping-restart 20,auth-token,ifconfig 10.0.0.98 255.255.255.224,peer-id 0
   ```

   If there is no DNS server specified, ask your Client VPN administrator to modify the Client VPN endpoint and ensure that a DNS server \(for example, the VPC DNS server\) has been specified for the Client VPN endpoint\. For more information, see [Client VPN Endpoints](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/cvpn-working-endpoints.html) in the *AWS Client VPN Administrator Guide*\.

1. Ensure that the `resolvconf` package is installed by running the following command\.

   ```
   sudo apt list resolvconf
   ```

   The output should return the following\.

   ```
   Listing... Done
   resolvconf/bionic-updates,now 1.79ubuntu10.18.04.3 all [installed]
   ```

   If it's not installed, install it using the following command\.

   ```
   sudo apt install resolvconf
   ```

1. Open the Client VPN configuration file \(the \.ovpn file\) in a text editor and add the following lines\.

   ```
   script-security 2
   up /etc/openvpn/update-resolv-conf
   down /etc/openvpn/update-resolv-conf
   ```

   Check the logs to verify that the `resolvconf` script has been invoked\. The logs should contain a line similar to the following\.

   ```
   Mon Apr 15 21:33:52 2019 us=795388 /etc/openvpn/update-resolv-conf tun0 1500 1552 10.0.0.98 255.255.255.224 init
   dhcp-option DNS 192.168.0.2
   ```

## Cannot resolve DNS<a name="ubuntu-troubleshooting-dns-resolution"></a>

**Problem**  
When using the Network Manager OpenVPN client, the connection fails with the following error\.

```
Apr 15 17:11:07  OpenVPN 2.4.4 x86_64-pc-linux-gnu [SSL (OpenSSL)] [LZO] [LZ4] [EPOLL] [PKCS11] [MH/PKTINFO] [AEAD] built on Sep  5 2018
Apr 15 17:11:07  library versions: OpenSSL 1.1.0g  2 Nov 2017, LZO 2.08
Apr 15 17:11:07  RESOLVE: Cannot resolve host address: cvpn-endpoint-1234.prod.clientvpn.us-east-1.amazonaws.com:443 (Name or service not known)
Apr 15 17:11:07  RESOLVE: Cannot resolve host
Apr 15 17:11:07  Could not determine IPv4/IPv6 protocol
```

**Cause**  
The `remote-random-hostname` flag is not honored, and the client cannot connect using the `network-manager-gnome` package\.

**Solution**  
See the solution for [Unable to Resolve Client VPN Endpoint DNS Name](https://docs.aws.amazon.com/vpn/latest/clientvpn-admin/troubleshooting.html#resolve-host-name) in the *AWS Client VPN Administrator Guide*\.