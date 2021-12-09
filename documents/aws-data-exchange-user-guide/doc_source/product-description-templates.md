# Product Description Templates<a name="product-description-templates"></a>

When listing a product on AWS Data Exchange, you should include a long description that contains all the information necessary for subscribers to understand what your product offers\. This section contains markdown templates that you can use as a starting point for the long description of a number of popular product types\.

You can copy and paste the content below in your long description and use whichever sections apply to your data product: 

## Generic long description template<a name="generic-template"></a>

```
---
## PRODUCT TITLE Data Product Overview
Instructions:Provide a description of the data product and what it contains in this section.

---
## Use Cases
Instructions:Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Metadata
Instructions:Provide metadata of your data using a table. Examples include but are not limited to:  

Description | Value 
----|-----
Update Frequency | ADD INFO HERE
Data Source(s) | ADD INFO HERE
Original Publisher of data | ADD INFO HERE
Data Creation Date | ADD INFO HERE
Data Modification Date | ADD INFO HERE
Geographic coverage | ADD INFO HERE
Time period coverage | ADD INFO HERE
Is historical data “point-in-time” | YES OR NO
Data Set(s) Format(s) | ADD INFO HERE
Raw or scraped data | ADD INFO HERE
Key Fields | ADD INFO HERE
Key Words | ADD INFO HERE
Number of companies/brands covered | ADD INFO HERE

---
## Key Data Points
Key data points include: 

* Key Data Point: 
* Key Data Point:

---
## Additional Information

* [Data Schema] (ADD LINK HERE)
* [Data Dictionary] (ADD LINK HERE)
* [Data Source] (ADD LINK HERE)
* [Data Due Diligence Questionnaire] (ADD LINK HERE)
* [Sample Data Set] (ADD LINK HERE)
* [Link to Corresponding ADX Trial Product/ Link to Corresponding ADX Paid Product] (ADD LINK HERE)

---
## Pricing Information
If you would like to tell your subscribers that you would like them to inquire for custom pricing 
(ie you price based on other variables), you can explain here.

---
## Regulatory and Compliance Information
If this section is applicable, provide an overview of the regulatory guidance and compliance
for use of this product.  Are there exemptions that need to be linked in order for the data product to be published?

---
## Subscription Verification Request Information
If you are enabling subscription verification for your products, you may elect to indicate the information 
that you will require from the prospective subscriber i.e., EIN number, # of applications, # of users, # of regions, etc.

---
## Need Help?
* If you have questions about our products, contact us using the support information below.

---
## About Your Company
Provide a description and/or link about your company
* [Company Fact Sheet] (ADD LINK HERE)
```

## Financial services long description template<a name="financial-template"></a>

