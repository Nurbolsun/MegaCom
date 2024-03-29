package kg.cinematica.service.impl;

import kg.cinematica.dao.ScheduleRep;
import kg.cinematica.mappers.ScheduleMapper;
import kg.cinematica.models.dto.ScheduleDto;
import kg.cinematica.models.requests.ScheduleRequest;
import kg.cinematica.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRep rep;
    ScheduleMapper mapper = ScheduleMapper.INSTANCE;

    @Override
    public ScheduleDto save(ScheduleDto scheduleDto) {
        return mapper.toDto(rep.save(mapper.toEntity(scheduleDto)));
    }

    @Override
    public ScheduleDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Расписание не найдено")));
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
    public ScheduleDto create(LocalDate startDate, LocalTime startTime ) {
        return save(new ScheduleDto(startDate, startTime));
    }
}
