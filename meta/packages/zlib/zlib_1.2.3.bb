DESCRIPTION = "Zlib Compression Library"
SECTION = "libs"
PRIORITY = "required"
HOMEPAGE = "http://www.gzip.org/zlib/"
LICENSE = "zlib"
PR = "r4"

SRC_URI = "http://www.zlib.net/zlib-1.2.3.tar.bz2 \
		file://1.2.3.3.dfsg.patch.gz;patch=1 \
		file://visibility.patch;patch=1 \
		file://autotools.patch;patch=1 "

S = "${WORKDIR}/zlib-${PV}"

DEPENDS = "libtool-cross"

inherit autotools

do_stage() {
	install -m 0644 zlib.h ${STAGING_INCDIR}/
	install -m 0644 zconf.h ${STAGING_INCDIR}/
	install -m 0644 zlibdefs.h ${STAGING_INCDIR}/
	oe_libinstall -a -so libz ${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${prefix} ${D}${includedir} ${D}${libdir}
	oe_runmake "prefix=${D}${prefix}" \
		   "exec_prefix=${D}${exec_prefix}" \
		   "man3dir=${D}${mandir}/man3" \
		   "includedir=${D}${includedir}" \
		   "libdir=${D}${libdir}" install
}