```
---
## PRODUCT TITLE Data Product Overview
Instructions:Provide a description of the data product and what it contains in this section.

---
## Use Cases
Instructions:Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Metadata
Instructions:Provide metadata of your data using a table. Examples include but are not limited to:  

Description | Value 
----|-----
Update Frequency | YOUR INFO HERE
Data Source(s) | YOUR INFO HERE
Original Publisher of data | YOUR INFO HERE
Data Creation Date | YOUR INFO HERE
Data Modification Date | YOUR INFO HERE
Geographic coverage | YOUR INFO HERE
Time period coverage | YOUR INFO HERE
Is historical data “point-in-time” | YES OR NO
Data Set(s) Format(s) | YOUR INFO HERE
Raw or scraped data | YOUR INFO HERE
Key Fields | YOUR INFO HERE
Key Words | YOUR INFO HERE
Number of companies/brands covered | YOUR INFO HERE
Standard entity identifiers | YOUR INFO HERE, EXAMPLE BELOW

examples include(include your identifier above then delete this section)  
* CUSIP Number: A unique identification number assigned to all stocks and registered bonds in the US & Canada
* ISIN: An International Securities Identification Number that uniquely identifies a specific securities issue (a series of stocks/bonds offered to raise funds from investors)
* RIC: The Reuters Instrument Code is used to identify financial instruments/indices used in Refinitiv financial information networks 
* Bloomberg ID: 12-digit alpha-numeric ID used to identify securities
* D-U-N-S Number: 9-digit identifier assigned to businesses by Dun & Bradstreet

---
## Tables
If this section is applicable, you can make a table and include information such as:

Description | Identifier | Format | Frequency
----|-----
FX FWD | FIGI | .CSV | Intraday
USD Deposits | CUSIP | .txt | End of Day
Interest Rate Swaps | ISIN | .json | Daily
Basis Swaps | CUSIP | .xml | Intraday

---
## Key Data Points
Examples of key data points include: 

* Symbol: Ticker symbol for the security
* Exchange: Exchange MIC identifier
* Currency: Trading currency code
* Open: Opening price for the day
* High: High price for the day
* Low: Low price for the day
* Last: Last price for the day
* Volume: Trading volume for the day
* Split Ratio: Ratio of new number of shares to old on the effective date
* Cash Dividend: Cash dividend amount on the ex-dividend date
* Dividend amount:
* Extra dividends:
* Total dividends paid this year:
* Effective dates:
* Textual descriptions of special dividends:
* Dividend Currency: Currency for the cash dividend

---
## Additional Information

* [Data Schema] (ADD LINK HERE)
* [Data Dictionary] (ADD LINK HERE)
* [Data Source] (ADD LINK HERE)
* [Data Due Diligence Questionnaire] (ADD LINK HERE)
* [Sample Data Set] (ADD LINK HERE)
* [Link to Corresponding ADX Trial Product/ Link to Corresponding ADX Paid Product] (ADD LINK HERE)

---
## Pricing Information
If you would like to tell your subscribers that you would like them to inquire for custom pricing 
(ie you price based on other variables), you can explain here.

---
## Regulatory and Compliance Information
If this section is applicable, provide an overview of the regulatory guidance and 
    compliance for use of this product.  Are there exemptions that need to be linked in order for 
    the data product to be published?

---
## Subscription Verification Request Information
If you are enabling subscription verification for your products, you may elect to indicate 
the information that you will require from the prospective subscriber i.e., EIN number, # of applications, 
# of users, # of regions, etc.

---
## Need Help?
* If you have questions about our products, contact us using the support information below. 

---
## About Your Company
Provide a description and/or link about your company
* [Company Fact Sheet] (ADD LINK HERE)
```

## Healthcare and life sciences long description template<a name="healthcare-template"></a>

```
---
## PRODUCT TITLE Data Product Overview
Instructions:Provide a description of the data product and what it contains in this section.

---
## Use Cases
Instructions:Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Metadata
Instructions:Provide metadata of your data using a table. Examples include but are not limited to:  

Description | Value 
----|-----
Update Frequency | YOUR INFO HERE
Data Source(s) | YOUR INFO HERE
Original Publisher of data | YOUR INFO HERE
Data Creation Date | YOUR INFO HERE
Data Modification Date | YOUR INFO HERE
Geographic coverage | YOUR INFO HERE
Time period coverage | YOUR INFO HERE
Is historical data “point-in-time” | YES OR NO
Data Set(s) Format(s) | YOUR INFO HERE
Raw or scraped data | YOUR INFO HERE
Key Fields | YOUR INFO HERE
Key Words | YOUR INFO HERE
Number of companies/brands covered | YOUR INFO HERE

---
## Key Data Points
Key data points include: 

* Key Data Point: 
* Key Data Point:

---
## Use Cases for the Data Set
Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Target Therapeutic Area / Disease Focus
Provide an overview of which therapeutic areas, diagnoses, procedures, medications, 
and more can be analyzed in the data listing, and can other data for different 
therapeutic areas be sourced.

---
## Data Engineering Overview
Provide an overview of how the raw data was engineered. Questions to answer:

* What data models were applied?
* What standards / terminologies applied?
* Was NLP post-processing used in the curation of the data?

---
## Additional Information

* [Data Schema] (ADD LINK HERE)
* [Data Dictionary] (ADD LINK HERE)
* [Data Source] (ADD LINK HERE)
* [Data Due Diligence Questionnaire] (ADD LINK HERE)
* [Sample Data Set] (ADD LINK HERE)
* [Link to Corresponding Trial Product/ Link to Corresponding Paid Product] (ADD LINK HERE)

---
## Pricing Information
If you would like to tell your subscribers that you would like them to inquire for
custom pricing (ie you price based on other variables), you can explain here.

---
## Regulatory and Compliance Information
If this section is applicable, provide an overview of the regulatory guidance and 
compliance for use of this product.  Are there exemptions that need to be linked in 
order for the data product to be published?

---
## Subscription Verification Request Information
If you are enabling subscription verification for your products, you may elect to 
indicate the information that you will require from the prospective subscriber i.e., 
EIN number, # of applications, # of users, # of regions, etc.

---
## Need Help?
* If you have questions about our products, contact us using the support information below. 

---
## About Your Company
Provide a description and/or link about your company
* [Company Fact Sheet] (ADD LINK HERE)
```

