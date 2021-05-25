# Trabajo Practico Cuatrimestral Orientacion a Objetos 2 - Grupo 7

## Configuracion del entorno

- Descargar maven: https://maven.apache.org/download.cgi

- Verificar instalacion:

    PS C:\Users\> mvn -v
    
    Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
    
    Maven home: C:\Program Files\apache-maven-3.6.3\bin\..
    
    Java version: 1.8.0_261, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_261\jre
    
    Default locale: en_US, platform encoding: Cp1252
    
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

- Agregar plugin Spring Tools 4 del marketplace del eclipse

## Generar build 

    mvn clean install
    
## Correr webservices  

    java -jar .\target\app-v0.1.war



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-security)
* [Bootstrap 4](https://getbootstrap.com/docs/4.6/getting-started/introduction/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
