------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

TeaVM (http://www.teavm.org/sandbox/index.html) does not support:
java.lang.ClassLoader classLoader = getClass().getClassLoader();
new FileWriter(fileName)
import java.util.Scanner;
new FileReader("data.txt")
import java.awt.*;
import java.swing.*;
import javafx.*;
String(StringBuffer)

PROJECT TITLE: Greenfoot Jeopardy
PURPOSE OF PROJECT: Present questions and answers in a Jeopardy-like manner.
VERSION or DATE: 1.0  1/16/2011
Updated: 2.0 1/23/2018 for Greenfoot 3.1. Had to remove use of files and awt to display online.
HOW TO START THIS PROJECT:
Press the run button and select the question file to run. Choose to use a timer
or display multiple choice answers by clicking the buttons. When your settings
are complete, click the "Continue" button.
AUTHORS: Ed Parrish adapted from the Quiz game by Michael Berry.
USER INSTRUCTIONS:
Test your Greenfoot and Java knowledge with this Jeopardy-like game!

Start with the basics.txt file and then move on to basics2.txt. All questions
are from the first 4 chapters of the Greenfoot book.

The Game Settings screen allows you to adjust how the game operates:

o Use Timer: if set to "On", you have 15 seconds to select a "question"

o Display multiple choices: if set to "On", an answer has multiple question
  choices to chose from. If set to "Off", you decide if your answer was
  correct.

o Question file: choose a set of questions for the game. You have two files
  you can choose from at this time: "basics.txt" and "basics2.txt". The first
  file is the easier of the two. The second file includes a "Final Jeopardy"
  style question.

Each question you get correct is worth a set amount of points. In the final
round you can wager on your ability to get the correct question.

Also, take a look at the GreenGUI components: Label and Button. These are
like Java components but implemented in Greenfoot.

DESIGN NOTES:
The design started as an adaptation of the Quiz game developed by Michael
Berry. The original classes, Question and Answer, have changed somewhat but the
basic design is from the Quiz game.

My contributions include the main board, several screens for the game and the
GUIComponent system that includes labels, buttons and text fields. Also, I
worked out the main flow of the game and added the ability to load questions
from files.

You can add your own question sets to the game. I have included two example
questions files in the game: basics.txt and basics2.txt. These files contain
questions from the first 4 chapters of the Greenfoot book.
