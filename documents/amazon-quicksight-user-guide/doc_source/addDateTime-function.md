# `addDateTime`<a name="addDateTime-function"></a>

`addDateTime` adds or subtracts a unit of time from a datetime\. For example, `addDateTime(2,'YYYY',parseDate('02-JUL-2018', 'dd-MMM-yyyy') )` returns `02-JUL-2020`\. You can use this function to perform date math on your date and time data\. 

`addDateTime` is not supported for use with analyses based on [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="addDateTime-function-syntax"></a>

```
addDateTime(amount, period, datetime)
```

### Arguments<a name="addDateTime-function-arguments"></a>

 *amount*   
A positive or negative integer value that represents the amount of time that you want to add or subtract from the provided datetime field\. 

 *period*   
A positive or negative value that represents the amount of time that you want to add or subtract from the provided datetime field\. Valid periods are as follows:   
+ YYYY: This returns the year portion of the date\. 
+ Q: This returns the quarter that the date belongs to \(1–4\)\. 
+ MM: This returns the month portion of the date\. 
+ DD: This returns the day portion of the date\. 
+ WK: This returns the week portion of the date\. The week starts on Sunday in Amazon QuickSight\. 
+ HH: This returns the hour portion of the date\. 
+ MI: This returns the minute portion of the date\. 
+ SS: This returns the second portion of the date\. \(SS is not supported when added inside SPICE\-based analyses\.\) 

 *datetime*   
The date or time that you want to perform date math on\. 

### Return Type<a name="addDateTime-function-return-type"></a>

Datetime

### Example<a name="addDateTime-function-example"></a>

Let's say you have a field called `purchase_date` that has the following values\.

```
2018 May 13 13:24
2017 Jan 31 23:06
2016 Dec 28 06:45
```

Using the following calculations, `addDateTime` modifies the values as shown following\.

```
addDateTime(-2, 'YYYY', purchaseDate)

2016 May 13 13:24
2015 Jan 31 23:06
2014 Dec 28 06:45


addDateTime(4, 'DD', purchaseDate)

2018 May 17 13:24
2017 Feb 4 23:06
2017 Jan 1 06:45


addDateTime(20, 'MI', purchaseDate)

2018 May 13 13:44
2017 Jan 31 23:26
2016 Dec 28 07:05
```