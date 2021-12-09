// snippet-comment:[The snippet tags are for the AWS SDK for Go Developer Guide. Do not remove.]
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
// snippet-start:[s3.go.set_tls_12]
package main

import (
    "crypto/tls"
    "flag"
    "fmt"
    "net/http"

    "github.com/aws/aws-sdk-go/aws"
    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/s3"
    "golang.org/x/net/http2"
)

// GetTLSVersion gets the version of TLS you have configured
// snippet-start:[s3.go.get_tls_version]
func GetTLSVersion(tr *http.Transport) string {
    switch tr.TLSClientConfig.MinVersion {
    case tls.VersionTLS10:
        return "TLS 1.0"
    case tls.VersionTLS11:
        return "TLS 1.1"
    case tls.VersionTLS12:
        return "TLS 1.2"
    case tls.VersionTLS13:
        return "TLS 1.3"
    }

    return "Unknown"
}

// snippet-end:[s3.go.get_tls_version]

// ConfirmBucketItemExists returns nil if the bucket and item can be accessed
func ConfirmBucketItemExists(sess *session.Session, bucket *string, item *string) error {
    // snippet-start:[s3.go.set_tls_12_client]
    svc := s3.New(sess)
    _, err := svc.HeadObject(&s3.HeadObjectInput{
        Bucket: bucket,
        Key:    item,
    })
    // snippet-end:[s3.go.set_tls_12_client]
    if err != nil {
        return err
    }

    return nil
}

func main() {
    bucket := flag.String("b", "", "The bucket to check")
    object := flag.String("o", "", "The bucket object to check")
    region := flag.String("r", "us-west-2", "The region where the bucket lives")
    goV112 := flag.Bool("v", false, "Whether the Go version is prior to 1.13")

    flag.Parse()

    if *bucket == "" || *object == "" {
        fmt.Println("You must supply a bucket name (-b BUCKET) and item name (-o OBJECT)")
        return
    }

    // snippet-start:[s3.go.set_tls_12_transport]
    tr := &http.Transport{
        TLSClientConfig: &tls.Config{
            MinVersion: tls.VersionTLS12,
        },
    }
    // snippet-end:[s3.go.set_tls_12_transport]

    if *goV112 {
        // snippet-start:[s3.go.set_tls_12_cfg_112]
        err := http2.ConfigureTransport(tr)
        if err != nil {
            fmt.Println("Got an error configuring HTTP transport")
            fmt.Println(err)
            return
        }
        // snippet-end:[s3.go.set_tls_12_cfg_112]
    } else {
        // snippet-start:[s3.go.set_tls_12_cfg_113]
        tr.ForceAttemptHTTP2 = true
        // snippet-end:[s3.go.set_tls_12_cfg_113]
    }

    // snippet-start:[s3.go.set_tls_12_session]
    client := http.Client{Transport: tr}

    sess := session.Must(session.NewSession(&aws.Config{
        Region:     region,
        HTTPClient: &client,
    }))
    // snippet-end:[s3.go.set_tls_12_session]

    // Confirm TLS version
    // snippet-start:[s3.go.get_tls_version_call]
    s3Client := s3.New(sess)
    if tr, ok := s3Client.Config.HTTPClient.Transport.(*http.Transport); ok {
        fmt.Println("Client uses " + GetTLSVersion(tr))
    }
    // snippet-end:[s3.go.get_tls_version_call]

    err := ConfirmBucketItemExists(sess, bucket, object)
    if err != nil {
        fmt.Println("Could not confirm whether bucket and item exists")
        return
    }

    fmt.Println("Bucket " + *bucket + " and item " + *object + " can be accessed")
}

// snippet-end:[s3.go.set_tls_12]
