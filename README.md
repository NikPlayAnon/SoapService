# bz-ion-service

Service **bz-ion-service** functions as an intermediate between ION and service 
what works with terminals for **Handling Units** operations,
by taking data from rabbit
and giving it to ION on request</br>
On response from ION puts data in rabbit

### Update
<details>
<summary>updating measured remainder</summary>
using queue 

`update.measured-remainder`

to update measured remainder, put json in rabbitmq queue as shown below</br>

```json
{
  "transaction_id": 51,
  "transaction_date": "2024-07-11T12:44:39.073779",
  "user": "some_one",
  "measured_remainders": [
    {
      "id": "W202011040000000001",
      "status": 1,
      "comment": "",
      "length": 255.0,
      "width": 260.0
    },
    {
      "id": "W202011040000000004",
      "status": 1,
      "comment": "",
      "length": 253.0,
      "width": 260.0
    }
  ]
}
```

</details>

### Inventarisation
<details>
<summary>Inventarisation of measured remainder</summary>
using queue

`inventory.measured-remainders`

To perform inventarisation for measured remainder, put json in rabbitmq queue as shown below</br>

```json
{
  "transaction_id": 51,
  "transaction_date": "2024-07-11T12:44:39.073779",
  "user": "some_one",
  "measured_remainders": [
    {
      "id": "W202011040000000001",
      "warehouse": "R0100",
      "location": "0001",
      "sequence": 1,
      "status": 1,
      "comment": "",
      "length": 255.0,
      "width": 260.0
    },
    {
      "id": "W202011040000000004",
      "warehouse": "R0100",
      "location": "0001",
      "sequence": 2,
      "status": 1,
      "comment": "",
      "length": 253.0,
      "width": 260.0
    }
  ]
}
```
</details>



### Responses
<details>
<summary>Responses of measured remainder requests</summary>
using queue

`update.response.measured-remainder`

To get measured remainders actions response, get json from rabbitmq queue</br>

success

```json
{
  "transaction_id":"51",
  "transaction_date":"2024-07-11T12:44:39.073779",
  "transaction_status":"success",
  "user":"some_one"
}
```

error

```json
{
  "transaction_id": "4353545325",
  "transaction_date": "27-11-2024 08:40:51",
  "transaction_status": "failed",
  "user": "v_ivanov",
  "measured_remainders": [
    {
      "id": "43905823-05kjj",
      "abort reason": {
        "errors": {
          "length_from": {
            "code": "1005",
            "description": "the value must be greater than zero"
          },
          "warehouse": {
            "code": "1005",
            "description": "the value must be greater than zero"
          }
        },
        "general": {
          "code": "9000",
          "description": "state error"
        }
      }
    },
    {
      "id": "43905823-05k11",
      "abort reason": {
        "errors": {
          "length_from": {
            "code": "1005",
            "description": "the value must be greater than zero"
          },
          "warehouse": {
            "code": "1005",
            "description": "the value must be greater than zero"
          }
        },
        "general": {
          "code": "9000",
          "description": "state error"
        }
      }
    }
  ]
}
```
</details>
