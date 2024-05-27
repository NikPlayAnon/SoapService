package zb.ru.bzionservice.rabbit

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.ws.config.annotation.EnableWs
import java.lang.Boolean
import kotlin.String


//@EnableWs
@Configuration
class RabbitMqConfig {
    // Value is populated with the queue name from "application.properties" file.
    @Value("\${spring.rabbitmq.queue}")
    private val queueName: String? = null

    // Value is populated with the exchange name from "application.properties" file.
    @Value("\${spring.rabbitmq.exchange}")
    private val exchange: String? = null

    // Value is populated with the routing key from "application.properties" file.
    @Value("\${spring.rabbitmq.routingkey}")
    private val routingKey: String? = null

    // Value is populated with the exchange name from "application.properties" file.
    @Value("\${spring.rabbitmq.username}")
    private val userName: String? = null

    // Value is populated with the routing key from "application.properties" file.
    @Value("\${spring.rabbitmq.password}")
    private val password: String? = null

    // @Bean annotation tells that a method produces a bean which is to be managed by the spring container.
    @Bean
    fun queue(): Queue {
        // Creating a queue.
        return Queue(queueName, Boolean.FALSE)
    }

    @Bean
    fun topicExchange(): TopicExchange {
        // Creating a topic exchange.
        return TopicExchange(exchange)
    }

    @Bean
    fun username(): Binding? {
        return BindingBuilder.bind(queue()).to(topicExchange()).with(userName)
    }

    @Bean
    fun password(): Binding? {
        return BindingBuilder.bind(queue()).to(topicExchange()).with(password)
    }

    @Bean
    fun binding(queue: Queue?, topicExchange: TopicExchange?): Binding {
        // Binding the queue to the topic with a routing key.
        return BindingBuilder.bind(queue).to(topicExchange).with(routingKey)
    }
}

