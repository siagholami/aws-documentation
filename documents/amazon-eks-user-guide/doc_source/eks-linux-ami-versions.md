# Amazon EKS optimized Amazon Linux AMI versions<a name="eks-linux-ami-versions"></a>

This topic lists versions of the Amazon EKS optimized Amazon Linux AMIs and their corresponding versions of `kubelet`, Docker, the Linux kernel, and the [Packer build script](eks-ami-build-scripts.md) configuration\.

The Amazon EKS optimized AMI metadata, including the AMI ID, for each variant can be retrieved programmatically\. For more information, see [Retrieving Amazon EKS optimized Amazon Linux AMI IDs](retrieve-ami-id.md)\.

AMIs are versioned by Kubernetes version and the release date of the AMI in the following format:

```
k8s_major_version.k8s_minor_version.k8s_patch_version-release_date
```

## Amazon EKS optimized Amazon Linux AMI<a name="eks-al2-ami-versions"></a>

The tables below lists the current and previous versions of the Amazon EKS optimized Amazon Linux AMI\.


**Kubernetes version 1\.17**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | 
| --- | --- | --- | --- | --- | 
| 1\.17\.9\-20200904 | 1\.17\.9 | 19\.03\.6\-ce\-4 | 4\.14\.193 | v20200904 | 
| 1\.17\.9\-20200814 | 1\.17\.9 | 19\.03\.6\-ce\-4 | 4\.14\.186 | v20200814 | 
| 1\.17\.9\-20200723 | 1\.17\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 
| 1\.17\.7\-20200710 | 1\.17\.7 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 
| 1\.17\.7\-20200709 | 1\.17\.7 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 


**Kubernetes version 1\.16**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | 
| --- | --- | --- | --- | --- | 
| 1\.16\.13\-20200904 | 1\.16\.13 |  19\.03\.6\-ce\-4  | 4\.14\.193 | v20200904 | 
| 1\.16\.13\-20200814 | 1\.16\.13 |  19\.03\.6\-ce\-4  | 4\.14\.186 | v20200814 | 
| 1\.16\.13\-20200723 | 1\.16\.13 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 
| 1\.16\.12\-20200710 | 1\.16\.12 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 
| 1\.16\.12\-20200709 | 1\.16\.12 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 
| 1\.16\.8\-20200615 | 1\.16\.8 | 19\.03\.6\-ce | 4\.14\.181 | v20200615 | 
| 1\.16\.8\-20200609 | 1\.16\.8 | 19\.03\.6\-ce | 4\.14\.181 | v20200609 | 
| 1\.16\.8\-20200531 | 1\.16\.8 | 18\.09\.9\-ce | 4\.14\.177 | v20200531 | 
| 1\.16\.8\-20200507 | 1\.16\.8 | 18\.09\.9\-ce | 4\.14\.177 | v20200507 | 
| 1\.16\.8\-20200423 | 1\.16\.8 | 18\.09\.9\-ce | 4\.14\.173 | v20200423 | 


**Kubernetes version 1\.15Kubernetes version 1\.15**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | 
| --- | --- | --- | --- | --- | 
| 1\.15\.11\-20200904 | 1\.15\.11 | 19\.03\.6\-ce\-4 | 4\.14\.193 | v20200904 | 
| 1\.15\.11\-20200814 | 1\.15\.11 | 19\.03\.6\-ce\-4 | 4\.14\.186 | v20200814 | 
| 1\.15\.11\-20200723 | 1\.15\.11 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 
| 1\.15\.11\-20200710 | 1\.15\.11 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 
| 1\.15\.11\-20200709 | 1\.15\.11 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 
|  1\.15\.11\-20200615  |  1\.15\.11  |  19\.03\.6\-ce  |  4\.14\.181  |  v20200615  | 
|  1\.15\.11\-20200609  |  1\.15\.11  |  19\.03\.6\-ce  |  4\.14\.181  |  v20200609  | 
|  1\.15\.11\-20200531  |  1\.15\.11  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200531  | 
|  1\.15\.11\-20200507  |  1\.15\.11  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200507  | 
|  1\.15\.11\-20200423  |  1\.15\.11  |  18\.09\.9\-ce  |  4\.14\.173  |  v20200423  | 
|  1\.15\.10\-20200406  |  1\.15\.10  |  18\.09\.9\-ce  |  4\.14\.173  |  v20200406  | 
|  1\.15\.10\-20200228  |  1\.15\.10  |  18\.09\.9\-ce  |  4\.14\.165  |  v20200228  | 


