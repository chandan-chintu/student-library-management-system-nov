package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.demo.example.student_library_management_system.requestdto.CardRequestDto;

public class AuthorConverter {

    // converts AuthorRequestDto into Author class

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){
        Author author =  Author.builder()
                .name(authorRequestDto.getName())
                .gender(authorRequestDto.getGender())
                .country(authorRequestDto.getCountry())
                .rating(authorRequestDto.getRating())
                .build();
        return author;
    }
}
