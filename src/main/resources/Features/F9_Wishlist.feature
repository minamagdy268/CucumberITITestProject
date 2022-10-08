@smoke
  Feature: WishList
    Scenario: User add product to wishlist
      When user click on wishlist icon
      Then Product added to wishlist successfully

    Scenario: User open wishlist tab
      When user click on wishlist icon
      And  user click on wishlist tab
      Then wishlist contain the added product