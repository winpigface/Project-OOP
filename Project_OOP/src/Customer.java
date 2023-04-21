import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    String name,address;
    long  phone;
    ArrayList<Food> food;
    public Customer(String name,String address, long phone,ArrayList<Food> food)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.food = food;
    }
    public String toString ()
    {
        return "Name :" + name + "Address :" + address + "Phone :" + phone + "\n" + food.toString();
    }
}
