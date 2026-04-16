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
stack = empty# Infix Converter

Converts infix expressions to **Postfix** and **Prefix** using Java.

## 1. Workflow

- Read the infix expression left to right
- Operand → add to output
- ( → push to stack
- ) → pop stack to output until ( is found
- Operator → pop higher or equal precedence operators first, then push
- After scanning → pop all remaining operators to output
- For Prefix: reverse infix, swap brackets, apply postfix, reverse result

## 2. Pseudocode

### Postfix
    function toPostfix(infix):
      output = ""
      stack = empty
      for each token in infix:
        if operand: output += token
        if ( : push to stack
        if ) : pop to output until (
        if operator: pop higher/equal precedence, then push
      pop remaining stack to output
      return output

### Prefix
    function toPrefix(infix):
      reverse infix
      swap ( with ) and vice versa
      result = toPostfix(reversed)
      return reverse(result)

## 3. How to Run

    javac InfixConverter.java
    java InfixConverter

## 4. Sample Output

| Infix     | Postfix | Prefix  |
|-----------|---------|---------|
| A+B*C     | ABC*+   | +A*BC   |
| (A+B)*C   | AB+C*   | *+ABC   |

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
