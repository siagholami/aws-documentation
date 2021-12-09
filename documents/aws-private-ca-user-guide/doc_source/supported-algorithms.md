# Supported Cryptographic Algorithms<a name="supported-algorithms"></a>

ACM Private CA supports the following cryptographic algorithms for private key generation and certificate signing\. This list applies only to certificates issued directly by ACM Private CA through its console, API, or command line\. 


**Supported algorithm**  

| Private key algorithms | Signing algorithms | 
| --- | --- | 
|  RSA\_2048  RSA\_4096 EC\_prime256v1 EC\_secp384r1  | SHA256WITHECDSASHA384WITHECDSASHA512WITHECDSASHA256WITHRSASHA384WITHRSASHA512WITHRSA | 

**Note**  
When AWS Certificate Manager issues certificates using a CA from ACM Private CA, it supports some but not all of these algorithms\. For more information, see [Request a Private Certificate](https://docs.aws.amazon.com/acm/latest/userguide/gs-acm-request-private.html) in the AWS Certificate Manager User Guide\.