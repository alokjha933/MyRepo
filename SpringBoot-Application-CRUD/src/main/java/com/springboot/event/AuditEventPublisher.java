package com.springboot.event;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class AuditEventPublisher {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;

	public void publishEvent(String message) {

		// Map<String, String> data = CommonUtils.requestData();
		Map<String, String> requestData = new HashMap<>();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		requestData.put("host", request.getHeader("host"));
		requestData.put("User-Agent", request.getHeader("User-Agent"));
		requestData.put("message", message);
		applicationEventPublisher.publishEvent(new AuditEvent<LogData>(LogData.builder().dataMap(requestData).build()));
	}

}
