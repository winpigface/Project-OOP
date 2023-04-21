import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private  JTextField u;
    private JPasswordField p;
    private JCheckBox c;
    private JCheckBox r;
    private JTextArea area;
    Login()
    {

        JLabel fd = new JLabel("Food Delivery",SwingConstants.CENTER);
        fd.setFont(new Font("",Font.BOLD,50));
        fd.setForeground(Color.yellow);
        fd.setBorder(BorderFactory.createLineBorder(Color.yellow,5));




        JButton l = new JButton("Login");
        l.addActionListener(this);
        JButton e = new JButton("Exit");
        e.addActionListener(this);
        JPanel pannelButton = new JPanel(new GridLayout(2,1,3,3));
        pannelButton.setBorder(BorderFactory.createEmptyBorder(1,70,1,70));
        pannelButton.add(l);
        pannelButton.add(e);

        c = new JCheckBox("Customer");

        r = new JCheckBox("Restaurant owner");



        JPanel user = new JPanel();
        user.setLayout(new GridLayout(1,2));
        user.add(new JLabel("Username :"));
        u =  new JTextField(20);
        user.add(u);

        JPanel password = new JPanel();
        password.setLayout(new GridLayout(1,2));
        password.add(new JLabel("Password :"));
        p = new JPasswordField(20);
        password.add(p);

        area = new JTextArea(1,10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,1));
        panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        panel.setBackground(new Color(255,127,80));

        panel.add(fd);
        panel.add(user);
        panel.add(password);
        panel.add(c);
        panel.add(r);
        panel.add(pannelButton);




        add(panel,BorderLayout.CENTER);
        setSize(500,500);

        setTitle("Food Delivery-Login");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            if(e.getActionCommand().equals("Login"))
            {

                if (c.isSelected() && new String(p.getPassword()).equals("1234") && new String(u.getText()).equals("N"))
                {

                    new CustomerInfo();
                    setVisible(false);

                }
                else if (r.isSelected() && new String(p.getPassword()).equals("1234") && new String(u.getText()).equals("N"))
                {
                    new Menu();
                    setVisible(false);

                }
                else
                {
                    clearTextField();
                    JOptionPane.showConfirmDialog(this,"Login Fail !!!!", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(e.getActionCommand().equals("Exit"))
            {
                System.exit(0);
            }



    }
    public void clearTextField()
    {
        u.setText("");
        p.setText("");
        area.setText("");
    }

    public static void main(String[] args) {
        new Login();
    }
}
