#!/bin/bash
set -e
set -u

echo "Running importer tests"
mvn -Dtest=org.stackexchange.dumps.importer.* test
echo "Running Dao tests"
mvn -Dtest=org.stackexchange.querying.dao.comment.* test
echo "Running integration tests"
mvn -Dtest=org.stackexchange.querying.QueryIntegrationTestSuite test
