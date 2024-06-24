package com.harbada.bookbank.mapper;

import com.harbada.bookbank.dto.AuthorDto;
import com.harbada.bookbank.dto.BookDto;
import com.harbada.bookbank.entity.Author;
import com.harbada.bookbank.entity.Book;

import java.util.Set;

public class BookMapper {
	public static BookDto toBookDto(Book book) {
		BookDto dto =  new BookDto(book.getId(), book.getName(), book.getDescription(), book.getPrice());
		Set<Author> authors = book.getAuthors();
		if(authors!=null && authors.size()>0) {
			for(Author a : authors) {
				AuthorDto ad = new AuthorDto(a.getId(), a.getName());
				dto.getAuhors().add(ad);
			};
		}
		return dto;
	}

	public static Book toBook(BookDto book) {
		Book bk = new Book(book.getId(), book.getName(), book.getDescription(), book.getPrice());
		Set<AuthorDto> dtos = book.getAuhors();
		if(dtos != null && !dtos.isEmpty()) {
			for (AuthorDto a : dtos) {
				bk.addAuthor(new Author(a.getId(), a.getName()));
			}
		}
		return bk;
	}
}
