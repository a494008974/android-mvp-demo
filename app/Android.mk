LOCAL_PATH:= $(call my-dir)/src/main

include $(CLEAR_VARS)
LOCAL_STATIC_JAVA_LIBRARIES := android-support-v4

LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-subdir-java-files,java)
LOCAL_PACKAGE_NAME := ZLauncher
LOCAL_PROGUARD_ENABLED := full
#LOCAL_PROGUARD_FLAG_FILES := proguard.flags
LOCAL_CERTIFICATE := platform
include $(BUILD_PACKAGE)

include $(CLEAR_VARS)

include $(BUILD_MULTI_PREBUILT)