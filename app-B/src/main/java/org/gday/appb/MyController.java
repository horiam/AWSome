package org.gday.appb;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private MessageRepository receivedMessageRepository;
    @Autowired
    private Messenger messenger;


    @RequestMapping("/physical")
    public String getResource(@RequestParam(value = "id") String id) {
        return "Resource = " + applicationService.getPhysicalName(id);
    }

    @RequestMapping("/received")
    public List<Message> getReceivedMessages() {
        List<Message> receivedMessages = new ArrayList<>();
        for (Message receivedMessage : receivedMessageRepository.findAll()) {
            receivedMessages.add(receivedMessage);
        }
        return receivedMessages;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Message sendMessages(@RequestBody String content) {
        System.out.println("I m going to send = " + content);
        String id = UUID.randomUUID().toString();
        Message message = new Message(id, content);
        messenger.sendMessage(message);
        return message;
    }
}
