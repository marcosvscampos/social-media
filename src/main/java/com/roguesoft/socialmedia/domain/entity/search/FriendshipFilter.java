package com.roguesoft.socialmedia.domain.entity.search;

import lombok.Getter;

@Getter
public class FriendshipFilter extends Filter {

    private final String userId;

    public FriendshipFilter(final String userId) {
        super();
        this.userId = userId;
    }

}
