from random import *
n_rolls = int(input('Number of Rolls: '))
dice_sides = int(input('How many sided dice: '))
storage = []
for x in range(n_rolls):
  storage.append(randint(1, dice_sides))
  
print(storage)