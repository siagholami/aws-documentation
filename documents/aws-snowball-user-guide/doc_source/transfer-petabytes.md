--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# How to Transfer Petabytes of Data Efficiently<a name="transfer-petabytes"></a>

When transferring petabytes of data, we recommend that you plan and calibrate your data transfer between the Snowball you have on\-site and your workstation according to the following guidelines\. Small delays or errors can significantly slow your transfers when you work with large amounts of data\.

**Topics**
+ [Planning Your Large Transfer](#copy-general-planning)
+ [Calibrating a Large Transfer](#calibrating-large-transfer)
+ [Transferring Data in Parallel](#parallel-usage)

## Planning Your Large Transfer<a name="copy-general-planning"></a>

To plan your petabyte\-scale data transfer, we recommend the following steps:
+ [Step 1: Understand What You're Moving to the Cloud](#understand-the-transfer)
+ [Step 2: Prepare Your Workstations](#prepare-workstations)
+ [Step 3: Calculate Your Target Transfer Rate](#calculate-rate)
+ [Step 4: Determine How Many Snowballs You Need](#number-of-snowballs)
+ [Step 5: Create Your Jobs Using the AWS Snowball Management Console](#make-jobs)
+ [Step 6: Separate Your Data into Transfer Segments](#prepare-segments)

### Step 1: Understand What You're Moving to the Cloud<a name="understand-the-transfer"></a>

Before you create your first job for Snowball, you should make sure that you know what data you want to transfer, where it is currently stored, and the destination you want to transfer it to\. For data transfers that are a petabyte in scale or larger, doing this administrative housekeeping makes your life much easier when your Snowballs start to arrive\.

You can keep this data in a spreadsheet or on a whiteboard—however it works best for you to organize the large amount of content you plan to move to the cloud\. If you're migrating data into the cloud for the first time, we recommend that you design a cloud migration model\. For more information, see the whitepaper [A Practical Guide to Cloud Migration](https://d0.awsstatic.com/whitepapers/the-path-to-the-cloud-dec2015.pdf) on the AWS Whitepapers website\.

When you're done with this step, you know the total amount of data that you're going to move into the cloud\.

### Step 2: Prepare Your Workstations<a name="prepare-workstations"></a>

When you transfer data to a Snowball, you do so through the Snowball client, which is installed on a physical workstation that hosts the data that you want to transfer\. Because the workstation is considered to be the bottleneck for transferring data, we highly recommend that your workstation be a powerful computer, able to meet high demands in terms of processing, memory, and networking\.

For large jobs, you might want to use multiple workstations\. Make sure that your workstations all meet the suggested specifications to reduce your total transfer time\. For more information, see [Workstation Specifications](specifications.md#workstationspecs)\.

### Step 3: Calculate Your Target Transfer Rate<a name="calculate-rate"></a>

It's important to estimate how quickly you can transfer data to the Snowballs connected to each of your workstations\. This estimated speed equals your target transfer rate\. This rate is the rate at which you can expect data to move into a Snowball given the realities of your local network architecture\.

By reducing the hops between your workstation running the Snowball client and the Snowball, you reduce the time it takes for each transfer\. We recommend hosting the data that you want transferred onto the Snowball on the workstation that you transfer the data through\.

To calculate your target transfer rate, download the Snowball client and run the `snowball test` command from the workstation that you transfer the data through\. If you plan on using more than one Snowball at a time, run this test from each workstation\. For more information on running the test, see [Testing Your Data Transfer with the Snowball Client](using-client.md#testing-client)\.

While determining your target transfer speed, keep in mind that it is affected by a number of factors including local network speed, file size, and the speed at which data can be read from your local servers\. The Snowball client copies data to the Snowball as fast as conditions allow\. It can take as little as a day to fill a 50 TB Snowball depending on your local environment\. You can copy twice as much data in the same amount of time by using two 50 TB Snowballs in parallel\. Alternatively, you can fill an 80 TB Snowball in two and a half days\.

### Step 4: Determine How Many Snowballs You Need<a name="number-of-snowballs"></a>

Using the total amount of data you're going to move into the cloud, found in step 1, determine how many Snowballs you need to finish your large\-scale data migration\. Remember that Snowballs come in 50 TB \(42 usable\) and 80 TB \(72 usable\) sizes so that you can determine this number effectively\. You can move a petabyte of data in as little as 14 Snowballs\.

### Step 5: Create Your Jobs Using the AWS Snowball Management Console<a name="make-jobs"></a>

Now that you know how many Snowballs you need, you can create an import job for each device\. Because each Snowball import job involves a single Snowball, you create multiple import jobs\. For more information, see [Create an Import Job](create-import-job.md)\.

### Step 6: Separate Your Data into Transfer Segments<a name="prepare-segments"></a>

As a best practice for large data transfers involving multiple jobs, we recommend that you separate your data into a number of smaller, manageable data transfer segments\. If you separate the data this way, you can transfer each segment one at a time, or multiple segments in parallel\. When planning your segments, make sure that all the sizes of the data for each segment combined fit on the Snowball for this job\. When segmenting your data transfer, take care not to copy the same files or directories multiple times\. Some examples of separating your transfer into segments are as follows:
+ You can make 10 segments of 4 TB each in size for a 50 TB Snowball\.
+ For large files, each file can be an individual segment\.
+ Each segment can be a different size, and each individual segment can be made of the same kind of data—for example, batched small files in one segment, large files in another segment, and so on\. This approach helps you determine your average transfer rate for different types of files\.

**Note**  
Metadata operations are performed for each file transferred\. Regardless of a file's size, this overhead remains the same\. Therefore, you get faster performance out of batching small files together\. For implementation information on batching small files, see [Options for the snowball cp Command](copy-command-reference.md)\.

Creating these data transfer segments makes it easier for you to quickly resolve any transfer issues, because trying to troubleshoot a large transfer after the transfer has run for a day or more can be complex\.

When you've finished planning your petabyte\-scale data transfer, we recommend that you transfer a few segments onto the Snowball from your workstation to calibrate your speed and total transfer time\.

## Calibrating a Large Transfer<a name="calibrating-large-transfer"></a>

You can calibrate a large transfer by running the `snowball cp` command with a representative set of your data transfer segments\. In other words, choose a number of the data segments that you defined following last section's guidelines and transfer them to a Snowball\. At the same time, make a record of the transfer speed and total transfer time for each operation\.

**Note**  
You can also use the `snowball test` command to perform calibration before receiving a Snowball\. For more information about using that command, see [Testing Your Data Transfer with the Snowball Client](using-client.md#testing-client)\.

While the calibration is being performed, monitor the workstation's CPU and memory utilization\. If the calibration's results are less than the target transfer rate, you might be able to copy multiple parts of your data transfer in parallel on the same workstation\. In this case, repeat the calibration with additional data transfer segments, using two or more instances of the Snowball client connected to the same Snowball\. Each running instance of the Snowball client should be transferring a different segment to the Snowball\.

Continue adding additional instances of the Snowball client during calibration until you see diminishing returns in the sum of the transfer speed of all Snowball client instances currently transferring data\. At this point, you can end the last active instance of Snowball client and make a note of your new target transfer rate\.

**Important**  
Your workstation should be the local host for your data\. For performance reasons, we don't recommend reading files across a network when using Snowball to transfer data\. 

If a workstation's resources are at their limit and you aren’t getting your target rate for data transfer onto the Snowball, there’s likely another bottleneck within the workstation, such as the CPU or disk bandwidth\.

When you complete these steps, you should know how quickly you can transfer data by using one Snowball at a time\. If you need to transfer your data faster, see [Transferring Data in Parallel](#parallel-usage)\.

## Transferring Data in Parallel<a name="parallel-usage"></a>

Sometimes the fastest way to transfer data with Snowball is to transfer data in parallel\. Parallelization involves one or more of the following scenarios:
+ Using multiple instances of the Snowball client on a single workstation with a single Snowball
+ Using multiple instances of the Snowball client on multiple workstations with a single Snowball
+ Using multiple instances of the Snowball client on multiple workstations with multiple Snowballs

If you use multiple Snowball clients with one workstation and one Snowball, you only need to run the `snowball start` command once, because you run each instance of the Snowball client from the same user account and home directory\. The same is true for the second scenario, if you transfer data using a networked file system with the same user across multiple workstations\. In any scenario, follow the guidance provided in [Planning Your Large Transfer](#copy-general-planning)\.