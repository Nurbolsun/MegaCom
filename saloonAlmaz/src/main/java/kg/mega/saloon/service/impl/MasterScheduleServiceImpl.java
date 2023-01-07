package kg.mega.saloon.service.impl;

import kg.mega.saloon.dao.MasterScheduleRep;
import kg.mega.saloon.mappers.MasterScheduleMapper;
import kg.mega.saloon.models.dto.MasterScheduleDto;
import kg.mega.saloon.service.MasterScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterScheduleServiceImpl implements MasterScheduleService {
    @Autowired
    private MasterScheduleRep rep;

    MasterScheduleMapper mapper = MasterScheduleMapper.INSTANCE;


    @Override
    public MasterScheduleDto save(MasterScheduleDto masterSchedule) {
        return mapper.toDto(rep.save(mapper.toEntity(masterSchedule)));
    }

    @Override
    public MasterScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("График мастера не найден!")));
    }

    @Override
    public MasterScheduleDto delete(Long id) {
        MasterScheduleDto masterSchedule = findById(id);
        //????
        return null;
    }

    @Override
    public List<MasterScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
