# PKI concepts<a name="pki-concepts"></a>

As you work with AWS PKI tools and services, you are likely to encounter a number of basic concepts\.

**Topics**
+  [asymmetric\-key cryptography](#concept-asymmetric) 
+  [certificate authority \(CA\) ](#concept-ca) 
+  [certificate authority certificate](#concept-ca-cert) 
+  [certificate signature](#concept-signing) 
+  [domain name](#concept-dn) 
+  [Domain Name System \(DNS\)](#concept-dns) 
+  [HTTPS](#concept-https) 
+  [private certificate](#concept-priv-cert) 
+  [public certificate](#concept-pub-cert) 
+  [public\-key encryption](#concept-asymmetric) 
+  [public\-key infrastructure \(PKI\)](#concept-pki) 
+  [root certificate](#concept-root) 
+  [Secure Sockets Layer \(SSL\) and Transport Layer Security \(TLS\) ](#concept-ssl) 
+  [SSL server certificates](#concept-sslcert) 
+  [symmetric\-key cryptography](#concept-symmetric) 
+  [TCP](#concept-tcp) 
+  [trust](#concept-trust)

**asymmetric\-key cryptography **  <a name="concept-asymmetric"></a>
Also called *public\-key cryptography*\. The use of different but mathematically related keys to encrypt and to decrypt content\. One of the keys is public and is typically made available in an X\.509 version 3 certificate\. The other key is private and is stored securely\. The X\.509 certificate binds the identity of a user, computer, or other resource \(the certificate subject\) to the public key\. See also: [symmetric\-key cryptography](#concept-symmetric)\.

**certificate authority \(CA\) **  <a name="concept-ca"></a>
A trusted third party that issues \(and, if necessary, revokes\) digital certificates\. The most common type of certificate is based on the ISO X\.509 standard\. An X\.509 certificate affirms the identity of the certificate subject and binds that identity to a public key\. The subject can be a user, an application, a computer, or other device\. The CA [signs a certificate](#concept-signing) by hashing its contents and then encrypting the hash with the private key corresponding to the public key in the certificate\. A client application such as a web browser that needs to affirm the identity of a subject uses the public key to decrypt the certificate signature\. It then hashes the certificate contents and compares the hashed value to the decrypted signature to determine whether they match\.  
For information about certificate signing, see [certificate signature](#concept-signing)\.  
A CA can be either public or private:  
+ Public CA—A commercial, non\-profit, or government entity that issues certificates that are universally valid\.
+ Private CA—An entity within an organization that issues certificate that are valid only inside the organization\.

**certificate authority certificate **  <a name="concept-ca-cert"></a>
A certificate that affirms the identity of the [certificate authority \(CA\)](#concept-ca) and binds it to the public key that is contained in the certificate\.

**certificate signature **  <a name="concept-signing"></a>
An encrypted hash over a certificate that affirms the integrity of the certificate data\. The encrypted hash is known as a digital signature\. Your private CA creates a signature by using a hash function \(such as SHA256\) over the variable\-sized certificate content to produce an irreversible fixed\-size data string\. The fixed data is called a hash\. The CA then encrypts the hash value with its private key and concatenates the encrypted hash with the certificate\.  
To validate a signed certificate, a client application uses the CA public key to decrypt the signature\. The client then uses the same signing algorithm that the CA used to compute a hash over the rest of the certificate\. Note that the signing algorithm used by the CA is listed in the certificate\. If the computed hash value is the same as the decrypted hash value, the certificate has not been tampered with\.

**domain name **  <a name="concept-dn"></a>
A text string such as `www.example.com` that can be translated by the Domain Name System \(DNS\) into an IP address\. Computer networks, including the internet, use IP addresses rather than text names\. A domain name consists of distinct labels separated by periods:  
**TLD**  
The rightmost label of a domain name, or top\-level domain\. Common examples include `.com`, `.net`, and `.edu`\. Also, the TLD for entities that are registered in some countries is an abbreviation of the country name and is called a country code\. Examples include `.uk` for the United Kingdom, `.ru` for Russia, and `.fr` for France\. When country codes are used, a second\-level hierarchy for the TLD is often introduced to identify the type of the registered entity\. For example, the `.co.uk` TLD identifies commercial enterprises in the United Kingdom\. 
**apex domain**  
The portion of a domain name that includes and expands on the top\-level domain\. For domain names that include a country code, the apex domain includes the code and the labels, if any, that identify the type of the registered entity\. The apex domain does not include subdomains \(see the following paragraph\)\. In `www.example.com`, the name of the apex domain is `example.com`\. In `www.example.co.uk`, the name of the apex domain is `example.co.uk`\. Other names that are often used instead of apex include *base*, *bare*, *root*, *root apex*, or *zone apex*\. 
**subdomain**  
The portion of a domain name \(if present\) that precedes the apex domain name and is separated from it and from other subdomains by a period\. The most common subdomain name is `www`, but any name is possible\. Also, subdomain names can have multiple levels\. For example, in `jake.dog.animals.example.com`, the subdomains are `jake`, `dog`, and `animals` in that order\. 
**FQDN**  
Fully qualified domain name\. The FQDN is the complete DNS name for a computer, website, or other resource that is connected to a network or to the internet\. For example `aws.amazon.com` is the FQDN for Amazon Web Services\. An FQDN includes all domains up to the top\-level domain\. For example, `[subdomain1].[subdomain2]...[subdomainn].[apex domain].[top-level domain]` represents the general format of an FQDN\.
**PQDN**  
Partially qualified domain name\. A PQDN is not fully qualified and is ambiguous\. A name such as `[subdomain1.subdomain2.]` is a PQDN because the root domain cannot be determined\.
**registration**  
The right to use a domain name that is delegated by domain name registrars\. Registrars are typically accredited by the Internet Corporation for Assigned Names and Numbers \(ICANN\)\. In addition, other organizations called registries maintain the TLD databases\. When you request a domain name, the registrar sends your information to the appropriate TLD registry\. The registry assigns a domain name, updates the TLD database, and publishes your information to WHOIS\. Typically, domain names must be purchased\.

** Domain Name System **  <a name="concept-dns"></a>
A hierarchical distributed naming system for computers and other resources connected to the internet or a private network\. DNS is primarily used to translate textual domain names, such as `aws.amazon.com`, into numerical IP \(internet protocol\) addresses of the form `111.222.333.444`\. The DNS database for your domain, however, contains a number of records that can be used for other purposes\. For example, with [AWS Certificate Manager](awspki-service-acm.md) you can use a CNAME record to validate that you own or control a domain when you request a certificate\.

** HTTPS **  <a name="concept-https"></a>
The abbreviation for *HTTP over [SSL/TLS](#concept-ssl)*, a secure form of Hypertext Transfer Protocol \(HTTP\) that is supported by all major browsers and servers\. All HTTP requests and responses are encrypted before being sent across a network, thereby providing transport security\. HTTPS combines the HTTP protocol with [symmetric](#concept-symmetric), [asymmetric](#concept-asymmetric), and X\.509 certificate\-based cryptographic techniques\. HTTPS works by inserting a cryptographic security layer below the HTTP application layer and above the [TCP](#concept-tcp) transport layer in the Open Systems Interconnection \(OSI\) model\. The security layer uses the Secure Sockets Layer \(SSL\) protocol or the Transport Layer Security \(TLS\) protocol\. 

** private certificate **  <a name="concept-priv-cert"></a>
An [SSL/TLS](#concept-ssl) certificate that authenticates the identity of a resource in a private PKI\. [Trust](#concept-trust) in a private certificate rests on the integrity of the private certificate authority \(CA\) that issued it\.  
Not to be confused with the private \(secret\) key of a public\-key encryption key pair\.  
See also [public certificate](#concept-pub-cert)\.

** public certificate **  <a name="concept-pub-cert"></a>
An [SSL/TLS](#concept-ssl) certificate that authenticates the identity of a resource in a public PKI\. [Trust](#concept-trust) in a public certificate rests on the integrity of the public certificate authority \(CA\) that issued it\.  
Not to be confused with the public key of a public\-key encryption key pair\.  
See also [private certificate](#concept-priv-cert)\.

** public\-key encryption \(PKI\) **  <a name="concept-pubkeycrypt"></a>
See [asymmetric\-key encryption](#concept-asymmetric)\.

** public\-key infrastructure \(PKI\) **  <a name="concept-pki"></a>
A comprehensive system that enables the creation, issuance, management, distribution, use, storage, and revocation of digital certificates\. A PKI consists of people, hardware, software, policies, documents, and procedures\. A public PKI is is used to secure communication in the world at large \(for example, over the internet\) and derives its authority from one or more public certificate authorities \(CAs\)\. A private PKI is used to secure communications within an organization, derives its authority from one or more private CAs, and has no validity outside the organization\.  
The "public key" of public key infrastructure refers to [public\-key encryption](#concept-asymmetric)\.

** root certificate **  <a name="concept-root"></a>
The certificate issued by the [certificate authority \(CA\)](#concept-ca) that is at the top of the CA hierarchy\. A certificate authority typically exists within a hierarchical structure that contains multiple other CAs with clearly defined parent\-child relationships between them\. Child or subordinate CAs are certified by their parent CAs, creating a certificate chain\. The CA at the top of the hierarchy is referred to as the root CA, and its certificate is called the root certificate\. This certificate is typically self\-signed\. 

**Secure Sockets Layer \(SSL\) and Transport Layer Security \(TLS\)**  <a name="concept-ssl"></a>
Cryptographic protocols that provide communication security over a computer network\. TLS is the successor of SSL\. They both use X\.509 certificates to authenticate the server\. Both protocols negotiate a symmetric key between the client and the server that is used to encrypt data flowing between the two entities\. 

**SSL/TLS server certificate**  <a name="concept-sslcert"></a>
An X\.509 version 3 data structure that binds the public key in the certificate to the subject of the certificate and is signed by a [certificate authority \(CA\)](#concept-ca)\. An SSL/TLS certificate contains the name of the server, the validity period, the public key, the signature algorithm, and more\. Server certificates are required for HTTPS transactions to authenticate a server\.

**symmetric\-key cryptography **  <a name="concept-symmetric"></a>
The practice of using the same key to encrypt and to decrypt data\. See also: [asymmetric\-key cryptography](#concept-asymmetric)\.

**Transmission Control Protocol \(TCP\)**  <a name="concept-tcp"></a>
As part of the TCP/IP stack, TCP is one of the main sets of rules used when sending data between networks\. By verifying the order in which information is received, TCP assures the quality of transmissions across hosts and servers\. TCP standards are regulated by the [Internet Engineering Task Force \(IETF\)](https://www.ietf.org/)\. 

**trust **  <a name="concept-trust"></a>
The reliability of a website's identity as established by verifying the website's certificate\. Browsers trust only a small number of certificates known as CA [root certificates](#concept-root)\. A trusted third party, known as a [certificate authority \(CA\)](#concept-ca), validates the identity of the website and issues a signed digital certificate to the website's operator\. The browser can then check the digital signature to validate the identity of the website\. If validation is successful, the browser displays a lock icon in the address bar\.