
package io.github.bonigarcia;

import org.springframework.stereotype.Component;

@Component
public class MessageComponent {

    private MessageService messageService;

    public MessageComponent(MessageService messageService) {
        this.messageService = messageService;
    }

    public String getMessage() {
        return messageService.getMessage();
    }

}
