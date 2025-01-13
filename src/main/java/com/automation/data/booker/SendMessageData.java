package com.automation.data.booker;

import com.automation.data.BaseData;

public class SendMessageData extends BaseData {

    private String name;
    private String email;
    private String phone;
    private String emailSubject;
    private String emailBody;
    private Boolean submit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public Boolean getSubmit() {
        return submit;
    }

    public void setSubmit(Boolean submit) {
        this.submit = submit;
    }
}
