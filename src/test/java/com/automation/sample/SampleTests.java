package com.automation.sample;

import com.automation.BaseTest;
import com.automation.data.booker.SendMessageData;
import com.automation.entity.booker.BookerEntity;
import org.testng.annotations.Test;

public class SampleTests extends BaseTest {

    @Test(description = "Send an enquiry")
    public void dashboardTest() {
        SendMessageData data = new SendMessageData();
        data.setName("Megha");
        data.setEmail("meghaa.dubey@gmail.com");
        data.setPhone("+1-781-579-4719");
        data.setEmailSubject("Send an enquiry test Case - Subject");
        data.setEmailBody("Send an enquiry test Case - Body");
        data.setSubmit(true);
        data.setSuccessMessage(String.format("Thanks for getting in touch %s!\n" +
                "We'll get back to you about\n" +
                "%s\n" +
                "as soon as possible.", data.getName(), data.getEmailSubject()));

        BookerEntity entity = new BookerEntity(data);
        entity.create();
    }
}
