package com.example.java.excel;

import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public class CreateExcelFile {

	public static HSSFCellStyle getStyle(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		return style;
	}

	public static HSSFCellStyle getStyleNoBorderBotton(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		return style;
	}

	public static HSSFCellStyle getStyleBorderBottomDot(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		style.setBorderBottom(BorderStyle.DOTTED);
		return style;
	}

	public static HSSFCellStyle getStyleForInfo(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		return style;
	}

	public static HSSFCellStyle getStyleBorderLeft(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);

		return style;
	}

	public static HSSFCellStyle getStyleBorderRight(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		return style;
	}

	public static HSSFCellStyle getStyleBorderRightBorderBottomDot(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.DOTTED);
		return style;
	}

	public static HSSFCellStyle getStyleBorderRightNoBorderBottom(HSSFWorkbook workbook, short indexedColors) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(indexedColors);
		style.setBorderRight(BorderStyle.THIN);
		return style;
	}

	public static void createInforHeader(String address, String to, String from, String editionDate, HSSFSheet sheet,
			HSSFCellStyle style) {
		HSSFRow detailInfo1 = sheet.createRow(0);
		detailInfo1.createCell(0).setCellValue("" + address);
		detailInfo1.createCell(1).setCellValue("");
		detailInfo1.createCell(2).setCellValue("");
		detailInfo1.getCell(0).setCellStyle(style);
		detailInfo1.getCell(1).setCellStyle(style);
		detailInfo1.getCell(2).setCellStyle(style);

		HSSFRow detailInfo2 = sheet.createRow(1);
		detailInfo2.createCell(0).setCellValue("" + to);
		detailInfo2.createCell(1).setCellValue("");
		detailInfo2.createCell(2).setCellValue("");
		detailInfo2.getCell(0).setCellStyle(style);
		detailInfo2.getCell(1).setCellStyle(style);
		detailInfo2.getCell(2).setCellStyle(style);

		HSSFRow detailInfo3 = sheet.createRow(2);
		detailInfo3.createCell(0).setCellValue("Period from");
		detailInfo3.createCell(1).setCellValue("");
		detailInfo3.createCell(2).setCellValue("" + from);
		detailInfo3.getCell(0).setCellStyle(style);
		detailInfo3.getCell(1).setCellStyle(style);
		detailInfo3.getCell(2).setCellStyle(style);

		HSSFRow detailInfo4 = sheet.createRow(3);
		detailInfo4.createCell(0).setCellValue("Date edition:" + editionDate);
		detailInfo4.createCell(1).setCellValue("");
		detailInfo4.createCell(2).setCellValue("23/05/2022 17:41:57");
		detailInfo4.getCell(0).setCellStyle(style);
		detailInfo4.getCell(1).setCellStyle(style);
		detailInfo4.getCell(2).setCellStyle(style);

	}

	public static void createHeaderSummary(String[] headers, HSSFWorkbook workbook, HSSFSheet sheet, short COLOR_GREY) {
		HSSFRow header = sheet.createRow(6);
		for (int i = 0; i < headers.length; i++) {
			if (i != 0 && i != 11 && i != 16 && i != 19) {
				header.createCell(i).setCellValue("" + headers[i]);
				header.getCell(i).setCellStyle(getStyle(workbook, COLOR_GREY));

			} else {
				header.createCell(i).setCellValue("" + headers[i]);
				header.getCell(i).setCellStyle(getStyleBorderRight(workbook, COLOR_GREY));

			}

		}
	}

	public static void createHeaderDetails(String[] headers, HSSFWorkbook workbook, HSSFSheet sheet, short COLOR) {
		HSSFRow header2 = sheet.createRow(0);
		header2.setHeight((short) (2 * 256));
		for (int i = 0; i < headers.length; i++) {

			if (i != 0 && i != 11 && i != 16 && i != 19) {
				header2.createCell(i).setCellValue("" + headers[i]);
				header2.getCell(i).setCellStyle(getStyle(workbook, COLOR));
			} else {
				header2.createCell(i).setCellValue("" + headers[i]);
				header2.getCell(i).setCellStyle(getStyleBorderRight(workbook, COLOR));
			}
		}

	}

	public static void addDetails(String[] details, HSSFWorkbook workbook, HSSFSheet sheet, short COLOR, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		row.setHeight((short) (1 * 256));
		for (int i = 0; i < details.length; i++) {
			if (i != 0 && i != 11 && i != 16 && i != 19) {
				row.createCell(i).setCellValue(details[i]);
				row.getCell(i).setCellStyle(getStyleBorderBottomDot(workbook, COLOR));

			} else {
				row.createCell(i).setCellValue(details[i]);
				row.getCell(i).setCellStyle(getStyleBorderRightBorderBottomDot(workbook, COLOR));
			}

			if (i == 17) {
				row.getCell(i).setCellValue(String.valueOf(calculateTotalCANET(details)));
				row.getCell(i).setCellStyle(getStyleBorderBottomDot(workbook, IndexedColors.RED.getIndex()));
			}
			if (i == 18) {
				row.getCell(i).setCellValue(String.valueOf(calculateTotalTaxes(details)));
				row.getCell(i).setCellStyle(getStyleBorderBottomDot(workbook, IndexedColors.RED.getIndex()));

			}
			if (i == 19) {
				Double CANET = Double.valueOf(row.getCell(i - 2).getStringCellValue());
				Double TAXES = Double.valueOf(row.getCell(i - 1).getStringCellValue());
				row.getCell(i).setCellValue(String.valueOf(CANET + TAXES));
				row.getCell(i)
						.setCellStyle(getStyleBorderRightBorderBottomDot(workbook, IndexedColors.YELLOW.getIndex()));
			}

		}

	}

	public static double calculateTotalCANET(String[] details) {
		double total = 0;
		for (int i = 1; i < 12; i++) {
			total += Double.valueOf(details[i]);
		}
		return total;
	}

	public static double calculateTotalTaxes(String[] details) {
		double total = 0;
		for (int i = 12; i < 17; i++) {
			total += Double.valueOf(details[i]);
		}
		return total;

	}

	public static void calculateSummary(String[] summaryHeaders, HSSFSheet detail, HSSFRow summaryData,
			int numberOfRowDetail) {
		double totalCellData = 0;
		for (int i = 1; i < summaryHeaders.length; i++) {
			totalCellData = 0;
			for (int j = 1; j <= numberOfRowDetail; j++) {
				HSSFRow dataRow = detail.getRow(j);
				double cellData = Double.valueOf(dataRow.getCell(i).getStringCellValue());
				totalCellData += cellData;
			}
			summaryData.createCell(i).setCellValue("" + totalCellData);
		}
	}

	public static void main(String[] args) {
		final short COLOR_GREY = IndexedColors.GREY_25_PERCENT.getIndex();
		final short COLOR_WHITE = IndexedColors.WHITE.getIndex();

		try {
			String filename = "./Test/Balance.xlsx";
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet summary = workbook.createSheet("Summary");
			summary.setDisplayGridlines(false);
			HSSFSheet detail = workbook.createSheet("Detail");
			detail.setDisplayGridlines(false);

			for (int i = 0; i < 20; i++) {
				summary.setColumnWidth(i, 40 * 256);
				detail.setColumnWidth(i, 40 * 256);

			}

			// create detail Header Information
			createInforHeader("490 AIR SENEGAL S.A", "CHIFFRE D'AFAIRES COLE PAR SEGMENT", "01/01/2021 au 31/01/2021",
					"23/02/2022 17:41:57", summary, getStyleForInfo(workbook, COLOR_GREY));

			// Summary header
			String[] summaryHeaders = { "", "NB(non GP/INF)", "NB.GP", "NB INF", "NB", "CA NET", "TAXES", "YQ", "YR",
					"PAX CP", "CA BRUT", "MOYEN NET/CPN", "Nombre de MCO", "CA MCO Net/Brut", "TAXES MCO", "CA MCO",
					"MOYEN NET/ CPN MCO", "TOTAL CA NET", "TOTAL TAXES", "TOTAL CA BRUT" };
			createHeaderSummary(summaryHeaders, workbook, summary, COLOR_GREY);

			// Detail Page Header
			String[] detailHeaders = { "SEGMENT", "Nb (non GP/INF)", "NB.GP", "NB INF", "NB", "CA NET", "TAXES", "YQ",
					"YR", "PAX CP", "CA BRUT", "MOYEN NET/CPN", "Nombre de MCO", "CA MCO Net/Brut", "TAXES MCO",
					"CA MCO", "MOYEN NET/ CPN MCO", "TOTAL CA NET", "TOTAL TAXES", "TOTAL CA BRUT" };
			createHeaderDetails(detailHeaders, workbook, detail, COLOR_GREY); // Detail Page Data

			// Add data to Detail
			String[] dataDetails = { "CDG-DSS", "1232", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "35000",
					"0", "35000", "35000", "35000", "0", "35000" };
			String[] dataDetails2 = { "DSS-BKO", "2", "36000", "0", "2", "94400", "199400", "30000", "10000", "0",
					"293800", "47200", "1", "35000", "0", "35000", "35000", "123", "1993113", "2123" };
			String[] dataDetails3 = { "DSS-CDG", "0", "0", "0", "0", "123", "0", "0", "789", "0", "0", "123123", "1",
					"35000", "0", "551000", "1212", "35000", "0", "35000" };

			addDetails(dataDetails, workbook, detail, COLOR_WHITE, 1);
			addDetails(dataDetails2, workbook, detail, COLOR_WHITE, 2);
			addDetails(dataDetails3, workbook, detail, COLOR_WHITE, 3);

			System.out.println("Number of row: " + detail.getLastRowNum());
			int numberOfDetailRow = detail.getLastRowNum();

			// Total Data of summary header
			HSSFRow summaryData = summary.createRow(7);
			summaryData.createCell(0).setCellValue("GRAND TOTAL");
			calculateSummary(summaryHeaders, detail, summaryData, numberOfDetailRow);

			FileOutputStream fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();

			workbook.close();
			System.out.println("Excel file has been generated successfully.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
