package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.requestdto.CardRequestDto;

public class CardConverter {

    // converts CardRequestDto into Card class

    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){
        Card card =  Card.builder()
                .cardStatus(cardRequestDto.getCardStatus())
                .build();
        return card;
    }
}
