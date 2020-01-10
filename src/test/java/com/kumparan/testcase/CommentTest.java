package com.kumparan.testcase;

import com.kumparan.TestInstrument;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CommentTest extends TestInstrument {

    @AfterMethod
    public void goToForYouTab() {
        kumparan.newsPage().goToForYouTab();
    }

    @Test
    public void commnetViaThumbnailWithoutLogin() {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().clearCache();
        kumparan.forYouPage().isOnForYouPage();
        kumparan.forYouPage().swipeToBottomPage();
        kumparan.forYouPage().tapOnButtonComment();
        kumparan.komentarPage().isOnKomentarPage();
        kumparan.komentarPage().typeOnTulisKomentar("tulis tulis");
        kumparan.komentarPage().tapOnSendButton();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().login("nanmaidabu", "rahasiadong");
    }
}
