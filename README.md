# Infix Converter

Converts infix expressions to **Postfix** and **Prefix** using Java.

---

## 1. Workflow
INPUT: Infix expression (e.g., A+B*C)
POSTFIX (Shunting-Yard Algorithm):
Scan left to right
Operand      → append to output
'('          → push to stack
')'          → pop to output until '('
Operator     → pop higher/equal precedence first, then push
PREFIX:
Reverse the infix expression
Swap '(' with ')' and vice versa
Apply postfix algorithm on reversed expression
Reverse the result
---

## 2. Pseudocode

### Postfix
function toPostfix(infix):
output = ""
stack = empty
for each token in infix:
if token is operand:
output += token
else if token == '(':
push to stack
else if token == ')':
while stack.top != '(':
output += stack.pop()
stack.pop()
else (operator):
while stack not empty AND precedence(stack.top) >= precedence(token):
output += stack.pop()
push token to stack
while stack not empty:
output += stack.pop()
return output
### Prefix
function toPrefix(infix):
reverse infix string
swap '(' with ')' and vice versa
result = toPostfix(reversed string)
return reverse(result)
---

## 3. How to Run

```bash
javac InfixConverter.java
java InfixConverter
