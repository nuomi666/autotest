package com.xjy.autotest.testbase;

import dal.dao.rap.TbProjectDAO;
import dal.model.rap.TbProjectDO;
import dal.model.rap.TbProjectDOExample;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author autotest
 * Created on 2018/03/21.
 */
@Service
public class RapTestBase {

	@Autowired
	TbProjectDAO tbProjectDAO;

    /**
	 * 插入tb_project表数据
	 */
	public void insertTbProject(
			Integer id, 
			String version, 
			String name, 
			Date createDate, 
			Integer userId, 
			String introduction, 
			Integer workspaceMode, 
			Integer stage, 
			String projectData, 
			Integer groupId, 
			String relatedIds, 
			Date updateTime, 
			Integer mockNum, 
			Byte accessType
	) {
		if (createDate == null) {
			createDate = new Date();
		}
		if (updateTime == null) {
			updateTime = new Date();
		}
		TbProjectDO tbProjectDO = new TbProjectDO();
		tbProjectDO.setId(id);
		tbProjectDO.setVersion(version);
		tbProjectDO.setName(name);
		tbProjectDO.setCreateDate(createDate);
		tbProjectDO.setUserId(userId);
		tbProjectDO.setIntroduction(introduction);
		tbProjectDO.setWorkspaceMode(workspaceMode);
		tbProjectDO.setStage(stage);
		tbProjectDO.setProjectData(projectData);
		tbProjectDO.setGroupId(groupId);
		tbProjectDO.setRelatedIds(relatedIds);
		tbProjectDO.setUpdateTime(updateTime);
		tbProjectDO.setMockNum(mockNum);
		tbProjectDO.setAccessType(accessType);
		tbProjectDAO.insert(tbProjectDO);
	}
	

	/**
	 * 根据id删除tb_project表数据
	 */
	public void cleanTbProjectById(Integer id) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		tbProjectDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除tb_project表数据
	*/
	public void cleanTbProjectByName(String name) {
		if (StringUtils.isBlank(name)){
			name = "test_name";
		}
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andNameEqualTo(name);
		tbProjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除tb_project表数据
	 */
	public void cleanTbProjectByUserId(Integer userId) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tbProjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupId删除tb_project表数据
	 */
	public void cleanTbProjectByGroupId(Integer groupId) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		tbProjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据relatedIds删除tb_project表数据
	 */
	public void cleanTbProjectByRelatedIds(String relatedIds) {
		if (StringUtils.isBlank(relatedIds)){
			relatedIds = "test_relatedIds";
		}
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andRelatedIdsEqualTo(relatedIds);
		tbProjectDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询tb_project表数据
	 */
	public List<TbProjectDO> findTbProjectById(Integer id) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return tbProjectDAO.selectByExample(exam);
	}

	/**
	* 根据name查询tb_project表数据
	*/
	public List<TbProjectDO> findTbProjectByName(String name) {
		if (StringUtils.isBlank(name)){
			name = "test_name";
		}
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return tbProjectDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询tb_project表数据
	 */
	public List<TbProjectDO> findTbProjectByUserId(Integer userId) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return tbProjectDAO.selectByExample(exam);
	}

    /**
	 * 根据groupId查询tb_project表数据
	 */
	public List<TbProjectDO> findTbProjectByGroupId(Integer groupId) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		return tbProjectDAO.selectByExample(exam);
	}

    /**
	 * 根据relatedIds查询tb_project表数据
	 */
	public List<TbProjectDO> findTbProjectByRelatedIds(String relatedIds) {
		if (StringUtils.isBlank(relatedIds)){
			relatedIds = "test_relatedIds";
		}
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andRelatedIdsEqualTo(relatedIds);
		return tbProjectDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新tb_project表数据
	 */
	public void updateTbProjectById(Integer id,TbProjectDO tbProjectDO) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		tbProjectDAO.updateByExampleSelective(tbProjectDO, exam);
	}

	/**
	* 根据name更新tb_project表数据
	*/
	public void updateTbProjectByName(String name,TbProjectDO tbProjectDO) {
		if (StringUtils.isBlank(name)){
			name = "test_name";
		}
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andNameEqualTo(name);
		tbProjectDAO.updateByExampleSelective(tbProjectDO, exam);
	}

    /**
	 * 根据userId更新tb_project表数据
	 */
	public void updateTbProjectByUserId(Integer userId,TbProjectDO tbProjectDO) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tbProjectDAO.updateByExampleSelective(tbProjectDO, exam);
	}

    /**
	 * 根据groupId更新tb_project表数据
	 */
	public void updateTbProjectByGroupId(Integer groupId,TbProjectDO tbProjectDO) {
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		tbProjectDAO.updateByExampleSelective(tbProjectDO, exam);
	}

    /**
	 * 根据relatedIds更新tb_project表数据
	 */
	public void updateTbProjectByRelatedIds(String relatedIds,TbProjectDO tbProjectDO) {
		if (StringUtils.isBlank(relatedIds)){
			relatedIds = "test_relatedIds";
		}
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andRelatedIdsEqualTo(relatedIds);
		tbProjectDAO.updateByExampleSelective(tbProjectDO, exam);
	}

}
