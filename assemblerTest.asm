.data
A: .word 0x1
B: .word 0x1
C: .word 0x0
.end
.text
LDR R0,A
LDR R1,B
ADD R3,R0,R1
STR R3,C
.end