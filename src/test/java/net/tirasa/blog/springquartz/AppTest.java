package net.tirasa.blog.springquartz;

import static org.junit.Assert.assertEquals;

import net.tirasa.blog.springquartz.repository.SyncopeUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SyncopeUserRepository repository;

    @Test
    public void run() {
        assertEquals(0, repository.count());
        LOG.info("Application started: {} objects stored", repository.count());

        // Let the job run...
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        assertEquals(1, repository.count());
        LOG.info("After Quartz job run, {} objects stored", repository.count());
    }
}
