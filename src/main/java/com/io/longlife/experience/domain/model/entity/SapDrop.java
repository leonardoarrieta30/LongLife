package com.io.longlife.experience.domain.model.entity;

import com.io.longlife.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sap_drops")
public class SapDrop extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String summary;

    private String content;
}
