package com.quinbay.mailService.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.quinbay.mailService.Interface.MailInterface;
import com.quinbay.mailService.Kafka.KafkaListenerService;
import com.quinbay.mailService.models.BillDetails;
import com.quinbay.mailService.models.MailDetails;

import com.quinbay.mailService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
// Annotation
@Service
// Class
// Implementing EmailService interface
public class MailOp implements MailInterface {

    @Autowired private JavaMailSender javaMailSender;
    @Autowired
    KafkaListenerService kafkaListenerService;

    @Value("${spring.mail.username}") private String sender;

    String filename;


    public String sendMailWithAttachment(MailDetails details)
    {
        try {
            generate_Bill_wholesaler(kafkaListenerService.bill);
        }catch(Exception e){}
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(filename));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }

    }
    void generate_Bill_wholesaler(BillDetails bill) throws IOException, DocumentException {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Bill_"+bill.getClientName()+".pdf"));
            filename="/Users/kowreesh/IdeaProjects/Day5/Bill_"+bill.getClientName()+".pdf";
            document.open();
            document.add(new Paragraph("Welcome - " + bill.getClientName()));
            document.add(new Paragraph("Product_Id" + " \t " + "Product_Name"+ " \t " + "Quntity"+" \t "+"Total_price"+" \t "+"After_Discount"+" \t "+"GST"+"\t "+"After_Gst"));
            document.add(new Paragraph( bill.getP_id() + " \t " + bill.getP_name()+ " \t " + "20"+" \t "+bill.getP_price()+" \t "+bill.getAft_dis()+" \t "+bill.getAft_gst()+"%"+"\t "+bill.getAft_gst()));
            document.add(new Paragraph("***** Thank you - Visit again *****"));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
