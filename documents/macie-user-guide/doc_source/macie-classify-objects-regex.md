# Regex<a name="macie-classify-objects-regex"></a>

Once Macie begins monitoring your data, it uses several automatic content classification methods to identify and prioritize your sensitive and critical data and to accurately assign business value to your data\. One of these methods is classifying by regex\.

Object classification by regex is based on specific data or data patterns that Macie searches for as it examines the contents of data objects\. Macie offers a set of managed regexes, each with a designated risk level between 1 and 10, with 10 being the highest risk and 1 being the lowest\.

Macie can assign one or more regexes to an object\.

You can't modify existing or add new regexes\. You can enable or disable any existing regexes, thus enabling or disabling Macie to assign them to your objects during the classification process\.<a name="enable-disable-regex"></a>

**To view, enable, or disable regexes**

1. In the Macie console, navigate to the **Settings** page\.

1. In the **Classify data** section, choose **Regex**\.

1. Choose any of the listed managed regexes to view its details\.

   To enable or disable a regex, on its details page, use the **Enabled/Disabled** dropdown and choose **Save**\.

The following is the complete list of regexes that Macie can assign to your objects during classification\.


|  |  |  |  | 
| --- |--- |--- |--- |
| Name  | Classification | Minimum number of matches | Risk | 
| Arista network configuration | Regex | 1 | 7 | 
| BBVA Compass Routing Number \- California | Regex | 1 | 1 | 
| Bank of America Routing Numbers \- California | Regex | 10 | 1 | 
| Box Links | Regex | 1 | 3 | 
| CVE Number | Regex | 1 | 3 | 
| California Drivers License | Regex | 10 | 1 | 
| Chase Routing Numbers \- California | Regex | 50 | 1 | 
| Cisco Router Config | Regex | 3 | 9 | 
| Citibank Routing Numbers \- California | Regex | 1 | 1 | 
| DSA Private Key | Regex | 1 | 8 | 
| Dropbox Links | Regex | 1 | 3 | 
| EC Private Key | Regex | 1 | 8 | 
| Encrypted DSA Private Key | Regex | 1 | 3 | 
| Encrypted EC Private Key | Regex | 1 | 3 | 
| Encrypted Private Key | Regex | 1 | 3 | 
| Encrypted PuTTY SSH DSA Key | Regex | 1 | 3 | 
| Encrypted PuTTY SSH RSA Key | Regex | 1 | 3 | 
| Encrypted RSA Private Key | Regex | 1 | 3 | 
| Google Application Identifier | Regex | 1 | 2 | 
| HIPAA PHI National Drug Code | Regex | 2 | 2 | 
| Huawei config file | Regex | 1 | 8 | 
| Individual Taxpayer Identification Numbers \(ITIN\) | Regex | 100 | 4 | 
| John the Ripper | Regex | 1 | 1 | 
| KeePass 1\.x CSV Passwords | Regex | 1 | 8 | 
| KeePass 1\.x XML Passwords | Regex | 1 | 8 | 
| Large number of US Phone Numbers | Regex | 100 | 1 | 
| Large number of US Zip Codes | Regex | 100 | 3 | 
| Lightweight Directory Access Protocol | Regex | 3 | 2 | 
| Metasploit Module | Regex | 1 | 6 | 
| MySQL database dump | Regex | 1 | 7 | 
| MySQLite database dump | Regex | 1 | 7 | 
| Network Proxy Auto\-Config | Regex | 1 | 3 | 
| Nmap Scan Report | Regex | 1 | 7 | 
| PGP Header | Regex | 1 | 5 | 
| PGP Private Key Block | Regex | 1 | 8 | 
| PKCS7 Encrypted Data | Regex | 1 | 5 | 
| Password etc passwd | Regex | 4 | 8 | 
| Password etc shadow | Regex | 4 | 8 | 
| PlainText Private Key | Regex | 1 | 8 | 
| PuTTY SSH DSA Key | Regex | 1 | 8 | 
| PuTTY SSH RSA Key | Regex | 1 | 8 | 
| Public Key Cryptography System \(PKCS\) | Regex | 1 | 3 | 
| Public encrypted key | Regex | 1 | 1 | 
| RSA Private Key | Regex | 1 | 8 | 
| SSL Certificate | Regex | 1 | 3 | 
| SWIFT Codes | Regex | 2 | 4 | 
| Samba Password config file | Regex | 1 | 7 | 
| Simple Network Management Protocol Object Identifier | Regex | 1 | 5 | 
| Slack 2FA Backup Codes | Regex | 1 | 8 | 
| UK Drivers License Numbers | Regex | 50 | 4 | 
| UK Passport Number | Regex | 5 | 1 | 
| USBank Routing Numbers \- California | Regex | 50 | 1 | 
| United Bank Routing Number \- California | Regex | 1 | 1 | 
| Wells Fargo Routing Numbers \- California | Regex | 10 | 1 | 
| aws\_access\_key | Regex | 1 | 3 | 
| aws\_credentials\_context | Regex | 1 | 3 | 
| aws\_secret\_key | Regex | 1 | 10 | 
| facebook\_secret | Regex | 1 | 8 | 
| github\_key | Regex | 1 | 8 | 
| google\_two\_factor\_backup | Regex | 1 | 8 | 
| heroku\_key | Regex | 1 | 7 | 
| microsoft\_office\_365\_oauth\_context | Regex | 1 | 1 | 
| pgSQL Connection Information | Regex | 1 | 2 | 
| slack\_api\_key | Regex | 1 | 7 | 
| slack\_api\_token | Regex | 1 | 8 | 
| ssh\_dss\_public | Regex | 1 | 1 | 
| ssh\_rsa\_public | Regex | 1 | 1 | 