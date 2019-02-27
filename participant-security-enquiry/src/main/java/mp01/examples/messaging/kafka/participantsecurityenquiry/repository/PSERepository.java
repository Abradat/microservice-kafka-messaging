package mp01.examples.messaging.kafka.participantsecurityenquiry.repository;

import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PSERepository extends PagingAndSortingRepository<Account, Integer> {
    Account findAccountByParticipantId(int participantId);
}
