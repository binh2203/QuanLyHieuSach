/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.HoaDonDao;
import dao.SanPhamDao;
import entity.HoaDon;
import service.HoaDonService;



/**
 *
 * @author Admin
 */
public class HoaDonServicelmpl implements HoaDonService{
    HoaDonDao hoaDonDao = new HoaDonDao();

    @Override
    public List<HoaDon> getDSHoaDon() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int themHoaDon(HoaDon hd) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDon timHoaDonTheoMa(String maHD) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> timHoaDonTheoTenKH(String tenKH) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
////    public int xoaHoaDon(String maHD) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
////    }

	@Override
	public List<HoaDon> timHoaDonTheoSDT(String SDT) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDoanhThuTheoMaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSoLuongHoaDonTheoMaNV(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSoLuongHoaDon(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
}
