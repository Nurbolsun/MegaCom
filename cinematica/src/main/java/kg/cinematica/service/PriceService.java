package kg.cinematica.service;

import kg.cinematica.enums.Type;
import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.requests.PriceRequest;

import java.util.List;

public interface PriceService extends BaseService<PriceDto>{
    PriceDto create(PriceRequest priceRequest);
    int getPrice(Type priceType);
    List<PriceDto> findPrice(Type priceType);
}
