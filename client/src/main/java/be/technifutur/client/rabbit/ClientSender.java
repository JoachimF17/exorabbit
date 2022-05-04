package be.technifutur.client.rabbit;

import be.technifutur.client.models.Reservation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientSender
{
    private static RabbitTemplate rabbitTemplate;

    public ClientSender(RabbitTemplate rabbitTemplate)
    {
        ClientSender.rabbitTemplate = rabbitTemplate;
    }

    public static void sendReservToFacture(Reservation reservation)
    {
        rabbitTemplate.convertAndSend("demo.direct", "reserv", reservation);
    }
}
