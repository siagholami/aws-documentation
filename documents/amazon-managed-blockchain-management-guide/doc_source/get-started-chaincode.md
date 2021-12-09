# Step 7: Install and Run Chaincode<a name="get-started-chaincode"></a>

This section shows you how to install sample chaincode on your peer, instantiating the chaincode, querying the chaincode, and invoking the chaincode to update values\.

## Step 7\.1: Install Chaincode<a name="get-started-create-channel-install-chaincode"></a>

Run the following command to install example chaincode on the peer node:

```
docker exec cli peer chaincode install \
-n mycc -v v0 -p github.com/chaincode_example02/go
```

## Step 7\.2: Instantiate Chaincode<a name="get-started-create-instantiate-chaincode"></a>

Run the following command to instantiate the chaincode:

```
docker exec cli peer chaincode instantiate \
-o $ORDERER -C mychannel -n mycc -v v0 \
-c '{"Args":["init","a","100","b","200"]}' \
--cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

You may have to wait a minute or two for the instantiation to propagate to the peer node\. Use the following command to verify instantiation:

```
docker exec cli peer chaincode list --instantiated \
-o $ORDERER -C mychannel \
--cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

The command returns the following when the chaincode is instantiated:

```
Get instantiated chaincodes on channel mychannel:
Name: mycc, Version: v0, Path: github.com/chaincode_example02/go, Escc: escc, Vscc: vscc
```

## Step 7\.3: Query the Chaincode<a name="get-started-create-channel-query-chaincode"></a>

You may need to wait a brief moment for the instantiation from the previous step to complete before you run the following command to query a value:

```
docker exec cli peer chaincode query -C mychannel \
-n mycc -c '{"Args":["query","a"]}'
```

The command should return the value of `a`, which you instantiated to a value of `100`\.

## Step 7\.4: Invoke the Chaincode<a name="get-started-create-channel-invoke-chaincode"></a>

In the previous steps, we instantiated the key `a` with a value of `100` and queried to verify\. Using the `invoke` command in the following example, we remove `10` from that initial value:

```
docker exec cli peer chaincode invoke -C mychannel \
-n mycc -c  '{"Args":["invoke","a","b","10"]}' \
-o $ORDERER --cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

When we query again using the following command:

```
docker exec cli peer chaincode query -C mychannel \
-n mycc -c '{"Args":["query","a"]}'
```

The command should return the value of `a` as the new value `90`\.