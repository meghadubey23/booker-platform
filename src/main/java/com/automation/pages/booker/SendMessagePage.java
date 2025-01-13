package com.automation.pages.booker;

import com.automation.data.BaseData;
import com.automation.data.booker.SendMessageData;
import com.automation.elements.Button;
import com.automation.elements.TextBox;
import com.automation.pages.BasePage;
import org.openqa.selenium.By;

public class SendMessagePage extends BasePage {

    private TextBox name = new TextBox(By.id("name"));
    private TextBox email = new TextBox(By.id("email"));
    private TextBox phone = new TextBox(By.id("phone"));
    private TextBox emailSubject = new TextBox(By.id("subject"));
    private TextBox emailBody = new TextBox(By.id("description"));
    private Button submit = new Button(By.id("submitContact"));

    public TextBox getName() {
        return name;
    }

    public TextBox getEmail() {
        return email;
    }

    public TextBox getPhone() {
        return phone;
    }

    public TextBox getEmailSubject() {
        return emailSubject;
    }

    public TextBox getEmailBody() {
        return emailBody;
    }

    public Button getSubmit() {
        return submit;
    }

    @Override
    public void fillout(BaseData bData) {
        if (bData != null) {
            SendMessageData data = (SendMessageData) bData;
            getName().set(data.getName());
            getEmail().set(data.getEmail());
            getPhone().set(data.getPhone());
            getEmailSubject().set(data.getEmailSubject());
            getEmailBody().set(data.getEmailBody());
            getSubmit().set(data.getSubmit());

            verifySuccessMessage(data.getSuccessMessage());
        }
    }

    @Override
    public void verify(BaseData bData) {
    }
}
