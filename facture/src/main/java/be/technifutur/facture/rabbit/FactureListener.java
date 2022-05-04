package be.technifutur.facture.rabbit;

import be.technifutur.facture.services.FactureServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class FactureListener
{
    @RabbitListener(queues = "reserv_queue")
    public void listener(String message) throws JsonProcessingException
    {
        FactureServiceImpl fsi = FactureServiceImpl.getInstance();
        ObjectMapper mapper = new ObjectMapper();
        Reservation reservation = mapper.readValue(message, Reservation.class);

        UUID reservRef = reservation.getRef();
        int nbNuits = (int) ChronoUnit.DAYS.between(reservation.getArrive(), reservation.getDepart());

        fsi.createFacture(nbNuits, reservRef);
    }

    @Data
    private class Reservation
    {
        private UUID ref;
        private LocalDate arrive;
        private LocalDate depart;
    }
}
