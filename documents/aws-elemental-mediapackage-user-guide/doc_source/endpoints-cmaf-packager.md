# Packager Settings Fields<a name="endpoints-cmaf-packager"></a>

The Packager settings fields hold general information about the endpoint\.

1. For **Type**, choose **Common Media Application Format \(CMAF\)**\. 

1. \(Optional\) For **Segment duration**, type the duration \(in seconds\) of each segment\. If the value that you type here is different from the input segment size, AWS Elemental MediaPackage rounds segments to the nearest multiple of the input segment duration\.

1. \(Optional\) For **Segment prefix**, type a custom name for the segments in the HLS child manifest\. The segment prefix is prepended to the segment name to create a unique identifier for each segment\.  
**Example**  

   If the segment prefix is **movie**, a segment from the child manifest is `movie_1_2.ts`\.