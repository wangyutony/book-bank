package com.harbada.bookbank.service;

import java.util.List;

import com.harbada.bookbank.dto.BookDto;

public interface BookService {
	BookDto create(BookDto book);
	
	BookDto getBookById(Integer id);
	
	List<BookDto> getAllBooks();

	List<BookDto> findBooksByAuthorId(Integer id);
}
