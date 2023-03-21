package com.rubato.report.store;

import com.rubato.report.domain.Report;

public interface ReportStore {

	/**
	 * 게시물 신고 등록 Store
	 * @param report
	 * @return
	 */
	int insertReport(Report report);

	int updateCondition(int reportNo);

}
