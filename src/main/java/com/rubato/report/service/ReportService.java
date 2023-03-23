package com.rubato.report.service;

import com.rubato.report.domain.Report;

public interface ReportService {

	/**
	 * 게시물 신고 등록 Service
	 * @param report
	 * @return
	 */
	int insertReport(Report report);

	int updateCondition(int reportNo);

}
