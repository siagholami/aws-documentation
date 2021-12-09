# Disabling Amazon Macie and Deleting Collected Metadata<a name="macie-disable"></a>

Use the Macie general settings page in the Macie console to disable Macie\.

**Important**  
Only the master Macie account can disable Macie\. For Macie to be disabled in a member account, the master account must disassociate this member account from Macie\.

If you disable Macie, it no longer has access to the resources in the master account and all member accounts\. You must add member accounts again if you decide to reenable Macie\.

 If you disable Macie, it stops processing the resources in the master account and all member accounts\. After Macie is disabled, the metadata that Macie collected while monitoring the data in your master and member accounts is deleted\. Within 90 days from disabling Macie, all of this metadata is expired from the Macie system backups\. 

**Important**  
Disabling Macie doesn't prompt the deletion of your other data in your AWS accounts\. After Macie is disabled, only the metadata that was collected by Macie while it monitored your accounts is deleted\.

1. Navigate to the **Macie general settings** page by choosing the down arrow next to your signed\-in name\.

1. On the **Macie general settings** page, select the following check boxes:
   + **I understand that if I disable Macie, the service will no longer have access to the resources in the master account and all member accounts\. You must add member accounts again if you decide to re\-enable Macie\.**
   +  **I understand that if I disable Macie, the service will stop processing the resources in the master account and all member accounts\. All metadata that Macie collected while monitoring the data in these accounts will be deleted\. **

1. Choose **Disable Amazon Macie**\.