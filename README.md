# Template Project
This is a template project for Java CLI projects.

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=coverage)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=fhery021_mine-sweeper-exam&metric=bugs)](https://sonarcloud.io/summary/new_code?id=fhery021_mine-sweeper-exam)

# KataLeanOn 
This repository contains Katas and their solutions in Java.

Each branch represents one Kata.

## 🥋 Template Kata Title 

- template requirement

Build and Run the application with the following:
> gradle build

> gradlew run

On windows
> .\gradlew.bat run

## Git Conventional commits

Git hooks overview: https://www.greengeeks.com/tutorials/an-overview-of-git-hooks/
Guide: https://gist.github.com/qoomon/5dfcdf8eec66a051ecd85625518cfd13
Install git-conventional-commits: npm install --global git-conventional-commits <- The ugly regex things are implemented in this tool
Put this file in your repo root: git-conventional-commits.json  <- This is the config file for the previous tool. Here you can customize your rules, but the example in the next line is sufficient for the exam.
I have filled the json with the example from https://github.com/qoomon/git-conventional-commits
After clone or git init create this file: <repo_root>/.git/hooks/commit-msg
Write this to the commit-msg file

#!/usr/bin/env sh
commit_message="$1"
# exit with a non zero exit code incase of an invalid commit message

# use git-conventional-commits, see https://github.com/qoomon/git-conventional-commits
git-conventional-commits commit-msg-hook "$commit_message"


If you use Linux, make the commit-msg file executable.
