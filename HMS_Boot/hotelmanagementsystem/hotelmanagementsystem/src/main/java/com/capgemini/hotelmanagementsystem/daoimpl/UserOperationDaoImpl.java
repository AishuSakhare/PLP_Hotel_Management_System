package com.capgemini.hotelmanagementsystem.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.bean.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.dao.UserOperationDao;

@Repository
public class UserOperationDaoImpl implements UserOperationDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

		@Override
	public HotelInformationBean hotelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomInformationBean roomList(String licenceNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean) {
		// TODO Auto-generated method stub
		return null;
	}
}// end of class
