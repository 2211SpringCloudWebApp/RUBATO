package com.rubato.report.store.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubato.report.domain.Report;
import com.rubato.report.store.ReportStore;

@Repository
public class ReportStoreImpl implements ReportStore{

	@Autowired
	private SqlSession session;

	@Override
	public int insertReport(Report report) {
		int result = session.insert("ReportMapper.insertReport", report);
		return result;
	}

	@Override
	public int updateCondition(int reportNo) {
		int result = session.update("ReportMapper.updateCondition", reportNo);
		return result;
	}
}
