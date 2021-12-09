# Choosing a gateway platform<a name="choose-gateway-platform"></a>

Choose an AWS IoT SiteWise gateway platform that best suits your industrial operation\. You can configure a gateway on any platform that can run AWS IoT Greengrass\. All gateway devices must meet the following requirements:
+ Supports AWS IoT Greengrass Core software v1\.10\.0 or later\. For more information, see [Supported platforms and requirements](https://docs.aws.amazon.com/greengrass/latest/developerguide/what-is-gg.html#gg-platforms) in the *AWS IoT Greengrass Developer Guide*\.
+ Has at least 1 GB of RAM\.
+ Has at least 10 GB of free disk space\.
+ Supports a Java 8 virtual machine \(JVM\)\.

Choose a gateway with sufficient disk, networking, and compute capacity for your workload\.

The disk space required for caching data for intermittent internet connectivity depends on the following factors:
+ Number of data streams uploaded
+ Data points per data stream per second
+ Size of each data point
+ Communication speeds
+ Expected network downtime

The compute capacity required to poll and upload data depends on the following factors:
+ Number of data streams uploaded
+ Data points per data stream per second