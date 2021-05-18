#include "graalvm/llvm/polyglot.h"
#include <ctype.h>
#include <stdio.h>
#include <string.h>

char *trim(char *str) {
    while (isspace(str[0])) str++;
    if (str[0] == '\0') return str;

    char *end = str + strlen(str) - 1;
    while (isspace(end[0])) end--;
    end[1] = '\0';
  
    return str;
}

void *getCpuInfo() {
    void *mapClass = polyglot_java_type("java.util.HashMap");
    void *map = polyglot_new_instance(mapClass);

    FILE *file;
    if (!(file = fopen("/proc/cpuinfo", "r"))) {
        printf("Cannot open /proc/cpuinfo\n");
        return map;
    }

    for (;;) {
        char buffer[1024];
        if (!fgets(buffer, sizeof(buffer), file) || buffer[0] == '\n') {
            break;
        }

        char *key = strtok(buffer, ":");
        char *value = strtok(NULL, ":");

        key = trim(key);
        value = trim(value);

        void *jKey = polyglot_from_string(key, "US-ASCII");
        void *jValue = polyglot_from_string(value, "US-ASCII");

        polyglot_invoke(map, "put", jKey, jValue);
    }

    fclose(file);

    return map;
}
