package com.devs.camel.configurations

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class CamelCsv extends RouteBuilder {
  @Override
  void configure() throws Exception {
    from('file:src/main/resources/files?fileName=camel.csv&noop=true')
      .unmarshal().csv()
      .split(body())
      .process { exchange ->
        def row = exchange.in.body
        def name = row[0]
        exchange.in.body = "Name: ${name}"
      }
      .log('Processed row: ${body}')
  }
}