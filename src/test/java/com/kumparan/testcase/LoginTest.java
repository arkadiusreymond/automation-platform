package com.kumparan.testcase;

import com.kumparan.TestInstrument;
import org.testng.annotations.Test;
public class LoginTest extends TestInstrument {

    @Test()
    public void loginGoogleTest()  {
        kumparan.pilihKanalPage().isOnPilihKanalPage();
        kumparan.pilihKanalPage().tapOnKanalNews();
        kumparan.pilihKanalPage().tapOnKanalOtomotif();
        kumparan.pilihKanalPage().tapOnKanalBisnis();
        kumparan.pilihKanalPage().tapOnSelanjutnyaButton();
        kumparan.forYouPage().isOnForYouPage();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageBeforeLogin();
        kumparan.menuPage().tapOnGooleButton();
        kumparan.menuPage().isPopUpGoogleShow();
        kumparan.menuPage().tapOnEmailTextView();
        kumparan.menuPage().isOnMenuPageAfterLogin();
    }
}