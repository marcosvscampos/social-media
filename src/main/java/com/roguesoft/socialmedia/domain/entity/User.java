package com.roguesoft.socialmedia.domain.entity;

import com.roguesoft.socialmedia.infrastructure.crypto.HashCreator;
import com.roguesoft.socialmedia.infrastructure.crypto.MD5HashCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String id;

    private String name;

    public String getId(){
        if(Objects.isNull(this.id)){
            this.generateId(new MD5HashCreator());
        }
        return this.id;
    }

    private void generateId(final HashCreator hashCreator){
        this.id = hashCreator.create(this.getName());
    }

    public String toString(){
        return "[ID: " + this.getId() + " | " + "NAME: " + this.getName() + "]";
    }

}
