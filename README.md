Compile all Java Files (Done everytime when changes are made in any Java files): 
javac -source 1.8 -target 1.8 -d bin -cp ".;lib/algs4.jar" src/*.java

For running the visualizer on Pointplotter.java:
java -cp ".;bin;lib/algs4.jar" PointPlotter input8.txt <- replace input.txt with the file name of txt

For running the visualizer on Pointplotter.java WITH connection (FAST):
Get-Content input8.txt | java -cp ".;bin;lib/algs4.jar" Fast


For running the visualizer on Pointplotter.java WITH connection (BRUTE):
Get-Content input8.txt | java -cp ".;bin;lib/algs4.jar" Brute
