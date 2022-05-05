package be.technifutur.client.controllers;

import be.technifutur.client.models.Reservation;
import be.technifutur.client.models.dtos.ReservationDTO;
import be.technifutur.client.models.forms.ReservationForm;
import be.technifutur.client.services.ReservationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/reserv")
public class ReservationController
{
    private final RestTemplate template;
    private final ReservationServiceImpl rsi = ReservationServiceImpl.getInstance();

    public ReservationController(RestTemplate template)
    {
        this.template = template;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerReservation(@RequestBody ReservationForm form) throws JsonProcessingException
    {
        rsi.create(form.toReservation());
    }

    @GetMapping
    public List<Reservation> getReservationsFacturees()
    {
        return rsi.getReservFactures();
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservation(@PathVariable int id)
    {
        Reservation reservation = rsi.getReservFactures().get(id);
        return ReservationDTO.of(
                reservation,
                template.getForObject("http://localhost:8082/facture/"+reservation.getRef(), Double.class)
        );
    }
}
