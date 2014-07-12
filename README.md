##### Overview

This project allows to import stackexchange dumps into relational databases.
Technologies used are Java, Hibernate and JAXB. Currently importing of posts,
users, badges, comments and votes is possible, but this can be easily extended
to all data. Importing has been tested with postgres, but should also be
possible with any relational database that works with hibernate:

https://community.jboss.org/wiki/SupportedDatabases2

This project focuses on clean code, complete test coverage, brevity,
maintainability, ease of use and efficiency.

Importing into a relational database is the first step in mining data from the
stackexchange sites (most importantly from stackoverflow). I hope this project
may be useful to others. Contributing is more than welcome.

##### Building

Maven is needed for building this project. Once mvn is installed and this
project is checked out via git, you can run 

```
mvn install
```

within the project root directory to add the jar and sources jar to your local
mvn repository.

##### Usage

Start your relational database you want to import to. Then adjust the
hibernate.cfg.xml file to point to your database.  Be sure to get the host
name, database name, schema name, port number, user, password, hibernate
dialect and the driver class correct.

###### Calling from Java

Using the importer is most easily understood looking at the classes within the
src/main/test directory. Here is an example of how to import posts:

```Java
Importer importer = new ImporterImpl();
importer.importPosts("/path/to/your/posts.xml");
```

Note that hibernate / JPA will create the database schema for you. Make sure
your user has the appropriate priviliges for creating tables in the specified
schema.  Also note that by default running the importer more than once will
delete previously imported data. Adjust the hibernate.cfg.xml file to override
this behavior.

###### Importing from the shell

There is no main method yet which could be called to do this. If it is needed,
just add a feature request.
