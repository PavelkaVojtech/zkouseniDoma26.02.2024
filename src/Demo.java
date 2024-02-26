import javax.swing.*;
import java.util.ArrayList;

public class Demo extends JFrame{
    private JTextField textField1;
    private JButton predchoziBtn;
    private JButton dalsiBtn;
    private JPanel panelMain;
    private int aktualniIndex = 0;
    private ArrayList<Integer> cisla = new ArrayList<>();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Akce", true);
    private JMenuItem menuItem = new JMenuItem("pozdrav");

    public Demo(){
        initComponents();
        for (int i = 0; i < 5;i++){
            cisla.add(i);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("moje neco");
        setContentPane(panelMain);
        pack();
    }

    private void initComponents(){
            zobrazCislo(aktualniIndex);
            dalsiBtn.addActionListener(e -> dalsiMetoda());
            predchoziBtn.addActionListener(e -> predchoziMetoda());
            predchoziBtn.setEnabled(false);
            menuBar.add(menu);
            menu.add(menuItem);
            menuItem.addActionListener(e -> pozdrav());

            setJMenuBar(menuBar);
    }

    public void dalsiMetoda(){
        aktualniIndex++;
        zobrazCislo(aktualniIndex);
        dalsiBtn.setEnabled(aktualniIndex < cisla.size()-1);
        predchoziBtn.setEnabled(aktualniIndex > 0);
    }

    public void predchoziMetoda(){
        aktualniIndex--;
        zobrazCislo(aktualniIndex);
        predchoziBtn.setEnabled(aktualniIndex > 0);
        dalsiBtn.setEnabled(aktualniIndex < cisla.size()-1);
    }

    public void zobrazCislo(int aktualniIndex){
        textField1.setText(new String(Integer.toString(aktualniIndex)));
    }

    private void pozdrav(){
        JOptionPane.showMessageDialog(this, "Hello");
    }
}
