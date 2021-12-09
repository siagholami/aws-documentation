# Creating and Signing a Private CA Certificate<a name="PcaTsSignCsr"></a>

After you create your private CA, you must retrieve the CSR and submit it to an intermediate or root CA in your X\.509 infrastructure\. Your CA uses the CSR to create your private CA certificate and then signs the certificate before returning it to you\. 

Unfortunately, it is not possible to provide specific advice on problems related to creating and signing your private CA certificate\. The details of your X\.509 infrastructure and the CA hierarchy within it are beyond the scope of this documentation\. 