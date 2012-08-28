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
package net.tirasa.blog.springquartz.repository.impl;

import javax.persistence.EntityManager;
import net.tirasa.blog.springquartz.beans.SyncopeUser;
import net.tirasa.blog.springquartz.repository.SyncopeUserRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SyncopeUserRepositoryImpl implements SyncopeUserRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SyncopeUserRepositoryCustom.class);

    public SyncopeUser uselessMethod(final SyncopeUser user) {
        SyncopeUser sameUser = entityManager.find(SyncopeUser.class, user.getId());
        LOG.info("Useless method: {} {}", user, sameUser);
        return sameUser;
    }
}
