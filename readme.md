## This is a work log console aplication 
It is meant to make the logging of the hours you are working easier by just prompting the console every n minutes that the user sets.
This only saves the worklog on a file for now.

### How to use it
1. Clone it in your computer (you should have JDK installed)
2. cd /to/cloned/path
3. javac InputDialogInFrame.java&& java InputDialogInFrame HH - hour you want to finish working, ex: 17 or 16 it should be in 24H format
4. Just minimize the terminal and start working... you will be prompted to enter the task code every 30 minutes;
5. The data will be saved on the file.csv format in the ./storage/ dir.
6. You can add an extra argument (3.) HH MM > what is the finish hour and the wait time to show the box.