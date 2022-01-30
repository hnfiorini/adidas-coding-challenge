package com.adidas.emailservice.dto;

import com.adidas.emailservice.enums.GenderEnum;
import lombok.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subscription {
    @org.springframework.lang.NonNull
    private String email;
    private String firstName;
    private GenderEnum gender;
    @org.springframework.lang.NonNull
    private LocalDate dateOfBirth;
    private Boolean consent;
    @NonNull
    private String idNewsletter;

}
