package com.roguesoft.socialmedia.domain.entity.search;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class FriendshipFilter extends Filter {

    private String userId;

    public FriendshipFilter(final String userId) {
        super();
        this.userId = userId;
    }
}
