# Configuring Availability Options in Amazon CloudSearch<a name="configuring-availability-options"></a>

You can expand an Amazon CloudSearch domain to an additional Availability Zone in the same region to increase fault tolerance in the event of a service disruption\. Availability Zones are physically separate locations with independent infrastructure engineered to be insulated from failures in other Availability Zones\. For more information, see [Regions and Availability Zones](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide//using-regions-availability-zones.html) in the Amazon EC2 User Guide for Linux Instances\.

When you turn on the Multi\-AZ option, Amazon CloudSearch provisions and maintains extra instances for your search domain in a second Availability Zone to ensure high availability\. The maximum number of Availability Zones a domain can be deployed in is two\.

Turning on Multi\-AZ does not affect a search domain's service endpoints or increase the volume of data or traffic your search domain can handle\. Updates are automatically applied to the instances in both Availability Zones\. Search traffic is distributed across all of the instances and the instances in either zone are capable of handling the full load in the event of a failure\. 

If there's an Availability Zone service disruption or the instances in one zone become degraded, Amazon CloudSearch routes all traffic to the other Availability Zone\. Redundant instances are restored in a separate Availability Zone without any administrative intervention or disruption in service\.

You expand an existing search domain to a second Availability Zone by turning on the Multi\-AZ option\. Similarly, you can turn off the Multi\-AZ option to downgrade the domain to a single Availability Zone\. Turning the Multi\-AZ option on or off takes about half an hour\.

You can configure a domain's availability options through the Amazon CloudSearch console, using the `aws cloudsearch update-availability-options` command, or the AWS SDKs\.

**Important**  
If your domain is running on a single search instance, enabling the Multi\-AZ option adds a second search instance in a different availability zone, which doubles the cost of running your domain\. Similarly, if your index is split across multiple partitions, a new instance is deployed in the second Availability Zone for each partition\. Additional replicas are added to ensure that either Availability Zone has enough capacity to handle all of your traffic—when Multi\-AZ is enabled, your domain will have at least one replica of each index partition\. If you set the desired number of replicas and enable the Multi\-AZ option, Amazon CloudSearch ensures that you have at least that many replicas available in total across the two availability zones\. You can monitor the number of instances being used for your domain from the domain dashboard\.

**Topics**
+ [Configuring Availability Options through the Amazon CloudSearch Console](#configuring-availability-options-console)
+ [Configuring Amazon CloudSearch Availability Options Using the AWS CLI](#configuring-availability-options-clt)
+ [Configuring Availability Options through the AWS SDK](#configuring-availability-options-sdk)

## Configuring Availability Options through the Amazon CloudSearch Console<a name="configuring-availability-options-console"></a>

**To configure a search domain's availability options**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console\. In the **Navigation** pane, click the name of the domain you want to configure, and then click the **Availability Options** link\.

1. To turn on the Multi\-AZ option, click **Turn Multi\-AZ on**\. To turn off the Multi\-AZ option, click **Turn Multi\-AZ off**\.

1. When prompted, click **OK** to confirm that you want to modify your domain's availability options\. If your domain currently uses a single search instance, turning on the Multi\-AZ option adds a second search instance, which can significantly increase the cost of running your domain\. To exit without saving your changes, click **Cancel**\.

## Configuring Amazon CloudSearch Availability Options Using the AWS CLI<a name="configuring-availability-options-clt"></a>

You use the `aws cloudsearch update-availability-options` command to configure availability options for a search domain\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To configure a search domain's availability options**
+ Run the `aws cloudsearch update-availability-options` command and specify the `--multi-az` option to turn on MultiAZ for the domain, or `--no-multi-az` to turn MultiAZ off\. For example, the following request enables MultiAZ for the `movies` domain:

  ```
  aws cloudsearch update-availability-options --domain-name movies --multi-az
                      
  {
      "AvailabilityOptions": {
          "Status": {
              "PendingDeletion": false, 
              "State": "Processing", 
              "CreationDate": "2014-04-30T20:42:57Z", 
              "UpdateVersion": 13, 
              "UpdateDate": "2014-05-01T00:17:45Z"
          }, 
          "Options": true
      }
  }
  ```

## Configuring Availability Options through the AWS SDK<a name="configuring-availability-options-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[UpdateAvailabilityOptions](API_UpdateAvailabilityOptions.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.