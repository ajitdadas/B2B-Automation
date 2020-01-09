package com.cisco.b2b.auotomation.ngc.report;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.ngc.constants.NGCConstants;

public class EmailReport {
	
	Logger LOGGER = LogManager.getLogger(EmailReport.class);

    /** Send execution report in mail **/
    public void sendReportInMail() {

        try {
            final String username = CommonConstants.USERNAME;
            final String password = CommonConstants.PASSWORD;

            final Properties props = new Properties();
            props.put(CommonConstants.MAIL_SMTP_AUTH, CommonConstants.TRUE);
            props.put(CommonConstants.MAIL_SMTP_STARTTLS_ENABLE, CommonConstants.FALSE);
            props.put(CommonConstants.MAIL_SMTP_HOST, CommonConstants.CISCO_HOST);

            final Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CommonConstants.USER_MAILID));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(CommonConstants.USER_MAILID));
            message.setSubject(NGCConstants.NGC_REPORT_SUBJECT);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(NGCConstants.NGC_REPORT_MAILBODY);
            final Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();

            final String filename = CommonConstants.REPORT_FILENAME;
            final DataSource source = new FileDataSource(CommonConstants.REPORT_FILEPATH);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            LOGGER.info("Mail sent successfully!");
        } catch (final Exception e) {
        	LOGGER.error(e.getMessage());
        }
    }

}
