# Listeners in AWS Global Accelerator<a name="about-listeners"></a>

With AWS Global Accelerator, you add listeners that process inbound connections from clients based on the ports and protocols that you specify\. Global Accelerator supports both TCP and UDP protocols\.

You define a listener when you create your accelerator, and you can add more listeners at any time\. You associate each listener with one or more endpoint groups, and you associate each endpoint group with one AWS Region\.

**Topics**
+ [Adding, editing, or removing a listener](about-listeners.creating-listeners.md)
+ [Client affinity](about-listeners-client-affinity.md)