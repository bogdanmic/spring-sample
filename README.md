Spring Playground - The Plan
-
The Plan is to have them all in the same project just to see how they work together. If we create a project to demonstrate each of them then we won't know if they work and how they work together.

Even though we started with one project to contain all, there is a need to try multiple approaches or tools. The said tools resolve the same problem in different ways and there is no need to have them both in the same project.
So for this purpose we created multiple projects, and they are:
 - JWT - a spring boot sample with JWT example 
 - PlayGround - this is the initial project that will try to follow the plan bellow.
 - Netflix Stack - a spring boot sample that uses some of the netflix tools: eureka, histrix, etc.
 
### JWT

DONE:
 - Angular and Spring Boot Jwt authentication.
 
### Netflix Stack
 
DONE:
 - Eureka Server - a sample project that acts as an Eureka server where other services can register
 - Eureka Client - a sample project that registers to an eureka server and offers an endpoint to search for available services by name
 - Circuit Breaker - a sample project using hystrix as a circuit breaker. We fetch the services available from the circuit-breaker app using the eureka-client endpoint. If that fails we fallback to another method using histryx. We also have a dashboard to watch the hystrix.stream
 - Feign Rest Call - a sample project that uses Feign clients to make a rest call to a service registered with our Eureka server. If no service is found or the call fails, we use a fallback.
 - REST service calls - In **Circuit Breaker** we use a REST Template to make a rest call and in **Feign Rest Call** we use a Feign Client for that.
 - Turbine Monitor - It's a project that aggregates all **hystryx.stream**s for a given cluster service name (our HYSTRIX-CIRCUIT-BREAKER service) under one roof.
 - Spring Boot Admin - Although this is not build by netflix, I added it as a sample project too see it's capabilities. It can use actuator endpoints to provide an overview of all your services registered into Eureka server and other stuff.

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
 - cloud tracing with zpikin and sleuth - https://github.com/Qkyrie/spring-boot-netflix-example/branches
 - spring integration example ??? (https://spring.io/guides/gs/integration/)
 - kafka microservices message bus (stream kafka)
 - deploy it as a docker image
 - config profiles
 - spring cloud config
 