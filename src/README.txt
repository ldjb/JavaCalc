##############################
##   Java Calculator 2012   ##
## Developed by Leon Byford ##
##   <ldjb20@bath.ac.uk>    ##
##############################

-- [00] TABLE OF CONTENTS --

    01: Running the program
    02: Using the calculator
    03: Storing results for further computations
    04: Quitting the program
    05: Extending the program


-- [01] RUNNING THE PROGRAM --

※ These instructions assume that the program has already been compiled with
  javac.

The main class is Calculator. Therefore, the program can be run from the command
line using the following command:

    $ java Calculator

If the program is run in an environment that supports a graphical user
interface (GUI), the program's GUI mode will start. Otherwise, the command-line
interface (CLI) mode will start. To use the CLI mode in a GUI environment, use
the following command:

    $ java Calculator force-cli


-- [02] USING THE CALCULATOR --

The calculator functions similarly regardless of whether you are using the CLI
or GUI mode.

In CLI mode, type a mathematical expression at the command line, and press the
RETURN key to submit it.

In GUI mode, type a mathematical expression into the text field, then either
press the RETURN key or click the button to submit it.

When submitted, the expression will be evaluated and the result will be
displayed.

Mathematical expressions should use infix notation and can use addition,
subtraction, multiplication and division operators as well as parentheses.

Some examples of valid expressions that can be entered are:

    5 + 6 * 2
    (5 + 4) * (4 - 2)
    (4 + (2 * (2 - 1))) * 1.2
    -2 / 4


-- [03] STORING RESULTS FOR FURTHER COMPUTATIONS --

Results of calculations can be stored to be used in future calculations. To do
this, first enter and submit a mathematical expression. The result will be
displayed. Then, type "STORE" and submit the input. A message will indicate that
the result has been stored. The string "VAR" will then be substituted with this
result in future calculations. For example:

     Input: 3 + 5
    Output: 8
     Input: STORE
    Output: Stored. "VAR" will be substituted with result.
     Input: VAR / 2
    Output: 4


-- [04] QUITTING THE PROGRAM --

To quit the calculator program whilst in CLI mode, submit the "QUIT" command.

To quit the calculator program whilst in GUI mode, close the interface window.


-- [05] EXTENDING THE PROGRAM --

It is possible to extend the calculator program to use mathematical operators
not already included. Instructions on how to do this can be found in a separate
document, Extension.txt.