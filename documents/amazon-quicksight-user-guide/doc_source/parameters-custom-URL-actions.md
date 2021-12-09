# Using Custom URL Actions with Parameters in Amazon QuickSight<a name="parameters-custom-URL-actions"></a>

A *URL action* lets you launch any URL from a data point in a visual, to open another webpage\. You can also pass or send parameters dynamically\. To make this work, you set up a parameter, and then add a custom URL action to the visual\. The parameters on both the sending and the receiving end should match in name and data type\. All parameters are compatible with custom URL actions\.

If you just want to use a parameter in a link, without creating a URL action, see [Using Parameters in a URL](parameters-in-a-url.md)\.

To use a parameter in a custom URL action, select it from the list\. Parameters are prefixed with a `$` and enclosed in angle brackets `<< >>`, for example: `<<$parameterName>>`\.

For details on creating a URL action, see [Adding Custom URL Actions to Visuals in Amazon QuickSight](custom-url-actions.md)\.