package eu.feg.kmp.pos

fun getIconPath(iconFileName: String?, prefix: String? = ""): String {
    val normalized = iconFileName.takeUnless { it.isNullOrBlank() }
    return "https://cdn-cf.ifortuna.cz/" + if (prefix.isNullOrEmpty()) "128/$iconFileName" else "$prefix/128/$iconFileName"
}
