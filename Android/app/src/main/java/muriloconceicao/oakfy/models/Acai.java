package muriloconceicao.oakfy.models;

import java.util.List;

public class Acai {

    private String size;
    private List<String> toppings;

    public Acai() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
}