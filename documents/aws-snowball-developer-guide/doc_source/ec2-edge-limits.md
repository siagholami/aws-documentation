--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Quotas for Compute Instances on a Snowball Edge<a name="ec2-edge-limits"></a>

The following AWS Regions are supported for you to add compute instances to your devices:
+ US East \(Ohio\)
+ US East \(N\. Virginia\)
+ US West \(N\. California\)
+ US West \(Oregon\)
+ Asia Pacific \(Singapore\)
+ Asia Pacific \(Sydney\)
+ Asia Pacific \(Tokyo\)
+ Europe \(Frankfurt\)
+ Europe \(Ireland\)
+ Europe \(London\)
+ Europe \(Paris\)
+ South America \(São Paulo\)

## Storage Quotas<a name="device-storage-limits"></a>

The storage available for compute resources is a separate resource from the dedicated Amazon S3 storage on a Snowball Edge device\. The quotas for storage are as follows: 
+ **Storage quotas for the Snowball Edge Storage Optimized option** – The total available storage for Amazon S3 is between 60 TB and 80 TB depending on whether you're using compute instances on the device\. If you are using compute instances, then total available dedicated storage for `sbe1` compute instances for the Snowball Edge Storage Optimized option is 1,000 GB\.
+ **Storage quotas for the Snowball Edge Compute Optimized and with GPU options** – The total available dedicated storage for `sbe-c` and `sbe-g` instances is 7\.68 TB\. The total available storage remaining is 42 TB\.

The following tables outline the available compute resources for Snowball Edge devices\.


****  

| Feature | Limitation | 
| --- | --- | 
| Number of AMIs on a single Snowball Edge Storage Optimized option | 10 | 
| Number of AMIs on a single Snowball Edge Compute Optimized option | 20 | 
| Number of AMIs on a single Snowball Edge Compute Optimized with GPU option | 20 | 
| Number of volumes per instance | 10 | 
| Concurrently running \(or stopped\) instances | Varies depending on available resources | 


****  

| Instance type | vCPU cores | Memory \(GiB\) | GPUs | Supported device option | 
| --- | --- | --- | --- | --- | 
| sbe1\.small | 1 | 1 | 0 | storage optimized | 
| sbe1\.medium | 1 | 2 | 0 | storage optimized | 
| sbe1\.large | 2 | 4 | 0 | storage optimized | 
| sbe1\.xlarge | 4 | 8 | 0 | storage optimized | 
| sbe1\.2xlarge | 8 | 16 | 0 | storage optimized | 
| sbe1\.4xlarge | 16 | 32 | 0 | storage optimized | 
| sbe1\.6xlarge | 24 | 32 | 0 | storage optimized | 
| sbe\-c\.small | 1 | 2 | 0 |  compute optimized  | 
| sbe\-c\.medium | 1 | 4 | 0 |  compute optimized  | 
| sbe\-c\.large | 2 | 8 | 0 |  compute optimized  | 
| sbe\-c\.xlarge | 4 | 16 | 0 |  compute optimized  | 
| sbe\-c\.2xlarge | 8 | 32 | 0 |  compute optimized  | 
| sbe\-c\.4xlarge | 16 | 64 | 0 |  compute optimized  | 
| sbe\-c\.8xlarge | 32 | 128 | 0 |  compute optimized  | 
| sbe\-c\.12xlarge | 48 | 192 | 0 |  compute optimized  | 
| sbe\-g\.small | 1 | 2 | 1 | with GPU | 
| sbe\-g\.medium | 1 | 4 | 1 | with GPU | 
| sbe\-g\.large | 2 | 8 | 1 | with GPU | 
| sbe\-g\.xlarge | 4 | 16 | 1 | with GPU | 
| sbe\-g\.2xlarge | 8 | 32 | 1 | with GPU | 
| sbe\-g\.4xlarge | 16 | 64 | 1 | with GPU | 
| sbe\-g\.8xlarge | 32 | 128 | 1 | with GPU | 
| sbe\-g\.12xlarge | 48 | 192 | 1 | with GPU | 

## Shared Compute Resource Limitations<a name="shared-resource-limitations"></a>

All services on a Snowball Edge device use some of the finite resources on the device\. A Snowball Edge device with its available compute resources maximized can't launch new compute resources\. For example, if you try to start the file interface while also running a `sbe1.4xlarge` compute instance on a storage optimized device, the file interface service doesn't start\. The following outlines the available resources on the different device options as well as resource requirements for each service\.
+ If no compute services are `ACTIVE`:
  + On a storage optimized option, you have 24 vCPUs and 32 GiB of memory for your compute instances\.
  + On a compute optimized option, you have 52 vCPUs and 208 GiB of memory for your compute instances\. This is also true for the with GPU option\.
+ While AWS IoT Greengrass and AWS Lambda powered by AWS Greengrass are `ACTIVE`:
  + On a storage optimized option, these services use 4 vCPU cores and 8 GiB of memory\.
  + On a compute optimized option, these services use 1 vCPU core and 1 GiB of memory\. This is also true for the GPU option\.
  + While the file interface is `ACTIVE`, it uses 8 vCPU cores and 16 GiB of memory on a Snowball Edge device\.

You can determine whether a service is `ACTIVE` on a Snowball Edge by using the command `snowballEdge describe-service` on the Snowball client\. For more information, see [Getting Service Status](using-client-commands.md#client-service-status)\.