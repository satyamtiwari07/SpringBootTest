Feature:  EvenOdd Game Play

  Scenario: Play EvenOdd to get even
    Given Create a EvenOdd Game Play
    When I play with number 4
    Then The result is Even
