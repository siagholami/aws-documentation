# Step 4: Create an AWS Service Catalog Product<a name="getstarted-product"></a>

After you have created a portfolio, you're ready to add a product\. For this tutorial, you will create a product called Linux Desktop, a cloud development environment that runs on Amazon Linux\.

**To create a product**

1. If you've just completed the previous step, the **Portfolios** page is already displayed\. Otherwise, open [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose the name **Engineering Tools** to open the portfolio details page, and then choose **Upload new product**\.

1. On the **Enter product details** page, type the following and then choose **Next**:
   + **Product name** – **Linux Desktop**
   + **Description** – **Cloud development environment configured for engineering staff\. Runs AWS Linux\.**
   + **Provided by** – **IT**
   + **Vendor** – *\(blank\)*

1. On the **Enter support details** page, type the following and then choose **Next**:
   + **Email contact** – **ITSupport@example\.com**
   + **Support link** – **https://wiki\.example\.com/IT/support**
   + **Support description** – **Contact the IT department for issues deploying or connecting to this product\.**

1. On the **Version details** page, choose **Specify an Amazon S3 template URL**, type the following, and then choose **Next**:
   + **Select template** – **https://awsdocs\.s3\.amazonaws\.com/servicecatalog/development\-environment\.template**
   + **Version title** – **v1\.0**
   + **Description** – **Base Version**

1. On the **Review** page, choose **Create**\.