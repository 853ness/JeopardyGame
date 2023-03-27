
/**
 * Questions as String[] instead of files since cannot read files online.
 */
public class File {
    public static final String[] MATH_TRIVIA = {
            "# Single Round",
            "# Category format = :CATX:Category name, where X is the catgory number.",
            "# Question format = :QUESTX:$:Question test, where X is the question number",
            "#     and $ is the value displayed for the question.",
        "# Questions are linked to categories in groups of 5. For example, questions 1",
            "#     to 5 are in category 1, questions 6 to 10 in category 2, and so on.",
            "# Answer format = :ANSWERX:T/F:Answer text, where X is the question number and",
            "#     T/F is either T (for true) or F (for false). Answers are optional.",
            "# Answer order format = :ANSWERORDER1:randomized to shuffle the answers. Skip",
            "#     this statement if you do not wnat to randomize answers.",
            "# Explanation format = :EXPLANATIONX:Explanation text, where X is the question",
            "#     number. Note that you can force new lines using \n.",
            "",

            ":CAT1:ABSOULTE\nVALUE",
            "",
            ":QUEST1:100:The absolute value of |0| is..",
            ":ANSWER1:T:0",
            ":ANSWER1:F:None of the above",
            ":ANSWER1:F:Not applicable",
            ":ANSWER1:F:|0|",
            ":ANSWERORDER1:randomized",
            ":EXPLANATION1:The distance from of a number from 0 without its sign.",
            "",
            ":QUEST2:200:The absolute value of -|-2| is..",
            ":ANSWER2:T:-2",
            ":ANSWER2:F:2",
            ":ANSWER2:F:|-2|",
            ":ANSWER2:F:None of the above",
            ":ANSWERORDER2:randomized",
            ":EXPLANATION2:We know |-2| is 2, so -|-2| is -2. ",
            "",
            ":QUEST3:300:The absolute value of |-5|+|2| is..",
            ":ANSWER3:T:7",
            ":ANSWER3:F:-3",
            ":ANSWER3:F:-|7|",
            ":ANSWER3:F:None of the above",
            ":ANSWERORDER3:randomized",
            ":EXPLANATION3:The abs value of |-5| is 5, and |2| is 2 so 5+2= 7",
            "",
            ":QUEST4:400: The absolute value of|-3*5| is ...",
            ":ANSWER4:T:15",
            ":ANSWER4:F:|15|",
            ":ANSWER4:F:|-15|",
            ":ANSWER4:F:None of the above",
            ":ANSWERORDER4:randomized",
            ":EXPLANATION4:If |-3*5| is |-15|, the abs value is 15.",
            "",
            ":QUEST5:500:Arrange from greatest to least (|4|,|1|,|0|,-|-21|,|-2|)",
            ":ANSWER5:T:0,1,2,4,-21",
            ":ANSWER5:F:21,4,2,1,0",
            ":ANSWER5:F:-21,0,1,2,4",
            ":ANSWER5:F:None of the above",
            ":ANSWERORDER5:randomized",
            ":EXPLANATION5:.",
            "",
            ":CAT2:PERFECT\nSQUARE",

            ":CAT3:COMPARE\nRATIONAL\nNUM",

            "",
            ":QUEST11:100:These 2 coordinates are used to locate a point in a 2-dimensional Cartesian, or coordinate, system.",
            ":ANSWER11:T:x & y",
            ":ANSWER11:F:up & down",
            ":ANSWER11:F:latitude & longitude",
            ":ANSWER11:F:radius & theta (\u0398)",
            ":ANSWERORDER11:randomized",
            ":EXPLANATION11:A Cartesian coordinate system specifies each point in a plane using the numerical coordinates x & y.",
            "",
            ":QUEST12:200:The  origin (0, 0) of the coordinate system is located at this area of a Greenfoot window.",
            ":ANSWER12:T:the upper left-hand corner",
            ":ANSWER12:F:in the center",
            ":ANSWER12:F:the upper right-hand corner",
            ":ANSWER12:F:the lower left-hand corner",
            ":ANSWERORDER12:randomized",
            ":EXPLANATION12:The upper left-hand corner is the origin (0, 0) of the Greenfoot coordinate system.",
            "",
            ":QUEST13:300:To move to a specific (x, y) location, use this method of the Actor class.",
            ":ANSWER13:T:setLocation()",
            ":ANSWER13:F:location()",
            ":ANSWER13:F:setXY()",
            ":ANSWER13:F:setX_Y()",
            ":ANSWERORDER13:randomized",
            ":EXPLANATION13:The setLocation() method of the Actor class assigns a new location for an Actor object. The location is specified as a cell index in the world.",
            "",
            ":QUEST14:400:To find the current (x, y) coordinate location of an Actor, use these two methods.",
            ":ANSWER14:T:getX() and getY()",
            ":ANSWER14:F:x() and y()",
            ":ANSWER14:F:getXCoordinate() and getYCoordinate()",
            ":ANSWER14:F:setX() and setY()",
            ":ANSWERORDER14:randomized",
            ":EXPLANATION14:Method getX() returns the x-coordinate of the object's current location and method getY() returns the y-coordinate of the object's current location.",
            "",
            ":QUEST15:500:To move an Actor one pixel to the right use this statement.",
            ":ANSWER15:T:setLocation(getX() + 1, getY());",
            ":ANSWER15:F:setLocation(getX() + 10, getY() - 1);",
            ":ANSWER15:F:setLocation(getX() + 1, getY() - 1);",
            ":ANSWER15:F:setLocation(getX(), getY() + 1);",
            ":ANSWERORDER15:randomized",
            ":EXPLANATION15:These statements should be worked from the inside out. Method getX() returns the x-coordinate of the object's current location. By adding 1, you move the location one pixel to the right. Method getY() returns the y-coordinate of the object's current location. With the (x, y) locations computed, calling the setLocation() method will move an Actor one pixel to the right.",
            "",

            ":CAT4:PROBLEMS\nWITH\nRATIONAL NUM",

            "",
            ":QUEST16:100:It's the sum total of the degrees in a circle.",
            ":ANSWER16:T:360",
            ":ANSWER16:F:180",
            ":ANSWER16:F:2\u00B7\u03C0\u00B7r",
            ":ANSWER16:F:\u03C0\u00B7r\u00B2",
            ":ANSWERORDER16:randomized",
            ":EXPLANATION16:There are 360 degrees in a circle.",
            "",
            ":QUEST17:200:For an Actor, zero degrees is in this direction of the compass.",
            ":ANSWER17:F:to the north",
            ":ANSWER17:T:to the east",
            ":ANSWER17:F:to the south",
            ":ANSWER17:F:to the west",
            "#:ANSWERORDER17:randomized",
            ":EXPLANATION17:Zero degrees is to the east and the angle of the circle increases clockwise.",
            "",
            ":QUEST18:300:To find the current orientation (or heading) of an actor, use this method of the Actor class.",
            ":ANSWER18:T:getRotation()",
            ":ANSWER18:F:getOrientation()",
            ":ANSWER18:F:getHeading()",
            ":ANSWER18:F:getDirection()",
            ":ANSWERORDER18:randomized",
            ":EXPLANATION18:The getRotation() method of the Actor class returns the current rotation of the object. Rotation is a degree value in the range of (0..359). Zero degrees is to the east and the angle increases clockwise.",
            "",
            ":QUEST19:400:To turn an actor facing straight up (or north), use this command.",
            ":ANSWER19:T:setRotation(270)",
            ":ANSWER19:F:setRotation(0)",
            ":ANSWER19:F:setRotation(\"north\")",
            ":ANSWER19:F:setRotation(\"up\")",
            ":ANSWERORDER19:randomized",
            ":EXPLANATION19:Zero degrees is to the east and the angle of the circle increases clockwise. Straight up, or north, is at 270 degrees. Use the setRotation() method to set the orientation (or heading) of an Actor.",
            "",
            ":QUEST20:500:To turn an actor 10 degress clockwise from their current heading, use this command.",
            ":ANSWER20:T:turn(10)",
            ":ANSWER20:F:turn(-10)",
            ":ANSWER20:F:setRotation(+10)",
            ":ANSWER20:F:setRotation(-10)",
            ":ANSWERORDER20:randomized",
            ":EXPLANATION20:Zero degrees is to the east and the angle of the circle increases clockwise. Straight up, or north, is at 270 degrees. To turn clockwise use a positive number.",
            "",

            ":CAT5:POWER OF 10\nEXPONENTS",

            "",
            ":QUEST21:100:It is a numerical sequence where the next number cannot be predicted.",
            ":ANSWER21:T:a random number",
            ":ANSWER21:F:a sequential number",
            ":ANSWER21:F:an ordered number",
            ":ANSWER21:F:a psudeo number",
            ":ANSWERORDER21:randomized",
            ":EXPLANATION21:Random numbers are a series of numbers that lack any pattern and thus appear random. Most times, a random number generator will produce psuedorandom sequences, where numbers appear to be random but are not. Psuedorandom numbers are often sufficient for computer programs, like video games, that need random numbers.",
            "",
            ":QUEST22:200:This method of solving problems with a random number generator is named after the casino city of Monaco.",
            ":ANSWER22:T:Monte Carlo",
            ":ANSWER22:F:Las Vegas",
            ":ANSWER22:F:Macau",
            ":ANSWER22:F:Venise",
            ":ANSWERORDER22:randomized",
            ":EXPLANATION22:Monte Carlo is a city widely known for its casino. Monte Carlo methods rely on repeated computation of random or pseudorandom numbers.",
            "",
            ":QUEST23:300:This expression will return a random number between 0 and 10, including the numbers 0 and 10.",
            ":ANSWER23:F:Greenfoot.getRandomNumber(9)",
            ":ANSWER23:F:Greenfoot.getRandomNumber(10)",
            ":ANSWER23:T:Greenfoot.getRandomNumber(11)",
            ":ANSWER23:F:Greenfoot.getRandomNumber(\"10\")",
            "#:ANSWERORDER23:randomized",
            ":EXPLANATION23:The Greenfoot method getRandomNumber() returns a random number between 0 (inclusive) and an upper limit (exclusive). Since the upper limit is excluded you must add one to the parameter to include the upper limit.",
            "",
            ":QUEST24:400:This expression will produce a random number between -45 and +45.",
            ":ANSWER24:T:Greenfoot.getRandomNumber(91) - 45",
            ":ANSWER24:F:Greenfoot.getRandomNumber(45, -45)",
            ":ANSWER24:F:Greenfoot.getRandomNumber(-90) + 45",
            ":ANSWER24:F:Greenfoot.getRandomNumber(-45, 45)",
            ":ANSWERORDER24:randomized",
            ":EXPLANATION24:The Greenfoot method getRandomNumber() returns a random number between 0 (inclusive) and an upper limit (exclusive). Thus the method Greenfoot.getRandomNumber(91) returns a random number between 0 and 90. By subtracting 45, the number shifts to between -45 and +45.",
            "",
            ":QUEST25:500:Use this test condition in an if-statement to randomly decide whether to turn 10% of the time.",
            ":ANSWER25:T:Greenfoot.getRandomNumber(100) < 10",
            ":ANSWER25:F:Greenfoot.getRandomNumber(10) < 100",
            ":ANSWER25:F:turn(Greenfoot.getRandomNumber(-90))",
            ":ANSWER25:F:turn(\"random\") * 10%",
            ":ANSWERORDER25:randomized",
            ":EXPLANATION25:The expression: Greenfoot.getRandomNumber(100) returns a random number between 0 and 99. By testing if the number is < 10, there is a 10% chance of turning when using code like:\n\nif (Greenfoot.getRandomNumber(100) < 10) {\n    // turn statement...\n}",
            "",

            ":CAT6:SCIENTIFIC\nNOTATION",

            "",
            ":QUEST26:100:This test condition says that: x is positive.",
            ":ANSWER26:T:x > 0",
            ":ANSWER26:F:0 > x",
            ":ANSWER26:F:x < 0",
            ":ANSWER26:F:x >= 0",
            ":ANSWERORDER26:randomized",
            ":EXPLANATION26:A positive number is a number greater than zero. The relational operator > means greater than. So the expression (x > 0) means x is positive.",
            "",
            ":QUEST27:200:This test condition says: x is negative.",
            ":ANSWER27:T:x < 0",
            ":ANSWER27:F:x > 0",
            ":ANSWER27:F:0 > x",
            ":ANSWER27:F:x >= 0",
            ":ANSWERORDER27:randomized",
            ":EXPLANATION27:A negative number is a number less than zero. The relational operator < means: less than. So the expression (x < 0) means: x is negative.",
            "",
            ":QUEST28:300:This test condition says that x is zero.",
            ":ANSWER28:T:x == 0",
            ":ANSWER28:F:x = 0",
            ":ANSWER28:F:0 = x",
            ":ANSWER28:F:x is 0",
            ":ANSWERORDER28:randomized",
            ":EXPLANATION28:The equality operator is \"==\" (two equal signs). So the expression (x == 0) means: x is zero.",
            "",
            ":QUEST29:400:This test condition says that x is not equal to y.",
            ":ANSWER29:T:x != y",
            ":ANSWER29:F:x <> y",
            ":ANSWER29:F:x =! y",
            ":ANSWER29:F:x \u2260 y",
            ":ANSWERORDER29:randomized",
            ":EXPLANATION29:The algebra symbol \u2260 is not easy to make on a standard keyboard. Thus two symbols are used for inequality: !=. Code the symbols in the order people normally say them.",
            "",
            ":QUEST30:500:This test condition says that x is greater than y + 1.",
            ":ANSWER30:T:x > y + 1",
            ":ANSWER30:F:x + y = 1",
            ":ANSWER30:F:x < y + 1",
            ":ANSWER30:F:x + 1 > y",
            ":ANSWERORDER30:randomized",
            ":EXPLANATION30:Each operand (side of the operator) can be an arithmetic expression. The arithmetic is preformed before the comparison is made.",
            "",
            ""
        };


        }


