# Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
#
# This file is licensed under the Apache License, Version 2.0 (the "License").
# You may not use this file except in compliance with the License. A copy of the
# License is located at
#
# http://aws.amazon.com/apache2.0/
#
# This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
# OF ANY KIND, either express or implied. See the License for the specific
# language governing permissions and limitations under the License.

# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourcedescription:[rekognition-image-python-list-faces-in-collection.py demonstrates how to list the faces in an Amazon Rekognition collection.]
# snippet-keyword:[Python]
# snippet-sourcesyntax:[python]
# snippet-sourcesyntax:[python]
# snippet-keyword:[AWS SDK for Python (Boto3)]
# snippet-keyword:[Code Sample]
# snippet-keyword:[Amazon Rekognition]
# snippet-keyword:[ListFaces]
# snippet-keyword:[Collection]
# snippet-service:[rekognition]
# snippet-sourcetype:[full-example]
# snippet-sourcedate:[2019-01-3]
# snippet-sourceauthor:[reesch (AWS)]
# snippet-start:[rekognition.python.rekognition-image-python-list-faces-in-collection.complete]
import boto3

if __name__ == "__main__":
    # Change collectionID to the required collection.

    collectionId='MyCollection'
    maxResults=2
    tokens=True

    client=boto3.client('rekognition')
    response=client.list_faces(CollectionId=collectionId,
                               MaxResults=maxResults)

    print('Faces in collection ' + collectionId)

 
    while tokens:

        faces=response['Faces']

        for face in faces:
            print (face)
        if 'NextToken' in response:
            nextToken=response['NextToken']
            response=client.list_faces(CollectionId=collectionId,
                                       NextToken=nextToken,MaxResults=maxResults)
        else:
            tokens=False
# snippet-end:[rekognition.python.rekognition-image-python-list-faces-in-collection.complete]