# Creating a SMIL File<a name="supported-inputs-vod-smil"></a>

When you send an VOD MP4 asset to AWS Elemental MediaPackage, you have to include a Synchronized Multimedia Integration Language \(SMIL\) file as well\. This `.smil` file acts as a wrapper for all of the files that are part of the asset\. 

MediaPackage supports the following attributes in a `.smil` file:
+ `name`
+ `src`
+ `language`
+ `systemLanguage`

**Example Supported SMIL Structure**  
The following is an example of a `.smil` manifest that MediaPackage supports\. It references video files `ExampleHigh`, `ExampleMid`, and `ExampleLow` and captions file `ExampleCC`\.  

```
<?xml version="1.0" encoding="utf-8"?>
<smil>
    <head></head>
    <body>
        <switch>
            <video name="ExampleHigh.mp4" />
            <video name="ExampleLow.mp4" />
            <video name="ExampleMid.mp4" />
            <textstream src="ExampleCC.srt" systemLanguage="eng"/>
    </switch>
  </body>
</smil>
```