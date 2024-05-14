# bz-ion-service

## return from ion

```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:SetAcknowledgeRequest>
         <gs:mvid>?</gs:mvid>
         <gs:success>Accepted</gs:success>
         <gs:errorlog>
         		<gs:error>err orr</gs:error>
         		<gs:error>errorr</gs:error>
         </gs:errorlog>
      </gs:SetAcknowledgeRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

on response write
mvid, success status and list of errors if any in to repository

## request from ion

```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:GetHandlingUnitsRequest>
         <gs:fromIon>?</gs:fromIon>
      </gs:GetHandlingUnitsRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## WSDL

```
<wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                  xmlns:sch="http://spring.io/guides/gs-producing-web-service"
                  xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
                  xmlns:tns="http://spring.io/guides/gs-producing-web-service"
                  targetNamespace="http://spring.io/guides/gs-producing-web-service">
    <wsdl:types>
        <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified"
                   targetNamespace="http://spring.io/guides/gs-producing-web-service">
            <xs:element name="GetHandlingUnitsRequest">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="fromIon" type="xs:string"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="GetHandlingUnitsResponse">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element maxOccurs="1" minOccurs="1" name="handlingUnitsResp" type="tns:unit4TransferResp"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:complexType name="unit4TransferResp">
                <xs:sequence>
                    <xs:element maxOccurs="1" minOccurs="1" name="mvid" type="xs:string"/>
                    <xs:element maxOccurs="1" minOccurs="1" name="datentime" type="xs:string"/>
                    <xs:element maxOccurs="1" minOccurs="1" name="actioncode" type="xs:string"/>
                    <xs:element minOccurs="1" name="handlingUnit" type="tns:handlingUnit"/>
                </xs:sequence>
            </xs:complexType>
            <xs:complexType name="handlingUnit">
                <xs:sequence>
                    <xs:element maxOccurs="1" minOccurs="1" name="huid" type="xs:string"/>
                    <xs:element maxOccurs="1" minOccurs="1" name="cdfHght" type="xs:string"/>
                    <xs:element maxOccurs="1" minOccurs="1" name="cdfWdth" type="xs:string"/>
                    <xs:element maxOccurs="1" minOccurs="1" name="cwar" type="xs:string"/>
                    <xs:element maxOccurs="1" minOccurs="1" name="cdfLoca" type="xs:string"/>
                    <xs:element maxOccurs="1" minOccurs="1" name="cdfLose" type="xs:string"/>
                </xs:sequence>
            </xs:complexType>
            <xs:element name="SetAcknowledgeRequest">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element maxOccurs="1" minOccurs="1" name="mvid" type="xs:string"/>
                        <xs:element maxOccurs="1" minOccurs="1" name="success" type="xs:string"/>
                        <xs:element minOccurs="1" name="errorlog" type="tns:resultList"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:complexType name="resultList">
                <xs:sequence>
                    <xs:element maxOccurs="1" minOccurs="1" name="error" type="xs:string"/>
                </xs:sequence>
            </xs:complexType>
            <xs:element name="SetAcknowledgeResponse">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element maxOccurs="1" minOccurs="1" name="noted" type="xs:string"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
        </xs:schema>
    </wsdl:types>
    <wsdl:message name="SetAcknowledgeResponse">
        <wsdl:part element="tns:SetAcknowledgeResponse" name="SetAcknowledgeResponse"></wsdl:part>
    </wsdl:message>
    <wsdl:message name="GetHandlingUnitsResponse">
        <wsdl:part element="tns:GetHandlingUnitsResponse" name="GetHandlingUnitsResponse"></wsdl:part>
    </wsdl:message>
    <wsdl:message name="GetHandlingUnitsRequest">
        <wsdl:part element="tns:GetHandlingUnitsRequest" name="GetHandlingUnitsRequest"></wsdl:part>
    </wsdl:message>
    <wsdl:message name="SetAcknowledgeRequest">
        <wsdl:part element="tns:SetAcknowledgeRequest" name="SetAcknowledgeRequest"></wsdl:part>
    </wsdl:message>
    <wsdl:portType name="unitsPort">
        <wsdl:operation name="SetAcknowledge">
            <wsdl:input message="tns:SetAcknowledgeRequest" name="SetAcknowledgeRequest"></wsdl:input>
            <wsdl:output message="tns:SetAcknowledgeResponse" name="SetAcknowledgeResponse"></wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="GetHandlingUnits">
            <wsdl:input message="tns:GetHandlingUnitsRequest" name="GetHandlingUnitsRequest"></wsdl:input>
            <wsdl:output message="tns:GetHandlingUnitsResponse" name="GetHandlingUnitsResponse"></wsdl:output>
        </wsdl:operation>
    </wsdl:portType>
    <wsdl:binding name="unitsPortSoap11" type="tns:unitsPort">
        <soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
        <wsdl:operation name="SetAcknowledge">
            <soap:operation soapAction=""/>
            <wsdl:input name="SetAcknowledgeRequest">
                <soap:body use="literal"/>
            </wsdl:input>
            <wsdl:output name="SetAcknowledgeResponse">
                <soap:body use="literal"/>
            </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="GetHandlingUnits">
            <soap:operation soapAction=""/>
            <wsdl:input name="GetHandlingUnitsRequest">
                <soap:body use="literal"/>
            </wsdl:input>
            <wsdl:output name="GetHandlingUnitsResponse">
                <soap:body use="literal"/>
            </wsdl:output>
        </wsdl:operation>
    </wsdl:binding>
    <wsdl:service name="unitsPortService">
        <wsdl:port binding="tns:unitsPortSoap11" name="unitsPortSoap11">
            <soap:address location="http://bzs-16-077:8081/ws"/>
        </wsdl:port>
    </wsdl:service>
</wsdl:definitions>
```