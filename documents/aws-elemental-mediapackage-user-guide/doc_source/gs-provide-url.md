# Step 5: Provide Playback URLs<a name="gs-provide-url"></a>

After creating the asset resource, AWS Elemental MediaPackage prepares to serve the packaged manifests to viewers\. This happens in the background and might take some time depending on the size and complexity of the source content, but is usually less than a few minutes\. The URLs of the manifests are available immediately on the asset's details page, but content is not yet available for playback\.

After the processing for each manifest is complete, MediaPackage sends an Amazon CloudWatch event to your account\.

On the asset, MediaPackage provides a URL for each packaging configuration\. This URL is how downstream devices \(CDN or playback device\) request VOD content from MediaPackage\.

**To get playback URLs**

1. On the MediaPackage console, go to the **Assets** page and choose the **ID** of the asset that you created in [Step 4: Create an Asset](gs-create-asset.md)\.

1. On the asset's detail page, get the URL for each packaging configuration\.

1. Provide the URLs to the person in charge of the downstream device \(CDN or player\)\. In the downstream device, this person must enter the request destination as the URL from the corresponding packaging configuration\.

Each URL is stable\. It never changes during the lifetime of the combination of this asset and packaging configuration\. Provide the URL to the person in charge of the downstream device \(CDN or player\)\. In the downstream device, this person must use the asset's URL as the request destination\.