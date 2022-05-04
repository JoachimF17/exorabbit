package be.technifutur.client.rabbit;

import be.technifutur.client.services.ReservationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientListener
{
    private final Logger logger = LoggerFactory.getLogger(ClientListener.class);
    @RabbitListener(queues = "facture_queue")
    public void listener(String message) throws JsonProcessingException
    {
        ReservationServiceImpl rsi = ReservationServiceImpl.getInstance();
        ObjectMapper mapper = new ObjectMapper();
        UUID ref = mapper.readValue(message, UUID.class);

        logger.info("--- FACTURE RECUE ---");
        rsi.setToFacture(ref);
        logger.info("--- RESERVATION FACTUREE ---");
    }
}
