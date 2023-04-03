package com.example.Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class CumberDemo {
    Demo d;
    String result;

    @Given("Create a game")
    public void createAGame() {
        d = new Demo();
    }

    @When("I play with number {int}")
    public void iPlayWithNumber(int arg0) {
        result = d.game(arg0);
    }

    @Then("the result is fizz")
    public void theResultIsFizz() {
        System.out.println(result);
        assertEquals(result, "odd");
    }


}
