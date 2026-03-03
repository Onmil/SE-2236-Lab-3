Compile all Java Files:
javac -source 1.8 -target 1.8 -d bin -cp ".;lib/algs4.jar" src/*.java

For running the visualizer on Pointplotter.java:
java -cp ".;bin;lib/algs4.jar" PointPlotter input8.txt

For running the visualizer on Pointplotter.java WITH segmentation (FAST):
Get-Content input8.txt | java -cp ".;bin;lib/algs4.jar" Fast
