package br.com.example.asb.asbmessagecount;

import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClient;
import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClientBuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServiceBusMessageCounter {
    public static int countMessagesInQueue(String connectionString, String queueName) {

        ServiceBusAdministrationClientBuilder builder = new ServiceBusAdministrationClientBuilder()
                .connectionString(connectionString);
        ServiceBusAdministrationClient adminClient = builder.buildClient();

        return adminClient.getQueueRuntimeProperties(queueName).getActiveMessageCount();
    }
}
