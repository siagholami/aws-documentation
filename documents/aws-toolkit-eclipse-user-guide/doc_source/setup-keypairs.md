# Associate Private Keys with Your Amazon EC2 Key Pairs<a name="setup-keypairs"></a>

The AWS Toolkit for Eclipse can obtain your Amazon EC2 key pairs from AWS\. However, you will need to associate private keys to use them with the AWS Toolkit for Eclipse\.

 **To view your Amazon EC2 key pairs in the AWS Toolkit for Eclipse and associate private keys with them** 

1. Open Eclipse’s **Preferences** dialog box and click the triangle next to **AWS Toolkit** in the sidebar to show additional categories of AWS Toolkit for Eclipse settings\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-preferences-node.png)

1. Select **Key Pairs**\.

   Eclipse displays a scrollable list of your key pairs\. If a key pair has a red **X** next to it, you will need to associate a private key with the key pair to use it\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-preferences-keypairs.png)

1. Right\-click the key pair and, from the context menu, select **Select Private Key File…**   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-preferences-select-private-key-file.png)

1. Navigate to the private key file and select it to associate it with your key pair\.