package kg.mega.saloon.service.impl;

import kg.mega.saloon.dao.OrderRep;
import kg.mega.saloon.enums.WorkDayEnum;
import kg.mega.saloon.mappers.OrderMapper;
import kg.mega.saloon.models.dto.ClientDto;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.models.dto.OrderDto;
import kg.mega.saloon.models.dto.ScheduleDto;
import kg.mega.saloon.models.requests.OrderRequest;
import kg.mega.saloon.models.responses.Response;
import kg.mega.saloon.network.EmailSender;
import kg.mega.saloon.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class OrderServiceImpl implements OrderService {

    OrderMapper mapper = OrderMapper.INSTANCE;
    private final OrderRep rep;
    private final ClientService clientService;
    private final MasterService masterService;
    private final ScheduleService scheduleService;

    public OrderServiceImpl(OrderRep rep, ClientService clientService, MasterService masterService, ScheduleService scheduleService) {
        this.rep = rep;
        this.clientService = clientService;
        this.masterService = masterService;
        this.scheduleService = scheduleService;
    }

//    @Autowired
//    private EmailSender

    @Override
    public OrderDto save(OrderDto order) {
        ClientDto client = new ClientDto();
        client.setName(order.getClient().getName());
        client.setSurname(order.getClient().getSurname());
        client.setPhoneNumber(order.getClient().getPhoneNumber());
        client.setEmail(order.getClient().getEmail());
        client = clientService.save(client);
        order.setClient(client);

        if (client.getName().isEmpty() | client.getPhoneNumber().isEmpty()) {
            throw new RuntimeException("Имя или номер телефона не может быть пустым!");
        }

        try {
            emailSender(order.getClient().getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mapper.toDto(rep.save(mapper.toEntity(order)));

    }

    @Override
    public OrderDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Заявка не найдена!")));
    }

    @Override
    public OrderDto delete(Long id) {
        OrderDto order = findById(id);
        order.setActive(false);
        return save(order);
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }


    @Override
    public void emailSender(String email) throws IOException, MessagingException {
        final Properties properties = new Properties();
        properties.load(EmailSender.class.getClassLoader().getResourceAsStream("application.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("41mazkin"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Hello");
        message.setText("you have successfully registered");

        Transport transport = mailSession.getTransport();
        transport.connect(null, "rpbubkqxutjgcjtx");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    @Override
    public Response create(OrderRequest order) {
        //Найти клиента, если его нет, ошибка код 404
        // Найти мастера,если нет 404
        //найти график мастера на этот appointmentDate
        //Найти день недели appointmentDate
        // по дню недели найти график
        //TODO add exc with 404 code
        ClientDto clientDto=clientService.findById(order.getClientId());
        MasterDto masterDto=masterService.findById(order.getMasterId());

        List<ScheduleDto>  scheduleDtos=scheduleService.getScheduleByMasterId(masterDto.getId());
        ScheduleDto scheduleDto=null;
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(order.getAppointmentDate());
        WorkDayEnum workDayEnum=WorkDayEnum.getValue(calendar.get(Calendar.DAY_OF_WEEK));

        for (ScheduleDto item:scheduleDtos){
            if (item.getWorkDay().equals(workDayEnum)){
                scheduleDto=item;
                break;
            }else {
                throw new RuntimeException("В этот день мастер не работает");
            }
        }
        //проверка на график мастера
        // проверка на ордерс

        LocalTime startTime=scheduleDto.getStartTime();

//        if (calendar.get(Calendar.))

//TODO https://stackoverflow.com/questions/29927362/localtime-from-date






        return null;
    }
}
