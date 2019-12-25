package com.capgemini.hotelmanagementsystem.serviceimpl;

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
	public HotelInformationBean hotelList() {
		return userOperationDao.hotelList();
	}

	@Override
	public RoomInformationBean roomList(String licenceNumber) {
		return userOperationDao.roomList(licenceNumber);
	}

	@Override
	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean) {
		return userOperationDao.bookRoomUser(bookingInformationBean);
	}

}
