import java.io.Serializable;

public class Food implements Serializable {
    public String foodname;
    public double price;

    Food(String foodname,double price)
    {

        this.foodname = foodname;
        this.price = price;

    }
    public  String toString()
    {
        return "Food : " + foodname +"          "+ "price : " + price + "  Baht" + "\n";
    }

    public String getFoodname() {
        return foodname;
    }

    public double getPrice() {
        return price;
    }
}
