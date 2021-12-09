# documents/batch XML API<a name="documents-batch-xml"></a>

## XML documents/batch Requests<a name="documents-batch-xml-request"></a>

The body of a `documents/batch` request specifies the document operations you want to perform in XML\. For example:

```
<batch>
	<add  id="tt0484562">
		<field name="title">The Seeker: The Dark Is Rising</field>
		<field name="director">Cunningham, David L.</field>
		<field name="genre">Adventure</field>
		<field name="genre">Drama</field>
		<field name="genre">Fantasy</field>
		<field name="genre">Thriller</field>
		<field name="actor">McShane, Ian</field>
		<field name="actor">Eccleston, Christopher</field>
		<field name="actor">Conroy, Frances</field>
		<field name="actor">Ludwig, Alexander</field>
		<field name="actor">Crewson, Wendy</field>
		<field name="actor">Warner, Amelia</field>
		<field name="actor">Cosmo, James</field>
		<field name="actor">Hickey, John Benjamin</field>
		<field name="actor">Piddock, Jim</field>
		<field name="actor">Lockhart, Emma</field>
	</add>
	<delete id="tt0301199" />
</batch>
```

### documents/batch Request Elements \(XML\)<a name="documents-batch-xml-request-elements"></a>


****  

| Element | Description | Required | 
| --- | --- | --- | 
| batch | The collection of add or delete operations that you want to submit to your search domain\. A batch must contain at least one add or delete element\.  | Yes | 
| add | Specifies a document that you want to add to your search domain\. The id attributes is required and an add element must contain at least one field\. Attributes: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/documents-batch-xml.html)  | No | 
| field | Specifies a field in the document being added\. The name attribute and a field value are required\. Field names must begin with a letter and can contain the following characters: a\-z \(lower case\), 0\-9, and \_ \(underscore\)\. The name score is reserved and cannot be used as a field name\. The field value can be text or CDATA\.  To specify multiple values for a field, you include multiple field elements with the same name\. For example: <pre><field name="genre">Adventure</field><br /><field name="genre">Drama</field><br /><field name="genre">Fantasy</field><br /><field name="genre">Thriller</field></pre> Constraints: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/documents-batch-xml.html)  Condition: At least one field must be specified in an add element\.  | Conditional | 
| delete | Specifies a document that you want to remove from your search domain\. The id attribute is required\. A delete element must be empty\. For information on permanently deleting documents, see [Deleting Documents in Amazon CloudSearch](preparing-data.md#deleting-documents)\.Constraints: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/documents-batch-xml.html)  | No | 

## documents/batch Response \(XML\)<a name="documents-batch-xml-response"></a>

The response body lists the number of adds and deletes that were performed and any errors or warnings that were generated\. 

The RelaxNG schema of a document service API response is:

```
 start = response

response = element response {
    attribute status { "success" | "error" },
    attribute adds { xsd:integer },
    attribute deletes { xsd:integer },
    element errors {
        element error {
            text
        }+
    }? &
    element warnings {
        element warning {
            text
        }+
    }?
}
```

### documents/batch Response Elements \(XML\)<a name="documents-batch-xml-response-elements"></a>


****  

| Element | Description | 
| --- | --- | 
| result | Contains elements that list the errors and warnings generated when parsing and validating the request\.  Attributes: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/documents-batch-xml.html) Constraints: If the status is `error`, the results element contains a list of errors\. If the status is `success`, the results element can contain a list of warnings, but no errors\.  | 
| errors | Contains a collection of error elements that identify the errors that occurred when parsing and validating the request\.  | 
| error | Provides information about a parsing or validation error\. The value provides a description of the error\.  | 
| warnings | Contains a collection of warning elements that identify the warnings that were generated when parsing and validating the request\.  | 
| warning | Provides information about a parsing or validation warning\. The value provides a description of the error\.  | 