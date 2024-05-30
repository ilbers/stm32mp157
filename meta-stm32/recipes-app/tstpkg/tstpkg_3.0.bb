# Copyright (C) 2024 ilbers GmbH

inherit dpkg-raw

do_install() {
    install -v -d ${D}/var/lib/${PN}
    echo "3.0" > ${D}/var/lib/${PN}/version
}
