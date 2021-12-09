--------

--------

# Managing Lifecycles for AWS IoT Things Graph Entities, Flows, Systems, and Deployments<a name="iot-tg-lifecycle"></a>

This topic contains information about how to manage namespace versions and revisions of workflows \(flows\) and systems\. 

Namespace versioning protects your flows, systems, and deployment configurations from breaking when you update or create devices and device models \(either your own or ones that get added when you sync with the public namespace\)\. Changes that aren't backward compatible don't break existing deployments or even new deployments of flows that contain the earlier versions\.

Additionally, this topic describes how to delete existing entities from your namespace, and deprecate and delete flows, systems, and deployment configurations\.

## Namespace Management<a name="iot-tg-lifecycle-namespaces"></a>

A [namespace](iot-tg-whatis-namespace.html) is the container for entities created by using the AWS IoT Things Graph Data Model \(TDM\) language\. These entities are associated with a specific account\. The namespace is part of the URN for each entity\. 

In the following example, the namespace is everything before the device name \(*DL05PLCUnits*\)\.

`urn:tdm:REGION/ACCOUNT_ID/default:deviceModel:DL05PLCUnits`

The following are the entities that are stored in your namespace:
+ [Properties](iot-tg-models-tdm-propertytype.html)
+ [States](iot-tg-models-tdm-iot-state.html)
+ [Events](iot-tg-models-tdm-iot-event.html)
+ [Actions](iot-tg-models-tdm-iot-action.html)
+ [Capabilities](iot-tg-models-tdm-iot-capability.html)
+ [Mappings](iot-tg-models-tdm-iot-mapping.html)
+ [Devices](iot-tg-models-tdm-iot-device.html)
+ [Device Models](iot-tg-models-tdm-iot-device-model.html)
+ [Services](iot-tg-models-tdm-iot-service.html)

[Systems](iot-tg-models-tdm-iot-system.html), [Flows](iot-tg-models-tdm-iot-workflow.html), and [Deployments](iot-tg-models-tdm-iot-sdc-deployconfig.html) aren't stored in your namespace\.

When you first upload an entity definition, AWS IoT Things Graph creates a namespace for you\. This namespace is in sync with the current version of the public namespace\. AWS IoT Things Graph provides a [ValidateEntityDefinitions](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_ValidateEntityDefinitions.html) API that you can use to debug your TDM before you upload your entity definitions\. After confirming that your TDM is valid, you upload the definitions by using either the [UploadEntityDefinitions](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UploadEntityDefinitions.html) API or the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home)\.

AWS IoT Things Graph creates a new version of your namespace when you make a backward\-incompatible change\. The following are examples of actions that prompt the creation of a new namespace version:
+ You update any existing entity \(property, action, event, and so on\) in your namespace\.
+ You sync your namespace with the public namespace\.
+ You deprecate the existing entities in your namespace and replace them with a new set of entities\.

You can update existing entities by using either the AWS IoT Things Graph console or the [UploadEntityDefinitions](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UploadEntityDefinitions.html) API\. The [UploadEntityDefinitions](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UploadEntityDefinitions.html) API has two optional Boolean parameters that enable you to perform the other two actions:
+ `syncWithPublicNamespace`
+ `deprecateExistingEntities`

After the `UploadEntityDefinitions` operation completes, there is a short delay before the entities are available in flows\. When you're writing tests and scripted solutions, take this delay into account\.

When you create a flow, by default AWS IoT Things Graph uses entities in the current version of your namespace\. When you deploy a flow, by default AWS IoT Things Graph validates it against the current version of your namespace\. This means that if you attempt to deploy a flow that contains entities that are incompatible with the current namespace, by default the deployment fails\. A flow that contains deprecated entities also fails\.

To specify an earlier namespace that contains entities that are compatible with a flow, use the optional `compatibleNamespaceVersion` parameter of the [CreateFlowTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateFlowTemplate.html) API\. If you create the flow with this parameter, AWS IoT Things Graph validates your flow against the version value that you set with this parameter when you deploy the flow\. The [CreateSystemTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateSystemTemplate.html) also has this optional parameter, so ensure that your system and flow are using the same namespace version when you deploy them\.

The [UpdateFlowTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UpdateFlowTemplate.html) and [UpdateSystemTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UpdateSystemTemplate.html) APIs take the same optional `compatibleNamespaceVersion` parameter\. This means you can use those operations to change the namespace version against which the flow is validated when it deploys\.

## Deleting Systems, Flows, and Namespaces<a name="iot-tg-lifecycle-deletingsysflow"></a>

To delete a flow in the AWS IoT Things Graph console, on the **Flows** page, select the flow to delete\. Choose **Delete**\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDeleteFlow.png)

When you create a flow in the AWS IoT Things Graph console, the console silently creates a system that contains the flow for you\. When you delete the flow, the AWS IoT Things Graph console also silently deletes the system that contains the flow\.

The [DeprecateFlowTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_DeprecateFlowTemplate.html) and [DeprecateSystemTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_DeprecateSystemTemplate.html) APIs enable you to mark a flow or system for deletion before you delete it\. Deprecated systems and flows can't be deployed, but existing deployments that contain the system or flow continue to run\. If you're not using the AWS IoT Things Graph console, you must deprecate a system or flow before you delete it\. Delete a system before you delete the flows that it contains\.

The [DeleteFlowTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_DeleteFlowTemplate.html) and [DeleteSystemTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_DeleteSystemTemplate.html) APIs enable you to delete a flow or system that is deprecated\. After you delete a flow, any system that contains the flow no longer updates or deploys\. After you delete a system, any deployment configuration that contains the system no longer updates or deploys\. Existing deployments that contain the flow continue to run because they use a snapshot of the workflow that's taken at the time of deployment\. The same is true for deployments that contain deleted systems\. You must delete all flows in a system before you delete the system\.

To delete a namespace, use the [DeleteNamespace](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_DeleteNamespace.html) API\. Before you delete the namespace, you must delete all systems, flows, and flow configurations that use entities in the namespace\. Existing flow deployments continue to work after you delete a namespace\. AWS IoT Things Graph creates a snapshot of the flow, flow configuration, system, and entities for each deployment\.

## Deleting Flow Configurations<a name="iot-tg-lifecycle-deletingflowconfig"></a>

Deleting a deployment configuration requires two steps\.

1. **Undeploy the flow configuration\.** This step removes the configuration from the AWS IoT Greengrass group or the cloud\.

1. **Delete the flow configuration\.** This step removes the deployment configuration from AWS IoT Things Graph\.

The following procedure shows how to delete a deployment configuration by using the AWS IoT Things Graph console\.

1. Undeploy the flow configuration\.

   On the **Deployments** page, select the flow configuration to delete\. In the upper right of the page, choose **Undeploy**\. Enter **Undeploy**, and then choose **Undeploy** in the box that appears\. 

1. Delete the deployment configuration\.

   On the **Deployments** page, select the flow configuration to delete\. In the upper right of the page, choose **Delete**\. Enter **delete**, and then choose **Delete** in the box that appears\.

The [UndeploySystemInstance](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_API_UndeploySystemInstance.html) and [DeleteSystemInstance](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_DeleteSystemInstance.html) APIs also perform these two actions\.