package com.newsletter.model;

import java.util.List;
import java.util.Map;

import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

	@ApiModelProperty(notes = "From address")
	private String from;

	@ApiModelProperty(notes = "To address")
	private String to;

	@ApiModelProperty(notes = "Subject")
	private String subject;

	@ApiModelProperty(notes = "Attachements")
	private List<Object> attachments;

	@ApiModelProperty(notes = "key, value pairs")
	private Map<String, Object> model;
}