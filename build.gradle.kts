import babric.SubprojectHelpers.addDependencyXML
import org.gradle.internal.extensions.stdlib.toDefaultLowerCase
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URI
import java.net.URL

plugins {
	id("maven-publish")
	id("fabric-loom") version "1.9.2"
	id("babric-loom-extension") version "1.9.3"
}

// https://stackoverflow.com/a/40101046 - Even with kotlin, gradle can't get it's shit together.
inline fun <reified C> Project.configure(name: String, configuration: C.() -> Unit) {
	(tasks.getByName(name) as C).configuration()
}

allprojects
{
	apply(plugin = "maven-publish")
	apply(plugin = "fabric-loom")
	apply(plugin = "babric-loom-extension")

	java.sourceCompatibility = JavaVersion.VERSION_17
	java.targetCompatibility = JavaVersion.VERSION_17

	repositories {
		maven("https://maven.glass-launcher.net/snapshots/")
		maven("https://maven.glass-launcher.net/releases/")
		maven("https://maven.glass-launcher.net/babric")
		maven("https://maven.minecraftforge.net/")
		maven("https://jitpack.io/")
		mavenCentral()
		exclusiveContent {
			forRepository {
				maven("https://api.modrinth.com/maven")
			}
			filter {
				includeGroup("maven.modrinth")
			}
		}
	}

	configurations {
		val transitiveImplementation = create("transitiveImplementation")
		implementation.get().extendsFrom(transitiveImplementation)

		// Required cause loom 0.14 for some reason doesn't remove asm-all 4.1. Ew.
		all {
			exclude(group = "org.ow2.asm", module = "asm-debug-all")
			exclude(group = "org.ow2.asm", module = "asm-all")
		}
	}

	dependencies {
		implementation("org.slf4j:slf4j-api:1.8.0-beta4")
		implementation("org.apache.logging.log4j:log4j-slf4j18-impl:2.17.2")

		implementation("org.apache.logging.log4j:log4j-core:2.17.2")
		implementation("com.google.guava:guava:33.2.1-jre")
		implementation("com.google.code.gson:gson:2.9.0")

		minecraft("com.mojang:minecraft:b1.7.3")
		mappings("net.glasslauncher:biny:${project.properties["yarn_mappings"]}:v2")
		modImplementation("babric:fabric-loader:${project.properties["loader_version"]}")

		"transitiveImplementation"("org.apache.commons:commons-lang3:3.12.0")
		"transitiveImplementation"("commons-io:commons-io:2.11.0")
		"transitiveImplementation"("net.jodah:typetools:${project.properties["typetools_version"]}")
		"transitiveImplementation"("com.github.mineLdiver:UnsafeEvents:${project.properties["unsafeevents_version"]}")
		"transitiveImplementation"("it.unimi.dsi:fastutil:${project.properties["fastutil_version"]}")
		//noinspection GradlePackageUpdate
		"transitiveImplementation"("com.github.ben-manes.caffeine:caffeine:${project.properties["caffeine_version"]}")
		"transitiveImplementation"("com.mojang:datafixerupper:${project.properties["dfu_version"]}")
		"transitiveImplementation"("maven.modrinth:spasm:${project.properties["spasm_version"]}")

		// convenience stuff
		// adds some useful annotations for data classes. does not add any dependencies
		compileOnly("org.projectlombok:lombok:1.18.30")
		annotationProcessor("org.projectlombok:lombok:1.18.30")
		testCompileOnly("org.projectlombok:lombok:1.18.30")
		testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

		// adds some useful annotations for miscellaneous uses. does not add any dependencies, though people without the lib will be missing some useful context hints.
		implementation("org.jetbrains:annotations:23.0.0")

		// StAPI itself.
		// transitiveImplementation tells babric loom that you want this dependency to be pulled into other mod's development workspaces. Best used ONLY for required dependencies.
		modImplementation("net.modificationstation:StationAPI:${project.properties["stationapi_version"]}")

		// Extra mods.
		// https://github.com/calmilamsy/glass-config-api
		modImplementation("net.glasslauncher.mods:GlassConfigAPI:${project.properties["gcapi_version"]}")
		// https://github.com/calmilamsy/modmenu
		modImplementation("net.glasslauncher.mods:ModMenu:${project.properties["modmenu_version"]}")
		// https://github.com/Glass-Series/Always-More-Items
		modImplementation("net.glasslauncher.mods:AlwaysMoreItems:${project.properties["alwaysmoreitems_version"]}")
		// https://github.com/matthewperiut/retrocommands
		modImplementation("maven.modrinth:retrocommands:${project.properties["retrocommands_version"]}")
		// https://github.com/DanyGames2014/spawneggs
		modImplementation("maven.modrinth:spawn-eggs:${project.properties["spawneggs_version"]}")
		// https://github.com/paulevsGitch/BHCreative
		modImplementation ("com.github.paulevsGitch:BHCreative:${project.properties["bhcreative_version"]}")

		annotationProcessor("io.github.llamalad7:mixinextras-fabric:0.4.1")
	}

	loom {
		@Suppress("UnstableApiUsage") // Too bad, this is needed.
		mixin {
			useLegacyMixinAp.set(true)
		}
	}

	sourceSets {
		test {
			compileClasspath += sourceSets["main"].compileClasspath + sourceSets["main"].output
			runtimeClasspath += sourceSets["main"].runtimeClasspath + sourceSets["main"].output
		}
	}

	configure<ProcessResources>("processResources") {
		var ver = project.properties["mod_version"]

		if (project.properties["override_version"] != null) {
			ver = "${project.properties["mod_version"]}+${project.properties["override_version"]}"
		}

		inputs.property("version", ver)

		filesMatching("fabric.mod.json") {
			expand(mapOf("version" to ver))
		}
	}

	java {
		// Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
		// if it is present.
		// If you remove this line, sources will not be generated.
		withSourcesJar()
	}

	// Include license inside of the mod jar
	configure<Jar>("jar") {
		from("LICENSE") {
			rename { "${it}_${project.properties["archivesBaseName"]}" }
		}
	}

	// ensure that the encoding is set to UTF-8, no matter what the system default is
	// this fixes some edge cases with special characters not displaying correctly
	// see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
	tasks.withType<JavaCompile> {
		options.encoding = "UTF-8"
	}

	// Makes gradle shut up
	configure<JavaCompile>("compileJava") {
		options.compilerArgs.add("-XDignore.symbol.file")
		options.isFork = true
		options.forkOptions.executable = System.getProperty("java.home") + "/bin/javac" + (if (System.getProperty("os.name").startsWith("Windows")) ".exe" else "")
	}

	publishing {
		repositories {
			mavenLocal()
			if (project.hasProperty("my_maven_username")) {
				maven {
					url = URI("https://maven.example.com")
					credentials {
						username = "${project.properties["my_maven_username"]}"
						password = "${project.properties["my_maven_password"]}"
					}
				}
			}
		}

		publications {
			register("mavenJava", MavenPublication::class) {
				artifactId = project.properties["archives_base_name"] as String
				from(components["java"])
			}
		}
	}

}