**Kubernetes version 1\.14**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | 
| --- | --- | --- | --- | --- | 
| 1\.14\.9\-20200904 | 1\.14\.9 | 19\.03\.6\-ce\-4 | 4\.14\.193 | v20200904 | 
| 1\.14\.9\-20200814 | 1\.14\.9 | 19\.03\.6\-ce\-4 | 4\.14\.186 | v20200814 | 
| 1\.14\.9\-20200723 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 
| 1\.14\.9\-20200710 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 
| 1\.14\.9\-20200709 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 
| 1\.14\.9\-20200615 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200615 | 
| 1\.14\.9\-20200609 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200609 | 
| 1\.14\.9\-20200531 | 1\.14\.9 | 18\.09\.9\-ce | 4\.14\.177 | v20200531 | 
| 1\.14\.9\-20200507 | 1\.14\.9 | 18\.09\.9\-ce | 4\.14\.177 | v20200507 | 
| 1\.14\.9\-20200423 | 1\.14\.9 | 18\.09\.9\-ce | 4\.14\.173 | v20200423 | 
| 1\.14\.9\-20200406 | 1\.14\.9 | 18\.09\.9\-ce | 4\.14\.173 | v20200406 | 
| 1\.14\.9\-20200406 | 1\.14\.9 | 18\.09\.9\-ce | 4\.14\.173 | v20200406 | 
|  1\.14\.9\-20200228  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.165  |  v20200228  | 
|  1\.14\.9\-20200122  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.158  |  v20200122  | 
|  1\.14\.8\-20191213  |  1\.14\.8  |  18\.09\.9\-ce  |  4\.14\.154  |  v20191213  | 
| 1\.14\.7\-20191119 | 1\.14\.7 | 18\.09\.9\-ce | 4\.14\.152 | v20191119 | 
| 1\.14\.7\-20190927 | 1\.14\.7 | 18\.06\.1\-ce | 4\.14\.146 | v20190927 | 

## Amazon EKS optimized accelerated Amazon Linux AMI<a name="eks-gpu-ami-versions"></a>

The tables below list the current and previous versions of the Amazon EKS\-optimized accelerated Amazon Linux AMI\.


**Kubernetes version 1\.17**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | NVIDIA driver version | 
| --- | --- | --- | --- | --- | --- | 
| 1\.17\.9\-20200904 | 1\.17\.9 | 19\.03\.6\-ce\-4 | 4\.14\.193 | v20200904 | 418\.87\.00 | 
| 1\.17\.9\-20200814 | 1\.17\.9 | 19\.03\.6\-ce\-4 | 4\.14\.186 | v20200814 | 418\.87\.00 | 
| 1\.17\.9\-20200723 | 1\.17\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 418\.87\.00 | 
| 1\.17\.7\-20200710 | 1\.17\.7 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 418\.87\.00 | 
| 1\.17\.7\-20200709 | 1\.17\.7 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 418\.87\.00 | 


**Kubernetes version 1\.16**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | NVIDIA driver version | 
| --- | --- | --- | --- | --- | --- | 
| 1\.16\.13\-20200904 | 1\.16\.13 | 19\.03\.6\-ce\-4 | 4\.14\.193 | v20200904 | 418\.87\.00 | 
| 1\.16\.13\-20200814 | 1\.16\.13 | 19\.03\.6\-ce\-4 | 4\.14\.186 | v20200814 | 418\.87\.00 | 
| 1\.16\.13\-20200723 | 1\.16\.13 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 418\.87\.00 | 
| 1\.16\.12\-20200710 | 1\.16\.12 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 418\.87\.00 | 
| 1\.16\.12\-20200709 | 1\.16\.12 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 418\.87\.00 | 
|  1\.16\.8\-20200615  |  1\.16\.8  |  19\.03\.6\-ce  |  4\.14\.181  |  v20200615  |  418\.87\.00  | 
|  1\.16\.8\-20200609  |  1\.16\.8  |  19\.03\.6\-ce  |  4\.14\.181  | v20200609 |  418\.87\.00  | 
|  1\.16\.8\-20200531  |  1\.16\.8  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200531  |  418\.87\.00  | 
|  1\.16\.8\-20200507  |  1\.16\.8  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200507  |  418\.87\.00  | 
|  1\.16\.8\-20200423  |  1\.16\.8  |  18\.09\.9\-ce  |  4\.14\.173  |  v20200423  |  418\.87\.00  | 


