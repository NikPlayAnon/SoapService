package zb.ru.bzionservice

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition
import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.xml.xsd.XsdSchema
import zb.ru.bzionservice.data.soap.container.ContainerEndpoint
import zb.ru.bzionservice.data.soap.handling.HandlingUnitsEndpoint
import zb.ru.bzionservice.data.soap.transfer.TransferEndpoint


@EnableWs
@Configuration
class WebServiceConfig : WsConfigurerAdapter() {
    @Bean
    fun messageDispatcherServlet(applicationContext: ApplicationContext?): ServletRegistrationBean<*> {
        val servlet = MessageDispatcherServlet()
        servlet.setApplicationContext(applicationContext!!)
        servlet.isTransformWsdlLocations = true
        return ServletRegistrationBean(servlet, "/ws/*")
    }

    @Bean(name = ["units"])     //  http://bzs-16-077:8080/ws/units.wsdl
    fun defaultWsdl11Definition(unitsSchema: XsdSchema?): DefaultWsdl11Definition? {
        val wsdl11Definition = DefaultWsdl11Definition()
        wsdl11Definition.setPortTypeName("unitsPort")
        wsdl11Definition.setLocationUri("/ws")
        wsdl11Definition.setTargetNamespace(HandlingUnitsEndpoint.NAMESPACE_URI)
        wsdl11Definition.setSchema(unitsSchema)
        return wsdl11Definition
    }

    @Bean(name = ["transfer"])     //  http://bzs-16-077:8080/ws/transfer.wsdl
    fun defaultWsdl11Definition2(transferSchema: XsdSchema?): DefaultWsdl11Definition? {
        val wsdl11Definition = DefaultWsdl11Definition()
        wsdl11Definition.setPortTypeName("transferPort")
        wsdl11Definition.setLocationUri("/ws")
        wsdl11Definition.setTargetNamespace(TransferEndpoint.NAMESPACE_URI)
        wsdl11Definition.setSchema(transferSchema)
        return wsdl11Definition
    }

    @Bean(name = ["container"])     //  http://10.1.1.97:8082/ws/container.wsdl
    fun defaultWsdl11Definition3(containerSchema: XsdSchema?): DefaultWsdl11Definition? {
        val wsdl11Definition = DefaultWsdl11Definition()
        wsdl11Definition.setPortTypeName("containerPort")
        wsdl11Definition.setLocationUri("/ws")
        wsdl11Definition.setTargetNamespace(ContainerEndpoint.NAMESPACE_URI)
        wsdl11Definition.setSchema(containerSchema)
        return wsdl11Definition
    }

    //
    @Bean
    open fun unitsSchema(): XsdSchema? {
        return SimpleXsdSchema(ClassPathResource("units.xsd"))
    }

    @Bean
    open fun transferSchema(): XsdSchema? {
        return SimpleXsdSchema(ClassPathResource("transfer.xsd"))
    }

    @Bean
    open fun containerSchema(): XsdSchema? {
        return SimpleXsdSchema(ClassPathResource("container.xsd"))
    }
}
