package com.demo.example.student_library_management_system.requestdto;

import com.demo.example.student_library_management_system.enums.CardStatus;
import lombok.Data;

@Data
public class CardRequestDto {

    private CardStatus cardStatus;
    private int studentId;
}
