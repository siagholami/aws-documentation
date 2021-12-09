# Traffic Mirror Sessions<a name="traffic-mirroring-sessions"></a>

A *traffic mirror* session establishes a relationship between a traffic mirror source and a traffic mirror target\.

A traffic mirror session contains the following resources:
+ A traffic mirror source
+ A traffic mirror target 
+ A traffic mirror filter

A given packet is only mirrored one time\. However, you can use multiple traffic mirror sessions on the same source\. This is useful if you want to send a subset of the mirrored traffic from a traffic mirror source to different tools\. For example, you can filter HTTP traffic in a higher priority traffic mirror session and send it to a specific monitoring appliance\. At the same time, you can filter all other TCP traffic in a lower priority traffic mirror session and send it to another monitoring appliance\.

Traffic mirror sessions are evaluated based on the ascending session number that you define when you create the session\. 