# Adding assets to projects<a name="add-assets-to-projects-ea"></a>

As a portal administrator, you decide how to assign your AWS IoT SiteWise assets to projects\. You give access to users at the project level, so you should group related assets into projects that will have a common set of viewers\.

**Note**  
You can only add assets to a project if you're a portal administrator\. Project owners and viewers can explore the assets in the projects to which they have access, but can't add assets to the project\.

You can add assets to an existing project or you can create a project for the chosen assets\.

## Adding assets to a new project<a name="add-assets-new-project-ea"></a><a name="add-assets-new-project"></a>

1. In the navigation bar, choose the **Assets** icon\.  
![\[The "Assets" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-asset-library-console.png)

1. <a name="asset-library-choose-project"></a>\(Optional\) Choose a project in the projects drop\-down list to show only assets from a specific project\.  
![\[The "Assets" page, with the projects drop-down list called out.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-choose-project-console.png)

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

## Adding assets to an existing project<a name="add-assets-existing-project-ea"></a><a name="add-assets-existing-project"></a>

1. In the navigation bar, choose the **Assets** icon\.  
![\[The "Assets" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-asset-library-console.png)

1. <a name="asset-library-choose-project"></a>\(Optional\) Choose a project in the projects drop\-down list to show only assets from a specific project\.  
![\[The "Assets" page, with the projects drop-down list called out.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-choose-project-console.png)

1. <a name="asset-library-choose-asset"></a>Choose an asset in the **Assets** hierarchy, and then choose **Add asset to project**\.  
![\[The "Assets" page with the asset hierarchy and "Add assets to project" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-add-asset-to-project-console.png)
**Note**  
You can add only a single node hierarchy \(an asset and all assets that are subordinate to that asset\) to a project\. To create a dashboard to compare two assets that are children of a common parent asset, add that common parent to the project\.

1. In the **Add assets to project** dialog box, choose **Select existing project**, and then choose the project to add the assets\.  
![\[Add assets to project dialog.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/asset-library-add-assets-to-existing-project-console.png)

1. <a name="asset-library-finish-adding-asset"></a>Choose **Add asset to project**\.

   The **Create new project** dialog box closes, and the new project's page opens\.

## Removing assets from a project<a name="remove-project-assets-ea"></a>

<a name="remove-assets-project-intro"></a>As a portal administrator, you can remove assets from projects if you no longer need them\.<a name="remove-assets-project-procedure"></a>

**To remove assets from a project**

1. In the navigation bar, choose the **Projects** icon\.  
![\[The "Projects" icon in the navigation bar.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/portal-navigation-projects-console.png)

1. On the **Projects** page, choose the project to remove assets from\.  
![\[The "Projects" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/projects-portal-admin-choose-project-console.png)

1. Choose **Remove all assets from project**\.  
![\[The "Projects" page.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/project-remove-all-assets-console.png)

1. In the dialog box, confirm that you want to remove the assets\.