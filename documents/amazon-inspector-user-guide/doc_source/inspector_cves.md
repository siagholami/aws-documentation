# Common vulnerabilities and exposures<a name="inspector_cves"></a>

The rules in this package help verify whether the EC2 instances in your assessment targets are exposed to common vulnerabilities and exposures \(CVEs\)\. Attacks can exploit unpatched vulnerabilities to compromise the confidentiality, integrity, or availability of your service or data\. The CVE system provides a reference method for publicly known information security vulnerabilities and exposures\. For more information, see [ https://cve\.mitre\.org/](https://cve.mitre.org/)\. 

If a particular CVE appears in a *finding* that is produced by an Amazon Inspector assessment, you can search [https://cve\.mitre\.org/](https://cve.mitre.org/) for the ID of the CVE \(for example, **CVE\-2009\-0021**\)\. The search results can provide detailed information about this CVE, its severity, and how to mitigate it\.

The rules included in this package help you assess whether your EC2 instances are exposed to the CVEs in the following regional lists:
+ [US East \(N\. Virginia\)](https://s3.us-east-1.amazonaws.com/rules-engine.us-east-1/CVEList.txt)
+ [US East \(Ohio\)](https://s3.us-east-2.amazonaws.com/rules-engine.us-east-2/CVEList.txt)
+ [US West \(N\. California\)](https://s3.us-west-1.amazonaws.com/rules-engine.us-west-1/CVEList.txt)
+ [US West \(Oregon\)](https://s3.us-west-2.amazonaws.com/rules-engine.us-west-2/CVEList.txt)
+ [EU \(Ireland\)](https://s3.eu-west-1.amazonaws.com/rules-engine.eu-west-1/CVEList.txt)
+ [EU \(Frankfurt\)](https://s3.eu-central-1.amazonaws.com/rules-engine.eu-central-1/CVEList.txt)
+ [EU \(London\)](https://s3.eu-west-2.amazonaws.com/rules-engine.eu-west-2/CVEList.txt)
+ [EU \(Stockholm\)](https://s3.eu-north-1.amazonaws.com/rules-engine.eu-north-1/CVEList.txt)
+ [Asia Pacific \(Tokyo\)](https://s3.ap-northeast-1.amazonaws.com/rules-engine.ap-northeast-1/CVEList.txt)
+ [Asia Pacific \(Seoul\)](https://s3.ap-northeast-2.amazonaws.com/rules-engine.ap-northeast-2/CVEList.txt)
+ [Asia Pacific \(Mumbai\)](https://s3.ap-south-1.amazonaws.com/rules-engine.ap-south-1/CVEList.txt)
+ [Asia Pacific \(Sydney\)](https://s3.ap-southeast-2.amazonaws.com/rules-engine.ap-southeast-2/CVEList.txt)
+ [AWS GovCloud West \(US\)](https://s3.us-gov-west-1.amazonaws.com/rules-engine.us-gov-west-1/CVEList.txt)
+ [AWS GovCloud East \(US\)](https://s3.us-gov-east-1.amazonaws.com/rules-engine.us-gov-east-1/CVEList.txt)

The CVE rules package is updated regularly; this list includes the CVEs that are included in assessments runs that occur at the same time that this list is retrieved\.

For more information, see [Amazon Inspector rules packages for supported operating systems](inspector_rule-packages_across_os.md)\.