# Customer Onboarding<a name="customer-onboarding"></a>

Protect your content from unauthorized use by combining a Secure Packager and Encoder Key Exchange \(SPEKE\) digital rights management \(DRM\) key provider with your encryptor and with your media players\. SPEKE defines the standard for communication between encryptors and packagers of media content and digital rights management \(DRM\) key providers\. To onboard, you choose a DRM platform key provider and configure the communication between the key provider and your encryptors and players\. 

**Topics**
+ [Get On Board with a DRM Platform Provider](#choose-drm-system)
+ [SPEKE Support in AWS Services and Products](#check-supported-technologies)

## Get On Board with a DRM Platform Provider<a name="choose-drm-system"></a>

The following Amazon partners provide third\-party DRM platform implementations for SPEKE\. For details about their offerings and information about how to contact them, follow the links to their Amazon Partner Network pages\. Partners that don't have a link don't currently have an Amazon Partner Network page, but you can contact them directly\. The partners can help you get set up to use their platforms\. 
+ Axinom
+ [BuyDRM](https://aws.amazon.com/partners/find/partnerdetails/?n=BuyDRM&id=001E000000UfZXLIA3) 
+ [castLabs](https://aws.amazon.com/partners/find/partnerdetails/?n=castLabs&id=001E000001Bv2lcIAB)
+ [Conax AS](https://aws.amazon.com/partners/find/partnerdetails/?n=Conax%20AS&id=0010L00001nEJPEQA4)
+ [EZDRM](https://aws.amazon.com/partners/find/partnerdetails/?n=EZDRM&id=001E000000UfZgxIAF)
+ [INKA Entworks](https://aws.amazon.com/partners/find/partnerdetails/?n=INKA%20Entworks%20Inc%2C&id=001E000000qGr8GIAS)
+ [Insys Video Technologies](https://aws.amazon.com/partners/find/partnerdetails/?n=INSYS&id=0010L00001jS1XHQA0)
+ [Intertrust Technologies](https://aws.amazon.com/partners/find/partnerdetails/?n=Intertrust%20Technologies&id=0010L00001o9pcfQAA)
+ [Irdeto](https://aws.amazon.com/partners/find/partnerdetails/?n=Irdeto&id=001E000000Rl0x2IAB)
+ [Kaltura](https://aws.amazon.com/partners/find/partnerdetails/?n=Kaltura&id=001E000000Rp5FnIAJ)
+ [NAGRA](https://aws.amazon.com/partners/find/partnerdetails/?n=Nagravision%20SA%20-%20Kudelski%20Group&id=0010L00001sC6iuQAC)
+ [NEXTSCAPE, Inc\.](https://aws.amazon.com/partners/find/partnerdetails/?n=NEXTSCAPE%20INC.&id=0010L00001u4MbTQAU)
+ [Verimatrix](https://aws.amazon.com/partners/find/partnerdetails/?n=Verimatrix&id=001E000000be2SEIAY)
+ Viaccess\-Orca
+ VUALTO
+ WebStream

## SPEKE Support in AWS Services and Products<a name="check-supported-technologies"></a>

This section lists the SPEKE support that is provided by AWS Media Services that run in the AWS Cloud and by AWS on\-premises media products\. Verify that your streaming protocol and the DRM system that you want are available for your service or product\.


**AWS Elemental MediaConvert \- Service That Runs in the AWS Cloud**  

| Support matrix for protocol and DRM system | Microsoft PlayReady | Google Widevine | Apple FairPlay | AES\-128 | 
| --- | --- | --- | --- | --- | 
| DASH | √ | √ |  |  | 
| Apple HLS |  |  | √ | √ | 
| Microsoft Smooth | √ |  |  |  | 


**AWS Elemental MediaPackage \- Service That Runs in the AWS Cloud**  

| Support matrix for protocol and DRM system | Microsoft PlayReady | Google Widevine | Apple FairPlay | AES\-128 | 
| --- | --- | --- | --- | --- | 
| DASH | √ with key rotation | √ with key rotation |  |  | 
| Apple HLS |  |  | √ with key rotation | √ with key rotation | 
| Microsoft Smooth | √ |  |  |  | 
| CMAF Apple HLS |  |  | √ with key rotation |  | 


**AWS Elemental Live \- On\-premises Product**  

| Support matrix for protocol and DRM system | Microsoft PlayReady | Google Widevine | Apple FairPlay | AES\-128 | 
| --- | --- | --- | --- | --- | 
| DASH | √ | √ |  |  | 
| Apple HLS TS |  |  | √ with key rotation | √ with key rotation | 
| Apple HLS fMP4 |  |  | √ with key rotation |  | 


**AWS Elemental Delta \- On\-premises Product**  

| Support matrix for protocol and DRM system | Microsoft PlayReady | Google Widevine | Apple FairPlay | AES\-128 | 
| --- | --- | --- | --- | --- | 
| DASH | √ with key rotation | √ with key rotation |  |  | 
| Apple HLS |  |  | √ with key rotation | √ with key rotation | 
| Microsoft Smooth | √ |  |  |  | 
| CMAF Apple HLS |  |  | √ with key rotation |  | 