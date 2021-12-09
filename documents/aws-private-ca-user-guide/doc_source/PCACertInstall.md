# Creating and Installing the Certificate for a Private CA<a name="PCACertInstall"></a>

Complete the following procedures to create and install your private CA certificate\. Your CA will then be ready to use\.

ACM Private CA supports three scenarios for installing a CA certificate :
+ Installing a certificate for a root CA hosted by ACM Private CA
+ Installing a subordinate CA certificate whose parent authority is hosted by ACM Private CA
+ Installing a subordinate CA certificate whose parent authority is externally hosted

 The following sections describe procedures for each scenario\. The console procedures begin on the console page **Private CAs**\.

## If You Are Installing a Root CA Certificate<a name="InstallRoot"></a>

**To create and install a certificate for your private root CA using the console**

1. If you previously created a root CA and chose **Get started** from the **Success** window, you were sent directly to the **Install root CA certificate** wizard\. If you chose to postpone certificate installation, you can open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home) and begin installation by selecting a root CA with status **Pending Certificate** or **Active**, choosing **Actions**, and finally choosing **Install CA Certificate**\. This opens the **Install root CA certificate** wizard\.

1. In the section **Specify the root CA certificate parameters**, specify the following certificate parameters:
   + **Validity** — In years, months, or days, this determines when the CA certificate will expire\. The ACM Private CA default validity period for a root CA certificate is 10 years\.
   + **Signature algorithm** — This specifies the signing algorithm to use when the root CA issues new certificates\.

   Choose **Next**\.

1. On the **Review, generate, and install root CA certificate** page, confirm that the configuration is correct and choose **Confirm and install**\. ACM Private CA exports a CSR for your CA, issues a self\-signed root CA certificate using your CA and a root CA template, and then imports the self\-signed root CA certificate\.

   You should be returned to the **Private CAs** list page, displaying the status of the installation \(success or failure\) at the top\. If the installation was successful, the newly completed root CA displays a status of **Active** in the list\.

**To create and install a certificate for your private root CA using the AWS CLI**

1. Create the root certificate\.

   ```
   aws acm-pca issue-certificate \
   --certificate-authority-arn arn:aws:acm-pca:ap-southeast-1:012345678901:certificate-authority/01234567-89ab-cdef-0123-456789abcdef \
   --csr file://ca.csr \
   --signing-algorithm SHA256WITHRSA \
   --template-arn arn:aws:acm-pca:::template/RootCACertificate/V1 \
   --validity Value=365,Type=DAYS
   ```

1. Retrieve the root certificate\.

   ```
   aws acm-pca get-certificate \
   --certificate-authority-arn arn:aws:acm-pca:ap-southeast-1:012345678901:certificate-authority/01234567-89ab-cdef-0123-456789abcdef \
   --certificate-arn arn:aws:acm-pca:ap-southeast-1:012345678901:certificate-authority/01234567-89ab-cdef-0123-456789abcdef/certificate/0123456789abcdef0123456789abcdef \
   --output text > cert.pem
   ```

1. Import the root certificate to install it on the CA\.

   ```
   aws acm-pca import-certificate-authority-certificate \
   --certificate-authority-arn arn:aws:acm-pca:ap-southeast-1:012345678901:certificate-authority/01234567-89ab-cdef-0123-456789abcdef \
   --certificate file://cert.pem
   ```

## If You Are Installing a Subordinate CA Certificate Hosted by ACM Private CA<a name="InstallSubordinateInternal"></a>

**To create and install a certificate for your ACM Private CA\-hosted subordinate CA**

1. If you previously created a subordinate CA and chose **Get started** from the **Success\!** window, you were sent directly to the **Install subordinate CA certificate** console\. If you chose to postpone certificate installation, you can open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home) and begin installation by selecting a subordinate CA with status **Pending Certificate** or **Active**, choosing **Actions**, and finally choosing **Install CA Certificate**\. This opens the **Install subordinate CA certificate** wizard\.

1. On the **Private CAs** page, the existing CAs in your account are displayed along with their type and status information\. If a CA is selected that has status **Pending Certificate**, an **Action required** box displays and offers a link to begin installing a certificate\.

   Choose **Install a CA certificate**\.

1. On the **Install subordinate CA certificate** page, select the following option:
   + **ACM Private CA** — This installs a certificate managed by ACM Private CA\.

   Choose **Next**\.

1. If **ACM Private CA**: In section **Select parent ACM Private CA**, choose an available CA from the **Parent private CA** list\.

1. In the section **Specify the subordinate CA certificate parameters**, can specify the following certificate parameters:
   + **Validity** — In years, months, or days, this determines when the subordinate CA certificate will expire\. 
**Note**  
The expiration date of the subordinate CA certificate cannot be later than the expiration date of the parent CA certificate\.
   + **Signature algorithm** — This specifies the signing algorithm to use when the subordinate CA issues new certificates\.
   + **Path length** — This specifies the number of trust layers that the subordinate CA may add when signing new certificates\. A path length of zero \(the default\) means that only end\-entity certificates and not CA certificates may be created\. A path length of one or more means that the subordinate CA may issue certificates to create additional CAs subordinate to it\.
   + **Template ARN** — The ARN of the configuration template for this CA certificate\. The template changes if you change the specified **Path length**\. If you create a certificate using the CLI [issue\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/issue-certificate.html) command or API [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html) action, you must specify the ARN manually\. For information about available CA certificate templates, see [Understanding Certificate Templates](UsingTemplates.md)\.

   Choose **Next**\.

1. On the **Review and generate** page, confirm that your configuration is correct and choose **Generate**\. ACM Private CA exports a CSR for your CA, issues a CA certificate from the parent CA and template you selected, and imports the CA certificate\. 

## If You Are Installing a Subordinate CA Certificate Signed by an External Parent CA<a name="InstallSubordinateExternal"></a>

**To create and install a subordinate CA certificate signed by an external parent CA**

1. If you previously created a subordinate CA and chose **Get started** from the **Success\!** window, you were sent directly to the **Install subordinate CA certificate** console\. If you chose to postpone certificate installation, you can open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home) and begin installation by selecting a subordinate CA with status **Pending Certificate**, choosing **Actions**, and finally choosing **Install CA Certificate**\. This opens the **Install subordinate CA certificate** console\.

1. On the **Install subordinate CA certificate** page, select the following option:
   + **External private CA** — This installs a certificate signed by an external private CA that you own\.

   Choose **Next**\.

1. On the **Export a certificate signing request \(CSR\)** page, ACM Private CA generates and displays certificate information and a CSR\. You have to option of exporting the CSR to a file\.

   When you have exported the CSR to a file and had the file signed by your external parent CA, choose **Next**\.

1. On the **Import a signed certificate authority \(CA\) certificate** page, import your signed CA certificate and your certificate chain \(containing intermediate certificates\)\. 

   Choose **Next**\.

1. On the **Review and install** page, confirm that your configuration is correct and choose **Confirm and install**\. 

   You should be returned to the **Private CAs** list page, displaying the status of the installation \(success or failure\) at the top\. If the installation was successful, the newly completed root CA displays a status of **Active** in the list\.