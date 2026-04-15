 
  # infix-convertor
Converts Infix expressions  to **Postfix** to **Prefix** using java
 Workflow
INPUT: Infix expression (e.g., A+B*C)

POSTFIX (Shunting-Yard Algorithm):
  Scan left → right
  ├─ Operand → append to output
  ├─ '(' → push to stack
  ├─ ')' → pop & output until '('
  └─ Operator → pop higher/equal precedence ops first, then push

PREFIX:
  Reverse the infix expression
  Swap '(' ↔ ')'
  Apply postfix algorithm on reversed expression
  Reverse the result
  2. Pseudocode
Postfix:
function toPostfix(infix):
  output = ""
  stack = empty

  for each token in infix:
    if token is operand:
      output += token
    else if token == '(':
      push token to stack
    else if token == ')':
      while stack.top != '(':
        output += stack.pop()
      stack.pop()   // discard '('
    else (token is operator):
      while stack not empty AND precedence(stack.top) >= precedence(token):
        output += stack.pop()
      push token to stack

  while stack not empty:
    output += stack.pop()

  return output
Prefix:
function toPrefix(infix):
  reverse infix string
  swap each '(' with ')' and vice versa
  result = toPostfix(reversed string)
  return reverse(result)
# How to run
```bash
javac Infixconverter.java
java InfixConverter
___
