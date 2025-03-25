inherit core-image
CORE_IMAGE_EXTRA_INSTALL += "log-proxy"
CORE_IMAGE_EXTRA_INSTALL += "log-client"
CORE_IMAGE_EXTRA_INSTALL += "openssh"
IMAGE_INSTALL:append = " wireless-regdb-static"
WIRELESS_REGDOM = "TR"
SERIAL_CONSOLES = "115200;tty0"
inherit extrausers
# See https://docs.yoctoproject.org/singleindex.html#extrausers-bbclass
# We set a default password of root to match our busybox instance setup
# Don't do this in a production image
# PASSWD below is set to the output of
# printf "%q" $(mkpasswd -m sha256crypt root) to hash the "root" password
# string
PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"
IMAGE_FSTYPES = "wic.zip"