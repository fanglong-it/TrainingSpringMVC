package com.example.java.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.example.java.model.Subject;

public class SubjectListExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HSSFSheet excelSheet = (HSSFSheet) workbook.createSheet("Subject List");
		setExcelHeader(excelSheet);

		List<Subject> subjects = (List<Subject>) model.get("subjectList");
		setExcelRows(excelSheet, subjects);
	}

	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("ID");
		excelHeader.createCell(1).setCellValue("Name");
		excelHeader.createCell(2).setCellValue("Description");
		excelHeader.createCell(3).setCellValue("Image");
		excelHeader.createCell(4).setCellValue("Date");
	}

	public void setExcelRows(HSSFSheet excelSheet, List<Subject> subjects) {
		int record = 1;
		for (Subject subject : subjects) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(subject.getId());
			excelRow.createCell(1).setCellValue(subject.getName());
			excelRow.createCell(2).setCellValue(subject.getDescription());
			excelRow.createCell(3).setCellValue(subject.getUrlImage());
			excelRow.createCell(4).setCellValue(subject.getDate());
		}
	}

}
