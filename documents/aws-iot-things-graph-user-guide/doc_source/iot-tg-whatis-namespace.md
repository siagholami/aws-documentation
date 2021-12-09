--------

--------

# Namespaces<a name="iot-tg-whatis-namespace"></a>

 A namespace is the repository for entities \(for example, models\) created using the AWS IoT Things Graph Data Modeling \(TDM\) language\. These entities are associated with a specific account\. The namespace is part of the URN for each entity\. 

When you [upload TDM entities](iot-tg-models-gs.html) for the first time, AWS IoT Things Graph creates a namespace for you\. The namespace consists of your AWS Region, your account ID, and a fixed suffix `default`\. The pattern is *REGION*/*ACCOUNT ID*/`default`\. For example, a TDM entity created in the `us-west-2` region looks like this: `us-west-2/012345678910/default`\.

You can extend the path under `default` to organize your entities\. For example, you could place your device definitions under `default/devices` and your property definitions under `default/properties`\.

Currently AWS IoT Things Graph supports only one namespace per account\. TDM entities that are stored in a namespace are [Properties](iot-tg-models-tdm-propertytype.html), [States](iot-tg-models-tdm-iot-state.html), [Events](iot-tg-models-tdm-iot-event.html), [Actions](iot-tg-models-tdm-iot-action.html), [Capabilities](iot-tg-models-tdm-iot-capability.html), [Mappings](iot-tg-models-tdm-iot-mapping.html), [Devices](iot-tg-models-tdm-iot-device.html), and [Services](iot-tg-models-tdm-iot-service.html)\. 

There are two kinds of namespaces: public and private\. The namespace associated with your account is private\. You create and upload your own entity models inside this namespace\. The public namespace is maintained by AWS and contains the entity definitions that all accounts can access\. Private namespaces track the public namespace, and you can synchronize your private namespace with a specific version of the public namespace\. 

For more information about namespaces, see: 
+ [Versioning and Entity Modeling](iot-tg-models-manage.html)
+ [Namespace Versioning and Workflows](iot-tg-workflows-deploy.html)
+ [Lifecycle Management for AWS IoT Things Graph Entities, Flows, Systems, and Deployments ](iot-tg-lifecycle.html)