Assembler Interpreter
=====================

Simple Assembler interpreter written in Java

Testing code `machine-code.asm`
```Assembly
#strings
push S-- strings --
print 0

push SHello World
concat S, my name s assembler.
save 1

prints 1

#numeric
push S-- numeric --
print 0

push I5
add I6
save 2

sub I1
save 3

mul I10
save 4

div I2
save 5

mod I3
save 6

uminus
save 7

prints 6

#booleans
push S-- booleans --
print 0

push Btrue
save 7

and Bfalse
save 8

or Btrue
save 9

load 5
gt I10
save 10

load 5
lt I10
save 11

not
save 12

load 5
eq I50
save 13

prints 6

#cycle with if condition
push S-- cycle with if condition --
print 0

#bumper
push S------------
save 13

print 13

#cycle begin
push I0
save 14
label 1
load 14
lt I5
fjmp 2
load 14
add I1
save 14
print 14
jmp 1
label 2
#cycle end

print 13
```

Output of `machine-code.asm`
```
Preprocesing file: ../machine-code.asm
-- strings --
Hello World, my name s assembler.

-- numeric --
11
10
100
50
2
-2

-- booleans --
true
true
false
true
true

-- cycle with if condition --
------------
1
2
3
4
5
------------
```
