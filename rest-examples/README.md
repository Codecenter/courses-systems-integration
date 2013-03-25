RESTful Examples
================
Copyright @ Codecenter Oy. All rights reserved.

Description
-----------

This project contains some examples of RESTful web services.

Running the Sample
------------------

The project contains an Apache Maven project, which implements all the 
web services using Java. You can install Maven by downloading its latest
version from <http://maven.apache.org>.

After you have installed Maven, you can start the web application directly
with the command `mvn tomcat:run`. It will launch Tomcat directly
on the project.

After Tomcat has started you can access the web services at:

<http://localhost:8080/rest/hello>
<http://localhost:8080/rest/crm/customers>
<http://localhost:8080/rest/crm/customers/1>

The second URL supports for GET and POST. Use the first to get a list of 
customers and the second to create a new customer.

The last URL returns the customer information for the specified customer
when GET is used. PUT can be used to update the customer information and
finally DELETE can be used to delete the customer.

You can test the web services with, for example, SoapUI. 