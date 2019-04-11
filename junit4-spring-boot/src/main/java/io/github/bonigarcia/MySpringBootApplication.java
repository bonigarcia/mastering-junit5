
package io.github.bonigarcia;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication {

    final Logger log = LoggerFactory.getLogger(MySpringBootApplication.class);

    @Autowired
    public MessageComponent messageComponent;

    @PostConstruct
    private void setup() {
        log.info("*** {} ***", messageComponent.getMessage());
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(MySpringBootApplication.class).run(args);
    }
}
