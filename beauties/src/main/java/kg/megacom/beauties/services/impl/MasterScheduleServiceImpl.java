package kg.megacom.beauties.services.impl;

import kg.megacom.beauties.dao.MasterScheduleRep;
import kg.megacom.beauties.mappers.MasterScheduleMapper;
import kg.megacom.beauties.models.dtos.MasterScheduleDto;
import kg.megacom.beauties.models.entities.MasterSchedule;
import kg.megacom.beauties.services.MasterScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MasterScheduleServiceImpl implements MasterScheduleService {
    @Autowired
    private MasterScheduleRep rep;
    MasterScheduleMapper mapper = MasterScheduleMapper.INSTANCE;

    @Override
    public MasterScheduleDto save(MasterScheduleDto masterScheduleDto) {
        return mapper.toDto(rep.save(mapper.toEntity(masterScheduleDto)));
    }

    @Override
    public MasterScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("График не найден")));
    }

    @Override
    public MasterScheduleDto delete(Long id) {
        return null;
    }

    @Override
    public List<MasterScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
