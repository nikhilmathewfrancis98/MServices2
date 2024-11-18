Spring Cloud Sleuth library is deprecated in the latest version of Spring Cloud 2022.0.0.

If you are using Spring Boot 2.7.x and Spring Cloud 2021.0.x then you can continue with this section.

If you are using Spring Boot 3.x and Spring Cloud 2022.0.x then check out the below simple post:

Spring Boot 3 distributed tracing with Micrometer (alternative to Sleuth) and Zipkin
Step 1:  Add the following Micrometer-related Maven dependencies to your microservices.

<dependency>
	<groupId>io.micrometer</groupId>
	<artifactId>micrometer-observation</artifactId>
</dependency>
<dependency>
	<groupId>io.micrometer</groupId>
	<artifactId>micrometer-tracing-bridge-brave</artifactId>
</dependency>
<dependency>
	<groupId>io.zipkin.reporter2</groupId>
	<artifactId>zipkin-reporter-brave</artifactId>
</dependency>
<dependency>
	<groupId>io.github.openfeign</groupId>
	<artifactId>feign-micrometer</artifactId>
</dependency>
micrometer-observation dependency will allow us to collect and report metrics from our application to Zipkin.

micrometer-tracing-bridge-brave dependency will allow us to trace our spring boot application.

zipkin-reporter-brave dependency allows us to send traces that we collect to Zipkin.

feign-micrometer dependency was added because I am using feign in my microservices to call other APIs. This dependency will configure the micrometer to work with feign.



NOTE:


Step 2: Start Zipkin as a docker container (be sure to have Docker running before you run the following command).

**docker run --rm -it --name zipkin -p 9411:9411 openzipkin/zipkin**
**docker run -d -p 9411:9411 openzipkin/zipkin**
After this config the Zipkin server in the MSs 
Step 4: Start your applications and try to send a request to employee or department service. Now, open 
in the browser Zipkin at [http://127.0.0.1:9411/](the Zipkin Provider) and press the button Run Query.

Important Note:

Enable Auto-refresh:
To enable automatic refreshing of configurations without project refresh, you can use Spring Cloud Bus along with Spring Cloud Config. By default, Spring Cloud Config Server does not support refreshing individual properties files, but with Spring Cloud Bus, you can achieve this.

Add the spring-cloud-starter-bus-amqp dependency to your microservice project.
Configure a message broker (e.g., RabbitMQ) in your Spring Cloud Config Server.
Configure Spring Cloud Bus and RabbitMQ in your microservice project.
Trigger a refresh by sending a POST request to the /actuator/bus-refresh endpoint.
With these steps, you should be able to access configurations from your properties file and have them automatically refreshed 
without requiring a project refresh.

**Circuit Breakers**

Here are the links for your reference:

https://spring.io/projects/spring-cloud-circuitbreaker

https://resilience4j.readme.io/

https://resilience4j.readme.io/docs/circuitbreaker

https://resilience4j.readme.io/docs/retry