import org.jetbrains.kotlin.builtins.StandardNames.FqNames.target
import java.util.Calendar.YEAR

/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("room_version", "2.5.2")
    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("com.android.library") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
//    hilt as kapt to ksp
//    id("com.google.devtools.ksp") version "1.8.20-1.0.9"
    id("com.google.devtools.ksp") version "1.9.0-1.0.12"
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
//    kotlin("kapt") version "1.9.0"

//    spotless and ktlint
    id("org.jlleitschuh.gradle.ktlint") version "11.6.0"
    id("com.diffplug.spotless") version "6.21.0"
}
spotless {
    kotlin {
        // by default the target is every '.kt' and '.kts` file in the java sourcesets
//        ktfmt()    // has its own section below
        ktlint() // has its own section below
//        diktat()   // has its own section below
//        prettier() // has its own section below
        licenseHeader("/* (C) $YEAR */") // or licenseHeaderFile
    }
    kotlinGradle {
        target("*.gradle.kts", "app/src/main/java/com/example/inventory/**") // default target for kotlinGradle
        ktlint() // or ktfmt() or prettier()
    }
}

// tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
// }
