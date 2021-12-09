# WPA2 Enterprise Prerequisite<a name="dst-beta-prereq"></a>

If you plan to use WPA2 Enterprise Wi\-Fi to set up your shared devices, you will specify this network security type later in the Device Setup Tool\. For more information, see [Run the Device Setup Tool](getting-started.md#run-tool)\. However, you must create a Private Certificate Authority \(PCA\) in AWS Certificate Manager \(ACM\)\. To do this, follow these steps:

1. [Create a Private Certificate Authority](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaCreateCa.html)

1. [Get a Certificate Signing Request \(CSR\)](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaGetCsr.html)

1. [Sign Your Private CA Certificate](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaSignCert.html)

1. [Import Your Private CA Certificate into ACM PCA](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaImportCaCert.html)