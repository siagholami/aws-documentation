# Resource\-Based Policies<a name="pca-rbp"></a>

Resource\-based policies are permission policies that you create and manually attach to a resource \(in this case, a private CA\) rather than to a user identity or role\. Using RAM to apply a resource\-based policy, a ACM Private CA administrator can share access to a CA with a user in a different AWS account directly or through AWS Organizations\. Alternatively, an ACM Private CA administrator can use the PCA APIs [PutPolicy](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_PutPolicy.html), [GetPolicy](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetPolicy.html), and [DeletePolicy](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeletePolicy.html), or the corresponding AWS CLI commands [put\-policy](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/put-policy.html), [get\-policy](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/get-policy.html), and [delete\-policy](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/delete-policy.html), to apply and manage resource\-based policies\.

For general information about resource\-based policies, see [Identity\-Based Policies and Resource\-Based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html) and [Controlling Access Using Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_controlling.html)\. 

An AWS Certificate Manager \(ACM\) user who has received shared access to a private CA can issue managed end\-entity certificates that are signed by the CA\. Users with cross\-account shared access to a CA may only issue certificates that use the `EndEntityCertificate/V1` template\.

The following examples contain resource\-based policies and the commands to apply them\. In addition to specifying the ARN of a CA, the administrator provides an AWS user account ID or an AWS Organizations ID that will be granted access to the CA\. For readability, the JSON of each policy is provided as a file instead of inline\.

**Note**  
The structure of the JSON resource\-based polices shown below must be followed precisely\. Only the ID fields for the principals \(the AWS account number or the AWS Organizations ID\) and the CA ARNs can be configured by customers\.

**Example 1: Sharing access to a CA with a user in a different account**

```
$ aws acm-pca put-policy \
   --region ap-southeast-2 \
   --resource-arn arn:aws:acm-pca:ap-southeast-2:0123456789012:certificate-authority/01234567-89ab-cdef-0123-456789abcdef \
   --policy file:///[path]/policy1.json
```

The file `policy1.json` has the following content:

```
 {                        
   "Version":"2012-10-17",
   "Statement":[
      {    
         "Sid":"1",
         "Effect":"Allow",         
         "Principal":{                                                                                                                                               
            "AWS":"0123456789ab"                                                                                
         },
         "Action":[
            "acm-pca:DescribeCertificateAuthority",
            "acm-pca:GetCertificate",
            "acm-pca:GetCertificateAuthorityCertificate",
            "acm-pca:ListPermissions",
            "acm-pca:ListTags"                                                                                   
         ],                                                                                              
         "Resource":"arn:aws:acm-pca:ap-southeast-2:0123456789012:certificate-authority/01234567-89ab-cdef-0123-456789abcdef"
      },
      {
         "Sid":"1",  
         "Effect":"Allow",
         "Principal":{
            "AWS":"0123456789ab"
         },
         "Action":[
            "acm-pca:IssueCertificate"
         ],
         "Resource":"arn:aws:acm-pca:ap-southeast-2:0123456789012:certificate-authority/01234567-89ab-cdef-0123-456789abcdef",
         "Condition":{
            "StringEquals":{
               "acm-pca:TemplateArn":"arn:aws:acm-pca:::template/EndEntityCertificate/V1"
            }
         }
      }
   ]
}
```

**Example 2: Sharing access to a CA through AWS Organizations**

```
$ aws acm-pca put-policy \
   --region ap-southeast-2 \
   --resource-arn arn:aws:acm-pca:ap-southeast-2:0123456789012:certificate-authority/01234567-89ab-cdef-0123-456789abcdef 
   --policy file:///[path]/policy2.json
```

The file `policy2.json` has the following content:

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Sid":"1",
         "Effect":"Allow",
         "Principal":"*",
         "Action":"acm-pca:IssueCertificate",
         "Resource":"arn:aws:acm-pca:ap-southeast-2:0123456789012:certificate-authority/01234567-89ab-cdef-0123-456789abcdef",
         "Condition":{
            "StringEquals":{
               "acm-pca:TemplateArn":"arn:aws:acm-pca:::template/EndEntityCertificate/V1",
               "aws:PrincipalOrgID":"o-1b2c3d4z5"
            }
         }
      },
      {
         "Sid":"1",
         "Effect":"Allow",
         "Principal":"*",
         "Action":[
            "acm-pca:DescribeCertificateAuthority",
            "acm-pca:GetCertificate",
            "acm-pca:GetCertificateAuthorityCertificate",
            "acm-pca:ListPermissions",
            "acm-pca:ListTags"
         ],
         "Resource":"arn:aws:acm-pca:ap-southeast-2:0123456789012:certificate-authority/01234567-89ab-cdef-0123-456789abcdef",
         "Condition":{
            "StringEquals":{
               "aws:PrincipalOrgID":"o-a1b2c3d4z5"
            }
         }
      }
   ]
}
```