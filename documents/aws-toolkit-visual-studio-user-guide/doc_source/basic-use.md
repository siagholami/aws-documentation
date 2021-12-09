# Using the Toolkit for Visual Studio<a name="basic-use"></a>

## Profiles and Toolkit for Visual Studio Window Binding<a name="profiles-and-tvs-window-binding"></a>

The AWS Explorer window is bound to a single profile and region at a time\.
+ Windows opened from the AWS Explorer use the current bound profile and region\. Once the window is open, you can switch to another profile or region in the AWS Explorer\.
+ Publish and other wizards default to the profile and region of the AWS Explorer\. You can change them\. Any resources created by the wizard, or windows opened when the wizard closes, will continue to use the profile and region selected in the wizard\.
+ If you have multiple Visual Studio open, each can be bound to a different profile and region\. The AWS Explorer saves the last\-used profile and region\. The last Visual Studio instanced closed will have its values persisted\.