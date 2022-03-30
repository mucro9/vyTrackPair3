@wip
Feature: As a user, I want to learn how to use the pinbar.


  Scenario Outline: Verify user see the two different text on the pinbar page
    When user enter  username "<username>" and password "<password>"
    Then user should be on the homepage
    And user click the “Learn how to use this space”
    Then users should see: “How To Use Pinbar”  and “Use pin icon on the right top corner of the page to create fast access link in the pinbar.”

    Examples:
      | username        | password    |
      | user38          | UserUser123 |
      | storemanager75  | UserUser123 |
      | salesmanager125 | UserUser123 |


  Scenario Outline: Verify users see pinbar image
    When user enter  username "<username>" and password "<password>"
    Then user should be on the homepage
    And user click the “Learn how to use this space”
    Then user see an pinbar image

    Examples:
      | username        | password    |
      | user38          | UserUser123 |
      | storemanager75  | UserUser123 |
      | salesmanager125 | UserUser123 |