# Use case: contribution<a name="use-cases-contribution"></a>

You can use AWS Elemental MediaConnect to ingest your content from an on\-premises contribution encoder into the AWS Cloud\. The source for your MediaConnect flow comes from your on\-premises contribution encoder, and the output points to your encoder in the cloud, such as AWS Elemental MediaLive\. For redundancy, you can set up your flow to have two outputs that point to your cloud encoder\. Another setup for redundancy includes two on\-premises contribution encoders—a primary and a backup—that each send content to a different MediaConnect flow\. The output from each flow then points to the same cloud encoder\. 

The following illustration shows an on\-premises contribution encoder that uploads content to AWS Elemental MediaConnect in the AWS Cloud\. The flow output points to an AWS Elemental MediaLive channel\.

![\[This illustration shows an on-premises contribution encoder that uploads content to AWS Elemental MediaConnect in the AWS Cloud. The flow output points to an AWS Elemental MediaLive channel.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)

The following illustration shows two on\-premises contribution encoders, a primary and a backup, that upload the same content to AWS Elemental MediaConnect in the AWS Cloud\. There are two flows, each with one output\. Both outputs point to a single AWS Elemental MediaLive channel\. 

![\[This illustration shows two on-premises contribution encoders, a primary and a backup, that upload the same content to AWS Elemental MediaConnect in the AWS Cloud. There are two flows, each with one output. Both outputs point to a single AWS Elemental MediaLive channel.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)