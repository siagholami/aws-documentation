# Theme<a name="macie-classify-objects-theme"></a>

Once Macie begins monitoring your data, it uses several automatic content classification methods to identify and prioritize your sensitive and critical data and to accurately assign business value to your data\. One of these methods is classifying by theme\.

Object classification by theme is based on keywords that Macie searches for as it examines the contents of data objects\. Macie offers a set of managed themes, each with a designated risk level between 1 and 10, with 10 being the highest risk and 1 being the lowest\.

Macie can assign one or more themes to an object\.

You can't modify existing or add new themes\. You can enable or disable any existing themes, thus enabling or disabling Macie to assign them to your objects during the classification process\.<a name="enable-disable-themes"></a>

**To view, enable, or disable themes**

1. In the Macie console, navigate to the **Settings** page\.

1. In the **Classify data** section, choose **Themes**\.

1. Choose any of the listed managed themes to view its details\.

   To enable or disable a theme, on its details page, use the **Enabled/Disabled** dropdown and then choose **Save**\.

The following is the complete list of themes that Macie can assign to your objects during classification\.


|  |  |  | 
| --- |--- |--- |
| Theme title  | Minimum keyword combinations | Risk | 
| American Express Credit Card Keywords | 1 | 1 | 
| Attorney Client Privileged | 2 | 5 | 
| Audit Keywords | 3 | 2 | 
| Banking Keywords | 1 | 1 | 
| Big Data Frameworks | 2 | 4 | 
| Cisco Analysis Keywords | 1 | 2 | 
| Confidential Markings | 2 | 5 | 
| Corporate Growth Keywords | 3 | 5 | 
| Corporate Project Plan | 3 | 3 | 
| Corporate Proposals | 3 | 2 | 
| Credit Card Keywords | 1 | 1 | 
| Encrypted Data Keywords | 1 | 5 | 
| Financial Keywords | 1 | 1 | 
| Hacker Keywords | 2 | 1 | 
| Limit Distribution Markings | 3 | 5 | 
| Mastercard Credit Card Keywords | 1 | 1 | 
| Metasploit Framework Keywords | 1 | 2 | 
| NMAP OS Fingerprinting | 1 | 2 | 
| Network Scanner Keywords | 1 | 2 | 
| Network Service Fingerprinting Keywords | 1 | 2 | 
| Network Traffic Analysis Keywords | 1 | 2 | 
| OS Backdoor Keywords | 1 | 2 | 
| Offline Attacks Keywords | 1 | 2 | 
| Online Attacks Keywords | 1 | 2 | 
| Oracle DB Analysis Keywords | 1 | 2 | 
| Password Keywords | 2 | 5 | 
| Project Tracking Keywords | 2 | 3 | 
| Proprietary Markings | 2 | 5 | 
| Real\-Time Processing Frameworks | 2 | 4 | 
| Restricted Markings | 2 | 5 | 
| SSL Forensic Analysis Keywords | 1 | 2 | 
| Secret Markings | 3 | 5 | 
| Sensitive Markings | 3 | 3 | 
| Social Security Keywords | 2 | 2 | 
| Stock Keywords | 3 | 1 | 
| Taxpayer EIN Keywords | 2 | 1 | 
| Tunneling Attacks Keywords | 1 | 2 | 
| Unclassified Markings | 2 | 3 | 
| VISA Credit Card Keywords | 1 | 1 | 
| Vulnerability Assessment Keywords | 2 | 1 | 
| Web Exploitation Tool Keywords | 1 | 2 | 
| Web Vulnerability Scanner Keywords | 1 | 2 | 
| pof OS Fingerprinting | 2 | 2 | 