This project demonstrates validating request parameters in Spring Boot using the @Valid, @NotBlank, and @Pattern annotations. Some tests that can be executed using POSTMAN or SOAPUI:

ENDPOINT:
http://localhost:8080/home

1) VALID:

request body:

{
    "validateDataRequest": {
        "id": "1000",
        "firstName": "Donald",
        "lastName": "Cole"
    }
}

response:

{
    "validated": true
}


2) INVALID missing firstName:

request body:
{
    "validateDataRequest": {
        "id": "1000",
        "firstName": " ",
        "lastName": "Cole"
    }
}

response:

{
    "errorTimestamp": "20-05-2023 11:23:41",
    "errorCode": 400,
    "errorDescription": "METHOD_ARGUMENT_NOT_VALID_EXCEPTION",
    "errorMessage": "parameter 'firstName' is mandatory",
    "errorSource": "VALIDATION_DEMO_SERVICE"
}


3) INVALID: id has NON-NUMERIC CHAR(S)

request body:
{
    "validateDataRequest": {
        "id": "x",
        "firstName": "Donald",
        "lastName": "Cole"
    }
}

response:

{
    "errorTimestamp": "20-05-2023 11:37:27",
    "errorCode": 400,
    "errorDescription": "METHOD_ARGUMENT_NOT_VALID_EXCEPTION",
    "errorMessage": "parameter 'id' uses only numeric characters.",
    "errorSource": "VALIDATION_DEMO_SERVICE"
}