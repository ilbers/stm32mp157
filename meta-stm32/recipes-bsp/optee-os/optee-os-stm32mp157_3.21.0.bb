# Copyright (C) 2024 ilbers GmbH

require recipes-bsp/optee-os/optee-os-custom.inc

SRC_URI += "https://github.com/OP-TEE/optee_os/archive/${PV}.tar.gz;downloadfilename=optee_os-${PV}.tar.gz"
SRC_URI[sha256sum] = "92a16e841b0bdb4bfcb1c20b6a1bd3309092203d534ed167dfdb5a5f395bf60b"

S = "${WORKDIR}/optee_os-${PV}"

DEBIAN_BUILD_DEPENDS += ", device-tree-compiler, python3-cryptography:native"

OPTEE_PLATFORM = "stm32mp1-157A_DK1"
OPTEE_EXTRA_BUILDARGS = " \
    TEE_IMPL_VERSION=${PV} \
    ARCH=arm CFG_EMBED_DTB_SOURCE_FILE=stm32mp157a-dk1.dts \
    CFG_TEE_CORE_LOG_LEVEL=2"
OPTEE_BINARIES = "tee-header_v2.bin tee-pageable_v2.bin tee-pager_v2.bin"

COMPATIBLE_MACHINE = "stm32mp157"
