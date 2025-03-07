package org.example;

import org.example.pages.AddCandidatePage;
import org.example.pages.LoginPage;
import org.example.pages.RecruitmentPage;
import org.example.utils.PropertyUtils;
import org.testng.annotations.Test;

public class AddCandidateTest extends BaseTest{
    @Test
    public void addCandidateTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        String username = PropertyUtils.getProperty("user.name");
        String password = PropertyUtils.getProperty("user.password");
        loginPage.login(username, password);

        recruitmentPage.goToRecruitmentPage();

        addCandidatePage.goToAddCandidatePage();
        addCandidatePage.addCandidate("Lorem", "Ipsum", "Nose", "mau@si.com", "1234567890");


        Thread.sleep(10000);
    }
}
