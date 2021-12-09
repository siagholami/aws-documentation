# Traffic Mirror Source and Target Connectivity Options<a name="traffic-mirroring-connection"></a>

The traffic mirror source and the traffic mirror target \(monitoring appliance\) can be in:
+ The same VPC, or
+ A different VPC connected by using an intra\-Region VPC peering connection or a transit gateway\.

The traffic mirror target can be owned by an AWS account that is different from the traffic mirror source\. 

The mirrored traffic is sent to the traffic mirror target using the source VPC route table\. Before you configure Traffic Mirroring, make sure that the traffic mirror source can route to the traffic mirror target\. 

The following table describes the available resource configurations\. 


**Available Traffic Mirroring Configurations**  

| Source Owner | Source VPC | Source Type | Target Owner | Target VPC | Connectivity Option | 
| --- | --- | --- | --- | --- | --- | 
| Account A | VPC 1 | Network interface | Account A | VPC1 | No additional configuration | 
| Account A | VPC 1 | Network interface | Account A | VPC 2 | Intra\-Region peering or a transit gateway | 
| Account A | VPC 1 | Network interface | Account B | VPC 2 | Cross\-account Intra\-Region peering or a transit gateway | 
| Account A | VPC 1 | Network interface | Account B | VPC 1 | VPC sharing | 