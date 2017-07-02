package Model;

import javax.persistence.*;

/**
 * Created by a on 29/06/2017.
 */
@Entity
public class ClosedTradesTransactionStrategy7 extends ClosedTradesTransaction {
    @Id
    @Column(name="transactionId")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int transactionId;

    @Transient
    private String resource= "/Transactions/closedTradesStrategy7.csv";

    public ClosedTradesTransactionStrategy7() {
    }

    @Override
    public int getTransactionId() {
        return transactionId;
    }

    @Override
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
