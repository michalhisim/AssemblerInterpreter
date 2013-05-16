Assembler Interpreter
=====================

Simple Assembler interpreter written in Java

Testing code `machine-code.asm`
```Assembly
#strings
push S-- strings --
print 0

push S, my name is assembler.
save 1
push SHello World
concat 1
save 1

print 1

#numeric
push S-- numeric --
print 0

push I6
save 2
push I5
add 2
save 2

push I1
save 3
load 2
sub 3
save 3

push I10
save 4
load 3
mul 4
save 4

push I2
save 5
load 4
div 5
save 5

push I3
save 6
load 5
mod 6
save 6

uminus
save 7

prints 6

#booleans
push S-- booleans --
print 0

push Btrue
save 7

push Bfalse
save 8
load 7
and 8
save 8

push Btrue
save 9
load 8
or 9
save 9

push I10
save 10
load 5
gt 10
save 10

push I10
save 11
load 5
lt 11
save 11

not
save 12

push I50
save 13
load 5
eq 13
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
push I5
save 12
push I0
save 14
label 1
load 14
lt 12
fjmp 2
push I1
save 11
load 14
add 11
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
Hello World, my name is assembler.

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
