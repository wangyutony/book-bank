package com.harbada.bookbank.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author", schema="react")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;

	public Author() {
		super();
	}
	public Author(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
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

	public Set<Book> getBooks() { return this.books; }

	public void addBook(Book book) {
		books.add(book);
		book.getAuthors().add(this);
	}

	public void removeBook(Book book) {
		books.remove(book);
		book.getAuthors().remove(this);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (!(o instanceof Author)) return false;
		return id != null && id.equals(((Author) o).getId());
	}

	@Override
	public int hashCode() {
		if (id == null) return -1;
		return id.hashCode();
	}
}
