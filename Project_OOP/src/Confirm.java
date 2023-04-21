import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Confirm extends JFrame implements ActionListener {
    static String file = "Food Delivery.dat";
    JButton back,confirm;
    JLabel order,name,address,phone,nametitle,addresstitle,phonetitle,totalprice,getTotalprice;
    JPanel panel,panelButton,panelName,panelAddress,panelPhone,panelprice;
    ArrayList<Customer> clist = new ArrayList<>();

    Confirm()
    {

     order = new JLabel("Food you have order");

     nametitle = new JLabel("Name :");
     nametitle.setFont(new Font("",Font.BOLD,16));
     name = new JLabel(CustomerInfo.Name.getText());
     name.setFont(new Font("",Font.BOLD,12));
     panelName = new JPanel(new GridLayout(1,2));
     panelName.add(nametitle);
     panelName.add(name);

     address = new JLabel(CustomerInfo.Address.getText());
     address.setFont(new Font("",Font.BOLD,12));
     addresstitle = new JLabel("Address :");
     addresstitle.setFont(new Font("",Font.BOLD,16));
     panelAddress = new JPanel(new GridLayout(1,2));
     panelAddress.add(addresstitle);
     panelAddress.add(address);

     phone = new JLabel(CustomerInfo.Phone.getText());
     phone.setFont(new Font("",Font.BOLD,12));
     phonetitle = new JLabel("Phone :");
     phonetitle.setFont(new Font("",Font.BOLD,16));
     panelPhone = new JPanel(new GridLayout(1,2));
     panelPhone.add(phonetitle);
     panelPhone.add(phone);

     totalprice = new JLabel("Total Price :");
     getTotalprice = new JLabel(String.valueOf(Order.totalprice));
     panelprice = new JPanel(new GridLayout(1,2));
     panelprice.add(totalprice);
     panelprice.add(getTotalprice);


     back = new JButton("Back");
     confirm = new JButton("Confirm");
     panelButton = new JPanel(new GridLayout(2,1));
     panelButton.setBorder(BorderFactory.createEmptyBorder(10,60,10,60));
     panelButton.add(confirm);
     panelButton.add(back);

     confirm.addActionListener(this);
     back.addActionListener(this);



     panel = new JPanel(new GridLayout(7,1));
     panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
     panel.setBackground(new Color(255,127,80));
     panel.add(panelName);
     panel.add(panelAddress);
     panel.add(panelPhone);
     panel.add(Order.scrollPaneFood);
     panel.add(panelButton);
     panel.add(panelprice);

     add(panel, BorderLayout.CENTER);
     setTitle("Food Delivery - Confirm");
     setSize(500,500);
     setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Confirm"))
        {
            try{
                //Add to Customer list
                clist.add(new Customer(CustomerInfo.Name.getText(), CustomerInfo.Address.getText(),Long.parseLong(CustomerInfo.Phone.getText()),Order.foodArrayList));

                //Add to file

                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(clist);
                out.flush();
                out.close();

                JOptionPane.showConfirmDialog(this,"Order Finish", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);
            }
            catch (Exception q)
            {
                JOptionPane.showConfirmDialog(this,"Error", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);
                System.out.println(q);
            }
        }
        if(e.getActionCommand().equals("Back"))
        {
            setVisible(false);
            new Order();

        }
    }

    public static void main(String[] args)
    {
        new Confirm();
    }
}
