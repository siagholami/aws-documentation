# Manifest Settings Fields<a name="cfigs-dash-manset"></a>

Specify the format of the manifest that AWS Elemental MediaPackage delivers from an asset that uses this packaging configuration\.

1. \(Optional\) For **Manifest name**, enter a short string that will be appended to the endpoint URL\. The manifest name helps to create a unique path to this endpoint\. If you don't enter a value, the default manifest name is *index*\.

1. \(Optional\) For **Min buffer time**, enter the minimum amount of time \(in seconds\) that a player must keep in the buffer\. If network conditions interrupt playback, the player will have additional buffered content before playback fails, allowing for recovery time before the viewer's experience is affected\.

1. \(Optional\) In **Profile**, specify a DASH profile, like HbbTV\.

   Choose from the following:
   + **None** – the output doesn't use a DASH profile
   + **Hbbtv 1\.5** – the output is HbbTV\-compliant

You can't change the values on **Manifest layout** and **Segment template format**\. AWS Elemental MediaPackage supports only the default format for outbound DASH manifests for VOD content\.