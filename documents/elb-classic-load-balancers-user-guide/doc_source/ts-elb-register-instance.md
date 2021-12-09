# Troubleshoot a Classic Load Balancer: Instance registration<a name="ts-elb-register-instance"></a>

When you register an instance with your load balancer, there are a number of steps that are taken before the load balancer can begin to send requests to your instance\.

The following are issues your load balancer might encounter when registering your EC2 instances, the potential causes, and the steps you can take to resolve the issues\.

**Topics**
+ [Taking too long to register an EC2 instance](#ts-elb-register-too-long)
+ [Unable to register an instance launched from a paid AMI](#ts-elb-paid-ami-instance)

## Taking too long to register an EC2 instance<a name="ts-elb-register-too-long"></a>

**Problem**: Registered EC2 instances are taking longer than expected to be in the `InService` state\.

**Cause**: Your instance might be failing the health check\. After the initial instance registration steps are completed \(it can take up to approximately 30 seconds\), the load balancer starts sending health check requests\. Your instance is not `InService` until one health check succeeds\.

**Solution**: See [Connection to the instances has timed out](ts-elb-healthcheck.md#ts-elb-healthcheck-failed)\.

## Unable to register an instance launched from a paid AMI<a name="ts-elb-paid-ami-instance"></a>

**Problem**: Elastic Load Balancing is not registering an instance launched using a paid AMI\.

**Cause**: Your instances might have been launched using a paid AMI from [Amazon DevPay](http://aws.amazon.com/devpay/)\. 

**Solution**: Elastic Load Balancing does not support registering instances launched using paid AMIs from [Amazon DevPay](http://aws.amazon.com/devpay/)\. Note that you can use paid AMIs from [AWS Marketplace](https://aws.amazon.com/marketplace)\. If you are already using a paid AMI from AWS Marketplace and are unable to register an instance launched from that paid AMI, go to the [AWS Support Center](https://console.aws.amazon.com/support/home#/) for assistance\.