package zb.ru.bzionservice.model

data class HandlingUnit(
        val id: String,
        val length: String,
        val width: String,
        val warehouse: String,
        val location: String,
        val sequence: String,
        val status: String,
        val comment: String
) {
}

/*"id": "R202011040000000009",  =id
    "remainder": "F5400603-1",  =
    "project": "057090",        =
    "material": "РСА36",        =
    "warehouse": "",            =
    "location": "",             =
    "sequence": 0,              =
    "status": 1,                =
    "comment": "dsf",           =
    "length": 2600,             =
    "width": 500,               =
    "depth": 0                  =

 */