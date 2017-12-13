package Survey.Api.controller.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import Survey.Api.model.entity.json.EncuestaTM;
import Survey.Api.model.entity.json.EncuestasTerminadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final EncuestaTM encuesta) {

        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(encuesta);
                System.out.println("Send Message");
                return objectMessage;
            }
        });
    }


}
