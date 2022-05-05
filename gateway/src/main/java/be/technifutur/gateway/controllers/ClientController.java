package be.technifutur.gateway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/reserv")
public class ClientController
{
    private final RestTemplate template;

    public ClientController(RestTemplate template)
    {
        this.template = template;
    }

    @PostMapping
    public ResponseEntity<?> registerReservation(@RequestBody Map<String, String> body)
    {
        return template.postForEntity("http://localhost:8081/reserv", body, Object.class);
    }

    @GetMapping
    public Object getReservationsFacturees()
    {
        return template.getForObject("http://localhost:8081/reserv", Object.class);
    }
}
