# Absorb

[![](https://jitpack.io/v/Absorb-Minecraft/Absorb-server.svg)](https://jitpack.io/#Absorb-Minecraft/Absorb-server)


## What is it?
Absorb is a reimplementation of the Minecraft server which is designed to take advantage of modern day hardware such 
as multiple threads and async compute. 

To be clear, this holds NO ORIGINAL CODE from Minecraft, but instead holds code written for open source projects

## How much?

Completely free

We do **NOT** collect any data automatically, nor will we. The only form of data collection we would want to give 
you is a link to a survey whereby it's completely optional to fill it out

## Current Target

- Minecraft: 1.18.2
- Java 16

## Download

Currently there is no download link, however when a offical version is ready for the public, please look at our 
*Release* page on the right.

Want to test the latest and greatest before a release is ready? You have two options to do so, either

- Download and build a jar from source
- Click the *Actions* tab to see our automatic builds and then select the newest "Build" action, whereby the jars to 
  download will be at the bottom (please note to download them, you need to be signed in to a github account)

## What works?
At the time of writing, you can see the server status, however cannot join the server


### Roadmap

The current target is to get players loading into a empty world, after that the bigger plans come into play

1. Basic features (such as walking, jumping, inventory opening, chat, etc)
2. Flat world generation
3. Creative mode
4. Mobs (Animals and then monsters)
5. Mobs (decorative)
6. Block Inventories (such as a chests inventory)
7. World saving and loading
8. server.properties (wont be the same as regular)

At each stage after part 3, I am wanting to get the Sponge module (read below) to a standard that matches the server

## Mods?
Absorb by itself does not run any form of mods

**HOWEVER**

There are plans to add support for Sponge plugins though a official module

### Why Sponge?
The only "plugin" like competition to Sponge is Bukkit, which has multiple issues when you try to run them on 
anything other then a CraftBukkit implementation (such as Spigot or Paper). Without going too technical, this is 
mainly because most Bukkit plugins assume that they are running on a form of CraftBukkit and will attempt to 
interact with Minecraft's official code though the CraftBukkit layer ... so when that layer isn't there, the plugin 
complains resulting in crashes. While there are attempts to bridge the gap, these attempts are like building a 
bridge out of cardboard, sure it may work but no one wants to try. 

Another major incompatibility when it comes to Bukkit is its backwards compatibility with pre 1.13 plugins which 
lead to Bukkit breaking the rules of Java (in particular what version of classes (files) a plugin can see) and all 
this nonsense meant that I didn't want to support it

Sponge on the other hand doesn't use any Java hacks to maintain compatibility as they believe that if Minecraft 
makes a change that breaks something in Sponge, then Sponge should remove the broken thing and replace it with 
something new.

## Credit

Minecraft itself is made by Mojang (Now owned by Microsoft). All credit for this game goes to them for making Absorb 
a thing to begin with. 

For everyone who has worked on Absorb, please refer to the contributions tab on the right

## Development

### Requirements

- Java Development Kit 16 (17 is recommended)
- Maven

### Recommendations
For development, you can use any IDE you wish (including Notepad) on any operating system (as long as it can run JDK 
16+), however we do actually have some recommendations for if you can't decide and we specify the reason why

#### IDE - IntelliJ Idea
Intellij Idea is a well designed free Java IDE that comes with a powerful debugger. While it does have a reputation 
of being a slow at caching. Its what the developers of Absorb have used and therefore we have included a format and 
suggestion file in the Github project that Intellij will read to help you develop 

#### Java - JDK 17
While Absorb can be compiled and ran on Java 16, we are recommending Java 17 and JDK 17 over 16 and 18 as Java 17 is 
a LTS version, which means that it will be gaining its security updates for longer then 16 (which has ended its 
updated) and 18

#### OS - Linux
Absorb's CI's run on Linux. Plus it's free and stable


### Building

To build Absorb from the source code, simply run the following

``mvn clean package``

If you have loaded this from JetBrains IntelliJ (Community or Ultimate) then you will already have a option to build 
within the IDE 

### Contributing

We are more then happy to look at any contribution and accept most (Malware will not be accepted for example). 
Simply follow the steps

#### Through GitHub

1. Click the clone button on Github and clone the repo to your own account
2. Create a new branch on your version of Absorb (click the branch and then in the search box, type the new branch 
   name)
3. Open your favourite Java IDE (we recommend IntelliJ) and clone your Absorb repo
4. Switch branches to your newly created branch
5. Make the changes you wish
6. commit your changes
7. push your changes to your Absorb Repo
8. Click "Pull Request" on github
9. select "Compare against Forks"
10. select your repo and new branch to be merged into Absorb's repo on the master branch
11. create pull request




