# Scenarios for Embedding Dashboards with Amazon QuickSight<a name="embedded-dashboards-scenarios"></a>

This section outlines some business scenarios and how Amazon QuickSight applies to them\.

## Scenario 1<a name="embedded-dashboards-scenario-1"></a>

You can embed dashboards in an app\. You can use Amazon QuickSight to build interactive dashboards that are seamlessly embedded in your SaaS app\. Your users log in to the app and securely view customized and easy\-to\-use dashboards\. You don't have to provision servers, manage infrastructure, or develop your own code to create charts\. 

## Scenario 2<a name="embedded-dashboards-scenario-2"></a>

You can embed dashboards in a website where users log in\. Using Amazon QuickSight, you can share interactive data dashboards with all your authenticated intranet users without needing to purchase software for every user or server infrastructure\. Amazon QuickSight runs in the cloud, scales to thousands of users, and offers pay\-per\-session pricing to bring large scale solutions within reach\. The code required to implement embedded dashboards is minimal, and fast to implement\. 

## Scenario 3<a name="embedded-dashboards-scenario-3"></a>

You currently can't embed dashboards in a website where users are anonymous\. If a single user accesses the same dashboard from multiple locations, their usage is automatically throttled\. This means that the first user sees the dashboard, and then the request times out for subsequent users\. This results in an inconsistent user experience until each connection times out\. Embedding dashboards in an anonymous website is not currently supported\.

## Scenario 4<a name="embedded-dashboards-scenario-4"></a>

You can't currently embed dashboards with no connectivity as a static report\. Using embedded dashboards for display only is not supported\. However, if you have this requirement, you could potentially use a screenshot of your visual in your display\. But users can't interact with it, and you have to refresh it using a different mechanism\.