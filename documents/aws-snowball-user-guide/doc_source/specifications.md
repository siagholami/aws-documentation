--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# AWS Snowball Specifications<a name="specifications"></a>

The following table outlines hardware specifications for the Snowball appliance\.


| Item | Specification | 
| --- | --- | 
| Storage capacity | 50 TB Snowballs have 42 TB of usable space\. 80 TB Snowballs have 72 TB of usable space\. | 
| On\-board I/O 10\-gigabit interfaces | Each Snowball supports RJ45 \(Cat6\), SFP\+ Copper, and SFP\+ Optical\. | 
| Cables | Each Snowball ships with RJ45 and copper SFP\+ cables\. For SFP\+ optical, you need to use your own cable, connected to the SFP\+ optical adapter in one of the SFP\+ ports\. | 
| Thermal requirements | Snowballs are designed for office operations, and are ideal for data center operations\. | 
| Decibel output | On average, a Snowball produces 68 decibels of sound, typically quieter than a vacuum cleaner or living\-room music\. | 
| Weight | 47 pounds \(21\.3 Kg\) | 
| Height | 19\.75 inches \(501 mm\) | 
| Width | 12\.66 inches \(320 mm\) | 
| Length | 21\.52 inches \(548 mm\) | 
| Power | In the US regions: NEMA 5–15p 100–220 volts\. In all regions, a power cable is included\. | 
| Power consumption | 200 watts\. | 
| Voltage | 100 – 240V AC | 
| Frequency | 47/63 Hz | 
| Power conversion efficiency | 80 – 84% at 25C, 230Vac | 
| Temperature range | 0 – 40°C \(operational\) | 
| Non\-operational Altitude | Not specified | 
| Operational Altitude | 0 to 3,000m \(0 to 10,000’\) | 

## Supported Network Hardware<a name="network-hardware"></a>

After you open the back panel of the Snowball, you see the network ports shown in the following photograph\.

![\[The available network ports.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/standard-snowball-back-connectors.png)

These ports support the following network hardware\.

**1\. RJ45**  
This port provides 1Gbase\-TX/10Gbase\-TX operation\. It is connected via UTP cable terminated with a RJ45 connector\.

1G operation is indicated by a blinking amber light\. 1G operation is not recommended for large\-scale data transfers to the Snowball device, as it will dramatically increase the time it takes to transfer data\.

10G operation is indicated by a blinking green light\. It requires a Cat6A UTP cable with a maximum operating distance of 180 feet\(55 meters\)\.

![\[RJ45\]](http://docs.aws.amazon.com/snowball/latest/ug/images/rj45.png)

**2\. SFP\+**  
This port provides an SFP\+ interface compatible with both SFP\+ transceiver modules and direct\-attach copper \(DAC\) cables\. You need to provide your own transceivers or DAC cables\. Examples include:
+ 10Gbase\-LR \(single mode fiber\) transceiver
+ 10Gbase\-SR \(multi\-mode fiber\) transceiver
+ SFP\+ DAC cable

![\[SFP+\]](http://docs.aws.amazon.com/snowball/latest/ug/images/sfp.png)

**3\. SFP\+**  
This port provides an SFP\+ interface and a 10Gbase\-SR transceiver that uses multi\-mode fiber optic media with an LC connector\.

![\[SFP+ Optical\]](http://docs.aws.amazon.com/snowball/latest/ug/images/sfpoptical.png)

## Workstation Specifications<a name="workstationspecs"></a>

The workstation is the computer, server, or virtual machine that hosts your mounted data source\. You connect the Snowball to this workstation to transfer your data\. Because the workstation is considered the bottleneck for transferring data between the Snowball and the data source, we highly recommend that your workstation be a powerful computer, able to meet high demands for processing, memory, and networking\.

We recommend that your workstation be a computer dedicated to the task of running the Snowball client or the Amazon S3 Adapter for Snowball while you're transferring data\.  Each instance of the client or the adapter requires up to 7 GB of dedicated RAM for memory\-intensive tasks, such as performing encryption\.

**Note**  
The hardware specifications for the workstations that are used to transfer data to and from a Snowball are for a powerful computer\. These hardware specifications are mainly based on security requirements for the service\. When data is transferred to a Snowball, a file is loaded into the workstation's memory\. While in memory, that file is fully encrypted by either the Snowball client or the Amazon S3 Adapter for Snowball\. Once the file is encrypted, chunks of the encrypted file are sent to the Snowball\. At no point is any data stored to disk\. All data is kept in memory, and only encrypted data is sent to the Snowball\. These steps of loading into memory, encrypting, chunking, and sending to the Snowball are both CPU\- and memory\-intensive\.

The following table outlines the suggested specifications for your workstation\.


| Item | Suggested Specification | 
| --- | --- | 
| Processing power | 16 core CPU | 
| Memory | 16 gigabytes of RAM  Each running instance of the client and/or adapter requires up to 7 GB of dedicated RAM for memory\-intensive tasks, such as performing the `snowball cp` command\.   | 
| Microsoft Windows support \(64\-bit only\) | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/ug/specifications.html) | 
| Mac support | Mac OS X version 10\.10 or higher | 
| Linux support \(64\-bit only\) | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/ug/specifications.html) | 
| User interface support | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/ug/specifications.html) | 
| Network I/O support | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/ug/specifications.html) | 