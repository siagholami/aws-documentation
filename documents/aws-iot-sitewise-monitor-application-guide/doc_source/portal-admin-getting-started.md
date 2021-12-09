# Getting started as an AWS IoT SiteWise Monitor portal administrator<a name="portal-admin-getting-started"></a>

As the portal administrator, you create projects and associate assets with those projects\. You specify an owner for each project\. The project owner can then create dashboards with visualizations of the property values\. Only portal administrators can create projects, assign owners, and change the list of assets associated with each project\. As the portal administrator, you can do the following tasks:
+ [Signing in to a portal](getting-started.md#portal-login)
+ [Exploring asset data and adding assets to projects](#portal-admin-exploring-assets)
+ [Assigning owners to the project](#portal-admin-inviting-owners)
+ [Getting started as a project owner](project-owner-getting-started.md)

## Exploring asset data and adding assets to projects<a name="portal-admin-exploring-assets"></a>

You can explore the list of assets to which you have access to view their properties, and compare property values between two assets\. As the portal administrator, you can add assets to a project to make them available to the project owner\. The project owner can then create dashboards to give other subject matter experts a common view of the asset properties\.

The following procedure assumes that you signed in the AWS IoT SiteWise Monitor portal\.

**To explore asset data and add asset to projects**

1. In the navigation bar, choose the **Assets** icon\.  
![\[The "Assets" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-asset-library-console.png)

   The **Assets** page appears\.  
![\[The "Assets" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-portal-admin-console.png)

   See the following areas of the page\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/portal-admin-getting-started.html)

1. <a name="asset-library-choose-asset"></a>Choose an asset in the **Assets** hierarchy, and then choose **Add asset to project**\.  
![\[The "Assets" page with the asset hierarchy and "Add assets to project" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-add-asset-to-project-console.png)
**Note**  
You can add only a single node hierarchy \(an asset and all assets that are subordinate to that asset\) to a project\. To create a dashboard to compare two assets that are children of a common parent asset, add that common parent to the project\.

1. <a name="asset-library-create-new-project"></a>In the **Add assets to project** dialog box, choose **Create new project**, then choose **Next**\.  
![\[Add assets to project dialog, step 1 of 2.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-add-assets-to-new-project-console.png)

1. <a name="asset-library-new-project-enter-project-name"></a>In **Project name**, enter a name for your project\. If you plan to create multiple projects, each with a distinct set of assets, choose a descriptive name\.  
![\[Add assets to project dialog, step 2 of 2.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-create-new-project-console.png)

1. <a name="asset-library-new-project-enter-project-description"></a>In **Project description**, enter a description of the project and its contents\.

   You can add project owners after you create the project\.

1. <a name="asset-library-finish-adding-asset"></a>Choose **Add asset to project**\.

   The **Create new project** dialog box closes, and the new project's page opens\.

1. When you're ready to share your project, you can add owners to your project to create dashboards and invite viewers\. You can see and change who you invited to the project on the project details page\. 

## Assigning owners to the project<a name="portal-admin-inviting-owners"></a>

<a name="add-owners-project-intro"></a>As a portal administrator, after you create a project, you can assign project owners\. Project owners create dashboards to provide a consistent way to view your asset data\. You can send an invitation email to assigned project owners when you are ready for them to work with the project\.<a name="add-owners-project"></a>

**To assign owners to a project**

1. In the navigation bar, choose the **Projects** icon\.  
![\[The "Projects" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-projects-console.png)

1. On the **Projects** page, choose the project to which to assign project owners\.  
![\[The "Projects" page with "Create project" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/projects-portal-admin-choose-project-console.png)

1. In the **Project owners** section of the project details page, choose **Add owners** if the project has no owners, or **Edit owners**\.  
![\[The "Project owners" section of the project details page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-add-owners-console.png)

1. In the **Project owners** dialog box, select the check boxes for the users to be owners for this project\.  
![\[Shows the "Project owners" dialog.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-choose-owners-console.png)
**Note**  
You can only add project owners if they're portal users\. If you don't see a user listed, contact your AWS administrator to add them to the list of portal users\.

1. Choose the **>>** icon to add those users as project owners\.

1. Choose **Save** to save your changes\.

<a name="invite-owners-project-intro"></a>Next, you can send emails to your project owners so they can sign in and start managing the project\.<a name="invite-owners-project"></a>

**To send email invitations to project owners**

1. In the navigation bar, choose the **Projects** icon\.  
![\[The "Projects" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-projects-console.png)

1. On the **Projects** page, choose the project for which to invite project owners\.  
![\[The "Projects" page with "Create project" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/projects-portal-admin-choose-project-console.png)

1. In the **Project owners** section of the project details page, select the check boxes for the project owners to receive an email, and then choose **Send invitations**\.  
![\[The "Project owners" section of the project details page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-invite-owners-console.png)

1. Your preferred email client opens, prepopulated with the recipients and the email body with details from your project\. You can customize the email before you send it to the project owners\.