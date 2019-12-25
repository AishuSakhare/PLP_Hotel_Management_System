package com.capgemini.hotelmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.dao.AdminOperationDao;
import com.capgemini.hotelmanagementsystem.service.AdminOperationService;
import com.capgemini.hotelmanagementsystem.validation.HotelValidationDaoImpl;
import com.capgemini.hotelmanagementsystem.validation.UserValidationDaoImpl;

@Service
public class AdminOperationServiceImpl implements AdminOperationService {

	@Autowired
	private AdminOperationDao adminOperationsDao;

	UserValidationDaoImpl userValidation = new UserValidationDaoImpl();
	HotelValidationDaoImpl hotelValidation = new HotelValidationDaoImpl();

	@Override
	public HotelInformationBean addHotel(HotelInformationBean hotelBean) {
//		if (hotelValidation.licenseValidation(hotelBean.getLicenceNumber())) {
//			return adminOperationsDao.addHotel(hotelBean);
//		} else {
//			return null;
//		}
		return adminOperationsDao.addHotel(hotelBean);
	}

	@Override
	public List<HotelInformationBean> getHotelList() {
		return adminOperationsDao.getHotelList();
	}

	@Override
	public boolean updateHotelInformation(HotelInformationBean hotelBean) {
		if (hotelValidation.licenseValidation(hotelBean.getLicenceNumber())
				&& hotelValidation.contactNumberValidation(hotelBean.getHotelContactNumber())) {
			return adminOperationsDao.updateHotelInformation(hotelBean);
		}
		return false;
	}

	@Override
	public boolean deleteHotelInformation(int hotelId) {
		return adminOperationsDao.deleteHotelInformation(hotelId);
	}

	@Override
	public RoomInformationBean addRoom(RoomInformationBean roomBean) {
		return adminOperationsDao.addRoom(roomBean);
	}

	@Override
	public boolean deleteRoomInformation(int roomId) {
		return adminOperationsDao.deleteRoomInformation(roomId);
	}

	@Override
	public List<RoomInformationBean> getRoomList() {
		return adminOperationsDao.getRoomList();
	}

	@Override
	public boolean updateRoomInformation(RoomInformationBean roomBean) {
		if (hotelValidation.licenseValidation(roomBean.getLicenceNumber())) {
			return adminOperationsDao.updateRoomInformation(roomBean);
		}
		return false;
	}

	@Override
	public EmployeeInformationBean addEmployee(EmployeeInformationBean employeeBean) {
		if (userValidation.nameValidation(employeeBean.getName())
				&& userValidation.emailValidation(employeeBean.getEmail())
				&& userValidation.passwordValidation(employeeBean.getPassword())) {
			return adminOperationsDao.addEmployee(employeeBean);
		}
		return null;
	}

	@Override
	public List<EmployeeInformationBean> getEmployeeList() {
		return adminOperationsDao.getEmployeeList();
	}

	@Override
	public boolean deleteEmployeeInformation(int employeeId) {
		return adminOperationsDao.deleteEmployeeInformation(employeeId);
	}

	@Override
	public boolean updateEmployeeInformation(EmployeeInformationBean employeeBean) {
		if (userValidation.nameValidation(employeeBean.getName())
				&& userValidation.emailValidation(employeeBean.getEmail())
				&& userValidation.passwordValidation(employeeBean.getPassword())) {
			return adminOperationsDao.updateEmployeeInformation(employeeBean);
		}
		return false;
	}

	@Override
	public boolean licenseNumberPresent(String licenseNumber) {
		
		return adminOperationsDao.licenseNumberPresent(licenseNumber);
	}
}// end of class
