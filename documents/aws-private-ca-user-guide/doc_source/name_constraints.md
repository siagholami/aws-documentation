# Enforcing Name Constraints on a Private CA<a name="name_constraints"></a>

Name constraints are defined in the internet public key infrastructure \(PKI\) standard RFC 5280\. These constraints provide a way for CA administrators to restrict subject names in certificates\. Administrators can control which names are allowed or prohibited in certificates that are issued from their private CAs\. For example, a private domain name such as "project1\.corp" might be allowed\. But another private domain name such as "project2\.corp" might be reserved for a different internal project\. Similarly, public DNS names such as "example\.com" or "\*\.com" can be denied\. For more information, see the [Name Constraints](https://tools.ietf.org/html/rfc5280#section-4.2.1.10) section of RFC 5280\.

ACM Private CA enforces name constraints that are included in CA certificates\. However, CA certificates issued *by* ACM Private CA cannot include name constraints\. To apply name constraints in your private CA hierarchy, sign your AWS managed CA certificate with an external CA that supports issuing CA certificates with name constraints\. Then import that certiﬁcate into ACM Private CA\. Name constraints will now be inherited by certificates that your private CA issues\.

**Note**  
Procedures for creating or obtaining an external CA are outside the scope of this guide\.

Name constraints define names that can be either permitted or excluded in downstream certificate subtrees\. Applying name constraints prevents subordinate CA administrators from issuing certificates for domains or hosts outside of an authorized scope\. 

ACM Private CA supports name constraints for the following name forms:
+ `IPAddress`
+ `DirectoryName`
+ `UniformResourceIdentifier`
+ `EmailAddress`
+ `DNSName`

ACM Private CA will not import a certificate that is configured to enforce name constraints for one of the following unsupported name forms:
+ `OtherName`
+ `X400Address`
+ `RegisteredID`
+ `EDIPartyName`

## Examples of Name Constraint Policies<a name="name_constraint_exmaples"></a>

Each of the following examples includes a stub certificate policy that defines a set of name constraints\. The examples also include an explanation of the resulting restrictions on certificate issuance\. The following general rules apply:
+ Name constraints are stated as *permitted* subtrees, *excluded* subtrees, or both\.
+ Permitted and excluded subtrees contain matching patterns, which may be empty\. If a `permitted` subtree is empty, then all names in that form are denied\. Similarly, if an `excluded` subtree is empty, then all names in that form are allowed\.
+ If a name form is not listed, then all names in that form are allowed\. 
+ Placing a constraint on one name form has no effect on other name forms\.

### Permitted Subtrees Only<a name="example1"></a>

```
nameConstraints=critical,permitted;
DNSName:.private
DNSName:.local
DNSName:.corp
UniformResourceIdentifier:
```

**Result:** A DNS name is allowed only if it matches "\.private", "\.local", or "\.corp"\. Names in the `UniformResourceIdentifier` form are denied because there is no matching pattern\. All names in supported unlisted forms are allowed\.

### Excluded Subtrees Only<a name="example2"></a>

```
nameConstraints=critical,excluded;
DNSName:.example.com
DNSName:.local
```

**Result:** A DNS name is denied if it matches "\.example\.com" or "\.local"\. All names in supported unlisted forms are allowed\.

### Permitted AND Excluded Subtrees<a name="example3"></a>

```
nameConstraints=critical,permitted;
DNSName:.private
DNSName:.local
DNSName:.corp
nameConstraints=critical,excluded;
DNSName:.secret.corp
DNSName:.example.com
```

**Result:** A DNS name matching "\.private" or "\.local" is allowed\. A DNS name matching "\.corp" is allowed unless it also matches "\.secret\.corp"\. A DNS name matching "\.example\.com" is denied\. All names in supported unlisted forms are allowed\.

### Permitted Subtrees Only, Specified in Two CA Certificates in the Chain<a name="example4"></a>

```
Root CA:
nameConstraints=critical,permitted;
DNSName:.private
DNSName:.local
DNSName:.corp

Subordinate CA:
nameConstraints=critical,permitted;
DNSName:sub.private
DNSName:a.b.local
```

**Result:** A DNS name is allowed if it matches "sub\.private" or "a\.b\.local"\. DNS names matching "\.corp" are denied\. All names in supported unlisted forms are allowed\.

### Excluded Subtrees Only, Specified in Two CA Certificates in the Chain<a name="example5"></a>

```
Root CA:
nameConstraints=critical,excluded;
DNSName:foo.private
DNSName:foo.example
Subordinate CA:
nameConstraints=critical,excluded;
DNSName:bar.private
DNSName:.example
IPAddress:0.0.0.0/0
```

**Result:** A DNS name is allowed unless it matches "foo\.private", "bar\.private", or "\.example"\. Names in the `IPAddress` form are denied because the matching pattern matches all IP addresses\. All names in supported unlisted forms are allowed\.