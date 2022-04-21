package com.springboot.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class AuditEvent<T> extends ApplicationEvent {

	public AuditEvent(T source) {
		super(source);
	}

}
