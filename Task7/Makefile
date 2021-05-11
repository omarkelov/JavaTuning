all: Main.class cpuinfo.dll

Main.class: Main.java
	javac -h . Main.java

cpuinfo.dll: Main.c Main.h
	x86_64-w64-mingw32-gcc -I"C:\Program Files\Java\jdk-15\include" -I"C:\Program Files\Java\jdk-15\include\win32" -shared -o cpuinfo.dll Main.c

clean:
	del /s cpuinfo.dll Main.class Main.h
