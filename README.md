The main purpose of this program was to create a dice rolling application
that would basically be used during an online session of Dungeons and Dragons.

Dungeons and Dragons is a roll playing game that is based off of individuals 
imaginations and the freedoms provided by the Dungeon Masters story. In terms of
why this dice rolling application is needed is because I noticed that I was
using an online dice rolling website and figured that creating my own application
maybe an interesting task. Although there are thousands of programs already 
out there, my program is specificially designed for a DnD campaign. 

The program will take in 3 sents of inputs one for the number of times a dice
roll is made, the second is for the number of sides on a dice, and the final 
value is used as a modifier score that is based off of individal player characters.



Ideas/Plans
The next plan of action is either to start figuring out doing a string evaluation 
instead of the current method of constantly providing input as well as having the
program run consistently instead of a one and done.

Example of the evaluation would be like 3d4 + 1, the evaluator would take all the 
values at the front of 'd' and store that value as the number of rolls. Next the 
evaluator would find the first instance of "+/-" and anything before that character
would be the number of sides on a dice, and anything after those characters would 
be stored in a different array as a modifier value used for last.
