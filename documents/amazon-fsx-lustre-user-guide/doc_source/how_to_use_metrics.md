# How to Use Amazon FSx for Lustre Metrics<a name="how_to_use_metrics"></a>

The metrics reported by Amazon FSx for Lustre provide information that you can analyze in different ways\. The list following shows some common uses for the metrics\. These are suggestions to get you started, not a comprehensive list\.


| How Do I Determine\.\.\. | Relevant Metrics | 
| --- | --- | 
| My file system's throughput? | SUM\(DataReadBytes \+ DataWriteBytes\)/Period \(in seconds\)  | 
| My file system's IOPS? | Total IOPS = SUM\(DataReadOperations \+ DataWriteOperations \+ MetadataOperations\)/Period \(in seconds\) | 