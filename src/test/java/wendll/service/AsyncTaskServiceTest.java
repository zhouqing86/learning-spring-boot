package wendll.service;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wendll.configuration.TaskExecutorConfig;

import static org.junit.Assert.*;

public class AsyncTaskServiceTest {
    @Test
    public void testAsyncTask() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for(int i=0; i<10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        context.close();
    }
}