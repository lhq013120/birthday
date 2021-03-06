package com.hm.birthday.master.blessing.service;

import java.util.List;

import com.hm.birthday.entity.BirthBlessing;
import com.hm.birthday.master.blessing.vo.BlessingLimitVo;
import com.hm.birthday.master.blessing.vo.BlessingVo;

/**
 * 
 * 生日祝福服务类接口
 * 
 * @author hanyd
 *
 */
public interface IBirthBlessingService {
	
	/**
	 * 给寿星添加祝福
	 * 
	 * @param blessing
	 * @return
	 */
	public int addBlessing(BirthBlessing blessing) throws Exception;
	
	/**
	 * 获取所有寿星的最新的两条留言
	 * 
	 * @param blessing
	 * @return
	 */
	public List<BlessingLimitVo> newBlessing() throws Exception;
	
	/**
	 * 获取寿星当年的所以留言祝福
	 * 
	 * @param birthPerson 寿星用户名
	 * @return 
	 */
	public List<BlessingVo> allBlessing(String birthPersonPnum) throws Exception;
	
}
