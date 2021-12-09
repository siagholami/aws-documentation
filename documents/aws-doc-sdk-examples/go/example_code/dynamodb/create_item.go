// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Creates an item in an Amazon DynamoDB table.]
// snippet-keyword:[Amazon DynamoDB]
// snippet-keyword:[PutItem function]
// snippet-keyword:[Go]
// snippet-sourcesyntax:[go]
// snippet-service:[dynamodb]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-03-16]
/*
   Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This file is licensed under the Apache License, Version 2.0 (the "License").
   You may not use this file except in compliance with the License. A copy of
   the License is located at

    http://aws.amazon.com/apache2.0/

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied. See the License for the
   specific language governing permissions and limitations under the License.
*/

package main

import (
    "github.com/aws/aws-sdk-go/aws"
    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/dynamodb"
    "github.com/aws/aws-sdk-go/service/dynamodb/dynamodbattribute"

    "fmt"
    "os"
)

// Create structs to hold info about new item
type ItemInfo struct {
    Plot string`json:"plot"`
    Rating float64`json:"rating"`
}

type Item struct {
    Year int`json:"year"`
    Title string`json:"title"`
    Info ItemInfo`json:"info"`
}

func main() {
    // Initialize a session in us-west-2 that the SDK will use to load
    // credentials from the shared credentials file ~/.aws/credentials.
    sess, err := session.NewSession(&aws.Config{
        Region: aws.String("us-west-2")},
    )

    // Create DynamoDB client
    svc := dynamodb.New(sess)

    info := ItemInfo{
        Plot: "Nothing happens at all.",
        Rating: 0.0,
    }

    item := Item{
        Year: 2015,
        Title: "The Big New Movie",
        Info: info,
    }

    av, err := dynamodbattribute.MarshalMap(item)

    if err != nil {
        fmt.Println("Got error marshalling map:")
        fmt.Println(err.Error())
        os.Exit(1)
    }

    // Create item in table Movies
    input := &dynamodb.PutItemInput{
        Item: av,
        TableName: aws.String("Movies"),
    }

    _, err = svc.PutItem(input)

    if err != nil {
        fmt.Println("Got error calling PutItem:")
        fmt.Println(err.Error())
        os.Exit(1)
    }

    fmt.Println("Successfully added 'The Big New Movie' (2015) to Movies table")
}
