/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
/**
 *
 * @author Admin
 */
public interface HoaDonService {
    
    public List<HoaDon> getDSHoaDon() throws SQLException;
    
    public int themHoaDon(HoaDon hd) throws SQLException;
    
    public HoaDon timHoaDonTheoMa(String maHD) throws SQLException;
    
    public List<HoaDon> timHoaDonTheoTenKH(String tenKH) throws SQLException;
    
    public List<HoaDon> timHoaDonTheoSDT (String SDT) throws SQLException;
    
    
}
