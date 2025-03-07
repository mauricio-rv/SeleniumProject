package org.example;

import org.example.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest{
    @Test
    public void TestDashboardSideBar() throws Exception{
        DashboardPage dashboardPage = new DashboardPage(driver);

        String searchText = "Rec";
        dashboardPage.searchSidebar(searchText);
        boolean results = dashboardPage.searchSidebaHasFoundResultsr(searchText);
        Assert.assertTrue(results);
    }
}
