require libx11.inc

DESCRIPTION += " Support for XCMS is disabled in this version."

PR = "${INC_PR}.0"

DEPENDS += "libxcb xproto xextproto xtrans libxau kbproto inputproto xf86bigfontproto xproto-native"

SRC_URI += "file://x11_disable_makekeys.patch \
            file://keysymdef_include.patch \
            file://makekeys_crosscompile.patch"

RPROVIDES_${PN}-dev = "libx11-dev"
RPROVIDES_${PN}-locale = "libx11-locale"

SRC_URI[md5sum] = "78b4b3bab4acbdf0abcfca30a8c70cc6"
SRC_URI[sha256sum] = "c382efd7e92bfc3cef39a4b7f1ecf2744ba4414a705e3bc1e697f75502bd4d86"
