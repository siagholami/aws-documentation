# Designing a CA Hierarchy<a name="ca-hierarchy"></a>

With ACM Private CA, you can create a hierarchy of certificate authorities with up to five levels\. The root CA, at the top of a hierarchy tree, can have any number of branches\. The root CA can have as many as four levels of subordinate CAs on each branch\. You can also create multiple hierarchies, each with its own root\. 

A well\-designed CA hierarchy offers the following benefits:
+ Granular security controls appropriate to each CA
+ Division of administrative tasks for better load balancing and security
+ Use of CAs with limited, revocable trust for daily operations
+ Validity periods and certificate path limits

The following diagram illustrates a simple, three\-level CA hierarchy\. 

![\[Diagram of a simple, three-level CA hierarchy.\]](http://docs.aws.amazon.com/acm-pca/latest/userguide/images/simple-ca-tree.png)

Each CA in the tree is backed by an X\.509 v3 certificate with signing authority \(symbolized by the pen\-and\-paper icon\)\. This means that as CAs, they can sign other certificates subordinate to them\. When a CA signs a lower\-level CA's certificate, it confers limited, revocable authority on the signed certificate\. The root CA in level 1 signs high\-level subordinate CA certificates in level 2\. These CAs, in turn, sign certificates for CAs in level 3 that are used by PKI \(public key infrastructure\) administrators who manage end\-entity certificates\. 

Security in a CA hierarchy should be configured to be strongest at the top of the tree\. This arrangement protects the root CA certificate and its private key\. The root CA anchors trust for all of the subordinate CAs and the end\-entity certificates below it\. While localized damage can result from the compromise of an end\-entity certificate, compromise of the root destroys trust in the entire PKI\. Root\- and higher\-level subordinate CAs are used only infrequently \(usually to sign other CA certificates\)\. Consequently, they are tightly controlled and audited to ensure a lower risk of compromise\. At the lower levels of the hierarchy, security is less restrictive\. This approach allows the routine administrative tasks of issuing and revoking end\-entity certificates for users, computer hosts, and software services\.

**Note**  
Using a root CA to sign a subordinate certificate is a rare event that occurs in only a handful of circumstances:  
When the PKI is created
When a high\-level certificate authority needs to be replaced
When a certificate revocation list \(CRL\) or Online Certificate Status Protocol \(OCSP\) responder needs to be configured
Root and other high\-level CAs require highly secure operational processes and access\-control protocols\.

**Topics**
+ [Validating End\-Entity Certificates](#end-entity-validation)
+ [Planning the Structure of a CA Hierarchy](#ca-layers)
+ [Setting Length Constraints on the Certification Path](#length-constraints)

## Validating End\-Entity Certificates<a name="end-entity-validation"></a>

End\-entity certificates derive their trust from a certification path leading back through the subordinate CAs to a root CA\. When a web browser or other client is presented with an end\-entity certificate, it attempts to construct a chain of trust\. For example, it may check to see that the certificate's *issuer distinguished name* and *subject distinguished name* match with the corresponding fields of the issuing CA certificate\. Matching would continue at each successive level up the hierarchy until the client reaches a trusted root that is contained in its trust store\. 

The trust store is a library of trusted CAs that the browser or operating system contains\. For a private PKI, your organization's IT must ensure that each browser or system has previously added the private root CA to its trust store\. Otherwise, the certification path cannot be validated, resulting in client errors\. 

The next diagram shows the validation path that a browser follows when presented with an end\-entity X\.509 certificate\. Note that the end\-entity certificate lacks signing authority and serves only to authenticate the entity that owns it\.

![\[Validation check by a web browser.\]](http://docs.aws.amazon.com/acm-pca/latest/userguide/images/chain-of-trust.png)

The browser inspects the end\-entity certificate\. The browser finds that the certificate offers a signature from subordinate CA \(level 3\) as its trust credential\. The certificates for the subordinate CAs must be included in the same PEM file\. Alternatively, they can also be in a separate file that contains the certificates that make up the trust chain\. Upon finding these, the browser checks the certificate of subordinate CA \(level 3\) and finds that it offers a signature from subordinate CA \(level 2\)\. In turn, subordinate CA \(level 2\) offers a signature from root CA \(level 1\) as its trust credential\. If the browser finds a copy of the private root CA certificate preinstalled in its trust store, it validates the end\-entity certificate as trusted\. 

Typically, the browser also checks each certificate against a certificate revocation list \(CRL\)\. An expired, revoked, or misconfigured certificate is rejected and validation fails\.

## Planning the Structure of a CA Hierarchy<a name="ca-layers"></a>

In general, your CA hierarchy should reflect the structure of your organization\. Aim for a *depth* \(that is, number of CA levels\) no greater than necessary to delegate administrative and security roles\. Adding a CA to the hierarchy means increasing the number of certificates in the certification path, which increases validation time\. Keeping the depth to a minimum also reduces the number of certificates sent from the server to the client when establishing trust\. A smaller depth also decreases the amount of work that a client performs to validate an end\-entity certificate\.

In theory, a root CA, which has no [path\-length parameter](#length-constraints), can authorize any depth of subordinate CAs\. A subordinate CA can have as many child subordinate CAs as are allowed by its internal configuration\. ACM Private CA managed hierarchies support CA certification paths up to five levels deep\.

Well designed CA structures have several benefits: 
+ Separate administrative controls for different organizational units
+ The ability to delegate access to subordinate CAs
+ A hierarchical structure that protects higher\-level CAs with additional security controls 

Two common CA structures accomplish all of this:
+ **Two CA levels: root CA and subordinate CA**

  This is the simplest CA structure that allows separate administration, control, and security policies for the root CA and a subordinate CA\. You can maintain restrictive controls and policies for your root CA while allowing more permissive access for the subordinate CA\. The latter is used for bulk issuance of end\-entity certificates\.
+ **Three CA levels: root CA and two layers of subordinate CA**

  Similar to the above, this structure adds an additional CA layer to further separate the root CA from low\-level CA operations\. The middle CA layer is only used to sign subordinate CAs that carry out the issuance of end\-entity certificates\. 

Less common CA structures include the following:
+ **Four or more CA levels**

  Though less common than three\-level hierarchies, CA hierarchies with four or more levels are possible and may be required to allow administrative delegation\.
+ **One CA level: root CA only**

  This structure is commonly used for development and testing when a full chain of trust is not required\. Used in production, it is atypical\. Moreover, it violates the best practice of maintaining separate security policies for the root CA and the CAs that issue end\-entity certificates\. 

  However, if you are already issuing certificates directly from a root CA, you can migrate to ACM Private CA\. Doing so provides security and control advantages over using a root CA managed with OpenSSL or other software\.

### Example of a Private PKI for a Manufacturer<a name="sample-hierarchy"></a>

In this example, a hypothetical technology company manufactures two Internet of Things \(IoT\) products, a smart light bulb and a smart toaster\. During production, each device is issued an end\-entity certificate so it can communicate securely over the internet with the manufacturer\. The company's PKI also secures its computer infrastructure, including the internal website and various self\-hosted computer services that run finance and business operations\. 

Consequently, the CA hierarchy closely models these administrative and operational aspects of the business\.

![\[Diagram of a more complex CA hierarchy.\]](http://docs.aws.amazon.com/acm-pca/latest/userguide/images/multilevel-ca-tree.png)

This hierarchy contains three roots, one for Internal Operations and two for External Operations \(one root CA for each product line\)\. It also illustrates multiple certification depths, with two levels of CA for Internal Operations and three levels for External Operations\. 

The use of separated root CAs and additional depth on the External Operations side is a design decision serving business and security needs\. With multiple CA trees, the PKI is future\-proofed against corporate reorganizations, divestitures, or acquisitions\. When changes occur, an entire root CA hierarchy can move cleanly with the division it secures\. And with two levels of subordinate CA, the roots CAs have a high level of isolation from the level 3 CAs that are responsible for bulk\-signing the certificates for thousands or millions of manufactured items\. 

On the internal side, corporate web and internal computer operations complete a two\-level hierarchy\. These levels allow web administrators and operations engineers to manage certificate issuance independently for their own work domains\. The compartmentalization of PKI into distinct functional domains is a security best practice and protects each from a compromise that might affect the other\. Web administrators issue end\-entity certificates for use by web browsers throughout the company, authenticating and encrypting communications on the internal website\. Operations engineers issue end\-entity certificates that authenticate data center hosts and computer services to one another\. This system helps keep sensitive data secure by encrypting it on the LAN\.

## Setting Length Constraints on the Certification Path<a name="length-constraints"></a>

The structure of a CA hierarchy is defined and enforced by the *basics constraints extension* that each certificate contains\. The extension defines two constraints:
+ `cA` – Whether the certificate defines a CA\. If this value is *false* \(the default\), then the certificate is an end\-entity certificate\.
+ `pathLenConstraint` – The maximum *additional* depth of a certification path that includes the certificate\.

A root CA certificate needs maximum flexibility and does not include a path length constraint\. This allows the root to define a certification path of any depth\. 

**Note**  
ACM Private CA limits the certification path to five levels\.

Subordinate CAs have `pathLenConstraint` values equal to or greater than zero, depending on location in the hierarchy placement and desired features\. For example, in a hierarchy with three CAs, no path constraint is specified for the root CA\. The first subordinate CA has a path length of 1 and can therefore sign child CAs\. Each of these child CAs must necessarily have a `pathLenConstraint` value of zero\. This means that they can sign end\-entity certificates but cannot issue additional CA certificates\. Limiting the power to create new CAs is an important security control\.

The following diagram illustrates this propagation of limited authority down the hierarchy\.

![\[Diagram of a simple, three-level CA hierarchy.\]](http://docs.aws.amazon.com/acm-pca/latest/userguide/images/path-length.png)

In this four\-level hierarchy, the root is unconstrained \(as always\)\. But the first subordinate CA has a `pathLenConstraint` value of 2, which limits its child CAs from going more than two levels deeper\. Consequently, for a valid certification path, the constraint value must decrement to zero in the next two levels\. If a web browser encounters an end\-entity certificate from this branch that has a path length greater than four, validation fails\. Such a certificate could be the result of an accidentally created CA, a misconfigured CA, or a unauthorized issuance\.

### Managing Depth with Templates<a name="template-depth"></a>

ACM Private CA provides templates for issuing root, subordinate, and end\-entity certificates\. These templates encapsulate best practices for the basic constraints values, including path length\. The templates include the following:
+ RootCACertificate/V1
+ SubordinateCACertificate\_PathLen0/V1
+ SubordinateCACertificate\_PathLen1/V1
+ SubordinateCACertificate\_PathLen2/V1
+ SubordinateCACertificate\_PathLen3/V1
+ EndEntityCertificate/V1

The `IssueCertificate` API will return an error if you attempt to create a CA with a path length greater than or equal to the path length of its issuing CA certificate\.

For more information about certificate templates, see [Understanding Certificate Templates](UsingTemplates.md)\.

### Automating CA Hierarchy Setup with AWS CloudFormation<a name="using-cloudformation"></a>

Once you have settled on a design for your CA hierarchy, you can test it and put it into production using a AWS CloudFormation template\. For an example of such a template, see [Declaring a Private CA Hierarchy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-acmpca-certificateauthority.html#aws-resource-acmpca-certificateauthority--examples) in the *AWS CloudFormation User Guide*\.