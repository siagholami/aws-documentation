# Content Key Encryption<a name="content-key-encryption"></a>

You can optionally add content key encryption to your SPEKE implementation\. Content key encryption guarantees full end\-to\-end protection by encrypting the content keys for transit, in addition to encrypting the content itself\. If you don't implement this for your key provider, you rely on the transport layer encryption plus strong authentication for security\. 

To use content key encryption for encryptors running in AWS Cloud, customers import certificates into the AWS Certificate Manager and then use the resulting certificate ARNs for their encryption activities\. The encryptor uses the certificate ARNs and the ACM service to provide encrypted content keys to the DRM key provider\. 

**Restrictions**  
SPEKE supports content key encryption as specified in the DASH\-IF CPIX specification with the following restrictions:
+ SPEKE doesn't support digital signature verification \(XMLDSIG\) for request or response payloads\. 
+ SPEKE requires 2048 RSA\-based certificates\.

These restrictions are also listed in [Customizations and Constraints to the DASH\-IF Specification](speke-constraints.md)\.

**Implement content key encryption**  
To provide content key encryption, include the following in your DRM key provider implementations: 
+ Handle the element `<cpix:DeliveryDataList>` in the request and response payloads\.
+ Provide encrypted values in the `<cpix:ContentKeyList>` of the response payloads\.

For more information about these elements, see the [DASH\-IF CPIX 2\.0 specification](https://dashif.org/docs/DASH-IF-CPIX-v2-0.pdf)\.

*Example Content Key Encryption Element `<cpix:DeliveryDataList>` in the Request Payload*

The following example highlights the added `<cpix:DeliveryDataList>` element in bold:

```
<?xml version="1.0" encoding="UTF-8"?>
<cpix:CPIX id="example-test-doc-encryption"
    xmlns:cpix="urn:dashif:org:cpix"
    xmlns:pskc="urn:ietf:params:xml:ns:keyprov:pskc"
    xmlns:speke="urn:aws:amazon:com:speke">
    <cpix:DeliveryDataList>
        <cpix:DeliveryData id="<ORIGIN SERVER ID>">
            <cpix:DeliveryKey>
                <ds:X509Data>
                    <ds:X509Certificate><X.509 CERTIFICATE, BASE-64 ENCODED></ds:X509Certificate>
                </ds:X509Data>
            </cpix:DeliveryKey>
        </cpix:DeliveryData>
    </cpix:DeliveryDataList>
    <cpix:ContentKeyList>
     ...
    </cpix:ContentKeyList>
</cpix:CPIX>
```

*Example Content Key Encryption Element `<cpix:DeliveryDataList>` in the Response Payload*

The following example highlights the added `<cpix:DeliveryDataList>` element in bold:

```
<cpix:CPIX xmlns:cpix="urn:dashif:org:cpix"
    xmlns:enc="http://www.w3.org/2001/04/xmlenc#"
    xmlns:pskc="urn:ietf:params:xml:ns:keyprov:pskc"
    xmlns:speke="urn:aws:amazon:com:speke" id="hls_test_001">
    <cpix:DeliveryDataList>
        <cpix:DeliveryData id="<ORIGIN SERVER ID>">
            <cpix:DeliveryKey>
                <ds:X509Data>
                    <ds:X509Certificate><X.509 CERTIFICATE, BASE-64 ENCODED></ds:X509Certificate>
                </ds:X509Data>
            </cpix:DeliveryKey>
            <cpix:DocumentKey Algorithm="http://www.w3.org/2001/04/xmlenc#aes256-cbc">
                <cpix:Data>
                    <pskc:Secret>
                        <pskc:EncryptedValue>
                            <enc:EncryptionMethod Algorithm="http://www.w3.org/2001/04/xmlenc#rsa-oaep-mgf1p" />
                            <enc:CipherData>
                                <enc:CipherValue><RSA CIPHER VALUE></enc:CipherValue>
                            </enc:CipherData>
                        </pskc:EncryptedValue>
                        <pskc:ValueMAC>qnei/5TsfUwDu+8bhsZrLjDRDngvmnUZD2eva7SfXWw=</pskc:ValueMAC>
                    </pskc:Secret>
                </cpix:Data>
            </cpix:DocumentKey>
            <cpix:MACMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#hmac-sha512">
                <cpix:Key>
                    <pskc:EncryptedValue>
                        <enc:EncryptionMethod Algorithm="http://www.w3.org/2001/04/xmlenc#rsa-oaep-mgf1p" />
                        <enc:CipherData>
                            <enc:CipherValue><RSA CIPHER VALUE></enc:CipherValue>
                        </enc:CipherData>
                    </pskc:EncryptedValue>
                    <pskc:ValueMAC>DGqdpHUfFKxdsO9+EWrPjtdTCVfjPLwwtzEcFC/j0xY=</pskc:ValueMAC>
                </cpix:Key>
            </cpix:MACMethod>
        </cpix:DeliveryData>
    </cpix:DeliveryDataList>
    <cpix:ContentKeyList>
     ...
    </cpix:ContentKeyList>
</cpix:CPIX>
```

*Example Content Key Encryption Element `<cpix:ContentKeyList>` in the Response Payload*

The following example shows encrypted content key handling in the `<cpix:ContentKeyList>` element of the response payload\. This uses the `<pskc:EncryptedValue>` element: 

```
   <cpix:ContentKeyList>
        <cpix:ContentKey kid="682681c8-69fa-4434-9f9f-1a7f5389ec02">
            <cpix:Data>
                <pskc:Secret>
                    <pskc:EncryptedValue>
                        <enc:EncryptionMethod Algorithm="http://www.w3.org/2001/04/xmlenc#aes256-cbc" />
                        <enc:CipherData>
                            <enc:CipherValue>NJYebfvJ2TdMm3k6v+rLNVYb0NoTJoTLBBdbpe8nmilEfp82SKa7MkqTn2lmQBPB</enc:CipherValue>
                        </enc:CipherData>
                    </pskc:EncryptedValue>
                    <pskc:ValueMAC>t9lW4WCebfS1GP+dh0IicMs+2+jnrAmfDa4WU6VGHc4=</pskc:ValueMAC>
                </pskc:Secret>
            </cpix:Data>
        </cpix:ContentKey>
    </cpix:ContentKeyList>
```

By comparison, the following example shows a similar response payload with the content key delivered unencrypted, as a clear key\. This uses the `<pskc:PlainValue>` element: 

```
    <cpix:ContentKeyList>
        <cpix:ContentKey explicitIV="OFj2IjCsPJFfMAxmQxLGPw==" kid="682681c8-69fa-4434-9f9f-1a7f5389ec02">
            <cpix:Data>
                <pskc:Secret>
                    <pskc:PlainValue>5dGAgwGuUYu4dHeHtNlxJw==</pskc:PlainValue>
                </pskc:Secret>
            </cpix:Data>
        </cpix:ContentKey>
    </cpix:ContentKeyList>
```