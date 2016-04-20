/**
 * 
 */
package com.dgaotech.dgfw.service;
import com.dgaotech.dgfw.entity.Train;

/**
 * @author Roy
 *
 */
public interface ITrainService {
	
	
	Train selectByNo(Train train);
	
	Train isStartTrain(Train train);
	
	Train findInitialTrain(Train train);
	
}
