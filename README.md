# AWS Documentation Dataset

We present the AWS documentation corpus, an open-book QA dataset, which contains 25,175 documents along with 100 matched questions and answers.
These questions are inspired by the author's interactions with real AWS customers and the questions they asked about AWS services.
The data was anonymized and aggregated.
All questions in the dataset have a valid, factual and unambiguous answer within the accompanying documents, we deliberately avoided questions that are ambiguous, incomprehensible, opinion-seeking, or not clearly a request for factual information.
All questions, answers and accompanying documents in the dataset are annotated by authors.
There are two types of answers: text and yes-no-none(YNN) answers.
Text answers range from a few words to a full paragraph sourced from a continuous block of words in a document
or from different locations within the same document.
Every question in the dataset has a matched text answer.
Yes-no-none(YNN) answers can be yes, no, or none depending on the type of question.
For example the question: “Can I stop a DB instance that has a read replica?” has a clear yes or no answer but the
question “What is the maximum number of rows in a dataset in Amazon Forecast?” is not a yes or no question and
therefore has a “None” as the YNN answer.
23 questions have ‘Yes’ YNN answers, 10 questions have ‘No’ YNN answers and 67 questions have ‘None’ YNN answers.
