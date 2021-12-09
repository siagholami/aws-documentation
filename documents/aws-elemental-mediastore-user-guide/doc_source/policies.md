# Container policies in AWS Elemental MediaStore<a name="policies"></a>

Each container has a resource\-based policy that governs access rights to all folders and objects in that container\. The default policy, which is automatically attached to all new containers, allows access to all AWS Elemental MediaStore operations on the container\. It specifies that this access has the condition of requiring HTTPS for the operations\. After you create a container, you can edit the policy that is attached to that container\.

You can also specify an [object lifecycle policy](policies-object-lifecycle.md) that governs the expiration date of objects in a container\. After objects reach the maximum age that you specify, the service deletes the objects from the container\.

**Topics**
+ [Viewing a container policy](policies-view.md)
+ [Editing a container policy](policies-edit.md)
+ [Example container policies](policies-examples.md)