package com.devs.camel.configurations

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class CamelTimer extends RouteBuilder {

	@Override
	void configure() throws Exception {
		from('timer:test?period=120000')
			.log('¡Probando el Camello!')
	}

}