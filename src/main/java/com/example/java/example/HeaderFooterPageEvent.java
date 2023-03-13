package com.example.java.example;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper {
	private PdfTemplate t;
	private Image total;

	public void onOpenDocument(PdfWriter writer, Document document) {
		t = writer.getDirectContent().createTemplate(30, 16);
		try {
			total = Image.getInstance(t);
			total.setRole(PdfName.ARTIFACT);
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		addHeader(writer);
		addFooter(writer);
	}

	private void addHeader(PdfWriter writer) {
		PdfPTable header = new PdfPTable(4);

		// set defaults

		header.setTotalWidth(772);
		header.setLockedWidth(true);
		header.getDefaultCell().setFixedHeight(80);
		header.getDefaultCell().setBorder(Rectangle.BOTTOM);
		header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

		// add text
		PdfPTable subHeader1 = new PdfPTable(1);
		subHeader1.addCell(headerText("COUPONS DETAILS INVOICED", 10, Element.ALIGN_LEFT, Rectangle.NO_BORDER));
		subHeader1.addCell(headerText("2. From 490 AIR SENEGAL S.A", 8, Element.ALIGN_LEFT, Rectangle.NO_BORDER));
		subHeader1.addCell(headerText("3. To 169 HAHN AIR LINES GmbH", 8, Element.ALIGN_LEFT, Rectangle.NO_BORDER));

		PdfPTable subHeader2 = new PdfPTable(1);
		subHeader2.addCell(headerText("4. Currency of listing 978(EUR)", 10, Element.ALIGN_LEFT, Rectangle.NO_BORDER));

		PdfPTable subHeader3 = new PdfPTable(1);
		subHeader3.addCell(headerText("Ref 2", 10, Element.ALIGN_LEFT, Rectangle.NO_BORDER));
		subHeader3.addCell(headerText("5. Invoice num 0021904004", 8, Element.ALIGN_LEFT, Rectangle.NO_BORDER));
		subHeader3.addCell(headerText("6. Month/Year 04/2019", 8, Element.ALIGN_LEFT, Rectangle.NO_BORDER));

		PdfPTable subHeader4 = new PdfPTable(1);
		subHeader4.addCell(headerText("1. Non sampling invoice", 10, Element.ALIGN_LEFT, Rectangle.NO_BORDER));
		subHeader4
				.addCell(headerText("7. PAGE " + writer.getPageNumber(), 10, Element.ALIGN_LEFT, Rectangle.NO_BORDER));
		subHeader4.addCell(headerText("8. Souce Code 01", 8, Element.ALIGN_LEFT, Rectangle.NO_BORDER));

		header.addCell(subHeader1);
		header.addCell(subHeader2);
		header.addCell(subHeader3);
		header.addCell(subHeader4);

		if (writer.getPageNumber() > 1) {
			// write content
			header.writeSelectedRows(0, -1, 50, 550, writer.getDirectContent());
		}

	}

	private void addFooter(PdfWriter writer) {
		PdfPTable footer = new PdfPTable(1);
		footer.setTotalWidth(772);
		footer.setLockedWidth(true);
		footer.getDefaultCell().setFixedHeight(40);
//		footer.getDefaultCell().setBorder(Rectangle.TOP);
		footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

		// add copyright
		footer.addCell(footerText("AIR SENEGAL S.A", 7, Rectangle.TOP));
		footer.addCell(footerText("9927 VND Amitie 3", 7, Rectangle.NO_BORDER));

		// add current page count

//		 write page
		PdfContentByte canvas = writer.getDirectContent();
		canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
		footer.writeSelectedRows(0, -1, 34, 50, canvas);
		canvas.endMarkedContentSequence();

	}

	public void onCloseDocument(PdfWriter writer, Document document) {
		int totalLength = String.valueOf(writer.getPageNumber()).length();
		int totalWidth = totalLength * 5;
		ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
				new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)), totalWidth,
				6, 0);
	}

	public static PdfPCell footerText(String text, int fontSize, int Border) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5.0f);
		cell.setBorderColor(BaseColor.DARK_GRAY);
		cell.setBorder(Border);
		return cell;
	}

	public static PdfPCell headerText(String text, int fontSize, int Alignment, int Border) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Alignment);
		cell.setPadding(5.0f);
		cell.setBorderColor(BaseColor.DARK_GRAY);
		cell.setBorder(Border);
		return cell;
	}

}
