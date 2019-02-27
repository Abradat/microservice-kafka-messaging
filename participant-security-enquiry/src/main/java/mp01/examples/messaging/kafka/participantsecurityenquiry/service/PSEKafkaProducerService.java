package mp01.examples.messaging.kafka.participantsecurityenquiry.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.kafka.AccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class PSEKafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PSEKafkaProducerService.class);

    @Value("${kafka.topic.css.json}")
    private String cssJsonTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToCSS(AccountResponse accountResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        LOGGER.info("Sending Account='{}", accountResponse.toString());
        String accountAsString;
        try {
            accountAsString = objectMapper.writeValueAsString(accountResponse);
        } catch (JsonProcessingException ex) {
            accountAsString = "ERROR";
        }
        kafkaTemplate.send(cssJsonTopic, accountAsString);
    }

}
