# Tutorial: monitor source code in a GitHub repository<a name="tutorial-github-reviewer"></a>

 In this tutorial, you learn how to configure Amazon CodeGuru Reviewer to monitor source code so that it can create recommendations that improve the code\. 

You work with an actual suboptimal example application in a GitHub repository as a test case\. After you associate the repository with CodeGuru Reviewer, you create a code change and submit a pull request that triggers program analysis\. 

Because the example application contains intential inefficiencies, CodeGuru Reviewer creates recommendations about how to make it better\. You learn how to review the recommendations and then how to provide feedback about them\. Customer feedback from code reviews helps improve CodeGuru Reviewer recommendations over time\. 

 To run this tutorial, you must have a [GitHub](https://github.com/) account\. 

**Note**  
 This tutorial creates code reviews that might result in charges to your AWS account\. For more information, see [Amazon CodeGuru Pricing](https://aws.amazon.com/codeguru/pricing/)\. 
 Do not use the example code in production\. It's intentially problematic and intended for demonstration purposes only\. 

## Step 1: Fork the repository<a name="tutorial-step-1-fork-repo"></a>

 Fork the example application repository so you can create a pull request on it\. 

1.  Log in to GitHub and navigate to the **https://github\.com/aws\-samples/amazon\-codeguru\-reviewer\-sample\-app** example application repository\. 

1.  Choose **Fork** to fork the example application to your GitHub account\.   
![\[GitHub tutorial step 1: Fork a GitHub repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 1: Fork a GitHub repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 1: Fork a GitHub repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

## Step 2: Associate the forked repository<a name="tutorial-step-2-associate-repo"></a>

 Create a repository association with the example application's repository so that CodeGuru Reviewer listens to it for pull requests\. 

1. Open the Amazon CodeGuru Reviewer console at [https://console\.aws\.amazon\.com/codeguru/reviewer/](https://console.aws.amazon.com/codeguru/reviewer/)\.

1.  Choose **Associate repository**\. 

1.  Make sure **GitHub** is selected, and then choose **Connect to GitHub**\. 

1.  To allow CodeGuru Reviewer to access your account, choose **Authorize aws\-codesuite**\. If prompted, confirm your GitHub password\. 

1.  Select the **amazon\-codeguru\-reviewer\-sample\-app** repository, and then choose **Associate**\. 

   CodeGuru Reviewer is now associated with the repository and listening for pull requests\. 

## Step 3: Push a change to the code<a name="tutorial-step-3-push-change-to-code"></a>

 Push a change to the example application's code\. Later in this tutorial, you create a pull request for this change\. 

1.  Run the following Git command to clone the forked repository, replacing `USER_ID` with your actual GitHub user ID\. 

   ```
   git clone https://github.com/USER_ID/amazon-codeguru-reviewer-sample-app.git
   ```

    You can get the clone URL by choosing **Clone or download**\.   
![\[GitHub tutorial step 3: Clone a repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 3: Clone a repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 3: Clone a repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)
**Note**  
 If you access your GitHub repositories using SSH, use the SSH URL instead of the HTTPS URL shown in this step\. 

1.  Check out a new branch using the following command\. 

   ```
   cd amazon-codeguru-reviewer-sample-app
   git checkout -b dev
   ```

1.  Copy the Java class at `src/main/java/com/shipmentEvents/handlers/EventHandler.java` into `src/main/java/com/shipmentEvents/demo`\. 

   ```
   cp src/main/java/com/shipmentEvents/handlers/EventHandler.java src/main/java/com/shipmentEvents/demo/
   ```

    GitHub and CodeGuru Reviewer treat `EventHandler.java` as a new file\. 

1.  Push your changes to the example application's repository\. 

   ```
   git add --all
   git commit -m 'new demo file'
   git push --set-upstream origin dev
   ```

## Step 4: Create a pull request<a name="tutorial-step-4-create-pull-request"></a>

 Create a pull request for CodeGuru Reviewer to review\. 

1.  In your forked GitHub repository, choose **New pull request**\. 

1.  On the left side of the comparison \(**base**\), select **USER\_ID/amazon\-codeguru\-reviewer\-sample\-app**, where `USER_ID `is your GitHub user ID\. Leave the branch at **master**\. 

1.  On the right side of the comparison \(**compare**\), change the branch to **dev**\. The branches should show as **Able to merge**\.   
![\[GitHub tutorial step 4: Create a GitHub pull request\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 4: Create a GitHub pull request\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 4: Create a GitHub pull request\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

1.  Choose **Create pull request**, then choose **Create pull request** again\. 

## Step 5: Review recommendations<a name="tutorial-step-5-review-recommendations"></a>

 After a few minutes, CodeGuru Reviewer issues recommendations on the same GitHub page where the pull request was created\. You can check the status of the code review in CodeGuru Reviewer console\. 

1. Open the Amazon CodeGuru Reviewer console at [https://console\.aws\.amazon\.com/codeguru/reviewer/](https://console.aws.amazon.com/codeguru/reviewer/)\.

1.  In the navigation pane, expand **Reviewer** and choose **Code reviews**\. 

1.  After a code review is complete, choose it to view its details\. 

![\[GitHub tutorial step 5: CodeGuru Reviewer analysis status\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 5: CodeGuru Reviewer analysis status\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 5: CodeGuru Reviewer analysis status\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

 When the code review is complete and the recommendations appear in GitHub, you can provide feedback on the recommendations using the thumbs up or thumbs down icon\. Any positive or negative feedback is used to help improve the performance of CodeGuru Reviewer so that recommendations get better over time\. 

![\[GitHub tutorial step 5: Code Guru Reviewer feedback icons\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 5: Code Guru Reviewer feedback icons\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 5: Code Guru Reviewer feedback icons\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)

## Step 6: Clean up<a name="tutorial-step-6-clean-up"></a>

 After you're finished with this tutorial, clean up your resources\. 

1.  In your GitHub fork of **amazon\-codeguru\-reviewer\-sample\-app**, go to **Settings**, and then choose **Delete this repository**\. Follow the instructions to delete the forked repository\. 

1.  Delete your clone of the forked repository, for example, `rm -rf amazon-codeguru-reviewer-sample-app`\. 

1.  In the CodeGuru Reviewer console, select the example repository, choose **Actions**, and then choose **Disassociate repository**\.   
![\[GitHub tutorial step 6: Disassociate a CodeGuru Reviewer associated repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 6: Disassociate a CodeGuru Reviewer associated repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)![\[GitHub tutorial step 6: Disassociate a CodeGuru Reviewer associated repository\]](http://docs.aws.amazon.com/codeguru/latest/reviewer-ug/)