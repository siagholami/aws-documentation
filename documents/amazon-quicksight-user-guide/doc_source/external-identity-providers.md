# Enabling Single Sign\-On Access to Amazon QuickSight Using SAML 2\.0<a name="external-identity-providers"></a>

Amazon QuickSight supports identity federation through Security Assertion Markup Language 2\.0 \(SAML 2\.0\) in both Standard and Enterprise editions\. You can use an identity provider that supports SAML 2\.0 to provide a simple on\-boarding flow for your Amazon QuickSight users\. Such identity providers include Microsoft Active Directory Federation Services, Ping One Federation Server, and Okta\. 

With identity federation, your users get one\-click access to their Amazon QuickSight applications using their existing identity credentials\. You also have the security benefit of identity authentication by your identity provider\. You can control which users have access to Amazon QuickSight using your existing identity provider\. 

## Example Authentication Workflow<a name="external-identity-providers-example"></a>

In the following diagram, you can see a typical authentication flow between Amazon QuickSight and a third\-party identity provider\. In this example, the administrator has set up a sign\-in page to access Amazon QuickSight, called `applications.exampleco.com`\. The web page uses a federation service that complies with SAML 2\.0 to trigger a sign\-on request\. The administrator has also set up a user to allow access to Amazon QuickSight\.

![\[Amazon QuickSight SAML Diagram. The diagram contains two boxes. The first one describes an authentication process inside the enterprise. The second one describes authentication inside AWS. The process is described in the text following the table.\]](http://docs.aws.amazon.com/quicksight/latest/user/images/SAML-Flow-Diagram.png)

In this authentication flow, the following happens:

1. The user browses to `https://applications.exampleco.com`\. The sign\-on page requests authentication for the user\.

1. The federation service requests authentication from the organization's identity store\.

1. The identity store authenticates the user and returns the authentication response to the federation service\.

1. When authentication is successful, the federation service posts the SAML assertion to the user’s browser\.

1. The user's browser posts the SAML assertion to the AWS Sign\-In SAML endpoint \(`https://signin.aws.amazon.com/saml`\)\. AWS Sign\-In receives the SAML request, processes the request, authenticates the user, and forwards the authentication token to the Amazon QuickSight service\.

1. Using the authentication token from AWS, Amazon QuickSight authorizes the user and presents applications to the browser\.

From the user's perspective, the process happens transparently\. The user starts at your organization's internal portal and lands at an Amazon QuickSight application portal, without ever having to supply any AWS credentials\.