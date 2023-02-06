package kg.cinematica.mappers;

import kg.cinematica.models.dto.RoomDto;
import kg.cinematica.models.entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RoomMapper extends BaseMapper<Room, RoomDto> {
    RoomMapper INSTANCE  = Mappers.getMapper(RoomMapper.class);
}
