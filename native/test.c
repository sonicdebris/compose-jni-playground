#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

int i = 0;
    
JNIEXPORT jint JNICALL Java_com_test_Foo_nextNumber(JNIEnv *env, jobject object) {
    
    return i++;
}
    
#ifdef __cplusplus
}
#endif
