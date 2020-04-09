
package pkg123180125_kuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkg123180125_kuis.LihatData;


public class Form extends JFrame {
    JLabel lnim,lnama,lmatkul1,lnilai1,lmatkul2,lnilai2 ;
    JTextField txnim,txnama,txmatkul1,txnilai1,txmatkul2,txnilai2;
    JButton convert;
    Statement statement;
    
    public void tesForm (){
        
        setTitle("From Penghitungan Nilai");
        
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");        
        lmatkul1 = new JLabel("Mata Kuliah 1");
        lnilai1 = new JLabel("Nilai 1");
        lmatkul2 = new JLabel("Mata Kuliah 2");
        lnilai2 = new JLabel("Nilai 2");
        txnim = new JTextField("");
        txnama = new JTextField("");
        txmatkul1 = new JTextField("");
        txnilai1 = new JTextField("");
        txmatkul2 = new JTextField("");
        txnilai2 = new JTextField("");
        convert = new JButton("Convert");
        
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lmatkul1);
        add(lnilai1);
        add(lmatkul2);
        add(lnilai2);
        add(txnim);
        add(txnama);
        add(txmatkul1);
        add(txnilai1);
        add(txmatkul2);
        add(txnilai2);
        add(convert);
        
        lnim.setBounds(75, 50, 30, 20);
        lnama.setBounds(75, 75, 50, 20);
        lmatkul1.setBounds(75, 100, 100, 20);
        lnilai1.setBounds(75, 125, 50, 20);
        lmatkul2.setBounds(75, 150, 100, 20);
        lnilai2.setBounds(75, 175, 50, 20);
        txnim.setBounds(175, 50, 150, 20);
        txnama.setBounds(175, 75, 150, 20);
        txmatkul1.setBounds(175, 100, 150, 20);
        txnilai1.setBounds(175, 125, 150, 20);
        txmatkul2.setBounds(175, 150, 150, 20);
        txnilai2.setBounds(175, 175, 150, 20);
        convert.setBounds(200, 250, 90, 20);
        
        
        setSize(400,350); //luas jendela
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        convert.addActionListener(new ActionListener() {
     
            private int rata;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                int a1 =  Integer.parseInt(txnim.getText());
                String a2 = txnama.getText();
                String a3 = txmatkul1.getText();
                int a4 = Integer.parseInt(txnilai1.getText());
                String a5 = txmatkul2.getText();
                int a6 = Integer.parseInt(txnilai2.getText());
                float rata=(float)(a4+a6)/2;  //menghitung rata-rata nilai
                String huruf = KonversiNilaiKeHuruf(rata);
                
                KoneksiDB koneksi = new KoneksiDB();
                    try {
                        statement= koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("INSERT INTO data_mhs VALUES ('" 
                                + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','"+ a6 + "','"+ rata + "','"+ huruf +"')"); //memasukan data ke database
                        JOptionPane.showMessageDialog(rootPane, "data tersimpan"); //menampilmessage dialog pada gui
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                System.out.println("NIM           : "+a1); //mengoutputkan data
                System.out.println("Nama          : "+a2);
                System.out.println("Mata kuliah 1 : "+a3);
                System.out.println("Nilai 1       : "+a4);
                System.out.println("Mata kuliah 2 : "+a5);
                System.out.println("Nilai 2       : "+a6);
                System.out.println("Rata-rata     : "+rata);   
                System.out.println("Nilai Huruf   : "+huruf);   
                } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH"); //menampilmessage dialog pada gui
                } catch (Error ext){
                 JOptionPane.showMessageDialog(rootPane,"SALAH"); //menampilmessage dialog pada gui
                }
                
            }
           private String KonversiNilaiKeHuruf(float rata) { //untuk mengkonversi nilai angka ke huruf
                
                if ( rata >= 80 && rata <=100) 
                    return  "A";
                else if (rata >=75 && rata <80)
                    return "B+";
                else if (rata >=65 && rata <75)
                    return "B";
                else if (rata >=60 && rata <65)
                    return "C+";
                else if (rata >=50 && rata <60)
                    return "C";
                else if (rata >=20 && rata <50)
                    return "D";
                else if (rata >=0 && rata <20)
                    return "E";
                else
                    return "error";
            }
        });
        
    }
}
