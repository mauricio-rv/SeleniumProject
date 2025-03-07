package org.example;

import org.example.pages.AddCandidatePage;
import org.example.pages.LoginPage;
import org.example.pages.RecruitmentPage;
import org.example.utils.ExcelUtils;
import org.example.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddCandidateTest extends BaseTest{
    @Test(dataProvider = "getData")
    public void addCandidateTest
            (String firstname, String middlename, String lastname, String email, String contactNumber, String expectedResult)
            throws InterruptedException {
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        recruitmentPage.goToRecruitmentPage();

        addCandidatePage.goToAddCandidatePage();
        boolean newCandidate = addCandidatePage.addCandidate( firstname, middlename, lastname, email, contactNumber, expectedResult);
        Assert.assertTrue(newCandidate);
    }

    @DataProvider
    public String[][] getData() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        String[][] data = excelUtils.getCellData("testdata/DataTests.xlsx", "CandidatesTests");

        return data;
    }
}
