package com.example.Cucumber_Prime;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Driverdefs {

    Driver d;
    String result;
    String desc;
    Exception ex;
    @Given("Create a CheckExperience")
    public void createACheckExperience() {
     d=new Driver();
    }

    @When("the number is less than {int}")
    public void theNumberIsLessThan(int arg0) {
        result=d.check(arg0);
    }

    @Then("It will be newbie in driving")
    public void itWillBeNewbieInDriving() {
        assertEquals(result,"Newbie");
    }

    @Then("It will be Expert in driver")
    public void itWillBeExpertInDriver() {
        assertEquals(result,"Expert");
    }

    @When("the number is more than {int}")
    public void theNumberIsMoreThan(int arg0) {
        result=d.check(arg0);
    }

    @Then("It will be Master in driver")
    public void itWillBeMasterInDriver() {
        assertEquals(result,"Master");
    }

    @Given("Create a CheckName")
    public void createACheckName() {
        d=new Driver();
    }

    @When("the name is {string}")
    public void theNameIs(String arg0) {
        ex=assertThrows(Exception.class,()->d.checkNull(arg0));
    }

    @Then("It will throw an exception")
    public void itWillThrowAnException() {
        assertEquals("Name is NULL", ex.getMessage());
    }

    @Given("Create a CheckDescription")
    public void createACheckDescription() {
        d=new Driver();
    }

    @When("the desc is {string}")
    public void theDescIs(String arg0) {
        ex=assertThrows(Exception.class,()->d.checkDesc(arg0));
    }

    @Then("it will throw an error")
    public void itWillThroeAnError() {
        assertEquals("Desc is NULL", ex.getMessage());
    }
}
