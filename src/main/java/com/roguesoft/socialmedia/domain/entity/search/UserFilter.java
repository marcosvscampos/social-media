package com.roguesoft.socialmedia.domain.entity.search;

import lombok.Getter;

@Getter
public class UserFilter extends Filter {

    private final String name;

    public UserFilter(){
        super();
        this.name = "";
    }

    public UserFilter(final String name){
        super();
        this.name = name;
    }

}
