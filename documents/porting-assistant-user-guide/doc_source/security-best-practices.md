# Security best practices for Porting Assistant for \.NET<a name="security-best-practices"></a>

Porting Assistant for \.NET provides security features to consider as you develop and implement your own security policies\. The following best practices are general guidelines and don’t represent a complete security solution\. Because these best practices might not be appropriate or sufficient for your environment, treat them as helpful considerations rather than prescriptions\. 

**Implement least privilege access**  
When you attach the [IAM policy](porting-assistant-prerequisites.md#porting-assistant-iam) as an inline policy to your IAM user, grant only the permissions that are required to perform the specified task\. Implementing least privilege access is fundamental in reducing security risk and the impact that could result from errors or malicious intent\. 