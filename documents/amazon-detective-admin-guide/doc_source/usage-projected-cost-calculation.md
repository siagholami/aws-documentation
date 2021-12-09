# How Amazon Detective calculates projected cost<a name="usage-projected-cost-calculation"></a>

To calculate the projected cost values that it displays on the **Usage** page, Detective does the following\.

1. To get the projected cost for an individual account in a behavior graph, Detective does the following\.

   1. Calculates the average volume per day\. It adds the data volume across all of the active days and then divides by the number of days that the account has been active\.

      If the account was enabled more than 30 days ago, then the number of days is 30\. If the account was enabled fewer than 30 days ago, then it is the number of days since the acceptance date\.

      For example, if the account was enabled 12 days ago, then Detective adds the volume ingested for those 12 days and then divides it by 12\.

   1. Multiplies the account's daily average by 30\. This is the projected 30\-day usage for the account\.

   1. Uses its pricing model to calculate the projected 30\-day cost for the projected 30\-day usage\.

1. To get the total projected cost for a behavior graph, Detective does the following:

   1. Combines the projected 30\-day usage from all of the accounts in the behavior graph\.

   1. Uses its pricing model to calculate the projected 30\-day cost for the total projected 30\-day usage\.

1. To get the total projected cost for a member account across behavior graphs, Detective does the following:

   1. Combines the projected 30\-day usage across all of the behavior graphs\.

   1. Uses its pricing model to calculated the projected 30\-day cost for the total projected 30\-day usage\.