package kg.megacom.beauties.services;

public interface BaseService <DTO>{
    DTO save(DTO dto);
    DTO findById(Long id);
}
