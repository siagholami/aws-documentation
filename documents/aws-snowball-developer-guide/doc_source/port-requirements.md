--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Ports Required to Use AWS Services on an AWS Snowball Edge Device<a name="port-requirements"></a>

For AWS services to work properly on an AWS Snowball Edge device, you must allow the ports for the service\.

The following is a list of ports that are required for each AWS service\.


| Port | Protocol | Comment | 
| --- | --- | --- | 
| 6078 \(HTTP\) | TCP | IAM HTTP endpoint | 
| 6089 \(HTTPS\) | TCP | IAM HTTPS endpoint | 
| 7078 \(HTTP\) | TCP | STS HTTP endpoint | 
| 7089 \(HTTPS\) | TCP | STS HTTPS endpoint | 
| 8080 \(HTTP\) | TCP | S3 HTTP endpoint | 
| 8443 \(HTTPS\) | TCP | S3 HTTPS endpoint | 
| 8008 \(HTTP\) | TCP | EC2 HTTP endpoint | 
| 8243 \(HTTPS\) | TCP | EC2 HTTPS endpoint | 
| 9091 \(HTTPS\) | TCP | Endpoint for Snowball Edge AWS Command Line Interface | 