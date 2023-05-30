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
public class HoaDonServiceImpl implements HoaDonService{
    HoaDonDao hoaDonDao = new HoaDonDao();

    @Override
    public List<HoaDon> getDSHoaDon() throws SQLException {
    	return hoaDonDao.getDSHoaDon();
    }


	@Override
	public List<HoaDon> timDsHoaDon(HoaDon hd) throws SQLException {
		// TODO Auto-generated method stub
		return hoaDonDao.timDsHoaDon(hd);
	}


	@Override
	public int TaoHD(HoaDon hd) throws SQLException {
		// TODO Auto-generated method stub
		return hoaDonDao.TaoHD(hd);
	}

    
}
