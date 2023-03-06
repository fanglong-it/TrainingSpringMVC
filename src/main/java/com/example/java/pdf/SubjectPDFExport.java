package com.example.java.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Phaser;

import javax.servlet.http.HttpServletResponse;

import com.example.java.model.Subject;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class SubjectPDFExport {
	private List<Subject> subjects;

	public SubjectPDFExport(List<Subject> subjects) {
		this.subjects = subjects;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.blue);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.white);

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
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.blue);

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
