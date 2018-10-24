//cart-service-222.groovy
    package contracts

    org.springframework.cloud.contract.spec.Contract.make {
        request {
            method 'GET'
            urlPath('/cart-items') {
                queryParameters {
                    parameter 'customer' : "222"
                }
            }
        }
        response {
            status OK()
            body("""
                [
                    {
                        "id": 2,
                        "customer": "222",
                        "product": "CCC",
                        "quantity": 1
                    },
                    {
                        "id": 3,
                        "customer": "222",
                        "product": "DDD",
                        "quantity": 1
                    },
                    {
                        "id": 4,
                        "customer": "222",
                        "product": "EEE",
                        "quantity": 1
                    }
                ]
            """)
            headers {
                contentType('application/json')
            }
        }
    }