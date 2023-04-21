import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfo extends JFrame implements ActionListener {
    static JTextField Name = new JTextField(40);
    static JTextField Address = new JTextField(40);
    static JTextField Phone = new JTextField(40);
    JMenu Customer = new JMenu("Customer");
    JMenuItem login = new JMenuItem("Login");
    JMenuItem exit = new JMenuItem("exit");
    JMenuBar menuBar = new JMenuBar();



    CustomerInfo() {
        JLabel f = new JLabel("CustomerInfo",SwingConstants.CENTER);
        f.setFont(new Font("",Font.BOLD,50));
        f.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        f.setForeground(Color.YELLOW);

        JButton start = new JButton("Next");
        start.addActionListener(this);
        JButton back = new JButton( "Back");
        back.addActionListener(this);


        JPanel namepanel = new JPanel();
        namepanel.setLayout(new GridLayout(1,2));

        namepanel.add(new JLabel("Name :"));
        namepanel.add(Name);

        JPanel address = new JPanel();
        address.setLayout(new GridLayout(1,2));
        address.add(new JLabel("Address :"));
        address.add(Address);

        JPanel phone = new JPanel();
        phone.setLayout(new GridLayout(1,2));
        phone.add(new JLabel("Phone Number :"));
        phone.add(Phone);

        JPanel panelButton = new JPanel(new GridLayout(2,1));
        panelButton.setBorder(BorderFactory.createEmptyBorder(3,50,3,50));
        panelButton.add(start);
        panelButton.add(back);

        login.addActionListener(this);
        exit.addActionListener(this);
        Customer.add(login);
        Customer.add(exit);
        menuBar.add(Customer);


        JPanel panel = new JPanel(new GridLayout(6,1,2,2));
        panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        panel.setBackground(new Color(255,127,80));
        panel.add(f);
        panel.add(namepanel);
        panel.add(address);
        panel.add(phone);
        panel.add(panelButton);




        add(panel);
        setJMenuBar(menuBar);
        setSize(500,500);
        setMinimumSize(new Dimension(500,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Food Delivery - CustomerInfo");


        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Next"))
        {

            if(Name.getText().equals("")   || Address.getText().equals("") || Phone.getText().equals(""))
            {
                JOptionPane.showConfirmDialog(this,"Error", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);
            }
            else
            {

                new Order();
                setVisible(false);
            }
        }
        else if(e.getActionCommand().equals("Back"))
        {

            new Login();
            setVisible(false);
        }
        else if (e.getSource() == login)
        {
            new Login();
            setVisible(false);
        }
        else if(e.getSource() == exit)
        {
            System.exit(0);
        }

    }

}

