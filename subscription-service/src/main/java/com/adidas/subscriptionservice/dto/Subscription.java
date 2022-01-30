package com.adidas.subscriptionservice.dto;

import com.adidas.subscriptionservice.enums.GenderEnum;
import lombok.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @NonNull
    private String email;
    private String firstName;
    private GenderEnum gender;
    @NonNull
    private LocalDate dayOfBirth;
    private Boolean consent;
    @NonNull
    private String idNewsletter;

}
