# Personally Identifiable Information<a name="macie-classify-objects-pii"></a>

Object classification by personally identifiable information \(PII\) is based on recognizing any personally identifiable artifacts based on industry standards such as NIST\-80\-122 and FIPS 199\. Macie can recognize the following PII artifacts: 
+ Full names
+ Mailing addresses
+ Email addresses
+ Credit card numbers
+ IP addresses \(IPv4 and IPv6\)
+ Drivers license IDs \(USA\)
+ National identification numbers \(USA\)
+ Birth dates

As part of PII object classification, Macie also assigns each matching object a PII impact of high, moderate, and low using the following criteria:
+ High
  + >= 1 full name and credit card
  + >= 50 names or emails and any combination of other PII
+ Moderate
  + >= 5 names or emails and any combination of other PII
+ Low
  + 1–5 names or emails and any combination of PII
  + Any quantity of PII attributes above \(without names or emails\)