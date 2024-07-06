# bz-ion-service

Service **bz-ion-service** functions as an intermediate between ION and service 
what works with terminals for **Handling Units** operations,
by taking data from rabbit on **queue="bz-ion-service-queue"** 
and giving it to ION on request
and on response from ION puts data in rabbit on **queue="bz-ion-service-response"**

### rabbit data going to bz-ion-service
```json
{
  "transactionId": "1",
  "dateAndTime": "2024-02-14T08:57:23.676Z",
  "user": "v_ivanov",
  "handlingUnit": [
    {
      "id": "R202011040000000519",
      "length": "600",
      "width": "600",
      "warehouse": "R0100",
      "location": "НАЛУНЕ",
      "sequence": "1",
      "status": "3",
      "comment": ""
    },
    {
      "id": "R202011040000000880",
      "length": "600",
      "width": "600",
      "warehouse": "R0100",
      "location": "НАЛУНЕ",
      "sequence": "2",
      "status": "3",
      "comment": ""
    },
    {
      "id": "R202011040000000638",
      "length": "600",
      "width": "600",
      "warehouse": "R0100",
      "location": "НАЛУНЕ",
      "sequence": "3",
      "status": "3",
      "comment": ""
    }
  ]
}
```

### rabbit data returning from bz-ion-service
fail
```json
{
  "transactionid": "1",
  "transactiondate": "2024-02-14T08:57:23.676Z",
  "transactionstatus": "failed",
  "user": "v_ivanov",
  "measuredRemainders": [
    {
      "id": "R202011040000000638      ",
      "abortReason": {
        "errors": {
          "warehouse": {
            "code": "1005",
            "description": "Error Multiple locations present"
          }
        }
      }
    }
  ]
}
```
success
```json
{
  "transactionid": "1",
  "transactiondate": "2024-02-14T08:57:23.676Z",
  "transactionstatus": "success",
  "user": "v_ivanov"
}
```

on response write
mvid, success status and list of errors if any in to repository

## request from ion

```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:GetHandlingUnitsRequest/>
   </soapenv:Body>
</soapenv:Envelope>
```

## WSDL

```
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://spring.io/guides/gs-producing-web-service"
           xmlns:tns="http://spring.io/guides/gs-producing-web-service" elementFormDefault="qualified">

    <xs:element name="GetHandlingUnitsRequest"/>

    <xs:element name="GetHandlingUnitsResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="handlingUnitsResp" type="tns:unit4TransferResp" maxOccurs="1" minOccurs="1"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="unit4TransferResp">
        <xs:sequence>
            <xs:element name="mvid" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="datentime" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="actioncode" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="handlingUnit" type="tns:handlingUnit" minOccurs="1"/>
        </xs:sequence>
    </xs:complexType>

    <xs:complexType name="handlingUnit">
        <xs:sequence>
            <xs:element name="huid" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="cdfHght" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="cdfWdth" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="cwar" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="cdfLoca" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="cdfLose" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="status" type="xs:string" maxOccurs="1" minOccurs="1"/>
            <xs:element name="comment" type="xs:string" maxOccurs="1" minOccurs="1"/>
        </xs:sequence>
    </xs:complexType>

    <xs:element name="SetAcknowledgeRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="mvid" type="xs:string" maxOccurs="1" minOccurs="1"/>
                <xs:element name="success" type="xs:string" maxOccurs="1" minOccurs="1"/>
                <xs:element name="datentime" type="xs:string" maxOccurs="1" minOccurs="1"/>
                <xs:element name="errorlog" type="tns:resultList" minOccurs="1"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="resultList">
        <xs:sequence>
            <xs:element name="error" type="xs:string" maxOccurs="1" minOccurs="1"/>
        </xs:sequence>
    </xs:complexType>

    <xs:element name="SetAcknowledgeResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="noted" type="xs:string" maxOccurs="1" minOccurs="1"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
```