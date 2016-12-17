URL TOMCAT服务器中文乱码问题
 server.xml 添加 URIEncoding="UTF-8"
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>