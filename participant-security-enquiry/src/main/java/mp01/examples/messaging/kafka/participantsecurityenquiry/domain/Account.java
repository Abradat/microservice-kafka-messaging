package mp01.examples.messaging.kafka.participantsecurityenquiry.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private int participantId;

    @Column(nullable = false)
    private String ISIN;

    @Column(nullable = false)
    private Double amount;

    public Account(int participantId, String ISIN, Double amount) {
        this.participantId = participantId;
        this.ISIN = ISIN;
        this.amount = amount;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", participantId=" + participantId +
                ", ISIN='" + ISIN + '\'' +
                ", amount=" + amount +
                '}';
    }
}
