Feature: Main Page

  @ui @regression
  @TC-1
  Scenario Outline: The "Engineering the Future" slider present on Main page
    Given Configure '<browserName>' for scenario
    When Anonymous user opens Epam main page
    Then Anonymous user sees the Video slider on Main page
    And Anonymous user sees the Engineering the Future text on Video slider
    Examples:
      | browserName |
      | chrome      |
      | firefox     |


