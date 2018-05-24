STUDENT DETAILS

- Jonathan Duketis : 6883826
- Dylan Naumovski : 100579461

*********************************************************************************************

FEATURES

- The program runs using the command prompt with the format: 'run.bat <filename> <method>'
- Truth Table Uses a Knowledge base taken from the test file by the user
- Truth Table algorithm working 
- Forward Chaining Method working
- Backward Chaining Method working
- BC and FC take ASK and TELL as string parameters. They take the input using file reader in main which reads the 2nd (TELL clauses) and 4th (ASK proposition symbol) line of the text file.

*********************************************************************************************

BUGS 

-Truth table produces a YES:1 

*********************************************************************************************

MISSING

-null

*********************************************************************************************

TEST CASES

Test Case 1

TELL
p2=> p3; p3 => p1; c => e; b&e => f; f&g => h; p1=>d; p1&p3 => c; a; b; p2;
ASK
d



Test Case 2

TELL
p1&p2&p3=> p4; p5&p6 => p4; p1 => p2; p1&p2 => p3; p5&p7 => p6; p1; p4;
ASK
p7


Test Case 3 - Generic KB 

TELL
(a <=> (c => ~d)) & b & (b => a); c; ~f \/ g;
ASK
d


*********************************************************************************************

RESOURCES

- Artificial Intelligence: A modern approach
  This textbook helped us understand the backward/forward chaining and truth table algorithms by providing pseudo code.

- https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
  This website helped us develop the readInFile class. It helped us understand how to use the buffer reader classes and then from there, we were able to organize the variables to be used in the other classes.

- <<ADD MORE RESOURCES HERE>>


*********************************************************************************************

SUMMARY REPORT

In this assignment:

- Jonathan worked on: readInTestFile.java (100%), tellAskSentence.java (60%), fChaining.java(40%), bChaining.java(50%), Main(50%), <<UPDATE>>
- Dylan worked on: KnowledgeBase.java (100%), tellAskSentence.java (40%) bChaining.java(50%), fChaining.java(60%), Main(50%), <<UPDATE>>

- To communicate we used Facebook Messenger but mostly our communication was face to face. 
- We used gitHub for version control and Intelli J by JetBrains for our IDE. 
- The language we used for this project is Java.

Because of the last minute collaboration (last week before due date), most feedback was given face to face. We met up every day at uni to work on the assignment for approximately 12 hours a day.





