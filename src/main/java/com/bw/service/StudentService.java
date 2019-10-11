package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.bean.First;
import com.bw.bean.Last;

public interface StudentService {
	List<Map<String, Object>> findlist(Map<String, Object> map);

	int deleteFirst(int parseInt);

	int deleteMiddle(int parseInt);

	List<Last> findtype();

	int addFirst(String bname, int age);

	int findbid();

	int addMiddle(int bid, int[] cids);

	First getFirst(int fid);

	List<Integer> getcids(int bid);

	int update(int bid, String bname, int age);
}
