Maria Alexandra Leoveanu
323CA

Hero.class - contains all common behaviour of all 4 subclasses (level up, looking for
opponent, moving etc.) 
HeroFactory.class - generates and returns specific hero based on input 
Rogue.class - has 2 specific field for its type that store the streak for backstab and the 
land it was in the prevoius round
Constants.class - stores all the constants used throughout the program. Some have the same value
and are declared more than once to mantain the readability of the code. 
GameProcess.class - the actual game mechanic. After every player has checked if they had to take
any overtime damage, they attempt to move in the land map. Each of the players check if there is
an opponent available (alive and has the same coordinates). If the current player is a wizard, 
it is added in a list, and it will attack after all the other players, to ensure that the damage 
dealt is stored in the opponent's field. At the end of the round all flags are reset and each 
player checks to see if it gained enough xp to level up.

I used Github to keep track of changes thoughout the process, adding commits for new behaviour implemented (Rogue / Knight etc), but mostly for fixed bugs.



                  . '  .
               ' .( '.) '                 *bug spay*
       _     ('-.)' (`'.) '
      |0|- -(. ')`( .-`) (-')
   .--`+'--.  .  (' -,).(') .
   |`-----'|   (' .) - ('. )
   |       |    . (' `.  )
   |  .-.  |       ` .  `
   | (0.0) |
   | >|=|< |
   |  `"`  |
   |       |
   |       |
   `-.___.-'


