package dev.noemontes.reactive.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
	private Long id;
	private String name;
	private String lastname;
}
