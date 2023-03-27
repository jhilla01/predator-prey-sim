# Predator-Prey Lotka-Volterra Model Simulator
## Lotka-Volterra Model in Java describing predator-prey interactions
### The L-V Model is dependent on 6 parameters:
1. Prey birth rate
2. Prey death rate
3. Predator birth rate
4. Predator death rate
5. Population of prey
6. Population of predators

### How the Simulator Works:
The simulator has two main functions:
1. Displaying the rabbits and foxes for 250 iterations 
   After every iteration a board with F’s and R’sis printed with the population counts, representing foxes and rabbits respectively.
2. Plotting the population of rabbits and foxes over time
   After the 250 iterations, the simulator plots the population of rabbits and foxes over each generation.

### How to Edit the Simulator:
1. Open the src folder in your IDE
2. Edit the starting parameters in the Simulator.java file
3. Run the simulator using the command: java Simulator

### How to Run the Simulator:
1. Download the src folder
2. Open the src folder in your IDE/CMD
3. Compile the files using the command: javac *.java
4. Run the simulator using the command: java Simulator
5. The simulator will run for 300 iterations and then plot the population of rabbits and foxes over time.

### Classes:
1. Simulator.java: This is the main class that runs the simulator. Performs "x" iterations of the simulation by carrying out predation and movement of the animals on the board. Prints out the board in every iteration.
2. Graph.java:This class contains the code for plotting the population of rabbits and foxes over time after the simulator is complete.
3. Organism.java: This class contains the code for the Organism object. It is a superclass of foxes and rabbits, defining the internal logic of the two species such as position on the board and reproduction/death.
4. Rabbit.java: This class contains the code for the Rabbit object. Defines the symbol of rabbits (“R”). It extends the Organism class and contains the methods for the rabbit to reproduce and die.
5. Fox.java: This class contains the code for the Fox object. Defines the symbol of foxes (“X”). It extends the Organism class and contains the methods for the fox to reproduce and die.
6. Board.java: This class contains the code for the Board object. Initializes the board and randomly distributes rabbits and foxes across a grid to initialize the board. After each iteration, individuals are moved, breeding occurs in accordance with the breed rate, and any rabbits that are eaten by foxes and any starving foxes are removed from the board.
