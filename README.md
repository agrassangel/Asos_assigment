# Asos test application 

To conduct the automation test script for this assigment Serenity BDD library was used with Selenium and Cucumber as a framework. 


### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature file subdirectories
         google_search.feature    
```


## Test scenario 

```Gherkin
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



```


## Executing the tests
To run the project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

```json
$ mvn clean verify
        or
$ mvn clean verify -Ddriver=firefox
```

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```

The test results will be recorded in the `target/site/serenity` directory.

## Generating the reports
Reports are generated once you execute the command `mvn verify` in directory

```json
target/site/serenity/index.html
```
