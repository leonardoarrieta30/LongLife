package com.io.longlife.experience.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SapDropResource {
    private Long id;
    private String title;
    private String summary;
    private String content;
}