## Retail and location long description template<a name="retail-location-template"></a>

```
---
## PRODUCT TITLE Data Product Overview
Instructions:Provide a description of the data product and what it contains in this section.

---
## Use Cases
Instructions:Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Metadata
Instructions:Provide metadata of your data using a table. Examples include but are not limited to:  

Description | Value 
----|-----
Update Frequency | YOUR INFO HERE
Data Source(s) | YOUR INFO HERE
Original Publisher of data | YOUR INFO HERE
Data Creation Date | YOUR INFO HERE
Data Modification Date | YOUR INFO HERE
Geographic coverage | YOUR INFO HERE
Time period coverage | YOUR INFO HERE
Is historical data “point-in-time” | YES OR NO
Data Set(s) Format(s) | YOUR INFO HERE
Raw or scraped data | YOUR INFO HERE
Key Fields | YOUR INFO HERE
Key Words | YOUR INFO HERE
Number of companies/brands covered | YOUR INFO HERE
Contains Anonymous Personal Data | YES OR NO
Data Channels | Examples include web devices, mobile devices, CTV devices, offline purchases, household data, B2B data

---
## Tables
If you'd like to preview the format of the data file, you can make a table and include an example such as:

DMA | Category | Index (100 is baseline)
----|-----
DMA - New York City | Restaurant Transactions | 125 
DMA - Chicago | Restaurant Transactions | 150 
DMA - Los Angeles | Restaurant Transactions | 75 
DMA - New York City | Grocery store foot traffic | 120 | N/A | Weekly
DMA - Chicago | Grocery store foot traffic | 90 | N/A | Weekly
DMA - Los Angeles | Grocery store foot traffic | 150 | N/A | Weekly


---
## Dataset Specification
The following are examples of data set specifications that you can include if applicable: 

The datasets are updated at midnight EST daily.
The datasets are tied to a home address, and attributes correspond to the household level. 
Provider processes opt-outs on a daily basis and remove records from future files. 
Custom data cuts are available if desired. 

---
## Additional Information

* [Data Schema] (ADD LINK HERE)
* [Data Dictionary] (ADD LINK HERE)
* [Data Source] (ADD LINK HERE)
* [Data Due Diligence Questionnaire] (ADD LINK HERE)
* [Sample Data Set] (ADD LINK HERE)
* [Link to Corresponding ADX Trial Product/ Link to Corresponding ADX Paid Product] (ADD LINK HERE)

---
## Pricing Information
If you would like to tell your subscribers that you would like them to inquire for custom pricing
    (ie you price based on other variables), you can explain here.

---
## Regulatory and Compliance Information
If this section is applicable, provide an overview of the regulatory guidance and compliance 
    for use of this product.  Are there exemptions that need to be linked in order for the data product 
    to be published?

---
## Subscription Verification Request Information
If you are enabling subscription verification for your products, you may elect to indicate 
    the information that you will require from the prospective subscriber i.e., EIN number, # of applications, # of users, # of regions, etc.

---
## Need Help?
* If you have questions about our products, contact us using the support information below. 

---
## About Your Company
Provide a description and/or link about your company
* [Company Fact Sheet] (ADD LINK HERE)
```

