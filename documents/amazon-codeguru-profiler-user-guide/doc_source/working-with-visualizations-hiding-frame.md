# Hiding a frame<a name="working-with-visualizations-hiding-frame"></a>

When you hide a frame, the visualization no longer shows that frame or its callee frames\. This is useful when you want to remove certain execution paths from the visualization\. For example, you can exclude the `myFunction` function if it's not causing performance issues\. All occurrences of that frame in the visualization will be hidden\.

**To hide a stack frame while pausing over it**

1. On the **Profiling group detail** page, pause over the frame you want to inspect on the visualization\. 

1. Open the context \(right\-click\) menu, and then choose **Hide frame**\. 

**To search for stack frames to hide**

1. On the **Profiling group detail** page, choose **Actions**, and then choose **Hide frames**\. 

1. In the **Hidden frames** page, specify a search string\. As the string is provided, results will automatically update\. 

1. Select a stack frame to hide\. When you're done, close the **Hidden frames** page\.

**To unhide stack frames**

1. Choose **X Hidden frames** in the upper\-left corner\. It opens the **Hidden frames** menu with the list of already hidden frames\. **X** is how many frames are currently hidden\. 

1. Choose **Show** on any of the hidden frames to stop hiding it\. 