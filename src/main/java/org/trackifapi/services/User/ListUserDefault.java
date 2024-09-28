package org.trackifapi.services.User;

import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.UserDefaultDto;
import org.trackifapi.modal.entity.UserDefault.UserDefault;
import org.trackifapi.modal.repository.UserDefaultRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListUserDefault {
    private final UserDefaultRepository userDefaultRepository;

    public ListUserDefault(UserDefaultRepository userDefaultRepository) {
        this.userDefaultRepository = userDefaultRepository;
    }

    public List<UserDefaultDto> listUserDefault() {
        List<UserDefault> userDefaultList = userDefaultRepository.findAll();
        return userDefaultList.stream()
                .map(UserDefaultDto::fromEntity)
                .collect(Collectors.toList());
    }

}
