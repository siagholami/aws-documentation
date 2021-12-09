.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

###################
Troubleshooting SNS
###################

Using Delivery Status in the Amazon SNS Console
===============================================

The Amazon SNS console contains a Delivery Status feature that allows you to collect feedback on
successful and unsuccessful delivery attempts of your messages to mobile push notification platforms
(Apple (APNS), Google (GCM), Amazon (ADM), Windows (WNS and MPNS) and Baidu.

It also provides other important information such as dwell times in Amazon SNS. This information is
captured in an Amazon CloudWatch Log group that is created automatically by Amazon SNS when this
feature is enabled via the Amazon SNS console or via the Amazon SNS APIs.

For instructions on using the Delivery Status feature, see `Using the Delivery Status feature of
Amazon SNS
<https://mobile.awsblog.com/post/TxHTXGC8711JNF/Using-the-Delivery-Status-feature-of-Amazon-SNS>`_
on the AWS Mobile Blog.

