package test.com.asutptec.simpleproject;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.asutptec.simpleproject.AppConfig;
import com.asutptec.simpleproject.domain.Status;
import com.asutptec.simpleproject.service.BaseService;
import com.asutptec.simpleproject.service.StatusServiceImpl;

public class AppTest {
    
    private static AnnotationConfigApplicationContext ctx;
    private static Logger log;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	 ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	 log = LoggerFactory.getLogger(AppTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	ctx.close();
    }

    @Test
    public void test() {
	BaseService<Status> service = (StatusServiceImpl) ctx.getBean("statusService");
	Status status = service.getById(1).get();
	log.info(status.toString());
	Status status2 = new Status();
	status2.setId(1);
	status2.setName("New report");
	assertEquals(status2, status);
    }

}
