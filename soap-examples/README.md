SOAP Examples
=============
Copyright @ Codecenter Oy. All rights reserved.

Description
-----------

This project contains some SOAP examples. The samples are specified as WSDL 
documents which are located under src/main/resources. 

Running the Sample
------------------

The project contains an Apache Maven project, which implements all the 
web services using Java. You can install Maven by downloading its latest
version from <http://maven.apache.org>.

After you have installed Maven, you can start the web application directly
with the command `mvn tomcat:run`. It will launch Tomcat directly
on the project.

After Tomcat has started you can access the web services at:

<http://localhost:8080/soap/ws/HelloService>
<http://localhost:8080/soap/ws/DemoService>
<http://localhost:8080/soap/ws/HelloPolicy>

You can test the web services with, for example, SoapUI. Append ?wsdl to 
the URL to obtain the WSDLs directly from the web server.