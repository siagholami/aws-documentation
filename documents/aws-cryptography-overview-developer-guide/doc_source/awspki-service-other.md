# Other AWS services that use X\.509 public key certificates<a name="awspki-service-other"></a>

The following AWS services also include features that allow you to manage and implement X\.509 public key certificates for use as [SSL/TLS certificates](pki-concepts.md#concept-sslcert) or for code signing\.


****  

| Service | Description | Topic | 
| --- | --- | --- | 
| [Amazon API Gateway](https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html) | Establish a custom API and manage the API domain information\. | [Set Up Custom Domain Name for an API Gateway](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-custom-domains.html) | 
| [AWS CloudFormation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/Welcome.html) | Automatically provision AWS resources, including ACM certificates\. | [Request an ACM Certificate](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-certificatemanager-certificate.html) | 
| [Amazon CloudFront](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html) | Distribute dynamic and static web content to end users as efficiently as possible\. | [Choosing How CloudFront Serves HTTPS Requests](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/cnames-https-dedicated-ip-or-sni.html) | 
| [Code Signing for AWS IoT](https://docs.aws.amazon.com/signer/latest/developerguide/Welcome.html) | Cryptographically sign code using a certificate such as those provisioned by ACM\. | [What is Code Signing for AWS IoT?](https://docs.aws.amazon.com/signer/latest/developerguide/whatis-services.html) | 
| [Elastic Beanstalk](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/Welcome.html) | Easily deploy applications in the AWS Cloud with automated infrastructure provisioning\. | [Configure Your Load Balancer to Terminate HTTPS](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/configuring-https-elb.html) | 
| [Elastic Load Balancing](https://docs.aws.amazon.com/elasticloadbalancing/latest/userguide/what-is-load-balancing.html) | Distribute incoming application traffic across multiple Amazon EC2 instances as efficiently as possible\. | [HTTPS Listener for Your Application Load Balancer](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/create-https-listener.html#https-listener-certificate) | 