package service_impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.NhaSanXuatDao;
import entity.NhaSanXuat;
import service.NhaSanXuatService;

public class NhaSanXuatServiceImpl implements NhaSanXuatService{
	NhaSanXuatDao nhaSanXuatDao = new NhaSanXuatDao();
	public ArrayList<NhaSanXuat> getListNhaSanXuat() throws Exception {
		// TODO Auto-generated method stub
		return nhaSanXuatDao.getListNhaSanXuat();
	}

	@Override
	public boolean themNhaSanXuat(NhaSanXuat x) throws Exception {
		if(nhaSanXuatDao.kiemTraTonTaiNhaSanXuat(x.getTenNhaSX()))
			return false;
		return nhaSanXuatDao.themNhaSanXuat(x);
	}

	@Override
	public boolean xoaNhaSanXuat(String maNhaSanXuat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NhaSanXuat> getNhaSanXuat(String maNhaSanXuat) {
		// TODO Auto-generated method stub
		return nhaSanXuatDao.getNhaSanXuat(maNhaSanXuat);
	}

	@Override
	public NhaSanXuat timNhaSanXuat(String maNhaSanXuat) throws SQLException {
		// TODO Auto-generated method stub
		return nhaSanXuatDao.timNhaSanXuat(maNhaSanXuat);
	}

}
