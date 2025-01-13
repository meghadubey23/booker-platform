package com.automation.tests;

import com.automation.BaseTest;
import com.automation.data.booker.SendMessageData;
import com.automation.entity.booker.BookerEntity;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SampleTests extends BaseTest {

    @Test(description = "Send an enquiry")
    public void enquiryTest() {
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

    @Test
    public void testPass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFail() {
        Assert.fail("This test is supposed to fail");
    }

    @Test
    public void testSkip() {
        throw new SkipException("This test is skipped");
    }
}
