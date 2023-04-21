import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Menu extends JFrame implements ActionListener {
    private JButton add, back,showorder;
    private JTextField f, p;
    private JLabel menu, foodLabel, priceLabel, error;
    private JPanel panel, fpanel, ppanel,area,panelButton;
    private JTextArea foodArea,priceArea;
    public static DefaultListModel<Food> l1 = new DefaultListModel<>();

    public  JList<Food> l = new JList<>();
    public  JScrollPane sp = new JScrollPane(l);
    Menu() {
        l.setModel(l1);


        add = new JButton("Add");
        add.addActionListener(this);

        back = new JButton("Back");
        back.addActionListener(this);

        showorder = new JButton("Confirm Order");
        showorder.addActionListener(this);

        panelButton = new JPanel(new GridLayout(2,1,2,2));
        panelButton.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        panelButton.add(add);
        panelButton.add(showorder);
        panelButton.add(back);


        menu = new JLabel("Menu", SwingConstants.CENTER);
        menu.setFont(new Font("", Font.BOLD, 40));
        menu.setForeground(Color.yellow);
        menu.setBorder(BorderFactory.createLineBorder(Color.yellow,5));

        foodLabel = new JLabel("Food :");
        foodLabel.setFont(new Font("",Font.BOLD,25));
        priceLabel = new JLabel("Price :");
        priceLabel.setFont(new Font("",Font.BOLD,25));
        f = new JTextField(20);
        p = new JTextField(20);

        fpanel = new JPanel(new GridLayout(1, 2));
        fpanel.add(foodLabel);
        fpanel.add(f);

        ppanel = new JPanel(new GridLayout(1, 2));
        ppanel.add(priceLabel);
        ppanel.add(p);




        foodArea = new JTextArea(10,1);
        priceArea = new JTextArea(10,1);
        area = new JPanel(new GridLayout(1,2));
        area.add(foodArea);
        area.add(priceArea);


        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel = new JPanel(new GridLayout(5, 1,1,1));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setBackground(new Color(255,127,80));
        panel.add(menu);
        panel.add(fpanel);
        panel.add(ppanel);
        panel.add(sp);
        panel.add(panelButton);



        add(panel, BorderLayout.CENTER);

        setSize(600, 600);

        setTitle("Food Delivery - Menu");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Add"))
        {
            try
            {
                if (f.getText() != null && p.getText() != null) {
                    l1.addElement(new Food(f.getText(), Double.parseDouble(p.getText())));

                    clear();

                }
            }
            catch (Exception g)
            {
                JOptionPane.showConfirmDialog(this,"Error", "Food Delivery" ,JOptionPane.DEFAULT_OPTION);

            }


        }
        if (e.getActionCommand().equals("Back"))
        {
            new Login();
            setVisible(false);
        }
        if(e.getActionCommand().equals("Confirm Order"))
        {
            new ShowOrder();
            setVisible(false);
        }

    }

    public void clear()
    {
        f.setText("");
        p.setText("");

    }
}
