package be.technifutur.facture.rabbit;

import be.technifutur.facture.models.Facture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class FactureSender
{
    private static RabbitTemplate rabbitTemplate;

    public FactureSender(RabbitTemplate rabbitTemplate)
    {
        FactureSender.rabbitTemplate = rabbitTemplate;
    }

    public static void sendFactureToClient(Facture facture) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        rabbitTemplate.convertAndSend("demo.direct","facture", mapper.writeValueAsString(facture));
    }
}
