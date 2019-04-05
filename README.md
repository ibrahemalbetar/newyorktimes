# NY Times
NY Times is news app provide many types of news that intrest you, In an easy and fast way.

# Screenshoots
![Screenshot_1554480895](https://user-images.githubusercontent.com/22882810/55642307-cd464e00-57d8-11e9-9335-c3e026097565.png)


![Screenshot_1554481006](https://user-images.githubusercontent.com/22882810/55642331-dc2d0080-57d8-11e9-8074-3e438f919b6e.png)


![Screenshot_1554481011](https://user-images.githubusercontent.com/22882810/55642378-f9fa6580-57d8-11e9-9602-d08d18a8b6d6.png)

![Screenshot_1554481328](https://user-images.githubusercontent.com/22882810/55642425-13031680-57d9-11e9-8afe-72d06e4bbcdc.png)

# Project Design Pattern

This project based on MVP (Model-View-Presenter) design pattern. 
The general advantages that one gets from implementing MVP are: 
Clear separation of responsibilities between components. This separation allows for an easier understanding and maintenance of the code base.

# App Work Flow

- Splash Activity: in this screen the app load most recently news for user by callig the NY Times Api using Retrofit app client and RX Java/Android with parameters API key and period.
after load complete the app navigate to Main Activty.

- Main Activity: this is the core screen and it have the news list so the user can select any item to show the details screen or you can select period of news from option menu on top right of main activity screen.
The user can refresh the new at any time form the refresh button on actionbar.

- Details Activity: show the details of news item.



