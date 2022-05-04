package be.technifutur.facture.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigFacture
{
    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper().registerModule(new JavaTimeModule());
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

    @Bean("reserv_Queue")
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
    public Binding fBind(DirectExchange directExchange, Queue facture_queue)
    {
        return BindingBuilder.bind(facture_queue).to(directExchange).with("facture");
    }
}
