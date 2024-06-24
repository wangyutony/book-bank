package com.harbada.bookbank.dto;

import java.util.HashSet;
import java.util.Set;

public class BookDto {
	private Integer id;
	private String name;
	private String description;
	private double price;
	private Set<AuthorDto> auhors = new HashSet<>();;
	
	public BookDto() {
		super();
	}
	
	public BookDto(Integer id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<AuthorDto> getAuhors() { return auhors; }
	public void setAuhors(Set<AuthorDto> authors) { this.auhors = authors; }
}