## Marketing and advertising long description template<a name="marketing-advertising-template"></a>

```
---
## PRODUCT TITLE Data Product Overview
Instructions:Provide a description of the data product and what it contains in this section.

---
## Use Cases
Instructions:Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Metadata
Instructions:Provide metadata of your data using a table. Examples include but are not limited to:  

Description | Value 
----|-----
Update Frequency | YOUR INFO HERE
Data Source(s) | YOUR INFO HERE
Original Publisher of data | YOUR INFO HERE
Data Creation Date | YOUR INFO HERE
Data Modification Date | YOUR INFO HERE
Geographic coverage | YOUR INFO HERE
Time period coverage | YOUR INFO HERE
Is historical data “point-in-time” | YES OR NO
Data Set(s) Format(s) | YOUR INFO HERE
Raw or scraped data | YOUR INFO HERE
Key Fields | YOUR INFO HERE
Key Words | YOUR INFO HERE
Number of companies/brands covered | YOUR INFO HERE 
Contains Anonymous Personal Data | YES OR NO
Data Channels | Examples include web devices, mobile devices, CTV devices, offline purchases, household data, B2B data


---
## Dataset Specification
The following are examples of data set specifications that you may include if applicable: 

The datasets are updated at midnight EST daily.
Custom data cuts are available if desired. 

---
## Additional Information

* [Data Schema] (ADD LINK HERE)
* [Data Dictionary] (ADD LINK HERE)
* [Data Source] (ADD LINK HERE)
* [Data Due Diligence Questionnaire] (ADD LINK HERE)
* [Sample Data Set] (ADD LINK HERE)
* [Link to Corresponding ADX Trial Product/ Link to Corresponding ADX Paid Product] (ADD LINK HERE)

---
## Pricing Information
If you would like to tell your subscribers that you would like them to inquire for custom pricing
(ie you price based on other variables), you can explain here.

---
## Regulatory and Compliance Information
If this section is applicable, provide an overview of the regulatory guidance and compliance for use of this product.  
Are there exemptions that need to be linked in order for the data product to be published?

---
## Subscription Verification Request Information
If you are enabling subscription verification for your products, you may elect to indicate the information
that you will require from the prospective subscriber i.e., EIN number, # of applications, # of users, # of regions, etc.

---
## Need Help?
* If you have questions about our products, contact us using the support information below. 

---
## About Your Company
Provide a description and/or link about your company
* [Company Fact Sheet] (ADD LINK HERE)
```

## Media and entertainment long description template<a name="media-entertainment-template"></a>

