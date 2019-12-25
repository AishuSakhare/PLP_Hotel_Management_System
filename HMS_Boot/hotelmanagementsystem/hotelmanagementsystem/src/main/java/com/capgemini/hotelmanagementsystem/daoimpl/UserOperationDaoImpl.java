package com.capgemini.hotelmanagementsystem.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.bean.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.dao.UserOperationDao;

@Repository
public class UserOperationDaoImpl implements UserOperationDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<RoomInformationBean> roomlList = null;
		try {

			String jpql = "from RoomInformationBean where licenceNumber=:licenceNumber";
			Query query = entityManager.createQuery(jpql);
			String licenceNumber = hotelInformationBean.getLicenceNumber();
			query.setParameter("licenceNumber", licenceNumber);

			roomlList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong... room list not found");
		}
		return roomlList;

	}

	@Override
	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean) {
		System.out.println("........bean book inside impl...." + bookingInformationBean);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(bookingInformationBean);
			transaction.commit();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong...cant book room now");
		}
		return bookingInformationBean;
	}
}// end of class
