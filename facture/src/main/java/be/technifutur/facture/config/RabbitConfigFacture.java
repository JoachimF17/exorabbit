package be.technifutur.facture.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;

public class RabbitConfigFacture
{
    @Bean
    public ObjectMapper mapper()
    {
        return new ObjectMapper();
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
    public Binding fBind(DirectExchange directExchange, Queue factureQueue)
    {
        return BindingBuilder.bind(factureQueue).to(directExchange).with("facture");
    }

    @Bean
    public Binding rBind(DirectExchange directExchange, Queue reservQueue)
    {
        return BindingBuilder.bind(reservQueue).to(directExchange).with("reserv");
    }
}
