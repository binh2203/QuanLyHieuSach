package gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pnl_TimKiemSanPham extends javax.swing.JPanel{
   

    public Pnl_TimKiemSanPham() {
        JLabel lbl = new JLabel("Tìm kiếm Sản phẩm");
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 100));
        this.add(lbl);
    }

}
