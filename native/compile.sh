# mac os only, sorry
mkdir -p ../build
clang -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin/" -o ../build/libtest.jnilib -shared test.c
