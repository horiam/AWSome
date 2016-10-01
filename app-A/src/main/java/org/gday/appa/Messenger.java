
package org.gday.appa;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;

@Component
public class Messenger {

    @Autowired
    private MessageRepository receivedMessageRepository;
    private final QueueMessagingTemplate queueMessagingTemplate;
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    public Messenger(AmazonSQS amazonSqs) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSqs);
    }

    @SqsListener("QueueA")
    private void receiveMessage(Message receivedMessage) {
        System.out.println("Received message = " + receivedMessage.toString());
        receivedMessageRepository.save(receivedMessage);
    }

    public void sendMessage(Message message) {
        String queueName = applicationService.getPhysicalName("QueueB");
        queueMessagingTemplate.convertAndSend(queueName, message);
    }

}
