import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Order  extends JFrame implements ActionListener {
    static double totalprice = 0;

    private JLabel orderfood;
    private JButton order,back,add;
    private JPanel panel,panelButton;

    static JTextArea food = new JTextArea();
    static JScrollPane scrollPaneFood = new JScrollPane(food);
    static public JList<Food> listorder = new JList<>(Menu.l1);

    public JScrollPane spOrder = new JScrollPane(listorder);

    JMenu Customer = new JMenu("Customer");
    JMenuItem customerInfo = new JMenuItem("CustomerInfo");
    JMenuItem login = new JMenuItem("Login");
    JMenuItem exit = new JMenuItem("exit");
    JMenuBar menuBar = new JMenuBar();
    static  ArrayList<Food> foodArrayList = new ArrayList<>();

    Order()
    {
        //Title Label
        orderfood = new JLabel("Order Food",SwingConstants.CENTER);
        orderfood.setFont(new Font("",Font.BOLD,50));
        orderfood.setForeground(Color.yellow);
        orderfood.setBorder(BorderFactory.createLineBorder(Color.yellow,5));

        //Button
        add = new JButton("Add");
        add.addActionListener(this);
        order = new JButton("Order");
        order.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);

        //PanelButton
        panelButton = new JPanel(new GridLayout(3,1,2,2));
        panelButton.setBorder(BorderFactory.createEmptyBorder(2,50,2,50));
        panelButton.add(add);
        panelButton.add(order);
        panelButton.add(back);

        //Menu bar
        login.addActionListener(this);
        customerInfo.addActionListener(this);
        exit.addActionListener(this);
        Customer.add(login);
        Customer.add(customerInfo);
        Customer.add(exit);
        menuBar.add(Customer);

        //Panel
        panel = new JPanel(new GridLayout(3,1,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        panel.setBackground(new Color(255,127,80));
        panel.add(orderfood);
        panel.add(spOrder);
        panel.add(panelButton);

        //Frame
        add(panel,BorderLayout.CENTER);
        setJMenuBar(menuBar);
        setTitle("Food Delivery - Order");
        setSize(500,500);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add"))
        {
            if(listorder.getSelectedValue() != null)
            {
                //ListCustomer.add(new Customer(CustomerInfo.Name.getText(), CustomerInfo.Address.getText(),Long.parseLong(CustomerInfo.Phone.getText()),foodArrayList.add(new Food(listorder.getSelectedValue().foodname,listorder.getSelectedValue().price))));
                food.append(listorder.getSelectedValue().toString() + "\n");
                foodArrayList.add(new Food(listorder.getSelectedValue().foodname,listorder.getSelectedValue().price));
                totalprice = totalprice + listorder.getSelectedValue().price;
                JOptionPane.showConfirmDialog(this,"Add food in your list already ", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);
            }
            else
                JOptionPane.showConfirmDialog(this,"Error", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);
        }

        if(e.getActionCommand().equals("Order"))
        {
            if(listorder.getSelectedValue() != null)
            {
                new Confirm();
            }
            else
                JOptionPane.showConfirmDialog(this,"You haven't selected your food", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);
        }


        else if(e.getActionCommand().equals("Back"))
        {
            new CustomerInfo();
           setVisible(false);
        }
        else if(e.getSource() == customerInfo)
        {
            new CustomerInfo();
           setVisible(false);

        }
        else if(e.getSource() == exit)
        {
            System.exit(0);
        }
        else if(e.getSource() == login)
        {
            new Login();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Order();
    }
}
