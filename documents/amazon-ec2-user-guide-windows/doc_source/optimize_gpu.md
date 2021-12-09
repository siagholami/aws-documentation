# Optimizing GPU settings<a name="optimize_gpu"></a>

There are several GPU setting optimizations that you can perform to achieve the best performance on G3, G4, P2, P3, and P3dn instances\. By default, the NVIDIA driver uses an autoboost feature, which varies the GPU clock speeds\. By disabling the autoboost feature and setting the GPU clock speeds to their maximum frequency, you can consistently achieve the maximum performance with your GPU instances\.

**To optimize GPU settings**

1. Open a PowerShell window and navigate to the NVIDIA installation folder\.

   ```
   cd "C:\Program Files\NVIDIA Corporation\NVSMI"
   ```

1. Disable the autoboost feature for all GPUs on the instance\.

   ```
   .\nvidia-smi --auto-boost-default=0
   ```
**Note**  
GPUs on P3, P3dn, and G4 instances do not support autoboost\.

1. Set all GPU clock speeds to their maximum frequency\. Use the memory and graphics clock speeds specified in the following commands\.
**Note**  
Some versions of the NVIDIA driver do not allow setting application clock speed and throw a `"Setting applications clocks is not supported for GPU …"` error, which you can ignore\.
   + G3 instances:

     ```
     .\nvidia-smi -ac "2505,1177"
     ```
   + G4 instances:

     ```
     .\nvidia-smi -ac "5001,1590"
     ```
   + P2 instances:

     ```
     .\nvidia-smi -ac "2505,875"
     ```
   + P3 and P3dn instances:

     ```
     .\nvidia-smi -ac "877,1530"
     ```