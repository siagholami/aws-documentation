# Client affinity<a name="about-listeners-client-affinity"></a>

If you have stateful applications, you can choose to have Global Accelerator direct all requests from a user at a specific source \(client\) IP address to the same endpoint resource, to maintain client affinity\.

By default, client affinity for a listener is set to **None** and Global Accelerator distributes traffic equally between the endpoints in the endpoint groups for the listener\.

Global Accelerator uses a consistent\-flow hashing algorithm to choose the optimal endpoint for a user's connection\. If you configure client affinity for your Global Accelerator resource to be **None**, Global Accelerator uses the 5\-tuple properties—source IP, source port, destination IP, destination port, and protocol—to select the hash value\. Next, it chooses the endpoint that provides the best performance\. If a given client uses different ports to connect to Global Accelerator and you've specified this setting, Global Accelerator can't ensure that connections from the client are always routed to the same endpoint\. 

If you want to maintain client affinity by routing a specific user—identified by their source IP address—to the same endpoint each time they connect, set client affinity to **Source IP**\. When you specify this option, Global Accelerator uses the 2\-tuple properties—source IP and destination IP—to select the hash value and route the user to the same endpoint whenever they connect\.