package mp01.examples.messaging.kafka.centralsecuritysettlement.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

    private int participantId;
    private String ISIN;
    private Double amount;

    @JsonCreator
    public Account(@JsonProperty("participantId") int participantId,
                   @JsonProperty("ISIN") String ISIN,
                   @JsonProperty("amount") Double amount) {
        this.participantId = participantId;
        this.ISIN = ISIN;
        this.amount = amount;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "participantId=" + participantId +
                ", ISIN='" + ISIN + '\'' +
                ", amount=" + amount +
                '}';
    }
}
