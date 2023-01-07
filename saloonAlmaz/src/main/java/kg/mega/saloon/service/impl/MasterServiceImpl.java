package kg.mega.saloon.service.impl;

import kg.mega.saloon.dao.MasterRep;
import kg.mega.saloon.mappers.MasterMapper;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
    private MasterRep rep;
    MasterMapper mapper = MasterMapper.INSTANCE;


    @Override
    public MasterDto save(MasterDto master) {
        return mapper.toDto(rep.save(mapper.toEntity(master)));
    }

    @Override
    public MasterDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Мастер не найден!")));
    }

    @Override
    public MasterDto delete(Long id) {
        MasterDto master = findById(id);
        master.setActive(false);
        return save(master);
    }

    @Override
    public List<MasterDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
