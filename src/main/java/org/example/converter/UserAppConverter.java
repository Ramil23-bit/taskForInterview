package org.example.converter;

import org.example.dto.UserAppCreateDto;
import org.example.dto.UserAppResponseDto;
import org.example.entity.UserApp;
import org.springframework.stereotype.Component;

@Component
public class UserAppConverter implements Converter<UserApp, UserAppCreateDto, UserAppResponseDto>{
    @Override
    public UserAppResponseDto toDto(UserApp userApp) {
        return new UserAppResponseDto(userApp.getName(), userApp.getEmail(), userApp.getAge());
    }

    @Override
    public UserApp toEntity(UserAppCreateDto userAppRequestDto) {
        return new UserApp(userAppRequestDto.getName(), userAppRequestDto.getEmail(), userAppRequestDto.getAge(),
                userAppRequestDto.getWeight(), userAppRequestDto.getHeight(),
                userAppRequestDto.getTarget(), userAppRequestDto.getGender());
    }
}
