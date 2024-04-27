package com.BusReservation.service.ServiceImpl;

import com.BusReservation.entity.Passenger;
import com.BusReservation.service.PdfGeneratorService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService {

    @Autowired
    private JavaMailSender emailSender;

    public void generatePdf(Passenger passenger) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Define font and font size
                contentStream.setFont(PDType1Font.HELVETICA, 12);

                // Write passenger details to the PDF
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("First Name: " + passenger.getFirstName());
                contentStream.newLine();
                contentStream.showText("Last Name: " + passenger.getLastName());
                contentStream.newLine();
                contentStream.showText("Contact Number: " + passenger.getContactNumber());
                contentStream.newLine();
                contentStream.showText("Email: " + passenger.getEmail());
                contentStream.newLine();
                contentStream.showText("Date of Birth: " + passenger.getDob());
                contentStream.endText();
            }

            // Save the filled PDF document
            document.save(outputStream);

            // Send email with the attached PDF
            sendEmailWithAttachment(passenger.getEmail(), outputStream.toByteArray());

        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEmailWithAttachment(String to, byte[] attachmentContent) throws MessagingException, javax.mail.MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Your Ticket Details");
        helper.setText("Dear Passenger,\n\nPlease find attached your ticket details.\n\nRegards,\nYour Travel Company");

        helper.addAttachment("ticket_details.pdf", new ByteArrayResource(attachmentContent));

        emailSender.send(message);
    }
}
