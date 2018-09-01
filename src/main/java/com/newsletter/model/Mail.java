package com.newsletter.model;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Mail {
    private String from;
    private String to;
    private String subject;
    private List<Object> attachments;
    private Map<String, Object> model;
}