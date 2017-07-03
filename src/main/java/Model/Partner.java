package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="partner")
@Cacheable(false)
public class Partner {
    @Id
    @Column(name="partnerId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int partnerId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private Date joinedDate;
    private int closedTradesTransactionStrategyNumber;
    @Transient
    //@Digits(integer=9, fraction=2)
    private float totalBonusForPeriod;

    public Partner() {
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClosedTradesTransactionStrategyNumber() {
        return closedTradesTransactionStrategyNumber;
    }

    public void setClosedTradesTransactionStrategyNumber(int closedTradesTransactionStrategyNumber) {
        this.closedTradesTransactionStrategyNumber = closedTradesTransactionStrategyNumber;
    }

    public float getTotalBonusForPeriod() {
        return totalBonusForPeriod;
    }

    public void setTotalBonusForPeriod(float totalBonusForPeriod) {
        this.totalBonusForPeriod = totalBonusForPeriod;
    }

//    public Date getJoinedDate() {
//        return joinedDate;
//    }
//
//    public void setJoinedDate(Date joinedDate) {
//        this.joinedDate = joinedDate;
//    }
}
