package com.roguesoft.socialmedia.domain.entity.search;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserFilter extends Filter {

    private String name;

    private String username;

    public UserFilter(final String name, final String username){
        super();
        this.name = name;
        this.username = username;
    }
}
