# Deleting a profiling group<a name="working-with-profiling-groups-delete"></a>

When you delete a profiling group, the profiling group and recommendations reports are deleted\. Application data in the profiling group will be inaccessible\. While Amazon CodeGuru Profiler is in preview, contact AWS Support to have the profiling data deleted\. 

**To delete a profiling group**

1. In the navigation pane on the left, choose **Profiling groups**\.

1. Select the profiling group to delete\.

1. Choose **Actions**, **Delete profiling group**\. 

1. On the confirmation page, choose **Delete** to delete the profiling group\.

1. Remove the CodeGuru Profiler profiling agent code from the Java applications in the profiling group\. You can also modify the code to send data to a different profiling group\. 