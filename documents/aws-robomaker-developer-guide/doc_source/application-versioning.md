# Application Versioning<a name="application-versioning"></a>

AWS RoboMaker supports creating more than one version of your robot applications and simulation applications\. This helps you control which code your robots and simulations use\. A version is a numbered snapshot of your application\. Create a version to use in different parts of your development workflow\. For example, development, beta deployment, or production\. 

When you version an AWS RoboMaker robot application or simulation application you create a snapshot of the application\. This way you can use the application as it existed when the version was made\. After you create a version it stays the same while you continue to work on your application\.

You can create a maximum of 40 versions per application\.

**Topics**
+ [The $LATEST Version](#latest-version)
+ [Updating an Application Version](#updating-version)
+ [Deleting an Application Version](#delete-version)

## The $LATEST Version<a name="latest-version"></a>

When you create a version, AWS RoboMaker copies the `$LATEST` version to create the new version and increments the version number by 1\. Version numbers are never reused\. For example, if you remove a simulation application numbered version 10 and then recreate it, the next version number AWS RoboMaker assigns to the simulation application is version 11\. 

 When you deploy a robot application, you must select a specific numbered version to deploy\. For more information on how to create a robot application version, see [Creating a Robot Application Version](create-robot-application-version.md)\. 

For more information how to create a simulation application version, see [Creating a Simulation Application Version](create-simulation-application-version.md)\.

## Updating an Application Version<a name="updating-version"></a>

You can update only the `$LATEST` version of an AWS RoboMaker application \. When you do this, it is available to use in AWS RoboMaker\. For example, if you restart a simulation job, the latest version of the applications will be used in the simulation\. 

For more information, see [Updating a Robot Application](update-robot-application.md) and [Updating a Simulation Application](update-simulation-application.md)\.

## Deleting an Application Version<a name="delete-version"></a>

When you no longer need an application version, delete it\. For more information, see [Deleting a Robot Application Version](delete-robot-application-version.md) and [Deleting a Simulation Application Version](delete-simulation-application-version.md)\. 