
package io.github.bonigarcia;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MySpringApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MySpringApplication.class)) {
            MessageComponent messageComponent = context
                    .getBean(MessageComponent.class);
            System.out.println(messageComponent.getMessage());
        }
    }
}
