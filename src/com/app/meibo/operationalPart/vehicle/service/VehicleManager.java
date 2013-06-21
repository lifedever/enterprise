package com.app.meibo.operationalPart.vehicle.service;

import org.springframework.stereotype.Service;

import com.app.meibo.operationalPart.vehicle.model.Vehicle;
import com.sqds.hibernate.HibernateDao;

/**
 * 车辆管理
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-21 下午10:39:53
 */
@Service
public class VehicleManager extends HibernateDao<Vehicle> {

}
