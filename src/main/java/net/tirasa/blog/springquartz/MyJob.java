/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.tirasa.blog.springquartz;

import net.tirasa.blog.springquartz.beans.SyncopeUser;
import net.tirasa.blog.springquartz.repository.SyncopeUserRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class MyJob implements StatefulJob {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            MyJob.class);

    @Autowired
    private SyncopeUserRepository repository;

    @Override
    @Transactional
    public void execute(final JobExecutionContext context)
            throws JobExecutionException {

        LOG.info("At first, there are {} users", repository.count());

        final SyncopeUser user1 = new SyncopeUser();
        user1.setUsername("user1");
        user1.setPassword("password1");
        final SyncopeUser saved1 = repository.save(user1);

        LOG.info("Before saving: {}; after saving: {}", user1, saved1);

        LOG.info("Now, there are {} users", repository.count());
    }
}
