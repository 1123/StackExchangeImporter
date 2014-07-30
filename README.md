[![Build Status](https://travis-ci.org/1123/StackExchangeImporter.png)](https://travis-ci.org/1123/StackExchangeImporter)

##### Overview

This project allows to import StackExchange dumps into relational databases.
Technologies used are Java, Hibernate/JPA for writing and JAXB for parsing. Currently importing of posts, post history, 
users, badges, comments and votes is possible. Importing has been tested with postgres and H2, but should also be
possible with any relational database that works with hibernate:

https://community.jboss.org/wiki/SupportedDatabases2

This project focuses on clean code, complete test coverage, brevity,
maintainability, ease of use and efficiency.

The dumps are currently hosted by archive.org 

https://archive.org/details/stackexchange

and are released under a creative commons license:

http://creativecommons.org/licenses/by-sa/3.0/

Tiny excerpts of these dumps are included in the test/resources directory for testing purposes.

Importing into a relational database is the first step in mining data from the
stackexchange sites (most importantly from stackoverflow). I hope this project
may be useful to others. Contributing is more than welcome.

##### Building

Maven and Java >= 1.8 is needed for building this project. Once mvn is installed and this
project is checked out via git, you can run 

```
mvn install
```

within the project root directory to add the jar and sources jar to your local
mvn repository.

##### Usage

###### Calling from Java

Start your relational database you want to import to or skip this step if you are going to use H2. 
Then create a Spring configuration similar to 
TestConfig.java file to point to your database.  Be sure to get the host
name, database name, schema name, port number, user, password, hibernate
dialect and the driver class correct. 

Using the importer is most easily understood looking at the classes within the
src/main/test directory. Here is an example of how to import posts with a
spring-injected instance of ImporterImpl called importer. 

```Java
importer.importPosts("/path/to/your/posts.xml");
```

If you do not want to use Spring for configuration, then you can manually
construct an instance of ImporterImpl and explicitly set the JPA
SessionFactory:

```Java
LocalSessionFactoryBean factory = new TestConfig().sessionFactory();
factory.afterPropertiesSet();
Importer importer = new ImporterImpl();
importer.setSessionFactory(factory.getObject());
importer.importPosts(POSTS_FILE);
```

Note that hibernate / JPA will create the database schema for you. Make sure
your user has the appropriate privileges for creating tables in the specified
schema.  Also note that by default running the importer more than once will
delete previously imported data. Adjust the spring configuration to change this
behavior.

###### Importing from the shell

Edit the LocalSessionFactoryBean within ImporterContext.java to point to the
database that you want to import to -- or leave it pointing to the in-memory H2
instance, which is configured by default. 

Use the mvn assemply plugin to create a jar that includes all dependencies:

```bash
mvn clean compile assembly:single
```

Then execute the following, possibly changing the path to your Posts.xml file:

```bash
java -jar target/StackExchangeImporter-1.0-SNAPSHOT-jar-with-dependencies.jar posts src/test/resources/beer/Posts.xml
```

Valid values for the first parameter are those of the Enum Main.FILE: 
posts, comments, users, votes, badges, post_history, tags, post_links
