STUDENT DETAILS

- Jonathan Duketis : 6883826
- Dylan Naumovski : 100579461

*********************************************************************************************

FEATURES

- The program runs using the command prompt with the format: 'run.bat <filename> <method>'
- Truth Table Uses a Knowledge base taken from the test file by the user
- Truth Table algorithm
- Forward Chaining Method
- Backward Chaining Method
- BC and FC take ASK and TELL as string parameters. They take the input using file reader in main which
reads the 2nd (TELL clauses) and 4th (ASK proposition symbol) line of the text file.

*********************************************************************************************

KNOWN BUGS

- Truth table produces a YES:1 with all test results
- BC method producing funky results with different tests


*********************************************************************************************

MISSING

-

*********************************************************************************************

TEST CASES


Test Case 1

TELL
p2=> p3; p3 => p1; c => e; b&e => f; f&g => h; p1=>d; p1&p3 => c; a; b; p2;
ASK
d

------------------------------------------------------------------------------------

Test Case 2

TELL
p1&p2&p3=> p4; p5&p6 => p4; p1 => p2; p1&p2 => p3; p5&p7 => p6; p1; p4;
ASK
p7

------------------------------------------------------------------------------------

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
  This website helped us develop the readInFile class.
  It helped us understand how to use the buffer reader classes and then from there, we were able
  to organize the variables to be used in the other classes.

- http://w7r.blogspot.com.au/2012/03/creating-truth-tables-for-your-java.html
  This website gave us better understanding of how to implement our truth table. 
  
- https://stackoverflow.com/questions/12862109/how-does-the-backward-chaining-algorithm-work-in-first-order-logic/12884344?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
  This url gave us a deeper understanding in reference to backward-chaining and how the algorithm works.
 
- http://snipplr.com/view/56296/ai-forward-chaining-implementation-for-propositional-logic-horn-form-knowledge-bases/
  This link gave us an insight to how to implement the forward chaining algorithm
  - https://stackoverflow.com/questions/6091772/forward-chaining-and-backward-chaining-in-java
  Understanding forward and backward chaining.



*********************************************************************************************

SUMMARY REPORT

TEAM MEMBER CONTRIBUTIONS:

- Jonathan worked on: readInTestFile.java (100%), tellAskSentence.java (80%), fChaining.java(50%), bChaining.java(50%),
 main(50%), TruthTable(50%)

- Dylan worked on: KnowledgeBase.java (100%), tellAskSentence.java (20%), bChaining.java(50%), fChaining.java(50%),
main(50%), TruthTable(50%), getSetSymbol(100%)

GENERAL COMMENTS
- To communicate we used Facebook Messenger but mostly our communication was face to face. 
- We used gitHub for version control and Intelli J by JetBrains for our IDE. 
- The language we used for this project is Java.

Because of the last minute collaboration (last week before due date), most feedback was given face to face.
We met up every day at uni to work on the assignment for approximately 12 hours a day.





