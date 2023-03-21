package com.rubato.report.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.report.domain.Report;
import com.rubato.report.service.ReportService;
import com.rubato.report.store.ReportStore;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportStore rStore;

	@Override
	public int insertReport(Report report) {
		int result = rStore.insertReport(report);
		return result;
	}

	@Override
	public int updateCondition(int reportNo) {
		int result = rStore.updateCondition(reportNo);
		return result;
	}
}
