inherit libc-common
inherit libc-package

INHIBIT_DEFAULT_DEPS = "1"

# License applies to this recipe code, not the toolchain itself
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PROVIDES = "\
	linux-libc-headers \
	virtual/arm-none-linux-gnueabi-gcc \
	virtual/arm-none-linux-gnueabi-g++ \
	virtual/arm-none-linux-gnueabi-gcc-initial \
	virtual/arm-none-linux-gnueabi-gcc-intermediate \
	virtual/arm-none-linux-gnueabi-binutils \
	virtual/arm-none-linux-gnueabi-libc-for-gcc \
	virtual/arm-none-linux-gnueabi-compilerlibs \
	virtual/libc \
	virtual/libintl \
	virtual/libiconv \
	glibc-thread-db \
	libgcc \
	virtual/linux-libc-headers "
RPROVIDES = "glibc-utils libsegfault glibc-thread-db"
PACKAGES_DYNAMIC = "glibc-gconv-*"
PR = "r2"

#SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-linux-gnueabi/arm-${PV}-arm-none-linux-gnueabi-i686-pc-linux-gnu.tar.bz2"

SRC_URI = "file://SUPPORTED"

do_install() {
	install -d ${D}${sysconfdir} ${D}${bindir} ${D}${sbindir} ${D}${base_bindir} ${D}${libdir}
	install -d ${D}${base_libdir} ${D}${base_sbindir} ${D}${datadir}

	cp -a ${EXTERNAL_TOOLCHAIN}/arm-none-linux-gnueabi/libc/lib/*  ${D}${base_libdir}
	cp -a ${EXTERNAL_TOOLCHAIN}/arm-none-linux-gnueabi/libc/etc/*  ${D}${sysconfdir}
	cp -a ${EXTERNAL_TOOLCHAIN}/arm-none-linux-gnueabi/libc/sbin/* ${D}${base_sbindir}
	cp -a ${EXTERNAL_TOOLCHAIN}/arm-none-linux-gnueabi/libc/usr/*  ${D}/usr

	sed -i -e "s# /lib# ../../lib#g" -e "s# /usr/lib# .#g" ${D}${libdir}/libc.so
	sed -i -e "s# /lib# ../../lib#g" -e "s# /usr/lib# .#g" ${D}${libdir}/libpthread.so
}

GLIBC_INTERNAL_USE_BINARY_LOCALE ?= "compile"

PACKAGES += "libgcc libgcc-dev libstdc++ libstdc++-dev linux-libc-headers linux-libc-headers-dev"
FILES_libgcc = "${base_libdir}/libgcc_s.so.1"
FILES_libgcc-dev = "${base_libdir}/libgcc_s.so"
FILES_libstdc++ = "${libdir}/libstdc++.so.*"
FILES_libstdc++-dev = "${includedir}/c++/${PV} \
	${libdir}/libstdc++.so \
	${libdir}/libstdc++.la \
	${libdir}/libstdc++.a \
	${libdir}/libsupc++.la \
	${libdir}/libsupc++.a"
FILES_linux-libc-headers = "${includedir}/asm* \
	${includedir}/linux \
	${includedir}/mtd \
	${includedir}/rdma \
	${includedir}/scsi \
	${includedir}/sound \
	${includedir}/video \
"
