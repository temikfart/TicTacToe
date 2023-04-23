# TicTacToe
---

### About
---

Tic-tac-toe is a paper-and-pencil game for two players
who take turns marking the spaces in a three-by-three 
grid with X or O. The player who succeeds in placing 
three of their marks in a horizontal, vertical, or diagonal 
row is the winner. It is a solved game, with a forced draw 
assuming best play from both players.

There is an implementation of this simple game.
In my application you can choose grid: 3x3, 4x4, 5x5.



### Build and run
---

> JDK-17 minimum required.

1. If you have local `gradle` tool with minimum version 7.5.1,
you can build the game with the following command:

    ```shell
    $ gradle build
    ```
    
    and run with
    
    ```shell
    $ gradle run
    ```

2. Another way is to use `gradle-wrapper`:

    On Unix systems:

    ```shell
    $ ./gradlew build
    $ ./gradlew run
    ```

    On Windows:
    
    ```shell
    $ ./gradlew.bat build
    $ ./gradlew.bat run
    ```

3. Finally, you can download the game in the "Release" page
and run `TicTacToe-<version>.jar` file on your computer.



### License
---

[MIT license](https://en.wikipedia.org/wiki/MIT_License).
