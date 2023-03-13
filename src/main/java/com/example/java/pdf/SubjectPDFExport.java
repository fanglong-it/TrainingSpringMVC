package com.example.java.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Phaser;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HeaderFooter;

import com.example.java.model.Subject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SubjectPDFExport {
	private List<Subject> subjects;

	public SubjectPDFExport(List<Subject> subjects) {
		this.subjects = subjects;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();

		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);

		cell.setPhrase(new Phrase("Id", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Description", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Image", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("date", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (Subject subject : subjects) {

			table.addCell(String.valueOf(subject.getId()));
			table.addCell(subject.getName());
			table.addCell(subject.getDescription());
			table.addCell(subject.getUrlImage());
			table.addCell(subject.getDate());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4.rotate());

		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

//		ImageData

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
//		font.setColor(Color.blue);

		Paragraph p = new Paragraph("List of Subjects", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();

	}

}
