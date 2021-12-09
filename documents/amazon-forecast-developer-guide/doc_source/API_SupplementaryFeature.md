# SupplementaryFeature<a name="API_SupplementaryFeature"></a>

Describes a supplementary feature of a dataset group\. This object is part of the [InputDataConfig](API_InputDataConfig.md) object\.

The only supported feature is a holiday calendar\. If you use the calendar, all data in the datasets should belong to the same country as the calendar\. For the holiday calendar data, see the [Jollyday](http://jollyday.sourceforge.net/data.html) website\.

Holidays for India, Korea, and United Arab Emirates are not included in the Jollyday library, but are supported by Amazon Forecast\. Their holidays are:

 **"IN" \- INDIA** 
+  `JANUARY 26 - REPUBLIC DAY` 
+  `AUGUST 15 - INDEPENDENCE DAY` 
+  `OCTOBER 2 - GANDHI'S BIRTHDAY` 

 **"KR" \- KOREA** 
+  `JANUARY 1 - NEW YEAR` 
+  `MARCH 1 - INDEPENDENCE MOVEMENT DAY` 
+  `MAY 5 - CHILDREN'S DAY` 
+  `JUNE 6 - MEMORIAL DAY` 
+  `AUGUST 15 - LIBERATION DAY` 
+  `OCTOBER 3 - NATIONAL FOUNDATION DAY` 
+  `OCTOBER 9 - HANGEUL DAY` 
+  `DECEMBER 25 - CHRISTMAS DAY` 

 **"AE" \- UNITED ARAB EMIRATES** 
+  `JANUARY 1 - NEW YEAR` 
+  `DECEMBER 1 - COMMEMORATION DAY` 
+  `DECEMBER 2-3 - NATIONAL DAY` 
+  `RAMADAN*` 
+  `EID AL-FITR*` 
+  `EID AL-ADHA*` 
+  `ISLAMIC NEW YEAR*` 

\*Islamic holidays are determined according to moon sighting\.

## Contents<a name="API_SupplementaryFeature_Contents"></a>

 **Name**   <a name="forecast-Type-SupplementaryFeature-Name"></a>
The name of the feature\. This must be "holiday"\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 **Value**   <a name="forecast-Type-SupplementaryFeature-Value"></a>
One of the following 2 letter country codes:  
+ "AL" \- ALBANIA
+ "AR" \- ARGENTINA
+ "AT" \- AUSTRIA
+ "AU" \- AUSTRALIA
+ "BA" \- BOSNIA HERZEGOVINA
+ "BE" \- BELGIUM
+ "BG" \- BULGARIA
+ "BO" \- BOLIVIA
+ "BR" \- BRAZIL
+ "BY" \- BELARUS
+ "CA" \- CANADA
+ "CL" \- CHILE
+ "CO" \- COLOMBIA
+ "CR" \- COSTA RICA
+ "HR" \- CROATIA
+ "CZ" \- CZECH REPUBLIC
+ "DK" \- DENMARK
+ "EC" \- ECUADOR
+ "EE" \- ESTONIA
+ "ET" \- ETHIOPIA
+ "FI" \- FINLAND
+ "FR" \- FRANCE
+ "DE" \- GERMANY
+ "GR" \- GREECE
+ "HU" \- HUNGARY
+ "IS" \- ICELAND
+ "IN" \- INDIA
+ "IE" \- IRELAND
+ "IT" \- ITALY
+ "JP" \- JAPAN
+ "KZ" \- KAZAKHSTAN
+ "KR" \- KOREA
+ "LV" \- LATVIA
+ "LI" \- LIECHTENSTEIN
+ "LT" \- LITHUANIA
+ "LU" \- LUXEMBOURG
+ "MK" \- MACEDONIA
+ "MT" \- MALTA
+ "MX" \- MEXICO
+ "MD" \- MOLDOVA
+ "ME" \- MONTENEGRO
+ "NL" \- NETHERLANDS
+ "NZ" \- NEW ZEALAND
+ "NI" \- NICARAGUA
+ "NG" \- NIGERIA
+ "NO" \- NORWAY
+ "PA" \- PANAMA
+ "PY" \- PARAGUAY
+ "PE" \- PERU
+ "PL" \- POLAND
+ "PT" \- PORTUGAL
+ "RO" \- ROMANIA
+ "RU" \- RUSSIA
+ "RS" \- SERBIA
+ "SK" \- SLOVAKIA
+ "SI" \- SLOVENIA
+ "ZA" \- SOUTH AFRICA
+ "ES" \- SPAIN
+ "SE" \- SWEDEN
+ "CH" \- SWITZERLAND
+ "UA" \- UKRAINE
+ "AE" \- UNITED ARAB EMIRATES
+ "US" \- UNITED STATES
+ "UK" \- UNITED KINGDOM
+ "UY" \- URUGUAY
+ "VE" \- VENEZUELA
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\_\-]+$`   
Required: Yes

## See Also<a name="API_SupplementaryFeature_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/SupplementaryFeature) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/SupplementaryFeature) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/SupplementaryFeature) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/SupplementaryFeature) 