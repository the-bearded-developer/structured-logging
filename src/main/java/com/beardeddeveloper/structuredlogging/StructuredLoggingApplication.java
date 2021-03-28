package com.beardeddeveloper.structuredlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

import static net.logstash.logback.argument.StructuredArguments.kv;
import static net.logstash.logback.argument.StructuredArguments.v;

@SpringBootApplication
public class StructuredLoggingApplication {

	private static final Logger logger = LoggerFactory.getLogger(StructuredLoggingApplication.class);

	public static void main(String[] args) {
		// Variables in the message only
		logger.info("Order successful. User ID 1234. Order ID 9876. Total sale price: 12.67.");

		// Variables added as properties of the JSON log and added to the log message
		logger.info("Order successful {} {} {}", kv("userId", 1234), kv("orderId", 9876), kv("totalSaleValue", 12.67));

		// Variables added as properties of the JSON log and added to the log message with a custom format
		logger.info("Order successful {} {} {}", kv("userId", 1234, "{0} equals {1}"), kv("orderId", 9876, "{0} equals {1}"), kv("totalSaleValue", 12.67, "{0} equals {1}"));

		// Order object is written to JSON log
		Order order = new Order(1234, 9876, new BigDecimal("12.67"));
		logger.info("Order successful", kv("order", order));

		// Variables added to properties of the JSON log but only the values are added to the log message
		logger.info("Order successful {} {} {}", v("userId", 1234), v("orderId", 9876), v("totalSaleValue", 12.67));

		SpringApplication.run(StructuredLoggingApplication.class, args);
	}
}
