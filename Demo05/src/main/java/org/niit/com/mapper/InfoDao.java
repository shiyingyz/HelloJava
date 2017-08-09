package org.niit.com.mapper;

import java.util.List;

import org.niit.com.bean.Info;

public interface InfoDao {
	//InfoDao方法名与info.xml的id关联
	
	public List<Info> queryInfos();
	
	public Info queryInfo(int id);
	
	public Info login(String name,String intro);
	
	public int insertInfo(Info info);
	
	public int deleteInfo(int id);
	
	public int updateInfo(Info info);
	
}
