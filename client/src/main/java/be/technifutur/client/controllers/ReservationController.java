package be.technifutur.client.controllers;

import be.technifutur.client.models.Reservation;
import be.technifutur.client.models.forms.ReservationForm;
import be.technifutur.client.services.ReservationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserv")
public class ReservationController
{
    private final ReservationServiceImpl rsi = ReservationServiceImpl.getInstance();

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
}
