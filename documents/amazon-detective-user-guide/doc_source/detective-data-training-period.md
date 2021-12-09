# Training period for new behavior graphs<a name="detective-data-training-period"></a>

One avenue of investigation for a finding is to compare the activity during the finding scope time to activity that occurred before the finding was detected\. Activity that has not been seen before might be more likely to be suspicious\.

Some Amazon Detective profile panels highlight activity that was not observed during the time period before the finding\. Several profile panels also display a baseline value to show the average activity during the 45 days before the scope time\.

As more data is extracted into your behavior graph, Detective develops a more accurate picture of what activity is normal in your organization and what activity is unusual\.

However, to create this picture, Detective needs access to at least two weeks of data\. The maturity of the Detective analysis also increases with the number of accounts in the behavior graph\.

The first two weeks after you activate Detective are considered a training period\. During this period, the **Search** page and profiles display a message that Detective is in a training period\. A similar message is displayed on profile panels that compare activity that occurred during the scope time to activity that occurred before the scope time\.

During the free trial, Detective recommends that you add as many member accounts as you can to the behavior graph\. This provides Detective with a larger pool of data, which allows it to generate a more accurate picture of the normal activity for your organization\.