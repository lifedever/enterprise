package com.app.meibo.human.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.human.model.Position;
import com.sqds.hibernate.HibernateDao;

@Service
public class PositionManager extends HibernateDao<Position> {

	public List<Position> listPosition() {
		return list("from Position p order by p.positionNo asc");
	}

}
