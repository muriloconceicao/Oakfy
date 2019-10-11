package muriloconceicao.oakfy.models;

public class Demand {

    private int demandNumber;
    private double totalPrice;
    private Acai acai;
    private User user;

    public Demand() {
    }

    public int getDemandNumber() {
        return demandNumber;
    }

    public void setDemandNumber(int demandNumber) {
        this.demandNumber = demandNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Acai getAcai() {
        return acai;
    }

    public void setAcai(Acai acai) {
        this.acai = acai;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}