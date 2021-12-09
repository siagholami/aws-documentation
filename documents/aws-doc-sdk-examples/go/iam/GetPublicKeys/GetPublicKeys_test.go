// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. // SPDX-License-Identifier: MIT-0

package main

import (
    "errors"
    "testing"
    "time"

    "github.com/aws/aws-sdk-go/service/iam"
    "github.com/aws/aws-sdk-go/service/iam/iamiface"
)

// Define a mock struct to use in unit tests
type mockIAMClient struct {
    iamiface.IAMAPI
}

func (m *mockIAMClient) ListSSHPublicKeys(input *iam.ListSSHPublicKeysInput) (*iam.ListSSHPublicKeysOutput, error) {
    // Check that required inputs exist
    if input.UserName == nil || *input.UserName == "" {
        return nil, errors.New("ListSSHPublicKeysInput.UserName is nil or an empty string")
    }

    resp := iam.ListSSHPublicKeysOutput{}
    return &resp, nil
}

func TestGetPublicKeys(t *testing.T) {
    thisTime := time.Now()
    nowString := thisTime.Format("2006-01-02 15:04:05 Monday")
    t.Log("Starting unit test at " + nowString)

    // mock resource
    userName := "test-user"

    mockSvc := &mockIAMClient{}

    _, err := GetPublicKeyBodies(mockSvc, &userName)
    if err != nil {
        t.Fatal(err)
    }

    t.Log("Got SSH keys for user " + userName)
}
