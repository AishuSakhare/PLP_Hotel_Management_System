package com.capgemini.hotelmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.AdminOperationDao;
import com.capgemini.hotelmanagementsystem.dao.UserOperationDao;
import com.capgemini.hotelmanagementsystem.service.UserOperationService;

@Service
public class UserOperationServiceImpl implements UserOperationService {

	@Autowired
	private UserOperationDao userOperationDao;

	@Override
	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean) {
		return userOperationDao.roomList(hotelInformationBean);
	}

	@Override
	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean) {
		return userOperationDao.bookRoomUser(bookingInformationBean);
	}

	@Override
	public double calculateTotalDaysAmount(BookingInformationBean bookingInformationBean) {
		return userOperationDao.calculateTotalDaysAmount(bookingInformationBean);
	}

	@Override
	public int updateRoomCount(int roomId) {
		return userOperationDao.updateRoomCount(roomId);
	}

	@Override
	public String updateRoomStatus(int roomId) {
		return userOperationDao.updateRoomStatus(roomId);
	}

}
