
  Feature: Search Functionality on  Users page

    As a user,
    when I login as librarian
    and I go to Users page,
    then table should have following columns
    . Actions
    . UserID
    . Full Name
    . Email
    . Group
    . Status

    @SearchResults
    Scenario: Table columns names
      Given I am on the login page
      And I login as a librarian
      And click on "Users" link
      Then table should have following columns names:
        | Actions   |
        | User ID   |
        | Full Name |
        | Email     |
        | Group     |
        | Status    |