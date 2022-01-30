package com.adidas.subscriptionservice.dto;

import com.adidas.subscriptionservice.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    private String email;
    private String firstName;
    private GenderEnum gender;
    private LocalDate dayOfBirth;
    private Boolean consent;
    private String idNewsletter;

}
