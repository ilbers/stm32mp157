# Copyright (C) 2024 ilbers GmbH

require recipes-bsp/trusted-firmware-a/trusted-firmware-a-custom.inc

STM32_REV = "2.4-stm32mp-r2.3"

SRC_URI += "https://github.com/STMicroelectronics/arm-trusted-firmware/archive/refs/tags/v${STM32_REV}.tar.gz"

SRC_URI[sha256sum] = "b7d7e39fbc5490076415c62f36cbc712c1d49c9089a753e0376b80b374e7273c"

S = "${WORKDIR}/arm-trusted-firmware-${STM32_REV}"

DEPENDS = "u-boot-${MACHINE} optee-os-${MACHINE}"

DEBIAN_BUILD_DEPENDS += ", optee-os-${MACHINE}, u-boot-${MACHINE}, \
    device-tree-compiler, git, libssl-dev:native"

TF_A_PLATFORM = "stm32mp1"
TF_A_EXTRA_BUILDARGS = " \
    ARCH=aarch32 ARM_ARCH_MAJOR=7 \
    STM32MP_SDMMC=1 DTB_FILE_NAME=stm32mp157d-dk1.dtb \
    AARCH32_SP=optee \
    BL32=/usr/lib/optee-os/${MACHINE}/tee-header_v2.bin \
    BL32_EXTRA1=/usr/lib/optee-os/${MACHINE}/tee-pager_v2.bin \
    BL32_EXTRA2=/usr/lib/optee-os/${MACHINE}/tee-pageable_v2.bin \
    BL33=/usr/lib/u-boot/${MACHINE}/u-boot-nodtb.bin \
    BL33_CFG=/usr/lib/u-boot/${MACHINE}/u-boot.dtb \
    FW_CONFIG=fdts/stm32mp157d-dk1-fw-config.dts all fip"
TF_A_BINARIES = "release/tf-a-stm32mp157d-dk1.stm32 release/fip.bin"

COMPATIBLE_MACHINE = "stm32mp157"
