Feature: Contact us Page

  @ui @regression
    @TC-2
  Scenario Outline: The the JUST ASK US ANYTHING form present on Contact Us Page
    Given Configure '<browserName>' for scenario
    When Anonymous user opens Epam main page
    Then Anonymous user opens Contact Us Page
    And Anonymous user sees the JUST ASK US ANYTHING form on Contact Us Page
    Examples:
      | browserName |
      | chrome      |
      | firefox     |


