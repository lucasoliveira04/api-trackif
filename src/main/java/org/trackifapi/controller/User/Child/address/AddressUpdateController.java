package org.trackifapi.controller.User.Child.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.modal.dto.TokenModalChildDto;
import org.trackifapi.services.User.Child.address.AddressUpdateService;

@RestController
@RequestMapping("/api/address")
public class AddressUpdateController {
    private final AddressUpdateService addressUpdateService;

    public AddressUpdateController(AddressUpdateService addressUpdateService) {
        this.addressUpdateService = addressUpdateService;
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyAndUpdateAddress(@RequestBody TokenModalChildDto dto) {
        return addressUpdateService.verifyAndUpdateAddress(dto.getId());
    }
}
