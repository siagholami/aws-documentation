--------

--------

# Versioning and Entity Modeling<a name="iot-tg-models-manage"></a>

AWS IoT Things Graph enables you to create different versions of your namespace\. If you change one or more of the entities in your namespace in ways that aren't compatible with existing deployments, AWS IoT Things Graph creates a new version of your namespace\. Because each instance of a workflow \(flow\) is associated with a namespace version, existing deployments of a flow continue to work because they're associated with earlier versions of the namespace\.

## Uploading Entities<a name="iot-tg-models-manage-upload"></a>

The [UploadEntityDefinitions](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UploadEntityDefinitions.html) API takes two optional parameters that enable you to create versions of your namespace\. If you set the value of the `deprecateExistingEntities` parameter to `true`, AWS IoT Things Graph deprecates all of the existing entities in the current version of your namespace before it uploads the new entity definitions\. This creates a new version of your namespace\.

## Synchronizing with the Public Namespace<a name="iot-tg-models-manage-synchronize"></a>

If you set the value of the `syncWithPublicNamespace` parameter to `true`, AWS IoT Things Graph synchronizes your namespace with the latest version of the public namespace\. Because this might introduce incompatibilities with the entity definitions that existing flow deployments use, AWS IoT Things Graph creates a new version of your namespace\.

Existing deployments of flows that use deprecated or updated entity definitions continue to work because they're associated with earlier versions of the namespace\.

If you add any entity definitions from your private namespace to the public namespace, you must update your own flows to use the version of the entity that's in the public namespace\.

For more information about namespaces, see [AWS IoT Things Graph Namespaces](iot-tg-whatis-namespace.html)\.