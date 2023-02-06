package kg.cinematica.service;

import kg.cinematica.models.dto.PriceDto;
import kg.cinematica.models.requests.PriceRequest;

public interface PriceService extends BaseService<PriceDto>{
    PriceDto create(PriceRequest priceRequest);
}
