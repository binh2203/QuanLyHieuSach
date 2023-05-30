/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.KhachHang;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public interface KhachHangService {
    
    public int themKhachHang(KhachHang kh) throws SQLException ;
    
    public List<KhachHang> getDSKhachHang() throws SQLException;
    
    public List<KhachHang> timDSKH(KhachHang kh) throws SQLException; 
    
    public int capNhatKhachHang(KhachHang kh) ;
    
    public int xoaKhachHang(String maKH);
    
    public KhachHang getKhachHangTheoMa(String maKH) throws SQLException ;
    
    public KhachHang getKhachHangTheoSDT(String sDT) throws SQLException;
}
