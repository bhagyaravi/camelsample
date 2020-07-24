package com.test.quarkus.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
public class BookingProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
    	//FlightBooking booking = exchange.getIn().getBody();
    	//exchange.getIn().setBody(flightbooking);
    }
}
