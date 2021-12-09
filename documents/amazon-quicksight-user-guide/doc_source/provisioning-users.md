# Provisioning Users for Amazon QuickSight<a name="provisioning-users"></a>

## Self\-Provisioning an Amazon QuickSight Administrator<a name="assigning-the-admin"></a>

Amazon QuickSight administrators are users who can also manage Amazon QuickSight features such as account settings and user accounts\. They can also purchase additional Amazon QuickSight user subscriptions, purchase [SPICE](welcome.md#spice) capacity, and cancel the subscription to Amazon QuickSight for your AWS account\.

You can use an AWS user or group policy to give users the ability to add themselves as administrators of Amazon QuickSight\. Their accounts become active and billable the first time that they open Amazon QuickSight\. To set up self\-provisioning, you need to give them permission to use the `quicksight:CreateAdmin` action\. For more information about using AWS Identity and Access Management \(IAM\), see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. 

Alternatively, you can use the following procedure to use the console to set or create the administrator for Amazon QuickSight\. 

**To make a user the Amazon QuickSight administrator**

1. Create the AWS user:
   + Use IAM to create the user that you want to be the administrator of Amazon QuickSight\. Alternatively, identify an existing user in IAM for the administrator role\. You can also put the user inside a new group, for manageability\. 
   + Grant the user \(or group\) sufficient permissions, as described in [Setting Your IAM Policy](set-iam-policy.md)\. 

   For more information on working with IAM, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. 

1. Sign in to your AWS Management Console with the target user's credentials\.

1. Go to [http://quicksight.aws.amazon.com/sn/console/get-user-email](http://quicksight.aws.amazon.com/sn/console/get-user-email), type in the target user's email address, and choose **Continue**\.

On success, the target IAM user is now an administrator in Amazon QuickSight\.

## Self\-Provisioning an Amazon QuickSight Author<a name="self-service-access"></a>

Amazon QuickSight authors can create data sources, data sets, analyses, and dashboards\. They can share analyses and dashboards with other Amazon QuickSight users in your Amazon QuickSight account\. However, they don't have access to the **Manage QuickSight** menu\. They can't change account settings, manage user accounts, purchase additional Amazon QuickSight user subscriptions or [SPICE](welcome.md#spice) capacity, or cancel the subscription to Amazon QuickSight for your AWS account\.

You can use an AWS user or group policy to give users the ability to create an Amazon QuickSight author account for themselves\. Their accounts become active and billable the first time they open Amazon QuickSight\. To set up self\-provisioning, you need to give them permission to use the `quicksight:CreateUser` action\. For more information about using IAM, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. 

## Self\-Provisioning an Amazon QuickSight Read\-Only User<a name="self-service-read-only-users"></a>

Amazon QuickSight read\-only users or *readers* can view and manipulate dashboards that are shared with them, but they can't make any changes or save a dashboard for further analysis\. Amazon QuickSight readers can't create data sources, data sets, analyses, or visuals\. They can't do any administrative tasks\. Choose this role for people who are consumers of the dashboards but don't author their own analysis, for example, executives\.

If you are using Microsoft Active Directory with Amazon QuickSight, you can manage read\-only permissions by using a group\. Otherwise, you can bulk\-invite users to use Amazon QuickSight\. You can also use an AWS user or group policy to give people the ability to create an Amazon QuickSight reader account for themselves\. 

Reader accounts become active and billable the first time they open Amazon QuickSight\. If you decide to upgrade or downgrade a user, billing for that user is pro\-rated for the month\. To set up self\-provisioning, you need to give them permission to use the `quicksight:CreateReader` action\. For more information about using IAM, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. 