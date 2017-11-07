package wendll.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SchedulingService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次 " + LocalDateTime.now().format(formatter));
    }

    public void fixTimeExecution() {
        System.out.println("在指定时间 " + LocalDateTime.now().format(formatter) + "执行");
    }
}
