package com.automation.entity;

import com.automation.pages.BasePage;

public abstract class BaseEntity {

    public abstract BasePage navigation();

    public abstract void create();

    public abstract void verify();
}
