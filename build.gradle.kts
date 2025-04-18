@file:Suppress("UnstableApiUsage", "PropertyName")

import dev.deftu.gradle.utils.GameSide

plugins {
    id("java")
    id("dev.deftu.gradle.tools") version("2.30.0")
    id("dev.deftu.gradle.tools.resources") version("2.30.0")
    id("dev.deftu.gradle.tools.bloom") version("2.30.0")
    id("dev.deftu.gradle.tools.shadow") version("2.30.0")
    id("dev.deftu.gradle.tools.minecraft.loom") version("2.30.0")
}

toolkitLoomHelper {
    // mixins
    useMixinExtras("0.4.1")
    useMixinRefMap(modData.id)
    useForgeMixin(modData.id)
    useTweaker("org.spongepowered.asm.launch.MixinTweaker")

    // run configs
    useDevAuth("1.2.1")
    useProperty("mixin.debug.export", "true", GameSide.CLIENT)
    disableRunConfigs(GameSide.SERVER)
}

repositories {
    maven("https://repo.polyfrost.org/releases")
    maven("https://repo.polyfrost.org/snapshots")
}

dependencies {
    implementation(shade("org.polyfrost:polymixin:0.8.4+build.2") {
        isTransitive = false
    })

    implementation(shade("io.github.nevalackin:radbus:1.0.0") {
        isTransitive = false
    })
}