# ✏ Notes
Contains the features, plans, and progress.

## ✨ Features
> Focus on the expected behavior (WHAT) and not on the implementation details (HOW).


## ⏱ Pomodoro Plans

| Pomodoro | Plan |
| ------ | ------ |
| 1. 09:30-10:00  | 📌 Prepare readme, notes with the plan, create a **1X1 game board**|
| 2. 10:05-10:30 | 📌 2X2 Game Board |
| 3. 10:35-11:00 | 📌 3X3 Game Board |
| 4. 11:05-11:30 | 📌 Refactor and clean-up |


## 📰 Plan Details

### 1X1 Game board
- create a 1x1 board

+-+

|  |

+-+

- place a bomb (or not)
- run the game
- click: and if there is a bomb you lost.
  You lost:
  +-+

| X |

+-+

You win:

+-+

| _ |

+-+
### 1X2 game board
- create a 1x2 board [0, 1]
- place a bomb randomly (or not)
- run the game
- click on bomb: you lost.
- click on empty field: you win

+-+-+

| 1 | X |

+-+-+

Or:

+-+-+

| _ | _ |

+-+-+

### 2X2 game board
- create a 2x2 board
- place a bomb randomly (or not)
- ser the bomb's neighbors to 1
- run the game
- click on bomb: you lost.
- click on empty field: show 1

+-+-+

| 1 | X |

+-+-+

| 1 | 1 |

+-+-+

### 3X3 game board
- create a 3x3 board
- place a bomb or more randomly
- increase the bomb's neighbour's counter with 1
- run the game
- click on bomb: you lost.
- click on empty field: unveil (uncover) the number's neighbours until neighbours contains bombs
- mark the potential bombs: uncoveredNumber amount of uncovered neighbours

+-+-+-+

| 1 | X | 1 |

+-+-+

| 2 | 2 | 1 |

+-+-+

| X | 1 | _ |

## 📈 Progress

- ✔ 1x1 Game Board
- ✔ On Every 2 seconds draw the game board
- 🔧 2x2 Game Board
- 📌 3x3 Game Board

> Example entries in the progress: - ✔ Done 🔧 In Progress 📌 TODO
