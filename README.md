# dominion-restful

Instalar ojdbc6 en repositorio Maven
====================================
install:install-file -Dfile=K:/curso/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar

Dependencia Maven ojdbc6
========================
	<!-- ORACLE -->
	<dependency>
		<groupId>com.oracle</groupId>
		<artifactId>ojdbc6</artifactId>
		<version>11.2.0</version>
	</dependency>


Configurar JNDI
===============
	<!-- Resource en server.xml -->
	<Resource auth="Container" description="Curso database" driverClassName="oracle.jdbc.OracleDriver" maxActive="20" maxIdle="10" maxWait="-1" name="jdbc/masterOracleDS" password="MASTER" type="javax.sql.DataSource" url="jdbc:oracle:thin:@a3-server:1521:XE" username="MASTER"/>

	<!-- ResourceLink en context.xml -->
	<ResourceLink global="jdbc/masterOracleDS" name="jdbc/masterOracleDS" type="javax.sql.DataSource"/>

Tomcat manager 
==============
	<role rolename="manager-gui"/>
	<user password="s3cr3t" roles="manager-gui" username="tomcat"/>    

Configuración dialect hibernate
===============================
hibernate.dialect=org.hibernate.dialect.Oracle10gDialect

Url pruebas Postman
===================
findAll
-------
http://localhost:8080/dominion-restful/rest/pais

search
------
http://localhost:8080/dominion-restful/rest/pais/search?searchBasic=&paisNombreLk=mb&page=0&size=2&sort=paisNombre&paisNombre.dir=asc

findById
--------
http://localhost:8080/dominion-restful/rest/pais/239

create
------
http://localhost:8080/dominion-restful/rest/pais
TYPE:POST
HEADERS: Content-Type-->application/json
BODY:{
	"codigoPais": 998,
	"paisIsonum": 0,
	"paisIso2": "PR",
	"paisIso3": "PRB",
	"paisNombre": "prueba"
}

update
------
http://localhost:8080/dominion-restful/rest/pais/998
TYPE:PUT
HEADERS: Content-Type-->application/json
BODY:{
	"codigoPais": 998,
	"paisIsonum": 0,
	"paisIso2": "PR",
	"paisIso3": "PRB",
	"paisNombre": "prueba modif"
}

delete
------
http://localhost:8080/dominion-restful/rest/pais
TYPE:DELETE
HEADERS: Content-Type-->application/json
BODY:{
	"codigoPais": 998
}
