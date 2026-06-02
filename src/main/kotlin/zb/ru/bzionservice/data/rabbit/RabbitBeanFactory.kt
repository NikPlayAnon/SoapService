package zb.ru.bzionservice.data.rabbit

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class RabbitBeanFactory {
    @Value("#{\${queue.key.map.return}}")
    val myMap: Map<String, String> = mapOf()

    fun createExchange(exchangeName: String): DirectExchange {
        return DirectExchange(exchangeName, true, false)
    }

    fun createQueue(queueName: String): Queue {
        return Queue(queueName, true)
    }

    fun createBinding(queue: Queue, key: String, exchange: DirectExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with(key)
    }

    fun generateBeans(): List<Pair<Queue, Binding>> {
        return myMap.keys.filter { it.endsWith(".queue") }.map { key ->
            val queueName = myMap[key]
            val bindingKey = myMap[key.replace(".queue", ".key")]
            val exchangeName = myMap[key.replace(".queue", ".exchange")]

            val queue = createQueue(queueName!!)
            val exchange = createExchange(exchangeName!!)
            val binding = createBinding(queue, bindingKey!!, exchange)

            queue to binding
        }
    }
}