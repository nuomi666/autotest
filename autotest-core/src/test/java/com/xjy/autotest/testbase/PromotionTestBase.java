package com.xjy.autotest.testbase;

import com.xjy.autotest.config.PromotionDataSourceConfig;
import dal.dao.promotion.*;
import dal.model.promotion.*;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author autotest
 * Created on 2019/08/02.
 */
@Service
@Import({
        PromotionDataSourceConfig.class
})
public class PromotionTestBase {

	@Autowired
	CouponDAO couponDAO;

	@Autowired
	CouponDefinitionDAO couponDefinitionDAO;

	@Autowired
	CouponLogDAO couponLogDAO;

	@Autowired
	CouponTransferLogDAO couponTransferLogDAO;

	@Autowired
	InstructionDAO instructionDAO;

	@Autowired
	PointsDAO pointsDAO;

	@Autowired
	PointsLogDAO pointsLogDAO;

	public CouponDAO getCouponDAO() {
		return this.couponDAO;
	}

	public CouponDefinitionDAO getCouponDefinitionDAO() {
		return this.couponDefinitionDAO;
	}

	public CouponLogDAO getCouponLogDAO() {
		return this.couponLogDAO;
	}

	public CouponTransferLogDAO getCouponTransferLogDAO() {
		return this.couponTransferLogDAO;
	}

	public InstructionDAO getInstructionDAO() {
		return this.instructionDAO;
	}

	public PointsDAO getPointsDAO() {
		return this.pointsDAO;
	}

	public PointsLogDAO getPointsLogDAO() {
		return this.pointsLogDAO;
	}


