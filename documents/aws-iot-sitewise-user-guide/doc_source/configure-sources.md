# Configuring data sources<a name="configure-sources"></a>

After you set up a gateway, you can configure data sources so that your gateway can ingest data from local servers to AWS IoT SiteWise\. Each source represents a local server, such as an OPC\-UA server, that your gateway connects and retrieves industrial data streams\. For more information about setting up a gateway, see [Configuring a gateway](configure-gateway.md)\.

**Note**  
AWS IoT SiteWise restarts your gateway each time you add or edit a source\. Your gateway won't ingest data while it's restarting\. The time to restart your gateway depends on the number of OPC\-UA tags on your gateway's OPC\-UA sources\. Restart time can range from a few seconds \(for a gateway with few tags\) to several minutes \(for a gateway with many tags\)\.

After you create sources, you can associate your data streams with asset properties\. For more information about how to create and use assets, see [Modeling industrial assets](industrial-asset-models.md) and [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

You can view CloudWatch metrics to verify that a data source is connected to AWS IoT SiteWise\. For more information, see [Gateway metrics](monitor-cloudwatch-metrics.md#gateway-metrics)\.

**Topics**
+ [Configuring data sources \(console\)](#configure-source-console)
+ [Configuring data sources \(AWS CLI\)](#configure-source-cli)
+ [Enabling your source servers to trust the gateway](#enable-source-trust)
+ [Configuring source authentication](configure-source-authentication.md)
+ [Using OPC\-UA node filters](opc-ua-node-filters.md)

## Configuring data sources \(console\)<a name="configure-source-console"></a>

You can use the AWS IoT SiteWise console to add OPC\-UA sources to your gateway\.

**To configure a data source \(console\)**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Gateways**\.

1. On the gateway you want to create a source for, choose **Manage**, and then choose **View details**\.  
![\[AWS IoT SiteWise "Gateways" page screenshot with "View details" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-view-details-console.png)

1. Choose **New source** in the upper\-right corner\.

1. Enter a **Nickname** for the source\.

1. Enter the **Local endpoint** of the data source server\. For example, your local endpoint might look like **opc\.tcp://203\.0\.113\.0:49320**\.

1. \(Optional\) Enter a **Data stream prefix**\. The gateway adds this prefix to all data streams from this source\. Use a data stream prefix to distinguish between data streams that have the same name from different sources\. Each data stream should have a unique name within your account\.

1. Choose a **Message security mode** for connections and data in transit between your source server and your gateway\. This field is the combination of the OPC\-UA security policy and message security mode\. You must choose the same security policy and message security mode that you specified for your OPC\-UA server\.

   Choose the security policy from the following options:
   + **None** – The gateway doesn't secure connections to the OPC\-UA source\. We recommend that you choose a different security policy\.
   + **Basic256Sha256** – The **Basic256Sha256** security policy\.
   + **Aes128\_Sha256\_RsaOaep** – The **Aes128\_Sha256\_RsaOaep** security policy\.
   + **Aes256\_Sha256\_RsaPss** – The **Aes256\_Sha256\_RsaPss** security policy\.
   + **Basic128Rsa15** – \(Deprecated\) The **Basic128Rsa15** security policy is deprecated in the OPC\-UA specification because it's no longer considered secure\. We recommend that you choose a different security policy\. For more information, see [Basic128Rsa15](http://opcfoundation.org/UA-Profile/UA/SecurityPolicy%23Basic128Rsa15)\.
   + **Basic256** – \(Deprecated\) The **Basic256** security policy is deprecated in the OPC\-UA specification because it's no longer considered secure\. We recommend that you choose a different security policy\. For more information, see [Basic256](http://opcfoundation.org/UA-Profile/UA/SecurityPolicy%23Basic256)\.

   Except for the **None** option, each security policy has two options for message security mode:
   + **Sign** – The data in transit between the gateway and the source is signed but not encrypted\.
   + **Sign and encrypt** – The data in transit between the gateway and the source is signed and encrypted\.
**Important**  
If you choose a message security mode other than **None**, you must enable your source server to trust the gateway\. For more information, see [Enabling your source servers to trust the gateway](#enable-source-trust)\.

1. If your source requires authentication, choose an AWS Secrets Manager secret from the **Authentication configuration** list\. The gateway uses the authentication credentials in this secret when it connects to this source\. You must attach secrets to your gateway's IoT SiteWise connector to use them for source authentication\. For more information, see [Configuring source authentication](configure-source-authentication.md)\.
**Tip**  
Your data server might have an option named **Allow anonymous login**\. If this option is **Yes**, then your source doesn't require authentication\.

1. \(Optional\) Add OPC\-UA node filters to limit which OPC\-UA paths are uploaded to AWS IoT SiteWise\. You can use node filters to reduce your gateway's startup time and CPU usage by only including paths to data that you model in AWS IoT SiteWise\. By default, gateways upload all OPC\-UA paths except those that start with `/Server/`\. To define OPC\-UA node filters, you can use node paths and the `*` and `**` wildcard characters\. For more information, see [Using OPC\-UA node filters](opc-ua-node-filters.md)\.

1. Choose **Save**\.

   AWS IoT SiteWise deploys the gateway configuration to your AWS IoT Greengrass core\. You don't need to manually trigger a deployment\.

## Configuring data sources \(AWS CLI\)<a name="configure-source-cli"></a>

You can use the AWS IoT SiteWise API and AWS Command Line Interface to add sources to your gateway\. You define sources in gateway capabilities\. A gateway capability represents a software feature that runs on the gateway, such as the capability to collect industrial data from OPC\-UA sources\.

Gateway capabilities have the following components:
+ A configuration – A JSON document that defines all of the data sources for a capability\.
+ A namespace – A unique string that identifies the type and version of a capability\. For example, the OPC\-UA source capability namespace is `iotsitewise:opcuacollector:version`, where *version* is the version of the OPC\-UA capability\. All OPC\-UA sources are defined in one capability with this namespace\.
+ A synchronization status – A status that indicates if a capability is synchronized between the AWS Cloud and the gateway\. The sync status can be one of the following:
  + `IN_SYNC` – The gateway is running the capability configuration\.
  + `OUT_OF_SYNC` – The gateway hasn't received the capability configuration\.
  + `SYNC_FAILED` – The gateway rejected the capability configuration\.

  After you update a capability configuration, its sync status is `OUT_OF_SYNC` until the gateway receives and applies or rejects the updated configuration\.

Use the following operations to query and update your gateway sources and capability configurations:
+ [DescribeGateway](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeGateway.html) – Retrieves information about a specific gateway\. The response includes a list of capability summaries, including capability namespaces\.
+ [DescribeGatewayCapabilityConfiguration](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeGatewayCapabilityConfiguration.html) – Retrieves the configuration of a specific capability\. Use this operation to retrieve a capability configuration to update\.
+ [ListGateways](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListGateways.html) – Lists information about all gateways\. The response includes a list of capability summaries for each gateway, including capability namespaces\.
+ [UpdateGatewayCapabilityConfiguration](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateGatewayCapabilityConfiguration.html) – Updates a gateway capability configuration or defines a new capability configuration\. This operation identifies capabilities by a capability namespace\. If you provide a namespace that already exists, this operation updates the capability for that namespace\. Otherwise, this operation creates a new capability\.
**Warning**  
The [UpdateGatewayCapabilityConfiguration](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateGatewayCapabilityConfiguration.html) operation overwrites the existing capability configuration with the configuration that you provide in the payload\. To avoid deleting your capability's configuration, you must add to the existing configuration when you update the capability\.

**Topics**
+ [OPC\-UA sources](#configure-opc-ua-source-cli)

### OPC\-UA sources<a name="configure-opc-ua-source-cli"></a>

You can define OPC\-UA data sources in a gateway capability\. You must define all of your OPC\-UA sources in a single capability configuration\.

This capability has the following versions\.


| Version | Namespace | 
| --- | --- | 
| 1 | iotsitewise:opcuacollector:1 | 

**Topics**
+ [Parameters](#opc-ua-source-parameters-cli)
+ [Examples](#opc-ua-source-example-cli)

#### Capability configuration parameters<a name="opc-ua-source-parameters-cli"></a>

When you define OPC\-UA sources in a capability configuration, you must specify the following information in the `capabilityConfiguration` JSON document:

`sources`  
A list of OPC\-UA source definition structures that each contain the following information:    
`name`  
A unique, friendly name for the source\.  
`endpoint`  
An endpoint structure that contains the following information:    
`certificateTrust`  
A certificate trust policy structure that contains the following information:    
`type`  
The certificate trust mode for the source\. Choose one of the following:  
+ `TrustAny` – The gateway trusts any certificate when it connects to the OPC\-UA source\.
+ `X509` – The gateway trusts an X\.509 certificate when it connects to the OPC\-UA source\. If you choose this option, you must define `certificateBody` in `certificateTrust`\. You can also define `certificateChain` in `certificateTrust`\.  
`certificateBody`  
\(Optional\) The body of an X\.509 certificate\.  
This field is required if you choose `X509` for `type` in `certificateTrust`\.  
`certificateChain`  
\(Optional\) The chain of trust for an X\.509 certificate\.  
This field is used only if you choose `X509` for `type` in `certificateTrust`\.  
`endpointUri`  
The local endpoint of the OPC\-UA source\. For example, your local endpoint might look like `opc.tcp://203.0.113.0:49320`\.  
`securityPolicy`  
The security policy to use so that you can secure messages that are read from the OPC\-UA source\. Choose one of the following:  
+ `NONE` – The gateway doesn't secure messages from the OPC\-UA source\. We recommend that you choose a different security policy\. If you choose this option, you must also choose `NONE` for `messageSecurityMode`\.
+ `BASIC256_SHA256` – The `Basic256Sha256` security policy\.
+ `AES128_SHA256_RSAOAEP` – The `Aes128_Sha256_RsaOaep` security policy\.
+ `AES256_SHA256_RSAPSS` – The `Aes256_Sha256_RsaPss` security policy\.
+ `BASIC128_RSA15` – \(Deprecated\) The `Basic128Rsa15` security policy is deprecated in the OPC\-UA specification because it's no longer considered secure\. We recommend that you choose a different security policy\. For more information, see [Basic128Rsa15](http://opcfoundation.org/UA-Profile/UA/SecurityPolicy%23Basic128Rsa15)\.
+ `BASIC256` – \(Deprecated\) The `Basic256` security policy is deprecated in the OPC\-UA specification because it's no longer considered secure\. We recommend that you choose a different security policy\. For more information, see [Basic256](http://opcfoundation.org/UA-Profile/UA/SecurityPolicy%23Basic256)\.
If you choose a security policy other than `NONE`, you must choose `SIGN` or `SIGN_AND_ENCRYPT` for `messageSecurityMode`\. You must also configure your source server to trust the gateway\. For more information, see [Enabling your source servers to trust the gateway](#enable-source-trust)\.  
`messageSecurityMode`  
The message security mode to use to secure connections to the OPC\-UA source\. Choose one of the following:  
+ `NONE` – The gateway doesn't secure connections to the OPC\-UA source\. We recommend that you choose a different message security mode\. If you choose this option, you must also choose `NONE` for `securityPolicy`\.
+ `SIGN` – Data in transit between the gateway and the OPC\-UA source is signed but not encrypted\.
+ `SIGN_AND_ENCRYPT` – Data in transit between the gateway and the OPC\-UA source is signed and encrypted\.
If you choose a message security mode other than `NONE`, you must choose a `securityPolicy` other than `NONE`\. You must also configure your source server to trust the gateway\. For more information, see [Enabling your source servers to trust the gateway](#enable-source-trust)\.  
`identityProvider`  
An identity provider structure that contains the following information:    
`type`  
The type of authentication credentials required by the source\. Choose one of the following:  
+ `Anonymous` – The source doesn't require authentication to connect\.
+ `Username` – The source requires a user name and password to connect\. If you choose this option, you must define `usernameSecretArn` in `identityProvider`\.  
`usernameSecretArn`  
\(Optional\) The ARN of an AWS Secrets Manager secret\. The gateway uses the authentication credentials in this secret when it connects to this source\. You must attach secrets to your gateway's IoT SiteWise connector to use them for source authentication\. For more information, see [Configuring source authentication](configure-source-authentication.md)\.  
This field is required if you choose `Username` for `type` in `identityProvider`\.  
`nodeFilterRules`  
A list of node filter rule structures that define the OPC\-UA data stream paths to send to the AWS Cloud\. You can use node filters to reduce your gateway's startup time and CPU usage by only including paths to data that you model in AWS IoT SiteWise\. By default, gateways upload all OPC\-UA paths except those that start with `/Server/`\. To define OPC\-UA node filters, you can use node paths and the `*` and `**` wildcard characters\. For more information, see [Using OPC\-UA node filters](opc-ua-node-filters.md)\.  
Each structure in the list must contain the following information:    
`action`  
The action for this node filter rule\. You can choose the following option:  
+ `INCLUDE` – The gateway includes only data streams that match this rule\.  
`definition`  
A node filter rule structure that contains the following information:    
`type`  
The type of node filter path for this rule\. You can choose the following option:  
+ `OpcUaRootPath` – The gateway evaluates this node filter path against the root of the OPC\-UA path hierarchy\.  
`rootPath`  
The node filter path to evaluate against the root of the OPC\-UA path hierarchy\. This path must start with `/`\.  
`measurementDataStreamPrefix`  
A string to prepend to all data streams from the source\. The gateway adds this prefix to all data streams from this source\. Use a data stream prefix to distinguish between data streams that have the same name from different sources\. Each data stream should have a unique name within your account\.

#### Capability configuration examples<a name="opc-ua-source-example-cli"></a>

The following example defines a gateway capability configuration from a payload stored in a JSON file\.

```
aws iotsitewise update-gateway-capability-configuration \
  --capability-namespace "iotsitewise:opcuacollector:1" \
  --capability-configuration file://opc-ua-configuration.json
```

**Example**  
The following JSON example for `opc-ua-configuration.json` defines a basic, insecure OPC\-UA source configuration\.  

```
{
  "sources": [
    {
      "name": "Wind Farm #1",
      "endpoint": {
        "certificateTrust": {
          "type": "TrustAny"
        },
        "endpointUri": "opc.tcp://203.0.113.0:49320",
        "securityPolicy": "NONE",
        "messageSecurityMode": "NONE",
        "identityProvider": {
          "type": "Anonymous"
        },
        "nodeFilterRules": []
      },
      "measurementDataStreamPrefix": ""
    }
  ]
}
```

**Example**  
The following JSON example for `opc-ua-configuration.json` defines an OPC\-UA source configuration with the following properties:  
+ Trusts any certificate\.
+ Uses the `BASIC256` security policy to secure messages\.
+ Uses the `SIGN_AND_ENCRYPT` mode to secure connections\.
+ Uses authentication credentials stored in a Secrets Manager secret\.
+ Filters out data streams except those whose path starts with `/WindFarm/2/WindTurbine/`\.
+ Adds `/Washington` to the start of every data stream path to distinguish between this "Wind Farm \#2" and a "Wind Farm \#2" in another area\.

```
{
  "sources": [
    {
      "name": "Wind Farm #2",
      "endpoint": {
        "certificateTrust": {
          "type": "TrustAny"
        },
        "endpointUri": "opc.tcp://203.0.113.1:49320",
        "securityPolicy": "BASIC256",
        "messageSecurityMode": "SIGN_AND_ENCRYPT",
        "identityProvider": {
          "type": "Username",
          "usernameSecretArn": "arn:aws:secretsmanager:region:123456789012:secret:greengrass-windfarm2-auth-1ABCDE"
        },
        "nodeFilterRules": [
          {
            "action": "INCLUDE",
            "definition": {
              "type": "OpcUaRootPath",
              "rootPath": "/WindFarm/2/WindTurbine/"
            }
          }
        ]
      },
      "measurementDataStreamPrefix": "/Washington"
    }
  ]
}
```

**Example**  
The following JSON example for `opc-ua-configuration.json` defines an OPC\-UA source configuration with the following properties:  
+ Trusts a given X\.509 certificate\.
+ Uses the `BASIC256` security policy to secure messages\.
+ Uses the `SIGN_AND_ENCRYPT` mode to secure connections\.

```
{
  "sources": [
    {
      "name": "Wind Farm #3",
      "endpoint": {
        "certificateTrust": {
          "type": "X509",
          "certificateBody": "-----BEGIN CERTIFICATE-----
MIICiTCCAfICCQD6m7oRw0uXOjANBgkqhkiG9w
 0BAQUFADCBiDELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAldBMRAwDgYDVQQHEwdTZ
 WF0dGxlMQ8wDQYDVQQKEwZBbWF6b24xFDASBgNVBAsTC0lBTSBDb25zb2xlMRIw
 EAYDVQQDEwlUZXN0Q2lsYWMxHzAdBgkqhkiG9w0BCQEWEG5vb25lQGFtYXpvbi5
 jb20wHhcNMTEwNDI1MjA0NTIxWhcNMTIwNDI0MjA0NTIxWjCBiDELMAkGA1UEBh
 MCVVMxCzAJBgNVBAgTAldBMRAwDgYDVQQHEwdTZWF0dGxlMQ8wDQYDVQQKEwZBb
 WF6b24xFDASBgNVBAsTC0lBTSBDb25zb2xlMRIwEAYDVQQDEwlUZXN0Q2lsYWMx
 HzAdBgkqhkiG9w0BCQEWEG5vb25lQGFtYXpvbi5jb20wgZ8wDQYJKoZIhvcNAQE
 BBQADgY0AMIGJAoGBAMaK0dn+a4GmWIWJ21uUSfwfEvySWtC2XADZ4nB+BLYgVI
 k60CpiwsZ3G93vUEIO3IyNoH/f0wYK8m9TrDHudUZg3qX4waLG5M43q7Wgc/MbQ
 ITxOUSQv7c7ugFFDzQGBzZswY6786m86gpEIbb3OhjZnzcvQAaRHhdlQWIMm2nr
 AgMBAAEwDQYJKoZIhvcNAQEFBQADgYEAtCu4nUhVVxYUntneD9+h8Mg9q6q+auN
 KyExzyLwaxlAoo7TJHidbtS4J5iNmZgXL0FkbFFBjvSfpJIlJ00zbhNYS5f6Guo
 EDmFJl0ZxBHjJnyp378OD8uTs7fLvjx79LjSTbNYiytVbZPQUQ5Yaxu2jXnimvw
 3rrszlaEXAMPLE=
-----END CERTIFICATE-----",
          "certificateTrust": "-----BEGIN CERTIFICATE-----
MIICiTCCAfICCQD6m7oRw0uXOjANBgkqhkiG9w
 0BAQUFADCBiDELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAldBMRAwDgYDVQQHEwdTZ
 WF0dGxlMQ8wDQYDVQQKEwZBbWF6b24xFDASBgNVBAsTC0lBTSBDb25zb2xlMRIw
 EAYDVQQDEwlUZXN0Q2lsYWMxHzAdBgkqhkiG9w0BCQEWEG5vb25lQGFtYXpvbi5
 jb20wHhcNMTEwNDI1MjA0NTIxWhcNMTIwNDI0MjA0NTIxWjCBiDELMAkGA1UEBh
 MCVVMxCzAJBgNVBAgTAldBMRAwDgYDVQQHEwdTZWF0dGxlMQ8wDQYDVQQKEwZBb
 WF6b24xFDASBgNVBAsTC0lBTSBDb25zb2xlMRIwEAYDVQQDEwlUZXN0Q2lsYWMx
 HzAdBgkqhkiG9w0BCQEWEG5vb25lQGFtYXpvbi5jb20wgZ8wDQYJKoZIhvcNAQE
 BBQADgY0AMIGJAoGBAMaK0dn+a4GmWIWJ21uUSfwfEvySWtC2XADZ4nB+BLYgVI
 k60CpiwsZ3G93vUEIO3IyNoH/f0wYK8m9TrDHudUZg3qX4waLG5M43q7Wgc/MbQ
 ITxOUSQv7c7ugFFDzQGBzZswY6786m86gpEIbb3OhjZnzcvQAaRHhdlQWIMm2nr
 AgMBAAEwDQYJKoZIhvcNAQEFBQADgYEAtCu4nUhVVxYUntneD9+h8Mg9q6q+auN
 KyExzyLwaxlAoo7TJHidbtS4J5iNmZgXL0FkbFFBjvSfpJIlJ00zbhNYS5f6Guo
 EDmFJl0ZxBHjJnyp378OD8uTs7fLvjx79LjSTbNYiytVbZPQUQ5Yaxu2jXnimvw
 3rrszlaEXAMPLE=
-----END CERTIFICATE-----"
        },
        "endpointUri": "opc.tcp://203.0.113.2:49320",
        "securityPolicy": "BASIC256",
        "messageSecurityMode": "SIGN_AND_ENCRYPT",
        "identityProvider": {
          "type": "Anonymous"
        },
        "nodeFilterRules": []
      },
      "measurementDataStreamPrefix": ""
    }
  ]
}
```

## Enabling your source servers to trust the gateway<a name="enable-source-trust"></a>

If you choose a message security mode other than **None**, you must enable your source servers to trust the gateway\. The gateway generates a certificate that you must accept on your source server\. Steps can vary depending on the source servers that you use\. Consult the documentation for each server\.

The procedure might be similar to the following steps\.

**To enable an OPC\-UA server to trust the gateway**

1. Open the interface for configuring your OPC\-UA server \(for example, right\-click the OPC\-UA icon in the system tray\)\.

1. Enter the user name and password for the OPC\-UA server administrator\.

1. Locate **Trusted Clients** in the interface, and then choose **AWS IoT SiteWise Gateway Client**\.

1. Choose **Trust**\.

### Exporting the OPC\-UA client certificate<a name="export-opc-ua-client-certificate"></a>

Some OPC\-UA servers require access to the OPC\-UA client certificate file to trust the gateway\. If this applies to your OPC\-UA servers, you can use the following procedure to export the OPC\-UA client certificate from the gateway\. Then, you can import the certificate on your OPC\-UA server\.

**To export the OPC\-UA client certificate file for a source**

1. The gateway stores an OPC\-UA client certificate for each source\. Each source is identified by a unique ID\. The gateway stores source IDs in a configuration file located at `/sitewise-root/config/sitewise-COLLECTOR-config.json`\. The AWS IoT SiteWise API doesn't provide source IDs, so you must find them in this configuration file\.

   On the gateway, run one of the following commands to print the output of the collector configuration file\. Replace *sitewise\-root* with the local storage path for your AWS IoT SiteWise configuration\. The default *sitewise\-root* is `/var/sitewise`\.
   + If you have [jq](https://stedolan.github.io/jq/) installed, run the following command to pretty\-print the configuration file with syntax highlighting\.

     ```
     cat /sitewise-root/config/sitewise-COLLECTOR-config.json | jq .
     ```
   + If you have [Python](https://www.python.org/) installed, run the following command to pretty\-print the configuration file\.

     ```
     cat /sitewise-root/config/sitewise-COLLECTOR-config.json | python -m json.tool
     ```
   + If you don't have a JSON printing tool, run the following command to print the configuration file\.

     ```
     cat /sitewise-root/config/sitewise-COLLECTOR-config.json
     ```

   The following JSON example demonstrates a configuration file for a gateway with one basic OPC\-UA source\.

   ```
   {
     "creationDate": 1588369971457,
     "dataVersion": null,
     "gatewayConfiguration": {
       "schemaVersion": "DefaultSchemaVersion",
       "sources": [
         {
           "endpoint": {
             "certificateTrust": {
               "type": "TrustAny"
             },
             "endpointUri": "opc.tcp://203.0.113.0:49320",
             "identityProvider": {
               "type": "Anonymous"
             },
             "messageSecurityMode": "NONE",
             "nodeFilterRules": [],
             "securityPolicy": "NONE"
           },
           "id": "a1b2c3d4-5678-90ab-cdef-1c1c1EXAMPLE",
           "measurementDataStreamPrefix": "",
           "name": "Wind Farm #1",
           "type": "OpcUaSource"
         }
       ],
       "syncStatus": "OUT_OF_SYNC",
       "version": 27
     },
     "id": {
       "accountId": "123456789012",
       "value": "a1b2c3d4-5678-90ab-cdef-1a1a1EXAMPLE"
     },
     "lastUpdateDate": 1592004024251,
     "name": "ExampleCorpGateway",
     "platform": {
       "groupArn": "arn:aws:greengrass:us-west-2:123456789012:/greengrass/groups/a1b2c3d4-5678-90ab-cdef-1b1b1EXAMPLE",
       "type": "Greengrass"
     },
     "sink": null,
     "state": "ACTIVE"
   }
   ```

   Find the source that corresponds to the OPC\-UA server\. The ID of the source is in the `id` field\. In the above example, *a1b2c3d4\-5678\-90ab\-cdef\-1c1c1EXAMPLE* is the source ID for the OPC\-UA source named `Wind Farm #1`\.

1. Run the following command to change to the directory that contains the certificate file\. Replace *sitewise\-root* with the local storage path for your AWS IoT SiteWise configuration and replace *source\-id* with the source ID that you found in the previous step\.

   ```
   cd /sitewise-root/pusher/source-id/opcua-certificate-store
   ```

1. The gateway's OPC\-UA client certificate for this source is in the `aws-iot-opcua-client.pfx` file\.

   Run the following command to export the certificate to a `.pem` file called `aws-iot-opcua-client-certificate.pem`\.

   ```
   keytool -exportcert -v -alias aws-iot-opcua-client -keystore aws-iot-opcua-client.pfx -storepass amazon -storetype PKCS12 -rfc > aws-iot-opcua-client-certificate.pem
   ```

1. Transfer the certificate file, `aws-iot-opcua-client-certificate.pem`, from the gateway to the OPC\-UA server\.

   To do so, you can use common software such as the `scp` program to transfer the file using the SSH protocol\. For more information, see [Secure copy](https://en.wikipedia.org/wiki/Secure_copy) on *Wikipedia*\.
**Note**  
If your gateway is running on Amazon Elastic Compute Cloud \(Amazon EC2\) and you're connecting to it for the first time, you must configure prerequisites to connect\. For more information, see [Connect to your Linux instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstances.html) in the *Amazon EC2 User Guide for Linux Instances*\.

1. Import the certificate file, `aws-iot-opcua-client-certificate.pem`, on the OPC\-UA server to trust the gateway\. Steps can vary depending on the source server that you use\. Consult the documentation for the server\.