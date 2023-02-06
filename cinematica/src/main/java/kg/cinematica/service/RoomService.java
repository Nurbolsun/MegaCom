package kg.cinematica.service;

import kg.cinematica.models.dto.RoomDto;
import kg.cinematica.models.requests.RoomRequest;

public interface RoomService extends BaseService<RoomDto> {
    RoomDto create(RoomRequest roomRequest);
}
