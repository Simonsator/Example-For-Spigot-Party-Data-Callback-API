# Example For The Party Data Callback API Of Party And Friends Extended Edition For BungeeCord
## What is the party data callback api?
The party data callback api allows your spigot plugin to use the party data of [Party and Friends Extended Edition for Bungeecord](https://www.spigotmc.org/resources/party-and-friends-extended-edition-for-bungeecord-velocity-supports-1-7-1-16-4.10123/). The JavaDoc for the api can be found [here](https://simonsator.de/JavaDoc/SpigotPartyDataCallbackApi/index.html). The only requirment is that the gui has to be installed on the spigot server where you want to receive the data using this api.
## What are the limitations of the callback api?
As the name suggests it uses an asynchronous callback (The class de.simonsator.partyandfriendsgui.api.datarequest.party.PartyDataCallBackRunnable). This means the data won't be accessible directly when you request it using the api, but you are going to have to wait until the spigot server receives the data from the bungeecord. When the data is received the method onCallback(pPlayer: Player, pParty: PartyData, pId: int) is called. Your data handling must be done in this class. Also, this api is read only and the data won't be updated automatically when for example somebody leaves the party. The [Spigot Party API for Party and Friends](https://www.spigotmc.org/resources/39751/) on the other hand has not those limitations, but it either requires redis or uses more performance than this  api if mysql is used as a bridge. 
## How do I use the api?
You need to add "PartyAndFriendsGUI" to your plugin.yml as a (soft)dependency. If you are using maven you need to add 

```xml
<repositories>
	<repository>
		<id>simonsators Repo</id>
		<url>https://simonsator.de/repo</url>
	</repository>
</repositories>
<dependencies>
	<dependency>
		<groupId>de.simonsator</groupId>
		<artifactId>DevelopmentPAFSpigot</artifactId>
		<version>1.0.65</version>
		<scope>provided</scope>
	</dependency>
</dependencies>
```
to your pom.xml. How to actually use the actual api can be found in this [example class](https://github.com/Simonsator/Example-For-Spigot-Party-Data-Callback-API/blob/main/src/main/java/de/simonsator/partyandfriends/apiexample/ExamplePlugin.java). The api itself is integrated into the gui of [Party and Friends Extended Edition for BungeeCord/Velocity jar](https://www.spigotmc.org/resources/party-and-friends-extended-edition-for-bungeecord-velocity-supports-1-7-1-16-4.10123/) meaning you have to install the jar onto the spigot server.
