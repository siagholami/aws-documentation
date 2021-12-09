--------

--------

# Revising Flows<a name="iot-tg-workflows-deploy"></a>

After you deploy a flow, you might want to revise it\. Each flow is associated with a namespace version\. 

When you revise or create a flow, you should specify a compatible namespace version\. This ensures that the flow continues to work even if the entities in your namespace are revised or deprecated\.

When you pass the optional `compatibleNamespaceVersion` parameter to the [https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateFlowTemplate.html](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateFlowTemplate.html) API, you associate the flow with a specific version of the namespace\. This ensures that deployments of the flow continue to work even if the entities in the namespace are deprecated or updated in ways that are incompatible with the flow\.

The [https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UpdateFlowTemplate.html](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UpdateFlowTemplate.html) also takes the `compatibleNamespaceVersion` parameter\. You can use `compatibleNamespaceVersion` to associate the updated version of the flow with a version of the namespace that is compatible with your flow updates\.

Because flows aren't versioned, you can't update earlier implementations of a flow\. You can revise only the latest version of a flow\.

For more information about namespaces, see [AWS IoT Things Graph Namespaces](iot-tg-whatis-namespace.html)\.