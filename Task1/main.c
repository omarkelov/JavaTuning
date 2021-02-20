#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#define reverse2bytes(x) (((x)<<8) | ((x)>>8))
#define reverse4bytes(x) ((((x)<<24) & 0xff000000) | (((x)<<8) & 0xff0000) | (((x)>>8) & 0xff00) | (((x)>>24) & 0xff))

#define u1 uint8_t
#define u2 uint16_t
#define u4 uint32_t
#define u8 uint64_t

#define CONSTANT_Utf8 1
#define CONSTANT_Integer 3
#define CONSTANT_Float 4
#define CONSTANT_Long 5
#define CONSTANT_Double 6
#define CONSTANT_Class 7
#define CONSTANT_String 8
#define CONSTANT_Fieldref 9
#define CONSTANT_Methodref 10
#define CONSTANT_InterfaceMethodref 11
#define CONSTANT_NameAndType 12
#define CONSTANT_MethodHandle 15
#define CONSTANT_MethodType 16
#define CONSTANT_Dynamic 17
#define CONSTANT_InvokeDynamic 18
#define CONSTANT_Module 19
#define CONSTANT_Package 20

char *get_constant_name(int tag) {
    switch (tag) {
        case CONSTANT_Utf8:
            return "Utf8";
        case CONSTANT_Integer:
            return "Integer";
        case CONSTANT_Float:
            return "Float";
        case CONSTANT_Long:
            return "Long";
        case CONSTANT_Double:
            return "Double";
        case CONSTANT_Class:
            return "Class";
        case CONSTANT_String:
            return "String";
        case CONSTANT_Fieldref:
            return "Fieldref";
        case CONSTANT_Methodref:
            return "Methodref";
        case CONSTANT_InterfaceMethodref:
            return "InterfaceMethodref";
        case CONSTANT_NameAndType:
            return "NameAndType";
        case CONSTANT_MethodHandle:
            return "MethodHandle";
        case CONSTANT_MethodType:
            return "MethodType";
        case CONSTANT_Dynamic:
            return "Dynamic";
        case CONSTANT_InvokeDynamic:
            return "InvokeDynamic";
        case CONSTANT_Module:
            return "Module";
        case CONSTANT_Package:
            return "Package";
        default:
            return "___UNEXPECTED TAG___";
    }
}

typedef struct cp_info {
    u1 tag;
    u1 *info;
} cp_info;

typedef struct CONSTANT_Class_info {
    u1 tag;
    u2 name_index;
} CONSTANT_Class_info;

typedef struct CONSTANT_Fieldref_info {
    u1 tag;
	u2 class_index;
    u2 name_and_type_index;
} CONSTANT_Fieldref_info;

typedef struct CONSTANT_Methodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
} CONSTANT_Methodref_info;

typedef struct CONSTANT_InterfaceMethodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
} CONSTANT_InterfaceMethodref_info;

typedef struct CONSTANT_String_info {
    u1 tag;
    u2 string_index;
} CONSTANT_String_info;

typedef struct CONSTANT_Integer_info {
    u1 tag;
    u4 bytes;
} CONSTANT_Integer_info;

typedef struct CONSTANT_Float_info {
    u1 tag;
    u4 bytes;
} CONSTANT_Float_info;

typedef struct CONSTANT_Long_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
} CONSTANT_Long_info;

typedef struct CONSTANT_Double_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
} CONSTANT_Double_info;

typedef struct CONSTANT_NameAndType_info {
    u1 tag;
    u2 name_index;
    u2 descriptor_index;
} CONSTANT_NameAndType_info;

typedef struct CONSTANT_Utf8_info {
    u1 tag;
    u2 length;
    u1 *bytes;
} CONSTANT_Utf8_info;

typedef struct CONSTANT_MethodHandle_info {
    u1 tag;
    u1 reference_kind;
    u2 reference_index;
} CONSTANT_MethodHandle_info;

typedef struct CONSTANT_MethodType_info {
    u1 tag;
    u2 descriptor_index;
} CONSTANT_MethodType_info;

typedef struct CONSTANT_Dynamic_info {
    u1 tag;
    u2 bootstrap_method_attr_index;
    u2 name_and_type_index;
} CONSTANT_Dynamic_info;

typedef struct CONSTANT_InvokeDynamic_info {
    u1 tag;
    u2 bootstrap_method_attr_index;
    u2 name_and_type_index;
} CONSTANT_InvokeDynamic_info;

typedef struct CONSTANT_Module_info {
    u1 tag;
    u2 name_index;
} CONSTANT_Module_info;

typedef struct CONSTANT_Package_info {
    u1 tag;
    u2 name_index;
} CONSTANT_Package_info;

typedef struct attribute_info {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 *info;
} attribute_info;

