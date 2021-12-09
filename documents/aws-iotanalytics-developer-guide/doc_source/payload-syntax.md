# Message payload syntax<a name="payload-syntax"></a>

The field names of message payloads \(data\) that you send to AWS IoT Analytics: 
+ Must contain only alphanumeric characters and underscores \(\_\); no other special characters are allowed
+ Must begin with an alphabetic character or single underscore \(\_\)\.
+ Cannot contain hyphens \(\-\)\.
+ In regular expression terms: "`^[A-Za-z_]([A-Za-z0-9]*|[A-Za-z0-9][A-Za-z0-9_]*)$`"\. 
+ Cannot be greater than 255 characters\.
+ Are case\-insensitive\. Fields named "foo" and "FOO" in the same payload are considered duplicates\.

For example, `{"temp_01": 29}` or `{"_temp_01": 29}` are valid, but ` {"temp-01": 29}`, `{"01_temp": 29}` or `{"__temp_01": 29}` are invalid in message payloads\. 