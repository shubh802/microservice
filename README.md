# Microservices

A microservice is a service built around a specific business capability which can be independently deployed. So, to build large enterprise applications, we can identify the sub-domains of our main business domain and build each sub-domain as a microservice using Domain Driven Design (DDD) techniques. But in the end, we need to make all these microservices work together to serve the end user as if it is a single application.

Advantages of Microservices
----------------------------
Comprehending a smaller codebase is easy.
You can independently scale up highly used services.
Each team can focus on one (or a few) microservice(s).
Technology updates/rewrites become simpler.

* Spring Boot is the most popular and widely-used Java framework for building MicroServices. These days, many organizations prefer to deploy their applications in a Cloud environment instead of the headache of maintaining a datacenter themselves. But, we need to take good care of the various aspects to make our applications Cloud Native. There comes the beauty of Spring Cloud.

* Spring Cloud is essentially an implementation of various design patterns to be followed while building Cloud Native applications. Instead of reinventing the wheel, we can simply take advantage of various Spring Cloud modules and focus on our main business problem rather than worrying about infrastructural concerns.

Following are just a few Spring Cloud modules that can be used to address distributed application concerns:

Spring Cloud Config Server: 
Used to externalize the configuration of applications in a central config server with the ability to update the configuration values without requiring to restart the applications. We can use Spring Cloud Config Server with git, Consul, or ZooKeeper as a config repository.

Service Registry and Discovery: 
As there could be many services and we need the ability to scale up or down dynamically, we need a Service Registry and Discovery mechanism so that service-to-service communication does not depend on hard-coded hostnames and port numbers. Spring Cloud provides Netflix Eureka-based Service Registry and Discovery support with just minimal configuration. We can also use Consul or ZooKeeper for Service Registry and Discovery.

Circuit Breaker: 
In microservices-based architecture, one service might depend on another service, and if one service goes down, then failures may cascade to other services as well. Spring Cloud provides a Netflix Hystrix-based Circuit Breaker to handle these kinds of issues.

Spring Cloud Data Streams: 
We may need to work with huge volumes of data streams using Kafka or Spark. Spring Cloud Data Streams provides higher-level abstractions to use those frameworks more easily.

Spring Cloud Security: 
Some microservices need to be accessible to authenticated users only, and most likely, we'll want a Single Sign-On feature to propagate the authentication context across services. Spring Cloud Security provides authentication services using OAuth2.

Distributed Tracing: 
One of the pain points with microservices is the ability to debug issues. One simple end-user action might trigger a chain of microservice calls; there should be a mechanism to trace the related call chains. We can use Spring Cloud Sleuth with Zipkin to trace cross-service invocations.

Spring Cloud Contract: 
There is a high chance that separate teams will work on different microservices. There should be a mechanism for teams to agree upon API endpoint contracts so that each team can develop their APIs independently. Spring Cloud Contract helps to create such contracts and validate them by both the service provider and consumer.

* By deafult the SpringBootApplication contains the configuration annotation which allows us to register the beans within this class

* DispatcherServlet that stands for the application controller and directs all the request to the appropriate servlet

// We are trying to overwrite the default Dispatcher Servlet provided by the SpringBoot 
// All our servlet request will be moved to /servlet eg http://localhost:8080/servlet/
@Bean
public DispatcherServlet dispatcherServlet() {
	return new DispatcherServlet();
}

@Bean
public ServletRegistrationBean registration() {
	ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(),"/servlet/*");
	registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
	return registration;
}

MicroServices
--------------

In monolith the traditional scaling is adding ram or CPU.
Scale horzontially in this we add another instance

In microservice we  have many services and service belong to the domain and communicate outside of the same service
Earlier they used http to communicate and the container for the services is embedded in itself like jetty or embedded tomcat
So we are not building large application we are beaking them into the small services

These service communicate with each other using http
Scaling is just creating the copy of the microservice in our server and the cloud
We are creating the new instance of our services or scaling
Small and independent services organized around business 

Each service is exposed through the API wch allowes processing of the business logic through that service
Service is responsible for managing its own data wch means each microservice shld have its own data storage
They are stateless service
Concurrent processing is possible

Monolith
---------

N tier architecture

Presentation
Business Process
Data Layer -> Facade, Processing, I/O

Large deployment in the ear file which has all the component packaged in one large file

SOA(Service Oriented Architecture)
-----------------------------------
Tight coupling
Aggregation layer - transforamtion of xml and logic operation are statred adding to the SOA bus it added coupling in internal n external element

MicroServices
--------------
* Breaking software problems into smaller pieces tht are easier to understand n solve
* Every call within the service boundary are solved via rest
* Each unit can call any no od service in the system


Cloud native  depends upon the 12 factor cloud methodology
It involves pattern to run on the cloud based system
