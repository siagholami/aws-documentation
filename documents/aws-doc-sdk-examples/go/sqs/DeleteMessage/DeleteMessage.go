/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This file is licensed under the Apache License, Version 2.0 (the "License").
   You may not use this file except in compliance with the License. A copy of
   the License is located at

    http://aws.amazon.com/apache2.0/

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied. See the License for the
   specific language governing permissions and limitations under the License.
*/
// snippet-start:[sqs.go.delete_message]
package main

// snippet-start:[sqs.go.delete_message.imports]
import (
    "flag"
    "fmt"

    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/sqs"
)
// snippet-end:[sqs.go.delete_message.imports]

// GetQueueURL gets the URL of an Amazon SQS queue
// Inputs:
//     sess is the current session, which provides configuration for the SDK's service clients
//     queueName is the name of the queue
// Output:
//     If success, the URL of the queue and nil
//     Otherwise, an empty string and an error from the call to
func GetQueueURL(sess *session.Session, queue *string) (*sqs.GetQueueUrlOutput, error) {
    // Create an SQS service client
    svc := sqs.New(sess)

    result, err := svc.GetQueueUrl(&sqs.GetQueueUrlInput{
        QueueName: queue,
    })
    if err != nil {
        return nil, err
    }

    return result, nil
}

// DeleteMessage deletes a message from an Amazon SQS queue
// Inputs:
//     sess is the current session, which provides configuration for the SDK's service clients
//     queueURL is the URL of the queue
//     messageID is the ID of the message
// Output:
//     If success, nil
//     Otherwise, an error from the call to DeleteMessage
func DeleteMessage(sess *session.Session, queueURL *string, messageHandle *string) error {
    // snippet-start:[sqs.go.delete_message.call]
    svc := sqs.New(sess)

    _, err := svc.DeleteMessage(&sqs.DeleteMessageInput{
        QueueUrl:      queueURL,
        ReceiptHandle: messageHandle,
    })
    // snippet-end:[sqs.go.delete_message.call]
    if err != nil {
        return err
    }

    return nil
}

func main() {
    // snippet-start:[sqs.go.delete_message.args]
    queue := flag.String("q", "", "The name of the queue")
    messageHandle := flag.String("m", "", "The receipt handle of the message")
    flag.Parse()

    if *queue == "" || *messageHandle == "" {
        fmt.Println("You must supply a queue name (-q QUEUE) and message receipt handle (-m MESSAGE-HANDLE)")
        return
    }
    // snippet-end:[sqs.go.delete_message.args]

    // Create a session that gets credential values from ~/.aws/credentials
    // and the default region from ~/.aws/config
    // snippet-start:[sqs.go.delete_message.sess]
    sess := session.Must(session.NewSessionWithOptions(session.Options{
        SharedConfigState: session.SharedConfigEnable,
    }))
    // snippet-end:[sqs.go.delete_message.sess]

    // Get URL of queue
    result, err := GetQueueURL(sess, queue)
    if err != nil {
        fmt.Println("Got an error getting the queue URL:")
        fmt.Println(err)
        return
    }

    queueURL := result.QueueUrl

    err = DeleteMessage(sess, queueURL, messageHandle)
    if err != nil {
        fmt.Println("Got an error deleting the message:")
        fmt.Println(err)
        return
    }

    fmt.Println("Deleted message from queue with URL " + *queueURL)
}
// snippet-end:[sqs.go.delete_message]
