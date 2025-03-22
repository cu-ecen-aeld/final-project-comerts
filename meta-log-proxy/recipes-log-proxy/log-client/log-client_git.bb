# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#SRC_URI = "git://git@github.com/comerts/log-client.git;protocol=ssh;branch=main"
#SRCREV = "f02159825a62991120a5d6bb6471990a4b01a262"

SOURCE_PATH = "/home/comert/workspace/ws_linux"
FILESEXTRAPATHS:prepend := "${SOURCE_PATH}:"
SRC_URI = "file://log-client"

#
# Modify these as desired
#V = "1.0+git${SRCPV}"
#PV = "1.0"

#S = "${WORKDIR}/git"
S = "${WORKDIR}/log-client"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.
FILES:${PN} += "${bindir}/log-client"
FILES:${PN} += "${sysconfdir}/rcS.d/S99logclient"

TARGET_LDFLAGS += "-pthread -lrt"
TARGET_CFLAGS += "-Werror -Wall -Wextra -Wno-format-truncation -D_REENTRANT -DDEBUG"
#LDFLAGS += "-pthread -lrt"
#CFLAGS += "-Werror -Wall -Wextra -Wno-format-truncation -D_REENTRANT -DDEBUG"

#INITSCRIPT_PACKAGES = "${PN}"
#INITSCRIPT_NAME = "log-client-start-stop"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
	#$(CXX) $(CFLAGS) $(LDFLAGS) -o log-client func.cpp main.cpp
}

do_install () {
	# TODO: Install your binaries/scripts here.
	# Be sure to install the target directory with install -d first
	# Yocto variables ${D} and ${S} are useful here, which you can read about at 
	# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-D
	# and
	# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-S
	# See example at https://github.com/cu-ecen-aeld/ecen5013-yocto/blob/ecen5013-hello-world/meta-ecen5013/recipes-ecen5013/ecen5013-hello-world/ecen5013-hello-world_git.bb
	
	install -d ${D}${bindir}
	install -m 0755 ${S}/log-client ${D}${bindir}/

	install -d ${D}${sysconfdir}/rcS.d
	install -m 0755 ${S}/log-client-start-stop ${D}${sysconfdir}/rcS.d/S99logclient
}

