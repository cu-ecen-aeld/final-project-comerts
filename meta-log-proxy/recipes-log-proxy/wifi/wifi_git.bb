# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#SRC_URI = "git://git@github.com/cu-ecen-aeld/final-project-comerts.git;protocol=ssh;branch=main"

# Modify these as desired
#PV = "1.0+git${SRCPV}"
#SRCREV = "689a5fd6f79d57d1932038ec96fab7ca7df97463"

#S = "${WORKDIR}/git"

FILES:${PN} += "${sysconfdir}/wpa_supplicant2.conf"

# NOTE: no Makefile found, unable to determine what needs to be done

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install:append () {
	# Specify install commands here

	install -d ${D}${sysconfdir}
	install -m 0655 ${THISDIR}/files/wpa_supplicant2.conf ${D}${sysconfdir}/wpa_supplicant2.conf
}

