@file:Suppress("UnstableApiUsage", "PropertyName")

import dev.deftu.gradle.utils.GameSide

plugins {
    id("java")
    alias(libs.plugins.dgt)
    alias(libs.plugins.dgt.resources)
    alias(libs.plugins.dgt.bloom)
    alias(libs.plugins.dgt.shadow)
    alias(libs.plugins.dgt.loom)
}

toolkitLoomHelper {
    // mixins
    useMixinExtras("0.4.+")
    useMixinRefMap(modData.id)
    useForgeMixin(modData.id)
    useTweaker("org.spongepowered.asm.launch.MixinTweaker")

    // run configs
    useDevAuth("1.2.+")
    useProperty("mixin.debug.export", "true", GameSide.CLIENT)
    disableRunConfigs(GameSide.SERVER)
}

repositories {
    maven("https://repo.polyfrost.org/releases")
    maven("https://repo.polyfrost.org/snapshots")
}

dependencies {
    implementation(libs.polymixin)
    shade(libs.polymixin)

    implementation(libs.radbus)
    shade(libs.radbus)
}