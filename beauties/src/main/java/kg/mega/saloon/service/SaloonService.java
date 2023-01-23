package kg.mega.saloon.service;

import kg.mega.saloon.models.dto.SaloonDto;
import kg.mega.saloon.models.requests.SaloonRequest;

public interface SaloonService extends BaseService<SaloonDto>{
    SaloonDto create (SaloonRequest saloon);
}
