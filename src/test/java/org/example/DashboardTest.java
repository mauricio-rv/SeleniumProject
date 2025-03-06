package org.example;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest{
    @Test
    public void TestDashboardSideBar() throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.login();

        String searchText = "Rec";
        dashboardPage.searchSidebar(searchText);
        boolean results = dashboardPage.getSearchSidebarResult(searchText);
        Assert.assertTrue(results);
    }
}
