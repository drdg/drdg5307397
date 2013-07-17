package com.sino.elearning.studyrecord.service.Impl;


import java.util.List;

import com.sino.elearning.studyrecord.Dao.IResultRecordDao;
import com.sino.elearning.studyrecord.bean.EResultsRecord;
import com.sino.elearning.studyrecord.service.IResultRecordService;

public class ResultRecordServiceImpl implements IResultRecordService{

	public long saveResult(EResultsRecord result) throws Exception {
		// TODO Auto-generated method stub
		return resultDao.saveResult(result);
	}
	public List<EResultsRecord> findByProId(long id, String studyType,Long userId)
			throws Exception {
		return resultDao.findByProId(id, studyType,userId);
	}
	public void updateResult(EResultsRecord result) throws Exception {
		 resultDao.updateResult(result);
	}
	IResultRecordDao resultDao;
	public IResultRecordDao getResultDao() {
		return resultDao;
	}

	public void setResultDao(IResultRecordDao resultDao) {
		this.resultDao = resultDao;
	}
	

	
	
}
