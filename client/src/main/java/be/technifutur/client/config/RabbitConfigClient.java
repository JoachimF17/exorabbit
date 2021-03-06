package be.technifutur.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RabbitConfigClient
{
    @Bean
    public RestTemplate template()
    {
        return new RestTemplate();
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory)
    {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("facture_queue")
    public Queue factureQueue()
    {
        return new Queue("facture_queue");
    }

    @Bean("reserv_queue")
    public Queue reservQueue()
    {
        return new Queue("reserv_queue");
    }

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange("demo.direct");
    }

    @Bean
    public Binding rBind(DirectExchange directExchange, Queue reserv_queue)
    {
        return BindingBuilder.bind(reserv_queue).to(directExchange).with("reserv");
    }
}
