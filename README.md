# BRYNJOLF_LEGACY_PROBLEM

Assumption 1:
> e represents exit(not o).

Assumption 2:
> When Brynjolf or guards move in a direction, they move to the extremes of the direction until the meet the obstacle.
The obstacles here are, the end of direction or wall or exit(basically anything that is not a open space).

Assumption 3:
> Throws invalid room error when the given room in room.txt is greater than 10 or empty.

Assumption 4:
> There wont be any invalid elements in room or input.

Assumption 5:
> In enlightment problem, when input is same as a the output even after 20 moves, then the user is assumed to be stuck.

Assumption 6:
> "ur" should be similar to "ru", as both are possible reaches the exit.

Assumption 7:
> The given room is solutionizable and exit is always on a corner.

Problem 1 : [Establishment]

- Input: 
    Sequence of moves
- Output: 
    Room in the end. 
    Won or lost or undecided. 
    Number of moves used, number of moves given as input. 
    
 Problem 2 : [Enlightment]
 
 - Input: 
     Sequence of moves
 - Output: 
     Won or stuck 
     input moves along with winning moves
