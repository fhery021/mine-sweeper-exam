# 🥋  Mine Sweeper Kata

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=coverage)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=bugs)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)

## Game Rules:
You are presented with a board of squares. Some squares contain mines (bombs), others don't.

If you step
on a square containing a bomb, you lose. If you manage to clear all the squares (without clicking on any
bombs) you win.

Clearing a square which doesn't have a bomb reveals the number of neighbouring squares containing bombs.
If you guess a square contains a bomb mark it with a flag.


A squares "neighbours" are the squares adjacent above, below, left, right, and all 4 diagonals. Squares on the
sides of the board or in a corner have fewer neighbors.

The board does not wrap around the edges.
If you clear a square with 0 neighboring bombs, all its neighbors will automatically open; recursively.
The first square you open could be a bomb.

You don't have to mark all the bombs to win; you just need to open all non-bomb squares.


### Build and Run the application with the following:
> gradle build

> gradlew run

On windows
> .\gradlew.bat run