**Kubernetes version 1\.15**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | NVIDIA driver version | 
| --- | --- | --- | --- | --- | --- | 
| 1\.15\.11\-20200904 | 1\.15\.11 | 19\.03\.6\-ce\-4 | 4\.14\.193 | v20200904 | 418\.87\.00 | 
| 1\.15\.11\-20200814 | 1\.15\.11 | 19\.03\.6\-ce\-4 | 4\.14\.186 | v20200814 | 418\.87\.00 | 
| 1\.15\.11\-20200723 | 1\.15\.11 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 418\.87\.00 | 
| 1\.15\.11\-20200710 | 1\.15\.11 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 418\.87\.00 | 
| 1\.15\.11\-20200709 | 1\.15\.11 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 418\.87\.00 | 
|  1\.15\.11\-20200615  |  1\.15\.11  |  19\.03\.6\-ce  |  4\.14\.181  |  v20200615  |  418\.87\.00  | 
|  1\.15\.11\-20200609  |  1\.15\.11  | 19\.03\.6\-ce |  4\.14\.181  |  v20200609  |  418\.87\.00  | 
|  1\.15\.11\-20200531  |  1\.15\.11  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200531  |  418\.87\.00  | 
|  1\.15\.11\-20200507  |  1\.15\.11  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200507  |  418\.87\.00  | 
|  1\.15\.11\-20200423  |  1\.15\.11  |  18\.09\.9\-ce  |  4\.14\.173  |  v20200423  |  418\.87\.00  | 
|  1\.15\.10\-20200406  |  1\.15\.10  |  18\.09\.9\-ce  |  4\.14\.173  |  v20200406  |  418\.87\.00  | 
|  1\.15\.10\-20200228  |  1\.15\.10  |  18\.09\.9\-ce  |  4\.14\.165  |  v20200228  |  418\.87\.00  | 


**Kubernetes version 1\.14**  

| AMI version | `kubelet` version | Docker version | Kernel version | Packer version | NVIDIA driver version | 
| --- | --- | --- | --- | --- | --- | 
| 1\.14\.9\-20200904 | 1\.14\.9 | 19\.03\.6\-ce\-4 | 4\.14\.193 | v20200904 | 418\.87\.00 | 
| 1\.14\.9\-20200814 | 1\.14\.9 | 19\.03\.6\-ce\-4 | 4\.14\.186 | v20200814 | 418\.87\.00 | 
| 1\.14\.9\-20200723 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200723 | 418\.87\.00 | 
| 1\.14\.9\-20200710 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200710 | 418\.87\.00 | 
| 1\.14\.9\-20200709 | 1\.14\.9 | 19\.03\.6\-ce | 4\.14\.181 | v20200709 | 418\.87\.00 | 
|  1\.14\.9\-20200615  |  1\.14\.9  |  19\.03\.6\-ce  |  4\.14\.181  |  v20200615  |  418\.87\.00  | 
|  1\.14\.9\-20200609  |  1\.14\.9  |  19\.03\.6\-ce  |  4\.14\.181  |  v20200609  |  418\.87\.00  | 
|  1\.14\.9\-20200531  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200531  |  418\.87\.00  | 
|  1\.14\.9\-20200507  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.177  |  v20200507  |  418\.87\.00  | 
|  1\.14\.9\-20200423  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.173  |  v20200423  |  418\.87\.00  | 
|  1\.14\.9\-20200406  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.173  |  v20200406  |  418\.87\.00  | 
|  1\.14\.9\-20200228  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.165  |  v20200228  |  418\.87\.00  | 
|  1\.14\.9\-20200122  |  1\.14\.9  |  18\.09\.9\-ce  |  4\.14\.158  |  v20200122  |  418\.87\.00  | 
|  1\.14\.8\-20191213  |  1\.14\.8  |  18\.09\.9\-ce  |  4\.14\.154  |  v20191213  |  418\.87\.00  | 
|  1\.14\.7\-20191119  |  1\.14\.7  |  18\.09\.9\-ce  |  4\.14\.152  |  v20191119  |  418\.87\.00  | 
|  1\.14\.7\-20190927  |  1\.14\.7  |  18\.06\.1\-ce  |  4\.14\.146  |  v20190927  |  418\.87\.00  | 