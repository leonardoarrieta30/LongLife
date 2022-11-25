package com.io.longlife.experience.domain.model.entity;

import com.io.longlife.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "big_trees")
public class BigTree extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


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
