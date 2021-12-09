# Calculating OEE in AWS IoT SiteWise<a name="calculate-oee"></a>

This tutorial provides an example of how to calculate overall equipment effectiveness \(OEE\) for a manufacturing process\. As a result, your OEE calculations or formulas might differ from those shown here\. In general, OEE is defined as `Availability * Quality * Performance`\. To learn more about calculating OEE, see [Overall equipment effectiveness](https://en.wikipedia.org/wiki/Overall_equipment_effectiveness) on *Wikipedia*\.

## Prerequisites<a name="oee-requirements"></a>

To complete this tutorial, you must configure data ingestion for a device that has the following three data streams:
+ `Equipment_State` – A numerical code that represents the state of the machine, such as idle, fault, planned stop, or normal operation\.
+ `Good_Count` – A data stream where each data point contains the number of successful operations since the last data point\.
+ `Bad_Count` – A data stream where each data point contains the number of unsuccessful operations since the last data point\.

To configure data ingestion, see [Ingesting data to AWS IoT SiteWise](industrial-data-ingestion.md)\. If you don't have an available industrial operation, you can write a script that generates and uploads sample data through the AWS IoT SiteWise API\.

## How to calculate OEE<a name="how-to-calculate-oee"></a>

In this tutorial, you create an asset model that calculates OEE from three data input streams: `Equipment_State`, `Good_Count`, and `Bad_Count`\. In this example, consider a generic packaging machine, such as one that's used for packaging sugar, potato chips, or paint\. In the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/), create an AWS IoT SiteWise asset model with the following measurements, transforms, and metrics\. Then, you can create an asset to represent the packaging machine and observe how AWS IoT SiteWise calculates OEE\.

Define the following [measurements](measurements.md) to represent the raw data streams from the packaging machine\.

**Measurements**
+ `Equipment_State` – A data stream \(or measurement\) that provides the current state of the packaging machine in numerical codes: 
  + `1024` – The machine is idle\. 
  + `1020` – A fault, such as an error or delay\. 
  + `1000` – A planned stop\.
  + `1111` – A normal operation\.
+ `Good_Count` – A data stream where each data point contains the number of successful operations since the last data point\.
+ `Bad_Count` – A data stream where each data point contains the number of unsuccessful operations since the last data point\.

Using the `Equipment_State` measurement data stream and the codes it contains, define the following [transforms](transforms.md) \(or derived measurements\)\. Transforms have a one\-to\-one relationship with raw measurements\.

**Transforms**
+ `Idle = eq(Equipment_State, 1024)` – A transformed data stream that contains the machine's idle state\.
+ `Fault = eq(Equipment_State, 1020)` – A transformed data stream that contains the machine's fault state\.
+ `Stop = eq(Equipment_State, 1000)` – A transformed data stream that contains the machine's planned stop state\.
+ `Running = eq(Equipment_State, 1111)` – A transformed data stream that contains the machine's normal operational state\.

Using the raw measurements and the transformed measurements, define the following [metrics](metrics.md) that aggregate machine data over specified time intervals\. Choose the same time interval for each metric when you define the metrics in this section\.

**Metrics**
+ `Successes = sum(Good_Count)` – The number of successfully filled packages over the specified time interval\.
+ `Failures = sum(Bad_Count)` – The number of unsuccessfully filled packages over the specified time interval\.
+ `Idle_Time = statetime(Idle)` – The machine's total idle time \(in seconds\) per specified time interval\.
+ `Fault_Time = statetime(Fault)` – The machine's total fault time \(in seconds\) per specified time interval\.
+ `Stop_Time = statetime(Stop)` – The machine's total planned stop time \(in seconds\) per specified time interval\.
+ `Run_Time = statetime(Running)` – The machine's total time \(in seconds\) running without issue per specified time interval\.
+ `Down_Time = Idle_Time + Fault_Time + Stop_Time` – The machine's total downtime \(in seconds\) over the specified time interval, calculated as the sum of the machine states other than `Run_Time`\.
+ `Availability = Run_Time / (Run_Time + Down_Time)` – The machine's uptime or percentage of scheduled time that the machine is available to operate over the specified time interval\.
+ `Quality = Successes / (Successes + Failures)` – The machine's percentage of successfully filled packages over the specified time intervals\.
+ `Performance = ((Successes + Failures) / Run_Time) / Ideal_Run_Rate` – The machine's performance over the specified time interval as a percentage out of the ideal run rate \(in seconds\) for your process\. 

  For example, your `Ideal_Run_Rate` might be 60 packages per minute \(1 package per second\)\. If your `Ideal_Run_Rate` is per minute or per hour, you need to divide it by the appropriate unit conversion factor because `Run_Time` is in seconds\. 
+ `OEE = Availability * Quality * Performance` – The machine's overall equipment effectiveness over the specified time interval\. This formula calculates OEE as a fraction out of 1\.