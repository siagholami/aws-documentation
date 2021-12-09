# ARNs for Amazon Inspector resources<a name="inspector-arns-resources"></a>

In Amazon Inspector, the primary resources are resource groups, assessment targets, assessment templates, assessment runs, and findings\. These resources have unique Amazon Resource Names \(ARNs\) associated with them, as shown in the following table\.


| Resource Type | ARN Format  | 
| --- | --- | 
| Resource group |  `arn:aws:inspector:region:account-id:resourcegroup/ID`  | 
| Assessment target |  `arn:aws:inspector:region:account-id:target/ID `  | 
| Assessment template |  `arn:aws:inspector:region:account-id:target/ID:template:ID`  | 
| Assessment run |  `arn:aws:inspector:region:account-id:target/ID/template/ID/run/ID`  | 
| Finding |  `arn:aws:inspector:region:account-id:target/ID/template/ID/run/ID/finding/ID`  | 