# Copyright (C) 2024 ilbers GmbH

require recipes-kernel/linux/linux-custom.inc

STM32_REV = "6.1-stm32mp-r1.1"

SRC_URI += "https://github.com/STMicroelectronics/linux/archive/refs/tags/v${STM32_REV}.tar.gz \
    file://fragment-01-multiv7_cleanup.cfg \
    file://fragment-02-multiv7_addons.cfg \
"

SRC_URI[sha256sum] = "1e7123ed27223b0d3f4d3ed2c66a51145951ed0b502def92ea007e565746409d"

S = "${WORKDIR}/linux-${STM32_REV}"

KBUILD_DEPENDS:append = "lzop, u-boot-tools"

KERNEL_DEFCONFIG = "multi_v7_defconfig"

LINUX_VERSION_EXTENSION = "-isar"

KERNEL_EXTRA_BUILDARGS = "LOADADDR=0xC2000040"

COMPATIBLE_MACHINE = "stm32mp157"
