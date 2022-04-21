package com.springboot.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuditEventHandler {

	@EventListener
	@Async
	public void handleEvent(AuditEvent<LogData> auditEvent) {
		try {
			String data = new ObjectMapper().writerWithDefaultPrettyPrinter()
					.writeValueAsString(auditEvent.getSource());
			System.out.println("sending data to security audit service : " + data);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
