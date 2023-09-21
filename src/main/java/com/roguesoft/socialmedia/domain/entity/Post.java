package com.roguesoft.socialmedia.domain.entity;

import com.roguesoft.socialmedia.infrastructure.model.PostModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    public String description;
}
