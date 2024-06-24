package com.harbada.bookbank.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.harbada.bookbank.dto.BookDto;
import com.harbada.bookbank.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto)
	{
		BookDto saved = bookService.create(bookDto);
		
		
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/author/{id}")
	public ResponseEntity<List<BookDto>> getBooksByAuthorId(@PathVariable(name="id") Integer id)
	{
		List<BookDto> books = bookService.findBooksByAuthorId(id);
		return new ResponseEntity<>(books, HttpStatus.FOUND);
	}

	@GetMapping
	public ResponseEntity<List<BookDto>> getAll(@RequestParam(name="id", required=false) Integer id)
	{
		if(id == null) {
			List<BookDto> books = bookService.getAllBooks();
			return new ResponseEntity<>(books, HttpStatus.FOUND);
		}
		else {
			BookDto book = bookService.getBookById(id);
			List<BookDto> books = new LinkedList<>();
			books.add(book);
			return new ResponseEntity<>(books, HttpStatus.FOUND);
		}
	}	
}
