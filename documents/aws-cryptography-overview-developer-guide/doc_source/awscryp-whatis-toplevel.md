# What is cryptography?<a name="awscryp-whatis-toplevel"></a>

Cryptography is the practice of protecting information through the use of coded algorithms, hashes, and signatures\. The information can be at rest such as a file on a hard drive\. The information can also be in transit such as electronic communication exchanged between two or more parties\. Cryptography has four primary goals:
+ **Confidentiality** – Makes information available to only authorized users\.
+ **Data Integrity** – Ensures that information has not been manipulated\.
+ **Authentication** – Confirms the authenticity of information or the identity of a user\.
+ **Nonrepudiation** – Prevents a user from denying prior commitments or actions\.

Cryptography uses a number of tools, typically called *primitives*, to provide information security\. A *primitive* is a cryptographic algorithm\. This includes encryption algorithms, digital signature algorithms, hashes, and other functions\. AWS uses only well established, peer\-reviewed primitives\.

**Note**  
Cryptography relies extensively on mathematics\. This includes basic function theory, permutations, probability, information theory, complexity theory, number theory, and more\. The math underlying cryptography is beyond the scope of this documentation, but printed and online sources are readily available\. 

To learn more about the terms and concepts used in cryptography, see [Cryptography concepts](cryptography-concepts.md)\.