package be.technifutur.facture.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FactureListener
{
    @RabbitListener(queues = "reserv_queue")
    public void listener()
    {

    }
}
