package be.technifutur.client.rabbit;

import be.technifutur.client.services.ReservationServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientListener
{
    @RabbitListener(queues = "facture_queue")
    public void listener(String message)
    {
        ReservationServiceImpl rsi = ReservationServiceImpl.getInstance();

        rsi.setToFacture(UUID.fromString(message));
    }
}
