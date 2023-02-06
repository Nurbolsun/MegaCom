package kg.cinematica.mappers;

import kg.cinematica.models.dto.UserDto;
import kg.cinematica.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper extends BaseMapper<User, UserDto>{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
