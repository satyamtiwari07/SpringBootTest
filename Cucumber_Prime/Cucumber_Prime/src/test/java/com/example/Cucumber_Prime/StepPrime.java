package com.example.Cucumber_Prime;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;


public class StepPrime
{
    PrimeNumber p;
    String result;

    @Given("Create a PrimeCalculator")
    public void createAPrimeCalculator()
    {
       p=new PrimeNumber();

    }

    @When("I Enter Number {int}")
    public void iEnterNumber(int n)
    {
        result=p.find_prime(n);

    }

    @Then("the Result is Prime")
    public void theResultIsPrime()
    {
        Assertions.assertEquals(result,"Prime");
    }
}
