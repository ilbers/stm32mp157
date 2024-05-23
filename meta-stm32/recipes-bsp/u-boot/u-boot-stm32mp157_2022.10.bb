# Copyright (C) 2024 ilbers GmbH

require recipes-bsp/u-boot/u-boot-custom.inc

STM32_REV = "2022.10-stm32mp-r1"

SRC_URI += "https://github.com/STMicroelectronics/u-boot/archive/refs/tags/v${STM32_REV}.tar.gz"

SRC_URI[sha256sum] = "a6757779a4d1d960379d7612fd3d453768fc331809faf4ce6368e38e5d573bd5"

DEBIAN_BUILD_DEPENDS += ", swig, python3-setuptools, python3-dev:native, \
    libssl-dev:native, libssl-dev:armhf"

S = "${WORKDIR}/u-boot-${STM32_REV}"

U_BOOT_EXTRA_BUILDARGS = "DEVICE_TREE=stm32mp157d-dk1"

COMPATIBLE_MACHINE = "stm32mp157"
