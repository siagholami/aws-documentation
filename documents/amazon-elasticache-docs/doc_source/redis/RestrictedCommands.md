# Restricted Redis Commands<a name="RestrictedCommands"></a>

To deliver a managed service experience, ElastiCache restricts access to certain cache engine\-specific commands that require advanced privileges\. For cache clusters running Redis, the following commands are unavailable:
+ `bgrewriteaof`
+ `bgsave`
+ `cluster addslot`
+ `cluster delslot`
+ `cluster setslot`
+ `config`
+ `debug`
+ `migrate`
+ `replicaof`
+ `save`
+ `slaveof`
+ `shutdown`
+ `sync`