package mp01.examples.messaging.kafka.participantsecurityenquiry.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.Account;
import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.kafka.AccountRequest;
import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.kafka.AccountResponse;
import mp01.examples.messaging.kafka.participantsecurityenquiry.repository.PSERepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PSEKafkaConsumerService {

    @Autowired
    private PSERepository pseRepository;

    @Autowired
    private PSEKafkaProducerService pseKafkaProducerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PSEKafkaConsumerService.class);

    @KafkaListener(topics = "${kafka.topic.pse.json}")
    public void receiveMessageFromCSS(String accountRequestAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        AccountRequest accountRequest;
        try {
            accountRequest = objectMapper.readValue(accountRequestAsString, AccountRequest.class);
        } catch (IOException ex) {
            accountRequest =  new AccountRequest(0);
            ex.printStackTrace();
        }

        LOGGER.info("Received Account Request='{}'", accountRequest.toString());

        Account auxAccount = pseRepository.findAccountByParticipantId(accountRequest.getParticipantId());
        if(auxAccount != null ) {
            AccountResponse accountResponse = new AccountResponse(auxAccount.getParticipantId(), auxAccount.getISIN(), auxAccount.getAmount());
            pseKafkaProducerService.sendMessageToCSS(accountResponse);
        } else {
            AccountResponse accountResponse = new AccountResponse(0, "0", 0.0);
            pseKafkaProducerService.sendMessageToCSS(accountResponse);
        }
    }
}
