package Survey.Api.controller.queue;


import Survey.Api.controller.processor.GuardarDatosEncuesta;
import Survey.Api.model.entity.json.EncuestaTM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

@Component
public class MessageConsumer {

    private static Logger log = LoggerFactory.getLogger(MessageConsumer.class);
    private static final String ORDER_TOPIC = "data-survey";

    @Autowired
    private GuardarDatosEncuesta guardarDatosEncuesta;

    @JmsListener(destination = ORDER_TOPIC)
    public void receiveTopicMessage(@Payload EncuestaTM encuestaTM,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {
        System.out.println("received <" + encuestaTM.getTipo() + ">");
        guardarDatosEncuesta.guardarDatosEncuesta(encuestaTM);
    }
}
