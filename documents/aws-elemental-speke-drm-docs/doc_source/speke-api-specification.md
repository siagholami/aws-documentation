# SPEKE API Specification<a name="speke-api-specification"></a>

This is the REST API specification for Secure Packager and Encoder Key Exchange \(SPEKE\)\. Use this specification to provide DRM copyright protection for customers who use encryption\. 

In a video streaming workflow, the encryption engine communicates with the DRM platform key provider to request content keys\. These keys are highly sensitive, so it is critical that the key provider and encryption engine establish a highly secure, trusted communication channel\. You can also encrypt the content keys in the document for more secure, end\-to\-end encryption\.

This specification addresses the following goals: 
+ Define a simple, trusted, highly secure interface that DRM vendors and customers can use to integrate with encryptors when content encryption is required\. 
+ Cover VOD and live workflows, and include the error conditions and the authentication mechanisms that are required for robust, highly secure communication between encryptors and DRM key provider endpoints\.
+ Include support for HLS, MSS, and DASH packaging and their common DRM systems: FairPlay, PlayReady, and Widevine/CENC\.
+ Keep the specification simple and extensible, to support future DRM systems\.
+ Use a simple REST API\.

**Note**  
The code examples in this specification are for illustration purposes only\. You can’t run the examples because they aren’t part of a complete SPEKE implementation\. 

**Topics**
+ [Authentication](authentication.md)
+ [SPEKE API](the-speke-api.md)