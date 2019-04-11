
package io.github.bonigarcia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageComponent {

    @Autowired
    private MessageService messageService;

    public String getMessage() {
        return messageService.getMessage();
    }
}
