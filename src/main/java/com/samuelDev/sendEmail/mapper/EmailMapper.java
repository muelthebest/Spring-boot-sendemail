package com.samuelDev.sendEmail.mapper;

import com.samuelDev.sendEmail.domain.Email;
import com.samuelDev.sendEmail.dtos.EmailDtoPost;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EmailMapper {
    public static final EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    public abstract Email toEmail(EmailDtoPost emailDto);
}
