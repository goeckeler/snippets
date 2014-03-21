Integration Tests with JUnit and Spring 
=======================================

Sample that demonstrates how to separate integration tests
from unit tests even with JUnit.

Simple use Springs @IfProfileValue to mark classes or methods
with @IfProfileValue(name = "junit.stage", value = "test").

In this sample "integration" is used instead of "test" but as
standard unit tests are executed anyway the first integration
system is mostly the test server used by the team.

