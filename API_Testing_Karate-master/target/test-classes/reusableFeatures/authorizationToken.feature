@ignore
Feature: Generate Authentication Token for the API

  Background:
    * url 'https://reqres.in/api/register'

    Scenario: Generate OAuth 2.0 Token
      Given path 'toke'
      And form field grand_type = 'client_credentials'
      And form field client_id = ''
      And form field client_secret = ''
      When method POST
      Then status 201
      * def accessToken = response.access_token