package com.test.quarkus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class OrchestratorApplication {

	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrchestratorApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		List<Student> list = new ArrayList<>();

		list.add(new Student(1234,"Bhagya", "Maths"));
		list.add(new Student(5678,"Geetha", "Physics"));

		studentRepository.saveAll(list);
	}
	
	@Component
	class StudentRoute extends RouteBuilder {

		@Override
		public void configure() {
			restConfiguration()
			.component("servlet")
			.port("8080")
			.host("localhost")
			.contextPath("/")
			.apiProperty("cors", "true")
			.bindingMode(RestBindingMode.json);

			
			rest().get("/helloworld").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("Hello World")).endRest();
			rest("/student")
			.get("/findAll")
			.produces(MediaType.APPLICATION_JSON_VALUE)
			.route().routeId("student-api")
			.bean(StudentService.class, "getAllStudents")
			.endRest()
			.get("/records/{name}").to("direct:records");
			
			/*rest("/flight")
			.get()
			.produces(MediaType.APPLICATION_JSON_VALUE)
			.route().routeId("flight-api")
			.setHeader("Content-Type", constant("application/json"))
	        .setHeader("Accept", constant("application/json"))
	        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
			.to("uri=https://flightms-bhjayara-in.osc-sbx-exp-na-1589963421-f72ef11f3ab089a8c677044eb28292cd-0000.us-east.containers.appdomain.cloud/flight/searchFlight?fromcity=Banaglore&tocity=Delhi&date=2019-01-08 18:30:00")
			.endRest();*/
			from("direct:records")
			.process(new Processor() {

				final AtomicLong counter = new AtomicLong();

				@Override
				public void process(Exchange exchange) throws Exception {

					final String name = exchange.getIn().getHeader("name",String.class);
					exchange.getIn().setBody(new Student(counter.incrementAndGet(),name,"Camel + SpringBoot"));
				}
			});
		}
	}
}
