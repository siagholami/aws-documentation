# Adding Custom URL Actions to Visuals in Amazon QuickSight<a name="custom-url-actions"></a>

You can use URL schemes to perform an action, based on a URL, from within your dashboard\. In some cases, you might want to create a link to another URL from your visual, or you might want to create an email directly from a visual\. Users viewing the dashboard can use a URL action to send data points to other URLs \(dashboards, analyses, and websites\) by using the data point context menu\. 

To use an existing URL action, choose a data point on a visual\. When you hover over the data point, a notification appears regarding that data point\. To get the URL action menu, choose the data point to bring up the context menu\. You can find URL actions listed in the middle of the context menu, just above **Color** options\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/url-actions-using-the-context-menu.png)

You can create URL actions on all visual types except pivot tables and KPIs\. However, if you create a URL action, then change your visual type to one of these, your URL action isn't deleted\. It's simply not accessible from these visual types\. URL actions can be deep links into another application, so long as each can be accessed by a valid URL in the URL scheme `https`, `http`, or `mailto`\. You can create a maximum of 100 URL actions per visual\.

Create or edit a URL action by using the following procedure\. 

1. Open a visual\. Choose the `v`\-shaped at the top right of the visual to display the on\-visual menu\. Choose **URL actions**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/url-action-menu.png)

   If this is the first action for this visual, the **URL action** screen opens\. If one or more actions already exist, the **URL actions for this visual** screen appears, which lists all existing actions\. 

1. Do the following to name and define a URL for your URL action:
   + For **Action name**, type a custom name for your URL action\. This name appears in the context menu when you choose a data point in the visual\.
   + Define the URL that you want to open as part of the URL action\. The URL must be part of one of the following schemes: 
     + `https://`
     + `http://`
     + `mailto:`
   + You can also parameterize the URL to include dynamic values\. The parameters on both the sending and the receiving end should match in name and data type\. To use a parameter in a custom URL action, use the name of the parameter prefixed with a `$` and enclosed in angle brackets `<< >>`, for example `<<$parameterName>>`\. Select a value or a parameter from the current visual by choosing the **\+** on the right\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/url-action-1.png)

1. Choose **Add URL action** to save your changes\. 

1. Edit the action name and URL by choosing the pencil icon near the name of the URL action\. Or, add a new URL action by choosing **Add URL action**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/url-action-2.png)

1. After you finish making changes, you can close the screen by choosing either **X** or **Cancel**\.

For more information on using parameters, see [Parameters in Amazon QuickSight](parameters-in-quicksight.md)\. 