package service_impl;

import java.sql.SQLException;
import java.util.List;

import entity.ChiTietHoaDon;
import dao.CTHoaDonDao;
import service.ChiTietHoaDonService;

public class CTHDServiceImpl implements ChiTietHoaDonService{
	CTHoaDonDao ctHoaDonDao = new CTHoaDonDao();


	@Override
	public int TaoCTHD(ChiTietHoaDon cthd) throws SQLException {
		// TODO Auto-generated method stub
		return ctHoaDonDao.TaoCTHD(cthd);
	}


	@Override
	public void ChiTietHoaDon() {
		// TODO Auto-generated method stub
		
	}
	
}
