# Minivm
*btw this is a project to learn java*

### Register
****
#### Pointer Register
```
ip = instruction pointer
sp = Stack pointer
bp = base pointer
```
****
##### Control Register
```
zf = zero flag 
sf = sign flag
cf = call flag (created for my vm to check succes of last syscall)
```
****
#### Data Register
`a, b, c, d` (maybe will give real register name)


#### Instruction
###### Two operand instruction
```
add = addition
sub = substraction
mul = multiplication
div = division
xor = exclusive or 
mov = the value of the first operand will be identical to the second operand
cmp = compare the first and the last operand
```
###### One operand instruction
```
push = put the value on the top of the stack
pop = Loads the value from the top of the stack to the location specified
inc = incrementation
dec = decrementation
jmp = jump to the instruction pointed by the integer provided
je = jump if zero flag is equal to 1
jne = jump if zero flag is equal to 0
jge = jump if sign flag is equal to 0
jg = jump if sign flag is equal to 0 and zero flag equal 0
jle = jump if sign flag is equal to 1
jl = jump if sign flag is equal to 1 and zero flag equal 0
jz = jump if zero flag is equal to 1
jnz = jump if zero flag is equal to 0
```
###### Syscall
```
print = print a message with element in the stack
```


