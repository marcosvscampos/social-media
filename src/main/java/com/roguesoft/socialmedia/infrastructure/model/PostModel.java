package com.roguesoft.socialmedia.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("posts")
public class PostModel {

    @Id
    private String id;

    private String description;

    private String userId;

}
