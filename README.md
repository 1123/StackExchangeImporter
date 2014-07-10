##### Overview

This project allows to import stackexchange dumps into a postgres database. Technologies used are Java, Hibernate and JAXB. Currently only import of posts and users is possible, but this can be easily extended to comments, badges, votes, etc, since all files have similar relational structure. 

Importing into a relational database is the first step in mining data from the stackexchange sites (most importantly from stackoverflow). I hope this project may be useful to others.

##### Building

Maven is needed for building this project. Once mvn is installed and this project is checked out via git, you can run 

```
mvn install
```

within the project root directory to add the jar and sources jar to your local mvn repository.

##### Usage

Using the importer is most easily understood looking at the classes within the src/main/test directory. The PostImporter class also contains a main method you can use.

```Java
PostImporter.importPosts(100l, POSTS_FILE);
```
