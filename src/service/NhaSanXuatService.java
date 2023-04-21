package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.NhaSanXuat;

public interface NhaSanXuatService {
	public ArrayList<NhaSanXuat> getListNhaSanXuat() throws Exception;

	public boolean themNhaSanXuat(NhaSanXuat x) throws Exception;

	public boolean xoaNhaSanXuat(String maNhaSanXuat);

	public List<NhaSanXuat> getNhaSanXuat(String maNhaSanXuat);

	public NhaSanXuat timNhaSanXuat(String maNhaSanXuat) throws SQLException;
}
