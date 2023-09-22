package com.roguesoft.socialmedia.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("friendships")
public class FriendshipModel {

    @Id
    private String id;

    private String userId;

    private String friendId;

}
