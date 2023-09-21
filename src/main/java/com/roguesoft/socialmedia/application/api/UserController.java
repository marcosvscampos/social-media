package com.roguesoft.socialmedia.application.api;

import com.roguesoft.socialmedia.application.dto.ResponseDTO;
import com.roguesoft.socialmedia.application.dto.user.UserDTO;
import com.roguesoft.socialmedia.domain.usecase.CreateRegistryUseCase;
import com.roguesoft.socialmedia.domain.usecase.GetRegistryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateRegistryUseCase<UserDTO, ResponseDTO> createRegistryUseCase;

    private final GetRegistryUseCase<String, UserDTO> getRegistryByIdUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> createUser(@RequestBody final UserDTO request){
        ResponseDTO response = createRegistryUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable String id){
        UserDTO response = getRegistryByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }



}
