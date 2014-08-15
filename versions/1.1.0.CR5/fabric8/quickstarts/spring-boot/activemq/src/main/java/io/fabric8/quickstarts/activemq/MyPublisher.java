/**
 *  Copyright 2005-2014 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.quickstarts.activemq;

import org.springframework.jms.core.JmsTemplate;

import javax.annotation.PostConstruct;
import javax.jms.Destination;

/**
 */
public class MyPublisher {
    private final JmsTemplate jmsTemplate;
    private final Destination queue;
    private final String message;

    public MyPublisher(JmsTemplate jmsTemplate, Destination queue, String message) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
        this.message = message;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("" + this + " is starting up!");

        jmsTemplate.convertAndSend(queue, message);
        System.out.println("Sent message to queue: " + queue);
    }
}