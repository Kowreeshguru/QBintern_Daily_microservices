package com.quinbay.mailService.Interface;

import com.quinbay.mailService.models.MailDetails;

public interface MailInterface {


    String sendMailWithAttachment(MailDetails details);
}


