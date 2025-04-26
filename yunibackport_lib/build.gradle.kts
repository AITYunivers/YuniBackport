import net.modificationstation.stationapi.gradle.SubprojectHelpers.getSubprojectVersion

base.archivesName.set("yunibackport_lib")
version = getSubprojectVersion(project, "1.0.0")

loom {
    accessWidenerPath = file("src/main/resources/yunibackport_lib.accesswidener")
}