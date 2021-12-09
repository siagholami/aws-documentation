# Lumberyard Release Notes – Beta 1.13 (March 2018)<a name="lumberyard-v1.13"></a>

Lumberyard Beta 1.13 adds over 200 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-13/).

**Topics**
+ [Highlights](#lumberyard-v1.13-highlights)
+ [Improvements and Changes](lumberyard-v1.13-improvements-changes.md)
+ [Fixes](lumberyard-v1.13-fixes.md)
+ [Known Issues](lumberyard-v1.13-known-issues.md)

## Highlights<a name="lumberyard-v1.13-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.13.

**Topics**
+ [New Lumberyard PhysX System](#lumberyard-v1.13-highlights-physics-system)
+ [Navigation Components for the Component Entity System](#lumberyard-v1.13-highlights-navigation-components)
+ [Cross-Communication Feature for Cloud Gems](#lumberyard-v1.13-highlights-cloud-canvas)
+ [Major Changes to Lumberyard Documentation](#lumberyard-v1.13-highlights-documentation)
+ [New Configuring the Cloud Tutorials](#lumberyard-v1.13-highlights-tutorials)
+ [New Amazon GameLift Features](#lumberyard-v1.13-highlights-amazon-gamelift)
+ [SDK Compatibility](#lumberyard-v1.13-highlights-compatible-sdk-versions)

### New Lumberyard PhysX System<a name="lumberyard-v1.13-highlights-physics-system"></a>

Lumberyard 1.13 introduces the preview release of a new physics system that acts upon entities to create realistic physical effects such as collision detection and rigid body dynamics simulation. You can try the new physics system by enabling the **PhysX** gem in the **Project Configurator** and adding the following components to your entities:
+ **PhysX Collider** – Provides collision response by linking the entity's **PhysX Mesh Shape** or shape component with its assigned **PhysX Rigid Body Physics** motion type.
+ **PhysX Mesh Shape** – Provides the geometry of the collision area.
+ **PhysX Rigid Body Physics** – Defines the entity as a rigid object and allows you to choose the motion type. A static motion type means that the object is not movable. A dynamic motion type means that the object is movable based on parameters that define how the object interacts with other objects.

A Physics Samples project provides sample levels that demonstrate how to use the new physics features. For example, the PhysX Rigid Body sample shows you how to use the following PhysX rigid bodies: boxes, spheres, capsules, convex meshes, and static triangular mesh objects.

For more information, see [PhysX System](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-intro.html) in the Amazon Lumberyard User Guide.

### Navigation Components for the Component Entity System<a name="lumberyard-v1.13-highlights-navigation-components"></a>

Lumberyard 1.13 adds the following components:
+ **Navigation Area** – Use this component to define a navigable area or volume for the AI system to use. For more information, see [Navigation Area](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-nav-area.html) in the *Amazon Lumberyard User Guide*.  
![\[Navigable area created using the Navigation Area component.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/navigation-area-component.png)
+ **Navigation Seed** – Use this component with the **Navigation Area** component to specify the areas of the navigation mesh that AI agents can access. For more information, see [Navigation Seed](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-nav-seed.html) in the *Amazon Lumberyard User Guide*.  
![\[Navigation mesh area that AI agents can access.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/navigation-seed-component.png)

### Cross-Communication Feature for Cloud Gems<a name="lumberyard-v1.13-highlights-cloud-canvas"></a>

Lumberyard 1.13 introduces the following Cloud Canvas features:

**Cross-Gem Communication**  
Cloud gems can use the cross-communication feature to expose their API operations to one another and use each other's backend services. You can also use cloud gem cross-communication to notify multiple gems when an event occurs. For example, Lumberyard's Player Account cloud gem provides a banned player service that the Leaderboard cloud gem can use to limit fraudulent scores. The web service interface is defined in a cloud gem `swagger.json` file that can be called from an AWS Lambda function. For more information, see [Cross-Gem Communication](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cgf-service-api-cross-gem-communication.html) in the *Amazon Lumberyard User Guide*.

**Custom Resource Framework**  
Cloud Canvas supports custom resources and AWS services that are supported by AWS CloudFormation. You can add custom resource types and AWS services to a cloud gem's `project-template.json` file and `resource-template.json` file. This eliminates the need to hard code non-native resource types and helps to increase security. For more information, see [Adding Support for New AWS:: and Custom:: Types](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cgf-adding-aws-resources-adding-support-for-new-aws-and-custom-types.html) in the *Amazon Lumberyard User Guide*.

### Major Changes to Lumberyard Documentation<a name="lumberyard-v1.13-highlights-documentation"></a>

Based on customer feedback about content discoverability, the Lumberyard documentation team has made the following improvements:
+ Combined the user guide and the developer guide into a [single guide](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-intro.html). This makes it easier for you to search for the information that you want.
+ Separated the legacy content into a [legacy reference](https://docs.aws.amazon.com/lumberyard/latest/legacyreference/introduction.html). This removes the confusion of having information for new and legacy systems and tools in the same guide.
+ Reorganized the parent-level sections to better follow a game development workflow.
+ Updated the parent-level topic titles to be task-based.

You can access the combined guide and legacy reference from the [Lumberyard documentation landing page](https://aws.amazon.com/documentation/lumberyard/).

![\[Updated Lumberyard documentation landing page.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/lumberyard-documentation-landing-page.png)

You can search the documentation in Lumberyard Editor.

![\[Search the documentation in Lumberyard Editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/lumberyard-editor-documentation-search-option.png)

Lumberyard documentation is available in Chinese, English, French, German, Japanese, Korean, Portuguese (Brazil), and Spanish. 

![\[Language support for Lumberyard documentation.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/release-notes-language-support.png)

### New Configuring the Cloud Tutorials<a name="lumberyard-v1.13-highlights-tutorials"></a>

You can use the following video tutorials to learn how to implement cloud-connected features in your Lumberyard game project.

**AWS Signup Process Walkthrough**  

**Setting up Lumberyard and AWS to Use Cloud Gems**  

**Adding and Deploying Cloud Gem Resources in Lumberyard**  

**Adding a Message of the Day in Lumberyard Using Cloud Gems**  

To follow the steps in this video, download the [MOTD\_Educational\_Demo.lua file](https://d3bqhfbip4ze4a.cloudfront.net/MOTD_Educational_Demo.lua). Save this file in the `lumberyard_version\dev\StarterGame\Scripts\UI` directory.

### New Amazon GameLift Features<a name="lumberyard-v1.13-highlights-amazon-gamelift"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).

### SDK Compatibility<a name="lumberyard-v1.13-highlights-compatible-sdk-versions"></a>

Lumberyard 1.13 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.1.13
+ Amazon GameLift Server SDK version 3.1.5