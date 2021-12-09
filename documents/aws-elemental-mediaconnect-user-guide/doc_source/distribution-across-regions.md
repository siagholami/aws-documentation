# Distributing content across Regions<a name="distribution-across-regions"></a>

You can set up two AWS Elemental MediaConnect flows to distribute content from one AWS Region to another\. In this scenario, you create one flow in the Region that is closest to your contribution encoder and a second flow in the Region that is closest to your receiver\. The following illustration shows this process\.

![\[This illustration shows the workflow for distributing content from one AWS Region to another.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)

This topic assumes that you already know how to [create a flow](flows-create.md) and [add outputs to a flow](outputs-add.md)\.

**To distribute content across Regions \(console\)**

1. In the AWS Region that is closest to your source, create a flow\. \(We'll refer to this as flow A\.\)

1. Review the **Details** page for flow A to determine its egress IP address\.

1. In the AWS Region that is closest to your destination, create a second flow \(flow B\) with the following details:
   + Source type: Choose **Standard source**\.
   + Protocol: Choose **Zixi**\.
   + Ingest port: Enter **2088**\.
   + Whitelist CIDR block: Enter a CIDR value that includes the egress IP of flow A\.

1. Review the **Details** page, **Source** tab for flow B to determine its ingest IP address\.

1. In flow A, create an output with the following details:
   + Protocol: Choose **Zixi push**\.
   + IP address: Enter the ingest IP address of flow B\.
   + Port: Enter **2088**\.