import javax.swing.*;
import javax.swing.plaf.synth.SynthButtonUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class YapilacaklarListesi {
	
	
	
	public static void main(String[] args) {
		JFrame pencere = new JFrame("TO DO LIST");
        pencere.setSize(400, 700);
        pencere.getContentPane().setBackground(Color.decode("#87CEEB"));

        JPanel pan = new JPanel();
        pan.setBounds(0, 0, 400, 50);
        pan.setBackground(Color.decode("#FFC0CB"));

        JLabel b = new JLabel("TO DO LIST");
        b.setForeground(Color.white);
        b.setFont(new Font("Calibri", Font.BOLD, 30));
        pan.add(b);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        JList<String> toDoList = new JList<>(listModel);
        toDoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        toDoList.setFont(new Font("Calibri", Font.ITALIC, 20));
        toDoList.setForeground(Color.darkGray);
        toDoList.setBackground(Color.decode("#FFFACD"));
        toDoList.setBounds(40, 100, 300, 450);

        JButton butonekle = new JButton("Gorev ekle");
        butonekle.setBounds(40, 570, 120, 40);
        butonekle.setBackground(Color.decode("#FFC0CB"));
        butonekle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = JOptionPane.showInputDialog("Gorev giriniz");
                if (task != null && !task.isEmpty()) {
                    listModel.addElement(task);
                }
            }
        });

        JButton tamamla = new JButton("Gorev tamamlandi");
        tamamla.setBounds(180, 570, 160, 40);
        tamamla.setBackground(Color.decode("#FFC0CB"));
        tamamla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(pencere, "Önce tamamladiginiz gorevi secin.");
                }
            }
        });

        pencere.add(pan);
        pencere.add(toDoList);
        pencere.add(butonekle);
        pencere.add(tamamla);
        pencere.setLayout(null);
        pencere.setVisible(true);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
