package com.bw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.bean.First;
import com.bw.bean.Last;
import com.bw.mapper.StudentMapperDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapperDao dao;
	@Override
	public List<Map<String, Object>> findlist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.findlist(map);
	}
	@Override
	public int deleteFirst(int parseInt) {
		// TODO Auto-generated method stub
		return dao.deleteFirst(parseInt);
	}
	@Override
	public int deleteMiddle(int parseInt) {
		// TODO Auto-generated method stub
		return dao.deleteMiddle(parseInt);
	}
	@Override
	public List<Last> findtype() {
		// TODO Auto-generated method stub
		return dao.findtype();
	}
	@Override
	public int addFirst(String bname, int age) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		map.put("bname", bname);
		map.put("age", age);
		return dao.addFirst(map);
	}
	@Override
	public int findbid() {
		// TODO Auto-generated method stub
		return dao.findbid();
	}
	@Override
	public int addMiddle(int bid, int[] cids) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		map.put("bid", bid);
		map.put("cids", cids);
		return dao.addMiddle(map);
	}
	@Override
	public First getFirst(int fid) {
		// TODO Auto-generated method stub
		return dao.getFirst(fid);
	}
	@Override
	public List<Integer> getcids(int bid) {
		// TODO Auto-generated method stub
		return dao.getcids(bid);
	}
	@Override
	public int update(int bid, String bname, int age) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		map.put("bid", bid);
		map.put("bname", bname);
		map.put("age", age);
		return dao.update(map);
	}
}
