package com.quinbay.mailService.models;

public class MailDetails {
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
//
//    public String getAttachment() {
//        return attachment;
//    }
//
//    public void setAttachment(String attachment) {
//        this.attachment = attachment;
//    }

    MailDetails(){}
    MailDetails(String recipient,String msgBody,String subject,String attachment){
        this.recipient=recipient;
        this.msgBody=msgBody;
        this.subject=subject;
//        this.attachment=attachment;
    }

    private String recipient;
    private String msgBody;
    private String subject;

}
