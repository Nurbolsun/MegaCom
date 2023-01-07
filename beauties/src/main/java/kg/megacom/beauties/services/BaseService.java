package kg.megacom.beauties.services;

import java.util.List;

public interface BaseService <DTO>{
    DTO save(DTO dto);
    DTO findById(Long id);
    DTO delete(Long id);
    List<DTO> findAll();
}
