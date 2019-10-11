package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.bean.First;
import com.bw.bean.Last;

public interface StudentMapperDao {
	List<Map<String, Object>> findlist(Map<String, Object> map);
	
	int deleteFirst(int bid);
	
	int deleteMiddle(int bid);
	
	List<Last> findtype();
	
	int addFirst(Map<String, Object> map);
	
	int findbid();
	
	int addMiddle(Map<String, Object> map);
	
	First getFirst(int bid);
	
	List<Integer> getcids(int bid);
	
	int update(Map<String, Object> map);
}
