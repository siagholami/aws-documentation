# Working with visualizations<a name="working-with-visualizations"></a>

In Amazon CodeGuru Profiler, you can use visualizations to explore profiling data collected from applications in a profiling group\. When a profiling group has enough information to display, you can view an *overview* visualization of the profiling group data\. 

A visualization is a collection of stack frames that were profiled in the running application\. A stack frame contains the state of one method invocation\. The name of the method is displayed in the visualization\. You can pause over a frame to see its full name and timing details\. You can also see the active CPU cost of the method as it exists in the substack of the frame\. Frames with the same frame name are highlighted in the rest of the visualization\. You can hide a stack frame from the visualization or inspect a specific frame\. You can also zoom and search for a function\.

The following topics describe how to navigate, filter, and visualize data collected from your running applications\.

**Topics**
+ [Types of visualizations](working-with-visualizations-visualization-types.md)
+ [Exploring visualization data](working-with-visualizations-exploring.md)
+ [Filtering visualization data](working-with-visualizations-filtering.md)
+ [Selecting a custom time range](working-with-visualizations-time-range.md)