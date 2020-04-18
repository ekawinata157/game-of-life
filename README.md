#  Game Of Life

Game of Life is a simulation that take places in infinite 2D universe. Each coordinate in the grid will be populated with Cells with two state : LIVING and DEAD. By default, unitialized cells will have DEAD state. Only cells from user input will be treated LIVING cell. Each of the cells will able to change their own state based on the neighboring cell states. Several conditions including :
    - Living cell will die if the cell has less than two neighboring living cell(Death by loneliness)
    - Living cell will diea if the cell has more than three neighboring living cell(Death by overcrowding)
    - Living cell with exactly two or three neighboring living cell will stay alive
    - Death cell that are surrounded by exactly three living cells will be revived
State change of all cells will happen simultaneously

There are 4 class inside this project : Cell, Coordinate, GameOfLife and Main.
=> Coordinate class task is to handle the absolute and relative positioning of the cells
=> Cell class task is to simulate the state and behavior(living state changes) of a singular cell
=> GameOfLife contains the grid that will be populated by cells. GameOfLife class also handle the initialization of the simulation by receiving the initial state from the user

## Installation

Contained within com.btpn.app package

## Usage

GameOfLife object construction => GameOfLife gameOfLife = new GameOfLife(); #The constructor does not take any argument

Getting next generation of the cells state => gameOfLife.getNextGeneration(HashSet<Coordinates> coordinatesOfLivingCells); # Takes a set of coordinates as argument, representing the location of living cells inside the grid. All the coordinates not contained within the set will be populated by DEAD cells. By invoking this method, it will update the whole grid population state by the rule stated in the project description. 

Getting the information of LIVING cells => gameOfLife.toString() #If you invoke this method after calling the getNextGeneration method, it will print the latest living cell after one iteration.

Example of User Interaction in main program :

User input :
1,1
1,2
1,3
2,2
2,3
2,4
next

Output :
0,2
1,1
1,4
2,1
2,4
3,3

User will be asked to give coordinate input of living cells by typing "x,y". This process will be repeated until user typed "next". After finished receiving user input, the program will show the next generation of living cells coordinate to the user.




