package com.automation.entity.booker;

import com.automation.data.booker.SendMessageData;
import com.automation.entity.BaseEntity;
import com.automation.pages.booker.SendMessagePage;

public class BookerEntity extends BaseEntity {

    SendMessageData data;

    public BookerEntity(SendMessageData data) {
        this.data = data;
    }

    public SendMessagePage navigation() { //TODO: Add navigation path
        return new SendMessagePage();
    }

    public void create() {
        navigation().fillout(data);  //TODO: Add navigation path and access the fillout method of the pages
    }

    public void verify() {
        navigation().verify(data); //TODO: Add navigation path and access the verify method of the pages
    }
}
