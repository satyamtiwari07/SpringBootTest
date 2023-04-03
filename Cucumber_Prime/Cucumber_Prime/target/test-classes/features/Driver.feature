Feature: Driver Details


  Scenario:entering the year of experience to check it will newbie or not
    Given Create a CheckExperience
    When the number is less than 1
    Then It will be newbie in driving

  Scenario:entering the year of experience to check it will Expert or not
    Given Create a CheckExperience
    When the number is less than 5
    Then It will be Expert in driver

  Scenario:entering the year of experience to check it will Master or not
    Given Create a CheckExperience
    When the number is more than 6
    Then It will be Master in driver

  Scenario: Entering the driver name if its not there it will throw exception
    Given Create a CheckName
    When the name is ""
    Then It will throw an exception

  Scenario:Checking whether description is not Null
    Given Create a CheckDescription
    When the desc is ""
    Then it will throw an error