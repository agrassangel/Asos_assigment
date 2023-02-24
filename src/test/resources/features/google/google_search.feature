Feature: Searching in Google page


  Scenario Outline: Performs a search in Google
    Given User is on Google home page
    When User introduces the search criteria "<criteria>"
    And User hit on ENTER key
    Then Google should redirect to result web page
    And The total of results should be match the conditions allowed "<less_than_results>" and "<more_than_results>"

    Examples:
      | criteria | less_than_results | more_than_results |
      | apple    | 100000            | 100000            |
      | xunda    | 4000              | 3000000000        |

