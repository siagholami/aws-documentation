# Creating a Custom Terminology<a name="creating-custom-terminology"></a>

You can use either a CSV file or a TMX file with the source text and the target \(translated\) term for the terminology file\. A single source text is used for each term, but there can be multiple target terms, one for each language, as long as the target and source language can be used\.

**CSV \(comma separated values\)**

The first column contains the source text, and the other columns contain the target translations\. The first row consists of the language codes, with the source language in the first columns, and target language translations in the others\.


|  |  |  |  | 
| --- |--- |--- |--- |
| en | fr | de | es | 
| Amazon | Amazon | Amazon | Amazon | 

**TMX \(Translation Memory eXchange\) **

A TMX file is an XML\-type file commonly used by translation software\. Although the form is different than the CSV, the content is similar:

```
<?xml version="1.0" encoding="UTF-8"?>
<tmx version="1.4">
 <header
    creationtool="XYZTool" creationtoolversion="0"
    datatype="PlainText" segtype="sentence"
    adminlang="en-us" srclang="en"
    o-tmf="test"/>
 <body>
   <tu>
     <tuv xml:lang="en">
       <seg>Amazon</seg>
     </tuv>
     <tuv xml:lang="fr">
       <seg>Amazon</seg>
     </tuv>
     <tuv xml:lang="de">
       <seg>Amazon</seg>
     </tuv>
     <tuv xml:lang="es">
       <seg>Amazon</seg>
     </tuv>
   </tu>   
 </body>
</tmx>
```

These files are then attached to your Amazon Translate account\. When a translation job is run and you choose to use the custom terminology, Amazon Translate then uses the designated word whenever it encounters the source word\.

**Important**  
The source word within a custom terminology is *case\-sensitive* and will not work for words that are not an exact match\.