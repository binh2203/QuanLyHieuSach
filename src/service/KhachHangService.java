/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.KhachHang;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public interface KhachHangService {
    
    public int themKhachHang(KhachHang kh) throws SQLException ;
    
    public List<KhachHang> getDSKhachHang() throws SQLException;
    
    public KhachHang timKhachHangTheoMa(String maKH) throws SQLException;
    
    public ArrayList<KhachHang> timKhachHangTheoTen(String tenKH) throws SQLException;
    
    public ArrayList<KhachHang> timKhachHangTheoSDT(String sDT) throws SQLException;
    
    public ArrayList<KhachHang> getListKhachHangByNameAndSDT(String tenKH, String sdt);
    
    public KhachHang getKhachHangEmail(String email);
    
    public int capNhatKhachHang(KhachHang kh) ;
    
    public int xoaKhachHang(String maKH);
    
    public KhachHang getKhachHangTheoSDT(String sDT) throws SQLException;
    
    //Lĩnh
	public List<KhachHang> getTop10KHThanThiet(LocalDate ngayBatDau, LocalDate ngayKetThuc);
	public double getTongTienCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
			throws SQLException;
	public int getSoLuongHoaDonCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
			throws SQLException;
	public List<KhachHang> getKhachHangMuaNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc);
	public double getTongTienCuaKhachHangTop1(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException;
    public KhachHang timKhachHangTheoMaLinh(String maKH) throws SQLException;
}
