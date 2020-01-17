package com.javainuse;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
 
@Component
public class FileRoute extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
    	from("file:C:\\inputFolder?noop=true").to("file:E:\\opt");
    }
}
