package com.example.java.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageInPDF {
	public static void main(String[] args) {
		new ImageInPDF().setImageInPDF("./Test/image.pdf");
	}

	public static PdfPCell getIRDCell(String text) {
		PdfPCell cell = new PdfPCell(new Paragraph(text));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5.0f);
		cell.setBorderColor(BaseColor.LIGHT_GRAY);
		return cell;
	}

	public static PdfPCell getIRDCellCustomRight(String text, int Border) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPadding(5.0f);
		cell.setBorder(Border);
		return cell;
	}

//	public static PdfPCell getIRDCellCustomRight(String text, int Border, int fontSize) {
//		FontSelector fs = new FontSelector();
//		Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize);
//		fs.addFont(font);
//		Phrase phrase = fs.process(text);
//		PdfPCell cell = new PdfPCell(phrase);
//		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		cell.setPadding(5.0f);
//		cell.setBorder(Border);
//		return cell;
//	}

	public static PdfPCell getIRDCellCustomLeft(String text, int Border) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setPadding(5.0f);
		cell.setBorder(Border);
		return cell;
	}

	public static PdfPCell getIRDCellCustomLeft(String text, int Border, int fontSize) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setPadding(5.0f);
		cell.setBorder(Border);
		return cell;
	}

	public static PdfPCell getIRDCellCustomRight(String text, int Border, int fontSize) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPadding(5.0f);
		cell.setBorder(Border);
		return cell;
	}

	public static PdfPCell getIRHCell(String text, int alignment) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setPadding(5);
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPTable getWhiteSpace(int row) {
		PdfPTable whiteSpace = new PdfPTable(1);
		for (int i = 0; i < row; i++) {
			whiteSpace.addCell(getIRHCell(" ", Element.ALIGN_CENTER));
		}
		return whiteSpace;
	}

	public static PdfPTable getFooter() {
		PdfPTable footer = new PdfPTable(1);
		footer.addCell(getIRHCell("AIR SENEGAL S.A", Element.ALIGN_CENTER));
		footer.addCell(getIRHCell("9927 VDN Amitie 3", Element.ALIGN_CENTER));
		return footer;
	}

	public static PdfPTable header1() {
		PdfPTable pheader1 = new PdfPTable(1);
		pheader1.getDefaultCell().setBorder(0);
		pheader1.addCell(getIRDCellCustomLeft("INVOICE SUMMERY", PdfPCell.NO_BORDER));
		pheader1.addCell(getIRDCellCustomLeft("1. From 0490 AIR SENEGAL S.A", PdfPCell.NO_BORDER, 8));
		pheader1.addCell(getIRDCellCustomLeft("2. To 0169 HAHN AIR LINES GmbH", PdfPCell.NO_BORDER, 8));

		PdfPTable pheader2 = new PdfPTable(1);
		pheader2.getDefaultCell().setBorder(0);
		pheader2.addCell(getIRDCellCustomLeft("3. Invoice num 0021293102", PdfPCell.NO_BORDER, 8));
		pheader2.addCell(getIRDCellCustomLeft("4. Month/Year 04/2010", PdfPCell.NO_BORDER, 8));
		pheader2.addCell(getIRDCellCustomLeft("978(EUR)", PdfPCell.NO_BORDER, 8));
		pheader2.addCell(getIRDCellCustomLeft("B", PdfPCell.NO_BORDER, 8));

		PdfPTable pheader3 = new PdfPTable(1);
		pheader3.getDefaultCell().setBorder(0);
		pheader3.addCell(getIRDCellCustomLeft("Ref 1", PdfPCell.NO_BORDER));
		pheader3.addCell(getIRDCellCustomLeft("5. Currency of billing", PdfPCell.NO_BORDER));
		pheader3.addCell(getIRDCellCustomLeft("5A. Settlement method", PdfPCell.NO_BORDER));

		PdfPTable pdfPTable = new PdfPTable(5);
		pdfPTable.setWidthPercentage(100);
		pdfPTable.getDefaultCell().setBorder(0);

		pdfPTable.addCell(pheader1);
		pdfPTable.addCell(getIRHCell(" ", Element.ALIGN_CENTER));
		pdfPTable.addCell(pheader2);
		pdfPTable.addCell(getIRHCell(" ", Element.ALIGN_CENTER));
		pdfPTable.addCell(pheader3);
		return pdfPTable;
	}

	public static PdfPTable body1() {

		PdfPTable pdfPTable = new PdfPTable(new float[] { 0.7f, 1.1f, 1.8f, 1.2f, 1.6f, 1.4f, 1.3f, 1.3f, 0f });
		pdfPTable.setWidthPercentage(90);

		pdfPTable.addCell(getIRDCellCustomRight("PAGE", 5));
		pdfPTable.addCell(getIRDCellCustomRight("DEBITS", 5));
		pdfPTable.addCell(getIRDCellCustomRight("Gross amount", 5));
		pdfPTable.addCell(getIRDCellCustomRight("Tax", 5));
		pdfPTable.addCell(getIRDCellCustomRight("VAT Amount", 5));
		pdfPTable.addCell(getIRDCellCustomRight("Com amount", 5));
		pdfPTable.addCell(getIRDCellCustomRight("VAT/Com", 5));
		pdfPTable.addCell(getIRDCellCustomRight("Net total", 5));
		pdfPTable.addCell(getIRDCellCustomRight("", 5));

		// data
		pdfPTable.addCell(getIRDCellCustomRight("6", 5));
		pdfPTable.addCell(getIRDCellCustomRight("6A", 5));
		pdfPTable.addCell(getIRDCellCustomRight("7", 5));
		pdfPTable.addCell(getIRDCellCustomRight("8", 5));
		pdfPTable.addCell(getIRDCellCustomRight("8", 5));
		pdfPTable.addCell(getIRDCellCustomRight("9", 5));
		pdfPTable.addCell(getIRDCellCustomRight("12", 5));
		pdfPTable.addCell(getIRDCellCustomRight("13", 5));
		pdfPTable.addCell(getIRDCellCustomLeft("", 5));
		// total
		pdfPTable.addCell(getIRDCellCustomRight("", 5));
		pdfPTable.addCell(getIRDCellCustomRight("2041", 5));
		pdfPTable.addCell(getIRDCellCustomRight("257072.37", 5));
		pdfPTable.addCell(getIRDCellCustomRight("141612.27", 5));
		pdfPTable.addCell(getIRDCellCustomRight("0.00", 5));
		pdfPTable.addCell(getIRDCellCustomRight("0.00", 5));
		pdfPTable.addCell(getIRDCellCustomRight("0.00", 5));
		pdfPTable.addCell(getIRDCellCustomRight("398684.64", 5));
		pdfPTable.addCell(getIRDCellCustomLeft("", 5));

		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));
		pdfPTable.addCell(getIRDCellCustomRight("", 2));

		return pdfPTable;

	}

	public static PdfPTable mainTable() throws DocumentException {

		PdfPTable mainTable = new PdfPTable(16);
		mainTable.getDefaultCell().setFixedHeight(10f);
		mainTable.setWidthPercentage(100f);
		mainTable.setWidths(new float[] { 0.7f, 1.8f, 0.7f, 1.0f, 0.7f, 0.9f, 0.7f, 0.9f, 0.7f, 0.9f, 0.8f, 2f, 1.3f,
				1.4f, 1f, 1.6f });
		mainTable.addCell(getIRDCellCustomRight("CP", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("Ticket number", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("CK", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("Gross amt", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("Tax", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("VAT amt", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("VAT%", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("Com amt", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("AJ", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("VAT/Com", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("Net amt", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("Date & flight num", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomLeft("Fare", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("Gross amt orig", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("currency", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("SAC reference", com.itextpdf.text.Rectangle.NO_BORDER, 7));

		// Detail number
		mainTable.addCell(getIRDCellCustomRight("10", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("11", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("12", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("13", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("14", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("14", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("15", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("16", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("21", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("22", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("23", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));

		// Break Line
		mainTable.addCell(getIRDCellCustomRight(" ", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));

		for (int i = 0; i < 18; i++) {

			// Fill Data
			mainTable.addCell(getIRDCellCustomRight(" " + i, com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("1693213192391239", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("0", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("29.96", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("11.91", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("0.00", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("0.00", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("0.00", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("0.00", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("41.87", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("290419 DSS CDG 00403", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomLeft("L-LPXSN", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("6329.12", com.itextpdf.text.Rectangle.NO_BORDER, 7));
			mainTable.addCell(getIRDCellCustomRight("49018OAZL1EB1", com.itextpdf.text.Rectangle.NO_BORDER, 7));
		}
		return mainTable;
	}

	public static PdfPTable totalOfTable(PdfWriter writer) throws DocumentException {
		// Total
		PdfPTable totalPage = new PdfPTable(15);
		totalPage.setWidths(
				new float[] { 2.5f, 0.7f, 1.0f, 0.7f, 0.9f, 0.7f, 0.9f, 0.7f, 0.9f, 0.8f, 2f, 1.3f, 1.4f, 1f, 1.6f });
		totalPage.setWidthPercentage(100f);
		totalPage.addCell(getIRDCellCustomLeft("24.TOTAL PAGE", 0, 9));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("2149.86", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("0.00", 0, 7));
		totalPage.addCell(getIRDCellCustomLeft("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("0.00", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("0.00", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("0.00", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("3807.60", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));

		totalPage.addCell(getIRDCellCustomLeft("25.Number of docs "+ writer.getPageNumber(), 0, 8));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomLeft("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		totalPage.addCell(getIRDCellCustomRight("", 0, 7));
		return totalPage;
	}

	private void setImageInPDF(String PDFPath) {
		try {
			Font font = new Font();
			Document doc = new Document(PageSize.A4.rotate());
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(PDFPath));

			// event
			HeaderFooterPageEvent even = new HeaderFooterPageEvent();
			writer.setPageEvent(even);
			Image image = Image.getInstance(
					"D:\\Longpc\\Source Code\\eclipse-workspace\\mvcdemo\\src\\main\\resources\\Capture.PNG");
			doc.open();
			PdfPTable irdTable = new PdfPTable(2);
			irdTable.addCell(getIRDCellCustomRight("", PdfPCell.NO_BORDER));
			irdTable.addCell(getIRDCellCustomLeft("Date: 25-12-2000", PdfPCell.NO_BORDER));
			irdTable.addCell(getIRDCellCustomRight("", PdfPCell.NO_BORDER));
			irdTable.addCell(getIRDCellCustomLeft("invoicing Period: 09/2019", PdfPCell.NO_BORDER));

			PdfPTable irhTable = new PdfPTable(2);
			irhTable.setWidthPercentage(100);
			irhTable.getDefaultCell().setBorder(0);
			PdfPCell imageCell = new PdfPCell(image);
			imageCell.setFixedHeight(60);
			imageCell.setBorder(0);
			irhTable.addCell(imageCell);
			irhTable.addCell(irdTable);

			// Image with Date
			doc.add(irhTable);
			PdfPTable whiteSpace = getWhiteSpace(1);

			// White Space:
			doc.add(whiteSpace);

			PdfPTable InvoiceText = new PdfPTable(2);
			InvoiceText.addCell(getIRHCell("", Element.ALIGN_CENTER));
			InvoiceText.getDefaultCell().setBorder(0);
			font = new Font();
			font.setSize(30);
			font.setStyle(Font.BOLD);
			PdfPCell text = new PdfPCell(new Phrase("INVOICE", font));
			text.setBorder(0);
			text.setHorizontalAlignment(Element.ALIGN_LEFT);
			InvoiceText.addCell(text);

			// Invoice Text
			doc.add(InvoiceText);

			// Add white Space
			doc.add(getWhiteSpace(2));

			PdfPTable subAddress = new PdfPTable(1);
			subAddress.addCell(getIRDCellCustomLeft("HAHN AIRT LINES gmbs", PdfPCell.NO_BORDER));
			subAddress.addCell(getIRDCellCustomLeft("REVENUE ACCOUNTING", PdfPCell.NO_BORDER));
			subAddress.addCell(getIRDCellCustomLeft("An Der Trift 65", PdfPCell.NO_BORDER));
			PdfPTable address = new PdfPTable(2);
			address.getDefaultCell().setBorder(0);
			address.addCell(getIRDCellCustomRight("", PdfPCell.NO_BORDER));
			address.addCell(subAddress);

			// Add Address
			doc.add(address);

			doc.add(getWhiteSpace(1));

			doc.add(header1());

			doc.add(getWhiteSpace(1));

			doc.add(body1());

			doc.add(getWhiteSpace(4));

			
			for (int i = 0; i < 3; i++) {

				doc.newPage();
				doc.add(new Paragraph("\n"));
				doc.add(new Paragraph("\n"));
				doc.add(new Paragraph("\n"));
				doc.add(new Paragraph("\n"));
				doc.add(new Paragraph("\n"));
				doc.add(mainTable());
				doc.add(totalOfTable(writer));

			}

			doc.close();
			writer.close();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
