package Home;

import Enkripsi.Alay;
import Enkripsi.Cecar;
import Enkripsi.iostream;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;
    JLabel lblHead;
    JTextArea txtArea1;
    JTextArea txtArea2;
    JButton btnOpen;
    JButton btnSimpan;
    JButton btnGOALAY;
    JButton btnWrap;
    JButton btnClear;
    JRadioButton rdAlay;
    JRadioButton rdCecar;
    JRadioButton rdNormal;
    ButtonGroup rdGroup = new ButtonGroup();
    JFrame frame = new JFrame("");
    String bantu = "";
    Alay al;//edit
    Cecar c;//edit

    public View() {
        al = new Alay();//edit
        c = new Cecar();//edit
        setTitle("Program nge-ALAY");
        setSize(385, 510);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);

        addComponent();
    }

    public void addComponent() {
        this.lblHead = new JLabel("::ALAY&RAHASIA2AN yuk::");
        this.lblHead.setFont(new Font("Courier New", 1, 20));
        this.lblHead.setBounds(40, 0, 300, 60);
        add(this.lblHead);

        this.txtArea1 = new JTextArea("");
        this.txtArea1.setBounds(40, 60, 300, 145);
        add(this.txtArea1);
        this.txtArea2 = new JTextArea("");
        this.txtArea2.setBounds(40, 210, 300, 145);
        this.txtArea2.setEnabled(false);
        add(this.txtArea2);

        this.btnOpen = new JButton("Open");
        this.btnOpen.setBounds(40, 370, 80, 35);
        this.btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iostream io = new iostream();

                JFileChooser chooser = new JFileChooser();
                int load = chooser.showOpenDialog(View.this.frame);
                if (load != 0) {
                    return;
                }
                File outFile = chooser.getSelectedFile();
                io.readfile(outFile.getPath());
                View.this.txtArea1.setText(io.tampung);
            }
        });
        add(this.btnOpen);
        this.btnSimpan = new JButton("Save");
        this.btnSimpan.setBounds(130, 370, 80, 35);
        this.btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iostream io = new iostream();

                JFileChooser chooser = new JFileChooser();
                int load = chooser.showSaveDialog(View.this.frame);
                if (load != 0) {
                    return;
                }
                File outFile = chooser.getSelectedFile();
                io.writefile(View.this.txtArea2.getText(), outFile.getPath());
            }
        });
        add(this.btnSimpan);
        this.btnWrap = new JButton("Wrap");
        this.btnWrap.setBounds(40, 410, 80, 35);
        this.btnWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.this.txtArea1.setLineWrap(true);
                View.this.txtArea2.setLineWrap(true);
            }
        });
        add(this.btnWrap);

        this.btnClear = new JButton("Clear");
        this.btnClear.setBounds(130, 410, 80, 35);
        this.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.this.txtArea1.setText("");
                View.this.txtArea2.setText("");
                View.this.txtArea1.setLineWrap(false);
                View.this.txtArea2.setLineWrap(false);
                View.this.txtArea2.setEnabled(false);
                View.this.rdGroup.clearSelection();
            }
        });
        add(this.btnClear);

        this.rdAlay = new JRadioButton("Alay");
        this.rdAlay.setBounds(220, 370, 60, 35);
        add(this.rdAlay);
        this.rdCecar = new JRadioButton("Cecar");
        this.rdCecar.setBounds(280, 370, 80, 35);
        add(this.rdCecar);
        this.rdNormal = new JRadioButton("Normal");
        this.rdNormal.setBounds(245, 400, 80, 35);
        add(this.rdNormal);
        this.rdGroup.add(this.rdNormal);
        this.rdGroup.add(this.rdAlay);
        this.rdGroup.add(this.rdCecar);
        this.btnGOALAY = new JButton("PROSES");
        this.btnGOALAY.setBounds(220, 440, 90, 35);
        this.btnGOALAY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enkrip;
                String awal = txtArea1.getText();
                String rubah;
                if (View.this.rdAlay.isSelected()) {
                    txtArea2.setEnabled(true);
                    txtArea2.setEditable(false);
                    enkrip = al.enkripsi(awal);//edit
                    txtArea2.setText(al.enkripsi(View.this.txtArea1.getText(), enkrip));//edit
                } else if (View.this.rdCecar.isSelected()) {
                    View.this.txtArea2.setEnabled(true);
                    View.this.txtArea2.setEditable(false);
                    enkrip = c.enkripsi(View.this.txtArea1.getText());//edit
                    View.this.txtArea2.setText(c.enkripsi(View.this.txtArea1.getText(), enkrip));//edit
                } else if (View.this.rdNormal.isSelected()) {
                    View.this.txtArea2.setEnabled(true);
                    View.this.txtArea2.setEditable(false);
                    View.this.txtArea2.setText(View.this.txtArea1.getText());
                }
            }
        });
        add(this.btnGOALAY);
        setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View v = new View();
                v.setVisible(true);
            }
        });
    }
}