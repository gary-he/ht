package cn.tarena.ht.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> findAll() {
		return moduleMapper.findAll();
	}

}
