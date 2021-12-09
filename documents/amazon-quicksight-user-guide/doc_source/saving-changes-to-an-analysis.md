# Saving Changes to an Analysis<a name="saving-changes-to-an-analysis"></a>

When working on an analysis, you can set Autosave either on \(the default\) or off\. When Autosave is on, your changes are automatically saved every minute or so\. When Autosave is off, your changes are not automatically saved, which allows you to make changes and pursue different lines of inquiry without permanently altering the analysis\. If you decide that you want to save your results after all, re\-enable Autosave\. Your changes up to that point are then saved\.

In either Autosave mode, you can undo or redo any change you make by choosing **Undo** or **Redo** on the application bar\.

## Changing the Autosave Mode<a name="changing-autosave"></a>

To change the Autosave mode for an analysis, choose the Autosave indicator next to the analysis name and then choose **Autosave ON** or **Autosave OFF**\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/autosave.png)

## When Autosave Can't Save Changes<a name="conflicting-changes"></a>

Suppose that one of the following things occurs: 
+ Autosave is on and another user makes a conflicting change to the analysis\.
+ Autosave is on and there is a service failure, such that your most recent changes can't be saved\.
+ Autosave is off, you turn it on, and one of the backlogged changes now being saved to the server conflicts with another user's changes\.

In this case, Amazon QuickSight gives you the option to do one of two things\. You can either let Amazon QuickSight turn Autosave off and continue working in unsaved mode, or reload the analysis from the server and then redo your most recent changes\. 

If your client authentication expires while you are editing an analysis, you are directed to sign in again\. On successful sign\-in, you are directed back to the analysis where you can continue working normally\.

If your permissions on the analysis are revoked while you are editing it, you can't make any further changes\.