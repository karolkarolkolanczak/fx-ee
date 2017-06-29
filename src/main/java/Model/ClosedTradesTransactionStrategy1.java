package Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by a on 28/06/2017.
 */
@Entity
public class ClosedTradesTransactionStrategy1 extends ClosedTradesTransaction {
    @Id
    @Column(name="transactionId")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int transactionId;

    @Transient
    private String resource= "/Transactions/closedTradesStrategy1.csv";

    public ClosedTradesTransactionStrategy1() {
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public int getTransactionId() {
        return transactionId;
    }

    @Override
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
