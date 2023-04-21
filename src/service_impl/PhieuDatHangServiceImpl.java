package service_impl;

import java.sql.SQLException;
import java.util.List;

import dao.PhieuDatHangDao;
import entity.PhieuDatHang;

public class PhieuDatHangServiceImpl {
	PhieuDatHangDao phieuDatHangDao = new PhieuDatHangDao();
	
	public List<PhieuDatHang> getDSPhieuDatHang() throws SQLException{
		return phieuDatHangDao.getDSPhieuDatHang();
	}
	public List<PhieuDatHang> timDSPhieuDatHang(PhieuDatHang pdh) throws SQLException{
		return phieuDatHangDao.timDSPhieuDatHang(pdh);
	}
}
