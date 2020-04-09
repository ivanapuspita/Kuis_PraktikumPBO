package pkg123180125_kuis;


import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class LihatData extends JFrame {
    String [][] data = new String [500][8]; //ukuran baris dan kolom
    String[] kolom = {"nim","nama","matkul 1","nilai 1","matkul 2","nilai 2","rata-rata","nilai huruf"}; //membuat nama pada tabel
    JTable tabel;
    JScrollPane scrollpane;
    Statement statement;
    ResultSet resultSet;
    
    public void LihatData(){
        setTitle("Data Mahasiswa");
        try{
            KoneksiDB koneksi = new KoneksiDB();
            Statement statement = koneksi.getKoneksi().createStatement();
            
            String sql= "SELECT *from data_mhs"; //query untuk menampilkan data
            resultSet = statement.executeQuery(sql);
            
            int p=0;
            while(resultSet.next()){
                data[p][0]=resultSet.getString("nim");
                data[p][1]=resultSet.getString("nama");
                data[p][2]=resultSet.getString("matkul1");
                data[p][3]=resultSet.getString("nilai1");
                data[p][4]=resultSet.getString("matkul2");
                data[p][5]=resultSet.getString("nilai2");
                data[p][6]=resultSet.getString("rata");
                data[p][7]=resultSet.getString("huruf");
                p++;
            }
            statement.close();
            koneksi.getKoneksi().close();
        } catch (SQLException sqle){
            JOptionPane.showMessageDialog(rootPane, "data gagal ditampilkan" + sqle);
        } catch (ClassNotFoundException classe){
            JOptionPane.showMessageDialog(rootPane, "data tidak ditemukan" + classe);
        }
        tabel=new JTable(data, kolom); //membuat table
        JScrollPane scrollPane = new JScrollPane(tabel);
        
        setLayout(new FlowLayout());
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
