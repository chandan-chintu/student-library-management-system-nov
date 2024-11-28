package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {

    // converts BookRequestDto into Book class

    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto){
        Book book =  Book.builder()
                .name(bookRequestDto.getName())
                .pages(bookRequestDto.getPages())
                .publisherName(bookRequestDto.getPublisherName())
                .genre(bookRequestDto.getGenre())
                .available(bookRequestDto.isAvailable())
                .build();
        return book;
    }
}
