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
import zb.ru.bzionservice.soap.handling.HandlingUnitsEndpoint


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

    //
    @Bean
    open fun countriesSchema(): XsdSchema? {
        return SimpleXsdSchema(ClassPathResource("units.xsd"))
    }
}
