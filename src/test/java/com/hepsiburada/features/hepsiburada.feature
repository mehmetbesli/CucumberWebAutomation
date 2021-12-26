Feature: Hepsi burada test

  Scenario Outline: Buy a dress from site
    Given Go to "<url>" url and choose browser "<browser>"
    When Click sign in
    Then Type email "<email>" and password "<password>"
    And Control main page
    When Click main menu "<menu>" and sub menu "<subMenu>"
    Then Click add to cart
    And Click proceed to checkout
    Then Click proceed to checkout in summary
    When Click proceed to checkout in address
    Then Click Terms of service
    And Click proceed to checkout in shipping
    When Select pay by bank wire part
    Then Click I confirm my order
    And Click my account
    When Click order history and details
    Then control order with payment "<bankWire>"
    And Close driver
    Examples:
      | url                            | email                        | password            | menu    | subMenu        | bankWire  | browser |
      | http://automationpractice.com/ | hepsiburada.test34@gmail.com | HepsiburadaTest34.. | DRESSES | SUMMER DRESSES | Bank wire | chrome  |