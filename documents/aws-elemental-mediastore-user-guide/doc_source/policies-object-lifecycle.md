# Object lifecycle policies in AWS Elemental MediaStore<a name="policies-object-lifecycle"></a>

For each container, you can create an object lifecycle policy that governs how long objects should be stored in the container\. When objects reach the maximum age that you specify, AWS Elemental MediaStore deletes the objects\. You can delete objects after they are no longer needed to save on storage costs\. 

You can also specify that MediaStore should move objects to the infrequent access \(IA\) storage class after they reach a certain age\. Objects that are stored in the IA storage class have different rates for storage and retrieval than objects that are stored in the standard storage class\. For more information, see [MediaStore Pricing](https://aws.amazon.com/mediastore/pricing/)\. 

An object lifecycle policy contains rules, which dictate the lifespan of objects by subfolder\. \(You can't assign an object lifecycle policy to individual objects\)\. You can attach only one object lifecycle policy to a container, but you can add up to 10 rules to each object lifecycle policy\. For more information, see [Components of an object lifecycle policy](policies-object-lifecycle-components.md)\.

**Topics**
+ [Components of an object lifecycle policy](policies-object-lifecycle-components.md)
+ [Adding an object lifecycle policy to a container](policies-object-lifecycle-add.md)
+ [Viewing an object lifecycle policy](policies-object-lifecycle-view.md)
+ [Editing an object lifecycle policy](policies-object-lifecycle-change.md)
+ [Deleting an object lifecycle policy](policies-object-lifecycle-delete.md)
+ [Example object lifecycle policies](policies-object-lifecycle-examples.md)