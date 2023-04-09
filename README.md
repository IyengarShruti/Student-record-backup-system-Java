## Student Record System

-----------------------------------------------------------------------
## COMMANDS TO RUN:

My folder path in Remote 
/Desktop/NewDPAssign2/cs542-fall-22-assign2-siyenga1

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentRecordsBackupTree/src folder.
#### Note: bstInput.txt (sample input file) is present in studentRecordsBackupTree/ folder.
/Desktop/NewDPAssign2/cs542-fall-22-assign2-siyenga1/studentRecordsBackupTree/

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0="bstInput.txt" -Darg1="bstOutput.txt" -Darg2="errorLog.txt" -Darg3="debug_Level" -Darg4="UPDATE_VALUE" 

eg:

ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0="bstInput.txt" -Darg1="bstOutput.txt" -Darg2="errorLog.txt" -Darg3="3" -Darg4="2" 
-----------------------------------------------------------------------

## Description:
-----------------------------------------------------------------------
Aim of the assignment is to build BST trees using Observer Pattern(to store backup systems).

# Design Flow: 
The Driver code checks exceptions related to file and invokes BSTBuilder methods.The BSTBuilder class is used as a helper class to build the three trees: main, backup1 and backup2. The fileInvokerMethod() will invoke the readInput() of the FileProcessor class and read input file line by line and return it to helperforInsert() function of the BSTBuilder class. The insertNode() of the BST class is invoked from here. The helperforPrint() helps to send information to file and console for printing. LogError class is used to write the data to error file and display on console. Results class implements the fileDisplayInterface and the StdOutInterface to display in file and on the terminal. NodeImpl class stores node information. It implements Subject interface which is IObservable and observer interface which is IObserver. The observers are stored in an ArrayList. The observer pattern is implied when the update is performed only on the main tree (each node ) and updated data gets copied to rest of the trees on each node.

# Justification for the choice of data structures:
 The worst case time complexity for BST insert/update is O(n) and it's average case time complexity is the depth of the tree O(log n). As vectors' space requirement grows exponentially while syncing, copying data will take a lot of time. Thus, using an Arraylist is a better choice for this assignment.

-----------------------------------------------------------------------
## Citations: 
-----------------------------------------------------------------------
1)BST Basics:

https://www.geeksforgeeks.org/construct-a-binary-in-level-order-using-recursion/

2)How to append comma to lists:

https://www.techiedelight.com/print-list-elements-separated-by-comma-java/

-----------------------------------------------------------------------
# DesignPatterns
# DesignPatterns
# Design patterns
# Design-Patterns--Student-record-backup-system

