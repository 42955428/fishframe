package com.dgaotech.dgfw.controller;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgaotech.base.util.Constants;
import com.dgaotech.base.util.ServiceConstants;
import com.dgaotech.base.util.StringUtil;
import com.dgaotech.dgfw.entity.Role;
import com.dgaotech.dgfw.entity.Train;
import com.dgaotech.dgfw.entity.TrainStock;
import com.dgaotech.dgfw.entity.User;
import com.dgaotech.dgfw.service.ITrainService;
import com.dgaotech.dgfw.service.ITrainStockService;
import com.dgaotech.dgfw.service.IUserService;


@Controller
@RequestMapping("/")
public class IndexController extends BaseActionController{
	

	@Autowired
	private IUserService userService;
		
	@Autowired
	private ITrainService trainService;
	
	@Autowired
	private ITrainStockService trainStockService;
	
	@RequestMapping("/index")
	public String list(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		User currentUser = (User)request.getSession().getAttribute(Constants.LOING_MEMBER_SESSION);
		
			//获取分红总数
			Map map = new HashMap();
			map.put("regCode", currentUser.getUserId());
								
			modelMap.addAttribute("member", currentUser);
			return "/index";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String loginOut(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){			
		request.getSession().getServletContext().removeAttribute(Constants.LOING_MEMBER_SESSION);
		request.getSession().getServletContext().removeAttribute("goalSession");	
		return"/login";
	}
	
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(HttpServletRequest request, 
			HttpServletResponse response,ModelMap modelMap){
		
		return "/login";
	}
	
	
	@RequestMapping(value="/loginmodel",method = RequestMethod.GET)
	public String loginmodel(HttpServletRequest request, 
			HttpServletResponse response,ModelMap modelMap){
		return "/loginmodel";
	}
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String trainNo = request.getParameter("trainNo");
		//判断验证码
		String authImg="";
		try {
			authImg=request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY).toString();
		} catch (Exception e) {
			modelMap.put("errMsg", "验证码输入错误");
			return "/login";
		}
		if(!authImg.equals(request.getParameter("registration_code"))){
			modelMap.put("errMsg", "验证码输入错误");		
			return "/login";
		}
		
		User user = userService.getUserByCode(username);		
		
		if(user==null){		
			modelMap.put("errMsg", "没有找到该用户");
			return "/login";
		}else{
			//开始验证密码
			if(user.getLoginPwd()==null||!user.getLoginPwd().equals(password)){
				modelMap.put("errMsg","密码错误");
				return "/login";
			}else{
		
			List<Role> roleResult = userService.findUserRole(user);	
			if (null == roleResult) {
				modelMap.put("errMsg", "你所登录的用户尚未配置权限信息，请联系管理员！");
				return "/login";
			}
			if (roleResult.size() > 1) {
				modelMap.put("errMsg","您所登录的用户目前配置超过一个角色，请联系管理员重新配置");	
				return "/login";
			}
			//获取用户权限，判断是否需要输入车次	
			user.setTrainNo(trainNo);
			Role role = roleResult.get(0);
			if (role.getRoleId().equals(ServiceConstants.ROLE_TYPE_CWZ)){
				if (null == user.getTrainNo() || StringUtil.isEmpty(user.getTrainNo())) {
					modelMap.put("errMsg","您当前是餐务长，必须输入您当前车次的始发车次！");
					return "/login";
				}
				
				//判断车次是否存在
				Train train = new Train();
				train.setTrainNo(user.getTrainNo().toUpperCase());
				train = trainService.selectByNo(train);
				if (null == train) {
					modelMap.put("errMsg","当前列车车次不存在!");
					return "/login";
				}
				// 1) 验证是否始发车次；
				Train isStartTrain = trainService.isStartTrain(train);
	
				Train initialTrain = trainService.findInitialTrain(train);
				if (null == isStartTrain || isStartTrain.getIsStartFlag() != 1) {
					modelMap.put("errMsg","您输入的列车车次不是该回路的始发车次,输入的" + train.getTrainNo()
							+ "次列车的回路始发车次是" + initialTrain.getTrainNo());
					return "/login";
				}			
				TrainStock trainStock = new TrainStock();
				trainStock.setTrainNo(initialTrain.getTrainNo());
				trainStock.setMealsGrpLeadId(user.getUserId());
				int assignCount = trainStockService.isAssignedForTrain(trainStock);
				if (assignCount == 0) {
					modelMap.put("errMsg","您输入的列车车次(" + train.getTrainNo()	+ ")没有配货，不能登录，请联系结算员先行配货。");
					return "/login";
				}	
			}else if (role.getRoleId().equals(ServiceConstants.ROLE_TYPE_ADMIN)){
				System.out.println("admin用户登录");
			}
			else if (role.getRoleId().equals(ServiceConstants.ROLE_TYPE_JSY)){
				System.out.println("jsy用户登录");
			}
				//保存全局变量
				Hashtable hashTable = (Hashtable)request.getSession().getServletContext().getAttribute("goalSession");
				if(hashTable==null){
					hashTable = new Hashtable();
					request.getSession().getServletContext().setAttribute("goalSession", hashTable);
				}else{
					HttpSession session = (HttpSession)hashTable.get(user.getLoginName());
					
					if(session!=null){

						try{
							session.invalidate();
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}				
					}
					hashTable.remove(user.getLoginName());
				}		
				//验证成功了
				request.getSession().setAttribute(com.dgaotech.base.util.Constants.LOING_MEMBER_SESSION, user);
				hashTable.put(user.getLoginName(),request.getSession());
				return "redirect:/index.shtml";
				
			}
			
		}
		
	}
	
}
