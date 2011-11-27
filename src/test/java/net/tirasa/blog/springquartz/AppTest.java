package net.tirasa.blog.springquartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml"
})
public class AppTest {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            AppTest.class);

    @Test
    public void run() {
        LOG.info("Application started");
    }
}
