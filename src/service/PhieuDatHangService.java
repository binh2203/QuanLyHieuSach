package service;

import java.sql.SQLException;
import java.util.List;

import entity.PhieuDatHang;

public interface PhieuDatHangService {
	public List<PhieuDatHang> getDSPhieuDatHang() throws SQLException;
	
	public List<PhieuDatHang> timDSPhieuDatHang(PhieuDatHang pdh) throws SQLException;
}
