package Model;

import java.math.BigDecimal;

/**
 * Created by a on 22/06/2017.
 */
public class QuotesData {

    private String symbol;
    private Long lasttime;
    private BigDecimal change;
    private float ask;
    private float bid;
    private int digits;
    private float change24h;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getLasttime() {
        return lasttime;
    }

    public void setLasttime(Long lasttime) {
        this.lasttime = lasttime;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public float getChange24h() {
        return change24h;
    }

    public void setChange24h(float change24h) {
        this.change24h = change24h;
    }
}
