package mp01.examples.messaging.kafka.centralsecuritysettlement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import mp01.examples.messaging.kafka.centralsecuritysettlement.domain.Account;
import mp01.examples.messaging.kafka.centralsecuritysettlement.domain.kafka.AccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CSSKafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSSKafkaConsumerService.class);

    @KafkaListener(topics = "${kafka.topic.css.json}")
    public void receiveMessageFromPSE(String accountAsString) {

        System.out.println(accountAsString);
        ObjectMapper objectMapper = new ObjectMapper();
        AccountResponse accountResponse;
        try {
            accountResponse = objectMapper.readValue(accountAsString, AccountResponse.class);
        } catch (IOException ex) {
            accountResponse = new AccountResponse(0, "0", 0.0);
            ex.printStackTrace();
        }
        LOGGER.info("Received Account='{}'", accountResponse.toString());
    }
}
