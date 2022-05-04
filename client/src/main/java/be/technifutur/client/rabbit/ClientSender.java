package be.technifutur.client.rabbit;

import be.technifutur.client.models.Reservation;
import be.technifutur.client.services.ReservationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class ClientSender implements InitializingBean
{
    private static Logger logger = LoggerFactory.getLogger(ClientSender.class);
    private static RabbitTemplate rabbitTemplate;

    public ClientSender(RabbitTemplate rabbitTemplate)
    {
        ClientSender.rabbitTemplate = rabbitTemplate;
    }

    public static void sendReservToFacture(Reservation reservation) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        logger.info("RESERVATION UUID : "+reservation.getRef());
        rabbitTemplate.convertAndSend("demo.direct", "reserv", mapper.writeValueAsString(reservation));
    }

    @Override
    public void afterPropertiesSet() throws JsonProcessingException
    {
        Reservation r = new Reservation(
                UUID.randomUUID(),
                LocalDate.of(2020, 12, 10),
                LocalDate.of(2020, 12, 20)
        );
        ReservationServiceImpl rsi = ReservationServiceImpl.getInstance();

        rsi.create(r);
    }
}
