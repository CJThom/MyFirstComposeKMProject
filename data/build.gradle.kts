plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("app.cash.sqldelight")
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {

    android()
    jvm("desktop") {
        jvmToolchain(11)
    }
    sourceSets {
        val commonMain by getting {

            dependencies {
         //       implementation(project(":common"))
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("io.insert-koin:koin-core:3.3.3")
            }
        }
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }
        val androidMain by getting {
            dependencies {
                //dependsOn(commonMain)

                api("androidx.core:core-ktx:1.9.0")
                implementation("app.cash.sqldelight:android-driver:2.0.0-alpha05")

                implementation("io.insert-koin:koin-core:3.3.3")
                implementation("io.insert-koin:koin-android:3.3.3")

                implementation("io.insert-koin:koin-core:3.3.3")
            }
        }
//        val androidTest by getting {
//            dependencies {
//                implementation("junit:junit:4.13.2")
//            }
//        }
        val desktopMain by getting {
            dependencies {
                implementation("app.cash.sqldelight:sqlite-driver:2.0.0-alpha05")
                implementation("io.insert-koin:koin-core:3.3.3")
            }
        }
        // val desktopTest by getting
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 25
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    namespace = "com.example.data.common"

}

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.example.data")
        }
    }
}