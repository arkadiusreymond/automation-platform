package com.kumparan.testcase;

import com.kumparan.TestInstrument;
import org.testng.annotations.Test;

public class CommentTest extends TestInstrument {

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
    }
}
