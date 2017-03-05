#Microservices using Java Spring Boot
by Dean 4-5 March 2017 @ Geeky Base
[![Build Status](https://travis-ci.org/vichar/springdean.svg?branch=master)](https://travis-ci.org/vichar/springdean)

### Build Status at https://travis-ci.org/vichar/springdean

## How to integrate with Eureka
Put eureka config to file bootstrap.yml
```
eureka:
  client:
    serviceUrl:
      defaultZone: http://${eureka_server}:8761/eureka/
```      
