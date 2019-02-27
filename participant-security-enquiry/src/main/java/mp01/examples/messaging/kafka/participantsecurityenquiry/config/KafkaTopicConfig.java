package mp01.examples.messaging.kafka.participantsecurityenquiry.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.pse.json}")
    private String topicName;

//    @Bean
//    public NewTopic pseTopic() {
//        return new NewTopic(topicName, 1, (short) 1);
//    }
}
