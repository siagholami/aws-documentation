# File Extension<a name="macie-classify-objects-file-extension"></a>

Once Macie begins monitoring your data, it uses several automatic content classification methods to identify and prioritize your sensitive and critical data and to accurately assign business value to your data\. One of these methods is classifying by file extension\.

Macie can also classify your objects by their file extensions\. Macie offers a set of managed file extensions, each with a designated risk level between 1 and 10, with 10 being the highest risk and 1 being the lowest\.

Macie can assign only one file extension to an object\.

You can't modify existing or add new file extensions\. You can enable or disable any existing file extensions, thus enabling or disabling Macie to assign them to your objects during the classification process\.<a name="enable-disable-file-extensions"></a>

**To view, enable, or disable file extensions**

1. In the Macie console, navigate to the **Settings** page\.

1. In the **Classify data** section, choose **File extensions**\.

1. Choose any of the listed managed file extensions to view its details\.

   To enable or disable a file extension, on its details page, use the **Enabled/Disabled** dropdown and choose **Save**\.

The following is the complete list of file extensions that Macie can assign to your objects during classification\.


|  |  |  |  | 
| --- |--- |--- |--- |
| Name  | Description | Classification | Risk | 
| 7z | 7\-Zip compressed file | Archive and compressed | 3 | 
| abc | SolidWorks CAD | Design | 5 | 
| accdb | Microsoft Access database | Data records | 6 | 
| apk | Application installable on Android | Archive and compressed | 1 | 
| bat | Batch file | Source code | 5 | 
| bin | Compressed archive\. Readable by Java\. Extractable by 7\-zip | Archive and compressed | 3 | 
| bz2 | Bzip2 compressed archive | Archive and compressed | 3 | 
| bzip2 | Bzip2 compressed archive | Archive and compressed | 3 | 
| c | C source code | Source code | 5 | 
| c\# | C\# source code | Source code | 5 | 
| cab | Microsoft cabinet\. Extractable via ZIP | Archive and compressed | 3 | 
| cc | C\+\+ source code | Source code | 5 | 
| cer | PKI certificate | Keychain | 6 | 
| cpp | C\+\+ source code | Source code | 5 | 
| csv | Comma Separated Values | Data records | 6 | 
| cxx | C\+\+ source code | Source code | 5 | 
| dbf | dBase database | Data records | 6 | 
| dbx | Microsoft Outlook Express | Email data | 6 | 
| deb | Debian Linux install package | Archive and compressed | 1 | 
| dmg | Apple OS X Application Installer | Executable | 1 | 
| doc | Microsoft Word | Document | 1 | 
| docx | Microsoft Word | Document | 1 | 
| dot | Microsoft Word | Document | 1 | 
| dotx | Microsoft Word | Document | 1 | 
| dwg | AutoDesk CAD | Design | 5 | 
| dxf | AutoCAD | Design | 5 | 
| eml | MIME email | Email data | 5 | 
| emlx | Apple Mail email message | Email data | 5 | 
| exe | Microsoft Windows PE Executable | Executable | 1 | 
| gpg | PGP certificate | Keychain | 5 | 
| gz | GNU Zip compressed archive | Archive and compressed | 3 | 
| gzip | GNU Zip compressed archive | Archive and compressed | 3 | 
| html | Hyper Text Markup Language | Source code | 3 | 
| iwa | Apple iWork document archive file | Archive and compressed | 1 | 
| jar | Java source code archive | Source code | 5 | 
| java | Java source code | Source code | 5 | 
| json | Java Script Object Notation Values \(JSON\) | Data records | 5 | 
| key | Apple Keynote Presentation | Presentation | 1 | 
| keynote | Apple Keynote Presentation | Presentation | 1 | 
| lua | Lua source code | Source code | 3 | 
| mdb | Microsoft Access database | Data records | 6 | 
| msg | Microsoft Outlook Message | Email data | 5 | 
| msi | Microsoft Windows Application Installer | Executable | 1 | 
| odp | OpenOffice\.org OpenDocument presentation file | Presentation | 1 | 
| oos | OpenOffice\.org spreadsheet file | Spreadsheet | 1 | 
| p12 | PKI certificate | Keychain | 5 | 
| pages | Apple Pages | Document | 1 | 
| pdf | Adobe PDF | Document | 1 | 
| perl | Perl source code | Source code | 5 | 
| pgp | PGP certificate | Keychain | 5 | 
| pl | Perl source code | Source code | 5 | 
| pot | Microsoft PowerPoint | Presentation | 1 | 
| pps | Microsoft PowerPoint | Presentation | 1 | 
| ppt | Microsoft PowerPoint | Presentation | 1 | 
| pptx | Microsoft PowerPoint | Presentation | 1 | 
| pst | Microsoft Outlook | Email data | 8 | 
| py | Python source code | Source code | 5 | 
| rar | RAR archive\. Extractable by 7\-zip | Archive and compressed | 3 | 
| rtf | Rich Text Format | Document | 1 | 
| sdp | OpenOffice\.org presentation file | Presentation | 1 | 
| sdw | OpenOffice\.org text document file | Document | 1 | 
| sldasm | SolidWorks CAD | Design | 5 | 
| slddrw | SolidWorks CAD | Design | 5 | 
| sldprt | SolidWorks CAD | Design | 5 | 
| sql | Structured Query Language | Source code | 5 | 
| sxi | OpenOffice\.org presentation file | Presentation | 1 | 
| sxw | OpenOffice\.org Writer document file | Document | 1 | 
| tar\.gz | GNU Zip compressed archive | Archive and compressed | 3 | 
| tsv | Tab Separated Values | Data records | 6 | 
| txt | Text Document | Document | 1 | 
| vdx | Microsoft Visio | Design | 1 | 
| vsd | Microsoft Visio | Design | 1 | 
| vss | Microsoft Visio | Design | 1 | 
| vst | Microsoft Visio | Design | 1 | 
| vsx | Microsoft Visio | Design | 3 | 
| vtw | Microsoft Visio | Design | 1 | 
| vtx | Microsoft Visio | Design | 3 | 
| xls | Microsoft Excel | Spreadsheet | 1 | 
| xlsx | Microsoft Excel | Spreadsheet | 1 | 
| xlw | Microsoft Excel | Spreadsheet | 1 | 
| xml | Extensible Markup Language \(XML\) | Data records | 3 | 
| xps | Open XML document specification | Document | 1 | 
| zip | ZIP compressed archive | Archive and compressed | 3 | 