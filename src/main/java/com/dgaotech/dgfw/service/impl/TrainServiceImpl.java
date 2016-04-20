/**
 * 
 */
package com.dgaotech.dgfw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgaotech.dgfw.dao.TrainDAO;
import com.dgaotech.dgfw.entity.Train;
import com.dgaotech.dgfw.service.ITrainService;


/**
 * @author Roy
 *
 */
@Service
@Transactional
public class TrainServiceImpl implements ITrainService {

	@Autowired
	private TrainDAO trainDao;

	@Override
	public Train selectByNo(Train train) {

		return trainDao.selectByNo(train);
	}

	@Override
	public Train isStartTrain(Train train) {

		return trainDao.isStartTrain(train);
	}

	@Override
	public Train findInitialTrain(Train train) {

		return trainDao.findInitialTrain(train);
	}

}
