package kg.mega.saloon.service.impl;

import kg.mega.saloon.dao.ScheduleRep;
import kg.mega.saloon.enums.WorkDayEnum;
import kg.mega.saloon.mappers.ScheduleMapper;
import kg.mega.saloon.models.dto.ScheduleDto;
import kg.mega.saloon.service.MasterService;
import kg.mega.saloon.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRep rep;
    ScheduleMapper mapper = ScheduleMapper.INSTANCE;
    @Autowired
    MasterService masterService;


    @Override
    public ScheduleDto save(ScheduleDto scheduleDto) {
        return mapper.toDto(rep.save(mapper.toEntity(scheduleDto)));
    }

    @Override
    public ScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("График мастера не найден!")));
    }

    @Override
    public ScheduleDto delete(Long id) {
        return null;
    }

    @Override
    public List<ScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }


    @Override
    public ScheduleDto create(WorkDayEnum workDayEnum, LocalTime startTime, LocalTime endTime) {
        return save(new ScheduleDto(startTime,endTime,workDayEnum));
    }


    @Override
    public List<ScheduleDto> findScheduleByMasterId(Long id) {
        return mapper.toDtos(rep.findScheduleByMasterId(id));
    }

    @Override
    public Map<WorkDayEnum, String> scheduleMap(Long masterId) {
        List<ScheduleDto> list = mapper.toDtos(rep.findScheduleByMasterId(masterId));
        return null;
    }

    @Override
    public ScheduleDto create(LocalTime startTime, LocalTime endTime, WorkDayEnum workDay) {
        return null;
    }
}
