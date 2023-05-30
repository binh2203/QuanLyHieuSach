package service;

import java.sql.SQLException;

import entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	
	public  void ChiTietHoaDon() ;
	
	public int TaoCTHD(ChiTietHoaDon cthd) throws SQLException;
}
