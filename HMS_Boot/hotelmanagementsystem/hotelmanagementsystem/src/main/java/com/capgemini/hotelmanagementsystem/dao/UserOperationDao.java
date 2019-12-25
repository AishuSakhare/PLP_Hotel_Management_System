package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.service.AdminOperationService;

public interface UserOperationDao {

	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean);

	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean);

}// end of interface
