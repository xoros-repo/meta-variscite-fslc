DESCRIPTION = "Firmware files for use with BCM4343w WIFI and Bluetooth"
S = "${WORKDIR}/git"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=8cba1397cda6386db37210439a0da3eb"

PV = "0.43"
PR = "r1"

PROVIDES += "bcm4343w-fw"

SRC_URI = "git://github.com/varigit/bcm_4343w_fw.git;protocol=git;branch=imx-rel_imx_4.1.15_2.0.1_ga-var02"
SRCREV = "2523d192b429fcb9ab910b4e54b2451821d90c3e"

do_install() {
	install -d ${D}/lib/firmware/brcm
	install -d ${D}/lib/firmware/bcm
	install -m 0755 ${S}/brcm/* ${D}/lib/firmware/brcm/
	install -m 0755 ${S}/*.hcd ${D}/lib/firmware/bcm
	install -m 0644 ${S}/LICENSE ${D}/lib/firmware/bcm/
	install -m 0644 ${S}/LICENSE ${D}/lib/firmware/brcm/
}

FILES_${PN} =  "/lib/firmware/brcm/*"
FILES_${PN} += "/lib/firmware/bcm/*"
