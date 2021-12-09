# Printing from a WorkSpace<a name="printing"></a>

The following printing methods are supported by Amazon WorkSpaces\.

**Note**  
The Amazon WorkSpaces clients for iPad, Android, Chromebook, and Linux support cloud printing services\. Local and network printing are not currently supported for the iPad, Android, Chromebook, and Linux clients\.  
Amazon Linux WorkSpaces support network printers and cloud printing services\. Local printer redirection is not available for Linux WorkSpaces or the Linux client\. 

**Topics**
+ [Local Printers](#local_printers)
+ [Other Printing Methods](#other_printing)

## Local Printers<a name="local_printers"></a>

Amazon WorkSpaces supports local printer redirection\. When you print from an application in your WorkSpace, the local printers are contained in your list of available printers\. The local printers have "\(Local – *workspace username*\.*directory name*\.*client computer name*\)" appended to the printer's display name\. Select one of the local printers and your documents are printed on that printer\.

In some cases, you need to download and install the driver for your local printer manually on the WorkSpace\. When you install a printer driver on your WorkSpace, there are different types of drivers that you might encounter:
+ Add Printer wizard driver\. This driver includes only the printer drivers, and is for users who are familiar with installation using the Add Printer wizard in Windows\.
+ Printer model\-specific drivers that do not require communication with the printer\. In these cases, you can install the printer driver directly\.
+ Printer model\-specific drivers that require communication with the printer\. In these cases, you can use the printer driver files to add a local printer using an existing port \(LPT1:\)\. After selecting the port, you can choose **Have Disk** and select the `.INF` file for the printer driver\.

After installing the printer driver, you must restart the WorkSpace for the new printer to be recognized\.

If you cannot print to your local printer from your WorkSpace, make sure that you can print to your local printer from your client computer\. If you cannot print from your client computer, refer to the printer documentation and support to resolve the issue\. If you can print from your client computer, contact [AWS Support](https://console.aws.amazon.com/support/home#/) for further assistance\.

## Other Printing Methods<a name="other_printing"></a>

You can also use one of the following methods to print from a WorkSpace:
+ In a connected directory, you can attach your WorkSpace to network printers that are exposed through Active Directory\.
+ Use a cloud printing service, such as [HP Mobile Printing](https://www8.hp.com/us/en/printers/mobility/overview.html)\.
+ Print to a file, transfer the file to your local desktop \(such as by emailing the file or by using [ Amazon WorkDocs](https://docs.aws.amazon.com/workdocs/latest/userguide/what_is.html)\), and print the file locally to an attached printer\.