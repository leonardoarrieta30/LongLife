package com.io.longlife.experience.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateBigTreeResource {
    @NotNull
    @NotBlank
    @Column(unique = true)
//    @Size(max = 60)
    private String username;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String gender;

    private Date bornAt;
}
