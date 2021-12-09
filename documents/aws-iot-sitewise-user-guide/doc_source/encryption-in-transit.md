# Encryption in transit<a name="encryption-in-transit"></a>

AWS IoT SiteWise has three modes of communication where data is in transit:
+ [Over the internet](#internet-encryption-in-transit) – Communication between local devices \(including gateways\) and AWS IoT SiteWise is encrypted\.
+ [Over the local network](#local-encryption-in-transit) – Communication between gateways and OPC\-UA sources can be encrypted\.
+ [Between components on gateways](#gateway-encryption-in-transit) – Communication between AWS IoT Greengrass components on AWS IoT SiteWise gateways isn't encrypted\.

## Data in transit over the internet<a name="internet-encryption-in-transit"></a>

AWS IoT SiteWise uses Transport Layer Security \(TLS\) to encrypt all communication over the internet\. All data sent to the AWS Cloud is sent over a TLS connection using MQTT or HTTPS protocols, so it's secure by default\. Gateways, which run on AWS IoT Greengrass, and property value notifications use the AWS IoT transport security model\. For more information, see [Transport security](https://docs.aws.amazon.com/iot/latest/developerguide/transport-security.html) in the *AWS IoT Developer Guide*\.

## Data in transit over the local network<a name="local-encryption-in-transit"></a>

AWS IoT SiteWise gateways follow OPC\-UA specifications for communication with local OPC\-UA sources\. It's your responsibility to configure your sources to use a message security mode that encrypts data in transit\.

If you choose a *sign* message security mode, data in transit between gateways and sources is signed but not encrypted\. If you choose a *sign and encrypt* message security mode, the data in transit between gateways and sources is signed and encrypted\. For more information about configuring sources, see [Configuring data sources](configure-sources.md)\.

## Data in transit between local components on gateways<a name="gateway-encryption-in-transit"></a>

AWS IoT SiteWise gateways run on AWS IoT Greengrass, which doesn't encrypt data exchanged locally on the AWS IoT Greengrass core because the data doesn't leave the device\. This includes communication between AWS IoT Greengrass components such as the AWS IoT SiteWise connector\. For more information, see [Data on the core device](https://docs.aws.amazon.com/greengrass/latest/developerguide/encryption-in-transit.html#data-in-transit-locally) in the *AWS IoT Greengrass Developer Guide*\.