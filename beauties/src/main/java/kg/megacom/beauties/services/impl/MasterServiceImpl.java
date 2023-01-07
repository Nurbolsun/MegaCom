package kg.megacom.beauties.services.impl;

import kg.megacom.beauties.dao.MasterRep;
import kg.megacom.beauties.mappers.MasterMapper;
import kg.megacom.beauties.models.dtos.MasterDto;
import kg.megacom.beauties.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
    private MasterRep rep;
    MasterMapper mapper = MasterMapper.INSTANCE;

    @Override
    public MasterDto save(MasterDto masterDto) {
        return mapper.toDto(rep.save(mapper.toEntity(masterDto)));
    }

    @Override
    public MasterDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Мастер не найден")));
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
