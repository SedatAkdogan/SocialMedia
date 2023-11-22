package com.bilgeadam.controller;

import com.bilgeadam.dto.request.ActivateStatusRequestDto;
import com.bilgeadam.dto.request.UserCreateRequestDto;
import com.bilgeadam.dto.request.UserProfileUpdateRequestDto;
import com.bilgeadam.repository.entity.UserProfile;
import com.bilgeadam.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.bilgeadam.constants.RestApi.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserProfileController {

    private final UserProfileService userProfileService;
    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody UserCreateRequestDto dto){
        return ResponseEntity.ok(userProfileService.createUser(dto));
    }

    @GetMapping(ACTIVATESTATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId){
        return ResponseEntity.ok(userProfileService.activateStatus(authId));
    }

    @PostMapping(ACTIVATESTATUS2)
    public ResponseEntity<Boolean> activateStatus2(@RequestBody ActivateStatusRequestDto dto){
        return ResponseEntity.ok(userProfileService.activateStatus2(dto));
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody UserProfileUpdateRequestDto dto){
        return ResponseEntity.ok(userProfileService.update(dto));
    }
    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> delete(@RequestParam Long authId){
        return ResponseEntity.ok(userProfileService.delete(authId));
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }

    /**
     * Serializable anatasyonu baseentity sınfına implemte edildi o swınıfta entitymizin parent sınıfıydı
     * o olmadan once serizalizyon atası veriyordu
     * @param username
     * @return
     */
    @GetMapping("/findByUsername")
    public ResponseEntity<UserProfile> findByUsername(@RequestParam String username){
        return ResponseEntity.ok(userProfileService.findOptionalByUsername(username));
    }

}
