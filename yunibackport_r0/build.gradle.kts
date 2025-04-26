import net.modificationstation.stationapi.gradle.SubprojectHelpers.getSubprojectVersion
import net.modificationstation.stationapi.gradle.SubprojectHelpers.addModuleDependencies

base.archivesName.set("yunibackport_r0")
version = getSubprojectVersion(project, "1.0.0")

addModuleDependencies(project,
    "yunibackport_lib"
)