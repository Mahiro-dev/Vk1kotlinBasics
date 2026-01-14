# Vk_1_kotlin_basics

## Description
simple task list application built with Kotlin and Jetpack Compose.
Kotlin basics, immutable data handling, and creating a first
Compose-based UI without XML.

## Data model
application uses a `Task` data class with the following fields:
- id
- title
- description
- priority
- dueDate
- done

Mock data (5 tasks) is provided in the domain layer.

## Kotlin functions
pure Kotlin functions:
- addTask: adds a new task to the end of the list
- toggleDone: toggles the completion state of a task
- filterByDone: filters tasks by done state
- sortByDueDate: sorts tasks by due date

All functions return new lists and do not mutate existing data.

## UI
The HomeScreen is implemented using Jetpack Compose.
It displays:
- a title
- a list of tasks
- buttons for adding, sorting, filtering, and toggling task state

The UI uses basic Compose layouts such as Column, Row, and Modifier.

## How to run
1. Open the project in Android Studio
2. Sync Gradle
3. Run the app on an Android Emulator or physical Android device

APK is also provided for direct installation.
