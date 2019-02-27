package mp01.examples.messaging.kafka.centralsecuritysettlement.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mp01.examples.messaging.kafka.centralsecuritysettlement.domain.kafka.AccountRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CSSKafkaProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSSKafkaProducerService.class);

    @Value("${kafka.topic.pse.json}")
    private String pseJsonTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToPSE(AccountRequest accountRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        String accountRequestAsString;
        try {
            accountRequestAsString = objectMapper.writeValueAsString(accountRequest);
        } catch (JsonProcessingException e ) {
            accountRequestAsString = "ERROR";
        }
        LOGGER.info("Sending Account Request='{}'", accountRequest.toString());
        kafkaTemplate.send(pseJsonTopic, accountRequestAsString);
    }
}
