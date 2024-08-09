package zb.ru.bzionservice.rabbit


import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import kotlin.String


//@EnableWs
@Configuration
class RabbitMqConfig (private val rabbitTemplate: RabbitTemplate) {
    // Value is populated with the queue name from "application.properties" file.
    @Value("\${inventory_measured-remainders}")
    private val queueNameMRInventory: String? = null
    // Value is populated with the queue name from "application.properties" file.
    @Value("\${update_measured-remainder}")
    private val queueNameMRUpdate: String? = null
    // Value is populated with the queue name from "application.properties" file.
    @Value("\${update_response_measured-remainder}")
    private val queueNameResponce: String? = null
    // Value is populated with the exchange name from "application.properties" file.
    @Value("\${spring.rabbitmq.exchange}")
    private val measuredRemaindersExchange: String? = null
    @Value("\${inventory_measured-remainders.key}")
    private val findMRInventoryKey: String? = null
    @Value("\${update_measured-remainder.key}")
    private val findMRUpdateKey: String? = null
    @Value("\${response_measured-remainder.key}")
    private val findMRResponceKey: String? = null
    @Value("#{\${queue.key.map}}")
    val myMap: Map<String, String> = mapOf()

    @Autowired
    fun setupRabbitTemplate(template: RabbitTemplate) {
        template.messageConverter = Jackson2JsonMessageConverter()
    }

    @Bean
    fun rabbitListenerContainerFactory(connectionFactory: ConnectionFactory?): SimpleRabbitListenerContainerFactory {
        return SimpleRabbitListenerContainerFactory().apply {
            setMessageConverter(Jackson2JsonMessageConverter())
            setConnectionFactory(connectionFactory)
        }
    }

    @Bean
    fun measuredRemaindersExchange() = DirectExchange(measuredRemaindersExchange, true, false)
    @Bean
    fun queue1() = Queue(queueNameMRInventory, true)
    @Bean
    fun queue2() = Queue(queueNameMRUpdate, true)
    @Bean
    fun queue3() = Queue(queueNameResponce, true)
    @Bean
    fun queue4() = Queue(myMap["inventoryManagement.queue"], true)
    @Bean
    fun queue5() = Queue(myMap["writeOffOfGoods.queue"], true)
    @Bean
    fun binding1() = BindingBuilder
            .bind(queue1())
            .to(measuredRemaindersExchange())
            .with(findMRInventoryKey)
    @Bean
    fun binding2() = BindingBuilder
            .bind(queue2())
            .to(measuredRemaindersExchange())
            .with(findMRUpdateKey)
    @Bean
    fun binding3() = BindingBuilder
            .bind(queue3())
            .to(measuredRemaindersExchange())
            .with(findMRResponceKey)
    @Bean
    fun binding4() = BindingBuilder
            .bind(queue4())
            .to(measuredRemaindersExchange())
            .with(myMap["inventoryManagement.key"])
    @Bean
    fun binding5() = BindingBuilder
            .bind(queue5())
            .to(measuredRemaindersExchange())
            .with(myMap["writeOffOfGoods.key"])

}

