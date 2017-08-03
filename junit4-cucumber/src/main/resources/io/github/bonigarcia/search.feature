Feature: Book search
  To allow customers to find books, the library must offer seek methods.
 
  Scenario: Search books by publication year
    Given a book with the title 'The Hobbit', written by 'J. R. R. Tolkien', published in 21 September 1937
      And another book with the title 'A Confederacy of Dunces', written by 'John Kennedy Toole', published in 1 April 1980
      And another book with the title 'A Game of Thrones (A Song of Ice and Fire)', written by 'George R.R. Martin', published in 1 August 1996
    When the customer searches for books published between 1980 and 2000
    Then 2 books should have been found
      And Book 1 should have the title 'A Game of Thrones (A Song of Ice and Fire)'
      And Book 2 should have the title 'A Confederacy of Dunces'