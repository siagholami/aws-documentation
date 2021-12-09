# Cryptographic algorithms<a name="concepts-algorithms"></a>

An *encryption algorithm* is a formula or procedure that converts a plaintext message into an encrypted ciphertext\. Modern algorithms use advanced mathematics and one or more encryption keys to make it relatively easy to encrypt a message but virtually impossible to decrypt it without knowing the keys\. Algorithms generally require a source of randomness\. They may also involve multiple layers of encryption, repeated permutation, and insertion of sequential one\-time values to prevent attacks\. 

AWS cryptography services rely on secure, open\-source encryption algorithms that are vetted by public standards bodies and academic research\. Some AWS tools and services enforce the use of a specific algorithm, while others offer multiple algorithms and key sizes but recommend a default choice\.

This section describes some of the algorithms that AWS tools and services support\. They fall into two categories, symmetric and asymmetric, based on how their keys function\.

**Topics**
+ [Symmetric algorithms](#concepts-algos)
+ [Asymmetric algorithms](#concepts-asymm)

## Symmetric algorithms<a name="concepts-algos"></a>

### <a name="concepts-symm"></a>

AWS cryptographic tools and services support two widely used symmetric algorithms\.
+ **AES** – [Advanced Encryption Standard](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard) \(AES\) with 128\-, 192\-, or 256\-bit keys\. AES is often combined with [Galois/Counter Mode](https://en.wikipedia.org/wiki/Galois/Counter_Mode) \(GCM\) and known as AES\-GCM\.
+ **Triple DES** – Triple DES \(3DES\) uses three 56\-bit keys\. The scheme works on a block of data by splitting it in two and iteratively applying arbitrary round functions derived from an initial function\. Triple DES uses 48 rounds to encrypt a block of data\. 

For instance, AWS Key Management Service uses the Advanced Encryption Standard \(AES\) algorithm in Galois/Counter Mode \(GCM\) with 256\-bit secret keys\. 

An encryption scheme is called *symmetric* if it uses the same key to both encrypt and decrypt a message\. Technically, the encryption key *e* and decryption key *d* don't have to be exactly the same\. All that's required is that it's computationally trivial to determine *d* when you know *e* and *e* when you know *d*\. However, in most practical symmetric encryption schemes, *e* and *d* are the same\. 

**Note**  
Symmetric encryption is also called *shared key*, *shared secret*, and *secret key* encryption\. It is not called *private key* encryption\. Convention reserves the term *private key* for asymmetric cryptography, which centers around the idea of a private key and a corresponding \(but different\) public key\. 

Symmetric key encryption requires that all intended message recipients have access to the shared key\. Therefore, a secure communication channel must be established among the participants so that the key can be transmitted to each along with the ciphertext\. This presents practical problems and limits the use of direct symmetric key exchange\. 

The following illustrations show how encryption and decryption work with symmetric keys and algorithms\. In the first illustration, a symmetric key and algorithm are used to convert a plaintext message into ciphertext\.

![\[Symmetric key encryption diagram\]](http://docs.aws.amazon.com/crypto/latest/userguide/images/Symmetric_Key_Encryption_sm.png)

The following illustration shows the same secret key and symmetric algorithm being used to turn ciphertext back into plaintext\.

![\[Symmetric key decryption diagram\]](http://docs.aws.amazon.com/crypto/latest/userguide/images/Symmetric_Key_Decryption_sm.png)

Symmetric key ciphers may be either block ciphers or stream ciphers\. A **block** cipher divides the plaintext messaged into fixed\-length strings called blocks and encrypts one block at a time\. Block ciphers are typically considered to be more powerful and practical primitives than stream ciphers, but they're also slower\. **Stream**ciphers encrypt each unit of plaintext \(such as a byte\), one unit at a time, with a corresponding unit from a random key stream\. The result is a single unit of ciphertext\.

Both AES and 3DES are block ciphers\.

## Asymmetric algorithms<a name="concepts-asymm"></a>

AWS services typically support **RSA** and **Elliptic Curve Cryptography \(ECC\)** asymmetric algorithms\. These algorithms are useful for authentication and for establishing secure communication channels when it is inconvenient to share a symmetric key in advance\. For example, Amazon CloudFront supports a [long list](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/secure-connections-supported-viewer-protocols-ciphers.html) of assymmetric ciphers used by the SSL/TLS protocols to enable encrypted connections over the web\.

An encryption scheme is called *asymmetric* if it uses one key — the public key — to encrypt and a different, but mathematically related, key — the private key — to decrypt\. It must be computationally infeasible to determine the private key if the only thing one knows is the public key\. Therefore, the public key can be distributed publicly while the private key is kept secret and secure\. Together the keys are referred to as a *key pair*\.

Another more common name for asymmetric encryption is *public\-key* cryptography\. Public\-key cryptography is typically based on mathematical problems that are relatively easy to perform but cannot be easily reversed\. These include factoring a large integer back into its component prime numbers and solving the elliptic curve discrete logarithm function\. The RSA algorithm is based on the practical difficulty of factoring the product of two large prime numbers\. Elliptic\-curve cryptography is based on the difficulty of finding the discrete logarithm of a random point on an elliptic curve given a publicly known point\. 