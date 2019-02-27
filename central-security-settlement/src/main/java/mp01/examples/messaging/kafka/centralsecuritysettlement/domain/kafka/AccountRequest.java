package mp01.examples.messaging.kafka.centralsecuritysettlement.domain.kafka;

public class AccountRequest {

    private int participantId;

    public AccountRequest(int participantId) {
        this.participantId = participantId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
                "participantId=" + participantId +
                '}';
    }
}
