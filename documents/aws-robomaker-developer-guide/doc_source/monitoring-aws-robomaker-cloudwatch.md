# Monitoring AWS RoboMaker with Amazon CloudWatch<a name="monitoring-aws-robomaker-cloudwatch"></a>

You can monitor AWS RoboMaker simulation jobs using Amazon CloudWatch, which collects information from your simulation job and creates readable, near real\-time metrics\. Information is provided at 1\-minute frequency\. 

Metrics exist only in the region in which they are created\. Metrics cannot be deleted, but they automatically expire after 15 months if no new data is published to them\. 

For more information about Amazon CloudWatch, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\. For more information about pricing, see [Amazon CloudWatch Pricing](http://aws.amazon.com/cloudwatch/pricing)\. 

## AWS RoboMaker Metrics<a name="monitoring-aws-robomaker-metrics"></a>

The following metrics are available in the `SimulationJobId` dimension\.


| Metric | Description | 
| --- | --- | 
| `RealTimeFactor`  | The ratio of the amount of time that was simulated versus wall clock time\. For example, if it takes an hour to simulate 30 minutes, the factor is \.5\. More complex simulations have a lower real time factor\.   | 
| `vCPU*` | Number of virtual CPU cores used by the simulation job Unit: Count  | 
| `Memory*` | Amount of Memory, in GB, used by the SimulationJob  Unit: GB  | 
| `SimulationUnit*` | SimulationUnit is calculated based on vCPU and memory consumption of the Simulation Job Unit: Count  | 

**Important**  
Metrics marked with \* are for estimation purposes\. AWS RoboMaker emits metrics while preparing to run a simulation job\. Charges do not accrue until the simulation job is in the `Running` state\. 