package com.dgaotech.dgfw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgaotech.base.persistence.page.Page;
import com.dgaotech.dgfw.entity.Product;
import com.dgaotech.dgfw.entity.TrainStock;

@MyBatisRepository
public interface TrainStockDAO {
	/**
	 * delete one record of inventory via MealXXXChargerId,ProductCode,TrainNo,trainSubNo
	 * @param record
	 * @return
	 */
    int delete(TrainStock record);

    /**
     * Insert one stock record.
     * @param record
     * @return
     */
    int insert(TrainStock record);

    /**
     * Get all assigned inventory by PK.(trainNo和参悟张Id),即取得当前配货之后的这趟车上的商品库存信息.
     * @param record
     * @return
     */
    List<TrainStock> select(TrainStock record);
    /**
     * Get stock record by MealXXXChargerId,ProductCode,TrainNo,trainSubNo
     * @param record
     * @return
     */
    TrainStock findProductsInStock(TrainStock record);

    /**
     * update one record's inventory quantity by MealXXXChargerId,ProductCode,TrainNo
     * @param record
     * @return
     */
    int updateStockNum(TrainStock record);
    /**
     * 判断当前车次（trainNo和参悟张Id）是否有配货;
     * @param train
     * @return
     */
    int isAssignedForTrain(TrainStock record);
    /**
     * Get all products for particular train.
     * @param condition
     * @return
     */
    List<Product> findProductByCategory(TrainStock condition);
    
    
    //get all assigned products from train_stock table
    Page loadProductFromTrainStock(Map m); 
    //update train stock product isSale
    int updateStockIsSale(TrainStock record);


}
