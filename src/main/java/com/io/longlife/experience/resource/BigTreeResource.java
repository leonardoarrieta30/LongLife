package com.io.longlife.experience.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BigTreeResource {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private Date bornAt;
}
