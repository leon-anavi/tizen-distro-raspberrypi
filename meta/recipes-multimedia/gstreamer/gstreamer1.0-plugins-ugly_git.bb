DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-plugins-ugly.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://tests/check/elements/xingmux.c;beginline=1;endline=21;md5=4c771b8af188724855cb99cadd390068 "

S = "${WORKDIR}/git"

SRCREV = "c12e5d1ad4c5279b2ec5c7d1aec88fea7e5f4f6a"

do_configure() {
	${S}/autogen.sh --noconfigure
	oe_runconf
}

