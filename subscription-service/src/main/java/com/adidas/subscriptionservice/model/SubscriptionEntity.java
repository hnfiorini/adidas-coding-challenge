package com.adidas.subscriptionservice.model;

import com.adidas.subscriptionservice.enums.GenderEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private GenderEnum gender;
    @Column
    private LocalDate dayOfBirth;
    @Column
    private boolean consent;
    @Column
    private String idNewsletter;
    @Column
    private boolean active;
}
