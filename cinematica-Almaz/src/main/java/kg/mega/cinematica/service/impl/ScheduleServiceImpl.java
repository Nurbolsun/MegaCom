package kg.mega.cinematica.service.impl;

import kg.mega.cinematica.dao.ScheduleRep;
import kg.mega.cinematica.exceptions.ScheduleNotFoundException;
import kg.mega.cinematica.mappers.ScheduleMapper;
import kg.mega.cinematica.models.dto.ScheduleDto;
import kg.mega.cinematica.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    ScheduleMapper mapper = ScheduleMapper.INSTANCE;
    private final ScheduleRep rep;

    @Autowired
    public ScheduleServiceImpl(ScheduleRep rep) {
        this.rep = rep;
    }

    @Override
    public ScheduleDto save(ScheduleDto scheduleDto) {
        return mapper.toDto(rep.save(mapper.toEntity(scheduleDto)));
    }

    @Override
    public ScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new ScheduleNotFoundException("Schedule not found!")));
    }

    @Override
    public ScheduleDto delete(Long id) {
        ScheduleDto scheduleDto = findById(id);
        scheduleDto.setActive(false);
        return save(scheduleDto);
    }

    @Override
    public List<ScheduleDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public ScheduleDto create(LocalDate startDay, LocalTime startTime) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setStartDay(startDay);
        scheduleDto.setStartTime(startTime);
        return save(scheduleDto);
    }
}
