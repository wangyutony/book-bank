package com.harbada.bookbank.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="book", schema="react")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	@Column(name = "price", columnDefinition = "NUMERIC")
	private double price;
	
	
	public Book() {
		super();
	}
	public Book(Integer id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@ManyToMany(cascade = {
			CascadeType.ALL
	})
	@JoinTable(name = "author_book", schema="react",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id")
	)
	private Set<Author> authors = new HashSet<>();
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
	public Set<Author> getAuthors() { return this.authors; }


	public void addAuthor(Author author) {
		authors.add(author);
		author.getBooks().add(this);
	}

	public void removeAuthor(Author author) {
		authors.remove(author);
		author.getBooks().remove(this);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (!(o instanceof Book)) return false;
		return id != null && id.equals(((Book) o).getId());
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
