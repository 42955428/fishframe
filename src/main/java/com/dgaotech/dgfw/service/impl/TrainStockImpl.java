package com.dgaotech.dgfw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaotech.dgfw.dao.TrainStockDAO;
import com.dgaotech.dgfw.entity.TrainStock;
import com.dgaotech.dgfw.service.ITrainStockService;
@Service
public class TrainStockImpl implements ITrainStockService{
	
	@Autowired
	private TrainStockDAO trainStockDao;

	@Override
	public int isAssignedForTrain(TrainStock trainStock) {
		// TODO Auto-generated method stub
		return trainStockDao.isAssignedForTrain(trainStock);
	}
	

}