typedef struct field_info {
    u2 access_flags;
    u2 name_index;
    u2 descriptor_index;
    u2 attributes_count;
    attribute_info *attributes;
} field_info;

typedef struct method_info {
    u2 access_flags;
    u2 name_index;
    u2 descriptor_index;
    u2 attributes_count;
    attribute_info *attributes;
} method_info;

typedef struct classfile {
    u4 magic;
    u2 minor_version;
    u2 major_version;
    u2 constant_pool_count;
    cp_info *constant_pool;
    u2 access_flags;
    u2 this_class;
    u2 super_class;
    u2 interfaces_count;
    u2 *interfaces;
    u2 fields_count;
    field_info *fields;
    u2 methods_count;
    method_info *methods;
    u2 attributes_count;
    attribute_info *attributes;
} classfile;

classfile parse_class_file(FILE* file) {
    classfile class_file;

    fread(&class_file.magic, sizeof(class_file.magic), 1, file);
    fread(&class_file.minor_version, sizeof(class_file.minor_version), 1, file);
    fread(&class_file.major_version, sizeof(class_file.major_version), 1, file);
    fread(&class_file.constant_pool_count, sizeof(class_file.constant_pool_count), 1, file);

    class_file.minor_version = reverse2bytes(class_file.minor_version);
    class_file.major_version = reverse2bytes(class_file.major_version);
    class_file.constant_pool_count = reverse2bytes(class_file.constant_pool_count);

    class_file.constant_pool = calloc(class_file.constant_pool_count - 1, sizeof(cp_info));

    for (int i = 0; i < class_file.constant_pool_count - 1; i++) {
        fread(&class_file.constant_pool[i].tag, 1, 1, file);

        switch (class_file.constant_pool[i].tag) {
            case CONSTANT_Utf8:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Utf8_info));
                fread(&((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->length, 2, 1, file);
                ((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->length = reverse2bytes(((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->length);
                ((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->bytes = malloc(((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->length);
                fread(((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->bytes, 1, ((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->length, file);
                break;
            case CONSTANT_Integer:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Integer_info));
                fread(&((CONSTANT_Integer_info*)class_file.constant_pool[i].info)->bytes, 4, 1, file);
                ((CONSTANT_Integer_info*)class_file.constant_pool[i].info)->bytes = reverse4bytes(((CONSTANT_Integer_info*)class_file.constant_pool[i].info)->bytes);
                break;
            case CONSTANT_Float:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Float_info));
                fread(&((CONSTANT_Float_info*)class_file.constant_pool[i].info)->bytes, 4, 1, file);
                ((CONSTANT_Float_info*)class_file.constant_pool[i].info)->bytes = reverse4bytes(((CONSTANT_Float_info*)class_file.constant_pool[i].info)->bytes);
                break;
            case CONSTANT_Long:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Long_info));
                fread(&((CONSTANT_Long_info*)class_file.constant_pool[i].info)->high_bytes, 4, 1, file);
                fread(&((CONSTANT_Long_info*)class_file.constant_pool[i].info)->low_bytes, 4, 1, file);
                ((CONSTANT_Long_info*)class_file.constant_pool[i].info)->low_bytes = reverse4bytes(((CONSTANT_Long_info*)class_file.constant_pool[i].info)->low_bytes);
                ((CONSTANT_Long_info*)class_file.constant_pool[i].info)->high_bytes = reverse4bytes(((CONSTANT_Long_info*)class_file.constant_pool[i].info)->high_bytes);
                i++;
                break;
            case CONSTANT_Double:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Double_info));
                fread(&((CONSTANT_Double_info*)class_file.constant_pool[i].info)->high_bytes, 4, 1, file);
                fread(&((CONSTANT_Double_info*)class_file.constant_pool[i].info)->low_bytes, 4, 1, file);
                ((CONSTANT_Double_info*)class_file.constant_pool[i].info)->low_bytes = reverse4bytes(((CONSTANT_Double_info*)class_file.constant_pool[i].info)->low_bytes);
                ((CONSTANT_Double_info*)class_file.constant_pool[i].info)->high_bytes = reverse4bytes(((CONSTANT_Double_info*)class_file.constant_pool[i].info)->high_bytes);
                i++;
                break;
            case CONSTANT_Class:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Class_info));
                fread(&((CONSTANT_Class_info*)class_file.constant_pool[i].info)->name_index, 2, 1, file);
                ((CONSTANT_Class_info*)class_file.constant_pool[i].info)->name_index = reverse2bytes(((CONSTANT_Class_info*)class_file.constant_pool[i].info)->name_index);
                break;
            case CONSTANT_String:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_String_info));
                fread(&((CONSTANT_String_info*)class_file.constant_pool[i].info)->string_index, 2, 1, file);
                ((CONSTANT_String_info*)class_file.constant_pool[i].info)->string_index = reverse2bytes(((CONSTANT_String_info*)class_file.constant_pool[i].info)->string_index);
                break;
            case CONSTANT_Fieldref:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Fieldref_info));
                fread(&((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->class_index, 2, 1, file);
                fread(&((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->name_and_type_index, 2, 1, file);
                ((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->class_index = reverse2bytes(((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->class_index);
                ((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->name_and_type_index = reverse2bytes(((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->name_and_type_index);
                break;
            case CONSTANT_Methodref:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Methodref_info));
                fread(&((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->class_index, 2, 1, file);
                fread(&((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->name_and_type_index, 2, 1, file);
                ((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->class_index = reverse2bytes(((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->class_index);
                ((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->name_and_type_index = reverse2bytes(((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->name_and_type_index);
                break;
            case CONSTANT_InterfaceMethodref:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_InterfaceMethodref_info));
                fread(&((CONSTANT_InterfaceMethodref_info*)class_file.constant_pool[i].info)->class_index, 2, 1, file);
                fread(&((CONSTANT_InterfaceMethodref_info*)class_file.constant_pool[i].info)->name_and_type_index, 2, 1, file);
                ((CONSTANT_InterfaceMethodref_info*)class_file.constant_pool[i].info)->class_index = reverse2bytes(((CONSTANT_InterfaceMethodref_info*)class_file.constant_pool[i].info)->class_index);
                ((CONSTANT_InterfaceMethodref_info*)class_file.constant_pool[i].info)->name_and_type_index = reverse2bytes(((CONSTANT_InterfaceMethodref_info*)class_file.constant_pool[i].info)->name_and_type_index);
                break;
            case CONSTANT_NameAndType:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_NameAndType_info));
                fread(&((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->name_index, 2, 1, file);
                fread(&((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->descriptor_index, 2, 1, file);
                ((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->name_index = reverse2bytes(((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->name_index);
                ((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->descriptor_index = reverse2bytes(((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->descriptor_index);
                break;
            case CONSTANT_MethodHandle:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_MethodHandle_info));
                fread(&((CONSTANT_MethodHandle_info*)class_file.constant_pool[i].info)->reference_kind, 1, 1, file);
                fread(&((CONSTANT_MethodHandle_info*)class_file.constant_pool[i].info)->reference_index, 2, 1, file);
                ((CONSTANT_MethodHandle_info*)class_file.constant_pool[i].info)->reference_index = reverse2bytes(((CONSTANT_MethodHandle_info*)class_file.constant_pool[i].info)->reference_index);
                break;
            case CONSTANT_MethodType:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_MethodType_info));
                fread(&((CONSTANT_MethodType_info*)class_file.constant_pool[i].info)->descriptor_index, 2, 1, file);
                ((CONSTANT_MethodType_info*)class_file.constant_pool[i].info)->descriptor_index = reverse2bytes(((CONSTANT_MethodType_info*)class_file.constant_pool[i].info)->descriptor_index);
                break;
            case CONSTANT_Dynamic:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Dynamic_info));
                fread(&((CONSTANT_Dynamic_info*)class_file.constant_pool[i].info)->bootstrap_method_attr_index, 2, 1, file);
                fread(&((CONSTANT_Dynamic_info*)class_file.constant_pool[i].info)->name_and_type_index, 2, 1, file);
                ((CONSTANT_Dynamic_info*)class_file.constant_pool[i].info)->bootstrap_method_attr_index = reverse2bytes(((CONSTANT_Dynamic_info*)class_file.constant_pool[i].info)->bootstrap_method_attr_index);
                ((CONSTANT_Dynamic_info*)class_file.constant_pool[i].info)->name_and_type_index = reverse2bytes(((CONSTANT_Dynamic_info*)class_file.constant_pool[i].info)->name_and_type_index);
                break;
            case CONSTANT_InvokeDynamic:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_InvokeDynamic_info));
                fread(&((CONSTANT_InvokeDynamic_info*)class_file.constant_pool[i].info)->bootstrap_method_attr_index, 2, 1, file);
                fread(&((CONSTANT_InvokeDynamic_info*)class_file.constant_pool[i].info)->name_and_type_index, 2, 1, file);
                ((CONSTANT_InvokeDynamic_info*)class_file.constant_pool[i].info)->bootstrap_method_attr_index = reverse2bytes(((CONSTANT_InvokeDynamic_info*)class_file.constant_pool[i].info)->bootstrap_method_attr_index);
                ((CONSTANT_InvokeDynamic_info*)class_file.constant_pool[i].info)->name_and_type_index = reverse2bytes(((CONSTANT_InvokeDynamic_info*)class_file.constant_pool[i].info)->name_and_type_index);
                break;
            case CONSTANT_Module:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Module_info));
                fread(&((CONSTANT_Module_info*)class_file.constant_pool[i].info)->name_index, 2, 1, file);
                ((CONSTANT_Module_info*)class_file.constant_pool[i].info)->name_index = reverse2bytes(((CONSTANT_Module_info*)class_file.constant_pool[i].info)->name_index);
                break;
            case CONSTANT_Package:
                class_file.constant_pool[i].info = malloc(sizeof(CONSTANT_Package_info));
                fread(&((CONSTANT_Package_info*)class_file.constant_pool[i].info)->name_index, 2, 1, file);
                ((CONSTANT_Package_info*)class_file.constant_pool[i].info)->name_index = reverse2bytes(((CONSTANT_Package_info*)class_file.constant_pool[i].info)->name_index);
                break;
            default:
                break;
        }
    }

    return class_file;
}

void print_class_file(classfile class_file) {
    u4 float_val;
	u8 double_val;

    printf("Minor version: %d\n", class_file.minor_version);
    printf("Major version: %d\n", class_file.major_version);

    for (int i = 0; i < class_file.constant_pool_count - 1; i++) {
        printf("#%-6d%-16s", i + 1, get_constant_name(class_file.constant_pool[i].tag));
        switch (class_file.constant_pool[i].tag) {
            case CONSTANT_Utf8:
                for (int j = 0; j < ((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->length; ++j) {
                    printf("%c", ((CONSTANT_Utf8_info*)class_file.constant_pool[i].info)->bytes[j]);
                }
                break;
            case CONSTANT_Integer:
                printf("%d", ((CONSTANT_Integer_info*)class_file.constant_pool[i].info)->bytes);
                break;
            case CONSTANT_Float:
                float_val = ((CONSTANT_Float_info*)class_file.constant_pool[i].info)->bytes;
                if (float_val == 0x7f800000) {
                    printf("Infinity");
                } else if (float_val == 0xff800000) {
                    printf("-Infinity");
                } else if ((float_val >= 0x7f800001 && float_val <= 0x7fffffff) || (float_val >= 0xff800001 && float_val <= 0xffffffff)) {
                    printf("NaN");
                } else {
                    printf("%e", *(float*)(&float_val));
                }
                break;
            case CONSTANT_Long:
                printf("%lld", ((u8)((CONSTANT_Long_info*)class_file.constant_pool[i].info)->high_bytes << 32) + ((CONSTANT_Long_info*)class_file.constant_pool[i].info)->low_bytes);
                i++;
                break;
            case CONSTANT_Double:
                double_val = ((u8)((CONSTANT_Double_info*)class_file.constant_pool[i].info)->high_bytes << 32) + ((CONSTANT_Double_info*)class_file.constant_pool[i].info)->low_bytes;
                if (double_val == 0x7ff0000000000000L) {
                    printf("Infinity");
                } else if (double_val == 0xfff0000000000000L) {
                    printf("-Infinity");
                } else if ((double_val >= 0x7ff0000000000001L && double_val <= 0x7fffffffffffffffL) || (double_val >= 0xfff0000000000001L && double_val <= 0xffffffffffffffffL)) {
                    printf("NaN");
                } else {
                    printf("%e", *(double*)(&double_val));
                }
                i++;
                break;
            case CONSTANT_Class:
                printf("#%d", ((CONSTANT_Class_info*)class_file.constant_pool[i].info)->name_index);
                break;
            case CONSTANT_String:
                printf("#%d", ((CONSTANT_String_info*)class_file.constant_pool[i].info)->string_index);
                break;
            case CONSTANT_Fieldref:
                printf("#%d.#%d", ((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->class_index, ((CONSTANT_Fieldref_info*)class_file.constant_pool[i].info)->name_and_type_index);
                break;
            case CONSTANT_Methodref:
                printf("#%d.#%d", ((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->class_index, ((CONSTANT_Methodref_info*)class_file.constant_pool[i].info)->name_and_type_index);
                break;
            case CONSTANT_InterfaceMethodref:
                break;
            case CONSTANT_NameAndType:
                printf("#%d:#%d", ((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->name_index, ((CONSTANT_NameAndType_info*)class_file.constant_pool[i].info)->descriptor_index);
                break;
            case CONSTANT_MethodHandle:
            case CONSTANT_MethodType:
            case CONSTANT_Dynamic:
            case CONSTANT_InvokeDynamic:
            case CONSTANT_Module:
            case CONSTANT_Package:
            default:
                break;
        }
        printf("\n");
    }
}

int main(int argc, char **argv) {
    if (argc < 2) {
        perror("No filename provided");
        return 13;
    }

    FILE* file;
    if ((file = fopen(argv[1], "rb")) == 0) {
        perror("Cannot open the file");
        return 13;
    }

    classfile class_file = parse_class_file(file);
    fclose(file);

    print_class_file(class_file);

    return 0;
}
