/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_impl;

import entity.KhachHang;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.KhachHangDao;
import service.KhachHangService;

/**
 *
 * @author Student
 */
public class KhachHangServiceImpl implements KhachHangService{
	private KhachHangDao KhachHang = new KhachHangDao();
    @Override
    public int themKhachHang(KhachHang kh) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KhachHang> getDSKhachHang() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KhachHang timKhachHangTheoMa(String maKH) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<KhachHang> timKhachHangTheoTen(String tenKH) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<KhachHang> timKhachHangTheoSDT(String sDT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<KhachHang> getListKhachHangByNameAndSDT(String tenKH, String sdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KhachHang getKhachHangEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int capNhatKhachHang(KhachHang kh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int xoaKhachHang(String maKH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public KhachHang getKhachHangTheoSDT(String sDT) throws SQLException{
    	return KhachHang.getKhachHangTheoSDT(sDT);
    }
}
