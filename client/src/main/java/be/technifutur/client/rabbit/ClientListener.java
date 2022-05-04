package be.technifutur.client.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ClientListener
{
    @RabbitListener(queues = "facture_queue")
    public void listener()
    {

    }
}
