Feature:As a user, I want to filter customers’ info on the Account page.

  @wip
  Scenario: Login as a store manager
  Given user is on the login page
  When user logins as a store manager.
  And user clicks Customers dropdown.
  And user clicks Accounts button.
  And user clicks filter icon.
  Then user sees Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At filter options

