# Infix Converter
Converts infix expressions to Postfix and Prefix using Java.

## 1. Workflow
1. Read the infix expression left to right
2. Operand → add to output
3. ( → push to stack
4. ) → pop stack to output until (
5. Operator → pop higher/equal precedence first, then push
6. After scanning → pop all remaining operators to output
7. For Prefix: reverse infix, swap brackets, apply postfix, reverse result

## 2. Pseudocode
function toPostfix(infix):
for each token:
if operand: output += token
if (: push to stack
if ): pop to output until (
if operator: pop higher precedence, then push
pop remaining stack to output
return output
## 3. How to Run
javac InfixConverter.java
java InfixConverter
