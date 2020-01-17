package com.nagarro.nagp.mom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MOMApplicationTests {

    @Autowired
    Producer producer;
    
	@Test
	void sendMessage() {
	    producer.sendMessage("This is testing -1");
	}

}
