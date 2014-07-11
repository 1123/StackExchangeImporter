##### Overview

This project allows to import stackexchange dumps into a postgres database.
Technologies used are Java, Hibernate and JAXB. Currently importing of posts,
users, badges, comments and votes is possible, but this can be easily extended to all data.

This project focuses on clean code, complete test coverage, brevity,
maintainability, ease of use and efficiency.

Importing into a relational database is the first step in mining data from the
stackexchange sites (most importantly from stackoverflow). I hope this project
may be useful to others.

##### Building

Maven is needed for building this project. Once mvn is installed and this project is checked out via git, you can run 

```
mvn install
```

within the project root directory to add the jar and sources jar to your local mvn repository.

##### Usage

Using the importer is most easily understood looking at the classes within the
src/main/test directory. Here is an example of how to import posts:

```Java
Importer.importPosts("/path/to/your/posts.xml")
```
