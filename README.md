# SOFTENG 250 Homework 4 for University of Auckland Software Engineering
## Various processing of directed graphs

```
Given a directed graph input, G, the code should do the following:
1.  Output all the vertices that have the same in and out degrees.
2.  Output the average in-degree and the average out-degree of vertices.
3.  Test if G has a cycle.
4.  If G has a cycle, then the code should output at least one cycle.
5.  Test if G has at most 3 cycles.
6.  If the G has no cycles, then the code should output topological ordering of G.
```

*See example inputs and outputs in the ```hw4.pdf``` file and in the ```.txt``` files*

### How Do I Use This? ###
You must have a JRE (Java Runtime Environment) installed. You can download one [here](https://java.com/en/download/).

#### First Method ###
1. Download the executable [`softeng250-hw4.jar`](https://github.com/beverleysun/softeng250-hw4/raw/master/softeng250-hw4.jar) file.
2. Open up the Command Prompt (Windows) or the Terminal (Mac)
3. Navigate to the directory where this file is located.
   * Use `cd folderpath`
3. Use `java -jar softeng250-hw4.jar` to execute the file.

#### Second Method ####
1. Download this [repository](https://github.com/beverleysun/softeng250-hw4/archive/master.zip).
2. Extract the `.zip` file into a directory of your choice.
3. Open up the Command Prompt (Windows) or the Terminal (Mac).
4. Navigate to the extracted folder `softeng250-hw4-master`.
   * Use `cd folderpath`
5. Use `javac -cp ./ src/hw4/Main.java`
6. Use `java src/hw4/Main`
