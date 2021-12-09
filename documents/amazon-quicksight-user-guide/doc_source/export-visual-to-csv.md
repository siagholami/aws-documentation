# Exporting Data from an Amazon QuickSight Visual to a CSV File<a name="export-visual-to-csv"></a>

Use the following procedure to export data from a visual to a file with the comma\-separated value \(CSV\) format\. 

For table charts, Amazon QuickSight supports exporting up to 1 million rows or 500 MB of data, whichever limit is reached first\. For other visuals, the same limits apply to exporting that apply to the visual type\. The export contains only the fields and the filtered data that are currently displayed in the visual\. 

1. Choose or create an analysis or dashboard that contains one or more visuals\. 

1. Choose the visual that you want to export\. 

1.  Choose the on\-visual menu, at the upper right of the visual\. Then choose **Export to CSV**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/export-visual-to-csv.png)

1.  Depending on your browser settings, one of the following happens: 
   +  The file automatically goes to your default **Download** location\. 
   +  A dialog box appears so you can choose a file name and location\. 
   +  A dialog box appears so you can choose to open the file with the default software or to save the file\. If you choose to save, you can choose a file name and location\. 

   You can provide a name for the downloaded file\. By default, the CSV file name is the name of your visual\. To make the file name unique, it has a sequential timestamp \(a Unix epoch data type\) or a date in the format `yyyy-MM-dd_THH_mm_ss.SSSZ`\. 

1. To export data from additional visuals in the same analysis or dashboard, repeat this process for each visual\. 

**Tip**  
If you have difficulty getting the download to start, try a different browser\.