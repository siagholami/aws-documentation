# IAM Policy Examples for Secrets in AWS Secrets Manager<a name="iam-policy-examples-asm-secrets"></a>

During setup, [you create an IAM policy](setting-up-create-trust-rel-policy.md) that you assign to AWS Elemental MediaPackage\. This policy allows AWS Elemental MediaPackage to read secrets that you have stored in AWS Secrets Manager\. The settings for this policy are entirely up to you\. The policy can range from most restrictive \(allowing access to only specific secrets\) to least restrictive \(allowing access to any secret that you create using this AWS account\)\. We recommend using the most restrictive policy as a best practice\. However, the examples in this section show you how to set up policies with different levels of restriction\. Because AWS Elemental MediaPackage needs only read access to secrets, all the examples in this section show only the actions necessary to read the values that you store\.

**Topics**
+ [Allow Read Access to Specific Secrets in AWS Secrets Manager](#iam-policy-examples-asm-specific-secrets)
+ [Allow Read Access to All Secrets Created in a Specific Region in AWS Secrets Manager](#iam-policy-examples-asm-secrets-in-a-region)
+ [Allow Read Access to All Resources in AWS Secrets Manager](#iam-policy-examples-asm-secrets-all)

## Allow Read Access to Specific Secrets in AWS Secrets Manager<a name="iam-policy-examples-asm-specific-secrets"></a>

The following IAM policy allows read access to specific resources \(secrets\) that you create in AWS Secrets Manager\.

```
{
              "Version": "2012-10-17",
              "Statement": [
                {
                  "Effect": "Allow",
                  "Action": [
                    "secretsmanager:GetResourcePolicy",
                    "secretsmanager:GetSecretValue",
                    "secretsmanager:DescribeSecret",
                    "secretsmanager:ListSecretVersionIds"
                  ],
                  "Resource": [
                    "arn:aws:secretsmanager:us-west-2:111122223333:secret:aes128-1a2b3c",
                    "arn:aws:secretsmanager:us-west-2:111122223333:secret:aes192-4D5e6F",
                    "arn:aws:secretsmanager:us-west-2:111122223333:secret:aes256-7g8H9i"
                  ]
                }
              ]
            }
```

## Allow Read Access to All Secrets Created in a Specific Region in AWS Secrets Manager<a name="iam-policy-examples-asm-secrets-in-a-region"></a>

The following IAM policy allows read access to all secrets that you create in a specific AWS Region in AWS Secrets Manager\. This policy applies to resources that you have created already and all resources that you create in the future in the specified Region\.

```
{
              "Version": "2012-10-17",
              "Statement": [
                {
                  "Effect": "Allow",
                  "Action": [
                    "secretsmanager:GetResourcePolicy",
                    "secretsmanager:GetSecretValue",
                    "secretsmanager:DescribeSecret",
                    "secretsmanager:ListSecretVersionIds"
                  ],
                  "Resource": [
                    "arn:aws:secretsmanager:us-west-2:111122223333:secret:*",
                  ]
                }
              ]
            }
```

## Allow Read Access to All Resources in AWS Secrets Manager<a name="iam-policy-examples-asm-secrets-all"></a>

The following IAM policy allows read access to all resources that you create in AWS Secrets Manager\. This policy applies to resources that you have created already and all resources that you create in the future\.

```
{
              "Version": "2012-10-17",
              "Statement": [
                {
                  "Effect": "Allow",
                  "Action": [
                    "secretsmanager:GetResourcePolicy",
                    "secretsmanager:GetSecretValue",
                    "secretsmanager:DescribeSecret",
                    "secretsmanager:ListSecretVersionIds"
                  ],
                  "Resource": ["*"]
                }
              ]
            }
```