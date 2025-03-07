package org.example;

import org.example.pages.AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest{
    @Test
    public void SearchUserTest() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdminPage();
        boolean filterWorks = adminPage.filterUsers("Admin");
        Assert.assertTrue(filterWorks);
    }
}
