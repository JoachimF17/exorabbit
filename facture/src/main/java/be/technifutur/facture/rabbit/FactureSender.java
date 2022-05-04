package be.technifutur.facture.rabbit;

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

    public static void sendFactureToClient(UUID reservRef)
    {
        rabbitTemplate.convertAndSend(reservRef);
    }
}
