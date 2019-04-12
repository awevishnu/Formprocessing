# Formprocessing
Following steps are used to create Fat Jar:
1) Make following changes in pom.xml file:
	a) Change packaging from war to jar in pom.xml file.
	   <packaging>jar</packaging>

	b) Add below plug-in in pom.xml file. Also set final jar file name.
	   <build>
		 <plugins>
		    <plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>	
		    </plugin>
		 </plugins>
		 <finalName>FormProcessing</finalName>
	   </build>

    c) Change boot version to 1.4.2.RELEASE
       <parent>
	   		<groupId>org.springframework.boot</groupId>
	   		<artifactId>spring-boot-starter-parent</artifactId>
	   		<version>1.4.2.RELEASE</version>
       </parent>
        
2) Remove web.xml from webapp/WEB-INF folder if exists.

3) Create META-INF/resources folders under src/main/resources
   Copy WEB-INF (along with views) folder from webapp to src/main/resources/META-INF/resources
   Remove webapp folder (optional)
   These steps are needed because of JSP Limitations with Embedded Tomcat Server.
   For more details, refer below two links:
   a) https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-jsp-limitations
   b) http://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-serve-dynamic/

4) Perform clean build and package project
    a) Maven clean
    b) Maven Build ...
         Goals: package
  
6) Refresh project. Copy target/FormProcessing.jar to any folder in file path. (For example: D:\SPRING MICROSERVICES\Fat Jar\) 
 
7) Create table and sequence in Oracle DB
   CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
   CREATE SEQUENCE CUSTOMER_SEQ;
In mYSQL

CREATE TABLE `customer` (
  `cid` INT NOT NULL AUTO_INCREMENT,
  `cname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL);

 
8) Navigate to above path in console and execute below command:
   C:\SPRING MICROSERVICES\Fat Jar>java -jar FormProcessing.jar
    
9) Finally test by using below URL:
   http://localhost:9090/customers/registration/form
   Note: By default boot deploys our project into ROOT context but into our context. Hence project name (/FormProcessing) should not present in url.

    
The actuator provides us insight about spring project such as:
   1) Total list of beans have been configured for our spring project which includes:
		a) Explicitly configured beans by developer.
		b) Auto discovered beans by spring.
		c) Auto Configured beans by spring boot.
		d) Bean dependencies information.

   2) Provides auto configuration report which contains both Positive and Negative matches.

   3) Provides project environment such as path, classpath, etc

   4) Provides health status such as up or down.

   5) Provides project metrics such as CPU usage, Memory usage, etc
   ...
Actuator:

The following steps are needed to get boot actuator feature:
1) The following starter dependency should be added in pom.xml file:
   <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	
2) Turn ON spring security to restrict actuators end points access
   management.security.enabled=true
   Note: Change boot version from 1.4.2.RELEASE to 1.5.x.RELEASE
   
   There was an unexpected error (type=Unauthorized, status=401).
   Full authentication is required to access this resource.
   
3) Following steps are needed to access actuator end points by authorized person:
   a) Add starter-security dependency in pom.xml file.
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
	  </dependency>
   b) Add @EnableWebSecurity in boot strap file (such as Application.java) 	 
      The above annotation automatically provides default login pop-up (but not login page).
    
   c) Add below properties in application.properties/yml file:
      security.user.name=test
      security.user.password=test123
          
    
