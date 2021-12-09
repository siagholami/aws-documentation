# Math activity<a name="pipeline-activities-math"></a>

A `math` activity computes an arithmetic expression using the message's attributes\. The expression must return a number\. For example, given the following input message:

```
{
    "tempF": 50,
}
```

after processing by the following `math` activity:

```
{
    "math": {
        "name": "MyMathActivity",
        "math": "(tempF - 32) / 2",
        "attribute": "tempC",
        "next": "MyDatastoreActivity"
    }
}
```

the resulting message looks like:

```
{
    "tempF" : 50,
    "tempC": 9
}
```