// Subprojects will set these themselves
// Not neatly. - calm
// haha i stole stationapi's build.gradle
group = project.properties["maven_group"] as String
base.archivesName = project.properties["archives_base_name"] as String
version = project.properties["mod_version"] as String

subprojects {
	group = (project.properties["maven_group"] as String) + ".YuniBackport.${(project.properties["archivesBaseName"] as String)}"

	configurations {
		create("out") {
			isCanBeConsumed = true
			isCanBeResolved = false
		}
		create("dev") {
			isCanBeConsumed = true
			isCanBeResolved = false
		}
		create("test") {
			isCanBeConsumed = true
			isCanBeResolved = false
		}
	}

	tasks.register<Jar>("testJar") {
		from(sourceSets["test"].output)
		archiveClassifier.convention("test")
		archiveClassifier.set("test")
	}

	//Attach the subproject to the root project
	rootProject.dependencies {
		implementation(project(path = ":$name", configuration = "dev"))
		testImplementation(project(path = ":$name", configuration = "test"))
		include(project(path = ":$name", configuration = "out"))
	}
}

dependencies {
	include("net.jodah:typetools:${project.properties["typetools_version"]}")
	include("com.github.mineLdiver:UnsafeEvents:${project.properties["unsafeevents_version"]}")
	include("it.unimi.dsi:fastutil:${project.properties["fastutil_version"]}")
	include("com.github.ben-manes.caffeine:caffeine:${project.properties["caffeine_version"]}")
	include("com.mojang:datafixerupper:${project.properties["dfu_version"]}")
	include("maven.modrinth:spasm:${project.properties["spasm_version"]}")
}

// Makes java shut up
configure<JavaCompile>("compileTestJava") {
	options.compilerArgs.add("-XDignore.symbol.file")
	options.isFork = true
	options.forkOptions.executable = System.getProperty("java.home") + "/bin/javac" + (if (System.getProperty("os.name").startsWith("Windows")) ".exe" else "")
}

loom {
	runs {
		// If you want to make a testmod for your mod, right click on src, and create a new folder with the same name as source() below.
		// Intellij should give suggestions for testmod folders.
		register("testClient") {
			source("test")
			client()
			configurations.transitiveImplementation
		}
		register("testServer") {
			source("test")
			server()
			configurations.transitiveImplementation
		}
	}
}