# Conway's Game of Life   

My take on core [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) implementation in different languages. This code may not be optimal or even correct.

## Rules   
1. Live cell with fewer thatn two neighbours dies from starvation
2. Live cell with two or three neighbours survives
3. Live cell with more than three neighbours dies from overpopulation
4. Dead cell with three neighbours becomes live (reproduction)

## Example   
![3x3](/../images/gol3x3.jpg?raw=true "3x3")

Cell|State|Neighbours|Next State|Rule
--- |-----|----------|----------|----
1|Dead|2|Dead|4
2|Dead|3|Live|4
3|Live|1|Dead|1
4|Live|2|Live|2
5|Live|3|Live|2
6|Dead|3|Live|4
7|Dead|3|Live|4
8|Live|2|Live|2
9|Dead|2|Dead|4