```
---
## PRODUCT TITLE Data Product Overview
Instructions:Provide a description of the data product and what it contains in this section.

---
## Use Cases
Instructions:Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Metadata
Instructions:Provide metadata of your data using a table. Examples include but are not limited to:  

Description | Value 
----|-----
Update Frequency | ADD INFO HERE
Data Source(s) | ADD INFO HERE
Original Publisher of data | ADD INFO HERE
Data Creation Date | ADD INFO HERE
Data Modification Date | ADD INFO HERE
Geographic coverage | ADD INFO HERE
Time period coverage | ADD INFO HERE
Is historical data “point-in-time” | YES OR NO
Data Set(s) Format(s) | ADD INFO HERE
Raw or scraped data | ADD INFO HERE
Key Fields | ADD INFO HERE
Key Words | ADD INFO HERE
Number of companies/brands covered | ADD INFO HERE

---
Table format examples
 
## Dataset(s) Inventory

File Description | Format | Initial Size | Revision Frequency | Revision Type 
----|-----
Data Dictionary | .PDF | 1 MB | N/A | N/A
New Text Archives | .CSV | 100 GB | Hourly | Incremental
Image Library | .JSON | 1.5 TB | Weekly | Incremental
Ratings | .JSON | 50 MB | Every 5 Min | Republish 

## Sample Data
Date  |  Publisher | Title | Plays | Price 
----|----
MMDDYYYY | Publisher ABC | Game XYZ | XXXXXX | Free 

---
## Key Data Points
Examples of key data points include: 

* Publisher or Studio
* Title
* Artist Name
* Producer Name
* Director Name
* Distributor
* Distribution Channel 
* Release Date
* Publish Date
* Format
* Operating System
* Sale Price
* # of Transactions
* # of Streams
* Average rating
* Designated Market Area (DMA)
* Zip or Postal Code

---
## Additional Information

* [Data Schema] (ADD LINK HERE)
* [Data Dictionary] (ADD LINK HERE)
* [Data Source] (ADD LINK HERE)
* [Data Due Diligence Questionnaire] (ADD LINK HERE)
* [Sample Data Set] (ADD LINK HERE)
* [Link to Corresponding ADX Trial Product/ Link to Corresponding ADX Paid Product] (ADD LINK HERE)

---
## Pricing Information
If you would like to tell your subscribers that you would like them to inquire for custom pricing 
(ie you price based on other variables), you can explain here.

---
## Regulatory and Compliance Information
If this section is applicable, provide an overview of the regulatory guidance and compliance for use of this product.  
Are there exemptions that need to be linked in order for the data product to be published?

---
## Subscription Verification Request Information
If you are enabling subscription verification for your products, you may elect to indicate the information 
that you will require from the prospective subscriber i.e., EIN number, # of applications, # of users, # of regions, etc.

---
## Need Help?
* If you have questions about our products, contact us using the support information below. 

---
## About Your Company
Provide a description and/or link about your company
* [Company Fact Sheet] (ADD LINK HERE)
```

## Public sector long description template<a name="public-sector-template"></a>

```
---
## PRODUCT TITLE Data Product Overview
Instructions: Provide a description of the data product and what it contains in this section.

---
## Applicable Industries for Data Product Usage  
Provide a list of industries that this data product is applicable to.

---
## Use Cases
Instructions:Provide a handful of use-cases or guidance of best ways to utilize the data product.

---
## Metadata
Instructions:Provide metadata of your data using a table. Examples include but are not limited to:  

Description | Value 
----|-----
Update Frequency | YOUR INFO HERE
Data Source(s) | YOUR INFO HERE
Original Publisher of data | YOUR INFO HERE
Data Creation Date | YOUR INFO HERE
Data Modification Date | YOUR INFO HERE
Geographic coverage | YOUR INFO HERE
Time period coverage | YOUR INFO HERE
Is historical data “point-in-time” | YES OR NO
Data Set(s) Format(s) | YOUR INFO HERE
Raw or scraped data | YOUR INFO HERE
Key Fields | YOUR INFO HERE
Key Words | YOUR INFO HERE
Number of companies/brands covered | YOUR INFO HERE

---
## Additional Information

* [Data Schema] (ADD LINK HERE)
* [Data Dictionary] (ADD LINK HERE)
* [Data Source] (ADD LINK HERE)
* [Data Due Diligence Questionnaire] (ADD LINK HERE)
* [Sample Data Set] (ADD LINK HERE)
* [Link to Corresponding ADX Trial Product/ Link to Corresponding ADX Paid Product] (ADD LINK HERE)

---
## Pricing Information
If you would like to tell your subscribers that you would like them to inquire for 
custom pricing (ie you price based on other variables), you can explain here.

---
## Regulatory and Compliance Information
If this section is applicable, provide an overview of the regulatory guidance and 
compliance for use of this product.  Are there exemptions that need to be linked in 
order for the data product to be published?

---
## Subscription Verification Request Information
If you are enabling subscription verification for your products, you may elect to 
indicate the information that you will require from the prospective subscriber i.e., 
EIN number, # of applications, # of users, # of regions, etc.

---
## Need Help?
* If you have questions about our products, contact us using the support information below. 

---
## About Your Company
Provide a description and/or link about your company
* [Company Fact Sheet] ADD LINK HERE
```