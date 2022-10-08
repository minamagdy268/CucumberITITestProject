@smoke
Feature: Logged-in user | search products
  Scenario Outline:  User could search  with product name
   Given      user click on search field
   When       user enter "<productname>" and click enter
   Then       user get products contain "<productname>"
    Examples:
      |productname|
      | apple      |
      | laptop    |
      | camera    |

  Scenario Outline:  User could search with product sku
    Given      user click on search field
    When       user enter sku "<sku>" and click enter
    And        user click on product from search result
    Then       Used "<sku>" shown in the product page
    Examples:
      |     sku      |
      | SCI_FAITH    |
      | APPLE_CAM    |
      | SF_PRO_11    |

