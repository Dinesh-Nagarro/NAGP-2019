package com.javainuse;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer://myTimer?period=2000").setBody().simple("Hello world camel fired at ${header.firedTime}}")
				.to("stream:out");
	}
}
