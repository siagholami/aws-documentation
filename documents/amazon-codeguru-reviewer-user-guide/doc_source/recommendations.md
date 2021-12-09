# Recommendations in Amazon CodeGuru Reviewer<a name="recommendations"></a>

Amazon CodeGuru Reviewer recommends various kinds of fixes in your Java code\. These recommendations are based on common code scenarios and might not apply to all cases\. 

If you don't agree with a recommendation, you can [provide feedback](provide-feedback.md) in the CodeGuru Reviewer console or by commenting on the code in the pull requests\. Any positive or negative feedback can be used to help improve the performance of CodeGuru Reviewer so that recommendations get better over time\.

The following kinds of recommendations are provided: 
+ AWS best practices
+ Concurrency
+ Resource leak prevention
+ Sensitive information leak prevention
+ Common coding best practices
+ Refactoring
+ Input validation

## AWS best practices<a name="best-practices"></a>

AWS APIs contain a rich set of features to ensure performance and stability of software\. For example, usage patterns such as batching and waiters lead to enhanced performance and more efficient, maintainable code\. Use of pagination is often required to ensure correctness of code\. Developers might fail to use the right constructs when using AWS APIs, and this leads to problems in production\. AWS best practices provide recommendations on correct use of AWS APIs, which leads to availability and performance gains\. 

## Concurrency<a name="concurrency"></a>

CodeGuru Reviewer identifies problems with implementations of concurrency in multithreaded code\. Concurrency defects are often subtle and escape even expert programmers\. Incorrect implementations of concurrency can lead to incorrect code or performance issues\. CodeGuru Reviewer identifies atomicity violations that might result in correctness problems, and it identifies excessive synchronizations that might result in performance problems\.

## Resource leak prevention<a name="resource-leak-prevention"></a>

CodeGuru Reviewer looks for lines of code where resource leaks might be occurring\. Resource leaks can cause latency issues and outages\. CodeGuru Reviewer can point to code where this might be occurring and suggest handling the resources in a different way\.

## Sensitive information leak prevention<a name="info-leak-prevention"></a>

Sensitive information in code should not be shared with unauthorized parties\. CodeGuru Reviewer looks for lines of code where sensitive information might be leaking, and suggests different ways to handle the data\.

## Common coding best practices<a name="common-bug-fixes"></a>

CodeGuru Reviewer checks parameters and looks for lines of code that could create bugs\. There are many common coding errors that cause bugs to happen, such as forgetting to check whether an object is null before setting it, reassigning a synchronized object, or forgetting to initialize a variable along an exception path\. CodeGuru Reviewer can point to the location of those errors and other sources of problems in code\.

## Refactoring<a name="refactoring"></a>

CodeGuru Reviewer looks for lines of code that appear to be duplicated or similar enough to be refactored\. Refactoring can help improve code maintainability\. 

## Input validation<a name="input-validation"></a>

It's important to detect unexpected input that arrives at a computation, and to apply appropriate validation before the computation starts\. Input validation is an important layer of defense against unintentional errors, such as client component changes, and malicious attacks, such as code injection or denial of service\. CodeGuru Reviewer looks for lines of code that process input data and suggests additional validation where it's needed\.