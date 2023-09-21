package com.roguesoft.socialmedia.application.api;

import com.roguesoft.socialmedia.application.dto.ResponseDTO;
import com.roguesoft.socialmedia.application.dto.friend.FriendshipDTO;
import com.roguesoft.socialmedia.domain.usecase.CreateRegistryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendsController {

    private final CreateRegistryUseCase<FriendshipDTO, ResponseDTO> createNewFriendshipUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> addFriend(@RequestBody FriendshipDTO request){
        ResponseDTO response = createNewFriendshipUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
