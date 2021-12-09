# Complete the Prerequisites<a name="getting-started-with-rds-on-vmware.pre-onboarding"></a>

Before you onboard your vSphere cluster, complete the following prerequisites\.

**To prepare to onboard your vSphere cluster for Amazon RDS on VMware**

1. Complete the tasks in [Setting Up Amazon RDS on VMware](setting-up-rds-on-vmware.md)\.

1. Make sure that you have a business\-level or enterprise\-level AWS Support plan\.

   Amazon RDS on VMware requires a business\-level or enterprise\-level AWS Support plan\. For information about AWS Support plans, see [ Compare AWS Support Plans](https://aws.amazon.com/premiumsupport/plans/)\.

1. Configure your VMware environment for resiliency and high availability\.

   Before deploying Amazon RDS on VMware, we recommend that you configure the resiliency and high availability options available on the underlying VMware platform\. VMware offers a variety of resiliency and high availability features to protect your infrastructure and ensure continued infrastructure operation\. We recommend configuring the following VMware features\.

   Amazon RDS on VMware includes a set of VMs running on the on\-premises vSphere cluster\. In case of an ESXi host failure, you can use vSphere HA to automatically start these VMs on another ESXi host\. For more information, see [Create a vSphere HA Cluster](https://docs.vmware.com/en/VMware-vSphere/6.5/com.vmware.vsphere.avail.doc/GUID-4BC60283-B638-472F-B1D2-1E4E57EAD213.html) in the VMware documentation\. You can also find information about enabling vCenter HA at [Configure vCenter HA Basic Option with the vSphere Web Client](https://docs.vmware.com/en/VMware-vSphere/6.7/com.vmware.vsphere.avail.doc/GUID-33AC12C8-EEB7-422D-831B-B1B5A7FECC44.html) in the VMware documentation\.

   You can also use vCenter alarms to alert you about the health of the underlying ESXi hosts on which you are running Amazon RDS on VMware\. For more information, see [Using Alarms](https://pubs.vmware.com/vsphere-50/index.jsp?topic=%2Fcom.vmware.wssdk.pg.doc_50%2FPG_Ch15_Alarms.17.5.html) in the VMware documentation\. If you get an alarm on ESXi host degradation, you can use VMware vMotion\. VMware vMotion can migrate the Amazon RDS on VMware VMs running on the host that has an issue to another ESXi host\. You can also use this capability during scheduled maintenance of your ESXi hosts\. For more information on vMotion, see [ Migration with vMotion](https://docs.vmware.com/en/VMware-vSphere/6.7/com.vmware.vsphere.vcenterhost.doc/GUID-D19EA1CB-5222-49F9-A002-4F8692B92D63.html) in the VMware documentation\.
**Note**  
vMotion storage is not supported with Amazon RDS on VMware\.

   Finally, you can enable a Distributed Resource scheduler \(DRS\) on your vSphere cluster to load balance the host memory and CPU\. For more information, see [ Enable vSphere HA and vSphere DRS in a Cluster \(MSCS\)](https://docs.vmware.com/en/VMware-vSphere/6.5/com.vmware.vsphere.mscs.doc/GUID-C228FA54-F621-45DA-8D62-AD8C118C89C0.html) in the VMware documentation\.

1. Meet the vSphere cluster requirements\.

   1. Meet the following data center requirements:
      + Select or create a virtual data center using vSphere Client or vSphere Web Client\.
      + Ensure that you have Admin privilege for the virtual data center\.

   1. Meet the following vSphere storage requirements:
      + All of the ESXi servers on the cluster must be connected to the same datastore\.
      + Ensure that your vSphere cluster is backed by a storage device that presents a single datastore using VMware Platform API \- VMFS compliant\.
**Note**  
Currently, working with a local datastore is not supported\.

   1. Meet the following vSphere hardware requirements:
      + 24 vCPU
      + 24 GB memory
      + 180 GB of storage

1. Meet the following vSphere environment requirements:
   + VMware vCenter Server version 6\.5 or 6\.7
   + VMware vSphere Server Enterprise Edition 6\.5 or 6\.7

   For specific release versions, see the [VMware Product Interoperability Matrices](https://www.vmware.com/resources/compatibility/sim/interop_matrix.php#interop&492=&1=&2=)\.

1. Gather the information required for onboarding\.

   1. Gather the following information about your vCenter configuration:
      + **vCenter NTP Server** – The DNS name or IPv4 address of the Network Time Protocol \(NTP\) server to which your ESXi hosts sync\.
      + **DNS server** – The IP address of the DNS server for the vCenter Server that is authoritative for your vCenter Server's private DNS zone\.
      + **Domain** – The private DNS subdomain of your vCenter Server\.
      + **vCenter DNS** – The DNS name of your vSphere Automation API endpoint\.
      + **vCenter Server Certificate** – A PEM\-formatted certificate used by your vCenter Server deployment for HTTPS and TLS\.
      + **VPN Originator IP** – The external source IPv4 address of packets leaving your virtual data center\.

        This address is used to configure an IP security \(IPSec\) VPN tunnel\. This VPN tunnel goes from your vSphere cluster to an RDS DMZ or demilitarized zone \(sometimes referred to as a perimeter network or screened subnet\) in AWS\. This DMZ is created specifically for that tunnel\.
**Note**  
This address must not change, and only vSphere clusters are supported\.

   1. Gather the following information about your ESXi host network \(Management Network\):
      + **Subnet** – The network address of the Management Network\.
      + **Netmask** – The subnet mask \(in dotted quad notation, for example 255\.255\.255\.128\) of the Management Network\.
      + **Gateway** – The gateway \(router\) for the Management Network\.
      + **Edge Router IP** – An unused IPv4 address on the Management Network, to be statically assigned to the third network interface on the virtual machine \(VM\) for the RDS Edge Router\.

        This is the only interface that will interact with your ESXi Management Network\.
**Note**  
Make sure that all of the vCenter Server and ESXi hosts are in the same Management Network or can be reached using the default gateway\.

1. Meet networking and access requirements\. 

   All the hosts \(including the NTP server, vCenter, and DNS server\) must fit one of two categories\. Either they must be on the Management Network subnet \(with the ESXi network as part of the same virtual LAN\)\. Or they must be reachable using the default gateway on the Internet Network \(ETH1 on Edge Router\)\.

   1. Meet the requirements for the Internet Network:
      + A network with outbound internet access, with a minimum speed of 1 Gbps\.
      + Outbound connectivity to the internet must have a ﬁxed, public\-facing IP \(Originator IP for outbound VPN\)\.
      + All public and internal URLs, including the vCenter fully qualified domain name \(FQDN\), must be DNS\-resolved\.
      + There must be access to public AWS service endpoints over HTTPS\.
      + For Microsoft SQL Server DB instances, access to Microsoft endpoints by using HTTPS, such as \*\.microsoft\.com \(http://microsoft\.com/\), must be reachable\.

        This requirement doesn’t apply to MySQL or PostgreSQL DB instances\.
      + There must be DHCP services on this interface with the default gateway\.
      + The DHCP broadcast must not cross over an up\-link\.
      + The network must allow outbound and related inbound traffic for ISAKMP \(UDP port 500\), IPSec NAT Traversal \(UDP port 4500\), and Encapsulating Security Payload \(IP protocol 50\)\.
      + The network must allow outbound and related inbound response traffic to TCP port 443 \(HTTPS to access public AWS service endpoints\)\.

   1. Meet the requirements for the Cluster Control Network:
      + There must be a new network dedicated to Amazon RDS on VMware with a unique virtual LAN \(VLAN\) ID\.
      + Amazon RDS on VMware assigns IP addresses in the predefined 54\.239\.236\.0/22 range using DHCP using the RDS Edge Router virtual appliance\. This address is a public IP address range managed by AWS but set aside for Amazon RDS on VMware use\. Therefore, it is important that the Cluster Control Network is isolated \(using VLAN tagging\)\. 
      + The network administrator must verify that broadcast packets don't cross over an up\-link\. Broadcast packets must be associated with a unique VLAN ID\.
      + The distributed port group must be accessible from all ESXi hosts that are part of the selected vSphere cluster\.
      + The distributed port group must use the elastic "port allocation" flag\.
      + After the distributed port group is created, you must provision a vmkernel adapter with replication and replication NFC traffic enabled\. This vmkernel adapter should use DHCP because it will be given an address by Amazon RDS on VMware\.
**Note**  
Provision VMKernel adapters for each of the cluster's ESXi hosts into the Cluster Control Network\.  
DHCP services are not required on the Cluster Control Network\.

   1. Meet the requirements for the Application Network:
      + Provide an existing network where you plan to deploy the DB instances\. Each DB instance will also have an interface in Cluster Control network, because all Amazon RDS operations happen over the cluster control network\.
      + The Application Network must be connected to a DHCP enabled interface\. This interface must provide a default gateway for the VMs that will connect to this network\.
      + DHCP broadcast must not cross over an up\-link\.
      + The distributed port group must be accessible from all ESXi hosts underlying the Amazon RDS on VMware cluster\.
      + The distributed port group must use the elastic "port allocation" flag\.

   1. Meet the requirements for the Management Network:
      + It must include the existing ESXi management network that exists on standard vSphere installations\.
      + All ESXi hosts that are part of the vSphere Cluster must be on the same Management Network\.
**Note**  
DHCP services are not required on the Management Network\.

   1. Meet the requirements for the vCenter server credentials\.

      Amazon RDS on VMware requires a set of vCenter server credentials \(a single sign\-on user name and password\) to use during the onboarding process\. This user creates four new SSO users scoped to the cluster\. The user also creates the resources to be used by the Amazon RDS on VMware management virtual machines and DB instances\. We recommend creating a new user with admin privileges to use during onboarding and removing the user after onboarding is complete\. Use a local single sign\-on \(SSO\) domain\. Active Directory domains aren't currently supported\.

      Add the new user to the following groups:
      + ADMINISTRATORS
      + CAADMINS
      + SYSTEMCONFIGURATION\.ADMINISTRATORS
      + LICENSESERVICE\.ADMINISTRATORS
      + COMPONENTMANAGER\.ADMINISTRATORS
      + SYSTEMCONFIGURATION\.BASHSHELLADMINISTRATORS

1. To use a proxy server for external traffic, complete the following prerequisites\. RDS on VMware connects with AWS services, such as Amazon CloudWatch and Amazon S3, over HTTPS\.

   1. Make sure that the proxy server is authenticated with transparent or password\-based methods\.

   1. Ensure that the proxy server maintains a trust store\.

      The proxy server is a client that initiates Transport Layer Security \(TLS\) connections with AWS services, such as Amazon CloudWatch and Amazon S3\. The proxy server must store CA certificates for these AWS services\. For more information, see [ Step 3: Install a TLS certificate on on\-premises servers and VMs](https://docs.aws.amazon.com/systems-manager/latest/userguide/hybrid-tls-certificate.html) in the *AWS Systems Manager User Guide*\.

   1. Ensure that your proxy server is reachable via the Internet Network\.

1. Validate the vSphere environment configuration\.

   Complete the following steps to validate that the vSphere environment is properly prepared for onboarding Amazon RDS on VMware\.

   1. Validate the vCenter version and access requirements:

      1. Log in to the vSphere Web Client using the user that you plan to provide during onboarding\.

      1. Choose **Home**\.

      1. Choose **Hosts and Clusters**\.

      1. Expand the target data center\.

      1. Expand the cluster\.

      1. Choose the ESXi host\.

      1. Choose the **Summary** tab\.

      1. Under **Configuration**, note the version in the **ESXi version** field\.

      For more information, see [ Determining the build number of VMware ESX/ESXi and VMware vCenter Server](https://kb.vmware.com/s/article/1022196) in the VMware documentation\.

   1. Validate that the vSphere environment requirements are met:
      + Verify that the user created for onboarding is present in the **Administrator** group\.
      + Ensure that a resource pool is present\. If one isn't, create one\.
      + All of the ESXi hosts must have the Cluster Control Network, Application Network, Internet Network, and Management Network linked to them\.
      + Determine whether OVF deployment timeout is applicable\. For more information, see [Cannot deploy an OVF in vCenter 6\.5\.0b \(build 5178943\) and later \(2150693\)](https://kb.vmware.com/s/article/2150693) in the VMware documentation\.

   1. Validate that the networking and access requirements are met:
      + Ensure that the Internet Network is running a DHCP server and that you can ping `8.8.8.8`\.

        To do this, you can put a small Linux VM or a Microsoft Windows VM on the Internet Network\. You can then test if the network interface gets the IP address and if you can ping `8.8.8.8`\.
      + Ensure that the Application Network is running a DHCP server\.

        To do this, you can put a small Linux VM or a Windows VM on the Internet Network\. You can then test if the network interface gets the IP address\.
      + Ensure that the free IP on the Management Network is not attached to any network interface on any other appliance\.

        Log in to the ESXi host or the vCenter and try to ping the free IP\. You *should not* be able to ping it\.
      + Verify the VPN Originator IP\.

        To do this, you can put a small Linux VM or a Windows VM on the Internet Network and then run the following command\.

        ```
        curl checkip.amazonaws.com
        ```

        Or you can put a small Linux VM or a Windows VM on the Internet Network, open a web browser, and go to [ http://checkip\.amazonaws\.com/](http://checkip.amazonaws.com/)\.

        After determining the IP address, get the IP address for another VM on the Internet Network\. Then make sure that you're getting the same IP address\.

   1. Validate that the storage requirements are met:
      + Storage must be in Network File System \(NFS\), VMware Virtual Machine File System \(VMFS\), or vSAN format\.

1. Configure your local DNS server\.

   You configure your applications to access Amazon RDS on VMware DB instances by DNS name, rather than by the IP address\. You do this because dynamically assigned IP addresses can change\. 

   To make sure that DNS resolution can occur for Amazon RDS on VMware DB instance endpoints, configure your local DNS server or servers\. You configure these to forward requests for `*.rdsonvmware.rds.amazonaws.com` to one of the IP addresses on the RDS Edge Router VM\. Use the IP address of either the Management Network or the internet\-facing interface, whichever is better for your network environment\. You can find your DB instance endpoints using the AWS Management Console, AWS CLI, or RDS API\.

   The following is an example of how this might look\. In this example, you use BIND \(that is, you are modifying `named.conf`\) and the RDS Edge Router IP where requests are forwarded is 10\.1\.2\.3\.

   ```
   ...
   
   zone rdsonvmware.rds.amazonaws.com {
   
     type forward;
   
     forward only;
   
     forwarders { 10.1.2.3; }
   
   };
   
   ...
   ```

1. Authorize a user to onboard Amazon RDS on VMware\.

   A user must be authorized to onboard Amazon RDS on VMware\. To do this, you add a predefined AWS Identity and Access Management \(IAM\) policy to the user, the `AmazonRDSDataFullAccess` policy\.

   You can also create an IAM policy that grants the required permissions to onboard Amazon RDS on VMware\. After you create the policy, add it to the user who you plan to onboard Amazon RDS on VMware\.

   The following policy provides the minimum required permissions for a user to onboard Amazon RDS on VMware\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Sid": "RDSonVMware",
               "Effect": "Allow",
               "Action": [
                   "rds:DescribeCustomAvailabilityZones",
                   "rds:RegisterCustomAvailabilityZone"
               ],
               "Resource": "*"
           }
       ]
   }
   ```

   For information about creating an IAM policy, see [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html) in the *AWS Identity and Access Management User Guide*\.

   For information about adding an IAM policy to a user, see [Adding and Removing IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_manage-attach-detach.html) in the *AWS Identity and Access Management User Guide*\.