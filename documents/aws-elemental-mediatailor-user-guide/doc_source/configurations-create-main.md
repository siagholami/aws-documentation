# Main Configuration Fields<a name="configurations-create-main"></a>

When you create a configuration, you must complete at least the main configuration fields, described here\.

**Configuration name**  
Enter a unique name that describes the configuration\. The name is the primary identifier for the configuration\. The maximum length allowed is 512 characters\.

**Video content source**  
 Enter the URL prefix for the manifest for this stream, minus the asset ID\. The maximum length is 512 characters\.  
For example, the URL prefix `http://origin-server.com/a/` is valid for an HLS master manifest URL of `http://origin-server.com/a/master.m3u8` and for a DASH manifest URL of `http://origin-server.com/a/dash.mpd`\. Alternatively, you can enter a shorter prefix such as `http://origin-server.com`, but the `/a/` must be included in the asset ID in the player request for content\.   
If your content origin uses HTTPS, its certificate must be from a well\-known certificate authority\. \(It can't be a self\-signed certificate\.\) Otherwise, AWS Elemental MediaTailor fails to connect to the content origin and can't serve manifests in response to player requests\.

**Ad decision server**  
 Enter the URL for your ad decision server \(ADS\)\. This is either the URL with variables as described in [Step 3: Configure ADS Request URL and Query Parameters](getting-started.md#getting-started-configure-request), or the static VAST URL that you are using for testing purposes\. The maximum length is 25,000 characters\.  
If your ADS uses HTTPS, its certificate must be from a well\-known certificate authority\. \(It can't be a self\-signed certificate\.\) The same also applies to mezzanine ad URLs returned by the ADS\. Otherwise, AWS Elemental MediaTailor can't retrieve and stitch ads into the manifests from the content origin\.