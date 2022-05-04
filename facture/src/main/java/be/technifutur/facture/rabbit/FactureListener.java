package be.technifutur.facture.rabbit;

import be.technifutur.facture.models.Reservation;
import be.technifutur.facture.services.FactureServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class FactureListener
{
    private final Logger logger = LoggerFactory.getLogger(FactureListener.class);

    @RabbitListener(queues = "reserv_queue")
    public void listener(String message) throws JsonProcessingException
    {
        FactureServiceImpl fsi = FactureServiceImpl.getInstance();
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        Reservation reservation = mapper.readValue(message, Reservation.class);

        UUID reservRef = reservation.getRef();
        int nbNuits = (int) ChronoUnit.DAYS.between(reservation.getArrive(), reservation.getDepart());

        logger.info("--- CREATION FACTURE ---");
        fsi.createFacture(nbNuits, reservRef);
        logger.info("--- FACTURE CREE ET ENVOYEE ---");
    }
}
