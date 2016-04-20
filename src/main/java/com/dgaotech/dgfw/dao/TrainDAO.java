package com.dgaotech.dgfw.dao;

import java.util.List;


import com.dgaotech.dgfw.entity.Train;

@MyBatisRepository
public interface TrainDAO {
	Train findInitialTrainLineNo(Train train);
	/**
	 * 根据输入车次no查找当前回路的始发列车;
	 * @param train's trainNo.
	 * @return
	 */
	
	/**
	 * 根据输入车次no查找当前回路的始发列车;
	 * @param train
	 * @return
	 */
	Train findInitialTrain(Train train);
	/**
	 * 
	 * @return
	 */
	List<Train> loadAllTrainForSelect();

	/**
	 * 根据回路编号找回所有列车;
	 * @param train
	 * @return
	 */
	List<Train> findTrainByLineNo(Train train);

	/**
	 * 是否始发列车;
	 * @param train
	 * @return
	 */
	Train isStartTrain(Train train);

	/**
	 * 删除
	 * @param train
	 * @return
	 */
	int deleteByPrimaryKey(Train train);

    int insert(Train record);

    Train selectByPrimaryKey(Train train);
    
    Train selectByNo(Train train);

    int updateByPrimaryKey(Train train);
    
    String findMaxId();
    
    int loadCount(Train train);
    /**
     * Load all menus for maintenance.
     * @param condition
     * @return
     */
    List<Train> loadAll();
    /**
     * Load all menus by page mode.
     * @param condition
     * @return
     */
    List<Train> loadByPage(Train train);

}
