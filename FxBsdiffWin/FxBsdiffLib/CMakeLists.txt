cmake_minimum_required(VERSION 3.9)
project(FxBsdiffLib)

set(CMAKE_CXX_STANDARD 11)

add_library(FxBsdiffLib SHARED

        fxbsdiff/bsdiff.cpp
        fxbsdiff/com_cfox_fxjbsdiff_JBsdiff.h
        fxbsdiff/jni.h

        bzip2/blocksort.c
        bzip2/bzlib.c
        bzip2/bzlib.h
        bzip2/bzlib_private.h
        bzip2/compress.c
        bzip2/crctable.c
        bzip2/decompress.c
        bzip2/huffman.c
        bzip2/randtable.c)