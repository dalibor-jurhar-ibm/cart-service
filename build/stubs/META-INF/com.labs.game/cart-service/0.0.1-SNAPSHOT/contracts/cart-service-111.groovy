//cart-service-111.groovy
    package contracts

    org.springframework.cloud.contract.spec.Contract.make {
        request {
            method 'GET'
            urlPath('/cart-items') {
                queryParameters {
                    parameter 'customer' : "111"
                }
            }
        }
        response {
            status OK()
            body("""
                [
                    {
                        "id": 0,
                        "customer": "111",
                        "product": "AAA",
                        "quantity": 1
                    },
                    {
                        "id": 1,
                        "customer": "111",
                        "product": "BBB",
                        "quantity": 1
                    }
                ]
            """)
            headers {
                contentType('application/json')
            }
        }
    }