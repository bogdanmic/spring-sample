Spring Playground - The Plan
-
The Plan is to have them all in the same project just to see how they work together. If we create a project to demonstrate each of them then we won't know if they work and how they work together.

Even though we started with one project to contain all, there is a need to try multiple approaches or tools. The said tools resolve the same problem in different ways and there is no need to have them both in the same project.
So for this porpose we created multiple projects, and they are:
 - JWT - a spring boot sample with JWT example 
 - PlayGround - this is the initial project that will try to follow the plan bellow.
 
### JWT

DONE:
 - Angular and Spring Boot Jwt authentication.

### Playground Plan

DONE:
 - AOP example
 - CRUD example
 - REST example
 - Hibernate example
 - DI example
 - Multiple Data Sources (**WIP**: on the multi_db_v1 branch)
 - Spring Cache example (with EHCache3)
 - MVC with Thymeleaf example (Thymeleaf reverse routing included)
 - Custom Application event example
 - Send Email example (as text or as Thymeleaf template)
 - Schedule and Batch Job examples
 - Security example with db auth and encrypted password
 - Load configuration values from a custom properties file.
 - REST controller generated docs with swagger.io available at http://localhost:8080/swagger-ui.html
 - Akka actors example
 - Consul Discovery sample: the app registers itself into consul
 - Consul Config sample: the app loads configuration from consul KV if available, ortherwise from the configuration files.
 - Async method sample with REST template

TODO:
 - multiple DBs in a proper way not as it is now on the multi_db_v1 branch (maybe use multiple spring maven modules?)
 - mongoDB example
 - elasticsearch example
 - cloud tracing with zpikin and sleuth
 - spring integration example. communicate between REST services. etc
 - kafka microservices message bus (stream kafka)
 - deploy it as a docker image
 - config profiles
 