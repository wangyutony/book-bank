package com.harbada.bookbank.dto;

public class AuthorDto {
	private Integer id;
	private String name;

	public AuthorDto() {
		super();
	}

	public AuthorDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
