from random import *
n_rolls = int(input('Number of Rolls: '))
dice_sides = int(input('How many sided dice: '))
for x in range(n_rolls):
  print(randint(1, dice_sides))