# Troubleshooting Amazon QuickSight<a name="troubleshooting"></a>

 Use this information to help you diagnose and fix common issues that you can encounter when using Amazon QuickSight\. 

**Note**  
 Need more help? You can visit the Amazon QuickSight [User Community](https://answers.quicksight.aws.amazon.com/sn/index.html) or the [AWS forums](https://forums.aws.amazon.com)\. See also the [Amazon QuickSight Resource Library](https://aws.amazon.com/quicksight/resource-library/)\. 

**Topics**
+ [I Can't Connect to My Data Source](troubleshoot-connect-to-datasources.md)
+ [My Rows Were Skipped During Data Preparation](troubleshooting-skipped-rows.md)
+ [My SPICE Data Doesn't Sort Alphabetically](troubleshoot-sorting-SPICE.md)
+ [I Can't Add a Visual to My Analysis](troubleshoot-adding-visuals.md)
+ [I Get a Feedback Bar Across My Printed Docs](troubleshoot-printing-docs.md)
+ [How Do I Delete My Amazon QuickSight Account?](#troubleshoot-delete-quicksight-account)
+ [My Map Charts Don't Show Locations](#troubleshoot-geocoding)
+ [Amazon QuickSight Isn't Working in My Browser](#troubleshoot-browser)
+ [Troubleshooting Issues When Using Athena with Amazon QuickSight](troubleshoot-athena.md)

## How Do I Delete My Amazon QuickSight Account?<a name="troubleshoot-delete-quicksight-account"></a>

If you need to delete your Amazon QuickSight account, even when you can't access Amazon QuickSight to unsubscribe, sign in to AWS and use the following link to open [the unsubscribe screen](https://us-east-1.quicksight.aws.amazon.com/sn/console/unsubscribe): `https://us-east-1.quicksight.aws.amazon.com/sn/console/unsubscribe`\. This approach works no matter what AWS Regions you use\. It deletes all data, analyses, Amazon QuickSight users, and Amazon QuickSight administrators\. If you have further difficulty, contact support\. 

## My Map Charts Don't Show Locations<a name="troubleshoot-geocoding"></a>

For automatic mapping, called geocoding, to work on map charts, your data must be prepared following specific rules\. For help with geospatial issues, see [Geospatial Troubleshooting](geospatial-troubleshooting.md)\. For help with preparing data for geospatial charts, see [Adding Geospatial Data](geospatial-data-prep.md)\.

## Amazon QuickSight Isn't Working in My Browser<a name="troubleshoot-browser"></a>

If you can't view Amazon QuickSight correctly in your Chrome browser, follow these steps to fix the problem:

1. Open Chrome and navigate to `chrome://flags/#touch-events`\. 

1. If the option is set to **Automatic**, change it to **Disabled** 

1. Close and reopen Chrome\.