	/**
	 * 断言coupon表数据
	 */
	public void assertCoupon(CouponDO expect, CouponDO couponDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			couponDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != couponDO.getRawAddTime());
		expect.setRawAddTime(couponDO.getRawAddTime());
        Assertions.assertTrue(null != couponDO.getRawUpdateTime());
		expect.setRawUpdateTime(couponDO.getRawUpdateTime());
		Assertions.assertEquals(expect, couponDO);
	}

    /**
	 * 插入coupon表数据
	 */
	public void insertCoupon(CouponDO couponDO) {
		couponDAO.insert(couponDO);
	}

    /**
	 * 插入coupon表数据
	 */
	public void insertCoupon(
			Integer id, 
			String couponId, 
			String innerName, 
			String name, 
			String platPartnerId, 
			String partnerId, 
			String instructionId, 
			String definitionId, 
			String userId, 
			String couponType, 
			String status, 
			String amountData, 
			long discountAmount, 
			long maxDiscountAmount, 
			String definitionJson, 
			Date takenTime, 
			Date appliedTime, 
			Date validStartTime, 
			Date validEndTime, 
			Date canApplyTime, 
			Date expireNotifyTime, 
			String product, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (takenTime == null) {
			takenTime = new Date();
		}
		if (appliedTime == null) {
			appliedTime = new Date();
		}
		if (validStartTime == null) {
			validStartTime = new Date();
		}
		if (validEndTime == null) {
			validEndTime = new Date();
		}
		if (canApplyTime == null) {
			canApplyTime = new Date();
		}
		if (expireNotifyTime == null) {
			expireNotifyTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CouponDO couponDO = new CouponDO();
		couponDO.setId(id);
		couponDO.setCouponId(couponId);
		couponDO.setInnerName(innerName);
		couponDO.setName(name);
		couponDO.setPlatPartnerId(platPartnerId);
		couponDO.setPartnerId(partnerId);
		couponDO.setInstructionId(instructionId);
		couponDO.setDefinitionId(definitionId);
		couponDO.setUserId(userId);
		couponDO.setCouponType(couponType);
		couponDO.setStatus(status);
		couponDO.setAmountData(amountData);
		couponDO.setDiscountAmount(discountAmount);
		couponDO.setMaxDiscountAmount(maxDiscountAmount);
		couponDO.setDefinitionJson(definitionJson);
		couponDO.setTakenTime(takenTime);
		couponDO.setAppliedTime(appliedTime);
		couponDO.setValidStartTime(validStartTime);
		couponDO.setValidEndTime(validEndTime);
		couponDO.setCanApplyTime(canApplyTime);
		couponDO.setExpireNotifyTime(expireNotifyTime);
		couponDO.setProduct(product);
		couponDO.setRawAddTime(rawAddTime);
		couponDO.setRawUpdateTime(rawUpdateTime);
		couponDAO.insert(couponDO);
	}

    /**
     * 删除coupon表所有数据
     */
    public void cleanCoupon() {
        CouponDOExample exam = new CouponDOExample();
        exam.createCriteria();
        couponDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除coupon表数据
	 */
	public void cleanCouponById(Integer id) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据couponId删除coupon表数据
	 */
	public void cleanCouponByCouponId(String couponId) {
        if (StringUtils.isBlank(couponId)){
            couponId = "test_couponId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andCouponIdEqualTo(couponId);
		couponDAO.deleteByExample(exam);
	}

	/**
	* 根据innerName删除coupon表数据
	*/
	public void cleanCouponByInnerName(String innerName) {
        if (StringUtils.isBlank(innerName)){
            innerName = "test_innerName";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		couponDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除coupon表数据
	*/
	public void cleanCouponByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除coupon表数据
	 */
	public void cleanCouponByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除coupon表数据
	 */
	public void cleanCouponByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据instructionId删除coupon表数据
	 */
	public void cleanCouponByInstructionId(String instructionId) {
        if (StringUtils.isBlank(instructionId)){
            instructionId = "test_instructionId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除coupon表数据
	 */
	public void cleanCouponByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除coupon表数据
	 */
	public void cleanCouponByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据validStartTime删除coupon表数据
	 */
	public void cleanCouponByValidStartTime(Date validStartTime) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andValidStartTimeEqualTo(validStartTime);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据validEndTime删除coupon表数据
	 */
	public void cleanCouponByValidEndTime(Date validEndTime) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据expireNotifyTime删除coupon表数据
	 */
	public void cleanCouponByExpireNotifyTime(Date expireNotifyTime) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andExpireNotifyTimeEqualTo(expireNotifyTime);
		couponDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询coupon表数据
	 */
	public List<CouponDO> findCouponById(Integer id) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据couponId查询coupon表数据
	 */
	public List<CouponDO> findCouponByCouponId(String couponId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andCouponIdEqualTo(couponId);
		return couponDAO.selectByExample(exam);
	}

	/**
	* 根据innerName查询coupon表数据
	*/
	public List<CouponDO> findCouponByInnerName(String innerName) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		return couponDAO.selectByExample(exam);
	}

	/**
	* 根据name查询coupon表数据
	*/
	public List<CouponDO> findCouponByName(String name) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询coupon表数据
	 */
	public List<CouponDO> findCouponByPlatPartnerId(String platPartnerId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询coupon表数据
	 */
	public List<CouponDO> findCouponByPartnerId(String partnerId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据instructionId查询coupon表数据
	 */
	public List<CouponDO> findCouponByInstructionId(String instructionId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询coupon表数据
	 */
	public List<CouponDO> findCouponByDefinitionId(String definitionId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询coupon表数据
	 */
	public List<CouponDO> findCouponByUserId(String userId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据validStartTime查询coupon表数据
	 */
	public List<CouponDO> findCouponByValidStartTime(Date validStartTime) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andValidStartTimeEqualTo(validStartTime);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据validEndTime查询coupon表数据
	 */
	public List<CouponDO> findCouponByValidEndTime(Date validEndTime) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据expireNotifyTime查询coupon表数据
	 */
	public List<CouponDO> findCouponByExpireNotifyTime(Date expireNotifyTime) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andExpireNotifyTimeEqualTo(expireNotifyTime);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新coupon表数据
	 */
	public void updateCouponById(Integer id,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据couponId更新coupon表数据
	 */
	public void updateCouponByCouponId(String couponId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andCouponIdEqualTo(couponId);
		couponDAO.updateByExample(couponDO, exam);
	}

	/**
	* 根据innerName更新coupon表数据
	*/
	public void updateCouponByInnerName(String innerName,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		couponDAO.updateByExample(couponDO, exam);
	}

	/**
	* 根据name更新coupon表数据
	*/
	public void updateCouponByName(String name,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据platPartnerId更新coupon表数据
	 */
	public void updateCouponByPlatPartnerId(String platPartnerId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据partnerId更新coupon表数据
	 */
	public void updateCouponByPartnerId(String partnerId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据instructionId更新coupon表数据
	 */
	public void updateCouponByInstructionId(String instructionId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据definitionId更新coupon表数据
	 */
	public void updateCouponByDefinitionId(String definitionId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据userId更新coupon表数据
	 */
	public void updateCouponByUserId(String userId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据validStartTime更新coupon表数据
	 */
	public void updateCouponByValidStartTime(Date validStartTime,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andValidStartTimeEqualTo(validStartTime);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据validEndTime更新coupon表数据
	 */
	public void updateCouponByValidEndTime(Date validEndTime,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据expireNotifyTime更新coupon表数据
	 */
	public void updateCouponByExpireNotifyTime(Date expireNotifyTime,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andExpireNotifyTimeEqualTo(expireNotifyTime);
		couponDAO.updateByExample(couponDO, exam);
	}

	/**
	 * 断言coupon_definition表数据
	 */
	public void assertCouponDefinition(CouponDefinitionDO expect, CouponDefinitionDO couponDefinitionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			couponDefinitionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != couponDefinitionDO.getRawAddTime());
		expect.setRawAddTime(couponDefinitionDO.getRawAddTime());
        Assertions.assertTrue(null != couponDefinitionDO.getRawUpdateTime());
		expect.setRawUpdateTime(couponDefinitionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, couponDefinitionDO);
	}

    /**
	 * 插入coupon_definition表数据
	 */
	public void insertCouponDefinition(CouponDefinitionDO couponDefinitionDO) {
		couponDefinitionDAO.insert(couponDefinitionDO);
	}

    /**
	 * 插入coupon_definition表数据
	 */
	public void insertCouponDefinition(
			Integer id, 
			String definitionId, 
			String platPartnerId, 
			String partnerId, 
			String definitionStatus, 
			String innerName, 
			String name, 
			String couponType, 
			long quantity, 
			Integer takeCount, 
			Integer applyCount, 
			long maxDiscountAmount, 
			Boolean overlay, 
			Integer expireNotifyDays, 
			String product, 
			String definitionJson, 
			Date createTime, 
			Date modifyTime, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (createTime == null) {
			createTime = new Date();
		}
		if (modifyTime == null) {
			modifyTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CouponDefinitionDO couponDefinitionDO = new CouponDefinitionDO();
		couponDefinitionDO.setId(id);
		couponDefinitionDO.setDefinitionId(definitionId);
		couponDefinitionDO.setPlatPartnerId(platPartnerId);
		couponDefinitionDO.setPartnerId(partnerId);
		couponDefinitionDO.setDefinitionStatus(definitionStatus);
		couponDefinitionDO.setInnerName(innerName);
		couponDefinitionDO.setName(name);
		couponDefinitionDO.setCouponType(couponType);
		couponDefinitionDO.setQuantity(quantity);
		couponDefinitionDO.setTakeCount(takeCount);
		couponDefinitionDO.setApplyCount(applyCount);
		couponDefinitionDO.setMaxDiscountAmount(maxDiscountAmount);
		couponDefinitionDO.setOverlay(overlay);
		couponDefinitionDO.setExpireNotifyDays(expireNotifyDays);
		couponDefinitionDO.setProduct(product);
		couponDefinitionDO.setDefinitionJson(definitionJson);
		couponDefinitionDO.setCreateTime(createTime);
		couponDefinitionDO.setModifyTime(modifyTime);
		couponDefinitionDO.setMemo(memo);
		couponDefinitionDO.setRawAddTime(rawAddTime);
		couponDefinitionDO.setRawUpdateTime(rawUpdateTime);
		couponDefinitionDAO.insert(couponDefinitionDO);
	}

    /**
     * 删除coupon_definition表所有数据
     */
    public void cleanCouponDefinition() {
        CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
        exam.createCriteria();
        couponDefinitionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除coupon_definition表数据
	 */
	public void cleanCouponDefinitionById(Integer id) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除coupon_definition表数据
	 */
	public void cleanCouponDefinitionByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除coupon_definition表数据
	 */
	public void cleanCouponDefinitionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除coupon_definition表数据
	 */
	public void cleanCouponDefinitionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponDefinitionDAO.deleteByExample(exam);
	}

	/**
	* 根据innerName删除coupon_definition表数据
	*/
	public void cleanCouponDefinitionByInnerName(String innerName) {
        if (StringUtils.isBlank(innerName)){
            innerName = "test_innerName";
        }
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		couponDefinitionDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除coupon_definition表数据
	*/
	public void cleanCouponDefinitionByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponDefinitionDAO.deleteByExample(exam);
	}

	/**
	 * 根据expireNotifyDays删除coupon_definition表数据
	 */
	public void cleanCouponDefinitionByExpireNotifyDays(Integer expireNotifyDays) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andExpireNotifyDaysEqualTo(expireNotifyDays);
		couponDefinitionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询coupon_definition表数据
	 */
	public List<CouponDefinitionDO> findCouponDefinitionById(Integer id) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return couponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询coupon_definition表数据
	 */
	public List<CouponDefinitionDO> findCouponDefinitionByDefinitionId(String definitionId) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return couponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询coupon_definition表数据
	 */
	public List<CouponDefinitionDO> findCouponDefinitionByPlatPartnerId(String platPartnerId) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return couponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询coupon_definition表数据
	 */
	public List<CouponDefinitionDO> findCouponDefinitionByPartnerId(String partnerId) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return couponDefinitionDAO.selectByExample(exam);
	}

	/**
	* 根据innerName查询coupon_definition表数据
	*/
	public List<CouponDefinitionDO> findCouponDefinitionByInnerName(String innerName) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		return couponDefinitionDAO.selectByExample(exam);
	}

	/**
	* 根据name查询coupon_definition表数据
	*/
	public List<CouponDefinitionDO> findCouponDefinitionByName(String name) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return couponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据expireNotifyDays查询coupon_definition表数据
	 */
	public List<CouponDefinitionDO> findCouponDefinitionByExpireNotifyDays(Integer expireNotifyDays) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andExpireNotifyDaysEqualTo(expireNotifyDays);
		return couponDefinitionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新coupon_definition表数据
	 */
	public void updateCouponDefinitionById(Integer id,CouponDefinitionDO couponDefinitionDO) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponDefinitionDAO.updateByExample(couponDefinitionDO, exam);
	}

    /**
	 * 根据definitionId更新coupon_definition表数据
	 */
	public void updateCouponDefinitionByDefinitionId(String definitionId,CouponDefinitionDO couponDefinitionDO) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponDefinitionDAO.updateByExample(couponDefinitionDO, exam);
	}

    /**
	 * 根据platPartnerId更新coupon_definition表数据
	 */
	public void updateCouponDefinitionByPlatPartnerId(String platPartnerId,CouponDefinitionDO couponDefinitionDO) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponDefinitionDAO.updateByExample(couponDefinitionDO, exam);
	}

    /**
	 * 根据partnerId更新coupon_definition表数据
	 */
	public void updateCouponDefinitionByPartnerId(String partnerId,CouponDefinitionDO couponDefinitionDO) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponDefinitionDAO.updateByExample(couponDefinitionDO, exam);
	}

	/**
	* 根据innerName更新coupon_definition表数据
	*/
	public void updateCouponDefinitionByInnerName(String innerName,CouponDefinitionDO couponDefinitionDO) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		couponDefinitionDAO.updateByExample(couponDefinitionDO, exam);
	}

	/**
	* 根据name更新coupon_definition表数据
	*/
	public void updateCouponDefinitionByName(String name,CouponDefinitionDO couponDefinitionDO) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponDefinitionDAO.updateByExample(couponDefinitionDO, exam);
	}

    /**
	 * 根据expireNotifyDays更新coupon_definition表数据
	 */
	public void updateCouponDefinitionByExpireNotifyDays(Integer expireNotifyDays,CouponDefinitionDO couponDefinitionDO) {
		CouponDefinitionDOExample exam = new CouponDefinitionDOExample();
		exam.createCriteria().andExpireNotifyDaysEqualTo(expireNotifyDays);
		couponDefinitionDAO.updateByExample(couponDefinitionDO, exam);
	}

	/**
	 * 断言coupon_log表数据
	 */
	public void assertCouponLog(CouponLogDO expect, CouponLogDO couponLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			couponLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != couponLogDO.getRawAddTime());
		expect.setRawAddTime(couponLogDO.getRawAddTime());
        Assertions.assertTrue(null != couponLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(couponLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, couponLogDO);
	}

    /**
	 * 插入coupon_log表数据
	 */
	public void insertCouponLog(CouponLogDO couponLogDO) {
		couponLogDAO.insert(couponLogDO);
	}

    /**
	 * 插入coupon_log表数据
	 */
	public void insertCouponLog(
			Integer id, 
			String couponId, 
			String definitionId, 
			String gid, 
			String reqId, 
			String platPartnerId, 
			String partnerId, 
			String userId, 
			String name, 
			String type, 
			String instructionId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CouponLogDO couponLogDO = new CouponLogDO();
		couponLogDO.setId(id);
		couponLogDO.setCouponId(couponId);
		couponLogDO.setDefinitionId(definitionId);
		couponLogDO.setGid(gid);
		couponLogDO.setReqId(reqId);
		couponLogDO.setPlatPartnerId(platPartnerId);
		couponLogDO.setPartnerId(partnerId);
		couponLogDO.setUserId(userId);
		couponLogDO.setName(name);
		couponLogDO.setType(type);
		couponLogDO.setInstructionId(instructionId);
		couponLogDO.setRawAddTime(rawAddTime);
		couponLogDO.setRawUpdateTime(rawUpdateTime);
		couponLogDAO.insert(couponLogDO);
	}

    /**
     * 删除coupon_log表所有数据
     */
    public void cleanCouponLog() {
        CouponLogDOExample exam = new CouponLogDOExample();
        exam.createCriteria();
        couponLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除coupon_log表数据
	 */
	public void cleanCouponLogById(Integer id) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据couponId删除coupon_log表数据
	 */
	public void cleanCouponLogByCouponId(String couponId) {
        if (StringUtils.isBlank(couponId)){
            couponId = "test_couponId";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andCouponIdEqualTo(couponId);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除coupon_log表数据
	 */
	public void cleanCouponLogByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除coupon_log表数据
	 */
	public void cleanCouponLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		couponLogDAO.deleteByExample(exam);
	}
	/**
	 * 根据reqId,type删除coupon_log表数据
	 */
	public void cleanCouponLogByReqIdAndType(String reqId,String type) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
        if (StringUtils.isBlank(type)){
            type = "test_type";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId).andTypeEqualTo(type);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除coupon_log表数据
	 */
	public void cleanCouponLogByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除coupon_log表数据
	 */
	public void cleanCouponLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除coupon_log表数据
	 */
	public void cleanCouponLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除coupon_log表数据
	 */
	public void cleanCouponLogByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除coupon_log表数据
	*/
	public void cleanCouponLogByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据instructionId删除coupon_log表数据
	 */
	public void cleanCouponLogByInstructionId(String instructionId) {
        if (StringUtils.isBlank(instructionId)){
            instructionId = "test_instructionId";
        }
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		couponLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogById(Integer id) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据couponId查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByCouponId(String couponId) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andCouponIdEqualTo(couponId);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByDefinitionId(String definitionId) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByGid(String gid) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return couponLogDAO.selectByExample(exam);
	}

	/**
	 * 根据reqId,type查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByReqIdAndType(String reqId,String type) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId).andTypeEqualTo(type);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByReqId(String reqId) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByPlatPartnerId(String platPartnerId) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByPartnerId(String partnerId) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByUserId(String userId) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return couponLogDAO.selectByExample(exam);
	}

	/**
	* 根据name查询coupon_log表数据
	*/
	public List<CouponLogDO> findCouponLogByName(String name) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据instructionId查询coupon_log表数据
	 */
	public List<CouponLogDO> findCouponLogByInstructionId(String instructionId) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		return couponLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新coupon_log表数据
	 */
	public void updateCouponLogById(Integer id,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据couponId更新coupon_log表数据
	 */
	public void updateCouponLogByCouponId(String couponId,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andCouponIdEqualTo(couponId);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据definitionId更新coupon_log表数据
	 */
	public void updateCouponLogByDefinitionId(String definitionId,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据gid更新coupon_log表数据
	 */
	public void updateCouponLogByGid(String gid,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

	/**
	 * 根据reqId,type更新coupon_log表数据
	 */
	public void updateCouponLogByReqIdAndType(String reqId,String type,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId).andTypeEqualTo(type);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据reqId更新coupon_log表数据
	 */
	public void updateCouponLogByReqId(String reqId,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新coupon_log表数据
	 */
	public void updateCouponLogByPlatPartnerId(String platPartnerId,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据partnerId更新coupon_log表数据
	 */
	public void updateCouponLogByPartnerId(String partnerId,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据userId更新coupon_log表数据
	 */
	public void updateCouponLogByUserId(String userId,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

	/**
	* 根据name更新coupon_log表数据
	*/
	public void updateCouponLogByName(String name,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

    /**
	 * 根据instructionId更新coupon_log表数据
	 */
	public void updateCouponLogByInstructionId(String instructionId,CouponLogDO couponLogDO) {
		CouponLogDOExample exam = new CouponLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		couponLogDAO.updateByExample(couponLogDO, exam);
	}

	/**
	 * 断言coupon_transfer_log表数据
	 */
	public void assertCouponTransferLog(CouponTransferLogDO expect, CouponTransferLogDO couponTransferLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			couponTransferLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != couponTransferLogDO.getRawAddTime());
		expect.setRawAddTime(couponTransferLogDO.getRawAddTime());
        Assertions.assertTrue(null != couponTransferLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(couponTransferLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, couponTransferLogDO);
	}

    /**
	 * 插入coupon_transfer_log表数据
	 */
	public void insertCouponTransferLog(CouponTransferLogDO couponTransferLogDO) {
		couponTransferLogDAO.insert(couponTransferLogDO);
	}

    /**
	 * 插入coupon_transfer_log表数据
	 */
	public void insertCouponTransferLog(
			long id, 
			String gid, 
			String reqId, 
			String instructionId, 
			String partnerId, 
			String platPartnerId, 
			String donorUserId, 
			String receiveUserId, 
			String oldCouponId, 
			String newCouponId, 
			String definitionId, 
			String amountData, 
			String couponType, 
			String name, 
			String innerName, 
			Date takenTime, 
			Date canApplyTime, 
			Date validEndTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (takenTime == null) {
			takenTime = new Date();
		}
		if (canApplyTime == null) {
			canApplyTime = new Date();
		}
		if (validEndTime == null) {
			validEndTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CouponTransferLogDO couponTransferLogDO = new CouponTransferLogDO();
		couponTransferLogDO.setId(id);
		couponTransferLogDO.setGid(gid);
		couponTransferLogDO.setReqId(reqId);
		couponTransferLogDO.setInstructionId(instructionId);
		couponTransferLogDO.setPartnerId(partnerId);
		couponTransferLogDO.setPlatPartnerId(platPartnerId);
		couponTransferLogDO.setDonorUserId(donorUserId);
		couponTransferLogDO.setReceiveUserId(receiveUserId);
		couponTransferLogDO.setOldCouponId(oldCouponId);
		couponTransferLogDO.setNewCouponId(newCouponId);
		couponTransferLogDO.setDefinitionId(definitionId);
		couponTransferLogDO.setAmountData(amountData);
		couponTransferLogDO.setCouponType(couponType);
		couponTransferLogDO.setName(name);
		couponTransferLogDO.setInnerName(innerName);
		couponTransferLogDO.setTakenTime(takenTime);
		couponTransferLogDO.setCanApplyTime(canApplyTime);
		couponTransferLogDO.setValidEndTime(validEndTime);
		couponTransferLogDO.setRawAddTime(rawAddTime);
		couponTransferLogDO.setRawUpdateTime(rawUpdateTime);
		couponTransferLogDAO.insert(couponTransferLogDO);
	}

    /**
     * 删除coupon_transfer_log表所有数据
     */
    public void cleanCouponTransferLog() {
        CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
        exam.createCriteria();
        couponTransferLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogById(long id) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据instructionId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByInstructionId(String instructionId) {
        if (StringUtils.isBlank(instructionId)){
            instructionId = "test_instructionId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据donorUserId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByDonorUserId(String donorUserId) {
        if (StringUtils.isBlank(donorUserId)){
            donorUserId = "test_donorUserId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andDonorUserIdEqualTo(donorUserId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据receiveUserId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByReceiveUserId(String receiveUserId) {
        if (StringUtils.isBlank(receiveUserId)){
            receiveUserId = "test_receiveUserId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andReceiveUserIdEqualTo(receiveUserId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据oldCouponId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByOldCouponId(String oldCouponId) {
        if (StringUtils.isBlank(oldCouponId)){
            oldCouponId = "test_oldCouponId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andOldCouponIdEqualTo(oldCouponId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据newCouponId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByNewCouponId(String newCouponId) {
        if (StringUtils.isBlank(newCouponId)){
            newCouponId = "test_newCouponId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andNewCouponIdEqualTo(newCouponId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除coupon_transfer_log表数据
	*/
	public void cleanCouponTransferLogByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	* 根据innerName删除coupon_transfer_log表数据
	*/
	public void cleanCouponTransferLogByInnerName(String innerName) {
        if (StringUtils.isBlank(innerName)){
            innerName = "test_innerName";
        }
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		couponTransferLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据validEndTime删除coupon_transfer_log表数据
	 */
	public void cleanCouponTransferLogByValidEndTime(Date validEndTime) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		couponTransferLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogById(long id) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByGid(String gid) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByReqId(String reqId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据instructionId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByInstructionId(String instructionId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByPartnerId(String partnerId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByPlatPartnerId(String platPartnerId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据donorUserId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByDonorUserId(String donorUserId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andDonorUserIdEqualTo(donorUserId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据receiveUserId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByReceiveUserId(String receiveUserId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andReceiveUserIdEqualTo(receiveUserId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据oldCouponId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByOldCouponId(String oldCouponId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andOldCouponIdEqualTo(oldCouponId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据newCouponId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByNewCouponId(String newCouponId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andNewCouponIdEqualTo(newCouponId);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByDefinitionId(String definitionId) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return couponTransferLogDAO.selectByExample(exam);
	}

	/**
	* 根据name查询coupon_transfer_log表数据
	*/
	public List<CouponTransferLogDO> findCouponTransferLogByName(String name) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return couponTransferLogDAO.selectByExample(exam);
	}

	/**
	* 根据innerName查询coupon_transfer_log表数据
	*/
	public List<CouponTransferLogDO> findCouponTransferLogByInnerName(String innerName) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据validEndTime查询coupon_transfer_log表数据
	 */
	public List<CouponTransferLogDO> findCouponTransferLogByValidEndTime(Date validEndTime) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		return couponTransferLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogById(long id,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据gid更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByGid(String gid,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据reqId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByReqId(String reqId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据instructionId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByInstructionId(String instructionId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据partnerId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByPartnerId(String partnerId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByPlatPartnerId(String platPartnerId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据donorUserId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByDonorUserId(String donorUserId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andDonorUserIdEqualTo(donorUserId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据receiveUserId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByReceiveUserId(String receiveUserId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andReceiveUserIdEqualTo(receiveUserId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据oldCouponId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByOldCouponId(String oldCouponId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andOldCouponIdEqualTo(oldCouponId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据newCouponId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByNewCouponId(String newCouponId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andNewCouponIdEqualTo(newCouponId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据definitionId更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByDefinitionId(String definitionId,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

	/**
	* 根据name更新coupon_transfer_log表数据
	*/
	public void updateCouponTransferLogByName(String name,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andNameEqualTo(name);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

	/**
	* 根据innerName更新coupon_transfer_log表数据
	*/
	public void updateCouponTransferLogByInnerName(String innerName,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andInnerNameEqualTo(innerName);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

    /**
	 * 根据validEndTime更新coupon_transfer_log表数据
	 */
	public void updateCouponTransferLogByValidEndTime(Date validEndTime,CouponTransferLogDO couponTransferLogDO) {
		CouponTransferLogDOExample exam = new CouponTransferLogDOExample();
		exam.createCriteria().andValidEndTimeEqualTo(validEndTime);
		couponTransferLogDAO.updateByExample(couponTransferLogDO, exam);
	}

	/**
	 * 断言instruction表数据
	 */
	public void assertInstruction(InstructionDO expect, InstructionDO instructionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			instructionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != instructionDO.getRawAddTime());
		expect.setRawAddTime(instructionDO.getRawAddTime());
        Assertions.assertTrue(null != instructionDO.getRawUpdateTime());
		expect.setRawUpdateTime(instructionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, instructionDO);
	}

    /**
	 * 插入instruction表数据
	 */
	public void insertInstruction(InstructionDO instructionDO) {
		instructionDAO.insert(instructionDO);
	}

    /**
	 * 插入instruction表数据
	 */
	public void insertInstruction(
			Integer id, 
			String instructionId, 
			String platPartnerId, 
			String partnerId, 
			String gid, 
			String reqId, 
			String platMerchantOrderNo, 
			String merchantOrderNo, 
			String instructionType, 
			String state, 
			String status, 
			String code, 
			String message, 
			String description, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String instructionJson
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		InstructionDO instructionDO = new InstructionDO();
		instructionDO.setId(id);
		instructionDO.setInstructionId(instructionId);
		instructionDO.setPlatPartnerId(platPartnerId);
		instructionDO.setPartnerId(partnerId);
		instructionDO.setGid(gid);
		instructionDO.setReqId(reqId);
		instructionDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		instructionDO.setMerchantOrderNo(merchantOrderNo);
		instructionDO.setInstructionType(instructionType);
		instructionDO.setState(state);
		instructionDO.setStatus(status);
		instructionDO.setCode(code);
		instructionDO.setMessage(message);
		instructionDO.setDescription(description);
		instructionDO.setMemo(memo);
		instructionDO.setRawAddTime(rawAddTime);
		instructionDO.setRawUpdateTime(rawUpdateTime);
		instructionDO.setInstructionJson(instructionJson);
		instructionDAO.insert(instructionDO);
	}

    /**
     * 删除instruction表所有数据
     */
    public void cleanInstruction() {
        InstructionDOExample exam = new InstructionDOExample();
        exam.createCriteria();
        instructionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除instruction表数据
	 */
	public void cleanInstructionById(Integer id) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据instructionId删除instruction表数据
	 */
	public void cleanInstructionByInstructionId(String instructionId) {
        if (StringUtils.isBlank(instructionId)){
            instructionId = "test_instructionId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除instruction表数据
	 */
	public void cleanInstructionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除instruction表数据
	 */
	public void cleanInstructionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除instruction表数据
	 */
	public void cleanInstructionByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		instructionDAO.deleteByExample(exam);
	}
	/**
	 * 根据reqId,instructionType删除instruction表数据
	 */
	public void cleanInstructionByReqIdAndInstructionType(String reqId,String instructionType) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
        if (StringUtils.isBlank(instructionType)){
            instructionType = "test_instructionType";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId).andInstructionTypeEqualTo(instructionType);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除instruction表数据
	 */
	public void cleanInstructionByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除instruction表数据
	 */
	public void cleanInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除instruction表数据
	 */
	public void cleanInstructionByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		instructionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除instruction表数据
	*/
	public void cleanInstructionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		instructionDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询instruction表数据
	 */
	public List<InstructionDO> findInstructionById(Integer id) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据instructionId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByInstructionId(String instructionId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByPlatPartnerId(String platPartnerId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByPartnerId(String partnerId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByGid(String gid) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return instructionDAO.selectByExample(exam);
	}

	/**
	 * 根据reqId,instructionType查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByReqIdAndInstructionType(String reqId,String instructionType) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId).andInstructionTypeEqualTo(instructionType);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByReqId(String reqId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByMerchantOrderNo(String merchantOrderNo) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return instructionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询instruction表数据
	*/
	public List<InstructionDO> findInstructionByCode(String code) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新instruction表数据
	 */
	public void updateInstructionById(Integer id,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据instructionId更新instruction表数据
	 */
	public void updateInstructionByInstructionId(String instructionId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据platPartnerId更新instruction表数据
	 */
	public void updateInstructionByPlatPartnerId(String platPartnerId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据partnerId更新instruction表数据
	 */
	public void updateInstructionByPartnerId(String partnerId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据gid更新instruction表数据
	 */
	public void updateInstructionByGid(String gid,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		instructionDAO.updateByExample(instructionDO, exam);
	}

	/**
	 * 根据reqId,instructionType更新instruction表数据
	 */
	public void updateInstructionByReqIdAndInstructionType(String reqId,String instructionType,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId).andInstructionTypeEqualTo(instructionType);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据reqId更新instruction表数据
	 */
	public void updateInstructionByReqId(String reqId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新instruction表数据
	 */
	public void updateInstructionByPlatMerchantOrderNo(String platMerchantOrderNo,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新instruction表数据
	 */
	public void updateInstructionByMerchantOrderNo(String merchantOrderNo,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		instructionDAO.updateByExample(instructionDO, exam);
	}

	/**
	* 根据code更新instruction表数据
	*/
	public void updateInstructionByCode(String code,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		instructionDAO.updateByExample(instructionDO, exam);
	}

	/**
	 * 断言points表数据
	 */
	public void assertPoints(PointsDO expect, PointsDO pointsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			pointsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != pointsDO.getRawAddTime());
		expect.setRawAddTime(pointsDO.getRawAddTime());
        Assertions.assertTrue(null != pointsDO.getRawUpdateTime());
		expect.setRawUpdateTime(pointsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, pointsDO);
	}

    /**
	 * 插入points表数据
	 */
	public void insertPoints(PointsDO pointsDO) {
		pointsDAO.insert(pointsDO);
	}

    /**
	 * 插入points表数据
	 */
	public void insertPoints(
			Integer id, 
			String pointId, 
			String platPartnerId, 
			String partnerId, 
			String userId, 
			long points, 
			long historySubtractPoints, 
			long historyAddPoints, 
			Date lastClearTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (lastClearTime == null) {
			lastClearTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PointsDO pointsDO = new PointsDO();
		pointsDO.setId(id);
		pointsDO.setPointId(pointId);
		pointsDO.setPlatPartnerId(platPartnerId);
		pointsDO.setPartnerId(partnerId);
		pointsDO.setUserId(userId);
		pointsDO.setPoints(points);
		pointsDO.setHistorySubtractPoints(historySubtractPoints);
		pointsDO.setHistoryAddPoints(historyAddPoints);
		pointsDO.setLastClearTime(lastClearTime);
		pointsDO.setRawAddTime(rawAddTime);
		pointsDO.setRawUpdateTime(rawUpdateTime);
		pointsDAO.insert(pointsDO);
	}

    /**
     * 删除points表所有数据
     */
    public void cleanPoints() {
        PointsDOExample exam = new PointsDOExample();
        exam.createCriteria();
        pointsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除points表数据
	 */
	public void cleanPointsById(Integer id) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		pointsDAO.deleteByExample(exam);
	}

	/**
	 * 根据pointId删除points表数据
	 */
	public void cleanPointsByPointId(String pointId) {
        if (StringUtils.isBlank(pointId)){
            pointId = "test_pointId";
        }
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPointIdEqualTo(pointId);
		pointsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除points表数据
	 */
	public void cleanPointsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		pointsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除points表数据
	 */
	public void cleanPointsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		pointsDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除points表数据
	 */
	public void cleanPointsByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		pointsDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询points表数据
	 */
	public List<PointsDO> findPointsById(Integer id) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return pointsDAO.selectByExample(exam);
	}

    /**
	 * 根据pointId查询points表数据
	 */
	public List<PointsDO> findPointsByPointId(String pointId) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPointIdEqualTo(pointId);
		return pointsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询points表数据
	 */
	public List<PointsDO> findPointsByPlatPartnerId(String platPartnerId) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return pointsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询points表数据
	 */
	public List<PointsDO> findPointsByPartnerId(String partnerId) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return pointsDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询points表数据
	 */
	public List<PointsDO> findPointsByUserId(String userId) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return pointsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新points表数据
	 */
	public void updatePointsById(Integer id,PointsDO pointsDO) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		pointsDAO.updateByExample(pointsDO, exam);
	}

    /**
	 * 根据pointId更新points表数据
	 */
	public void updatePointsByPointId(String pointId,PointsDO pointsDO) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPointIdEqualTo(pointId);
		pointsDAO.updateByExample(pointsDO, exam);
	}

    /**
	 * 根据platPartnerId更新points表数据
	 */
	public void updatePointsByPlatPartnerId(String platPartnerId,PointsDO pointsDO) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		pointsDAO.updateByExample(pointsDO, exam);
	}

    /**
	 * 根据partnerId更新points表数据
	 */
	public void updatePointsByPartnerId(String partnerId,PointsDO pointsDO) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		pointsDAO.updateByExample(pointsDO, exam);
	}

    /**
	 * 根据userId更新points表数据
	 */
	public void updatePointsByUserId(String userId,PointsDO pointsDO) {
		PointsDOExample exam = new PointsDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		pointsDAO.updateByExample(pointsDO, exam);
	}

	/**
	 * 断言points_log表数据
	 */
	public void assertPointsLog(PointsLogDO expect, PointsLogDO pointsLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			pointsLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != pointsLogDO.getRawAddTime());
		expect.setRawAddTime(pointsLogDO.getRawAddTime());
        Assertions.assertTrue(null != pointsLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(pointsLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, pointsLogDO);
	}

    /**
	 * 插入points_log表数据
	 */
	public void insertPointsLog(PointsLogDO pointsLogDO) {
		pointsLogDAO.insert(pointsLogDO);
	}

    /**
	 * 插入points_log表数据
	 */
	public void insertPointsLog(
			Integer id, 
			String pointId, 
			String gid, 
			String reqId, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String partnerId, 
			String merchantOrderNo, 
			String userId, 
			long points, 
			String instructionId, 
			String type, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PointsLogDO pointsLogDO = new PointsLogDO();
		pointsLogDO.setId(id);
		pointsLogDO.setPointId(pointId);
		pointsLogDO.setGid(gid);
		pointsLogDO.setReqId(reqId);
		pointsLogDO.setPlatPartnerId(platPartnerId);
		pointsLogDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		pointsLogDO.setPartnerId(partnerId);
		pointsLogDO.setMerchantOrderNo(merchantOrderNo);
		pointsLogDO.setUserId(userId);
		pointsLogDO.setPoints(points);
		pointsLogDO.setInstructionId(instructionId);
		pointsLogDO.setType(type);
		pointsLogDO.setRawAddTime(rawAddTime);
		pointsLogDO.setRawUpdateTime(rawUpdateTime);
		pointsLogDAO.insert(pointsLogDO);
	}

    /**
     * 删除points_log表所有数据
     */
    public void cleanPointsLog() {
        PointsLogDOExample exam = new PointsLogDOExample();
        exam.createCriteria();
        pointsLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除points_log表数据
	 */
	public void cleanPointsLogById(Integer id) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据pointId删除points_log表数据
	 */
	public void cleanPointsLogByPointId(String pointId) {
        if (StringUtils.isBlank(pointId)){
            pointId = "test_pointId";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPointIdEqualTo(pointId);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除points_log表数据
	 */
	public void cleanPointsLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除points_log表数据
	 */
	public void cleanPointsLogByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除points_log表数据
	 */
	public void cleanPointsLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除points_log表数据
	 */
	public void cleanPointsLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除points_log表数据
	 */
	public void cleanPointsLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除points_log表数据
	 */
	public void cleanPointsLogByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除points_log表数据
	 */
	public void cleanPointsLogByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		pointsLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据instructionId删除points_log表数据
	 */
	public void cleanPointsLogByInstructionId(String instructionId) {
        if (StringUtils.isBlank(instructionId)){
            instructionId = "test_instructionId";
        }
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		pointsLogDAO.deleteByExample(exam);
	}

    /**
	 * 根据id查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogById(Integer id) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据pointId查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByPointId(String pointId) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPointIdEqualTo(pointId);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByGid(String gid) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByReqId(String reqId) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByPlatPartnerId(String platPartnerId) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByPartnerId(String partnerId) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByMerchantOrderNo(String merchantOrderNo) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByUserId(String userId) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据instructionId查询points_log表数据
	 */
	public List<PointsLogDO> findPointsLogByInstructionId(String instructionId) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		return pointsLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新points_log表数据
	 */
	public void updatePointsLogById(Integer id,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据pointId更新points_log表数据
	 */
	public void updatePointsLogByPointId(String pointId,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPointIdEqualTo(pointId);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据gid更新points_log表数据
	 */
	public void updatePointsLogByGid(String gid,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据reqId更新points_log表数据
	 */
	public void updatePointsLogByReqId(String reqId,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新points_log表数据
	 */
	public void updatePointsLogByPlatPartnerId(String platPartnerId,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新points_log表数据
	 */
	public void updatePointsLogByPlatMerchantOrderNo(String platMerchantOrderNo,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据partnerId更新points_log表数据
	 */
	public void updatePointsLogByPartnerId(String partnerId,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新points_log表数据
	 */
	public void updatePointsLogByMerchantOrderNo(String merchantOrderNo,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据userId更新points_log表数据
	 */
	public void updatePointsLogByUserId(String userId,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}

    /**
	 * 根据instructionId更新points_log表数据
	 */
	public void updatePointsLogByInstructionId(String instructionId,PointsLogDO pointsLogDO) {
		PointsLogDOExample exam = new PointsLogDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		pointsLogDAO.updateByExample(pointsLogDO, exam);
	}
}
