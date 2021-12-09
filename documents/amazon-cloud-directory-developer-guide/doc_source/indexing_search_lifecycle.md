# Index Lifecycle<a name="indexing_search_lifecycle"></a>

You can use the following API calls to help with the development lifecycle of indexes\. 

1. You create indexes with the `[CreateIndex](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateIndex.html)` API call\. You supply an index definition structure that describes the attributes on attached objects that the index will track\. The definition also indicates whether or not the index should enforce uniqueness\. The result is an object ID for the new index, which should immediately be attached to your hierarchy like any other object\. For example, this can be a branch dedicated to holding indexes\.

1. You attach objects to the index manually with the `[AttachToIndex](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachToIndex.html)` API call\. The index then automatically tracks the values of its defined attributes on each attached object\.

1. To use the indexes to search for objects with more efficient enumeration, call `[ListIndex](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIndex.html)` and specify a range of values that you are interested in\.

1. Use the `[ListAttachedIndices](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListAttachedIndices.html)` API call to enumerate the indexes that are attached to a given object\.

1. Use the `[DetachFromIndex](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachFromIndex.html)` API call to remove objects from the index manually\.

1. Once you detach all objects from the index, you can delete the index with the `[DeleteObject](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DeleteObject.html)` API call\.

There is no limit on the number of indexes within a directory, other than the limit on the space used by all objects\. Indexes and their attachments do consume space, but it is similar to that consumed by nodes and parent–child links\. There is a limit on the number of indexes that can be attached to a given object\. For more information, see [Amazon Cloud Directory Limits](limits.md)\.