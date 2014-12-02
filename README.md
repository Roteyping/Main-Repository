Main-Repository
===============

To setup the project just point $JAVA_HOME variable to the right version of java path

In Mac 
------
you can add following line to .profile file in your home directory

JAVA_HOME=`/usr/libexec/java_home -v 1.7`
   export JAVA_HOME
   PATH=$PATH:$JAVA_HOME/bin
   
Then go to the project folder 
Make sure gradlew is executable

run chmod +x gradlew

and finally

run ./gradlew. This should build the project.

