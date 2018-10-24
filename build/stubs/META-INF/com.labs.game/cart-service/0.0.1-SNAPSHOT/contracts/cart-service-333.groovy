//cart-service-777.groovy
    package contracts

    org.springframework.cloud.contract.spec.Contract.make {
        request {
            method 'GET'
            urlPath('/cart-items') {
                queryParameters {
                    parameter 'customer' : "777"
                }
            }
        }
        response {
            status OK()
            body("""
                [
                ]
            """)
            headers {
                contentType('application/json')
            }
        }
    }