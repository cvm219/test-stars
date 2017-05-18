# test-stars

System for keep track of stars

## Getting started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

MySQL
jdk 8
Maven build tool

## Running test-stars locally

Download archive
```
git clone git@github.com:cvm219/test-stars.git
```

Before start, create database named "stars" in your MySQL and import database structure from "stars.sql"

Edit the following rows in \src\main\resources\mybatis-config.xml with your MySQL parameters
```
<property name="url" value="jdbc:mysql://localhost/stars?useUnicode=true&amp;characterEncoding=UTF8&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"/>
<property name="username" value="root"/>
<property name="password" value=""/>
```
To build the project run

```
mvn clean install
```

Then run project

```
mvn spring-boot:run
```

Result you can see on http://localhost:8080/

To enter the system use "username" as login and "password" as password (without quotes)
