package be.technifutur.facture.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FactureSender
{
    private static RabbitTemplate rabbitTemplate;

    public FactureSender(RabbitTemplate rabbitTemplate)
    {
        FactureSender.rabbitTemplate = rabbitTemplate;
    }

    public static void sendFactureToClient(UUID reservRef) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        rabbitTemplate.convertAndSend("demo.direct","facture", mapper.writeValueAsString(reservRef));
    }
}
