package com.dgaotech.dgfw.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseVO implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 2898458106583170838L;
	
	private String userId;
	private String loginName;
	private String loginPwd;
	private String userName;
	private int isActive = 1;
	private String mobile;
	private String bureau;
	private String optId;
	private Timestamp optDate;
	
	private Train train;

	/**
	 * To keep all menus for current user.
	 */
	private List<Menu> userMenu;
	
	public User(){
		
	}
		
	public User(String id,
				String userId, 
			    String loginName, 
			    String loginPwd,
			    String userName,
			    int isActive,
			    String mobile,
			    String bureau,
			    String optId,
			    Timestamp optDate) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.userName = userName;
		this.isActive = isActive;
		this.mobile =  mobile;
		this.bureau = bureau;
		this.optId = optId;
		this.optDate = optDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public String getOptId() {
		return optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	public Timestamp getOptDate() {
		return optDate;
	}

	public void setOptDate(Timestamp optDate) {
		this.optDate = optDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userMenu
	 */
	public List<Menu> getUserMenu() {
		return userMenu;
	}
	


	/**
	 * @param userMenu the userMenu to set
	 */
	public void setUserMenu(List<Menu> userMenu) {
		this.userMenu = userMenu;
	}

	/**
	 * @return the train
	 */
	public Train getTrain() {
		return train;
	}

	/**
	 * @param train the train to set
	 */
	public void setTrain(Train train) {
		this.train = train;
	}
	
	
}
