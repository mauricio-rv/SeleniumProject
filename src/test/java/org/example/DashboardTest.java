package org.example;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest{
    @Test
    public void TestDashboardSideBar() throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        String username = PropertyUtils.getProperty("user.name");
        String password = PropertyUtils.getProperty("user.password");
        loginPage.login(username, password);

        String searchText = "Rec";
        dashboardPage.searchSidebar(searchText);
        boolean results = dashboardPage.searchSidebaHasFoundResultsr(searchText);
        Assert.assertTrue(results);

    }
}
