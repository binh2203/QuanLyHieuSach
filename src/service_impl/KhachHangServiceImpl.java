/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_impl;

import entity.KhachHang;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.KhachHangDao;
import service.KhachHangService;
import dao.ThongKeDao;
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
    //Lĩnh:
    ThongKeDao thongKeDao = new ThongKeDao();
	@Override
	public List<entity.KhachHang> getTop10KHThanThiet(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return thongKeDao.getTop10KHThanThiet(ngayBatDau, ngayKetThuc);
	}

	@Override
	public double getTongTienCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
			throws SQLException {
		// TODO Auto-generated method stub
		return thongKeDao.getTongTienCuaKhachHangTheoMa(ngayBatDau, ngayKetThuc, maKH);
	}

	@Override
	public int getSoLuongHoaDonCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
			throws SQLException {
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongHoaDonCuaKhachHangTheoMa(ngayBatDau, ngayKetThuc, maKH);
	}

	@Override
	public List<entity.KhachHang> getKhachHangMuaNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return thongKeDao.getKhachHangMuaNhieuNhatTheoNgayTuChon(ngayBatDau, ngayKetThuc);
	}

	@Override
	public double getTongTienCuaKhachHangTop1(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		// TODO Auto-generated method stub
		return thongKeDao.getTongTienCuaKhachHangTop1(ngayBatDau, ngayKetThuc);
	}

	@Override
	public entity.KhachHang timKhachHangTheoMaLinh(String maKH) throws SQLException {
		// TODO Auto-generated method stub
		return KhachHang.timKhachHangTheoMa(maKH);
	}
	
	
}
