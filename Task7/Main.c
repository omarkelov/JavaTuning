#include "Main.h"
#include <jni.h>
#include <stdio.h>
#include <windows.h>

JNIEXPORT jobject JNICALL Java_Main_getCpuInfo(JNIEnv *env, jclass cl) {
    jclass jMapClass = (*env)->FindClass(env, "java/util/HashMap");
    jmethodID jInitMethod = (*env)->GetMethodID(env, jMapClass, "<init>", "()V");
    jobject jMap = (*env)->NewObject(env, jMapClass, jInitMethod);
    jmethodID jPutMethod = (*env)->GetMethodID(env, jMapClass, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");

    // ----- Name -----

    char name[64];
    DWORD nameSize = sizeof(name);
    RegGetValueA(HKEY_LOCAL_MACHINE, "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0", "ProcessorNameString", RRF_RT_REG_SZ, NULL, name, &nameSize);

    jstring jNameKey = (*env)->NewStringUTF(env, "name");
    jstring jNameValue = (*env)->NewStringUTF(env, name);
    (*env)->CallObjectMethod(env, jMap, jPutMethod, jNameKey, jNameValue);

    // ----- Cores Number -----

    SYSTEM_INFO sysinfo;
    GetSystemInfo(&sysinfo);
    char cores[64];
    sprintf(cores, "%d", sysinfo.dwNumberOfProcessors);

    jstring jCoresKey = (*env)->NewStringUTF(env, "cores");
    jstring jCoresValue = (*env)->NewStringUTF(env, cores);
    (*env)->CallObjectMethod(env, jMap, jPutMethod, jCoresKey, jCoresValue);

    // ----- Frequency -----

    DWORD freq;
    DWORD freqSize = sizeof(freq);
    RegGetValueA(HKEY_LOCAL_MACHINE, "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0", "~MHz", RRF_RT_DWORD, NULL, &freq, &freqSize);
    char frequency[64];
    sprintf(frequency, "%i", freq);

    jstring jFrequencyKey = (*env)->NewStringUTF(env, "frequency");
    jstring jFrequencyValue = (*env)->NewStringUTF(env, frequency);
    (*env)->CallObjectMethod(env, jMap, jPutMethod, jFrequencyKey, jFrequencyValue);

    return jMap;
}
