# Advanced Usage<a name="variables-advanced-usage"></a>

You can customize the ADS request in many ways with player and session data\. The only requirement is to include the ADS hostname\.

The following examples show some of the ways that you can customize your request:
+ Concatenate player parameters and session parameters to create new parameters\. Example: 

  ```
  https://my.ads.com?key1=[player_params.value1][session.id]
  ```
+ Use a player parameter as part of a path element\. Example:

  ```
  https://my.ads.com/[player_params.path]?key=value
  ```
+ Use player parameters to pass both path elements and the keys themselves, rather than just values\. Example: 

  ```
  https://my.ads.com/[player_params.path]?[player_params.key1]=[player_params.value1]
  ```