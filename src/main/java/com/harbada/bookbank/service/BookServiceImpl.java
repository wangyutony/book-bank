package com.harbada.bookbank.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.harbada.bookbank.dto.StoreConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.harbada.bookbank.dto.BookDto;
import com.harbada.bookbank.entity.Book;
import com.harbada.bookbank.exception.ResourceNotFoundException;
import com.harbada.bookbank.mapper.BookMapper;
import com.harbada.bookbank.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Value("${book.store.name}")
    private String storeName;

	@Autowired
	private StoreConfiguration conf;
	
	@Override
	public BookDto create(BookDto bookDto) {
		Book book = BookMapper.toBook(bookDto);
		Book saved = bookRepository.save(book);
		return BookMapper.toBookDto(saved);
	}

	@Override
	public BookDto getBookById(Integer id) {
		System.out.println(conf.getReader().getName());
		System.out.println(storeName + "<<<<<<<<<<<<<<<<<<<<");
		System.out.println(conf.getType());
		Book book = bookRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Book is not found with id " + id)); 
		return BookMapper.toBookDto(book);
	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map((book) -> BookMapper.toBookDto(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDto> findBooksByAuthorId(Integer id) {
		Set<Book> books = bookRepository.findBooksByAuthorId(id);
		return books.stream().map((book) -> BookMapper.toBookDto(book)).collect(Collectors.toList());
	}

}
