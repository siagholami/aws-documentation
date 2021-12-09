# Working with the Sample Database for Migration<a name="CHAP_On-PremOracle2Aurora.Appendix.SampleDatabase"></a>

We recommend working through the preceding outline and guide by using the sample Oracle database provided by Amazon\. This database mimics a simple sporting event ticketing system\. The scripts to generate the sample database are part of the \.tar file located here: [https://github\.com/awslabs/aws\-database\-migration\-samples](https://github.com/awslabs/aws-database-migration-samples)\.

To build the sample database, extract the \.tar file and follow the instructions in the README and install files\.

The sample includes approximately 8\-10 GB of data\. The sample database also includes the ticketManagment package, which you can use to generate some transactions\. To generate transactions, log into SQL\*Plus or SQL Developer and run the following as ***dms\_sample***:

```
SQL>exec  ticketManagement.generateTicketActivity(0.01,1000);
```

The first parameter is the transaction delay in seconds, the second is the number of transactions to generate\. The procedure preceding simply “sells tickets” to people\. You’ll see updates to the tables: sporting\_event\_ticket, and ticket\_purchase\_history\.

Once you’ve “sold” some tickets, you can transfer them using the command following:

```
SQL>exec ticketManagement.generateTransferActivity(1,100);
```

The first parameter is the transaction delay in seconds, the second is the number of transactions to generate\. This procedure also updates sporting\_event\_ticket and ticket\_purchase\_history\.