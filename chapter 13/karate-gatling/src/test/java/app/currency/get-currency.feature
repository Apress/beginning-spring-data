Feature: Currency operations

  Background:
    * url AppUrl
    * def get_currency_response = read('./get-currency-response.json')

  Scenario: Get all the information about one currency
    Given path 'currency/1'

    When method GET

    Then status 200
    And match response == get_currency_response
