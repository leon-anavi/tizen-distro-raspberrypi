# Base this image on rpi-hwup-image
include recipes-core/images/rpi-hwup-image.bb
include recipes-image/target-image-common.bb

CORE_IMAGE_EXTRA_INSTALL += "nodejs"
CORE_IMAGE_EXTRA_INSTALL += "nginx"
CORE_IMAGE_EXTRA_INSTALL += "wpa-supplicant wpa-supplicant-cli"
CORE_IMAGE_EXTRA_INSTALL += "openssh"
CORE_IMAGE_EXTRA_INSTALL += "systemd-serialgetty util-linux-agetty procps"
CORE_IMAGE_EXTRA_INSTALL += "v4l2grab"
