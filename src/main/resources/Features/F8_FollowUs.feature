@smoke
  Feature: Follow us
    Scenario: Follow  us on Facebook
     When     User click on Facebook icon
     Then     "https://www.facebook.com/nopCommerce" Facebook page open in new tab
    Scenario: Follow  us on Twitter
      When    User click on Twitter icon
      Then    "https://twitter.com/nopCommerce" Twitter page open in new tab
    Scenario: Follow  us on RSS
      When    User click on RSS icon
      Then    "https://demo.nopcommerce.com/new-online-store-is-open" RSS page open in new tab
    Scenario: Follow  us on Youtube
      When    User click on Youtube icon
      Then    "https://www.youtube.com/user/nopCommerce" Youtube page open in new tab
