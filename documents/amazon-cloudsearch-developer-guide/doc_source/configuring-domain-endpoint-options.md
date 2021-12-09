# Configuring Domain Endpoint Options in Amazon CloudSearch<a name="configuring-domain-endpoint-options"></a>

Amazon CloudSearch domains let you require that all traffic to the domain arrive over HTTPS\. This security feature helps you block clients that send unencrypted requests to the domain\.

**Topics**
+ [Configuring Domain Endpoint Options Using the Amazon CloudSearch Console](#configuring-domain-endpoint-options-console)
+ [Configuring Domain Endpoint Options Using the AWS CLI](#configuring-domain-endpoint-options-cli)
+ [Configuring Domain Endpoint Options Using the AWS SDKs](#configuring-domain-endpoint-options-api)

## Configuring Domain Endpoint Options Using the Amazon CloudSearch Console<a name="configuring-domain-endpoint-options-console"></a>

**To configure a search domain's endpoint options**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console\. In the navigation pane, click the name of the domain you want to configure, and then choose **HTTPS Options**\.

1. To require that all traffic to the domain arrive over HTTPS, choose **Turn Enforce HTTPS on**\.

## Configuring Domain Endpoint Options Using the AWS CLI<a name="configuring-domain-endpoint-options-cli"></a>

Use the `aws cloudsearch update-domain-endpoint-options` command\. For more information, see the [AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/cloudsearch/)\.

## Configuring Domain Endpoint Options Using the AWS SDKs<a name="configuring-domain-endpoint-options-api"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including [DescribeDomainEndpointOptions](API_DescribeDomainEndpointOptions.md) and [UpdateDomainEndpointOptions](API_UpdateDomainEndpointOptions.md)\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.